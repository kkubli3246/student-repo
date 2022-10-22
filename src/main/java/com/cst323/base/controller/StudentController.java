package com.cst323.base.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cst323.base.Cst323ListApplication;
import com.cst323.base.domain.Student;
import com.cst323.base.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	Logger log = LoggerFactory.getLogger(Cst323ListApplication.class);
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Student> listStudent = service.listAll();
		model.addAttribute("liststudent", listStudent);
		log.info("Number of Students in list =  {}", listStudent.size());
		return "index";
	}
	
	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("student", new Student());
		log.debug("Adding new Student");
		return "new";
	}
	
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student stu) {
		service.save(stu);
		log.debug("Student {} Saved at ID:{}",stu.getStudentname(), stu.getId());
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("new");
		log.debug("Student edited at Id:{}",id);
		Student std = service.get(id);
		mav.addObject("student",std);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name = "id") int id) {

		log.warn("Student {} getting deleted at ID:{}", service.get(id).getStudentname(), id);
		service.delete(id);
		return "redirect:/";
	}
	
}

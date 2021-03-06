package com.reena.projects.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.reena.projects.models.Project;
import com.reena.projects.models.Student;
import com.reena.projects.services.ProjectService;
import com.reena.projects.services.StudentService;

@Controller
public class HomeController {
	
	@Autowired 
	private StudentService sService;
	@Autowired
	private ProjectService pService;
	
	@GetMapping("/")
	public String dashBoard(Model model) {
		model.addAttribute("projects",pService.getAllProjects());
		return "/projects/dashboard.jsp";
	}
	
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student  ) {
		return "/students/new.jsp";
	}
	@PostMapping("/students/create")
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result ) {
		if(result.hasErrors()) {
			return "/students/new.jsp";
		}else {
			sService.createStudent(student);
			return "redirect:/";
		}
		
	}
	
//	Projects routes
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("project") Project project, Model model  ) {
		model.addAttribute("students", sService.getAllStudents());
		return "/projects/new.jsp";
	}	
	
	@PostMapping("/projects/create")
	public String creteProject(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model ) {
		if(result.hasErrors()) {
			model.addAttribute("students", sService.getAllStudents());
			return "/projects/new.jsp";
		}else {
			pService.createProject(project);
			return "redirect:/";
		}
		
	}
	
//	Edit 
	@GetMapping("/projects/{id}/edit")
	public String editProject(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editProject",pService.projectDetails(id));
		model.addAttribute("students", sService.getAllStudents());
		return "/projects/edit.jsp";
	}
//	Update
	@PutMapping("/projects/{id}/update")
	public String updateProject(@Valid @ModelAttribute("editProject") Project project, BindingResult result, Model model,@PathVariable("id") Long id ) {
		if(result.hasErrors()) {
			model.addAttribute("students", sService.getAllStudents());
			return "/projects/edit.jsp";
		}else {
			pService.updateProject(project);
			return "redirect:/";
		}
		
	}
	
//Delete
	@GetMapping("/projects/{id}/delete")
	public String deleteProject(@PathVariable("id") Long id) {
		pService.deleteProject(id);
		return "redirect:/";
	}
	
//	Details
	@GetMapping("/projects/{id}/details")
	public String details(@PathVariable("id") Long id, Model model) {
		model.addAttribute("project",pService.projectDetails(id));
		return "/projects/details.jsp";
	}
	
	
	
	
	
	
	
	

}

package com.greatlearning.studentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.studentapp.Student;
import com.greatlearning.studentapp.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listBooks(Model model) {
		List<Student> students = studentService.findAll();

		model.addAttribute("Student", students);

		return "list-students"; // /WEB-INF/views/list-students.jsp
	}

	@RequestMapping("/add")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("newStudent", true);
		model.addAttribute("Student", student);

		return "students-form";
	}

	@RequestMapping("/update")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Student student = studentService.findById(id);
		model.addAttribute("newStudent", false);
		model.addAttribute("Student", student);

		return "students-form";
	}

	@RequestMapping("/delete")
	public String showFormForUpdate(@RequestParam("id") int id) {
		studentService.deleteById(id);

		return "redirect:/students/list";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		Student student = null;

		if (id == 0) {
			student = new Student(name, department, country);
		} else {
			student = studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}
		System.out.println(student);
		studentService.save(student);

		// take the user automatically to the list of books after new book is saved
		return "redirect:/students/list";
	}

}

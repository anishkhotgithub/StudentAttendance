package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Attendance;
import com.example.model.Student;
import com.example.repository.StudentRepository;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentRepository studentRepository;

	
	  @RequestMapping("/studentdata") 
	  public String m1(ModelMap map ) 
	  {
		  map.addAttribute("student",studentRepository.findAll()); 
		  return"ExcelData"; 
	  }
	 
	@GetMapping("/delete/{id}")
	public String m4(@PathVariable("id") int id) {
		Student s = new Student();
		s.setId(id);
		studentRepository.delete(s);
		return "redirect:/student/studentdata/";
	}

	@PostMapping("/update")
	public String m7(@Valid @ModelAttribute("student") Student student, BindingResult br) {
		if (!br.hasErrors()) {
			studentRepository.save(student);
			return "redirect:/student/studentdata/";
		}

		return "ExcelData";
	}

	@GetMapping("/editStudent/{id}")
	public String m5(ModelMap map, @PathVariable("id") long id) {
		Student student = new Student();
		student = studentRepository.findById(id);
		map.addAttribute("s", student);
		return "editStudent";
	}

	@GetMapping("/addform")
	public String m3(ModelMap map) {
		map.addAttribute("student", new Student());
		return "add";
	}

	@PostMapping("/addform")
	public String m2(@Valid @ModelAttribute("student") Student student) {
		studentRepository.save(student);
		return "redirect:/student/studentdata/";
	}

	@RequestMapping("/Attendance")
	public String m8(ModelMap map) {
		map.addAttribute("student", studentRepository.findAll());
		return "Attendance";
	}

	@GetMapping("/{batch}")
	public String view3(Model m, @PathVariable("batch") String batch) 
	{
		List list = studentRepository.findByBatch(batch);
		if (!list.isEmpty()) 
		{
			m.addAttribute("student", list);
			m.addAttribute("attendance",new Attendance());
		} else {
			m.addAttribute("msg", "Sorry record not found!");
		}
		return "add";
	}

	@RequestMapping("/batchview")
	public String m9() {
		return "batchCard";
	}
}

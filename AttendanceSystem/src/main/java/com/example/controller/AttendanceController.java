package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Attendance;
import com.example.repository.AttendanceRepo;
import com.example.repository.StudentRepository;

@Controller
@RequestMapping("/attendance")
public class AttendanceController 
{
	@Autowired
	AttendanceRepo attendanceRepo;
	@Autowired
	StudentRepository studentrepo;
	@GetMapping("/{batch}")
	public String m3(ModelMap map,@PathVariable("batch") String batch)
	{
		map.addAttribute("student",studentrepo.findByBatch(batch));
		map.addAttribute("attendance",new Attendance());
		return "attendance";
	}
	
	@PostMapping("/add")
	public String m2(@Valid @ModelAttribute("attendance") Attendance attendance)
	{		
			attendanceRepo.save(attendance);
			return "redirect:/attendance/add";

	}
	
}

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Faculty;
import com.example.repository.FacultyRepository;
@Controller
@RequestMapping("/faculty")
public class FacultyController 
{
	@Autowired
	FacultyRepository facultyRepository;

	@RequestMapping("/")
	public String m1(ModelMap map)
	{
		map.addAttribute("faculties",facultyRepository.findAll());
		return "faculty";
	}
	
	@GetMapping("/add")
	public String m3(ModelMap map)
	{
		map.addAttribute("faculty",new Faculty());
		return "addfaculty";
	}
	
	@PostMapping("/add")
	public String m2(@Valid @ModelAttribute("faculty") Faculty faculty,BindingResult br)
	{
		if(!br.hasErrors())
		{
			faculty.setAuthority("faculty");
			faculty.setEnabled(true);
			faculty.setPassword(new BCryptPasswordEncoder().encode(faculty.getPassword()));
			facultyRepository.save(faculty);
			return "redirect:/faculty/";
		}

		return "addfaculty";
	}
	
	@PostMapping("/update")
	public String m7(@Valid  @ModelAttribute("faculty") Faculty faculty, BindingResult br)
	{
		if(!br.hasErrors())
		{
			facultyRepository.save(faculty);
			return "redirect:/faculty/";
		}
		
		return "addfaculty";
	}
	
	@GetMapping("/delete/{userid}")
	public String m4(@PathVariable("userid") int userid)
	{
		Faculty f=new Faculty();
		f.setUserid(userid);
		facultyRepository.delete(f);
		
		return "redirect:/faculty/";
	}
	
	@GetMapping("/edit/{userid}")
	public String m5(ModelMap map,@PathVariable("userid") int userid)
	{
		Faculty faculty=new Faculty();
		faculty=facultyRepository.findByUserid(userid);
		map.addAttribute("f",faculty);
		return "addfaculty";
	}
	
	@GetMapping("/login")
	public String m6()
	{
		return "login";
	}
	
	@GetMapping("/login-error")
	@ResponseBody
	public String m7()
	{
		return "<script>"
				+ "alert('Username or password is incorrect');"
				+ "window.location='/faculty/login';"
				+ "</script>";
	}
}

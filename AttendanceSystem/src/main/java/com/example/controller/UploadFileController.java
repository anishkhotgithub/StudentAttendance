package com.example.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.serviceimpl.FileServices;
@Controller
@RequestMapping("/import")
public class UploadFileController {
	
	@Autowired
	FileServices fileServices;
	
    @GetMapping("/")
    public String index() {
        return "uploadform";
    }
    
    @PostMapping("/")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) {
		try {
			fileServices.store(file);
			model.addAttribute("message", "File uploaded successfully!");
			 return "redirect:/student/studentdata/";
		} catch (Exception e) {
			model.addAttribute("message", "Fail!"+" -> uploaded filename: " + file.getOriginalFilename());
			 return "uploadform";
		}
       
    }
}
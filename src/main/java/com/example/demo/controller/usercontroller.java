package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.user;
import com.example.demo.services.userservice;


@Controller
@RequestMapping("/users")

public class usercontroller {

	
	@Autowired
	private userservice service;
	@GetMapping
	public String getalluser(Model m)
	{
		m.addAttribute("users", service.getalluser());
		return "users";
	}
	@GetMapping("/adduser")
	public String adduser(Model m)
	{
		m.addAttribute("user",new user());
		return "add-user";
	}
	@PostMapping("/saveuser")
	public String saveuser(@ModelAttribute("user") user u)
	{
		service.saveuser(u);
		return "redirect:/users";
	}
	@GetMapping("/deleteuser/{id}")
	public String deletebyid(@PathVariable("id") long id)
	{
		service.deleteuser(id);
		return "redirect:/users";
	}
	@PostMapping("/updateuser/{id}")
	public String updateuser(@ModelAttribute("user") user u, @PathVariable("id") long id )
	{
		u.setId(id);
		service.saveuser(u);
		return "redirect:/users";
	}
	
	@GetMapping("/edituser/{id}")
	public String editform(@PathVariable("id") long id, Model m)
	{
		m.addAttribute("user",service.getbyid(id));
		return "edit";
	}
	
	
}
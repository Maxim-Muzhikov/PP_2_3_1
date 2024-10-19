package org.muzhikov.controller;

import org.muzhikov.model.User;
import org.muzhikov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String getUsers(Model model) {
		model.addAttribute("users", userService.getUsers());
		model.addAttribute("user", new User()); // Для формы добавления
		return "index"; // Имя шаблона Thymeleaf
	}
	
	@PostMapping("/add")
	public String addUser(@ModelAttribute("user") User user) {
		userService.add(user);
		return "redirect:/users/";
	}
	
	@GetMapping("/edit")
	public String editUser(@RequestParam("id") long id, Model model) {
		model.addAttribute("user", userService.get(id));
		return "edit_user"; // Имя шаблона для редактирования
	}
	
	@PostMapping("/update")
	public String updateUser(@ModelAttribute("user") User user) {
		userService.update(user);
		return "redirect:/users/";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") long id) {
		userService.delete(id); // Реализуйте метод delete в UserService
		return "redirect:/users/";
	}
}
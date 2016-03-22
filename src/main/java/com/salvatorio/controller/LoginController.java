package com.salvatorio.controller;

import com.salvatorio.model.Book;
import com.salvatorio.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salvatorio.model.login.Users;

import java.util.Map;

@Controller
public class LoginController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/login")
	public String getLoginForm(@ModelAttribute Users users,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		String message = "";
		if (error != null) {
			message = "Incorrect username or password !";
		} else if (logout != null) {
			message = "Logout successful !";
		}
		model.addAttribute("message", message);
		return "login";
	}

	@RequestMapping("/admin*")
	public String getAdminProfile(Map<String, Object> map) {
			map.put("book", new Book());
			map.put("bookList", bookService.listBooks());
		return "adminPage";
	}

	@RequestMapping("/error403")
	public String getAccessDenied(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String username = "";
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			username = userDetail.getUsername();
		} else {
			username = "guest";
		}

		model.addAttribute("username", username);
		return "error403";
	}

}

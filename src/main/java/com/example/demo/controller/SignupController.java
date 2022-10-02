package com.example.demo.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.application.service.UserApplicationService;
import com.example.demo.form.GroupOrder;
import com.example.demo.form.SignupForm;

@Controller
@RequestMapping("/user")
public class SignupController {
	@Autowired
	private UserApplicationService userApplicationService;
	
	//登録画面を表示
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm signupForm) {
		Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
		model.addAttribute("genderMap", genderMap);
		return "user/signup";
	}
	
	//ユーザ登録処理
	@PostMapping("/signup")
	public String postSignup(Model model, Locale locale, 
			@ModelAttribute @Validated(GroupOrder.class) SignupForm signupForm, 
			BindingResult bindingResult) {
		//入力チェック
		if(bindingResult.hasErrors()) {
			return getSignup(model, locale, signupForm);
		}
		//ログイン画面にリダイレクト
		return "redirect:/login";
	}
}

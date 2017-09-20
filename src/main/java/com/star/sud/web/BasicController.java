/*package com.star.sud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.star.sud.form.UserBasicInform;

@Controller
public class BasicController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getBasicScreen(Model model) {

		UserBasicInform userBasicInformForm = new UserBasicInform();

		model.addAttribute("registration", userBasicInformForm);

		return "registarion/registarion";
	}

}
*/
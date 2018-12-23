package com.star.sud.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.star.sud.StarUrl;
import com.star.sud.form.UserBasicInform;
import com.star.sud.framework.model.notification.StarMailDetail;
import com.star.sud.message.StarMessage;
import com.star.sud.message.StarMessageCode;
import com.star.sud.message.StarMessageType;
import com.star.sud.sectionkey.StarConstants;
import com.star.sud.security.model.StarUser;

@Controller
public class StarRegistrationController extends StarAbstractController {

	@RequestMapping(value = StarUrl.REGISTRATION, method = RequestMethod.GET)
	public String registartionPage(Model model) {

		UserBasicInform userBasicInformForm = new UserBasicInform();

		model.addAttribute("registration", userBasicInformForm);

		return "registarion/registarion";
	}

	@RequestMapping(value = StarUrl.NEW_REGISTRATION, method = RequestMethod.POST)
	public String newUserRegistrn(Model model, @ModelAttribute("registration") UserBasicInform registration,
			RedirectAttributes redirectAttributes) {

		StarUser user = null;
		StarMessage starMessage = null;

		try {

			if (null == registration)
				throw new Exception("Registration param null or empty");

			if (null == registration.getUserGeneralDetail())
				throw new Exception("General Details param null or empty");

			user = starSecurityService.findSysUserName(registration.getUserGeneralDetail().getUserName());
			if (user != null)
				throw new Exception("User Already Exist. Please try with different User Name");

			user = userAcccountService.storeUserInformation(user, registration, Boolean.TRUE);

			model.addAttribute("registration", registration);

			if (user != null) {

				StarMailDetail mailDetail = starUtilService.createEntityObj(StarMailDetail.class.getName(),
						StarMailDetail.class);
				mailDetail.setStarUser(user);
				mailDetail.setStatus("NEW");
				mailDetail.setDateScheduled(new Date());
				starUtilService.save(mailDetail);

				starMessage = new StarMessage().code(StarMessageCode.INFORMATION)
						.message("Your Account is successfully created !!").type(StarMessageType.SUCCESS);

			} else {
				starMessage = new StarMessage().code(StarMessageCode.INFORMATION).message("Error In Account creation")
						.type(StarMessageType.ERROR);

			}

			redirectAttributes.addFlashAttribute(STAR_MESSAGE, starMessage);

			return StarConstants.REDIRECT_URL;

		} catch (Exception e) {
			starMessage = new StarMessage().code(StarMessageCode.INFORMATION).message(e.getMessage())
					.type(StarMessageType.ERROR);
		}
		model.addAttribute("registration", registration);

		return "registarion/registarion";

	}

}

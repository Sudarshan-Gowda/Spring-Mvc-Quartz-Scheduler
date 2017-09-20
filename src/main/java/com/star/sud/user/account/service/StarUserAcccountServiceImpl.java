package com.star.sud.user.account.service;
/*created by Sudarshan on 19-09-17*/
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.star.sud.StarDateUtil;
import com.star.sud.form.UserBasicInform;
import com.star.sud.framework.service.StarUtilService;
import com.star.sud.security.model.StarUser;

@Service("starUserAcccountService")
public class StarUserAcccountServiceImpl implements StarUserAcccountService {

	@Resource(name = "starUtilService")
	protected StarUtilService starUtilService;

	@Override
	public StarUser storeUserInformation(StarUser user, UserBasicInform userBasicInform, Boolean registrn) {

		if (registrn) {
			user = starUtilService.createEntityObj(StarUser.class.getName(), StarUser.class);
			user.setUserName(userBasicInform.getUserGeneralDetail().getUserName());
			user.setPassword(userBasicInform.getUserGeneralDetail().getPassword());
			user.setIsEnabled(Boolean.TRUE);
			user.getStarUserDetails().setFirstName(userBasicInform.getUserGeneralDetail().getFirstName());
			user.getStarUserDetails().setLastName(userBasicInform.getUserGeneralDetail().getLastName());
			user.getStarUserDetails().setEmail(userBasicInform.getUserGeneralDetail().getEmail());
		}

		if (userBasicInform.getUserGeneralDetail().getContactNum() != null
				& !userBasicInform.getUserGeneralDetail().getContactNum().isEmpty()) {
			user.getStarUserDetails().setContactNum(userBasicInform.getUserGeneralDetail().getContactNum().toString());

		}
		if (userBasicInform.getUserGeneralDetail().getDob() != null
				&& !userBasicInform.getUserGeneralDetail().getDob().isEmpty()) {
			user.getStarUserDetails().setDob(
					StarDateUtil.getDateFromString(userBasicInform.getUserGeneralDetail().getDob(), Boolean.TRUE));
		}
		if (userBasicInform.getUserGeneralDetail().getGender() != null
				&& !userBasicInform.getUserGeneralDetail().getGender().isEmpty()) {

			user.getStarUserDetails().setGender(userBasicInform.getUserGeneralDetail().getGender());
		}

		user.getStarUserDetails().setUser(user);

		try {

			user = (StarUser) starUtilService.save(user);

			return user;

		} catch (Exception e) {

			return null;

		}

	}
}

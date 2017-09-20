package com.star.sud.login.service;

/*@Author Sudarshan*/
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.star.sud.security.model.StarUser;
import com.star.sud.security.model.StarUserRole;
import com.star.sud.security.service.StarSecurityService;

@Service("starUserDetailsService")
public class StarUserDetailsService implements UserDetailsService {

	@Resource(name = "starSecurityService")
	protected StarSecurityService starSecurityService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		StarUser user = starSecurityService.findSysUserName(username);

		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
		return buildUserForAuthentication(user, authorities);

	}

	private User buildUserForAuthentication(StarUser user, List<GrantedAuthority> authorities) {

		return new User(user.getUserName(), user.getPassword(), true, true, true, true, authorities);

	}

	private List<GrantedAuthority> buildUserAuthority(List<StarUserRole> userRoles) {

		List<GrantedAuthority> setAuths = new ArrayList<GrantedAuthority>();

		for (StarUserRole userRole : userRoles) {

			setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;

	}

}

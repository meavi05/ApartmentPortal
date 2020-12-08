/**
 * 
 */
package com.apartment.apartmentPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apartment.apartmentPortal.dao.ApplicationPortalRepository;
import com.apartment.apartmentPortal.dto.MyUserDetails;
import com.apartment.apartmentPortal.dto.UserDTO;

/**
 * @author avi08
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	ApplicationPortalRepository applicationPortalRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserDTO userDTO = applicationPortalRepository.getUserData(userName);
		if(null == userDTO)
			throw new UsernameNotFoundException("No user return for the given user name");
		return new MyUserDetails(userDTO);
	}
	
}

package com.jpetstore.oauth2.domain.service.user;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jpetstore.oauth2.domain.model.Account;
import com.jpetstore.oauth2.domain.service.account.AccountService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Inject
	protected AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountService.getAccount(username);
		if (account == null) {
			throw new UsernameNotFoundException(username + " is not found.");
		}
		return new com.jpetstore.oauth2.domain.model.UserDetails(account);
	}

}

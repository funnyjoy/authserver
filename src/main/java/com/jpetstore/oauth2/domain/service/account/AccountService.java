package com.jpetstore.oauth2.domain.service.account;

import com.jpetstore.oauth2.domain.model.Account;

public interface AccountService {

	Account getAccount(String username);

	Account getAccount(String username, String password);

}

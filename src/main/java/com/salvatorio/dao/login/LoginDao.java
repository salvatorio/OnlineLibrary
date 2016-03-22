package com.salvatorio.dao.login;

import com.salvatorio.model.login.Users;

public interface LoginDao {
	Users findByUserName(String username);
}

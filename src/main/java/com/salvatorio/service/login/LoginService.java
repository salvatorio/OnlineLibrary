package com.salvatorio.service.login;

import com.salvatorio.model.login.Users;

public interface LoginService {
    public Users findByUserName(String username);
}

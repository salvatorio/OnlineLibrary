package com.salvatorio.service.login;

import com.salvatorio.dao.login.LoginDao;
import com.salvatorio.model.login.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    @Transactional
    public Users findByUserName(String username) {
        return loginDao.findByUserName(username);
    }
}

package com.pj.Service;

import com.pj.mapper.LoginMapper;
import com.pj.pojo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserData findAll() {
        return loginMapper.findAll();
    }

    @Override
    public UserData findUserNameAndPassword(String username, String password) {
        return loginMapper.findUserNameAndPassword(username, password);
    }
}

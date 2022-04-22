package com.pj.Service;

import com.pj.pojo.UserData;

public interface LoginService {
    UserData findAll();

    UserData findUserNameAndPassword(String username, String password);
}

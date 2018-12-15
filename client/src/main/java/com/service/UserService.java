package com.service;

import com.model.User;
import org.oasisopen.sca.annotation.Remotable;

@Remotable
public interface UserService {

    long add(User user);

    User showOne(String name);

    User showByPhone(String phone);

    User showByPostbox(String postbox);

    void updateByName(User user);
}

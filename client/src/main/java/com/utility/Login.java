package com.utility;


import com.model.User;

import com.service.SwitchService;
import com.service.UserService;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Component
public class Login {

//@Autowired
//UserService userService;
    private UserService userService=(UserService) SwitchService.switchBean().getBean("userService");

    public String login(User user1, DESUtil desUtil, HttpServletResponse response) throws Exception {
        Logger logger = Logger.getLogger(Login.class);
        String view;
        logger.info(user1);
        User user2 = userService.showOne(user1.getUsername());
        logger.info(user2);

        if (user2 == null) {
            view = "notName";
        } else if (user2.getPassword().equals(MD5str.getMD5Str(user1.getUsername() + user1.getPassword()))) {
            view = "loggedIn";
            //对Cookie进行加密
            long time = System.currentTimeMillis();
            user2.setUpdate_time(time);
            String str1 = desUtil.encryptFromLong(time);
            String str2 = desUtil.encryptFromLong(user2.getId());
            String token = desUtil.encrypt(str1 + "|" + user2.getUsername() + "|" + str2);
            Cookie nameCookie = new Cookie("name", user2.getUsername());
            Cookie pictureCookie = new Cookie("picture", user2.getPicture());
            logger.info("图片cookie:" + user2.getPicture());
            Cookie tokenCookie = new Cookie("token", token);
            nameCookie.setMaxAge(30 * 60);
            nameCookie.setPath("/");
            tokenCookie.setMaxAge(30 * 60);
            tokenCookie.setPath("/");
            response.addCookie(pictureCookie);
            response.addCookie(nameCookie);
            response.addCookie(tokenCookie);

        } else {
            view = "passWrong";
        }
        return view;
    }
}

package com.tht.controller;

import com.tht.entity.User;
import com.tht.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author quackmyth
 * @date 2023/9/15 0015 17:28
 */
@RestController
@RequestMapping
public class UserController {

    @GetMapping
    public R<User> getUser() {
        return R.ok(new User(1L, "Jack", 16, "man", 123456, "jack@email.com", "LianJiaTun"));
    }

}

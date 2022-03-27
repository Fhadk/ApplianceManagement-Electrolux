package com.electrolux.user.controller;

import com.electrolux.user.entity.User;
import com.electrolux.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        log.info("saveUser: UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long userId) {
        log.info("getUserDetails: UserController");
        return userService.getUser(userId);
    }

//    @GetMapping("/{id}")
//    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
//        log.info("getUserWithDepartment: UserController");
//        return userService.getUserWithDepartment(userId);
//    }


}

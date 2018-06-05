package com.hoho.springkotlin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController{
    @Autowired
    lateinit var userService : UserServiceImpl

    @GetMapping("/user/{userId}")
    fun queryUserById(@PathVariable userId: String): List<UserInfo>{
        val userInfo = UserInfo(userId = userId.toLong(), username = null, password = null)
        return userService.queryUserList(userInfo)
    }

    @GetMapping("/user")
    fun queryUserById(): List<UserInfo>{
        val userInfo = UserInfo(null,null,null)
        return userService.queryUserList(userInfo)
    }

    @PostMapping("/user")
    fun insertUser(@RequestParam username: String, @RequestParam password : String): List<UserInfo>{
        val userInfo = UserInfo(null,username = username, password = password)
        var userList: List<UserInfo> = ArrayList()
        userService.insertUser(userInfo)
        userList = userService.queryUserList(null)
        return userList
    }
}
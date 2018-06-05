package com.hoho.springkotlin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : IUserService{
    @Autowired
    lateinit var userMapper : UserMapper

    override fun queryUserList(userInfo: UserInfo?): List<UserInfo> {
        if(userInfo != null)
            return userMapper.queryUserList(userInfo)

        else{
            var userInfoNull:UserInfo = UserInfo(null,null,null)
            return userMapper.queryUserList(userInfoNull)
        }
    }

    override fun insertUser(userInfo: UserInfo): Int {
        return userMapper.insertUser(userInfo)
    }

}
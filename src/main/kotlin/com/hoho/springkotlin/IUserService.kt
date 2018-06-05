package com.hoho.springkotlin

interface IUserService{
    fun queryUserList(userInfo: UserInfo?): List<UserInfo>
    fun insertUser(userInfo: UserInfo): Int
}
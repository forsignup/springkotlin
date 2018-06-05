package com.hoho.springkotlin

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {
    @Select("""<script>
        select USER_ID, USERNAME, PASSWORD, DELETED from USER_T where 1 = 1
        <if test = 'username != null'>AND USERNAME like #{username}%</if>
        <if test = 'userId != null'>AND USER_ID = #{userId}</if>
        <if test = 'deleted != null'>AND DELETED = #{deleted}</if>
        </script>""")
    fun queryUserList(userInfo: UserInfo): List<UserInfo>

    @Insert("""
        insert into USER_T (USERNAME, PASSWORD, DELETED)
        values(#{username}, #{password}, #{deleted})
    """)
    fun insertUser(userInfo: UserInfo): Int
}
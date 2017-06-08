package com.mybatis.mapper;

import java.util.List;

import com.mybatis.pojo.User;
import com.mybatis.pojo.vo.UserQueryVo;
import com.mybatis.search.UserCustom;

public interface UserMapper {
	/** 根据ID查询用户信息 */
    public User findUserById(int id);

    /** 根据用户名称模糊查询用户信息 */
    public List<User> findUserByName(String username);

    /** 添加用户 */
    public void insertUser(User user);

    /** 根据ID删除用户 */
    public void deleteUser(Integer id);

    /** 根据ID更新用户 */
    public void updateUser(User user);
    
    public List<UserQueryVo> findUserList(UserCustom userCustom);
}

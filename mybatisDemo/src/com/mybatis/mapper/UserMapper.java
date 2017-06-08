package com.mybatis.mapper;

import java.util.List;

import com.mybatis.pojo.User;
import com.mybatis.pojo.vo.UserQueryVo;
import com.mybatis.search.UserCustom;

public interface UserMapper {
	/** ����ID��ѯ�û���Ϣ */
    public User findUserById(int id);

    /** �����û�����ģ����ѯ�û���Ϣ */
    public List<User> findUserByName(String username);

    /** ����û� */
    public void insertUser(User user);

    /** ����IDɾ���û� */
    public void deleteUser(Integer id);

    /** ����ID�����û� */
    public void updateUser(User user);
    
    public List<UserQueryVo> findUserList(UserCustom userCustom);
}

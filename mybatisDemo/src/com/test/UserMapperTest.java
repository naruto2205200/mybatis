package com.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import com.mybatis.pojo.vo.UserQueryVo;
import com.mybatis.search.UserCustom;

public class UserMapperTest {
	 private SqlSessionFactory sqlSessionFactory;

	    // �˷�������ִ��findUserByIdTest֮ǰִ��
	    @Before
	    public void setUp() throws Exception {
	        String resource = "SqlMapConfig.xml";
	        InputStream inputStream = Resources.getResourceAsStream(resource);
	        // ����SqlSessionFcatory
	        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    }
	    @Test
	    public void testFindUserById() {
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        // ����Usermapper����mybatis�Զ�����mapper�������
	        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	        User user = mapper.findUserById(1);
	        System.out.println(user);
	        sqlSession.close();
	    }

	    @Test
	    public void testFindUserByName() {
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        // ����Usermapper����mybatis�Զ�����mapper�������
	        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	        List<User> list = mapper.findUserByName("С");
	        System.out.println(list);
	        sqlSession.close();
	    }

	    @Test
	    public void testDeleteUser() {
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        // ����Usermapper����mybatis�Զ�����mapper�������
	        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	        mapper.deleteUser(6);
	        sqlSession.commit();
	        sqlSession.close();
	    }
	    
	    @Test
	    public void testInsertUser() {
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        // ����Usermapper����mybatis�Զ�����mapper�������
	        User user = new User();
	        user.setUsername("�߱�");
	        user.setSex("1");
	        user.setAddress("�ɹ����ղ���");
	        user.setBirthday(new Date());
	        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	        mapper.insertUser(user);
	        sqlSession.commit();
	        sqlSession.close();
	    }
	    
	    @Test
	    public void testUpdateUser() {
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        // ����Usermapper����mybatis�Զ�����mapper�������
	        User user = new User();
	        user.setId(11);//��������Id
	        user.setUsername("������߱�");
	        user.setSex("1");
	        user.setAddress("�ɹ����ղ���");
	        user.setBirthday(new Date());
	        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	        mapper.updateUser(user);
	        sqlSession.commit();
	        sqlSession.close();
	    }
	    
	    @Test
	    public void testFnidUserList(){
	    	SqlSession sqlSession = sqlSessionFactory.openSession();
	    	UserCustom userCustom = new UserCustom();
	    	UserQueryVo userQueryVo = new UserQueryVo();
	    	userQueryVo.setSex("2");
	    	userQueryVo.setUsername("С");
	    	userCustom.setUserQueryVo(userQueryVo);
	    	UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	    	List<UserQueryVo> list=mapper.findUserList(userCustom);
	    	System.out.println(list);
	        sqlSession.commit();
	        sqlSession.close();
	    }
}

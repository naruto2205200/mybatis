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

	    // 此方法是在执行findUserByIdTest之前执行
	    @Before
	    public void setUp() throws Exception {
	        String resource = "SqlMapConfig.xml";
	        InputStream inputStream = Resources.getResourceAsStream(resource);
	        // 创建SqlSessionFcatory
	        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    }
	    @Test
	    public void testFindUserById() {
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
	        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	        User user = mapper.findUserById(1);
	        System.out.println(user);
	        sqlSession.close();
	    }

	    @Test
	    public void testFindUserByName() {
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
	        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	        List<User> list = mapper.findUserByName("小");
	        System.out.println(list);
	        sqlSession.close();
	    }

	    @Test
	    public void testDeleteUser() {
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
	        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	        mapper.deleteUser(6);
	        sqlSession.commit();
	        sqlSession.close();
	    }
	    
	    @Test
	    public void testInsertUser() {
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
	        User user = new User();
	        user.setUsername("者别");
	        user.setSex("1");
	        user.setAddress("蒙古乞颜部落");
	        user.setBirthday(new Date());
	        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	        mapper.insertUser(user);
	        sqlSession.commit();
	        sqlSession.close();
	    }
	    
	    @Test
	    public void testUpdateUser() {
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
	        User user = new User();
	        user.setId(11);//必须设置Id
	        user.setUsername("神箭手者别");
	        user.setSex("1");
	        user.setAddress("蒙古乞颜部落");
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
	    	userQueryVo.setUsername("小");
	    	userCustom.setUserQueryVo(userQueryVo);
	    	UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	    	List<UserQueryVo> list=mapper.findUserList(userCustom);
	    	System.out.println(list);
	        sqlSession.commit();
	        sqlSession.close();
	    }
}

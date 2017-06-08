package com.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.mapper.OrdersVoMapper;
import com.mybatis.pojo.OrderDetail;
import com.mybatis.pojo.Orders;
import com.mybatis.pojo.User;
import com.mybatis.pojo.vo.OrdersVo;

public class OrdersVoMapperTest {
	private SqlSessionFactory sqlSessionFactory;

    // �˷�������ִ��findUserByIdTest֮ǰִ��
    @Before
    public void setUp() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // ����SqlSessionFcatory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    // ��ѯ������������ѯ�û���Ϣ��ʹ��resultTypeʵ�ֵĲ���
    @Test
    public void TestFindOrdersUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // �����������
        OrdersVoMapper oc = sqlSession.getMapper(OrdersVoMapper.class);
        // ����mapper�ķ���
        List<OrdersVo> list = oc.findOrdersUser();
        System.out.println(list);
        sqlSession.close();
    }

    // ��ѯ������������ѯ�û���Ϣ��ʹ��resultMapʵ�ֵĲ���
    @Test
    public void TestFindOrdersUserResultMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // �����������
        OrdersVoMapper oc = sqlSession.getMapper(OrdersVoMapper.class);
        // ����mapper�ķ���
        List<Orders> list = oc.findOrdersUserResultMap();
        System.out.println(list);
        sqlSession.close();

    }
    
 // ��ѯ�����������û����Լ�������ϸ�Ĳ���
    @Test
    public void TestFindOrdersAndOrderDetailResultMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // �����������
        OrdersVoMapper oc = sqlSession.getMapper(OrdersVoMapper.class);
        // ����mapper�ķ���
        List<OrderDetail> list = oc.findOrdersAndOrderDetailResultMap();
        System.out.println(list);
        sqlSession.close();  
    }
 // ��ѯ�û����û��������Ʒ����Ϣ
    @Test
    public void TestFindUserAndItemsResultMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // �����������
        OrdersVoMapper oc = sqlSession.getMapper(OrdersVoMapper.class);
        // ����mapper�ķ���
        List<User> list = oc.findUserAndItemsResultMap();
        System.out.println(list);
        sqlSession.close();
    }
}

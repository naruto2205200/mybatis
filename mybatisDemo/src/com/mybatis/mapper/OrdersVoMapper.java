package com.mybatis.mapper;

import java.util.List;

import com.mybatis.pojo.OrderDetail;
import com.mybatis.pojo.Orders;
import com.mybatis.pojo.User;
import com.mybatis.pojo.vo.OrdersVo;

public interface OrdersVoMapper {
	/** ��ѯ������������ѯ�û���Ϣ */
    public List<OrdersVo> findOrdersUser();
    /** ��ѯ����������ѯ�û���Ϣ��ʹ��reslutMapʵ��*/
    public List<Orders> findOrdersUserResultMap();
    /**��ѯ�����������û����Լ�������ϸ*/
    public List<OrderDetail> findOrdersAndOrderDetailResultMap();
    /** ��ѯ�û����û����������Ʒ��Ϣ */
    public List<User> findUserAndItemsResultMap();
}

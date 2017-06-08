package com.mybatis.mapper;

import java.util.List;

import com.mybatis.pojo.OrderDetail;
import com.mybatis.pojo.Orders;
import com.mybatis.pojo.User;
import com.mybatis.pojo.vo.OrdersVo;

public interface OrdersVoMapper {
	/** 查询订单，关联查询用户信息 */
    public List<OrdersVo> findOrdersUser();
    /** 查询订单关联查询用户信息，使用reslutMap实现*/
    public List<Orders> findOrdersUserResultMap();
    /**查询订单（关联用户）以及订单明细*/
    public List<OrderDetail> findOrdersAndOrderDetailResultMap();
    /** 查询用户及用户所购买的商品信息 */
    public List<User> findUserAndItemsResultMap();
}

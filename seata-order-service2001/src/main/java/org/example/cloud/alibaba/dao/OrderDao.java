package org.example.cloud.alibaba.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.example.cloud.alibaba.domain.Order;

/**
 * @author wenqifeng
 * @date 2021/6/8 23:09:35
 */
@Mapper
public interface OrderDao {
    /**
     * 新建订单
     *
     * @param order 订单对象
     */
    @Insert(" INSERT INTO t_order(user_id, product_id, count, money, status) " +
            " VALUES (#{userId},#{productId},#{count},#{money},0) ")
    void create(Order order);


    /**
     * 修改订单状态 0->1
     *
     * @param userId 用户id
     * @param status 订单状态
     *               //
     */
    @Update(" UPDATE t_order " +
            " SET status=1 " +
            " WHERE user_id = #{userId} " +
            "  AND status = #{status} ")
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}

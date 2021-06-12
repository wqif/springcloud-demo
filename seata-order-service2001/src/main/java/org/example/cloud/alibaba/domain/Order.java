package org.example.cloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author wenqifeng
 * @date 2021/6/7 23:51:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 下单数量
     */
    private Integer count;

    /**
     * 总金额
     */
    private BigDecimal money;

    /**
     * 订单状态 0：创建中 1：已完结
     */
    private Integer status;
}

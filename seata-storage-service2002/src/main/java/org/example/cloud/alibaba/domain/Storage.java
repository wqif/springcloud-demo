package org.example.cloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wenqifeng
 * @date 2021/6/11 22:23:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    /**
     * id
     */
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}

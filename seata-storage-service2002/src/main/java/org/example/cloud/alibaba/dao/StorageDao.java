package org.example.cloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author wenqifeng
 * @date 2021/6/11 22:11:42
 */
@Mapper
public interface StorageDao {
    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     扣减数量
     */
    @Update(" UPDATE t_storage " +
            " SET used=used + #{count}, " +
            "     residue=residue - #{count} " +
            " WHERE product_id = #{productId} ")
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}

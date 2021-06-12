package org.example.cloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

/**
 * @author wenqifeng
 * @date 2021/6/11 22:41:04
 */
@Mapper
public interface AccountDao {
    /**
     * 余额扣减
     *
     * @param userId 账户id
     * @param money  扣减数额
     */
    @Update(" UPDATE t_account " +
            " SET used=used + #{money}, " +
            "     residue=residue - #{money} " +
            " WHERE user_id = #{userId} ")
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}

package com.waterspringer.security.mapper;

import com.waterspringer.security.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Robert
 * @since 2023-06-26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

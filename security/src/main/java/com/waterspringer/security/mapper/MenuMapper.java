package com.waterspringer.security.mapper;

import com.waterspringer.security.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author Robert
 * @since 2023-07-17
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

     List<String> selectPermsByUserId(Long id);
}

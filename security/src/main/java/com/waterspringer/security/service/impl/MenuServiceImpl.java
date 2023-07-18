package com.waterspringer.security.service.impl;

import com.waterspringer.security.entity.Menu;
import com.waterspringer.security.mapper.MenuMapper;
import com.waterspringer.security.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author Robert
 * @since 2023-07-17
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService
{

}

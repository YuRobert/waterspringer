package com.waterspringer.security.service.impl;

import com.waterspringer.security.entity.User;
import com.waterspringer.security.mapper.UserMapper;
import com.waterspringer.security.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Robert
 * @since 2023-06-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

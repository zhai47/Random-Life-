package com.example.refreshmylife.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.refreshmylife.mapper.UserMapper;
import com.example.refreshmylife.model.User;
import com.example.refreshmylife.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserByUserID(String userId) {
        LambdaQueryWrapper lambdaQueryWrapper = new QueryWrapper<User>().lambda().eq(User::getUserId, userId);
        return userMapper.selectOne(lambdaQueryWrapper);
    }
}

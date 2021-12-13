package com.example.refreshmylife.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.refreshmylife.enums.StatusCode;
import com.example.refreshmylife.mapper.PerfumeMapper;
import com.example.refreshmylife.model.Perfume;
import com.example.refreshmylife.service.PerfumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class PerfumeServiceImpl implements PerfumeService {
    @Autowired
    PerfumeMapper perfumeMapper;

    @Override
    public String generateDailyPerfume() {
        LambdaQueryWrapper queryWrapper = new QueryWrapper<Perfume>().lambda().eq(Perfume::getState, StatusCode.START.getCode());
        List<Perfume> perfumeList = perfumeMapper.selectList(queryWrapper);

        Random r = new Random();

        return perfumeList.get(r.nextInt(perfumeList.size())).getPerfumeName();
    }
}

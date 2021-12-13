package com.example.refreshmylife.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.refreshmylife.mapper.DailyListMapper;
import com.example.refreshmylife.model.DailyList;
import com.example.refreshmylife.model.User;
import com.example.refreshmylife.service.DailyListService;
import com.example.refreshmylife.service.MailService;
import com.example.refreshmylife.service.PerfumeService;
import com.example.refreshmylife.service.UserService;
import com.example.refreshmylife.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;


@Service
@Slf4j
public class DailyListServiceImpl implements DailyListService {

    @Autowired
    DailyListMapper dailyListMapper;

    @Autowired
    PerfumeService perfumeService;

    @Autowired
    MailService mailService;

    @Autowired
    private UserService userService;

    /**
     * 检查每日清单是否生成
     * @return 生成为true，没生成为false;
     */
    @Override
    public boolean checkDailyListIsGenerate() {

        DailyList dailyList = new LambdaQueryChainWrapper<>(dailyListMapper)
                .eq(DailyList::getDate, DateUtils.currentDate())
                .one();

        return dailyList != null;
    }

    @Override
    public String generateDailyList(String userId) {
        if (checkDailyListIsGenerate()) {
            return "今日清单已生成，请检查邮箱";
        }
        String dailyList = "今日清单: \n";
        dailyList = dailyList + perfumeService.generateDailyPerfume().toString() + "\n";
        String subject = "Daily List: " + DateUtils.currentDate().toString();
//
        User user  = userService.findUserByUserID(userId);
        mailService.addTextMail(user.getEmail(), subject, dailyList);
        DailyList dailyList1 = new DailyList();
        dailyList1.setDate(DateUtils.currentDate());
        dailyListMapper.insert(dailyList1);


        return dailyList;
    }


}

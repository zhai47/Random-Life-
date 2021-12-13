package com.example.refreshmylife;

import com.example.refreshmylife.mapper.DailyListMapper;
import com.example.refreshmylife.mapper.MailMapper;
import com.example.refreshmylife.mapper.MusicMapper;
import com.example.refreshmylife.model.DailyList;
import com.example.refreshmylife.model.Mail;
import com.example.refreshmylife.service.DailyListService;
import com.example.refreshmylife.service.PerfumeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class RefreshMyLifeApplicationTests {
    @Autowired
    MusicMapper musicMapper;
    @Autowired
    DailyListMapper dailyListMapper;
    @Autowired
    PerfumeService perfumeService;
    @Autowired
    DailyListService dailyListService;

    @Autowired
    MailMapper mailMapper;
    @Test
    void contextLoads() {
        Mail mail = new Mail();
        mail.setText("1231231");
        mailMapper.insert(mail);

    }

}

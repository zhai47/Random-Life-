package com.example.refreshmylife.controller;

import com.example.refreshmylife.service.DailyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refresh-life/")
public class LifeController {
    @Autowired
    DailyListService dailyListService;

    @GetMapping("dailyList")
    public String dailyList(@RequestParam String userId) {
        return dailyListService.generateDailyList(userId);
    }
}

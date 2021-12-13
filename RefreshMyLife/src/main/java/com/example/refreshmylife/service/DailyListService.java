package com.example.refreshmylife.service;

public interface DailyListService {
    boolean checkDailyListIsGenerate();
    String generateDailyList(String userId);
}

package com.example.refreshmylife.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {
    START(1, "正常"),
    close(0, "删除");

    private  int code;
    private  String message;
}

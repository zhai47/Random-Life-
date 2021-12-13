package com.example.refreshmylife.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "daily_list")
public class DailyList {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Date createTime;

    public Date Date;
}

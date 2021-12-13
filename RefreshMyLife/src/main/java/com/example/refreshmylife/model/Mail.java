package com.example.refreshmylife.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "mail")
public class Mail {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "`from`")
    private String from;

    @TableField(value = "`to`")
    private String to;

    @TableField(value = "subject")
    private String subject;

    @TableField(value = "text")
    private String text;

    private Date createDate;
}

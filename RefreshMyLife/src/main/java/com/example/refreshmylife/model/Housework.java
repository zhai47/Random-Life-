package com.example.refreshmylife.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "housework")
public class Housework {
    @TableId(value = "id")
    private Integer id;

    private String houseworkName;

    private Integer state;
}

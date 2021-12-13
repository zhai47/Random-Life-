package com.example.refreshmylife.model;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "music")
public class Music {
    @TableId(value = "id")
    private Integer id;

    private String choiceName;

    private Integer parents;

    private Integer state;
}

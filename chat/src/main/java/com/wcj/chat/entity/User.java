package com.wcj.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 15:10
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;

    private String username;

    private String password;


}

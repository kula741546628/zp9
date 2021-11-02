package com.kula.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author kula
 * @create 2021/10/20 下午4:52
 */
@Data
public class UserEntity implements Serializable {
    private Integer id;
    private String name;
}

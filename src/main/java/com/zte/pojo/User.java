package com.zte.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Table(name = "tb_user")
public class User {


    private static final long serialVersionUID = 1L;
    @Id
    @KeySql(useGeneratedKeys = true)//主键回显
    private Long id;

    // 用户名
    private String username;

    // 密码
    private String password;

    // 创建时间
    private Date created;

    //号码
    private String phone;
    // 备注
    @Transient//不是数据库字段，不需要持久化
    private String note;

}


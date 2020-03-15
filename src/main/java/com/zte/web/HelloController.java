package com.zte.web;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.zte.pojo.User;
import com.zte.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("user")
public class HelloController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User queryUser(@PathVariable(name = "id") long id) {
        return userService.queryById(id);
    }

    @GetMapping("/all")
    public List<User> queryUsers() {
        return userService.queryAll();
    }

    @GetMapping("/export")
    public void exportUsers(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userService.queryAll();
        try (ServletOutputStream outputStream=response.getOutputStream();ExcelWriter writer = ExcelUtil.getWriter()) {
            writer.addHeaderAlias("id", "编号");
            writer.addHeaderAlias("username", "姓名");
            writer.addHeaderAlias("phone", "手机号码");
            writer.setOnlyAlias(true);
            writer.merge(2, "用户信息表");
            writer.write(users, true);
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            //限制编码
            response.setHeader("Content-Disposition", "attachment;filename=" + new String("用户信息.xls".getBytes(), StandardCharsets.ISO_8859_1));
            writer.flush(outputStream,true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

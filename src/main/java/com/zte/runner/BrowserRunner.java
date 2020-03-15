package com.zte.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BrowserRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("开始打开浏览器进入主页！");
        try {
            Runtime.getRuntime().exec("cmd /c start http://localhost");
        } catch (Exception e) {
            log.error("no runtime!");
        }

    }
}

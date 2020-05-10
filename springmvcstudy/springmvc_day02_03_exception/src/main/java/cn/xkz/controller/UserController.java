package cn.xkz.controller;

import cn.xkz.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SysException{
        System.out.println("testException执行了...");
        try {
            //模拟异常
            int a = 10/0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            throw new SysException("查询所有的用户出现了错误...");
        }

        return "success";
    }
}

package com.hue.jdk.controller2;

//引用封装好的 Mybatis-plus包
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hue.jdk.bean.User;
import com.hue.jdk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Classname TableController
 * @Description TODO
 * @Date 2022/4/1 22:38
 * @Created by liumeng
 */
@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }


    @GetMapping("/user/delete/{id}")
    public  String deleteUser(@PathVariable("id")Integer id,
                              @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                              RedirectAttributes ra)
    {
        userService.removeById(id);
        ra.addAttribute("pn",pn); //重定向所带参数
        return "redirect:/dynamic_table";
    }

    @GetMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id")Integer id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             Model model)
    {
        //1. 利用id 来查询当前用户
        User user = userService.getById(id);
        model.addAttribute("user",user);
        model.addAttribute("pn",pn);   //model 一次只能放一个属性？？
        return  "table/user_editable";
    }


   //课后作业 实现添加 修改 功能
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value= "pn",defaultValue = "1")Integer pn , Model model) {


//        //表格内容的遍历
//        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
//                new User("lisi", "123456"),
//                new User("haha", "123456"),
//                new User("hehe", "123456"));
//        model.addAttribute("users",users);
        //从数据库中查询user表中的用户进行展示
        List<User> list= userService.list();
//       model.addAttribute("users",list);

        //分页查询
        Page<User> userPage = new Page<>(pn,2);

        //分页查询的结果
        Page<User> page = userService.page(userPage, null);
        long current = page.getCurrent();
        long pages = page.getPages();
        long total = page.getTotal();
        List<User> records = page.getRecords();

        model.addAttribute("page",page);
        return "table/dynamic_table";
    }



    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }


    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }

    @GetMapping("/user_editable")
    public String user_editable() {
        return "table/user_editable";
    }

}

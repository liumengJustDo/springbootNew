package com.hue.jdk.controller2;


import com.hue.jdk.bean.Account;
import com.hue.jdk.bean.City;
import com.hue.jdk.bean.User;
import com.hue.jdk.service.AccountService;
import com.hue.jdk.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;


@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountService accountService;

    @Autowired
    CityService cityService;

    @ResponseBody
    @GetMapping("/acct")
    public Account getById( @RequestParam("id") int id){

        return  accountService.getAcctId(id);
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") int id){

        return  cityService.getCityById(id);
    }

    @ResponseBody
    @PostMapping("/savecity")
    public City saveCityByname(City city){
        cityService.saveCity(city);
       return city;
    }



    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb()
    {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from book", Long.class);
        return aLong.toString();
    }


    /**
     * 来登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }


    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){ //RedirectAttributes

        if(StringUtils.hasLength(user.getUsername()) && "123456".equals(user.getPassword())){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            //回到登录页面
            return "login";
        }

    }


    /**
     * 去main页面
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){

//        log.info("当前方法是：{}","mainPage");
        //是否登录。  拦截器，过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser != null){
//            return "main";
//        }else {
//            //回到登录页面
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }
//        ValueOperations<String, String> opsForValue =
//                redisTemplate.opsForValue();
//
//        String s = opsForValue.get("/main.html");
//        String s1 = opsForValue.get("/sql");
//
//
//        model.addAttribute("mainCount",s);
//        model.addAttribute("sqlCount",s1);

        return "main";

    }
}

package com.example.pjhouduan.controller;

import com.example.pjhouduan.mybatis.SqlSessionLoader;
import com.example.pjhouduan.mybatis.po.User;
import com.example.pjhouduan.request.UserRegisterRequest;
import com.example.pjhouduan.response.GreetingResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "What the fuck!";
    }

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public @ResponseBody
    GreetingResponse greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GreetingResponse(counter.incrementAndGet(), "ff74i, " + name + "!");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody Object register(@RequestBody UserRegisterRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("adweb.lab2.UserMapper.findUserByUsername", request.getUsername());
        if (user != null) {
            sqlSession.close();
            return "The username is already used";
        } else {
            sqlSession.insert("adweb.lab2.UserMapper.addUser", new User(request.getUsername(), request.getPassword(), request.getEmail(), request.getPhone()));
            sqlSession.commit();
            sqlSession.close();
            return "abc"; // use your generated token here.
        }
    }
}
package com.example.pjhouduan.controller;

import com.example.pjhouduan.mybatis.SqlSessionLoader;
import com.example.pjhouduan.mybatis.po.Student;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")

public class StudentController {
    @RequestMapping(path = "/student",method = RequestMethod.GET)
    public Student getStubySig(@RequestParam(value = "signature") String signature) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Student student = sqlSession.selectOne("GJweb.Mapper.selectstubysig",signature);
        return student;
    }
    @RequestMapping(path = "/addstu",method = RequestMethod.POST)
    public int addStu(  @RequestBody Student student)throws IOException{
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        System.out.println("stu");
        System.out.println(student.getSex());
        System.out.println(student.getSignature());
        System.out.println(sqlSession.insert("GJweb.Mapper.addStu",student));
        sqlSession.commit();
        sqlSession.close();
        return 1;
    }
    @RequestMapping(path = "/updatestuinfo",method = RequestMethod.PUT)
    public int update(@RequestBody Student student)throws IOException{
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        System.out.println("stuno;"+student.getStudentnumber());
        sqlSession.update("GJweb.Mapper.updatestuinfo",student);
        sqlSession.commit();
        sqlSession.close();
        return 1;
    }
}

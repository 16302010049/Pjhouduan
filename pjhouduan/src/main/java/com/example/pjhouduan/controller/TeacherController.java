package com.example.pjhouduan.controller;

import com.example.pjhouduan.mybatis.SqlSessionLoader;
import com.example.pjhouduan.mybatis.po.*;
import com.example.pjhouduan.request.AddLessonRequest;
import com.example.pjhouduan.request.AnswerRecordRequest;
import com.example.pjhouduan.request.TeacherLoginRequest;
import com.example.pjhouduan.request.TeacherRegisterRequest;
import com.example.pjhouduan.response.AnswerRecordResponse;
import com.example.pjhouduan.response.CommonResponse;
import com.example.pjhouduan.response.GreetingResponse;
import com.example.pjhouduan.response.StudentListResponse;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/teacher")
public class TeacherController {
    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public @ResponseBody Object register(TeacherRegisterRequest teacherRegisterRequest) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        String fileName = teacherRegisterRequest.getHead().getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;
        //指定本地文件夹存储图片
        String filePath = "D:\\image\\";
        try {
            //将图片保存到static文件夹里
            teacherRegisterRequest.getHead().transferTo(new File(filePath+fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.insert("GJweb.Mapper.addTeacher",new Teacher(teacherRegisterRequest.getName(),teacherRegisterRequest.getPassword(),"http://localhost:8080/img/"+fileName));
        sqlSession.commit();
        sqlSession.close();
        return new GreetingResponse(12,"fjlak");
    }

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public @ResponseBody Object login(TeacherLoginRequest teacherLoginRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Teacher teacher = sqlSession.selectOne("GJweb.Mapper.checkLogin",teacherLoginRequest);
        sqlSession.commit();
        sqlSession.close();
        return teacher;
    }

    @RequestMapping(path = "/addLesson",method = RequestMethod.POST)
    public @ResponseBody Object addLesson(AddLessonRequest addLessonRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        String fileName = addLessonRequest.getBackground().getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;
        //指定本地文件夹存储图片
        String filePath = "D:\\image\\";
        try {
            //将图片保存到static文件夹里
            addLessonRequest.getBackground().transferTo(new File(filePath+fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.insert("GJweb.Mapper.addLesson",new CourseJson(addLessonRequest.getTeacher_id(),addLessonRequest.getTitle(),addLessonRequest.getSubtitle(),"http://localhost:8080/img/"+fileName,addLessonRequest.getIntroduce(),addLessonRequest.getContent()));
        sqlSession.commit();
        sqlSession.close();
        return  new GreetingResponse(12,"fjlak");
    }

    @RequestMapping(path = "/getAllLesson",method = RequestMethod.GET)
    public @ResponseBody Course[] getAllLesson(@RequestParam int teacher_id) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<CourseJson> courseJsonList = new ArrayList<>();
        courseJsonList = sqlSession.selectList("GJweb.Mapper.findAllLesson",teacher_id);
        sqlSession.commit();
        sqlSession.close();
        Course[] courses = new Course[courseJsonList.size()];
        for(int i=0;i<courseJsonList.size();i++){
            courses[i] = Course.coursejson2course(courseJsonList.get(i));
        }
        return courses;
    }

    @RequestMapping(path = "/updateLesson",method = RequestMethod.POST)
    public @ResponseBody Course updateLesson(@RequestBody Course course) throws IOException{
        CourseJson courseJson = Course.course2coursejson(course);
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        sqlSession.update("GJweb.Mapper.updateLesson",courseJson);
        sqlSession.commit();
        sqlSession.close();
        return course;
    }

    @RequestMapping(path = "/studentList",method = RequestMethod.GET)
    public @ResponseBody StudentListResponse[] getStudentList(@RequestParam int course_id) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<StudentListResponse> studentListResponseList = sqlSession.selectList("GJweb.Mapper.getStudentList",course_id);
        StudentListResponse[] studentListResponses = new StudentListResponse[studentListResponseList.size()];
        studentListResponseList.toArray(studentListResponses);
        return studentListResponses;
    }

    @RequestMapping(path="/answerRecord",method = RequestMethod.POST)
    public @ResponseBody AnswerRecordResponse[] getAnswerRecord(@RequestBody AnswerRecordRequest answerRecordRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<AnswerRecordResponse> answerRecordResponseList = sqlSession.selectList("GJweb.Mapper.getAnswerRecord",answerRecordRequest);
        AnswerRecordResponse[] answerRecordResponses = new AnswerRecordResponse[answerRecordResponseList.size()];
        answerRecordResponseList.toArray(answerRecordResponses);
        return answerRecordResponses;
    }

    @RequestMapping(path = "/deleteCourse",method = RequestMethod.GET)
    public @ResponseBody Object deleteCourse(@RequestParam int course_id) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        sqlSession.delete("GJweb.Mapper.deleteCourseStudent",course_id);
        sqlSession.delete("GJweb.Mapper.deleteAnswerRecord",course_id);
        sqlSession.delete("GJweb.Mapper.deleteCourse",course_id);
        sqlSession.commit();
        sqlSession.close();
        return  new GreetingResponse(12,"fjlak");
    }

    @RequestMapping(path = "/checkName",method = RequestMethod.GET)
    public @ResponseBody  CommonResponse checkName(@RequestParam String name) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        String re = "";
        re = sqlSession.selectOne("GJweb.Mapper.checkName",name);
        sqlSession.commit();
        sqlSession.close();
        if(re == null){
            return new CommonResponse("Ok");
        }
        else{
            return new CommonResponse("No");
        }
    }
}

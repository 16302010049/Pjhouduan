package com.example.pjhouduan.controller;

import com.example.pjhouduan.mybatis.SqlSessionLoader;
import com.example.pjhouduan.mybatis.po.*;
import com.example.pjhouduan.request.AddCourseRequest;
import com.example.pjhouduan.request.DeleteLessonRequest;
import com.example.pjhouduan.request.UpdatePro;
import com.example.pjhouduan.request.getProcessRequest;
import com.example.pjhouduan.response.GreetingResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SNIHostName;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.example.pjhouduan.mybatis.po.Course.coursejson2course;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/course")
public class CourseController {
    @RequestMapping(path = "/getallcourses",method = RequestMethod.GET)
    public @ResponseBody List<CourseStu>getallCourse()throws IOException {
        List<CourseStu>courses=new ArrayList<>();
        List<CourseStuJson> courseStuJsonList = new ArrayList<>();
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        courseStuJsonList=sqlSession.selectList("GJweb.Mapper.getallcourses");
        for(int i=0;i<courseStuJsonList.size();i++){
            CourseStu courseStu = CourseStuJson.coursestujson2coursestu(courseStuJsonList.get(i));
            courses.add(courseStu);
        }
        return courses;
    }
    @RequestMapping(path ="/getcoursebycourseid",method=RequestMethod.GET)
    public @ResponseBody
    Course getcoursebycourseid(@RequestParam (value = "courseid")int id)throws IOException{
        Course course=new Course();
        CourseJson courseJson=new CourseJson();
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        courseJson=sqlSession.selectOne("getcoursebycourseid",id);
        System.out.println(courseJson.getContent());
        course=coursejson2course(courseJson);
        return course;
    }
    @RequestMapping(path = "/getcoursebyid",method = RequestMethod.GET)
    public @ResponseBody List<Integer>getcoursebyid(@RequestParam(value = "id")int id) throws IOException {
        List<Integer>course=new ArrayList<>();
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        course=sqlSession.selectList("GJweb.Mapper.getcoursebyid",id);

        return course;
    }
    @RequestMapping(path="/addcourse" ,method = RequestMethod.POST)
    public Object addcourse(@RequestBody AddCourseRequest addCourseRequest)throws IOException{
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        List<SectionName>list=new ArrayList<>();
        Gson gson = new Gson();
        String content = gson.toJson(list);
        System.out.println("inti:"+content);
        addCourseRequest.setStudysection(content);
        sqlSession.insert("GJweb.Mapper.addcourse",addCourseRequest);
        sqlSession.commit();
        sqlSession.close();
        return 1;
    }
    @RequestMapping(path = "/addanswerrecord",method = RequestMethod.POST)
    public Object addanswerrecord(@RequestBody AnswerRecord answerRecord)throws IOException{
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        sqlSession.insert("GJweb.Mapper.addanswerrecord",answerRecord);
        sqlSession.commit();
        sqlSession.close();
        return null;
    }
    @RequestMapping(path = "/addcollection",method = RequestMethod.POST)
    public Object addcollection(@RequestBody Collection collection) throws IOException {
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        sqlSession.insert("GJweb.Mapper.addcollection",collection);
        sqlSession.commit();
        sqlSession.close();
        return null;
    }
    @RequestMapping(path = "/getcollect",method = RequestMethod.GET)
    public @ResponseBody List<Collection> getcollect(@RequestParam(value = "stu_id")int id)throws IOException{
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        List<Collection>collections=new ArrayList<>();
        collections=sqlSession.selectList("GJweb.Mapper.getcollect",id);
        return collections;

    }
    @RequestMapping(path = "/updatecollect",method = RequestMethod.PUT)
    public void update(@RequestBody Collection collection)throws IOException{
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        sqlSession.update("GJweb.Mapper.updatecollect",collection);
        sqlSession.commit();
        sqlSession.close();
    }
    @RequestMapping( path="/deletecollect",method = RequestMethod.DELETE)
    public void delete(@RequestParam(value = "id")int id)throws IOException{
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        sqlSession.delete("GJweb.Mapper.daletecollect",id);
        sqlSession.commit();
        sqlSession.close();
    }
    @RequestMapping(path = "/updatepro",method = RequestMethod.PUT)
    public void updatepro(@RequestBody UpdatePro updatePro)throws IOException{

        String newSection=updatePro.getSection();
        int total = updatePro.getTotal();
        SectionName sectionName=new SectionName();
        sectionName.setSectionname(newSection);
        System.out.println(newSection);
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        AddCourseRequest addCourseRequest=sqlSession.selectOne("GJweb.Mapper.getcoursestu",updatePro);
        Gson gson = new Gson();
        // 将 json 转化 成 List泛型
        System.out.println(addCourseRequest.getId());
        List<SectionName> sectionnames = gson.fromJson(addCourseRequest.getStudysection(), new TypeToken<List<SectionName>>() {
        }.getType());
        System.out.println(addCourseRequest.getStudysection());
        System.out.println(sectionnames);
        sectionnames.add(sectionName);
        String newsections = gson.toJson(sectionnames);
        addCourseRequest.setStudysection(newsections);
        DecimalFormat df=new DecimalFormat("0.00");
        addCourseRequest.setProgress(Float.parseFloat(df.format((float)sectionnames.size()/total)));
        sqlSession.update("GJweb.Mapper.updatecoursestu",addCourseRequest);
        sqlSession.commit();
        sqlSession.close();
    }

    @RequestMapping(path="/getmycourse",method = RequestMethod.GET)
    public @ResponseBody List<CourseStu> getMyCourse(@RequestParam int stuid) throws IOException{
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        List<Integer> courseIDs = sqlSession.selectList("GJweb.Mapper.getcoursebyid",stuid);
        List<CourseStu> courseStus = new ArrayList<>();
        for(int i=0;i<courseIDs.size();i++){
            int course_id = courseIDs.get(i);
            courseStus.add(CourseStuJson.coursestujson2coursestu(sqlSession.selectOne("GJweb.Mapper.getcoursebycourseid",course_id)));
        }
        return courseStus;
    }

    @RequestMapping(path="getStudySection",method = RequestMethod.POST)
    public @ResponseBody List<SectionName> getStudySection(@RequestBody getProcessRequest getProcessRequest)throws IOException{
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        String studyString = sqlSession.selectOne("GJweb.Mapper.getStudySection",getProcessRequest);
        Gson gson = new Gson();
        return gson.fromJson(studyString, new TypeToken<List<SectionName>>() {
        }.getType());
    }

    @RequestMapping(path="deleteCourse",method = RequestMethod.POST)
    public @ResponseBody Object deleteCourse(@RequestBody DeleteLessonRequest deleteLessonRequest)throws IOException{
        SqlSession sqlSession= SqlSessionLoader.getSqlSession();
        sqlSession.delete("GJweb.Mapper.deleteStuLesson",deleteLessonRequest);
        sqlSession.delete("GJweb.Mapper.delAnswerRecord",deleteLessonRequest);
        sqlSession.commit();
        sqlSession.close();
        return  new GreetingResponse(12,"fjlak");
    }
}


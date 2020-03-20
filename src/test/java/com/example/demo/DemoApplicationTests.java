package com.example.demo;

import com.example.demo.controller.StudentController;
import com.example.demo.dao.StudentRepository;
import com.example.demo.pojo.Student;
import com.example.demo.service.StudentService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static com.sun.javaws.JnlpxArgs.verify;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
    @Autowired(required=false)
    StudentRepository studentRepository;
    @Autowired
    MockMvc mvc;


    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setup()
    {
        this.mvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    /*
    * @throws Exception
    * @创建日期：2020年3月19日
    * @功能描述：测试dao层的查询操作
    * */

    @Test
    public void DaoFindAllTest ()throws Exception
    {

        studentRepository.findAll();
    }

    /*
    * @throws Exception
    * @创建日期：2020年3月19日
    * @功能描述：测试dao层的修改操作
    * */
    @Test
    @Transactional
    @Rollback(false)
    public void DaoUpdateTest ()throws Exception
    {
        Student student=new Student();
        student.setId(19);
        student.setName("诸葛无力");
        student.setAge(18);
        student.setScore(91.0);
        studentRepository.save(student);
    }

    /*
    * @throws Exception
    * @创建日期：2020年3月19日
    * @功能描述：测试dao层的删除操作
    * */

    @Test
    @Transactional
    @Rollback
    public void DaoDeleteTest ()throws Exception
    {
        this.studentRepository.deleteById(15);
    }

    /*
    * @throws Exception
    * @创建日期：2020年3月19日
    * @功能描述：测试dao层的增加操作
    * */
    @Test
    @Transactional
    @Rollback(false)
    public void DaoSaveTest ()throws Exception
    {
        Student student=new Student();
        student.setName("诸葛有力");
        student.setAge(18);
        student.setScore(91.0);
        this.studentRepository.save(student);
    }


    /*
     * @throws Exception
     * @创建日期：2020年3月19日
     * @功能描述：测试controller层的增加操作
     * */



    @Test
    public void testFindFromController() throws Exception
    {
        String url="/find";

        MvcResult mvcResult=this.mvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }




}

package com.sdj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//api的一层命名 /api
@RequestMapping("/api")
public class StudentController {
//   1 当请求过来先访问这里controller 层 ， 其次指向=》Service层
    @Autowired
    private StudentService studentService;

    @GetMapping("/Students")
//  实际后端程序端口为8085， 这里则是模拟从8080
//    因为浏览器跨源资源共享（CORS）策略限制，访问同一IP的不同端口，会被浏览器限制
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

}

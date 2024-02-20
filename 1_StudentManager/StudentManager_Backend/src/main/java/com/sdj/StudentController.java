package com.sdj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//api的一层命名 /api
@RequestMapping("/api")
public class StudentController {
//   1 当请求过来先访问这里controller 层 ， 其次指向=》Service层
    @Autowired
    private StudentService studentService;
    // 遍历所有学生信息
    @GetMapping("/Students")
//  实际后端程序端口为8085， 这里则是模拟从8080
//    因为浏览器跨源资源共享（CORS）策略限制，访问同一IP的不同端口，会被浏览器限制
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    //  删除学生信息
    // 删除学生信息
    @DeleteMapping("/Students/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        // 调用Service层的方法删除学生信息
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return ResponseEntity.ok("学生信息删除成功");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

package com.sdj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class StudentService {
//    2 studentMapper 调用mapper方法，并指向=》StudentMapper
//      学生信息查询功能
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }

//    TODO  学生信息添加功能
//     学生信息删除功能
    public boolean deleteStudent(String id) {
        int result = studentMapper.softDeleteStudent(id);
        if (result == 0 ){
            return false ;
        }else{
            return true;
        }


}
//    TODO  学生信息修改功能


}

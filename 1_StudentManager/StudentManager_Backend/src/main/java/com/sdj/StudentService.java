package com.sdj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class StudentService {
//    2 studentMapper 调用mapper方法，并指向=》StudentMapper
//     学生信息查询功能
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }

//     学生信息删除功能
    public boolean deleteStudent(String id) {
        int result = studentMapper.softDeleteStudent(id);
        if (result == 0 ){
            return false ;
        }else{
            return true;
        }


}
//    TODO 【优先级1】 学生信息修改功能
public boolean editStudent(String id ,Student updatedStudent) {
    int result = studentMapper.editStudent(id,updatedStudent);
    if (result == 0) {
        System.out.println("数据库里没找到！！！  ");

        return false;


    } else {
        return true;
    }
}
//    TODO  【优先级1】学生信息添加功能

//    TODO  【优先级1】学生信息查询功能
    public List<Student> searchStudents(String keywords) {
    return studentMapper.resualtStudents(keywords);

}


}

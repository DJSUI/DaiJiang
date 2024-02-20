package com.sdj;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

    @Mapper
    public interface StudentMapper {
//        3 执行slect 语句
//        使用 MyBatis Spring Boot Starter 时，可以省略编写 Mapper.xml 文件
//        以@Select这样形式的注解，积习难改sql编写
//        @Select、@Insert、@Update 和 @Delete 注解分别对应 SQL 查询语句
//        只需在方法上添加适当的注解，以及对应的 SQL 语句，就可以完成数据访问操作。

//        @Select是告诉mybatis框架实现一个sql语句
        @Select("SELECT * FROM Students WHERE is_deleted != 1")
        List<Student>  getAllStudents();
    //    void addStudent(Student student);
    //    void updateStudent(Student student);

        @Update("UPDATE Students SET is_deleted = 1 WHERE studentId = #{id}")
        int softDeleteStudent(String id);


    }

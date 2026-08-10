package com.abhilash.studentms.dao;

import com.abhilash.studentms.model.Student;
import java.util.List;

public interface StudentDAO {

    boolean addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    boolean updateStudent(Student student);

    boolean deleteStudent(int id);

    List<Student> searchStudents(String keyword);

    List<Student> getStudentsByPage(int page, int pageSize);

    int getTotalStudentCount();

    List<Student> searchStudentsByPage(String keyword, int page, int pageSize);

    int getSearchStudentCount(String keyword);
}
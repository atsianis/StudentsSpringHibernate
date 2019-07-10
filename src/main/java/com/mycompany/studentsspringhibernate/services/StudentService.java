/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentsspringhibernate.services;

import com.mycompany.studentsspringhibernate.dao.StudentDao;
import com.mycompany.studentsspringhibernate.models.Student;
import java.util.List;

/**
 *
 * @author samsung np350
 */
public class StudentService {
    
    public List<Student> getStudents(){
        StudentDao sdao = new StudentDao();
        return sdao.getAllStudents();
    }
    
    public int saveStudent(Student s){
        StudentDao sdao = new StudentDao();
        return sdao.saveStudent(s);
    }
    
    public void updateStudent(Student s){
        StudentDao sdao = new StudentDao();
        sdao.updateStudent(s.getId(),s);
    }
    
    public Student getStudentById(int id){
        StudentDao sdao = new StudentDao();
        return sdao.getStudentById(id);
    }
    
    public void deleteStudent(int id){
        StudentDao sdao = new StudentDao();
        sdao.deleteStudent(id);
    }
}

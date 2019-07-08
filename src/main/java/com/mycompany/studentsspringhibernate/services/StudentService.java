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
    
    public int saveStudent(String firstName, String lastName, String section){
        StudentDao sdao = new StudentDao();
        return sdao.saveStudent(firstName,lastName,section);
    }
    
    public void updateStudent(Student s){
        StudentDao sdao = new StudentDao();
        sdao.updateStudent(s.getId(), s.getSection());
    }
}

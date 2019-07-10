package com.mycompany.studentsspringhibernate.controllers;


import com.mycompany.studentsspringhibernate.models.Student;
import com.mycompany.studentsspringhibernate.services.StudentService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class StudentController {
    
        @RequestMapping(method = RequestMethod.GET)
        public String indexPage(ModelMap model){
            return "index";
        }
        
        @RequestMapping(value= "/allstudents", method = RequestMethod.GET)
	public String getAllStudents(ModelMap model) {
                StudentService ss = new StudentService();
                List<Student> students = ss.getStudents();
		model.addAttribute("students", students);
		return "students";
	}

        @RequestMapping(value = "/studentupdate/{id}", method = RequestMethod.GET)
	public String update(ModelMap model, @PathVariable int id) {
                StudentService ss = new StudentService();
                Student s = ss.getStudentById(id);
		model.addAttribute("student", s);
                model.addAttribute("title","update");
                model.addAttribute("what","save");
		return "addedit";
	}
        
        @RequestMapping(value = "/addstudent", method = RequestMethod.GET)
	public String add(ModelMap model) {
            model.addAttribute("title", "Add");
            model.addAttribute("what", "save");
            model.addAttribute("student", new Student());
            return "addedit";
        }
        
        @RequestMapping(value = "/studentsave", method = RequestMethod.POST)
        // sto sygkekrimeno, to add new mou paizei kai me to modelattribute, pernontas mesa sto service
        // olokliro object kai me @valid profanws. Vlepe to SpringHibernateNoXML pou to model attribute sto add new
        // mou paizei mono otan pernaw sta service,dao ta stoixeia toy object ena ena (xwris to id)
	public String addsave(ModelMap model,@ModelAttribute("student") Student s) {
//            if (result.hasErrors()) {
//                return "index";
//            }
            StudentService ss = new StudentService();
            if (s.getId()==0){//new student
                ss.saveStudent(s);
                model.addAttribute("message", "Insert Completed");
            }else{//update old student
                ss.updateStudent(s);
                model.addAttribute("message", "Update Completed");
            }
            List<Student> students = ss.getStudents();
            model.addAttribute("students", students);
            return "students";
        }
        
        @RequestMapping(value = "/studentdelete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable int id) {
                StudentService ss = new StudentService();
                ss.deleteStudent(id);
                model.addAttribute("message", "Row successfully deleted");
                List<Student> students = ss.getStudents();
                model.addAttribute("students", students);
                return "students";
                
	}

}
package com.mycompany.studentsspringhibernate.controllers;


import com.mycompany.studentsspringhibernate.models.Student;
import com.mycompany.studentsspringhibernate.services.StudentService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class StudentController {

//	@RequestMapping(method = RequestMethod.GET)
        // to ModelMap einai to antistoixo ModelAndView bean
        // to model einai ena hashMap pou pernaei mesa ta antikeimena pou thelw nametaferw mprosta-pisw (front-back)
//	public String sayHello(ModelMap model) {
//		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
//                // edw epistrefoume apla ena view
//                // paratiroume oti den epistrefoume to bean pou tou valame entities 'h whatever
//                // auto ginetai automata
//                // diladi apo edw pame sto welcome.jsp MAZI ME O,TI EXEI FTIAXTEI EDW MESA( model )
//		return "index";
//	}

//	@RequestMapping(value = "/helloagain/{id}", method = RequestMethod.GET)
//	public String sayHelloAgain(ModelMap model, @PathVariable int id) {
//		model.addAttribute("id", id);
//		return "index";
//	}
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
//        
//        @RequestMapping(value = "/trainerbyid", method = RequestMethod.GET)
//	public String getTrainerById(ModelMap model) {
//                TrainerService ts = new TrainerService();
//                Trainer t = ts.getTrainerById(2);
//		model.addAttribute("t", t);
//		return "trainerbyid";
//	}
//        
//        @RequestMapping(value = "/trainerupdate/{id}", method = RequestMethod.GET)
//	public String update(ModelMap model, @PathVariable int id) {
//                TrainerService ts = new TrainerService();
//                Trainer t = ts.getTrainerById(id);
//		model.addAttribute("t", t);
//                model.addAttribute("title","update");
//                model.addAttribute("what","update");
//		return "addEditTrainer";
//	}
//        
//        @RequestMapping(value = "/trainerupdate", method = RequestMethod.POST)
//	public String updateSave(ModelMap model,
//                @RequestParam("id") int id,
//                @RequestParam("firstName") String fname,
//                @RequestParam("lastName") String lname,
//                @RequestParam("subject") String subject) {
//                Trainer t = new Trainer(id,fname,lname,subject);
//                TrainerService ts = new TrainerService();
//                boolean b = ts.updateTrainer(t);
//		if (b==true){
//                    model.addAttribute("message", "Trainer "+t.getTrainerId()+" updated");
//                }else{
//                    model.addAttribute("message", "Problem with update");
//                }
//                List<Trainer> trainers = ts.getTrainers();
//		model.addAttribute("trainers", trainers);
//                return "trainers";
//	}
//        
        @RequestMapping(value = "/addstudent", method = RequestMethod.GET)
	public String add(ModelMap model) {
            model.addAttribute("title", "Add");
            model.addAttribute("what", "save");
            model.addAttribute("student", new Student());
            return "addedit";
        }
        
        @RequestMapping(value = "/studentsave", method = RequestMethod.POST)
	public String addsave(ModelMap model,@ModelAttribute("student") Student s) {
            StudentService ss = new StudentService();
            if (s.getId()==0){//new student
                ss.saveStudent(s.getFirstName(),s.getLastName(),s.getSection());
                model.addAttribute("message", "Insert Completed");
            }else{//update old student
                ss.updateStudent(s);
                model.addAttribute("message", "Update Completed");
            }
            List<Student> students = ss.getStudents();
            model.addAttribute("students", students);
            return "students";
        }
//        
//        @RequestMapping(value = "/trainerdelete/{id}", method = RequestMethod.GET)
//	public String delete(ModelMap model, @PathVariable int id) {
//                TrainerService ts = new TrainerService();
//                boolean b = ts.deleteTrainer(id);
//                if (b==true){
//                    model.addAttribute("message", "Row successfully deleted");
//                }else{
//                    model.addAttribute("message", "Row could not be deleted");
//                }
//                List<Trainer> trainers = ts.getTrainers();
//                model.addAttribute("trainers", trainers);
//                return "trainers";
//                
//	}

}
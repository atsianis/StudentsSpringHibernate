
package com.mycompany.studentsspringhibernate.dao;

import com.mycompany.studentsspringhibernate.HibernateUtil;
import com.mycompany.studentsspringhibernate.models.Student;
import java.util.List;
import org.hibernate.Session;

public class StudentDao {
    
    public int saveStudent(String firstName, String lastName, String section) {
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setSection(section);
                
                //To antistoixo tou em
                // kai em=emf.createEntityManager
                // em.transaction.begin()
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
                
                // i methodos save tou hibernate pairnei mono object
                // kserei ennoeitai se poio table antistoixei auto pou tou pernaw
                // kai kanei mono tou to save
                // by default epistrefei to id pou tou dinei
		int id = (Integer) session.save(student);
		session.getTransaction().commit();
		session.close();
		return id;
	}

	/**
	 * This method returns list of all persisted Student objects/tuples from
	 * database
	 */
	public List<Student> getAllStudents() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
                // to .list() einai antistoixo tou query.getResultList() pou eixame sto JPA
                // to query einai grammeno se HQL
		List<Student> students = (List<Student>) session.createQuery(
				"FROM Student s ORDER BY s.firstName ASC").list();

		session.getTransaction().commit();
		session.close();
		return students;
	}

	/**
	 * This method updates a specific Student object
	 */
	public void updateStudent(int id, String section) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
                // antistoixo tou em.find(Student.class, id) pou kaname sto JPA
                // auto to object mas erxetai LIVE apo tin vasi
                // mporoume na peiraksoume o,ti theloume
                //ALLA den prepei na peiraksoume to id giati tha xasoume to mapping
                // pou exei dhmiourgithei
		Student student = (Student) session.get(Student.class, id);
		student.setSection(section);
		//session.update(student);//No need to update manually as it will be updated automatically on transaction close.
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * This method deletes a specific Student object
	 */
	public void deleteStudent(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
                
		Student student = (Student) session.get(Student.class, id);
		session.delete(student);
		session.getTransaction().commit();
		session.close();
	}
        
        public Student getStudentById(int id){
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Student s = (Student) session.get(Student.class, id);
            session.close();
            return s;
            
        }
    
}

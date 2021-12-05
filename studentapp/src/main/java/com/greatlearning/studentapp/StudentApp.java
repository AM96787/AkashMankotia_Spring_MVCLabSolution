package com.greatlearning.studentapp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.studentapp.implementation.StudentServiceImpl;
import com.greatlearning.studentapp.service.StudentService;

public class StudentApp {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		
		SessionFactory sessionFactory = config.buildSessionFactory();

		StudentService ss = new StudentServiceImpl(sessionFactory);

		List<Student> students = ss.findAll();

		for (Student student : students)
			System.out.println(student);

	}

}

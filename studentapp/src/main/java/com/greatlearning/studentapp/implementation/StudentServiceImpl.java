package com.greatlearning.studentapp.implementation;

import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.studentapp.Student;
import com.greatlearning.studentapp.service.StudentService;

@Repository
public class StudentServiceImpl implements StudentService{
	private SessionFactory sessionFactory;
	private Session session;

	public StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = this.sessionFactory.openSession();
		}
	}
@Transactional
	public List<Student> findAll() {
	Transaction tx = session.beginTransaction();
		List<Student> student = session.createQuery("from Student", Student.class).list();
		tx.commit();
		return student;
	}
@Transactional
public Student findById(int id) {
	Transaction tx = session.beginTransaction();
	Student student = session.get(Student.class, id);
	tx.commit();
	return student;
}
@Transactional
public void save(Student student) {

	Transaction tx = session.beginTransaction();
	session.saveOrUpdate(student);
	tx.commit();

}
@Transactional
public void deleteById(int id) {

	Transaction tx = session.beginTransaction();
	Student student = session.get(Student.class, id);
	session.delete(student);
	tx.commit();

}

}

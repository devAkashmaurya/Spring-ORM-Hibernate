package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int insert(Student student) {

		Integer r = (Integer) this.hibernateTemplate.save(student);
		return r;
	}

	public Student getStudent(int studentId) {

		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}

	public List<Student> getAllStudent() {
		List<Student> loadAll = this.hibernateTemplate.loadAll(Student.class);
		return loadAll;
	}
	
    @Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}

	public void updateStudent(Student student) {
		this.hibernateTemplate.delete(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}

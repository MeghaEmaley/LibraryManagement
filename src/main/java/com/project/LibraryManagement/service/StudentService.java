package com.project.LibraryManagement.service;


import java.util.List;

import com.project.LibraryManagement.entity.BookRequest;
import com.project.LibraryManagement.entity.Student;

public interface StudentService {

	public List<Student> findAllStudents();

	public Student findStudentById(Long id);

	public Student createStudent(Student student);

	public Student updateStudent(Long id, Student student);

	public void deleteStudent(Long id);

	public BookRequest createRequestTicket(BookRequest requestTicket);

	public void requestBook(BookRequest bookRequest) ;
	
	

}

package com.project.LibraryManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.project.LibraryManagement.entity.BookRequest;
import com.project.LibraryManagement.entity.Publisher;
import com.project.LibraryManagement.entity.Student;
import com.project.LibraryManagement.repository.StudentRepository;
import com.project.LibraryManagement.service.StudentService;


@Service
public class StudentServiceImpl implements  StudentService {

	final  StudentRepository  studentRepository;

	public  StudentServiceImpl( StudentRepository  studentRepository) {
		this. studentRepository =  studentRepository;
	}

    @Autowired
    private RestTemplate restTemplate;
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
    
	public void requestBook(BookRequest bookRequest) {
		 System.out.println("Book request: " + bookRequest.getTitle() + " by " + bookRequest.getAuthor());
    
		
	}

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent != null) {
            existingStudent.setstudentName(updatedStudent.getstudentName());
            existingStudent.setEmail(updatedStudent.getEmail());
            return studentRepository.save(existingStudent);
        }

        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public BookRequest createRequestTicket(BookRequest requestTicket) {
        String url = "http://localhost:8080/request-tickets";
        ResponseEntity<BookRequest> response = restTemplate.postForEntity(url, requestTicket, BookRequest.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to create request ticket");
        }
    }

	
    
   
	
}

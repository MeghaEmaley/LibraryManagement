package com.project.LibraryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.LibraryManagement.entity.Book;
import com.project.LibraryManagement.entity.BookRequest;
import com.project.LibraryManagement.entity.Student;
import com.project.LibraryManagement.service.StudentService;
import com.project.LibraryManagement.entity.BookRequest;

@RestController

public class StudentController {
  
    //private StudentService studentService;
    
    final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;

	}



	@RequestMapping("/students")
	public String findAllStudents(Model model) {

		model.addAttribute("students", studentService.findAllStudents());
		return "list-students";
	}

	@RequestMapping("/student/{id}")
	public String findStudentById(@PathVariable("id") Long id, Model model) {

		model.addAttribute("student", studentService.findStudentById(id));
		return "list-student";
	}

	@GetMapping("/addstudent")
	public String showCreateForm(Student student) {
		return "add-student";
	}

	@RequestMapping("/add-student")
	public String createStudent(Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-student";
		}

		studentService.createStudent(student);
		model.addAttribute("student", studentService.findAllStudents());
		return "redirect:/student";
	}

	@GetMapping("/updateStudent/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {

		model.addAttribute("student", studentService.findStudentById(id));
		return "update-student";
	}

	@RequestMapping("/update-student/{id}")
	public String updateStudent(@PathVariable("id") Long id,Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			student.setId(id);
			return "update-student";
		}

		studentService.updateStudent(id, student);
		model.addAttribute("student", studentService.findAllStudents());
		return "redirect:/students";
	}

	@RequestMapping("/remove-student/{id}")
	public String deleteStudent(@PathVariable("id") Long id, Model model) {
		studentService.deleteStudent(id);

		model.addAttribute("student", studentService.findAllStudents());
		return "redirect:/student";
	}

	@PostMapping("/{id}/borrow-book")
    public BookRequest borrowBook(@PathVariable Long id, @RequestBody Book book) {
        Student student = studentService.findStudentById(id);

        if (student != null) {
            BookRequest requestTicket = new BookRequest();
            requestTicket.setTitle("Book Borrow Request");
            requestTicket.setStatus("Pending");

            return studentService.createRequestTicket(requestTicket);
        }

        throw new RuntimeException("Student not found");
    }
	
	@GetMapping("/books/request")
    public String showBookRequest(Model model) {
        model.addAttribute("bookRequest", new BookRequest());
        return "book_request";
    }

    @PostMapping("/books/request")
    public String requestBook(@ModelAttribute("bookRequest") BookRequest requestForm) {
       
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle(requestForm.getTitle());
        bookRequest.setAuthor(requestForm.getAuthor());
        
        studentService.requestBook(bookRequest);
       return "redirect:/books"; 
    }
	
}

package com.project.LibraryManagement.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.project.LibraryManagement.entity.Author;
import com.project.LibraryManagement.entity.Book;
import com.project.LibraryManagement.entity.Category;
import com.project.LibraryManagement.entity.Publisher;
import com.project.LibraryManagement.entity.Student;
import com.project.LibraryManagement.vo.AuthorRecord;
import com.project.LibraryManagement.vo.BookRecord;
import com.project.LibraryManagement.vo.CategoryRecord;
import com.project.LibraryManagement.vo.PublisherRecord;
import com.project.LibraryManagement.vo.StudentRecord;

public class Mapper {

	public static List<BookRecord> bookModelToVo(List<Book> books) {

		return books.stream().map(vo -> {
			var bookVo = new BookRecord(vo.getId(), vo.getIsbn(), vo.getName(), vo.getSerialName(),
					vo.getDescription());
			return bookVo;
		}).collect(Collectors.toList());
	}

	public static List<AuthorRecord> authorModelToVo(List<Author> authors) {

		return authors.stream().map(vo -> {
			var authorVo = new AuthorRecord(vo.getId(), vo.getName(), vo.getDescription());
			return authorVo;
		}).collect(Collectors.toList());

	}

	public static List<CategoryRecord> categoryModelToVo(List<Category> categories) {

		return categories.stream().map(vo -> {
			var categoryVo = new CategoryRecord(vo.getId(), vo.getName());
			return categoryVo;
		}).collect(Collectors.toList());

	}
	
	public static List<StudentRecord> studentModelToVo(List<Student> students) {

		return students.stream().map(vo -> {
			var studentVo = new StudentRecord(vo.getId(), vo.getstudentName());
			return studentVo;
		}).collect(Collectors.toList());

	}

	public static List<PublisherRecord> publisherModelToVo(List<Publisher> publishers) {

		return publishers.stream().map(vo -> {
			var publisherVo = new PublisherRecord(vo.getId(), vo.getName());
			return publisherVo;
		}).collect(Collectors.toList());

	}

}

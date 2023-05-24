package com.project.LibraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LibraryManagement.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}

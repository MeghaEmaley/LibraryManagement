package com.project.LibraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LibraryManagement.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

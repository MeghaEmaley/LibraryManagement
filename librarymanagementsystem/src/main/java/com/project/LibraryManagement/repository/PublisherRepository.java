package com.project.LibraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LibraryManagement.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}

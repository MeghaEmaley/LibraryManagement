package com.project.LibraryManagement.repository;


	import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LibraryManagement.entity.Borrow;

	public interface BorrowRepository  extends JpaRepository<Borrow,Long> {


}

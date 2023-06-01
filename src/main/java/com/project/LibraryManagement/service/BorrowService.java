package com.project.LibraryManagement.service;


	import java.util.List;

import com.project.LibraryManagement.entity.Borrow;

	public interface BorrowService {

		public List<Borrow> findAllBorrows();

		public Borrow findBorrowById(Long id);

		public void createBorrow(Borrow borrow);

		public void updateBorrow(Borrow borrow);

		public void deleteBorrow(Long id);
}

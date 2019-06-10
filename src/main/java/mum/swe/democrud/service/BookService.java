package mum.swe.democrud.service;

import java.util.List;

import mum.swe.democrud.model.Book;

public interface BookService {
	 List<Book> findAll();
	 Book save(Book Book);
	 Book findOne(Long id);
	 void delete(Long id);
}

package mum.swe.democrud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.swe.democrud.model.Book;
import mum.swe.democrud.repository.BookRepository;
import mum.swe.democrud.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository BookRepository;
	
	@Override
	public List<Book> findAll() {
		return BookRepository.findAll();
	}

	@Override
	public Book save(Book Book) {
		return BookRepository.save(Book);
	}

	@Override
	public Book findOne(Long id) {
		return BookRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		BookRepository.delete(id);
	}

}

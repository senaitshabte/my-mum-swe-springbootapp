package mum.swe.democrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.swe.democrud.model.Book;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Long> {
}

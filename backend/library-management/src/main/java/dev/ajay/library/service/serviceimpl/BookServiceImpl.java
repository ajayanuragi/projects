package dev.ajay.library.service.serviceimpl;

import dev.ajay.library.model.Book;
import dev.ajay.library.repository.BookRepository;
import dev.ajay.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    public BookRepository bookRepository;

    @Override
    public List<Book> searchBooks(String query) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = getBookById(id);

        if (existingBook != null) {
            return bookRepository.save(updatedBook);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

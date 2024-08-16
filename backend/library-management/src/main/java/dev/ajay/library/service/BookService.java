package dev.ajay.library.service;

import dev.ajay.library.model.Book;

import java.util.List;

public interface BookService {
    List<Book> searchBooks(String query);

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book addBook(Book book);

    Book updateBook(Long id, Book updatedBook);

    boolean deleteBook(Long id);
}

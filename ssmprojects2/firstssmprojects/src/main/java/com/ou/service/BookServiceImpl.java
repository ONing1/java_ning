package com.ou.service;

import com.ou.dao.BookMapper;
import com.ou.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{

    private BookMapper bookMapper;

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }


    public List<Books> selectAllBook() {
        return bookMapper.selectAllBook();
    }

    public Books selectBookById(int id) {
        return bookMapper.selectBookById(id);
    }

    public Books selectBookByName(String bookName) {
        return bookMapper.selectBookByName(bookName);
    }





    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public BookMapper getBookMapper() {
        return bookMapper;
    }
}

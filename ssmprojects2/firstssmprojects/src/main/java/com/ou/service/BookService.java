package com.ou.service;

import com.ou.pojo.Books;

import java.util.List;

public interface BookService {

    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(int id);


    //修改一本书
    int updateBook(Books books);


    //查询全部的书
    List<Books> selectAllBook();

    //根据id查询一本书
    Books selectBookById(int id);


    //根据书的名字查询该shu
    Books selectBookByName(String bookName);
}

package com.ou.controller;

import com.ou.pojo.Books;
import com.ou.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;



    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.selectAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }


    @PostMapping("/addBook" )
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }


    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id ,Model model){
        Books books = bookService.selectBookById(id);
        model.addAttribute("book",books);
        return "updateBook";
    }
    @PostMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @PostMapping("/selectBook")
    public String selectBookByBookName(String bookName,Model model){
        Books books = bookService.selectBookByName(bookName);
        List<Books> books1 = new ArrayList<Books>();
        books1.add(books);
        if (books!=null) {
            model.addAttribute("list", books1);
        }else {
            model.addAttribute("error","未查到");
        }
        return "redirect:/book/allBook";
    }
}

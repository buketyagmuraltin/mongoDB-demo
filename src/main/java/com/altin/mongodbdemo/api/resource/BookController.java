package com.altin.mongodbdemo.api.resource;

import com.altin.mongodbdemo.api.model.Book;
import com.altin.mongodbdemo.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        repository.save(book);
        return "Added book with id:" + book.getId();
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks(){
        return repository.findAll();
    }

    @GetMapping("/findAllBooks/{id}")
    public Optional<Book> getBook(@PathVariable int id){
        return repository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        repository.deleteById(id);
        return "Book deleted with id:" + id;
    }
}

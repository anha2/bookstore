package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import hh.sof3.bookstore.domain.BookRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @Autowired

    private BookRepository bookRepository;

    @RequestMapping(value = { "/index", "*" }, method = RequestMethod.GET)
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "index";

    }

}

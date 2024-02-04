package hh.sof3.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import hh.sof3.bookstore.domain.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookstoreController {
    @RequestMapping(value = { "/index", "*" }, method = RequestMethod.GET)
    public String getBooks(Model model) {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Teos", "Tekijä", 2024, "123", 50.0));
        model.addAttribute("books", books);

        return "index";

    }

}

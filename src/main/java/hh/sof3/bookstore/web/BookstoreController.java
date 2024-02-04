package hh.sof3.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ResponseBody

public class BookstoreController {
    @GetMapping("/index")
    public String index() {
        return "Hello";
    }
}
package libraryproject.springframework.libraryproject.controllers;

import libraryproject.springframework.libraryproject.model.Book;
import libraryproject.springframework.libraryproject.model.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class BookController {
    public static BookRepository bookRepository;
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @RequestMapping() // pt link
    public static String getBooksMain(Model model){
        model.addAttribute("books", bookRepository.findAll());
        ArrayList<Book> books = (ArrayList<Book>) bookRepository.findAll();
        books.removeIf(x-> ! (x.getGenres().equals("Fiction")));
        model.addAttribute("booksFiction", books);

        books = (ArrayList<Book>) bookRepository.findAll();
        books.removeIf(x-> x.getbestseller() == Boolean.FALSE);
        model.addAttribute("booksBestseller", books);

        books = (ArrayList<Book>) bookRepository.findAll();
        books.removeIf(x-> ! (x.getGenres().equals("Personal Development")));
        model.addAttribute("booksPersonalDevelopment", books);

        books = (ArrayList<Book>) bookRepository.findAll();
        books.removeIf(x-> ! (x.getGenres().equals("Universal Literature")));
        model.addAttribute("booksUniversalLiterature", books);
        return "main";
    }
    @RequestMapping("/books") // pt link
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }
    @RequestMapping("/bestseller")
    public String getTrendingBooks(Model model){
        ArrayList<Book> books = (ArrayList<Book>) bookRepository.findAll();
        books.removeIf(x-> x.getbestseller() == Boolean.FALSE);
        model.addAttribute("books", books);
        return "books/bestseller";
    }
    @RequestMapping("/englishBooks")
    public String getEnglishBooks(Model model){
        ArrayList<Book> books = (ArrayList<Book>) bookRepository.findAll();
        books.removeIf(x-> ! (x.getLanguage().equals("English")));
        model.addAttribute("books", books);
        return "books/englishBooks";
    }
    @RequestMapping("/romanianBooks")
    public String getRomanianBooks(Model model){
        ArrayList<Book> books = (ArrayList<Book>) bookRepository.findAll();
        books.removeIf(x-> ! (x.getLanguage().equals("Romanian")));
        model.addAttribute("books", books);
        return "books/romanianBooks";
    }
}

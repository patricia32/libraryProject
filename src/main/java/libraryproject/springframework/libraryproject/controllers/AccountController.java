package libraryproject.springframework.libraryproject.controllers;

import libraryproject.springframework.libraryproject.model.Book;
import libraryproject.springframework.libraryproject.model.User;
import libraryproject.springframework.libraryproject.model.repositories.BookRepository;
import libraryproject.springframework.libraryproject.model.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class AccountController {
    public static BookRepository bookRepository;
    public static UserRepository userRepository;
    public Boolean itsUserVar;

    public AccountController(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }



    @RequestMapping("/account/booksAccount") // pt link
    public String getBooksAccount(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "account/listAccount";
    }
    @RequestMapping("/admin/booksAdmin") // pt link
    public String getBooksAdmin(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "admin/listMainAdmin";
    }
    @RequestMapping("/account/bestsellerAccount")
    public String getTrendingBooksAccount(Model model){
        ArrayList<Book> books = (ArrayList<Book>) bookRepository.findAll();
        books.removeIf(x-> x.getbestseller() == Boolean.FALSE);
        model.addAttribute("books", books);
        return "account/bestsellerAccount";
    }

    @RequestMapping("/account/englishBooksAccount")
    public String getEnglishBooksAccount(Model model){
        ArrayList<Book> books = (ArrayList<Book>) bookRepository.findAll();
        books.removeIf(x-> ! (x.getLanguage().equals("English")));
        model.addAttribute("books", books);
        return "account/englishBooksAccount";
    }

    @RequestMapping("/account/romanianBooksAccount")
    public String getRomanianBooksAccount(Model model){
        ArrayList<Book> books = (ArrayList<Book>) bookRepository.findAll();
        books.removeIf(x-> ! (x.getLanguage().equals("Romanian")));
        model.addAttribute("books", books);
        return "account/romanianBooksAccount";
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
    public String deleteBook(@ModelAttribute Book book, BindingResult errors, Model model) {
        // logic to process input data

        ArrayList<Book> books = (ArrayList<Book>) bookRepository.findAll();
        Book del = null;
        System.out.println(book);
        System.out.println(book.getTitle());
        for(Book book1:books){
            if(book1.getTitle().contains(book.getTitle())){
                del = book1;
               break;
            }
        }
        if(del!= null) {
            books.remove(del);
            bookRepository.deleteAll();
            bookRepository.saveAll(books);
        }
        model.addAttribute("books", bookRepository.findAll());
        return getBooksAdmin(model);
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute Book book, BindingResult errors, Model model) {
        // logic to process input data

        ArrayList<Book> books = (ArrayList<Book>) bookRepository.findAll();

        System.out.println(book.getTitle());
        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());

        return getBooksAdmin(model);
    }
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user, BindingResult errors, Model model) {
        // logic to process input data
        model.addAttribute("users", user);
        ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
        users.add(0, user);
        userRepository.deleteAll();
        userRepository.saveAll(users);
        return getLogin(model);
    }

    @RequestMapping(value = "/verifyUser", method = RequestMethod.POST)
    public String verifyUser(@ModelAttribute User user, BindingResult errors, Model model) {
        model.addAttribute("users", userRepository.findAll());
        ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
        for(User user1: users)
            if(user1.getUsername().equals(user.getUsername()) && user1.getPassword().equals(user.getPassword())){
                if(user1.getRole().equals(user.getRole())){
                    users.add(0,user1);
                    userRepository.deleteAll();
                    userRepository.saveAll(users);
                    model.addAttribute("users", users);
                    System.out.println("aici ok");
                    System.out.println(user);
                    if(user.getRole().equals("user")){

                        return getBooksMain(model);

                    }

                    if(user.getRole().equals("admin")){
                        System.out.println("admin");
                        return getBooksAdmin(model);
                    }


                }

            }
        System.out.println(String.valueOf(user.getRole()));
        return getLogin(model);
    }


    @RequestMapping(value = "/searchBooks", method = RequestMethod.POST)
    public String searchBooks(@ModelAttribute Book book, BindingResult errors, Model model) {
        ArrayList<Book> booksFound = new ArrayList<>();
        ArrayList<Book> books = (ArrayList<Book>) bookRepository.findAll();
        for(Book book1: books)
            if(book1.getTitle().contains(book.getTitle()))
                booksFound.add(book1);
        if(booksFound.size() == 0)
            return "books/nothingFound";
        model.addAttribute("booksFound", booksFound);
        return "books/foundBooks";
    }

    @RequestMapping(value = "/account/searchBooksAccount", method = RequestMethod.POST)
    public String searchBooksAccount(@ModelAttribute Book book, BindingResult errors, Model model) {
        ArrayList<Book> booksFound = new ArrayList<>();
        ArrayList<Book> books = (ArrayList<Book>) bookRepository.findAll();
        for(Book book1: books)
            if(book1.getTitle().contains(book.getTitle()))
                booksFound.add(book1);
        if(booksFound.size() == 0)
            return "books/nothingFound";
        model.addAttribute("booksFound", booksFound);
        return "account/foundBooksAccount";
    }
    @RequestMapping(value = "/seeInfo", method = RequestMethod.POST)
    public String seeInfo(@ModelAttribute User user, Model model){
        return getInfoAccount(model);
    }

    @RequestMapping("/account/info") // pt link
    public String getInfoAccount(Model model){
        ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
        model.addAttribute("users",users.get(0));
        return "account/info";
    }

    @RequestMapping("/account/login")
    public String getLogin(Model model){
        return "account/login";
    }

    @RequestMapping("/loginRead")
    public String getLoginRead(Model model){
        return "loginRead";
    }

    @RequestMapping("/account/create")
    public String getCreate(Model model){
        return "account/create";
    }

    @RequestMapping("/mainAccount") // pt link
    public static String getBooksMain2(Model model){

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

        ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
        model.addAttribute("users", users.get(0));

        return "mainAccount";
    }

    @RequestMapping("/account/mainAccount") // pt link
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

        ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
        model.addAttribute("users", users.get(0));

        return "account/mainAccount";
    }
}

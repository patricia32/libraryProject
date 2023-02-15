package libraryproject.springframework.libraryproject.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//    private final BookRepository bookRepository;
//
//    public HelloWorldController(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//    @RequestMapping()
//    public String HelloWorldControllerm(Model model) throws IOException {
//        //BookController bookController = new BookController(BookController.bookRepository);
//        StringBuilder html = new StringBuilder();
//        FileReader file = new FileReader("src\\main\\resources\\templates\\mainAccount.html");
//       // bookController.getBooksMain(model);
//
//        model.addAttribute("main", file);
//        model.addAttribute("books", BookController.bookRepository.findAll());
//        try {
//            BufferedReader br = new BufferedReader(file);
//            String val;
//            while ((val = br.readLine()) != null)
//                html.append(val);
//            br.close();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//       // return html.toString();
//        return BookController.getBooksMain(model);
//    }
}





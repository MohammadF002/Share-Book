package ir.sharif.sharebook.ap.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping(value = "/add")
    public Integer addBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook).getId();
    }

    @GetMapping(value = "/search")
    public Iterable<Book> findBook(@RequestParam String type, @RequestParam String name) {
        if (type.equals("Author"))
            return bookRepository.findBookByAuthorContaining(name);
        return bookRepository.findBookByNameContaining(name);
    }

    @GetMapping(value = "/{book_id}/get-information")
    public Book getBook(@PathVariable(value = "book_id") final Integer bookId) {
        Book book;
        Optional<Book> b = bookRepository.findBookById(bookId);
        if (b.isEmpty())
            return null;
        book = b.get();
        return book;
    }

}

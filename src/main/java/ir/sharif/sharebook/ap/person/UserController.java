package ir.sharif.sharebook.ap.person;

import ir.sharif.sharebook.ap.book.Book;
import ir.sharif.sharebook.ap.book.BookRepository;
import ir.sharif.sharebook.ap.purchase.Purchase;
import ir.sharif.sharebook.ap.purchase.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;


    @PostMapping(value = "/create")
    public Integer createUser(@RequestBody User user) {
        return userRepository.save(user).getId();
    }

    @PostMapping(value = "/charge/{user_id}")
    public String chargeAccount(@PathVariable String user_id, @RequestParam Integer amount) {
        Optional<User> u = userRepository.findById(Integer.parseInt(user_id));
        if (u.isEmpty())
            return "No user with this Id exists.";
        User user = u.get();
        user.chargeAccount(amount);
        userRepository.save(user);
        return "User account charged";
    }

    @PostMapping(value = "/add-book")
    public String addBookToBasket(@RequestParam Integer book_id, @RequestParam Integer user_id) {
        var b = bookRepository.findBookById(book_id);
        var u = userRepository.findUserById(user_id);
        if (b.isEmpty())
            return "No book with this Id exits.";
        if (u.isEmpty())
            return "No user with this Id exists.";
        var book = b.get();
        var user = u.get();
        if (book.isInBasket())
            return "The book is already in a basket.";
        if (user.getAccountBalance() - user.getBasketPrice() < book.getPrice())
            return "Not enough money.";
        book.setInBasket(true);
        book.setUser(user);
        bookRepository.save(book);
        return "Book added successfully.";
    }

    @GetMapping(value = "/purchase/{user_id}")
    public String purchase(@PathVariable String user_id) {
        var u = userRepository.findById(Integer.parseInt(user_id));
        if (u.isEmpty())
            return "No user exists with this Id";
        var user = u.get();
        if (user.getShoppingBasket().isEmpty())
            return "Your basket is empty.";
        Purchase purchase = new Purchase();
        purchase.setPrice(user.getBasketPrice());
        purchase.setUser(user);
        purchaseRepository.save(purchase);
        for (Book book : user.getShoppingBasket()){
            book.setOrder(purchase);
            bookRepository.save(book);
        }
        user.purchase();
        userRepository.save(user);
        return "Purchased successfully.";
    }

    @GetMapping(value = "/history/{user_id}")
    public Iterable<Purchase> viewHistory(@PathVariable String user_id) {
        var u = userRepository.findById(Integer.parseInt(user_id));
        if (u.isEmpty())
            return null;
        return u.get().getPurchasedBooks();
    }

    @PostMapping(value = "/update-profile/{user_id}")
    public String updateProfile(@RequestBody User newUser,
                                @PathVariable(name = "user_id") Integer userId) {
        var u = userRepository.findById(userId);
        if (u.isEmpty())
            return "No user with this Id exists.";
        User user = u.get();
        user.setEmailAddress(newUser.getEmailAddress());
        user.setFamilyName(newUser.getFamilyName());
        user.setFirstName(newUser.getFirstName());
        user.setPassword(newUser.getPassword());
        user.setUsername(newUser.getUsername());
        user.setPhoneNumber(newUser.getPhoneNumber());
        userRepository.save(user);
        return "User profile updated successfully.";
    }
}

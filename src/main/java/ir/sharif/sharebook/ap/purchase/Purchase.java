package ir.sharif.sharebook.ap.purchase;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.sharif.sharebook.ap.book.Book;
import ir.sharif.sharebook.ap.person.User;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy = "purchase")
    private Set<Book> books;
    private Integer price;
    private Boolean done = false;

    public Purchase() {}

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}

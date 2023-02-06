package ir.sharif.sharebook.ap.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.sharif.sharebook.ap.purchase.Purchase;
import ir.sharif.sharebook.ap.person.User;
import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    @ManyToOne
    @JsonIgnore
    private Purchase purchase;
    @ManyToOne
    @JsonIgnore
    private User user;
    private String author;
    private int price;
    private String summary;
    private Date publicationDate;
    private String translator;
    private String publication;
    private BookState bookState;
    private Category category;
    private int pages;
    private Language language;

    private boolean inBasket=false;

    public Book(String name, String author, int price, String summary, Date publicationDate, String translator,
                String publication, BookState bookState, Category category, int pages, Language language) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.summary = summary;
        this.publicationDate = publicationDate;
        this.translator = translator;
        this.publication = publication;
        this.bookState = bookState;
        this.category = category;
        this.pages = pages;
        this.language = language;
    }

    public Book() {}

    public Integer getId() {
        return id;
    }
    public int getPrice() {
        return price;
    }
    public boolean isInBasket() {
        return inBasket;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getSummary() {
        return summary;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getTranslator() {
        return translator;
    }

    public String getPublication() {
        return publication;
    }

    public BookState getBookState() {
        return bookState;
    }

    public Category getCategory() {
        return category;
    }

    public int getPages() {
        return pages;
    }

    public Language getLanguage() {
        return language;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public void setBookState(BookState bookState) {
        this.bookState = bookState;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrder(Purchase purchase) {
        this.purchase = purchase;
    }

    public void setInBasket(boolean inBasket) {
        this.inBasket = inBasket;
    }
}

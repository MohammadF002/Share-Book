package ir.sharif.sharebook.ap.person;

import ir.sharif.sharebook.ap.book.Book;
import ir.sharif.sharebook.ap.purchase.Purchase;
import jakarta.persistence.*;


import java.util.Set;
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;
    private Integer accountBalance = 0;
    @OneToMany(mappedBy = "user")
    private Set<Purchase> purchaseHistory;
    @OneToMany(mappedBy = "user")
    private Set<Book> shoppingBasket;
    private int basketPrice = 0;


    private String firstName;
    private String familyName;
    private String phoneNumber;
    private String emailAddress;
    private String password;
    private String username;


    public User(String firstName1, String familyName1, String phoneNumber1, String emailAddress1,
                String password1, String username1) {
        this.firstName = firstName1;
        this.familyName = familyName1;
        this.phoneNumber = phoneNumber1;
        this.emailAddress = emailAddress1;
        this.password = password1;
        this.username = username1;
    }

    public User() {}

    public void chargeAccount(int amount) {
        this.accountBalance += amount;
    }

    public void purchase() {
        this.accountBalance -= this.basketPrice;
        this.basketPrice = 0;
    }
    public Integer getAccountBalance() {
        return accountBalance;
    }
    public Integer getBasketPrice() {
        return basketPrice;
    }
    public Set<Book> getShoppingBasket() {
        return shoppingBasket;
    }

    public Set<Purchase> getPurchasedBooks() {
        return purchaseHistory;
    }

    public Integer getId() {
        return Id;
    }

    public Set<Purchase> getOrderHistory() {
        return purchaseHistory;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Set<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(Set<Purchase> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public void setShoppingBasket(Set<Book> shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }

    public void setBasketPrice(int basketPrice) {
        this.basketPrice = basketPrice;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

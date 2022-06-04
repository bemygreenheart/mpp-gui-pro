package uz.group.mppguiproject.entity;

import java.time.LocalDate;

public class CheckoutEntry {

    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private User user;
    private BookCopy bookCopy;

    public CheckoutEntry(LocalDate checkoutDate, LocalDate dueDate, LocalDate returnDate, User user, BookCopy bookCopy) {
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.user = user;
        this.bookCopy = bookCopy;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public User getUser() {
        return user;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }
}

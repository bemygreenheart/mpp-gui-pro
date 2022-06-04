package uz.group.mppguiproject.entity;

public enum CheckoutLength {
    WEEK(7),
    THREE_WEEKS(21);

    private int days;

    CheckoutLength(int days) {
        this.days = days;
    }
}

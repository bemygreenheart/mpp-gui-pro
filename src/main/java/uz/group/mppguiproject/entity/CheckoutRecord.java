package uz.group.mppguiproject.entity;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
    private List<CheckoutEntry> checkoutEntries;

    public CheckoutRecord() {
        this.checkoutEntries = new ArrayList<>();
    }

    public void addCheckoutEntry(CheckoutEntry entry){
        this.checkoutEntries.add(entry);
    }

    public boolean remove(CheckoutEntry entry){
        return this.checkoutEntries.remove(entry);
    }
}

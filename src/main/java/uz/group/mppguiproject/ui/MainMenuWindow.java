package uz.group.mppguiproject.ui;

import org.springframework.stereotype.Component;
import uz.group.mppguiproject.config.WindowConfig;
import uz.group.mppguiproject.entity.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class MainMenuWindow extends JFrame implements Drawable {

    public void draw() {
        Role userRole = Role.BOTH;
        this.setSize(WindowConfig.WIDTH, WindowConfig.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        WindowConfig.centerFrameOnDesktop(this);

        String message = "Welcome ";
        switch (userRole) {
            case ADMIN -> message += "Admin";
            case LIBRARIAN -> message += "Librarian";
            case BOTH -> message += "Super Admin";
        }
        this.setTitle(message);

        drawButtonsView(userRole);
    }

    private JButton getButton(String label, ActionListener listener){
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setForeground(Color.GREEN);
        button.setHorizontalAlignment(SwingConstants.CENTER);

        return button;
    }

    private void drawButtonsView(Role role) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        for(JButton button: getButtons(role)) {
            panel.add(button);
        }
        SpringLayout layout = new SpringLayout();
        Container mainPanel = getContentPane();
        mainPanel.setLayout(layout);
        mainPanel.add(panel);
        layout.putConstraint(SpringLayout.NORTH, panel, 100, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, panel, -100, SpringLayout.SOUTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, panel, 200, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST, panel, -200, SpringLayout.EAST, mainPanel);
    }

    private java.util.List<JButton> getButtons(Role role) {
        List<JButton> buttons = new ArrayList<JButton>();

        JButton checkoutBookBtn = getButton("Checkout Book", ev -> {
            CheckoutBookWindow checkoutBookWindow = new CheckoutBookWindow();
            this.dispose();
            checkoutBookWindow.setVisible(true);
            checkoutBookWindow.draw();
        });

        JButton printCheckoutRecordBtn = getButton("Print Checkout Record", ev -> {
            CheckoutEntryRecordWindow checkoutEntryRecordWindow = new CheckoutEntryRecordWindow();
            this.dispose();
            checkoutEntryRecordWindow.setVisible(true);
            checkoutEntryRecordWindow.draw();
        });

        JButton addMemberBtn = getButton("Add Member", ev -> {
            AddMemberWindow addMemberWindow = new AddMemberWindow();
            this.dispose();
            addMemberWindow.setVisible(true);
            addMemberWindow.draw();
        });

        JButton addBookBtn = getButton("Add Book", ev -> {
            AddBookWindow addBookWindow = new AddBookWindow();
            this.dispose();
            addBookWindow.setVisible(true);
            addBookWindow.draw();
        });

        JButton addBookCopyBtn = getButton("Add Book Copy", ev -> {
            AddBookCopyWindow addBookCopyWindow = new AddBookCopyWindow();
            this.dispose();
            addBookCopyWindow.setVisible(true);
            addBookCopyWindow.draw();
        });

        if(role != null){
            switch (role) {
                case ADMIN -> buttons = Arrays.asList(addMemberBtn, addBookBtn, addBookCopyBtn);
                case LIBRARIAN -> buttons = Arrays.asList(checkoutBookBtn, printCheckoutRecordBtn);
                case BOTH -> buttons = Arrays.asList(addMemberBtn, addBookBtn, addBookCopyBtn, checkoutBookBtn, printCheckoutRecordBtn);
            }
        }
        return buttons;
    }
}

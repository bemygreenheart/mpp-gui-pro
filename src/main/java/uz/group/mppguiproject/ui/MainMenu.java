package uz.group.mppguiproject.ui;

import org.springframework.stereotype.Component;
import uz.group.mppguiproject.config.WindowConfig;
import uz.group.mppguiproject.entity.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

@Component
public class MainMenu extends JFrame implements Drawable{

    public void draw(){
        this.setSize(WindowConfig.WIDTH, WindowConfig.HEIGHT);
        this.setLayout(new BorderLayout());
//        drawTopSearchbar();

    }

    private JButton getButton(String label, ActionListener listener){
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setForeground(Color.GREEN);
        button.setHorizontalAlignment(SwingConstants.CENTER);

        return button;
    }

    private java.util.List<JButton> getButtons(Role role){
        JButton checkoutBookBtn = getButton("Check Book", ev -> {
            System.out.println("Check Book Pressed");
        });

        JButton printCheckoutRecordBtn = getButton("Check Book", ev -> {
            System.out.println("Check Book Pressed");
        });

        JButton addMemberBtn = getButton("Add Member", ev -> {
            System.out.println("Check Book Pressed");
        });

        JButton addBookBtn = getButton("Add Book", ev -> {
            System.out.println("Check Book Pressed");
        });

        JButton addBookCopyBtn = getButton("Add Book Copy", ev -> {
            System.out.println("Check Book Pressed");
        });

        if(role != null){

            switch (role){
//                case Role.ADMIN -> Arrays.asList(addMemberBtn, addBookBtn, addBookCopyBtn);
//                case Role.LIBRARIAN -> Arrays.asList(checkoutBookBtn, printCheckoutRecordBtn);
//                case Role.ADMIN -> Arrays.asList(addMemberBtn, addBookBtn, addBookCopyBtn, checkoutBookBtn, printCheckoutRecordBtn);
            }
        }
        return Collections.emptyList();
    }
}

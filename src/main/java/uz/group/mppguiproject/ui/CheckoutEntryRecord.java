package uz.group.mppguiproject.ui;

import org.springframework.stereotype.Component;
import uz.group.mppguiproject.config.WindowConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Component
public class CheckoutEntryRecord extends JFrame implements Drawable{

    private JTextField idField;
    public void draw(){
        idField = new JTextField();
        this.setSize(WindowConfig.WIDTH, WindowConfig.HEIGHT);
        this.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new GridLayout(1, 1, WindowConfig.MGAP, WindowConfig.LGAP));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(WindowConfig.LGAP, WindowConfig.LGAP, WindowConfig.LGAP, WindowConfig.LGAP));
        this.add(mainPanel, BorderLayout.CENTER);
        drawTopSearchbar();

    }

    private void drawTopSearchbar(){
        JPanel panel = new JPanel(new GridLayout(1, 3, WindowConfig.SGAP, WindowConfig.LGAP));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 150, 10, 150));
        panel.setBackground(new Color(200, 200, 200));
        panel.add(new JLabel("Enter member id:"));
        panel.add(idField);
        JButton button = getButton("Search", ev -> {

        });
        panel.add(button);

        this.add(panel, BorderLayout.NORTH);
    }

    private JButton getButton(String label, ActionListener listener){
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setForeground(Color.GREEN);
        button.setHorizontalAlignment(SwingConstants.CENTER);

        return button;
    }

    private void drawTable(JPanel mainPanel){
//        id, name, checkoutDate, dueDate, return Date
    }
}

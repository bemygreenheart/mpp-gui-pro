package uz.group.mppguiproject.ui;

import org.springframework.stereotype.Component;
import uz.group.mppguiproject.config.WindowConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
public class CheckoutBookWindow extends JFrame implements Drawable{

    private Map<String, JTextField> fields = new HashMap<>();

    public void draw(){
        this.setSize(WindowConfig.WIDTH, WindowConfig.HEIGHT);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Checkout Book");
        WindowConfig.centerFrameOnDesktop(this);

        SpringLayout layout = new SpringLayout();
        JPanel container = new JPanel();
        container.setLayout(layout);
        this.add(container);

        JButton backButton = getButton("<Back");
        container.add(backButton);
        layout.putConstraint(SpringLayout.NORTH, backButton, 8, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, backButton, 50, SpringLayout.WEST, container);
        backButton.addActionListener(e -> {
            Router.getInstance().openMainWindow(this);
        });

        JButton addButton = getButton("Checkout Book", ev -> {
            boolean isValid = validateFields();

            if(isValid){
                //
            }
        });
        container.add(addButton);
        layout.putConstraint(SpringLayout.SOUTH, addButton, -20, SpringLayout.SOUTH, container);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, addButton, 0, SpringLayout.HORIZONTAL_CENTER, container);

        JPanel mainPanel = new JPanel(new GridLayout(2, 1, WindowConfig.MGAP, WindowConfig.LGAP));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(WindowConfig.LGAP, WindowConfig.LGAP, WindowConfig.LGAP, WindowConfig.LGAP));
        container.add(mainPanel);

        layout.putConstraint(SpringLayout.NORTH, mainPanel, 8, SpringLayout.SOUTH, backButton);
        layout.putConstraint(SpringLayout.SOUTH, mainPanel, -30, SpringLayout.NORTH, addButton);
        layout.putConstraint(SpringLayout.WEST, mainPanel, 50, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.EAST, mainPanel, -50, SpringLayout.EAST, container);

        drawSectionedPanel(mainPanel, "Checkout Book", new String[] {"MemberId", "Book ISBN"});
    }

    private void drawSectionedPanel(JPanel panel, String sectionLabel, String[] fields){
        JPanel section = new JPanel(new GridLayout(2, 1, 0, WindowConfig.LGAP));//Insert Gap to correct style

        JLabel label = new JLabel(sectionLabel);
        label.setFont(new Font("Monaco", Font.BOLD, WindowConfig.HEADER));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        section.add(label);

//        Create fields
        JPanel formPanel = new JPanel(new GridLayout(1, fields.length, WindowConfig.SGAP,  WindowConfig.MGAP));
        for(String field : fields){
            formPanel.add(getTextInputContainer(field));
        }
        section.add(formPanel);

        panel.add(section);
    }

    private Container getTextInputContainer(String name){
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(2, 1, WindowConfig.SGAP, WindowConfig.SGAP));
        JTextField field = new JTextField();

//        Make input field controlled
        fields.put(name.toLowerCase(Locale.ROOT).replace(" ", "_"), field);

        JLabel label = new JLabel(name);
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        container.add(label);
        container.add(field);

        return container;
    }

    private JButton getButton(String label){
        JButton button = new JButton(label);
        return button;
    }

    private JButton getButton(String label, ActionListener listener){
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setForeground(Color.GREEN);
        return button;
    }

    private boolean validateFields(){
        for(var entry:  fields.entrySet()){
            if(entry.getValue().getText().isEmpty()){
                showMessage(entry.getKey() + " can not be empty");
                return false;
            }
        }
        return true;
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

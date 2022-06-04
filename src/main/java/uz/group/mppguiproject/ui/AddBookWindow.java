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
public class AddBookWindow extends JFrame implements Drawable{

    private Map<String, JTextField> fields = new HashMap<>();

    public void draw(){
        this.setSize(WindowConfig.WIDTH, WindowConfig.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Add Book");
        WindowConfig.centerFrameOnDesktop(this);
        this.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new GridLayout(2, 1, WindowConfig.MGAP, WindowConfig.LGAP));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(WindowConfig.LGAP, WindowConfig.LGAP, WindowConfig.LGAP, WindowConfig.LGAP));
        this.add(mainPanel, BorderLayout.CENTER);

        drawSectionedPanel( mainPanel, "Add Book", new String[] {"Title", "ISBN", "Author"});
        drawButton("Add Book", ev -> {
            boolean isValid = validateFields();

            if(isValid){
                //
            }
        });
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

    private void drawButton(String label, ActionListener listener){
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setForeground(Color.GREEN);
        button.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(button, BorderLayout.SOUTH);
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

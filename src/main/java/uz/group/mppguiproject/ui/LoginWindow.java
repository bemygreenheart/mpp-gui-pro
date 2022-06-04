package uz.group.mppguiproject.ui;

import org.springframework.stereotype.Component;
import uz.group.mppguiproject.config.Session;
import uz.group.mppguiproject.config.WindowConfig;
import uz.group.mppguiproject.utils.ControllerInterface;
import uz.group.mppguiproject.utils.LoginException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
public class LoginWindow extends JFrame implements Drawable{
    private Map<String, JTextField> fields = new HashMap<>();

    private final Session session;
    private final ControllerInterface controller;

    public LoginWindow(Session session, ControllerInterface controller) {
        this.session = session;
        this.controller = controller;
    }

    public void draw(){
        this.setSize(WindowConfig.WIDTH, WindowConfig.HEIGHT);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        WindowConfig.centerFrameOnDesktop(this);
        JPanel mainPanel = new JPanel(new GridLayout(2, 1, WindowConfig.MGAP, WindowConfig.LGAP));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(WindowConfig.LGAP, WindowConfig.LGAP, WindowConfig.LGAP, WindowConfig.LGAP));
        this.add(mainPanel, BorderLayout.CENTER);

        drawSectionedPanel(mainPanel, "Login Page", new String[] {"Username", "Password"});
        drawBottomButtons(mainPanel);
    }

    private void drawSectionedPanel(JPanel panel, String sectionLabel, String[] fields){
        JPanel section = new JPanel(new GridLayout(2, 1, 0, WindowConfig.LGAP));//Insert Gap to correct style

        JLabel label = new JLabel(sectionLabel);
        label.setFont(new Font("Monaco", Font.BOLD, WindowConfig.HEADER));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        section.add(label);

//        Create fields
        JPanel formPanel = new JPanel(new GridLayout(1, fields.length, WindowConfig.LGAP,  WindowConfig.MGAP));
        for(String field : fields){
            formPanel.add(getTextInputContainer(field));
        }
        section.add(formPanel);

        panel.add(section);
    }

    private Container getTextInputContainer(String name){
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(2, 1, WindowConfig.LGAP, WindowConfig.SGAP));
        JTextField field = new JTextField();

//        Make input field controlled
        fields.put(name.toLowerCase(Locale.ROOT).replace(" ", "_"), field);

        JLabel label = new JLabel(name);
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        container.add(label);
        container.add(field);

        return container;
    }

    private void drawBottomButtons(JPanel mainPanel){
        JPanel panel = new JPanel(new GridLayout(1, 2, WindowConfig.LGAP, WindowConfig.LGAP));
        panel.setBorder(BorderFactory.createEmptyBorder(85, 0, 85, 0));
        JButton cancelBtn = getButton("Cancel", Color.RED, ev -> {
            dispose();
        });
        panel.add(cancelBtn);

        JButton submitBtn = getButton("Log In", Color.GREEN, ev -> {
            onSubmitButtonClicked();
        });
        panel.add(submitBtn);

        mainPanel.add(panel);
    }

    private JButton getButton(String label, Color color, ActionListener listener){
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setForeground(color);
        return button;
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private void onSubmitButtonClicked() {
        String userName = fields.get("username").getText();
        String password = fields.get("password").getText();
        if ((userName == null || userName.strip().length() == 0) &&
                (password == null || password.strip().length() == 0)) {
            showMessage("Please enter the username and password.\n");
        } else if (userName == null || userName.strip().length() == 0) {
            showMessage("Please enter the username.\n");
        } else if (password == null || password.strip().length() == 0) {
            showMessage("Please enter the password.\n");
        } else {
            try{
                controller.login(userName, password);
                Router.getInstance().openMainWindow(this);
            }catch(LoginException ex){
                showMessage(ex.getMessage() + "\n");
            }

        }
    }
}

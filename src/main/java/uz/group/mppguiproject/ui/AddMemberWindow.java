package uz.group.mppguiproject.ui;

import org.springframework.stereotype.Component;
import uz.group.mppguiproject.config.WindowConfig;
import uz.group.mppguiproject.entity.Address;
import uz.group.mppguiproject.entity.Role;
import uz.group.mppguiproject.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AddMemberWindow extends JFrame implements Drawable{

//    @Autowired
//    private PersonRepository personRepository;

    private Map<String, JTextField> fields = new HashMap<>();
    private JComboBox roleList;
    private JLabel warningLabel;

    public void draw(){
        this.setSize(WindowConfig.WIDTH, WindowConfig.HEIGHT);
        this.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new GridLayout(2, 1, WindowConfig.MGAP, WindowConfig.LGAP));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(WindowConfig.LGAP, WindowConfig.LGAP, WindowConfig.LGAP, WindowConfig.LGAP));
        this.add(mainPanel, BorderLayout.CENTER);

        drawTopWarningLabel();
        drawSectionedPanel( mainPanel, "Personal Info", new String[] {"Member ID", "First Name", "Last Name", "Phone"});
        drawSectionedPanel(mainPanel, "Address Info", new String[] {"State", "City", "Street", "Zip"});
        drawLowSubmitBar();

    }

    private void drawTopWarningLabel(){
        warningLabel = new JLabel("Please enter all values");
        warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
        warningLabel.setForeground(Color.RED);
        warningLabel.setVisible(false);
        this.add(warningLabel, BorderLayout.NORTH);
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

    private void drawLowSubmitBar(){
        String[] roles = { "None", "Librarian", "Admin", "Both" };
        roleList = new JComboBox(roles);
        roleList.setSelectedIndex(0);

        JPanel panel = new JPanel(new GridLayout(1, 2, WindowConfig.LGAP, WindowConfig.MGAP));
        panel.add(roleList);

        JButton button = getButton("Create Member", ev -> {
            if(!validateFields()){
                System.out.println("Working");
                warningLabel.setVisible(true);
            }else {
                warningLabel.setVisible(false);
                Map<String, String> values = fields.entrySet()
                        .stream()
                        .collect(Collectors.toMap(Map.Entry::getKey,
                                e -> e.getValue().getText()));

                int index = roleList.getSelectedIndex();
                Role role = null;

                if (!roles[index].isEmpty() && !roles[index].equals("None")) {
                    role = Role.valueOf(roles[index].toUpperCase(Locale.ROOT));
                }
                Address address = new Address(values.get("street"), values.get("city"), values.get("state"), values.get("zip"));
//            Save the address
                User user = new User(
                        values.get("member_id"),
                        role,
                        values.get("first_name"),
                        values.get("last_name"),
                        values.get("phone"),
                        address
                );
//            Save the user
                System.out.println(user);
            }
        });

        panel.add(button);
        this.add(panel, BorderLayout.SOUTH);
    }

    private boolean validateFields(){
        boolean isValid = true;
        isValid = !fields.values().stream().map(e -> e.getText()).anyMatch(s -> s.isEmpty());

        return isValid;
    }

    private JButton getButton(String label){
        JButton button = new JButton(label);
        return button;
    }

    private JButton getButton(String label, ActionListener listener){
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setBorderPainted(false);
        button.setBackground(Color.GREEN);
        return button;
    }
}

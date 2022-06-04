package uz.group.mppguiproject.ui;

import org.springframework.stereotype.Component;
import uz.group.mppguiproject.config.WindowConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;

@Component
public class CheckoutEntryRecordWindow extends JFrame implements Drawable{

    private JTextField idField;

    private final String[] columns = {"ID", "Name", "Checkout Date", "Due Date", "Return Date" };

    private final String[][] datas = {
            {"3001", "The Big Fish", "2022-06-02", "2022-06-10", "2022-06-04" },
            {"3002", "Antartica", "2022-06-02", "2022-06-12", "2022-06-03" },
            {"3004", "Thinking Java", "2022-06-02", "2022-07-02", "2022-06-03" },
            {"3007", "Jimmy's First Day of School", "2022-06-02", "2022-07-02", "2022-06-04" }
    };
    private final DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    public void draw(){
        idField = new JTextField(12);
        this.setSize(WindowConfig.WIDTH, WindowConfig.HEIGHT);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Checkout Entry Record");
        WindowConfig.centerFrameOnDesktop(this);

        JPanel mainPanel = new JPanel(new GridLayout(2, 1, WindowConfig.MGAP, WindowConfig.LGAP));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(WindowConfig.LGAP, WindowConfig.LGAP, WindowConfig.LGAP, WindowConfig.LGAP));
        this.add(mainPanel, BorderLayout.CENTER);
        drawTopSearchbar();
        drawTable(mainPanel);

        SpringLayout layout = new SpringLayout();
        JPanel container = new JPanel();
        container.setLayout(layout);
        mainPanel.add(container);

        JButton backButton = getButton("<Back");
        container.add(backButton);
        layout.putConstraint(SpringLayout.SOUTH, backButton, 0, SpringLayout.SOUTH, container);
        layout.putConstraint(SpringLayout.WEST, backButton, 10, SpringLayout.WEST, container);
        backButton.addActionListener(e -> {
            Router.getInstance().openMainWindow(this);
        });
    }

    private void drawTopSearchbar(){
        JPanel panel = new JPanel(new GridLayout(1, 3, WindowConfig.SGAP, WindowConfig.LGAP));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 150, 10, 150));
        panel.setBackground(new Color(200, 200, 200));
        panel.add(new JLabel("Enter member id:"));
        panel.add(idField);
        JButton button = getButton("Search", ev -> {
            for (int d = 0; d < datas.length; d++) {
                addTableRecord(datas[d]);
            }
        });
        panel.add(button);

        this.add(panel, BorderLayout.NORTH);
    }

    private JButton getButton(String label){
        JButton button = new JButton(label);
        return button;
    }

    private JButton getButton(String label, ActionListener listener){
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setForeground(Color.GREEN);
        button.setHorizontalAlignment(SwingConstants.CENTER);

        return button;
    }

    private void drawTable(JPanel mainPanel){
        JScrollPane scrollPane = new JScrollPane();
        mainPanel.add(scrollPane);
        JTable table = new JTable(tableModel);
        table.setEnabled(false);
        table.setDragEnabled(false);
        scrollPane.setViewportView(table);
    }

    private void addTableRecord(String[] entries) {
        tableModel.addRow(entries);
    }
}

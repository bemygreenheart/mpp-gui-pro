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

    private final String[] columns = {  "ID", "Name", "Checkout Date", "Due Date", "Return Date" };
    private final DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    public void draw(){
        idField = new JTextField();
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
    }

    private void drawTopSearchbar(){
        JPanel panel = new JPanel(new GridLayout(1, 3, WindowConfig.SGAP, WindowConfig.LGAP));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 150, 10, 150));
        panel.setBackground(new Color(200, 200, 200));
        panel.add(new JLabel("Enter member id:"));
        panel.add(idField);
        JButton button = getButton("Search", ev -> {
            addTableRecord(new String[]{"1", "2", "1", "2", "3","4"});
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

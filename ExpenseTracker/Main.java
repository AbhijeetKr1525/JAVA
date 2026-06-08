import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    private JFrame frame;
    private JTextField amountField, categoryField, dateField, searchField;
    private JComboBox<String> typeBox;
    private JTable table;
    private DefaultTableModel model;
    private JLabel totalLabel;

    private ArrayList<Expense> expenseList;

    public Main() {

        // ✅ Load data
        expenseList = FileHandler.loadExpenses();

        frame = new JFrame("Expense Tracker");
        frame.setSize(800, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(245, 247, 250));

        // ================== SEARCH PANEL (TOP) ==================
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(new Color(245, 247, 250));

        searchField = new JTextField(20);
        JButton searchBtn = new JButton("Search");

        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);

        frame.add(searchPanel, BorderLayout.NORTH);

        // ================== FORM PANEL (LEFT) ==================
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 247, 250));
        panel.setPreferredSize(new Dimension(300, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font font = new Font("Arial", Font.BOLD, 14);

        // Amount
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel l1 = new JLabel("Amount:");
        l1.setFont(font);
        panel.add(l1, gbc);

        gbc.gridx = 1;
        amountField = new JTextField(15);
        panel.add(amountField, gbc);

        // Category
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel l2 = new JLabel("Category:");
        l2.setFont(font);
        panel.add(l2, gbc);

        gbc.gridx = 1;
        categoryField = new JTextField(15);
        panel.add(categoryField, gbc);

        // Type
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel l3 = new JLabel("Type:");
        l3.setFont(font);
        panel.add(l3, gbc);

        gbc.gridx = 1;
        typeBox = new JComboBox<>(new String[]{"Income", "Expense"});
        panel.add(typeBox, gbc);

        // Date
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel l4 = new JLabel("Date:");
        l4.setFont(font);
        panel.add(l4, gbc);

        gbc.gridx = 1;
        dateField = new JTextField("dd-mm-yyyy");
        panel.add(dateField, gbc);

        // Buttons
        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");

        addBtn.setBackground(new Color(76, 175, 80));
        addBtn.setForeground(Color.WHITE);

        deleteBtn.setBackground(new Color(229, 57, 53));
        deleteBtn.setForeground(Color.WHITE);

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(new Color(245, 247, 250));
        btnPanel.add(addBtn);
        btnPanel.add(deleteBtn);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panel.add(btnPanel, gbc);

        // Total
        totalLabel = new JLabel("Balance: ₹0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));

        gbc.gridy = 5;
        panel.add(totalLabel, gbc);

        // ================== TABLE 
        model = new DefaultTableModel();
        model.addColumn("Amount");
        model.addColumn("Category");
        model.addColumn("Type");
        model.addColumn("Date");

        table = new JTable(model);
        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);

        // CENTER PANEL
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(panel, BorderLayout.WEST);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(centerPanel, BorderLayout.CENTER);

        // ================== LOAD DATA ==================
        loadTable();

        // ================== ADD ==================
        addBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String category = categoryField.getText();
                String type = (String) typeBox.getSelectedItem();
                String date = dateField.getText();

                Expense exp = new Expense(amount, category, type, date);
                expenseList.add(exp);

                model.addRow(new Object[]{amount, category, type, date});

                FileHandler.saveExpenses(expenseList);
                updateTotal();

                amountField.setText("");
                categoryField.setText("");
                dateField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input");
            }
        });

        // ================== DELETE ==================
        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();

            if (row != -1) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Delete?");
                if (confirm == JOptionPane.YES_OPTION) {
                    expenseList.remove(row);
                    model.removeRow(row);

                    FileHandler.saveExpenses(expenseList);
                    updateTotal();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Select a row");
            }
        });

        // ================== SEARCH ==================
        searchBtn.addActionListener(e -> {
            String keyword = searchField.getText().toLowerCase();

            model.setRowCount(0);

            for (Expense exp : expenseList) {
                if (exp.getCategory().toLowerCase().contains(keyword)) {
                    model.addRow(new Object[]{
                            exp.getAmount(),
                            exp.getCategory(),
                            exp.getType(),
                            exp.getDate()
                    });
                }
            }
        });

        frame.setVisible(true);
    }

    private void loadTable() {
        for (Expense e : expenseList) {
            model.addRow(new Object[]{
                    e.getAmount(),
                    e.getCategory(),
                    e.getType(),
                    e.getDate()
            });
        }
        updateTotal();
    }

    private void updateTotal() {
        double total = 0;

        for (Expense e : expenseList) {
            if (e.getType().equals("Income")) {
                total += e.getAmount();
            } else {
                total -= e.getAmount();
            }
        }

        totalLabel.setText("Balance: ₹" + total);
    }

    public static void main(String[] args) {
        new Main();
    }
} 




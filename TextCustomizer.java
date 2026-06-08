import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextCustomizer {
    public static void main(String[] args) {
        JFrame f = new JFrame("Text Customizer");

        JLabel label = new JLabel("Hello Java");
        label.setBounds(50, 50, 300, 50);

        String[] colors = {"Red", "Blue", "Green"};
        JComboBox<String> cbColor = new JComboBox<>(colors);

        String[] fonts = {"Serif", "SansSerif", "Monospaced"};
        JComboBox<String> cbFont = new JComboBox<>(fonts);

        String[] sizes = {"12", "18", "24"};
        JComboBox<String> cbSize = new JComboBox<>(sizes);

        cbColor.setBounds(50, 120, 100, 30);
        cbFont.setBounds(160, 120, 100, 30);
        cbSize.setBounds(270, 120, 100, 30);

        ActionListener update = e -> {
            String color = (String) cbColor.getSelectedItem();
            String font = (String) cbFont.getSelectedItem();
            int size = Integer.parseInt((String) cbSize.getSelectedItem());

            if (color.equals("Red")) label.setForeground(Color.RED);
            if (color.equals("Blue")) label.setForeground(Color.BLUE);
            if (color.equals("Green")) label.setForeground(Color.GREEN);

            label.setFont(new Font(font, Font.PLAIN, size));
        };

        cbColor.addActionListener(update);
        cbFont.addActionListener(update);
        cbSize.addActionListener(update);

        f.add(label); f.add(cbColor); f.add(cbFont); f.add(cbSize);
        f.setSize(450, 250);
        f.setLayout(null);
        f.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;

public class StudentForm {
    public static void main(String[] args) {
        JFrame f = new JFrame("STUDENT");
        f.setLayout(new GridLayout(7, 2));

        f.add(new JLabel("Roll No"));
        f.add(new JTextField());

        f.add(new JLabel("Name"));
        f.add(new JTextField());

        f.add(new JLabel("Course"));
        JPanel pCourse = new JPanel();
        pCourse.add(new JCheckBox("BCA"));
        pCourse.add(new JCheckBox("MCA"));
        f.add(pCourse);

        f.add(new JLabel("Gender"));
        JPanel pGender = new JPanel();
        JRadioButton m = new JRadioButton("Male");
        JRadioButton f1 = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(m); bg.add(f1);
        pGender.add(m); pGender.add(f1);
        f.add(pGender);

        f.add(new JLabel("Class"));
        f.add(new JTextField());

        f.add(new JLabel("Address"));
        f.add(new JTextField());

        f.getContentPane().setBackground(Color.LIGHT_GRAY);

        f.setSize(400, 300);
        f.setVisible(true);
    }
}

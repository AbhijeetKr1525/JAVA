import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class StudentForm5 extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    JTextArea area;

    Connection con;

    StudentForm5() {

        setTitle("Student Form");
        setSize(500,500);
        setLayout(null);

        l1 = new JLabel("ID");
        l1.setBounds(50,50,100,30);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(150,50,150,30);
        add(t1);

        l2 = new JLabel("Name");
        l2.setBounds(50,100,100,30);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(150,100,150,30);
        add(t2);

        l3 = new JLabel("Course");
        l3.setBounds(50,150,100,30);
        add(l3);

        t3 = new JTextField();
        t3.setBounds(150,150,150,30);
        add(t3);

        l4 = new JLabel("Marks");
        l4.setBounds(50,200,100,30);
        add(l4);

        t4 = new JTextField();
        t4.setBounds(150,200,150,30);
        add(t4);

        b1 = new JButton("Insert");
        b1.setBounds(50,260,100,30);
        add(b1);

        b2 = new JButton("Display");
        b2.setBounds(180,260,100,30);
        add(b2);

        area = new JTextArea();
        area.setBounds(50,320,350,100);
        add(area);

        b1.addActionListener(this);
        b2.addActionListener(this);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "YOUR_PASSWORD"
            );

        } catch(Exception e) {
            System.out.println(e);
        }

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {

        try {

            if(ae.getSource() == b1) {

                String query = "INSERT INTO Student VALUES(?,?,?,?)";

                PreparedStatement pst = con.prepareStatement(query);

                pst.setLong(1, Long.parseLong(t1.getText()));
                pst.setString(2, t2.getText());
                pst.setString(3, t3.getText());
                pst.setInt(4, Integer.parseInt(t4.getText()));

                pst.executeUpdate();

                JOptionPane.showMessageDialog(this,
                    "Data Inserted Successfully");
            }

            if(ae.getSource() == b2) {

                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery("SELECT * FROM Student");

                area.setText("");

                while(rs.next()) {

                    area.append(
                        rs.getLong(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getInt(4) + "\n"
                    );
                }
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        new StudentForm5();
    }
}

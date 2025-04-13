package universitymanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener {
    Choice croolNumber;

    JComboBox courseBox,departmentBox, semesterBox;

    JLabel totalAmount;
    JButton pay,update,back;

    StudentFeeForm(){
        getContentPane().setBackground(new Color(210,252,251));

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/fee.png"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400,50,500,300);
        add(img);



        JLabel roolNumber = new JLabel("Select Roll Number");
        roolNumber.setBounds(40,60,150,20);
        roolNumber.setFont(new Font("Tahoma",Font.BOLD,12));
        add(roolNumber);

        croolNumber = new Choice();
        croolNumber.setBounds(200,60,150,20);
        add(croolNumber);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from student");
            while (rs.next()){
                croolNumber.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(40,100,150,20);
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,150,20);
        add(textName);



        JLabel fname = new JLabel("Father Name");
        fname.setBounds(40,140,150,20);
        add(fname);

        JLabel textfName = new JLabel();
        textfName.setBounds(200,140,150,20);
        add(textfName);

        try {
            Conn c = new Conn();
            String query = "select * from student where rollno ='"+croolNumber.getSelectedItem()+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textfName.setText(resultSet.getString("fname"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        croolNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String Q = "select * from student where rollno ='"+croolNumber.getSelectedItem()+"'";
                    ResultSet rs = c.statement.executeQuery(Q);
                    while (rs.next()){
                        textName.setText(rs.getString("name"));
                        textfName.setText(rs.getString("fname"));

                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        JLabel Qulifictation = new JLabel("Course");
        Qulifictation.setBounds(40,180,150,20);
//        Qulifictation.setFont(new Font("Tahoma", Font.BOLD,10));
        add(Qulifictation);

        String course[] = {"BTech","BCA","BBA","BSC","BCOM","BA","MSC","MCA","MBA","MCOM","MA"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200,180,150,20);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);


        JLabel Department = new JLabel("Branch");
        Department.setBounds(40,220,150,20);
//        Department.setFont(new Font("Tahoma", Font.BOLD,16));
        add(Department);

        String department[] = {"Compuer Science","Electronics","Civil","IT"};
        departmentBox = new JComboBox(department);
        departmentBox.setBounds(200,220,150,20);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);

        JLabel textsemester = new JLabel("Semester");
        textsemester.setBounds(40,260,150,20);
        add(textsemester);

        String semester[] ={"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        semesterBox = new JComboBox(semester);
        semesterBox.setBounds(200,260,150,20);
        add(semesterBox);

        JLabel total = new JLabel("Total Payable");
        total.setBounds(40,300,150,20);
        add(total);

        totalAmount = new JLabel();
        totalAmount.setBounds(200,300,150,20);
        add(totalAmount);


        update = new JButton("Update");
        update.setBounds(30,380,100,25);
        update.addActionListener(this);
        add(update);


        pay = new JButton("Pay");
        pay.setBounds(150,380,100,25);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(270,380,100,25);
        back.addActionListener(this);
        add(back);





        setSize(900,500);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==update){
            String course = (String) courseBox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();
            try {
                Conn c = new Conn();
                ResultSet rs = c.statement.executeQuery("select * from fee where course ='"+course+"'");
                while (rs.next()){
                    totalAmount.setText(rs.getString(semester));
                }

            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==pay) {
            String rollno = croolNumber.getSelectedItem();
            String course = (String) courseBox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();
            String branch = (String) departmentBox.getSelectedItem();
            String total = totalAmount.getText();

            try {
                Conn c = new Conn();
                String Q = "insert into feecollege values('"+rollno+"','"+course+"','"+semester+"','"+branch+"','"+total+"')";
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Fee Submitted Successfully");

            } catch (Exception E) {
                E.printStackTrace();
            }


        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}

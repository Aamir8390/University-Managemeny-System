package universitymanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame implements ActionListener {
    Main_class(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.png.png"));
        Image i2 = i1.getImage().getScaledInstance(1540,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();

        // new information
        JMenu newinfo = new JMenu("New Information");
        newinfo .setForeground(Color.BLACK);
        mb.add(newinfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newinfo.add(facultyInfo);

        JMenuItem studentinfo =new JMenuItem("New Student Infromation");
        studentinfo.setBackground(Color.WHITE);
        studentinfo.addActionListener(this);
        newinfo.add(studentinfo);

        // details
        JMenu details = new JMenu("View Details");
        newinfo .setForeground(Color.BLACK);
        details.addActionListener(this);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultyInfo.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails =new JMenuItem("View Student Details");
        studentinfo.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);


        //leave
        JMenu leave = new JMenu("Apply Leave");
        leave .setForeground(Color.BLACK);
        leave.addActionListener(this);
        mb.add(leave);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave =new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);


        // Leave Details

        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails .setForeground(Color.BLACK);
        studentdetails.addActionListener(this);
        mb.add(leaveDetails);

        JMenuItem facultyleaveDetails = new JMenuItem("Faculty Leave Details");
        facultyleave.setBackground(Color.WHITE);
        facultyleaveDetails.addActionListener(this);
        leaveDetails.add(facultyleaveDetails);

        JMenuItem studentleaveDetails =new JMenuItem("Student Leave Details");
        studentleave.setBackground(Color.WHITE);
        studentleaveDetails.addActionListener(this);
        leaveDetails.add(studentleaveDetails);


        // Exam
        JMenu exam = new JMenu("Examination");
        exam .setForeground(Color.BLACK);
        exam.addActionListener(this);
        mb.add(exam);

        JMenuItem ExaminationDetails = new JMenuItem("Examination Results");
        ExaminationDetails.setBackground(Color.WHITE);
        ExaminationDetails.addActionListener(this);
        exam.add(ExaminationDetails);

        JMenuItem EnterMarks =new JMenuItem("Enter Marks");
        EnterMarks.setBackground(Color.WHITE);
        EnterMarks.addActionListener(this);
        exam.add(EnterMarks);

        // update info
        JMenu updateInfo = new JMenu("Update Details");
        exam .setForeground(Color.BLACK);
        updateInfo.addActionListener(this);
        mb.add(updateInfo);

        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Information");
        updateFacultyInfo.setBackground(Color.WHITE);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentInfo =new JMenuItem("Update Student Information");
        updateStudentInfo.setBackground(Color.WHITE);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);


        // fee
        JMenu fee = new JMenu("Fee Details");
        fee .setForeground(Color.BLACK);
        fee.addActionListener(this);
        mb.add(fee);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm =new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
        feeForm.addActionListener(this);
        fee.add(feeForm);


        // utility
        JMenu utility = new JMenu("Utility");
        utility .setForeground(Color.BLACK);
        mb.add(utility);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem NotePad =new JMenuItem("NotePad");
        NotePad.setBackground(Color.WHITE);
        NotePad.addActionListener(this);
        utility.add(NotePad);

        // about
        JMenu about = new JMenu("About");
        about .setForeground(Color.BLACK);
        mb.add(about);

        JMenuItem About = new JMenuItem("About");
        About.setBackground(Color.WHITE);
        About.addActionListener(this);
        about.add(About);

        // exit
        JMenu exit = new JMenu("Exit");
        exit .setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.WHITE);
        Exit.addActionListener(this);
        exit.add(Exit);





        setJMenuBar(mb);



        setSize(1540,850);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
        if (sm.equals("Exit")){
            System.exit(15);

        } else if (sm.equals("Calculator")) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();

            }

        } else if (sm.equals("NotePad")) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (sm.equals("New Faculty Information")) {
            new AddFaculty();

        }else if (sm.equals("New Student Infromation")) {
            new AddStudent();

        }else if (sm.equals("View Faculty Details")) {
            new TeacherDetails();

        }else if (sm.equals("View Student Details")) {
            new StudentDetails();

        }else if (sm.equals("Faculty Leave")) {
            new TeacherLeave();

        }else if (sm.equals("Student Leave")) {
            new StudentLeave();

        }else if (sm.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();

        }else if (sm.equals("Student Leave Details")) {
            new StudentLeaveDetails();

        }else if (sm.equals("Update Faculty Information")) {
            new UpdateTeacher();

        }else if (sm.equals("Update Student Information")) {
            new UpdateStudent();

        }else if (sm.equals("Enter Marks")) {
            new EnterMarks();

        }else if (sm.equals("Examination Results")) {
            new ExaminationDetails();

        }else if (sm.equals("Fee Structure")) {
            new FeeStructure();

        }else if (sm.equals("Student Fee Form")) {
            new StudentFeeForm();

        }else if (sm.equals("About")) {
            new About();

        }

    }

    public static void main(String[] args) {
        new Main_class();

    }
}

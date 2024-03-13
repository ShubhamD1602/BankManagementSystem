package AtmManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;

public class signupTwo extends JFrame implements ActionListener {
    JLabel religion,category,income,edu,exacc,qua, senior,ocu,pan,add;
    JTextField addrField,panField;
    JRadioButton yes,no,eyes,eno;
    JDateChooser dobField;
    JComboBox religionList,categoryList,incomeList,eduList,occList;
    JButton next;
    String formNo;
    signupTwo(String formNo){
        this.formNo = formNo;
        setLayout(null);

        setTitle("New Application From : Page 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Times new roman",Font.BOLD,22));
        additionalDetails.setBounds(270,40,400,30);
        add(additionalDetails);

//...................................form.....................................

        religion = new JLabel("Religion: ");
        religion.setFont(new Font("Times new roman",Font.BOLD,20));
        religion.setBounds(100,130,100,30);
        add(religion);

        String[] religionArr = {"Hindu","Sikh","Christan","Muslim","Other"};
        religionList = new JComboBox(religionArr);
        religionList.setFont(new Font("Times new roman",Font.BOLD,14));
        religionList.setBounds(300,130,400,30);
        religionList.setBackground(Color.white);
        add(religionList);


        category = new JLabel("Category: ");
        category.setFont(new Font("Times new roman",Font.BOLD,20));
        category.setBounds(100,170,200,30);
        add(category);

        String[] categoryArr = {"General","OBC","SC","ST","Other"};
        categoryList = new JComboBox(categoryArr);
        categoryList.setFont(new Font("Times new roman",Font.BOLD,14));
        categoryList.setBounds(300,170,400,30);
        categoryList.setBackground(Color.white);
        add(categoryList);


        income = new JLabel("Income: ");
        income.setFont(new Font("Times new roman",Font.BOLD,20));
        income.setBounds(100,210,200,30);
        add(income);

        String[] incomeArr = {"null","<1,50,000","<3,00,000","<8,00,000","above 8,00,000"};
        incomeList = new JComboBox(incomeArr);
        incomeList.setFont(new Font("Times new roman",Font.BOLD,14));
        incomeList.setBounds(300,210,400,30);
        incomeList.setBackground(Color.white);
        add(incomeList);



        edu = new JLabel("Education: ");
        edu.setFont(new Font("Times new roman",Font.BOLD,20));
        edu.setBounds(100,250,300,30);
        add(edu);

        String[] eduArr = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Other"};
        eduList = new JComboBox(eduArr);
        eduList.setFont(new Font("Times new roman",Font.BOLD,14));
        eduList.setBounds(300,270,400,30);
        eduList.setBackground(Color.white);
        add(eduList);

        qua = new JLabel("Qualification: ");
        qua.setFont(new Font("Times new roman",Font.BOLD,20));
        qua.setBounds(100,280,130,30);
        add(qua);



        ocu = new JLabel("Occupation: ");
        ocu.setFont(new Font("Times new roman",Font.BOLD,20));
        ocu.setBounds(100,330,150,30);
        add(ocu);

        String[] occArr = {"Service","Business","Retired","Student","Other"};
        occList = new JComboBox(occArr);
        occList.setFont(new Font("Times new roman",Font.BOLD,14));
        occList.setBounds(300,330,400,30);
        occList.setBackground(Color.white);
        add(occList);


        pan = new JLabel("PAN Number: ");
        pan.setFont(new Font("Times new roman",Font.BOLD,20));
        pan.setBounds(100,370,200,30);
        add(pan);

        panField = new JTextField();
        panField.setFont(new Font("Times new roman",Font.BOLD,14));
        panField.setBounds(300,370,400,30);
        add(panField);



        add = new JLabel("Addhaar Number: ");
        add.setFont(new Font("Times new roman",Font.BOLD,20));
        add.setBounds(100,410,170,30);
        add(add);

        addrField = new JTextField();
        addrField.setFont(new Font("Times new roman",Font.BOLD,14));
        addrField.setBounds(300,410,400,30);
        add(addrField);



        senior = new JLabel("Senior Citizen: ");
        senior.setFont(new Font("Times new roman",Font.BOLD,20));
        senior.setBounds(100,450,150,30);
        add(senior);

        yes = new JRadioButton("Yes");
        yes.setBounds(300,450,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        no = new JRadioButton("No");
        no.setBounds(400,450,100,30);
        no.setBackground(Color.WHITE);
        add(no);



        exacc = new JLabel("Existing Account: ");
        exacc.setFont(new Font("Times new roman",Font.BOLD,20));
        exacc.setBounds(100,490,170,30);
        add(exacc);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,490,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBounds(400,490,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);


        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(600,530,100,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);

        setSize(850,750);
        setLocation(250,5);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String sReligion = (String) religionList.getSelectedItem();
        String sCategory = (String) categoryList.getSelectedItem();
        String sIncome = (String) incomeList.getSelectedItem();
        String sEdu = (String) eduList.getSelectedItem();
        String sOcc = (String) occList.getSelectedItem();
        String sPan = panField.getText();
        String sAdd = addrField.getText();
        String seniorCitizen = null;
        if(yes.isSelected()){
            seniorCitizen = "Yes";
        }else if(no.isSelected()){
            seniorCitizen = "No";
        }
        String Exitacc = null;
        if(eyes.isSelected()){
            Exitacc = "Yes";
        }else if(eno.isSelected()){
            Exitacc= "No";
        }
        try {
            if(sReligion.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Religion");
            }
            else if(sCategory.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Category");
            }
            else if(sIncome.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Income");
            }
            else if(sEdu.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Education");
            }
            else if(sOcc.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Occupation");
            }
            else if(sPan.equals("")){
                JOptionPane.showMessageDialog(null,"Enter PAN Number");
            }
            else if(sAdd.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Aadhaar Number");
            }
            else if(seniorCitizen.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Seniority");
            }
            else if(Exitacc.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Existing Account");
            }
            else{
                Con connection = new Con();
                String query = "insert into signupTwo value('"+formNo+"','"+sReligion+"','"+sCategory+"','"+sIncome+"','"+sEdu+"','"+sOcc+"','"+sPan+"','"+sAdd+"','"+seniorCitizen+"','"+Exitacc+"')";
                connection.statement.executeUpdate(query);

                setVisible(false);
                new signupThree(formNo).setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new signupTwo("");
    }
}

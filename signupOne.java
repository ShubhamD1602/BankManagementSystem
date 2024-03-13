package AtmManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;

public class signupOne extends JFrame implements ActionListener {
    JLabel name,fname,Sname,dob,email,gender, marital,address,city,state1,pincode;
    JTextField nameField,fnameField,SnameField,emailField,addressField,cityField,stateField,pincodeField;
    JRadioButton male,female,other,single,married;
    JDateChooser dobField;
    long random;
    JButton next;
    signupOne(){
        setLayout(null);

        Random ran = new Random();
        random =Math.abs((ran.nextLong()%9000L)+1000L);
        JLabel formNo = new JLabel("Application Number is "+random);
        formNo.setFont(new Font("Times new roman",Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel personal = new JLabel("Page 1: Personal Details");
        personal.setFont(new Font("Times new roman",Font.BOLD,22));
        personal.setBounds(270,80,400,30);
        add(personal);

//...................................form.....................................

        name = new JLabel("Name: ");
        name.setFont(new Font("Times new roman",Font.BOLD,20));
        name.setBounds(100,130,100,30);
        add(name);

        nameField = new JTextField();
        nameField.setFont(new Font("Times new roman",Font.BOLD,14));
        nameField.setBounds(300,130,400,30);
        add(nameField);


        fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Times new roman",Font.BOLD,20));
        fname.setBounds(100,170,200,30);
        add(fname);

        fnameField = new JTextField();
        fnameField.setFont(new Font("Times new roman",Font.BOLD,14));
        fnameField.setBounds(300,170,400,30);
        add(fnameField);


        Sname = new JLabel("Surname: ");
        Sname.setFont(new Font("Times new roman",Font.BOLD,20));
        Sname.setBounds(100,210,200,30);
        add(Sname);

        SnameField = new JTextField();
        SnameField.setFont(new Font("Times new roman",Font.BOLD,14));
        SnameField.setBounds(300,210,400,30);
        add(SnameField);



        dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Times new roman",Font.BOLD,20));
        dob.setBounds(100,250,300,30);
        add(dob);

        dobField = new JDateChooser();
        dobField.setBounds(300,250,400,30);
//        dobField.setFont();
        add(dobField);



        email = new JLabel("Email: ");
        email.setFont(new Font("Times new roman",Font.BOLD,20));
        email.setBounds(100,290,100,30);
        add(email);

        emailField = new JTextField();
        emailField.setFont(new Font("Times new roman",Font.BOLD,14));
        emailField.setBounds(300,290,400,30);
        add(emailField);



        gender = new JLabel("Gender: ");
        gender.setFont(new Font("Times new roman",Font.BOLD,20));
        gender.setBounds(100,330,100,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,330,100,30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(400,330,100,30);
        female.setBackground(Color.WHITE);
        add(female);
        other = new JRadioButton("Other");
        other.setBounds(500,330,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup Group = new ButtonGroup();
        Group.add(male);
        Group.add(female);
        Group.add(other);


        marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Times new roman",Font.BOLD,20));
        marital.setBounds(100,370,200,30);
        add(marital);

        single = new JRadioButton("Single");
        single.setBounds(300,370,100,30);
        single.setBackground(Color.WHITE);
        add(single);
        married = new JRadioButton("Married");
        married.setBounds(400,370,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(single);
        maritalGroup.add(married);



        address = new JLabel("Address: ");
        address.setFont(new Font("Times new roman",Font.BOLD,20));
        address.setBounds(100,410,100,30);
        add(address);

        addressField = new JTextField();
        addressField.setFont(new Font("Times new roman",Font.BOLD,14));
        addressField.setBounds(300,410,400,30);
        add(addressField);



        city = new JLabel("City: ");
        city.setFont(new Font("Times new roman",Font.BOLD,20));
        city.setBounds(100,450,100,30);
        add(city);

        cityField = new JTextField();
        cityField.setFont(new Font("Times new roman",Font.BOLD,14));
        cityField.setBounds(300,450,400,30);
        add(cityField);



        state1 = new JLabel("State: ");
        state1.setFont(new Font("Times new roman",Font.BOLD,20));
        state1.setBounds(100,490,100,30);
        add(state1);

        stateField = new JTextField();
        stateField.setFont(new Font("Times new roman",Font.BOLD,14));
        stateField.setBounds(300,490,400,30);
        add(stateField);



        pincode = new JLabel("Pin Code: ");
        pincode.setFont(new Font("Times new roman",Font.BOLD,20));
        pincode.setBounds(100,530,100,30);
        add(pincode);

        pincodeField = new JTextField();
        pincodeField.setFont(new Font("Times new roman",Font.BOLD,14));
        pincodeField.setBounds(300,530,400,30);
        add(pincodeField);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(600,590,100,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);

        setSize(850,750);
        setLocation(250,5);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formNo = "" + random;
        String name = nameField.getText();
        String fname = fnameField.getText();
        String Sname = SnameField.getText();
        String email = emailField.getText();
        String dob = ((JTextField) dobField.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }else{
            gender = "Other";
        }
        String marital = null;
        if(single.isSelected()){
            marital = "Single";
        }else if(married.isSelected()){
            marital = "Married";
        }
        String address = addressField.getText();
        String pin = pincodeField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Name");
            }
            else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Father Name");
            }
            else if(Sname.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Surname");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Date of Birth");
            }
            else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Email");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"Enter City");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"Enter State");
            }
            else if(pin.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Pin Code");
            }
            else{
                Con connection = new Con();
                String query = "insert into signup value('"+formNo+"','"+name+"','"+fname+"','"+Sname+"','"+dob+"','"+email+"','"+gender+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                connection.statement.executeUpdate(query);

                setVisible(false);
                new signupTwo(formNo).setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new signupOne();
    }
}

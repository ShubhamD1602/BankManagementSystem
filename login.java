package AtmManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JButton signIn,clear,signUp;
    JTextField cardField;
    JPasswordField pinField;
    Choice type;
    login(){
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(100,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Times New Roman",Font.BOLD,38));
        text.setBounds(250,50,400,40);
        add(text);

        JLabel bank = new JLabel("Indian Bank");
        bank.setFont(new Font("Times New Roman",Font.BOLD,18));
        bank.setBounds(200,20,400,30);
        add(bank);
//...................................CARD.......................................
        JLabel card = new JLabel("Card No.:");
        card.setFont(new Font("Century",Font.BOLD,28));
        card.setBounds(120,150,150,40);
        add(card);

        cardField = new JTextField();
        cardField.setBounds(300,150,250,30);
        cardField.setFont(new Font("Time new roman",Font.BOLD,20));
        add(cardField);
//.......................................PIN...................................
        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Century",Font.BOLD,28));
        pin.setBounds(120,210,150,40);
        add(pin);
        pinField = new JPasswordField();
        pinField.setBounds(300,210,250,30);
        add(pinField);
//.......................................choice...................................
        JLabel account = new JLabel("Account: ");
        account.setFont(new Font("Century",Font.BOLD,28));
        account.setBounds(120,270,150,40);
        add(account);

        type = new Choice();
        type.add("Customer");
        type.add("Admin");
        type.setBounds(300,270,150,50);
        add(type);
//...................................BUTTONS...................................
        signIn = new JButton("SIGN IN");
        signIn.setBounds(280,320,100,30);
        signIn.setBackground(Color.black);
        signIn.setForeground(Color.white);
        signIn.addActionListener(this);
        add(signIn);

        clear = new JButton("CLEAR");
        clear.setBounds(400,320,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("SIGN Up");
        signUp.setBounds(280,370,220,30);
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);


        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == signIn){
            Con con = new Con();
            String cardNumber = cardField.getText();
            String pinNumber = pinField.getText();
            String user = type.getSelectedItem();
            if(user.equals("Admin")){
                String query = "Select * from admin where CardNumber='"+cardNumber+"'and PIN='"+pinNumber+"'";
                try{
                    ResultSet rs = con.statement.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new admin().setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(null,"Incorrect Number or PIN");
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }else{
                String query = "Select * from login where CardNumber='"+cardNumber+"'and PIN='"+pinNumber+"'";
                try{
                    ResultSet rs = con.statement.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Transaction(pinNumber).setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(null,"Incorrect Number or PIN");
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }

        } else if (ae.getSource() == clear) {
            cardField.setText("");
            pinField.setText("");
        } else if (ae.getSource() == signUp) {
            setVisible(false);
            new signupOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new login();
    }
}

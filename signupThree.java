package AtmManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signupThree extends JFrame implements ActionListener {
    JRadioButton j1,j2,j3,j4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formNo;
    signupThree(String formNo){
        this.formNo =formNo;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Additional Details");
        l1.setFont(new Font("Times new roman",Font.BOLD,24));
        l1.setBounds(270,40,400,40);
        add(l1);

        JLabel account = new JLabel("Account Type");
        account.setFont(new Font("Times new roman",Font.BOLD,22));
        account.setBounds(100,120,400,30);
        add(account);

        j1 = new JRadioButton("Saving Account");
        j1.setFont(new Font("Times new roman",Font.BOLD,16));
        j1.setBackground(Color.WHITE);
        j1.setBounds(100,160,200,30);
        add(j1);

        j2 = new JRadioButton("Fixed Deposit Account");
        j2.setFont(new Font("Times new roman",Font.BOLD,16));
        j2.setBackground(Color.WHITE);
        j2.setBounds(300,160,250,30);
        add(j2);

        j3 = new JRadioButton("Current Account");
        j3.setFont(new Font("Times new roman",Font.BOLD,16));
        j3.setBackground(Color.WHITE);
        j3.setBounds(100,200,200,30);
        add(j3);

        j4 = new JRadioButton("Recurring Deposit Account");
        j4.setFont(new Font("Times new roman",Font.BOLD,16));
        j4.setBackground(Color.WHITE);
        j4.setBounds(300,200,250,30);
        add(j4);
        ButtonGroup accountType = new ButtonGroup();
        accountType.add(j1);
        accountType.add(j2);
        accountType.add(j3);
        accountType.add(j4);


        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Times new roman",Font.BOLD,22));
        card.setBounds(100,280,400,30);
        add(card);

        JLabel cardNumber = new JLabel("XXXX-XXXX-XXXX-4981");
        cardNumber.setFont(new Font("Times new roman",Font.BOLD,22));
        cardNumber.setBounds(300,280,500,30);
        add(cardNumber);
        JLabel cardDetail= new JLabel("Card Number is 16 Digit");
        cardDetail.setFont(new Font("Times new roman",Font.BOLD,12));
        cardDetail.setBounds(100,300,400,30);
        add(cardDetail);


        JLabel cardPin = new JLabel("PIN :");
        cardPin.setFont(new Font("Times new roman",Font.BOLD,22));
        cardPin.setBounds(100,350,400,30);
        add(cardPin);

        JLabel cardPinNumber = new JLabel("XXXX");
        cardPinNumber.setFont(new Font("Times new roman",Font.BOLD,22));
        cardPinNumber.setBounds(300,350,500,30);
        add(cardPinNumber);
        JLabel pinDetail= new JLabel("PIN is 4 Digit");
        pinDetail.setFont(new Font("Times new roman",Font.BOLD,12));
        pinDetail.setBounds(100,370,400,30);
        add(pinDetail);

        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Times new roman",Font.BOLD,22));
        services.setBounds(100,410,500,30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Times new roman",Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,450,200,30);
        add(c1);

        c2 = new JCheckBox("Mobile Banking");
        c2.setFont(new Font("Times new roman",Font.BOLD,16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(300,450,200,30);
        add(c2);

        c3 = new JCheckBox("Internet Banking");
        c3.setFont(new Font("Times new roman",Font.BOLD,16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,490,200,30);
        add(c3);

        c4 = new JCheckBox("Email & SMS alert");
        c4.setFont(new Font("Times new roman",Font.BOLD,16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(300,490,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Times new roman",Font.BOLD,16));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,530,200,30);
        add(c5);

        c6 = new JCheckBox("E- Statement");
        c6.setFont(new Font("Times new roman",Font.BOLD,16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(300,530,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declared that the above entered detail is correct");
        c7.setFont(new Font("Times new roman",Font.BOLD,16));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,570,500,30);
        add(c7);


        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Times new roman",Font.BOLD,14));
        submit.setBounds(200,630,150,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Times new roman",Font.BOLD,14));
        cancel.setBounds(400,630,150,30);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(Color.white);
        setSize(800,750);
        setLocation(250,5);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType = null;
           if(j1.isSelected()){
               accountType = "Saving account";
           }else if(j2.isSelected()){
               accountType = "Fixed Deposit account";
           }else if(j3.isSelected()){
               accountType = "Current account";
           }else if(j4.isSelected()){
               accountType = "Recurring Deposit account";
           }
           Random random = new Random();
           String cardnumber = ""+Math.abs((random.nextLong())% 90000000L+ 3890542000000000L);

           String pinnumber = ""+Math.abs((random.nextLong())% 9000L+ 1000L);

           String services = "";
           if(c1.isSelected()){
               services = services +" ATM Card";
           }else if(c2.isSelected()){
               services = services+" Mobile Banking";
           }else if(c3.isSelected()){
               services = services+" Internet Banking";
           }else if(c4.isSelected()){
               services = services+" Email & SMS alert";
           }else if(c5.isSelected()){
               services = services+" Cheque Book";
           }else if(c2.isSelected()){
               services = services+" E-Statement";
           }
           try{
               if(accountType.equals("")){
                   JOptionPane.showMessageDialog(null,"Enter Account Type");
               }
               else if(c7.equals("")){
                   JOptionPane.showMessageDialog(null,"Check Declaration");
               }else{
                   Con connection = new Con();
                   String query1 = "insert into signupthree value('"+formNo+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+services+"')";
                   String query2 = "insert into login value('"+formNo+"','"+cardnumber+"','"+pinnumber+"')";
                   connection.statement.executeUpdate(query1);
                   connection.statement.executeUpdate(query2);

                   JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\nPIN: "+pinnumber);
                   setVisible(false);
                   new login().setVisible(true);
               }
           }catch (Exception e){
               System.out.println(e);
           }

        }else if(ae.getSource()== cancel){
            setVisible(false);
            new login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new signupThree("");
    }
}

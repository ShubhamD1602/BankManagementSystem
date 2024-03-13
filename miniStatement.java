package AtmManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class miniStatement extends JFrame {
    miniStatement(String pinnumber){
        setTitle("Mini Statement");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(90,20,50,50);
        add(label);

        JLabel bank = new JLabel("Indian Bank");
        bank.setFont(new Font("system",Font.BOLD,16));
        bank.setBounds(150,25,200,30);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,30);
        add(card);

        JLabel mini =new JLabel();
        mini.setBounds(20,130,400,200);
        add(mini);


        JLabel bal =new JLabel();
        bal.setBounds(20,400,300,30);
        add(bal);
        try{
            Con con = new Con();
            ResultSet rs = con.statement.executeQuery("select * from login where Pin = '"+pinnumber+"'");
            while (rs.next()){
                card.setText("Card Number "+rs.getString("CardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("CardNumber").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Con con = new Con();
            int balance = 0;
            ResultSet rs = con.statement.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Amount")+"<br><br>");
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
            bal.setText("Your Current Account Balance is: "+balance);
        }catch (Exception e){
            System.out.println(e);
        }

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new miniStatement("");
    }
}

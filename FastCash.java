package AtmManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

public class FastCash extends JFrame implements ActionListener {
    JButton rs_100,rs_500,rs_1000,rs_2000,rs_5000,rs_10000,exit;
    String pinnumber;
    FastCash(String pinNumber){
        this.pinnumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text = new JLabel("Select your Transaction");
        text.setBounds(230,250,700,30);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        rs_100 = new JButton("Rs 100");
        rs_100.setBounds(140,370,150,25);
        rs_100.addActionListener(this);
        image.add(rs_100);

        rs_500= new JButton("Rs 500");
        rs_500.setBounds(300,370,150,25);
        rs_500.addActionListener(this);
        image.add(rs_500);

        rs_1000= new JButton("Rs 1000");
        rs_1000.setBounds(140,400,150,25);
        rs_1000.addActionListener(this);
        image.add(rs_1000);

        rs_2000 = new JButton("Rs 2000");
        rs_2000.setBounds(300,400,150,25);
        rs_2000.addActionListener(this);
        image.add(rs_2000);

        rs_5000 = new JButton("Rs 5000");
        rs_5000.setBounds(140,430,150,25);
        rs_5000.addActionListener(this);
        image.add(rs_5000);

        rs_10000 = new JButton("Rs 10000");
        rs_10000.setBounds(300,430,150,25);
        rs_10000.addActionListener(this);
        image.add(rs_10000);

        exit = new JButton("Back");
        exit.setBounds(300,460,150,25);
        exit.addActionListener(this);
        image.add(exit);


        setSize(800,800);
        setLocation(250,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Con con = new Con();
            try{
                ResultSet rs = con.statement.executeQuery("Select * from bank where PIN ='"+pinnumber+"'");
                int balance=0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("Amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                }
                if(ae.getSource()!=exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values ('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
                con.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+amount+" Debited successfully");
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}

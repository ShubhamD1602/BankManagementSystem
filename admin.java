package AtmManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame implements ActionListener {
    JButton deposit,withdraw,fastCash,miniStatemnet,pinChange,balance,exit;
    admin(){

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text = new JLabel("Admin Account");
        text.setBounds(230,250,700,30);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        balance = new JButton("Customer Details");
        balance.setBounds(300,430,150,25);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource()== balance){
            setVisible(false);
            new accountsDetails().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new admin();
    }
}

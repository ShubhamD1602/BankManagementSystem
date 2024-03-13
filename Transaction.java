package AtmManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit,withdraw,fastCash,miniStatemnet,pinChange,balance,exit;
    String pinnumber;
    Transaction(String pinNumber){
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

        deposit = new JButton("Deposit");
        deposit.setBounds(140,370,150,25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw= new JButton("Withdraw");
        withdraw.setBounds(300,370,150,25);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(140,400,150,25);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatemnet = new JButton("Mini-Statement");
        miniStatemnet.setBounds(300,400,150,25);
        miniStatemnet.addActionListener(this);
        image.add(miniStatemnet);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(140,430,150,25);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balance = new JButton("Balance Enquiry");
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
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastCash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinChange){
            setVisible(false);
            new pinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()== balance){
            setVisible(false);
            new balanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()== miniStatemnet){
            new miniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transaction("");
    }
}

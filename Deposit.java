package AtmManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    JLabel text;
    JTextField amount;
    JButton deposit,back;
    String pinnmber;
    Deposit(String pinNumber){
        this.pinnmber=pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        text = new JLabel("Enter the amount you want to Deposit");
        text.setBounds(160,260,700,30);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170,300,250,30);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(300,430,150,25);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(300,460,150,25);
        back.addActionListener(this);
        image.add(back);

        setSize(800,800);
        setLocation(250,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Amount to Deposit");
            }
            else{
                try{
                    Con con = new Con();
                    String query = "insert into bank values ('"+pinnmber+"','"+date+"','Deposit','"+number+"')";
                    con.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs"+number+" Deposit successfully");
                    setVisible(false);
                    new Transaction(pinnmber).setVisible(true);
                }catch(Exception e) {
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnmber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}

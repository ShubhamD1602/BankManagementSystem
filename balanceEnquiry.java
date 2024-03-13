package AtmManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JLabel image,text;
    JButton back;
    balanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        Con con = new Con();
        int balance = 0;
        try {
            ResultSet rs = con.statement.executeQuery("Select * from bank where PIN ='" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        text = new JLabel("Your Current Balance is: "+balance);
        text.setForeground(Color.white);
        text.setBounds(160,300,700,30);
        text.setFont(new Font("system",Font.BOLD,16));
        image.add(text);

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
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new balanceEnquiry("");
    }
}

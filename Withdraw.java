package AtmManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JLabel text;
    JTextField amount;
    JButton withdraw,back,yes,no;
    JLabel image;
    String pinnmber;
    Withdraw(String pinNumber){
        this.pinnmber=pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        text = new JLabel("Enter the amount you want Withdrawal");
        text.setBounds(150,260,700,30);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170,300,250,30);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(300,430,150,25);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        if(ae.getSource()==withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Amount to Withdraw");
            }
            else{
                try{
                    Con con = new Con();
                    ResultSet rs = con.statement.executeQuery("Select * from bank where PIN ='"+pinnmber+"'");
                    int balance=0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("Amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("Amount"));
                        }
                    }
                    if(balance < Integer.parseInt(number)){
                        JOptionPane.showMessageDialog(null,"Insufficient balance");
                        setVisible(false);
                        new Transaction(pinnmber).setVisible(true);
                        return;
                    }
                    String query = "insert into bank values ('"+pinnmber+"','"+date+"','Withdraw','"+number+"')";
                    con.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Withdrawal successfully");
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
        new Withdraw("");
    }
}

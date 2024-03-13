package AtmManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {
    JLabel image,text,pinText,rePinText;
    JPasswordField pin,rePin;
    JButton change,back;
    String pinnumber;
    pinChange(String pinChange){
        this.pinnumber = pinChange;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("system",Font.BOLD,16));
        text.setForeground(Color.white);
        text.setBounds(220,260,700,30);
        image.add(text);

        pinText = new JLabel("New Pin:");
        pinText.setFont(new Font("system",Font.BOLD,14));
        pinText.setForeground(Color.white);
        pinText.setBounds(150,320,700,30);
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("system",Font.BOLD,14));
        pin.setBounds(240,320,200,25);
        image.add(pin);

        rePinText = new JLabel("Re-Enter Pin: ");
        rePinText.setFont(new Font("system",Font.BOLD,14));
        rePinText.setForeground(Color.white);
        rePinText.setBounds(150,370,700,30);
        image.add(rePinText);

        rePin = new JPasswordField();
        rePin.setFont(new Font("system",Font.BOLD,14));
        rePin.setBounds(240,370,200,25);
        image.add(rePin);

        change = new JButton("Change");
        change.setBounds(300,430,150,25);
        change.addActionListener(this);
        image.add(change);

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
        if(ae.getSource()==change){
           try{
               String npin = pin.getText();
               String rpin = rePin.getText();
               if(!npin.equals(rpin)){
                   JOptionPane.showMessageDialog(null,"Entered Pin doesn't match");
               }
               if(npin.equals("")){
                   JOptionPane.showMessageDialog(null,"Enter New Pin");
               }
               if(rpin.equals("")){
                   JOptionPane.showMessageDialog(null,"Re-Enter New Pin");
               }
               Con con = new Con();
               String query = "update login set Pin ='"+rpin+"'where Pin ='"+pinnumber+"'";
               String query1 = "update signupthree set Pin ='"+rpin+"'where Pin ='"+pinnumber+"'";
               String query2 = "update bank set pin ='"+rpin+"'where pin ='"+pinnumber+"'";
               con.statement.executeUpdate(query);
               con.statement.executeUpdate(query1);
               con.statement.executeUpdate(query2);

               JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
               setVisible(false);
               new Transaction(rpin).setVisible(true);
           }catch (Exception e){
               System.out.println(e);
           }
        }else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new pinChange("");
    }
}

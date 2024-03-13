package AtmManagementSystem;

import com.mysql.cj.xdevapi.JsonArray;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class accountsDetails extends JFrame implements ActionListener {
    JLabel accountNo;
    Choice accNo;
    JButton search,print,back;
    JTable table;
    accountsDetails(){
        super("Accounts Details");

        setLayout(null);
        getContentPane().setBackground(Color.white);
        accountNo = new JLabel("Search by Form Number: ");
        accountNo.setBounds(20,20,180,20);
        add(accountNo);

        accNo = new Choice();
        accNo.setBounds(200,20,130,20);
        add(accNo);

        try{
            Con con = new Con();
            ResultSet rs = con.statement.executeQuery("Select * from signup");
            while (rs.next()){
                accNo.add(rs.getString("formNo"));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        table = new JTable();
        try{
            Con con = new Con();
            ResultSet rs = con.statement.executeQuery("select * from signup");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
        }
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,100,900,600);
        add(sp);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        back = new JButton("Back");
        back.setBounds(220,70,80,20);
        back.addActionListener(this);
        add(back);


        setSize(900,700);

        setLocation(250,0);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query = "Select * from signup where formNo = '"+accNo.getSelectedItem()+"'";
            try{
                Con con = new Con();
                ResultSet rs = con.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==print) {
            try {
                table.print();
            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new admin().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new accountsDetails();
    }
}

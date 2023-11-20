
// Task 3 ATM Machine
//package Internship_CodeSoft;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class atm extends JFrame implements ActionListener {
    JLabel label, label1;
    JFrame frame;
    JButton Withdrawal,Deposite,CheckBalance,Clear;
    public static int amount, count = 0;
    public static int balance;
    public String input;

    atm(String s) {
        super(s);
        getContentPane().setBackground(Color.magenta);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 10));  // Set a border for the root pane of the frame
        label = new JLabel();
        label.setText(" *** ATM MACHINE ***");
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setOpaque(true);                                  // Set the label to be opaque and add bg colour
        label.setBackground(Color.LIGHT_GRAY);
        add(label);
        label1 = new JLabel();
        add(label1);
        label1.setBounds(110, 150, 300, 60);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setOpaque(true);                                  // Set the label to be opaque and add a bg colour
        label1.setBackground(Color.cyan);

        Withdrawal = new JButton("Withdrawal");
Deposite = new JButton("Deposite");
CheckBalance = new JButton("CheckBalance");
Clear = new JButton("Clea All");
Withdrawal.addActionListener(this);
Deposite.addActionListener(this);
CheckBalance.addActionListener(this);
Clear.addActionListener(this);
        add(Withdrawal);
        add(Deposite);
        add(CheckBalance);
        add(Clear);
        label.setBounds(120, 20, 270, 40);
        Withdrawal.setBounds(40, 100, 100, 30);
        Deposite.setBounds(400, 100, 100, 30);
        CheckBalance.setBounds(40, 250, 120, 30);
        Clear.setBounds(390, 250, 100, 30);

        setLayout(null);
        setLocation(350, 100);
        setVisible(true);
        setSize(550, 350);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    
    }

    void setData() {
        input = JOptionPane.showInputDialog(frame,"Enter your amount : ");
         balance = Integer.parseInt(input);
    }

    public void withdrawal(int balance) {
        if (balance <= amount) {
            if (balance <= 2000) {
                amount -= balance;
                count = 1;
                JOptionPane.showMessageDialog(frame, "Your Avalabel Balance is " + amount);
            } else {
                JOptionPane.showMessageDialog(frame, "You can't withdraw more than two thousand(2000/-) at a time");
                count = 0;
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Insuficeant Balance.");
            count = 0;
            JOptionPane.showMessageDialog(frame, "Your Avalabel Balance is " + amount);
        }
    }

    public void deposit(int balance) {
        amount += balance;
        count = 1;
        JOptionPane.showMessageDialog(frame, " Avalabel Balance : " + amount);
    }

    public void print() {
        label1.setText("  Account Balance : " + amount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Withdrawal) {
            setData();
            withdrawal(balance);
            if (count == 1)
                label1.setText("   Withdrwan Successfully !!");
            else
                label1.setText("   Transaction Failed !!");
        }
        if (e.getSource() == Deposite) {
            setData();
            deposit(balance);
            if (count == 1)
                label1.setText("   Deposit Successfully !!");
            else
                label1.setText("   Transaction Failed !!");
        }
        if (e.getSource() == CheckBalance) {
            print();
        }
        if(e.getSource()==Clear)
        {
            label1.setText("");
        }
    }
}

public class atm1 {
    public static void main(String[] args) {
        new atm(" ATM Machine ");
    }
}

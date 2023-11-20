import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cc extends JFrame {
    private JTextField amountField, baseCurrencyField, targetCurrencyField;
    double result;

    public cc() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);

        // Creating three panels for three rows
        JPanel row1 = new JPanel();
        JPanel row2 = new JPanel();
        JPanel row3 = new JPanel();

        // Row 1: Amount Field
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);
        row1.add(amountLabel);
        row1.add(amountField);

        // Row 2: Base Currency and Target Currency Fields
        JLabel baseCurrencyLabel = new JLabel("Base Currency:");
        baseCurrencyField = new JTextField(5);
        JLabel targetCurrencyLabel = new JLabel("==>> Target Currency:");
        targetCurrencyField = new JTextField(5);
        row2.add(baseCurrencyLabel);
        row2.add(baseCurrencyField);
        row2.add(targetCurrencyLabel);
        row2.add(targetCurrencyField);

        // Row 3: Convert Button
        JButton convertButton = new JButton("Convert");
        row3.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String b_c = baseCurrencyField.getText().toLowerCase();
                    String t_c = targetCurrencyField.getText().toLowerCase();
                    if (b_c.equalsIgnoreCase("rupee")) {

                        if (t_c.equalsIgnoreCase("dollar")) {
                            result = amount / 83.22;
                        } else if (t_c.equalsIgnoreCase("ruble"))
                            result = amount / 67.95;
                        else if (t_c.equalsIgnoreCase("euro"))
                            result = amount / 103.33;
                        else if (t_c.equalsIgnoreCase("taka"))
                            result = amount / 0.75;
                        else if (t_c.equalsIgnoreCase("riyal"))
                            result = amount / 22.7;

                    } else if (b_c.equalsIgnoreCase("dollar")) {
                        if (t_c.equalsIgnoreCase("rupee"))
                            result = amount * 83.2;
                        else if (t_c.equalsIgnoreCase("ruble"))
                            result = amount * 92.42;
                        else if (t_c.equalsIgnoreCase("euro"))
                            result = amount * 0.3;
                        else if (t_c.equalsIgnoreCase("taka"))
                            result = amount * 110.68;
                        else if (t_c.equalsIgnoreCase("riyal"))
                            result = amount * 3.57;

                    } else if (b_c.equalsIgnoreCase("euro")) {
                        if (t_c.equalsIgnoreCase("dollar"))
                            result = amount * 1.0739;
                        else if (t_c.equalsIgnoreCase("ruble"))
                            result = amount * 99.15;
                        else if (t_c.equalsIgnoreCase("rupee"))
                            result = amount * 89.21;
                        else if (t_c.equalsIgnoreCase("taka"))
                            result = amount * 118.71;
                        else if (t_c.equalsIgnoreCase("riyal"))
                            result = amount * 4.2;

                    } else if (b_c.equalsIgnoreCase("ruble")) {
                        if (t_c.equalsIgnoreCase("dollar"))
                            result = amount * 0.01;
                        else if (t_c.equalsIgnoreCase("rupee"))
                            result = amount * 0.9;
                        else if (t_c.equalsIgnoreCase("euro"))
                            result = amount * 0.01;
                        else if (t_c.equalsIgnoreCase("taka"))
                            result = amount * 1.20;
                        else if (t_c.equalsIgnoreCase("riyal"))
                            result = amount * 0.04;
                    }

                    JOptionPane.showMessageDialog(null, "Converted Amount: " + result, "Conversion Result",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        JButton clear=new JButton("clear");
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                baseCurrencyField.setText("");
               targetCurrencyField.setText("");
               amountField.setText("");
               }
               });
               row3.add(clear);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Setting BoxLayout for vertical arrangement

        // Adding rows to the frame
        add(row1);
        add(row2);
        add(row3);
        setVisible(true);
    }

    public static void main(String[] args) {
     new cc();
    }
}

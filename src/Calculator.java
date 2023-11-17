import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame{
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JComboBox cbOperations;
    private JLabel lblResult;
    private JButton btnCompute;
    private JPanel Jpanel;
    private JLabel firstn;


    public Calculator(){
        cbOperations.addItem("");
        cbOperations.addItem("+");
        cbOperations.addItem("-");
        cbOperations.addItem("*");
        cbOperations.addItem("/");
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbOperations.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "Select na Operation");
                }
                try{
                    double f1 = Double.parseDouble(tfNumber1.getText());
                    Double f2 = Double.parseDouble(tfNumber2.getText());

                    if(f2<1 && cbOperations.getSelectedIndex() == 4){
                        throw new IllegalArgumentException("Must not be zero");
                    }

                    if(cbOperations.getSelectedIndex() == 1){
                        lblResult.setText(Double.toString(f1+f2));
                    }
                    else if(cbOperations.getSelectedIndex() == 2){
                        lblResult.setText(Double.toString(f1-f2));
                    }
                    else if(cbOperations.getSelectedIndex() == 3){
                        lblResult.setText(Double.toString(f1*f2));
                    }
                    else if(cbOperations.getSelectedIndex() == 4){
                        lblResult.setText(Double.toString(f1/f2));
                    }

                }
                catch (Exception ee){
                    if(ee instanceof NumberFormatException){
                        JOptionPane.showMessageDialog(null, "Enter a number");
                    }
                    else if(ee instanceof ArithmeticException){
                        JOptionPane.showMessageDialog(null, "Do not divide by zero");
                    }
                    else if(ee instanceof IllegalArgumentException){
                        JOptionPane.showMessageDialog(null, "Do not divide by zero");
                    }
                }
            }
        });
    }
    public static void main(String[]args){
        Calculator app = new Calculator();
        app.setContentPane(app.Jpanel);//set the Contets of the app//sets which panel to utilize
        app.setSize(700,400);//set size of app
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);//allows you to stop running the program when you exit the application.
        app.setTitle("Simple Calculator");//setTitle
        app.setVisible(true);//allows the app to be shown
    }
}

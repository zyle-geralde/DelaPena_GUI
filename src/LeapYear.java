import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYear extends JFrame{
    private JTextField tfYear;
    private JButton btnCheckYear;

    private JPanel panel;

    public LeapYear() {

        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int year = Integer.parseInt(tfYear.getText());
                    if(year<0){
                        throw new IllegalArgumentException("Enter a Positive Integer");
                    }
                    boolean leap = false;

                    // if the year is divided by 4
                    if (year % 4 == 0) {

                        // if the year is century
                        if (year % 100 == 0) {

                            // if year is divided by 400
                            // then it is a leap year
                            if (year % 400 == 0)
                                leap = true;
                            else
                                leap = false;
                        }

                        // if the year is not century
                        else {
                            leap = true;
                        }
                    } else {
                        leap = false;
                    }

                    if (leap) {
                        JOptionPane.showMessageDialog(null, "Leap Year");
                    } else {
                        JOptionPane.showMessageDialog(null, "Not a Leap Year");
                    }
                }
                catch(Exception ee){
                    if(ee instanceof NumberFormatException){
                        JOptionPane.showMessageDialog(null, "Enter a Positive Integer");
                    }
                    else if(ee instanceof IllegalArgumentException){
                        JOptionPane.showMessageDialog(null, ee.getMessage());
                    }
                }
            }
        });
    }
    public static void main(String[]args){
        LeapYear app = new LeapYear();
        app.setContentPane(app.panel);//set the Contets of the app//sets which panel to utilize
        app.setSize(300,150);//set size of app
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);//allows you to stop running the program when you exit the application.
        app.setTitle("Leap Year Checker");//setTitle
        app.setVisible(true);//allows the app to be shown
    }
}

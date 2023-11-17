import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodSystem extends JFrame{
    private JPanel Jpanel;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrink;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;

    public FoodSystem(){
        JCheckBox ch[] = {cPizza,cBurger,cFries,cSoftDrink,cTea,cSundae};

        btnOrder.addActionListener(new ActionListener() {
            int sum = 0;
            double disc = -1;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ch[0].isSelected()){
                    sum+=100;
                }
                if(ch[1].isSelected()){
                    sum+=80;
                }
                if(ch[2].isSelected()){
                    sum+=65;
                }
                if(ch[3].isSelected()){
                    sum+=55;
                }
                if(ch[4].isSelected()){
                    sum+=50;
                }
                if(ch[5].isSelected()){
                    sum+=40;
                }

                if(rbNone.isSelected()){
                    disc = 0;
                }
                else if(rb5.isSelected()){
                    disc = 0.05;
                }
                else if(rb10.isSelected()){
                    disc = 0.10;
                }
                else if(rb15.isSelected()){
                    disc = 0.15;
                }

                if(sum == 0 || disc == -1){
                    JOptionPane.showMessageDialog(null, "Invalid");
                    sum = 0;
                    disc = -1;
                }
                else{
                    double total = sum-(sum*disc);
                    JOptionPane.showMessageDialog(null, String.format("The total price is Php %.2f",total));
                    sum = 0;
                    disc = -1;
                }
            }
        });
    }
    public static void main(String[]args){
        FoodSystem app = new FoodSystem();
        app.setContentPane(app.Jpanel);//set the Contets of the app//sets which panel to utilize
        app.setSize(700,400);//set size of app
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);//allows you to stop running the program when you exit the application.
        app.setTitle("Food Ordering System");//setTitle
        app.setVisible(true);//allows the app to be shown
    }
}


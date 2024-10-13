package Chapter14.Tutorials;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JResortCalculator extends JFrame implements ItemListener{
    final int BASE_PRICE = 200;
    final int WEEKEND_PRIMIUM = 100;
    final int BREAKFAST_PRIMIUM = 20;
    final int GOLF_PRIMIUM = 75;
    int totalPrice = BASE_PRICE;

    JCheckBox weekendBox = new JCheckBox(
        "Weekend premium" + WEEKEND_PRIMIUM, false);
    JCheckBox breakfastBox = new JCheckBox(
        "Breakfast premium" + BREAKFAST_PRIMIUM, false);
    JCheckBox golfBox = new JCheckBox(
        "Golf premium" + GOLF_PRIMIUM, false);    

    JLabel resortLabel = new JLabel("Resort Price Calculator");
    JLabel priceLabel = new JLabel("The price for your stay is");
    JTextField toPrice = new JTextField(4);
    JLabel optionalExplainLabel = new JLabel(
        "Base price for the room is $" + BASE_PRICE + ".");
    JLabel optionalExplainLabel2 = new JLabel(
        "Check the options you want.");

    public JResortCalculator() {
        super("Resort Price Estimator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(resortLabel);
        add(optionalExplainLabel);
        add(optionalExplainLabel2);
        add(weekendBox);
        add(breakfastBox);
        add(golfBox);
        add(priceLabel);
        add(toPrice);

        toPrice.setText("$" + totalPrice);
        weekendBox.addItemListener(this);
        breakfastBox.addItemListener(this);
        golfBox.addItemListener(this);
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        int select = e.getStateChange();

        if(source == weekendBox) {
            if (select == ItemEvent.SELECTED) {
                totalPrice += WEEKEND_PRIMIUM;
            } else {
                totalPrice -= WEEKEND_PRIMIUM;
            }
        } else if(source == breakfastBox) {
            if (select == ItemEvent.SELECTED) {
                totalPrice += BREAKFAST_PRIMIUM;
            } else {
                totalPrice -= BREAKFAST_PRIMIUM;
            }
        } else {
            if (select == ItemEvent.SELECTED) {
                totalPrice += GOLF_PRIMIUM;
            } else {
                totalPrice -= GOLF_PRIMIUM;
            }
        }
        toPrice.setText("$" + totalPrice);
    }

    public static void main(String[] args) {
        JResortCalculator aFrame = new JResortCalculator();
        final int WIDTH = 300;
        final int HEIGHT = 200;
        aFrame.setSize(WIDTH, HEIGHT);
        aFrame.setVisible(true);
    }
}

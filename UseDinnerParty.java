import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UseDinnerParty {
    private JFrame frame;
    private JPanel panel;
    private JLabel partyLabel, dinnerLabel;
    private JTextField partyField, dinnerField;
    private JButton partyButton, dinnerButton;
    private Party party;
    private DinnerParty dinnerParty;

    public UseDinnerParty() {
        frame = new JFrame("Party Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        partyLabel = new JLabel("Enter number of guests for the party:");
        partyField = new JTextField();
        partyButton = new JButton("Invite to Party");
        partyButton.addActionListener(new PartyButtonListener());

        dinnerLabel = new JLabel("Enter number of guests for the dinner party:");
        dinnerField = new JTextField();
        dinnerButton = new JButton("Invite to Dinner Party");
        dinnerButton.addActionListener(new DinnerButtonListener());

        panel.add(partyLabel);
        panel.add(partyField);
        panel.add(partyButton);
        panel.add(dinnerLabel);
        panel.add(dinnerField);
        panel.add(dinnerButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        party = new Party();
        dinnerParty = new DinnerParty();
    }

    private class PartyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int numGuests = Integer.parseInt(partyField.getText());
            party.setGuests(numGuests);
            JOptionPane.showMessageDialog(null, "The party has " + party.getGuests() + " guests\nPlease come to my party!");
        }
    }

    private class DinnerButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int numGuests = Integer.parseInt(dinnerField.getText());
            dinnerParty.setGuests(numGuests);
            int choice = JOptionPane.showOptionDialog(null, "Please select the dinner menu:", "Dinner Menu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Chicken", "Vegi"}, "Chicken");
            dinnerParty.setDinnerChoice(choice);
            JOptionPane.showMessageDialog(null, "The dinner party has " + dinnerParty.getGuests() + " guests\nMenu option " + (choice + 1) + " will be served\nPlease come to my party!");
        }
    }

    public static void main(String[] args) {
        new UseDinnerParty();
    }
}
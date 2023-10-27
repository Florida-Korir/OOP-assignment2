import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetProject {

    private JFrame frame;
    private JPanel panel;
    private JLabel imageLabel;

    public PetProject() {
        frame = new JFrame("RadioButtonDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());

        JLabel petLabel = new JLabel("Choose a pet:");
        panel.add(petLabel, BorderLayout.WEST);

        JRadioButton[] petButtons = new JRadioButton[5];
        petButtons[0] = new JRadioButton("Bird");
        petButtons[1] = new JRadioButton("Cat");
        petButtons[2] = new JRadioButton("Dog");
        petButtons[3] = new JRadioButton("Rabbit");
        petButtons[4] = new JRadioButton("Pig");

        JPanel petButtonPanel = new JPanel();
        petButtonPanel.setLayout(new GridLayout(5, 1));

        for (JRadioButton button : petButtons) {
            button.addActionListener(new PetSelectionListener());
            petButtonPanel.add(button);
        }

        ButtonGroup group = new ButtonGroup();
        for (JRadioButton button : petButtons) {
            group.add(button);
        }

        panel.add(petButtonPanel, BorderLayout.WEST);

        imageLabel = new JLabel();
        panel.add(imageLabel, BorderLayout.CENTER);

        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private class PetSelectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton selectedButton = (JRadioButton) e.getSource();
            String selectedPet = selectedButton.getText();
            displayPetImage(selectedPet);
        }
    }

    private void displayPetImage(String pet) {
        String imagePath = "images/"; // Update this to the correct path
        ImageIcon icon = new ImageIcon(imagePath + pet + ".jpg");
        imageLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PetProject();
            }
        });
    }
}

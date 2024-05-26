import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class BirthdayGUI extends JFrame implements ActionListener {
    // Initializing swing objects
    JPanel panel = new JPanel();
    JButton calcButton = new JButton("Calculate Age");
    JLabel infoLabel = new JLabel("Enter birthday below in numeric form (ex. 02/07/1990):");
    JLabel ageLabel = new JLabel("Age: ");
    JTextField textField = new JTextField(15);

    // Initializing vars to hold user input
    int birthDay;
    int birthMonth;
    int birthYear;
    
    // Initializing var to see if birthday was entered
    boolean birthdayEntered = false;

    public void init() {
        // Setting up JFrame
        this.setSize(1000, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting up JPanel
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // Setting up JTextField
        textField.setFont(new Font("Verdana", Font.PLAIN, 30));
        textField.addActionListener(this);

        // Setting up JButton
        calcButton.setFont(new Font("Verdana", Font.PLAIN, 30));
        calcButton.addActionListener(this);



        // Setting up JLabels
        ageLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
        infoLabel.setFont(new Font("Verdana", Font.PLAIN, 30));

        // Adding components
        panel.add(infoLabel);
        panel.add(textField);
        panel.add(calcButton);
        panel.add(ageLabel);
        this.add(panel);
        // Display GUI
        this.setVisible(true);
    }
    public static void main(String[] args) {
        // Creating and intitializing GUI object
        BirthdayGUI GUI = new BirthdayGUI();
        GUI.init();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.calcButton) {
            String birthday = this.textField.getText();
            // Checking if birthday has been entered
            if (birthday.length() == 0) {
                // Error message if nothing entered
                this.ageLabel.setText("Enter birthday first");
            } else if (birthday.length() != 10) {
                // Error message if text is wrong length
                this.ageLabel.setText("Reenter birthday in format (02/07/1990)");
            } else {
                // Correct format entered

                // Getting birthday day
                String monthString = birthday.substring(0,2);
                this.birthMonth = Integer.parseInt(monthString);
                // Getting birthday month
                String dayString = birthday.substring(3,5);
                this.birthDay = Integer.parseInt(dayString);
                // Getting birthday year
                String yearString = birthday.substring(6,10);
                this.birthYear = Integer.parseInt(yearString);

                // Funciton to calc and display birthday
                int age = calcAge();
                this.ageLabel.setText("Age: " + String.valueOf(age));
            }
        }
    }

    public int calcAge() {

        // Getting current date
        LocalDate date = LocalDate.now(); 
        String dateString = date.toString();
        // Getting current year
        String currentYearString = dateString.substring(0, 4);
        int currentYear = Integer.parseInt(currentYearString);
        // Getting current month
        String currentMonthString = dateString.substring(5,7);
        int currentMonth = Integer.parseInt(currentMonthString);
        // Getting current day
        String currentDayString = dateString.substring(8, 10);
        int currentDay = Integer.parseInt(currentDayString);

        // Logic to determine age
        int age = currentYear - this.birthYear - 1;
        if (currentMonth >= this.birthMonth && currentDay >= this.birthDay) {
            age += 1;
        }

        return age;
    }

}
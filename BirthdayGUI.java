import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.*;

public class BirthdayGUI implements ActionListener {
    String buttonText = "Age: ";
    public void main(String[] args) {
        BirthdayGUI GUI = new BirthdayGUI();

        JFrame frame = new JFrame("Birthday Calculator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JButton calcButton = new JButton("Calculate Birthday");
        calcButton.setFont(new Font("Verdana", Font.PLAIN, 30));
        calcButton.addActionListener(GUI);
    
        JLabel ageLabel = new JLabel("Age: ");
        ageLabel.setFont(new Font("Verdana", Font.PLAIN, 30));

        // Adding components
        panel.add(calcButton);
        panel.add(ageLabel);
        frame.add(panel);
        // Display GUI
        frame.setVisible(true);

        // Creating scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter birthday (ex. 02/07/1990):");
        // Reading input
        String birthday = scanner.nextLine();
        scanner.close();

        // Getting day
        String monthString = birthday.substring(0,2);
        int month = Integer.parseInt(monthString);
        System.out.println(month);

        // Getting month
        String dayString = birthday.substring(3,5);
        int day = Integer.parseInt(dayString);
        System.out.println(day);
        
        // Getting year
        String yearString = birthday.substring(6,10);
        int year = Integer.parseInt(yearString);
        System.out.println(year);

        
        // Getting current date
        LocalDate date = LocalDate.now(); 
        String dateString = date.toString();
        System.out.println("Current date: " + dateString);
        
        // Getting current year
        String currentYearString = dateString.substring(0, 4);
        int currentYear = Integer.parseInt(currentYearString);
        System.out.println(currentYear);

        // Getting current month
        String currentMonthString = dateString.substring(5,7);
        int currentMonth = Integer.parseInt(currentMonthString);
        System.out.println(currentMonth);

        // Getting current day
        String currentDayString = dateString.substring(8, 10);
        int currentDay = Integer.parseInt(currentDayString);
        System.out.println(currentDay);
        
        
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("button clicked");
        buttonText = "Age: 0";
        calcAge(buttonText);
    }

    public void calcAge(JLabel l) {
        l.setText(buttonText);
    }


}
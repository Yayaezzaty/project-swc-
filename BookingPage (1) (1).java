import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BookingPage implements ActionListener {
    // Declaration Variables
    private JFrame frame;
    private JComboBox<String> bookingTypesBox, dinnerBox, daysBox, datesBox, timeBox;
    private JCheckBox chkAdult, chkChild;
    private JTextField peopleField;
    private JButton btnNext;
    private String time = "";
    private String selectedMenu = "";
    int qtyAdult = 0, qtyChildren = 0;

    public BookingPage() {
        String[] bookingTypes = {"Dinner", "High-Tea"};
        String[] dinners = {"SINGLE", "COUPLE", "SMALL FAMILY", "BIG FAMILY"};
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] dates = {"April 27, 2024", "April 28, 2024", "April 29, 2024", "May 3, 2024", "May 4, 2024", "May 5, 2024"}; // Sample dates
        String[] dinnerTimes = {"7:00 PM", "8:00 PM", "9:00 PM", "10:00 PM"};
        String[] highTeaTimes = {"3:00 PM", "4:00 PM", "5:00 PM"};

        bookingTypesBox = new JComboBox<>(bookingTypes);
        dinnerBox = new JComboBox<>(dinners);
        daysBox = new JComboBox<>(days);
        datesBox = new JComboBox<>(dates);
        timeBox = new JComboBox<>();

        // PANEL BOOKING TYPES
        JPanel panelBookingTypes = new JPanel();
        panelBookingTypes.setLayout(new GridLayout(1, 0));
        panelBookingTypes.setBorder(BorderFactory.createTitledBorder("Select Booking Type"));
        panelBookingTypes.add(bookingTypesBox);

        // PANEL DAY
        JPanel panelDay = new JPanel();
        panelDay.setLayout(new GridLayout(1, 0));
        panelDay.setBorder(BorderFactory.createTitledBorder("Choose Day"));
        panelDay.add(daysBox);

        // PANEL DATE
        JPanel panelDates = new JPanel();
        panelDates.setLayout(new GridLayout(1, 0));
        panelDates.setBorder(BorderFactory.createTitledBorder("Choose Date"));
        panelDates.add(datesBox);

        // PANEL TIME
        JPanel panelTime = new JPanel();
        panelTime.setLayout(new GridLayout(1, 0));
        panelTime.setBorder(BorderFactory.createTitledBorder("Choose Time"));
        panelTime.add(timeBox);

        // PANEL RESERVATION
        JPanel panelReservation = new JPanel();
        panelReservation.setLayout(new GridLayout(1, 0));
        panelReservation.setBorder(BorderFactory.createTitledBorder("Enter Amount of People"));
        JLabel peopleLabel = new JLabel("Number of Adults:");
        peopleField = new JTextField();
        panelReservation.add(peopleLabel);
        panelReservation.add(peopleField);

        // NEXT BUTTON
        btnNext = new JButton("NEXT");

        // FRAME
        frame = new JFrame();
        frame.setTitle("Booking Page");
        frame.setSize(520, 400);
        frame.setLocation(450, 250);
        frame.setLayout(new GridLayout(6, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panelBookingTypes);
        frame.add(panelDay);
        frame.add(panelDates);
        frame.add(panelTime);
        frame.add(panelReservation);
        frame.add(btnNext);

        // REGISTER LISTENER
        bookingTypesBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String selectedBookingType = (String) bookingTypesBox.getSelectedItem();
                    timeBox.removeAllItems();
                    if (selectedBookingType.equals("Dinner")) {
                        for (String time : dinnerTimes) {
                            timeBox.addItem(time);
                        }
                    } else if (selectedBookingType.equals("High-Tea")) {
                        for (String time : highTeaTimes) {
                            timeBox.addItem(time);
                        }
                    }
                }
            });

        btnNext.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            String selectedBookingType = (String) bookingTypesBox.getSelectedItem();
            String selectedDay = (String) daysBox.getSelectedItem();
            String selectedDate = (String) datesBox.getSelectedItem();
            String selectedTime = (String) timeBox.getSelectedItem();
            int adultQty = Integer.parseInt(peopleField.getText());
            frame.dispose();

            new Receipt(selectedBookingType, selectedDay, selectedDate, selectedTime, adultQty);
        }
    }

    public static void main(String[] args) {
        new BookingPage();
    }
}

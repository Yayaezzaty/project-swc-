import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Receipt extends JFrame implements ActionListener {
    private String bookingType;
    private String day;
    private String date;
    private String time;
    private int adultQty;

    public Receipt(String selectedBookingType, String selectedDay, String selectedDate, String selectedTime, int adultQty) {
        this.bookingType = selectedBookingType;
        this.day = selectedDay;
        this.date = selectedDate;
        this.time = selectedTime;
        this.adultQty = adultQty;

        JTextArea receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);
        receiptTextArea.setFont(new Font("Calibri", Font.BOLD, 17));
        receiptTextArea.setText("\n" + 
                " Booking Type  : " + selectedBookingType + "\n\n" +
                " Day                   : " + selectedDay + "\n\n" +
                " Date                 : " + selectedDate + "\n\n" +
                " Time                 : " + selectedTime + "\n\n" +
                " Adults               : " + adultQty + "\n\n\n" +
                " Thank you for booking with Purnama Palace Dine & Tea!"
        );

        JScrollPane scrollPane = new JScrollPane(receiptTextArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(this);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(closeButton, BorderLayout.SOUTH);

        setTitle("Booking Receipt");
        setSize(550, 400);
        setLocation(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
        System.exit(0);
    }
}

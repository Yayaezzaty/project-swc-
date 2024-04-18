
/** 
 * PROGRAM DESCRIPTION: TO CREATE A WELCOME PAGE FOR RESERVATION  * 
 * Aijaz , Faq'rieyah, Aina
 * 1 April 2024 
 */ 
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
public class WelcomePage extends JFrame implements ActionListener { 
    JButton startButton; 

    public WelcomePage() 
    { 
        //Create a tittle for cinema 
        setTitle("WELCOME TO PURNAMA PALACE DINE  "); 
        setSize(500, 500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        
        //Create a Panel 
        JPanel panel = new JPanel(); 
        panel.setLayout(new BorderLayout()); 
        add(panel); 

        //Create Label 
        JLabel label = new JLabel("WELCOME TO PURNAMA PALACE DINE  ",  SwingConstants.CENTER); 
        label.setFont(new Font("ALGERIAN", Font.BOLD, 22)); 
        panel.add(label, BorderLayout.CENTER); 

        //Create Start Button 
        startButton = new JButton("START"); 

        //Register to a listener 
        startButton.addActionListener(this); 

        panel.add(startButton, BorderLayout.SOUTH); 
        startButton.setBounds(250, 300, 120, 100); 
        setVisible(true); 
    }//end of constructor 

    //method overriding 
    public void actionPerformed(ActionEvent e)
    { 
        if (e.getSource() == startButton) { 
            dispose(); 
            new BookingPage(); 
        }//end of if 
    }//end of method 
    
    public static void main(String[] args) 
    { 
        WelcomePage wp = new WelcomePage (); 
    }//end of the main
}


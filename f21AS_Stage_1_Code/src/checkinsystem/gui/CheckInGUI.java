package checkinsystem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
import java.awt.*;

import javax.swing.*;

import checkinsystem.model.BookingList;
import checkinsystem.model.Passenger;

/**
 * A simple GUI class for the Check-in application.
 * This GUI class is the initial one.
 */
public class CheckInGUI extends JFrame implements ActionListener{

	private BookingList bookingList;
	
	public CheckInGUI(BookingList bookingList) {  
		
		this.bookingList = bookingList;
		
		JFrame frame = new JFrame();
		frame.setTitle("Check In App");
        frame.setBounds(100, 100, 730, 489);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	System.out.println("Report Generated");
            	// Create report output
        		System.out.print("Created On-Exit Report.txt report");
        		String bookingsData = bookingList.getFirstReportData();
        		String flightsData = bookingList.getLastReportData();
        		bookingList.generateFinalReport("On-Exit Report.txt", bookingsData, flightsData); 
            }
        });
        
        JLabel centerLabel = new JLabel("Welcome to Check In App");
        centerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        centerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerLabel.setBounds(0, 30, 730, 30);
        frame.getContentPane().add(centerLabel);
        
        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(220, 100, 150, 14);
        frame.getContentPane().add(lastNameLabel);
        
        JTextField lastNameTextField = new JTextField();
        lastNameTextField.setBounds(370, 100, 150, 20);
        frame.getContentPane().add(lastNameTextField);
        lastNameTextField.setColumns(10);        
        
        JLabel bookingReferenceLabel = new JLabel("Booking Reference");
        bookingReferenceLabel.setBounds(220, 130, 150, 14);
        frame.getContentPane().add(bookingReferenceLabel);
         
        JTextField bookingReferenceTextField = new JTextField();
        bookingReferenceTextField.setBounds(370, 130, 150, 20);
        frame.getContentPane().add(bookingReferenceTextField);
        bookingReferenceTextField.setColumns(10);
        
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		System.out.println(lastNameTextField.getText());
        		System.out.println(bookingReferenceTextField.getText());
        		
        		try {
        			Passenger passenger = bookingList.findByBookingReference(bookingReferenceTextField.getText());
        			
        			if(passenger.getLastName().equalsIgnoreCase(lastNameTextField.getText()) && !passenger.getCheckedInStatus()) {
            			System.out.print("passenger found");
            			
            			lastNameTextField.setText("");
            			bookingReferenceTextField.setText("");
            			CheckInGUI2 secondFrame = new CheckInGUI2(passenger, bookingList);
                        secondFrame.setVisible(true);
            		}
        		}catch( Exception ex) {
        			System.out.println(ex.getMessage());
        			
        			JDialog d = new JDialog(frame, "dialog Box");

                    // create a label
                    JLabel l = new JLabel("No Booking Against this Data!");
                    l.setHorizontalAlignment(SwingConstants.CENTER);
                    d.add(l);

                    d.setBounds(350,220,200,200);

                    // set visibility of dialog
                    d.setVisible(true);

                    lastNameTextField.setText("");
        			bookingReferenceTextField.setText("");
        		}
	
        	}
        });
        
        btnSubmit.setBounds(300, 200, 150, 30);
        
        frame.getContentPane().add(btnSubmit);
        frame.setVisible(true);
	}
        
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}

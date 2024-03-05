package checkinsystem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import javax.swing.*;

import checkinsystem.model.BookingList;
import checkinsystem.model.Passenger;

/**
 * A simple GUI class for the Check-in application.
 * This GUI class is the secondary one.
 */
public class CheckInGUI2 extends JFrame implements ActionListener{
	
	private Passenger passenger;
	
	public CheckInGUI2(Passenger passenger, BookingList bookingLists)
    {
		this.passenger = passenger;
		
		JFrame frame = new JFrame();
		frame.setTitle("Check In App");
        frame.setBounds(150, 150, 600, 400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel detailsLabel = new JLabel("Please Enter Luggage Details");
        detailsLabel.setBounds(220, 70, 200, 15);
        frame.getContentPane().add(detailsLabel);
        
        JLabel lengthLabel = new JLabel("Length");
        lengthLabel.setBounds(150, 100, 150, 14);
        frame.getContentPane().add(lengthLabel);
        
        JTextField lengthTextField = new JTextField();
        lengthTextField.setBounds(320, 100, 150, 20);
        frame.getContentPane().add(lengthTextField);
        lengthTextField.setColumns(10);        
        
        JLabel widthLabel = new JLabel("Width");
        widthLabel.setBounds(150, 130, 150, 14);
        frame.getContentPane().add(widthLabel);
         
        JTextField widthTextField = new JTextField();
        widthTextField.setBounds(320, 130, 150, 20);
        frame.getContentPane().add(widthTextField);
        widthTextField.setColumns(10);
        
        JLabel heightLabel = new JLabel("Height");
        heightLabel.setBounds(150, 160, 150, 14);
        frame.getContentPane().add(heightLabel);
         
        JTextField heightTextField = new JTextField();
        heightTextField.setBounds(320, 160, 150, 20);
        frame.getContentPane().add(heightTextField);
        heightTextField.setColumns(10);
        
        JLabel weightLabel = new JLabel("Weight");
        weightLabel.setBounds(150, 190, 150, 14);
        frame.getContentPane().add(weightLabel);
         
        JTextField weightTextField = new JTextField();
        weightTextField.setBounds(320, 190, 150, 20);
        frame.getContentPane().add(weightTextField);
        weightTextField.setColumns(10);
        
        JLabel excessFeeLabel = new JLabel("Excess Fee");
        excessFeeLabel.setBounds(150, 220, 150, 14);
        frame.getContentPane().add(excessFeeLabel);
         
        JTextField excessFeeTextField = new JTextField();
        excessFeeTextField.setBounds(320, 220, 150, 20);
        excessFeeTextField.setEditable(false);
        frame.getContentPane().add(excessFeeTextField);
        excessFeeTextField.setColumns(10);
        
        JButton btnExcessFee= new JButton("Calculate");
        btnExcessFee.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		System.out.println(passenger.getFirstName());
        		System.out.println(passenger.getLastName());
        		System.out.println(passenger.getBaggageLength());
        		System.out.println(passenger.getBaggageHeight());
        		System.out.println(passenger.getCheckedInStatus());
        		
        		String length = lengthTextField.getText();
        		String width = widthTextField.getText();
        		String height = heightTextField.getText();
        		String weight = weightTextField.getText();
        		
        		Double length_, width_, height_, weight_, volume_;
        		try {
        			length_ = Double.parseDouble(length);
        		}catch(Exception ex) {
        			length_ = 0.0;
        		}
        		try {
        			width_ = Double.parseDouble(width);
        		}catch(Exception ex) {
        			width_ = 0.0;
        		}
        		try {
        			height_ = Double.parseDouble(height);
        		}catch(Exception ex) {
        			height_ = 0.0;
        		}
        		try {
        			weight_ = Double.parseDouble(weight);
        		}catch(Exception ex) {
        			weight_ = 0.0;
        		}
        		
        		volume_ = length_ * width_ * height_;
        		
        		passenger.setBaggageLength(length_);
        		passenger.setBaggageWidth(width_);
        		passenger.setBaggageHeight(height_);
        		passenger.setBaggageWeight(weight_);
        		passenger.setBaggageVolume(volume_);
        		passenger.setCheckInStatus(true);
        		
        		double excessFee = passenger.caculateExcessFee();
        		excessFeeTextField.setText(String.valueOf(excessFee));
        	}
        });
        btnExcessFee.setBounds(480, 220, 100, 20);
        frame.getContentPane().add(btnExcessFee);
        
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		frame.setVisible(false);
        		
        		bookingLists.updatePassengerDetails(passenger);
        		
        		Passenger ps = bookingLists.findByBookingReference(passenger.getBookingReference());
        		System.out.println(ps.getFirstName());
        		System.out.println(ps.getLastName());
        		System.out.println(ps.getBaggageLength());
        		System.out.println(ps.getBaggageHeight());
        		System.out.println(ps.getCheckedInStatus());
        		
        		// Create report output
        		System.out.print("Created On-Exit Report.txt report");
        		String bookingsData = bookingLists.getFirstReportData();
        		String flightsData = bookingLists.getLastReportData();
        		bookingLists.generateFinalReport("On-Exit Report.txt", bookingsData, flightsData);
        		
        		JDialog d = new JDialog(frame, "dialog Box");
        		 
                // create a label
                JLabel l = new JLabel("Check In Success!");
                l.setHorizontalAlignment(SwingConstants.CENTER);
                d.add(l);
    
                d.setBounds(350,220,200,200);
     
                // set visibility of dialog
                d.setVisible(true);
                
        		System.out.println("Check In Success");
        	}
        });
        
        btnSubmit.setBounds(220, 250, 150, 30);
        
        frame.getContentPane().add(btnSubmit);
        frame.setVisible(true);
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
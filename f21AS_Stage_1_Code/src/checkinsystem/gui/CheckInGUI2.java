package checkinsystem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter; // TODO Tag - Abeer fix
import java.awt.event.WindowEvent; // TODO Tag - Abeer fix

import java.awt.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import checkinsystem.model.BookingList;
import checkinsystem.model.CheckInException;
import checkinsystem.model.Passenger;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        
        // TODO Tag - Abeer fix
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	System.out.println("Report Generated");
            	// Create report output
        		System.out.print("Created On-Exit Report.txt report");
        		String bookingsData = bookingLists.getFirstReportData();
        		String flightsData = bookingLists.getLastReportData();
        		bookingLists.generateFinalReport("On-Exit Report.txt", bookingsData, flightsData); 
            }
        });
        
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
        
        JLabel lengthErrorMessage = new JLabel("Please input valid length");
        lengthErrorMessage.setBounds(320, 118, 150, 14);
        lengthErrorMessage.setForeground(Color.red);
        lengthErrorMessage.setVisible(false);
        frame.getContentPane().add(lengthErrorMessage);
        
        JLabel widthLabel = new JLabel("Width");
        widthLabel.setBounds(150, 130, 150, 14);
        frame.getContentPane().add(widthLabel);
         
        JTextField widthTextField = new JTextField();
        widthTextField.setBounds(320, 130, 150, 20);
        frame.getContentPane().add(widthTextField);
        widthTextField.setColumns(10);
        
        JLabel widthErrorMessage = new JLabel("Please input valid width");
        widthErrorMessage.setBounds(320, 148, 150, 14);
        widthErrorMessage.setForeground(Color.red);
        widthErrorMessage.setVisible(false);
        frame.getContentPane().add(widthErrorMessage);
        
        JLabel heightLabel = new JLabel("Height");
        heightLabel.setBounds(150, 160, 150, 14);
        frame.getContentPane().add(heightLabel);
         
        JTextField heightTextField = new JTextField();
        heightTextField.setBounds(320, 160, 150, 20);
        frame.getContentPane().add(heightTextField);
        heightTextField.setColumns(10);
        
        JLabel heightErrorMessage = new JLabel("Please input valid height");
        heightErrorMessage.setBounds(320, 178, 150, 14);
        heightErrorMessage.setForeground(Color.red);
        heightErrorMessage.setVisible(false);
        frame.getContentPane().add(heightErrorMessage);
        
        JLabel weightLabel = new JLabel("Weight");
        weightLabel.setBounds(150, 190, 150, 14);
        frame.getContentPane().add(weightLabel);
         
        JTextField weightTextField = new JTextField();
        weightTextField.setBounds(320, 190, 150, 20);
        frame.getContentPane().add(weightTextField);
        weightTextField.setColumns(10);
        
        JLabel weightErrorMessage = new JLabel("Please input valid weight");
        weightErrorMessage.setBounds(320, 208, 150, 14);
        weightErrorMessage.setForeground(Color.red);
        weightErrorMessage.setVisible(false);
        frame.getContentPane().add(weightErrorMessage);
        
        JLabel excessFeeLabel = new JLabel("Excess Fee");
        excessFeeLabel.setBounds(150, 220, 150, 14);
        frame.getContentPane().add(excessFeeLabel);
         
        JTextField excessFeeTextField = new JTextField();
        excessFeeTextField.setBounds(320, 220, 150, 20);
        excessFeeTextField.setEditable(false);
        frame.getContentPane().add(excessFeeTextField);
        excessFeeTextField.setColumns(10);
        
        JLabel excessFeeErrorMessage = new JLabel("Please calculate excess fee");
        excessFeeErrorMessage.setBounds(320, 238, 200, 14);
        excessFeeErrorMessage.setForeground(Color.red);
        excessFeeErrorMessage.setVisible(false);
        frame.getContentPane().add(excessFeeErrorMessage);
        
        JButton btnExcessFee= new JButton("Calculate");
        btnExcessFee.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		excessFeeErrorMessage.setVisible(false);
        		
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

        		volume_ = length_ * width_ * height_; // TODO Volume conversion to cm3 goes here?
        		
        		try {
					passenger.setBaggageLength(length_);
				} catch (CheckInException cIE) {
			
					// Print the associated system error message 
					System.out.println("The entered length value of " + cIE.getMessage());
				}
        		
        		try {
					passenger.setBaggageWidth(width_);
				} catch (CheckInException cIE) {
				
					// Print the associated system error message 
					System.out.println("The entered width value of " + cIE.getMessage());
				}
        		
        		try {
					passenger.setBaggageHeight(height_);
				} catch (CheckInException cIE) {
					
					// Print the associated system error message 
					System.out.println("The entered height value of " + cIE.getMessage());
				}
        		
        		try {
					passenger.setBaggageWeight(weight_);
				} catch (CheckInException cIE) {
					
					// Print the associated system error message 
					System.out.println("The entered weight value of " + cIE.getMessage());
					
					// End with system exit
					//System.exit(0);
				}
        		
        		try {
					passenger.setBaggageVolume(volume_);
				} catch (CheckInException cIE) {
					
					// Print the associated system error message 
					System.out.println("The calculated volume value of " + cIE.getMessage());
				}
        		
        		passenger.setCheckInStatus(true); // original
        		
        		double excessFee = passenger.caculateExcessFee(); 
        		excessFeeTextField.setText(String.valueOf(excessFee)); 
        	}
        });
        btnExcessFee.setBounds(480, 220, 100, 20);
        frame.getContentPane().add(btnExcessFee);
        
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		if(lengthTextField.getText().isBlank() && lengthTextField.getText().isEmpty()) {
        			lengthErrorMessage.setVisible(true);
        		}
        		if(heightTextField.getText().isBlank() && heightTextField.getText().isEmpty()) {
        			heightErrorMessage.setVisible(true);
        		}
        		if(widthTextField.getText().isBlank() && widthTextField.getText().isEmpty()) {
        			widthErrorMessage.setVisible(true);
        		}
        		if(weightTextField.getText().isBlank() && weightTextField.getText().isEmpty()) {
        			weightErrorMessage.setVisible(true);
        		}
        		if (excessFeeTextField.getText().isBlank() && excessFeeTextField.getText().isEmpty()) {
        			excessFeeErrorMessage.setVisible(true);
        		}
        		if(!lengthErrorMessage.isVisible() && !widthErrorMessage.isVisible() && !heightErrorMessage.isVisible() && !weightErrorMessage.isVisible() && !excessFeeErrorMessage.isVisible()) {
        			frame.setVisible(false);
            		
            		try {
    					bookingLists.updatePassengerDetails(passenger);
    				} catch (CheckInException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
            		
            		Passenger ps = bookingLists.findByBookingReference(passenger.getBookingReference());
            		System.out.println(ps.getFirstName());
            		System.out.println(ps.getLastName());
            		System.out.println(ps.getBaggageLength());
            		System.out.println(ps.getBaggageHeight());
            		System.out.println(ps.getCheckedInStatus());
            		
            		// Create report output TODO Tag - commented out as per Abeer's fix
            		/*
            		System.out.print("Created On-Exit Report.txt report");
            		String bookingsData = bookingLists.getFirstReportData();
            		String flightsData = bookingLists.getLastReportData();
            		bookingLists.generateFinalReport("On-Exit Report.txt", bookingsData, flightsData);
            		*/
            		
            		JDialog d = new JDialog(frame, "dialog Box");
            		 
                    // create a label
                    JLabel l = new JLabel("Check In Success!");
                    l.setHorizontalAlignment(SwingConstants.CENTER);
                    d.getContentPane().add(l);
        
                    d.setBounds(350,220,200,200);
         
                    // set visibility of dialog
                    d.setVisible(true);
                    
            		System.out.println("Check In Success");
        		}
        		
        	}
        });
        
        btnSubmit.setBounds(220, 250, 150, 30);
        
        lengthTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void changedUpdate(DocumentEvent e) {
            }

			@Override
			public void insertUpdate(DocumentEvent e) {
				String length = lengthTextField.getText();
        		Double length_;
        		
        		try {
        			length_ = Double.parseDouble(length);
        		}catch(Exception ex) {
        			length_ = 0.0; 
        		}
        		
        		try {
					passenger.setBaggageLength(length_);
					lengthErrorMessage.setVisible(false);
				} catch (CheckInException cIE) {
					lengthErrorMessage.setVisible(true);
					// Print the associated system error message 
					System.out.println("The entered length value of " + cIE.getMessage());
					
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String length = lengthTextField.getText();
        		Double length_;
        		
        		try {
        			length_ = Double.parseDouble(length);
        		}catch(Exception ex) {
        			length_ = 0.0; 
        		}
        		
        		try {
					passenger.setBaggageLength(length_);
					lengthErrorMessage.setVisible(false);
				} catch (CheckInException cIE) {
					lengthErrorMessage.setVisible(true);
					// Print the associated system error message 
					System.out.println("The entered length value of " + cIE.getMessage());
					
				}
			}
        });
        
        widthTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void changedUpdate(DocumentEvent e) {
            }

			@Override
			public void insertUpdate(DocumentEvent e) {
				String width = widthTextField.getText();
        		Double width_;
        		
        		try {
        			width_ = Double.parseDouble(width);
        		}catch(Exception ex) {
        			width_ = 0.0; 
        		}
        		
        		try {
					passenger.setBaggageWidth(width_);
					widthErrorMessage.setVisible(false);
				} catch (CheckInException cIE) {
					widthErrorMessage.setVisible(true);
					// Print the associated system error message 
					System.out.println("The entered width value of " + cIE.getMessage());
					
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String width = widthTextField.getText();
        		Double width_;
        		
        		try {
        			width_ = Double.parseDouble(width);
        		}catch(Exception ex) {
        			width_ = 0.0; 
        		}
        		
        		try {
					passenger.setBaggageWidth(width_);
					widthErrorMessage.setVisible(false);
				} catch (CheckInException cIE) {
					widthErrorMessage.setVisible(true);
					// Print the associated system error message 
					System.out.println("The entered width value of " + cIE.getMessage());
					
				}
			}
        });
        
        heightTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void changedUpdate(DocumentEvent e) {
            }

			@Override
			public void insertUpdate(DocumentEvent e) {
				String height = heightTextField.getText();
        		Double height_;
        		
        		try {
        			height_ = Double.parseDouble(height);
        		}catch(Exception ex) {
        			height_ = 0.0; 
        		}
        		
        		try {
					passenger.setBaggageWidth(height_);
					heightErrorMessage.setVisible(false);
				} catch (CheckInException cIE) {
					heightErrorMessage.setVisible(true);
					// Print the associated system error message 
					System.out.println("The entered height value of " + cIE.getMessage());
					
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String height = heightTextField.getText();
        		Double height_;
        		
        		try {
        			height_ = Double.parseDouble(height);
        		}catch(Exception ex) {
        			height_ = 0.0; 
        		}
        		
        		try {
					passenger.setBaggageWidth(height_);
					heightErrorMessage.setVisible(false);
				} catch (CheckInException cIE) {
					heightErrorMessage.setVisible(true);
					// Print the associated system error message 
					System.out.println("The entered height value of " + cIE.getMessage());
					
				}
			}
        });
        
        weightTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void changedUpdate(DocumentEvent e) {
            }

			@Override
			public void insertUpdate(DocumentEvent e) {
				String weight = weightTextField.getText();
        		Double weight_;
        		
        		try {
        			weight_ = Double.parseDouble(weight);
        		}catch(Exception ex) {
        			weight_ = 0.0; 
        		}
        		
        		try {
					passenger.setBaggageWidth(weight_);
					weightErrorMessage.setVisible(false);
				} catch (CheckInException cIE) {
					weightErrorMessage.setVisible(true);
					// Print the associated system error message 
					System.out.println("The entered weight value of " + cIE.getMessage());
					
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String weight = weightTextField.getText();
        		Double weight_;
        		
        		try {
        			weight_ = Double.parseDouble(weight);
        		}catch(Exception ex) {
        			weight_ = 0.0; 
        		}
        		
        		try {
					passenger.setBaggageWidth(weight_);
					weightErrorMessage.setVisible(false);
				} catch (CheckInException cIE) {
					weightErrorMessage.setVisible(true);
					// Print the associated system error message 
					System.out.println("The entered weight value of " + cIE.getMessage());
					
				}
			}
        });
        
        frame.getContentPane().add(btnSubmit);
        frame.setVisible(true);
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
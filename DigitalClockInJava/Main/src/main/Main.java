
package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class Main extends JFrame{
    private JLabel timeLabel;
    private JLabel dateLabel;
    
    public Main(){
        setTitle("Digital Clock");
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);    
        
        //Create a panel to hold the time and date labels
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        panel.setLayout(new BorderLayout());
        
        //create a label to display the time
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);    
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(Color.red);
        
        //create a label to display the date
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dateLabel.setVerticalAlignment(SwingConstants.CENTER);
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setForeground(Color.WHITE);
        
        //add the time and date labels to the panel
        panel.add(timeLabel, BorderLayout.CENTER);
        panel.add(dateLabel, BorderLayout.SOUTH);
        
        //set the panel's background color
        panel.setBackground(Color.BLACK);
        
        //add the panel to the frame
        add(panel);
        
        // use a timer to update the time and date labels every second
        Timer timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateTimeAndDate();
                
            }
        });
        timer.start();
    }
    
    private void updateTimeAndDate(){
        //Get the current time and format it
       Calendar calendar = Calendar.getInstance();
       SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
       String time = timeFormatter.format(calendar.getTime());
       
       //get the currenrt date and format it
       SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE, MMM dd, yyyy");
       String date = dateFormatter.format(calendar.getTime());
       
       //update the time and date labels
       timeLabel.setText(time);
       dateLabel.setText(date);
       
    }
    
    public static void main(String[] args) {
        Main clock = new Main();
        clock.setVisible(true);
    }
    
}

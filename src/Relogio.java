
import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class Relogio extends JFrame{
 
	 Calendar calendar;
	 SimpleDateFormat timeFormat;
	 SimpleDateFormat dayFormat;
	 SimpleDateFormat dateFormat;
	 private JLabel timeLabel;
	 private JLabel dayLabel;
	 private JLabel dateLabel;
	 private String time;
	 private String day;
	 private String date;
	 private Container cont;

	 public Relogio()
	 {
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setTitle(" Relogio ");
		  setLayout(new FlowLayout());
		  setSize(500,200);
		  setLocationRelativeTo(null);
		  setResizable(true);
		  
		  cont=getContentPane();
		  
		  timeFormat = new SimpleDateFormat("hh:mm:ss a");
		  dayFormat = new SimpleDateFormat("EEEE");
		  dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		  
		  timeLabel = new JLabel();
		  timeLabel.setFont(new Font("Lucida Calligraphy",Font.PLAIN,50));
		  timeLabel.setForeground(new Color(0x123456));
		  timeLabel.setBackground(Color.CYAN);
		  timeLabel.setOpaque(true);
		  
		  dayLabel = new JLabel();
		  dayLabel.setFont(new Font("Calibri",Font.PLAIN,35));
		  
		  dateLabel = new JLabel();
		  dateLabel.setFont(new Font("Calibri",Font.PLAIN,25));
		  
		  
		  cont.add(timeLabel);
		  cont.add(dayLabel);
		  cont.add(dateLabel);
		  setVisible(true);
		  
		  setTime();
	 }
	 
	 public void setTime() 
	 {
		  while(true) {
		  time = timeFormat.format(Calendar.getInstance().getTime());
		  timeLabel.setText(time);
		  
		  day = dayFormat.format(Calendar.getInstance().getTime());
		  dayLabel.setText(day);
		  
		  date = dateFormat.format(Calendar.getInstance().getTime());
		  dateLabel.setText(date);
		
		  
	  try {
		  Thread.sleep(1000);
	  } catch (InterruptedException e) {
	   // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
  }
 }
	 public static void main(String[] args) {
		  
		  new Relogio();
		 }
}
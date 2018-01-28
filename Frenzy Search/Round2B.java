import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import java.util.regex.*;
class Round2B
{	
	int total=50;
	int qn=1;
	JFrame JF1,JF2;
	JLabel JL1,JL2,timecounter,img;
	JTextArea JTA1;
	JButton JB1,JB2,JB3,start;
	int TimeLimit=1;
	boolean strt=false;
	int minutes,seconds=0;
	String[] splitted=new String[50];
	String answer_low_case, split_low_case, temp,temp2,temp3,newtemp;
	public int flag=0,count=0,ans,score=0;
	public String name;
	int ar[]=new int[31];
	int i;
	String qw="";
	String ansr;	
	public int quesNo=1;
	//public int count=0;
	static String []question =new String[]{"",
"1)Payment for cloud computing services is usually based on this model. What is it?",
"2)What breaks a public key (RSA-150)?",
"3)Theoretically Li-fi can achieve a speed of ",
"4)Who designed the ‘first’ small computer for home use?",
"5)Who gave the first computer mouse to the world.",
"6)Domain registration was free until when? Use (dd/mm/yyyy) format",
"7)What is the use to print a data in the webpage?",
"8)Sessions are stored on the ----, and ----- are stored on the user's computers in the text file format",
"9)What is the input device used to track the emotions of a user by a simple touch on it?",
"10)James Gosling team for developing Java (sun Microsystem) was known as? ",
"11)Fourth generation of nano technology is:",
"12)The idea of using compressed air to power a vehicle was first put forth in which century?",
"13)----- is the practice of using information technology to obtain secret information without permission from its owners or holders",
"14)How much solar energy reaches the Earth's surface at any given moment?",
"15)Development of a nanoplate was done in which lab?",
"16)SnapDragon S1 chip of 65nm,had a clock speed upto ______ GHz  ",
"17)Goldmont Series had a Maximum clock speed of ____MHz ",
"18)ILS is a technique introduced by the ________ to ensure that the supportability of an equipment item.",
"19)Processors built using AMD Zen will utilize 14 nm ______ silicon.",
"20)In hub polling, also referred to as token polling, each element polls the next element in some _______ sequence",
"21)Snapdragon 801 has the highest bandwidth of ______GB/s",
"22)Andiod is licensed under which licensing license?",
"23)Error detection at the data link level is achieved by___",
"24)Unmodulated signal coming from a transmitter is know as?",
"25)Bubble power works under the principle of sonofusion , which is technically known as:__ __ ___ ___ ",
"26)What is the cost of first eyephone?? (not iPhone)",
"27)United States deployed an experimental e-bomb on _____",
"28)OS Version of iTV : ",
"29)Initial general name of apple's logo ?",
"30)Who assisted in making first computer mouse ?"			
};
	
	
	static String []Answer =new String[]{"",
//1
"utility computing",
//2
"Shor's algorithm",
//3
"224 GBPS",
//4
" John Blankenbaker",
//5
"Douglas Engelbart",
//6
"14/09/1995",
//7
"echo",
//8
"server,cookies",
//9
"Emotion mouse",
//10
"Green Team",
//11
"Molecular Nanosystem",
//12
"19 century",
//13
"Cyber espionage",
//14
"173,000 terawatts",
//15
"Brookhaven National Lab",
//16
"1",
//17
"800",
//18
"US Army",
//19
"FinFET",
//20
"Fixed",
//21
"14.9",
//22
"Apache/MIT",
//23
"Cyclic Redundancy Code",
//24
"Baseband signal",
//25
"acoustic inertial confinement fusion",
//26
"$ 500",
//27
"March 24, 2003",
//28
"OS X Tiger",
//29
"Rainbow logo",
//30
"Bill English"
};
	Round2B()
	{
		JF1= new JFrame();
		JF1.setBounds(0,0,1366,768);
		JF1.setLayout(null);
		JF1.setBounds(0,0,1366,778);
		img=new JLabel(new ImageIcon("tp1.jpg"));
		img.setBounds(0,0,1366,778);
		JF1.add(img);
		img.setLayout(null);
		JL1 = new JLabel("Frenzy Search");
		JL1.setFont(new Font("Verdana ", Font.BOLD, 50));
		JL2 = new JLabel("");
		JL2.setFont(new Font("Verdana", Font.BOLD, 20));
		JL2.setForeground(Color.white);
		JL1.setForeground(Color.lightGray);
		timecounter=new JLabel();
		timecounter.setFont(new Font("Courier New",Font.BOLD,25));
		JB2 = new JButton("Next");
		JB3 = new JButton("Exit");
		start=new JButton("Start");
		JTA1 = new JTextArea();
		timecounter.setBounds(45,300,500,400);
		timecounter.setFont(new Font("Verdana",Font.BOLD,20));
		timecounter.setForeground(Color.white);
		JL1.setBounds(400,30,500,50);
		JL2.setBounds(45,160,1500,40);
		Border border = BorderFactory.createLineBorder(Color.gray,5);
		JTA1.setBorder(border);
		JTA1.setBounds(45,250,500, 200);
		JTA1.setFont(new Font("Verdana",Font.BOLD,25));
		start.setBounds(450,500,250,50);
		start.addActionListener(new Action());
		JB2.setBounds(600,610,150,50);
		JB3.setBounds(1100,610,100,50); 
		JB3.addActionListener(new Action());
		img.add(JL1);
		img.add(JL2);
		img.add(start);
		img.add(JB3);
		JF1.setVisible(true);
	}
	public class Action implements ActionListener
	{	

		public void actionPerformed(ActionEvent ae)
		{
			try
			{
				String  event = ae.getActionCommand();
				if(event.equals("Exit")) 
				{	

					savedata();
					
				}
				else if(event.equals("Start"))
				{	
					
					try 
   					{	
   						Object studentname = JOptionPane.showInputDialog(JF1, "Enter your Full Name without spaces :");
						name=studentname.toString();
						int aq=name.length();
						if(aq < 1) 
						{
							name = "Anonymous";
						}
						else 
						{
							name = name;
						}

 						Class.forName("com.mysql.jdbc.Driver");    // check for feasibility
			   			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Frenzy2","root","root");
	            		Statement st = cn.createStatement();
	            		String a="CREATE TABLE IF NOT EXISTS  ";
	            		a = a.concat(name);
	            		a =	a.concat(" (qno int, answer varchar(250))");		
                		st.executeUpdate(a);
                		
                	}
                	catch(NullPointerException e)
					{ 	
						System.exit(0); 
					}
					
					JB2.addActionListener(new Action());
					img.add(JB2);
					JB2.setVisible(true);
					start.setVisible(false);
					strt=true;
					seconds=70;
					img.add(JTA1);
					if(TimeLimit >0)new Timer();
					img.add(timecounter);
					JL2.setText(question[quesNo]);
					
				}//start end
					
						if(strt)
						{
							if (event.equals("Next")) 
							{	
								NextButton();
							}
					}
				
			}//outer try end
			catch(Exception e)
			{
				System.out.println(e);
			}	
		}//actionperformed close

		public void NextButton()
		{
			
	    	ansr=JTA1.getText();
	    	i++;
	        
	        if(ansr!=null)
	       	{
	        	try
	        	{	
	        		Class.forName("com.mysql.jdbc.Driver");    // check for feasibility
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Frenzy2","root","root");
					Statement st = cn.createStatement();
                	String s1="insert into ";
                	s1= s1.concat(name);
                	s1= s1.concat(" values('"+quesNo+"','"+ansr+"')");
                	st.executeUpdate(s1);
	            	String check1= "select * from ";
	            	check1=check1.concat(name);
	            	check1=check1.concat(" where qno='"+quesNo+"'");
					ResultSet r1=st.executeQuery(check1);					
					while(r1.next())
					{
						qw= r1.getString(2);		
					}
					JTA1.setText("");
					if(qw ==null) 
					{		
				   		String temp="insert into ";
				   		temp=temp.concat(name);
				   		temp=temp.concat(" values('"+quesNo+"','"+ansr+"')");
	            		st.executeUpdate(temp);
	            		JTA1.setText("");
	            	}

					else
					{
						String updat="update ";
						updat=updat.concat(name);
						updat=updat.concat(" set answer='"+ansr+"'where qno='"+quesNo+"'");
						st.executeUpdate(updat);
						JTA1.setText("");

					}
					check();
					quesNo++;	
					if (quesNo<=total) 
					{	
						JL2.setText(question[quesNo]);
					}

					else
					{
						JL2.setText(question[1]);
					}

					qn=qn+1;
					seconds=70;

									}
					
	        	catch(SQLException e)
	        	{
					JOptionPane.showMessageDialog(null, e);                    
	        	    
	        	} 
	        	catch (ClassNotFoundException ex) 
	        	{
	        	     Logger.getLogger(Round2B.class.getName()).log(Level.SEVERE, null, ex);
	    		}
			}
		}//next button end

		public void check()
		{
			splitted = Answer[(quesNo)].split("\\s+");
			answer_low_case=ansr.toLowerCase();
				for(int index=0; index < splitted.length ; index++)
				{	
					temp = splitted[index];
					 if(answer_low_case.contains(temp.toLowerCase()))
					{
							ans=1;
							flag = flag | ans;
					}

			}

			if(flag==1)
			{
				score++;
				flag=0;
			}

		}//check end
		

        
		public class Timer extends Thread implements Runnable
        {
			public Timer()
			{
				new Thread(this).start();
			}

    	public void run() 
    	{
			while(strt)
			{
    	        try 
    	        {
    	           Thread.sleep(1000);
    	          
    	           ar[i]=(70-seconds);
    	            seconds--;
					if(seconds==0)
					{
						/*minutes--;
						seconds=59;*/
    	                NextButton();
    	                
					}
					timecounter.setText("Time Counter : "+seconds+" seconds");
					if(qn==31)
					{
						
						JTA1.setVisible(false);
						JL2.setVisible(false);
						JB2.setVisible(false);
						timecounter.setText("Game over please click on EXIT.....");
					}
			    }
   	         catch(InterruptedException ex)  { System.out.print(ex); }
			}
   	 	}
	}
	public void savedata()
{	

	qn++;
	int sum=0;

	for(int j=0;j<30;j++)
	{
		sum=sum+ar[j];

	}

	String a=Integer.toString(sum);
	try
	       		{	

	    			Class.forName("com.mysql.jdbc.Driver");    // check for feasibility
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Frenzy2","root","root");
	            	Statement st = cn.createStatement();
	            	String s1="insert into ";
	            	s1=s1.concat(name);
	            	s1=s1.concat(" values('"+qn+"','"+a+"')");
	            	st.executeUpdate(s1);	            	
	            	qn++;
	            	String s2="insert into ";
	            	s2=s2.concat(name);
	            	s2=s2.concat(" values('"+qn+"','"+score+"')");
	            	st.executeUpdate(s2);
	            }
	            catch(SQLException e)
	        	{
					JOptionPane.showMessageDialog(null, e);                    
	        	    
	        	} 
	        	catch (ClassNotFoundException ex) 
	        	{
	        	     Logger.getLogger(Round2B.class.getName()).log(Level.SEVERE, null, ex);
	    		}

	JF1.dispose();
	System.exit(0);
}
	

	
}
	public static void main(String args[])
	{	
		Round2B F = new Round2B();
	}

}



import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import java.util.regex.*;

class Round1B
{	
	int total=101;
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
	int ar[]=new int[30];
	int i;
	int rank[]=new int[102];
	String qw="";
	String ansr;	
	public int quesNo=1;
	static String []question =new String[]{"",
		"1)Which Dialect of C appears to be at a Development Standstill since 1996 ?",
"2) Marvel Comics owned the rights to the word “zombie” from___through 1996(yyyy)",
"3)The only player to rush for a 99-yard touchdown",
"4)If x = 10 to the power negative 1, what is the value of (x+(1/x))*(1/x)",
"5)____ is an international collaboration between three space agencies and 17 nations contributed to building the spacecraft?",
"6)____ are one of two (non-human) primates to have truly blue eyes.",
"7)___ is the largest of Saturn's moons.",
"8)A guy from Indiana named ______ came up with the idea of venom",
"9)Father of American Football",
"10)The Company that created Pokemon Go also created the ______ game ? ",
 "11) _____ Killed the Entire Marvel Universe, Including Himself ",
"12)Acorn RISC Machine has the highest address bus width of _____ bits ",
"13)__was the series of revolutionary satellites that were first launched in 1972 ",
"14)The “G” on the Green Bay Packers helmet stands for?",
"15)Reliability, availability and serviceability (RAS) is a computer hardware engineering term was introduced by _____",
"16)Wonder Woman was originally named ____",
"17)Locked-in syndrome usually results in _______ and the inability to speak",
 "18)The ___ can only eat when its head is upside down.",
"19)___was India’s first indigenous satellite launch vehicle and A.P.J. Abdum Kalam Ji was the director of the project",
"20)C was originally developed re-implement the ______ OS.",
"21)Elton Johns song Tiny Dancer reminds him of ?",
"22)Which company Provides Pulse Width Modulation Coolers to Upcomming AMD processors ?",
"23)In which year the youngest Australian emerged to score a Century ?",
 "24)The  French Impressionist,who drew Magpie died in which city ?",
"25)Approximately 70% of virus writers are said to work under contract for ______",
"26)Which player of San Jose SaberCats set the AFL single-season record for extra points made with 128 and led the league with 158 kick points   during the 2007 season ?",
"27)The Highest amount of elevation at 'Faraway How',GreenLand is ?",
"28)The economic development arm of the University of South Carolina,was created by which  USC President ? ",
"29)Turbo Cidaris belongs to clade?",
"30)The scientific name of the red fox is .",
"31)The NASA _________ is located in Edwards, California.",
"32)Apple and pear seeds contain arsenic, which may be deadly to dogs.",
"33)In ___the immemorial four ball over was replaced by a five ball over in cricket(YYYY) ",
"34)____is the longest word that you can write using the letters only on one row of the keyboard of your computer.",
"35)Wittenborg University offered English to international students of approximately  How many countries ?",
"36) Name the first electronic computer",
"37)A web-based 3D satellite imagery tool which is the Indian incarnation of Google Earth",
"38)Die Hard originated from the failed script of ",
"39)______ invented the fax machine",
"40)_____,the only one country who has reached to the MARS in its FIRST attempt",
"41)The first ever VCR, which was made in ____",
"42)Microsoft’s third Xbox console was released on?(dd/mm/yyyy)",
"43)____are the only coed professional basketball team",
"44)The first Winter Olympic Games were held in which city?",
"45)ISRO has till date launched __consecutive successful PSLV launches",
"46)[Ctrl] + [Alt] + [Delete] sequence was written by ?",
"47) ____ was the first personal computer built on Intel processor 8008",
"48)First hard disk drive was introduced by ?",
"49)____ crossed the burled arch marking the finish line on Front Street in Nome, Alaska he became the first musher to do so in less than nine days.",
"50)In the Star Wars universe, what is the name of Han Solo's youngest son?",
"51)If a(n) denotes the nth term in an Arithmetic Progression. Then 1/a(1)a(2) +1/a(2)a(3) +………………………………+1/a(n-1)a(n)=",
"52)The steps and tasks needed to process data, such as responses to questions or clicking an icon, are called",
"53)The first home computer which was sold in millions of units was ",
"54)________ tags, when placed on an animal, can be used to record and track in a database all of the animals",
"55)In 2016, which country was estimated to have approximately 3.5% of the world population?",
"56)Upon completion in 1884, what became the world's tallest structure for 5 years until the completion of the Eiffel Tower?",
"57) Who was the science advisor on the first Star Trek film?",
"58)Which of the following is the newest element to be discovered and synthesised?",
"59)Name Pluto's moon",
"60)The acid generally stored in batteries is",
"61)Who was the first to observe Sun spots? ",
"62)What is the worlds longest race?",
"63)Standard cricket bats are made of",
"64)Who is the youngest world champion in the history of Formula One Races to-late ?",
"65)When did the first Commonwealth Games take place? ",
"66)Who has scored the highest run in a test cricket innings?  ",
"67)Which of the following is a hyper-defensive football strategy?",
"68)Which artist painted The Scream?",
"69)First Indian movie submitted for Oscar?",
"70)First Indian to win Oscar?",
"71)In which system, the Shadow mask methods are commonly used",
"72)___________ is a 3-D environment which is created artificially by using computer hardware and software.",
"73)In linked list each node contain minimum of two fields. One field is data field to store the data second field is?",
"74)Which class cannot be subclassed (or extended) in java?",
"75)Suspend thread can be revived by using",
"76)Similarly, the backstory for Transformers and most of the original characters including Optimus Prime and Megatron, were created by Marvel editors ____ and Denny O’Neil. ",
"77)Java intermediate code is known as",
"78)Marvel Comics and DC Comics have co-owned the trademark for the phrase “super hero” since________?(YYYY)",
"79)A manufacturer wants to earn 25% profit on a shirt that cost Rs.100, he should charge Rs. ?",
"80)Which of the following would you use to test a variable for five different values?",
"81)Which method is used in every Java program?",
"82)Technology no longer protected by copyright, available to everyone, is considered to be:",
"83)DHCP Sethe only one country who has reached to the MARS in his FIRST attemptrvers provides __to client?",
"84)For error dectection _____is used by the higher level protocols(TCP/IP).?",
"85)Controlling acces to a network by analyzing the incoming and outgoing packets is called .?",
"87)_____invented the first computer mouse?",
"88)The first ever hard disk drive was made in ___",
"89)J.A.R.V.I.S is an acronym for?",
"90)The Triangulum Galaxy, also known as ",
"91)_____deals with the commercialization of space products, consultancy and technology transfer developed by the ISRO",
"92)ISRO has also launched __ foreign satellites till date",
"93)What city is attacked in the 2008 film Cloverfield? ",
"94)What will be the output of this code?String aString = 'Crayons are great!';System.out.print(aString.charAt(8))",
"95)Which keyword would you use if you wanted a class to use an interface?",
"96)Which layout class would you use to lay out components from left to right?",
"97)Which of the following can be used to access the first element of an array named arrOne?",
"98)Which package is imported by default into Java programs?",
"99)What is it called when an instance of a class is also an instance of its superclass?",
"100)Which interface would you use to handle the event of a user clicking inside a textbox?"

				};
	
	
	static String []Answer =new String[]{"",
		//1 
"Split-C",
 //2
 "1975",
 //3
 "Tony Dorsett",
 //4
 "101",
 //5
 "Cassini-Huygens Mission",
 //6
 "Blue-eyed lemurs",
 //7
 "Titan",
  //8
  "Randy Schueller",
 //9
 "Walter Camp",
//10
 "Ingress ",
 //11
  " The Punisher",
 //12
  "26 ",
 //13 
 "Landsat ",
 //14
  "greatness",
 //15 
 "IBM ",
 //16
  "Suprema",
  //17
   "quadriplegia ",
//18 
"flamingo",
 //19
  "SLV-3 ",
 //20 
 "Unix",
  //21
   "The Humming Bird",
 //22
  "Noctua",
 //23
  "1948",
 //24
  "Giverny",
 //25 
 "organized crime syndicates",
 //26
  "A. J. Haglund",
//27
 "1,398 m (4,587 ft)",
 //28
 "New York",
 //29 
 "Vetigastropoda",
 //30
 "Vulpes vulpes",
 //31
 "	Dryden Flight Research Center ",
 //32
 "arsenic",
 //33
 "1889 ",
 //34
 "TYPEWRITER ",
 //35
 "more than 50",
 //36
 "ENIAC",
 //37
 "Bhuvan",
 //38
 "Commando 2",
 //39
 " Rocky Marciano",
//40
"India",
 //41
 "1956",
 //42
 " 22/11/2013",
 //43
 "The Harlem Globetrotters ",
 //44
 "Chamonix",
 //45
 "23 ",
 //46
 "David Bradley",
 //47
 "Micral N",
 //48
 "Seagate",
 //49
  "Buser",
 //50
 "anakin ",

//51
		"(a) n-1/a (1) a (n)",
 //52
 "Instructions",
 //53
 "Apple 2",
 //54
 "animals movements",
 //55
 "Indonesia",
 //56
 "The Washington Monument",
 //57
 "Isaac Asimov",
 //58
 " Ununseptium (117)",
 //59
 "charon",
 //60
 "Sulphuric Acid",
 //61
 "Galileo ",
 //62
 "The Whitbread round the world",
 //63
 "Willow wood",
 //64
 "Lewis Hamilton ",
 //65
 "1930",
 //66
 "Brian Lara",
 //67
 "Catenaccio",
 //68
 "Edvard Munch",
 //69
 "Mother India",
 //70
 "Bhanu Athaiya",
 //71
 "Raster-scan system",
 //72
 "Audio streaming",
 //73
 "Pointer to node",
 //74
 "Final class",
 //75
 "resume() method",
 //76
 "Jim Shooter",
 //77
 "Byte code",
 //78
 "1981",
 //79
 "125",
 //80
 "switch",
 //81
 "main()",
 //82
 "proprietary",
 //83
 "IP address",
 //84
 "Checksum",
 //85
 "Packet filtering",
 //87
 "Doug Engelbart ",
 //88
 "1979",
 //89
 "Just A Rather Very Intelligent System",
 //90
 "M33",
 //91
 "Antrix ",
 //92
 "29",
 //93
 "New York",
 //94
 "a",
 //95
 "implements",
 //96
 "FlowLayout",
 //97
 "arrOne[0]",
 //98
 "java.lang",
 //99
 "Polymorphism",
 //100
 "FocusListener"

};
	Round1B()
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
		timecounter.setFont(new Font("Courier New",Font.BOLD,20));
		JB2 = new JButton("Next");
		JB3 = new JButton("Exit");
		start=new JButton("Start");
		JTA1 = new JTextArea();
		timecounter.setBounds(45,300,500,400);
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
		
		for(i=0; i<=100; i++)
		{
			rank[i]=i;
		}
			
		Random rm = new Random();
		int temp, ind1, ind2;
		for(i=100; i>50; i--)
		{
			ind1= rm.nextInt(i); 
			temp = rank[ind1];
			rank[ind1] = rank[i];
			rank[i] = temp;
		}	
		
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
			   			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Frenzy1","root","root");
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
					seconds=59;
					minutes=19;
					img.add(JTA1);
					if(TimeLimit >0)new Timer();
					img.add(timecounter);
					JL2.setText(question[rank[quesNo]]);
					
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
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Frenzy1","root","root");
					Statement st = cn.createStatement();
                	String s1="insert into ";
                	s1= s1.concat(name);
                	s1= s1.concat(" values('"+rank[quesNo]+"','"+ansr+"')");
                	st.executeUpdate(s1);
	            	String check1= "select * from ";
	            	check1=check1.concat(name);
	            	check1=check1.concat(" where qno='"+rank[quesNo]+"'");
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
				   		temp=temp.concat(" values('"+rank[quesNo]+"','"+ansr+"')");
	            		st.executeUpdate(temp);
	            		JTA1.setText("");
	            	}

					else
					{
						String updat="update ";
						updat=updat.concat(name);
						updat=updat.concat(" set answer='"+ansr+"'where qno='"+rank[quesNo]+"'");
						st.executeUpdate(updat);
						JTA1.setText("");

					}
					check();
					quesNo++;	
					if (quesNo<total) 
					{	
						JL2.setText(question[rank[quesNo]]);
					
					}

					else
					{
						throw new Exception();
					}

									}
					
	        	catch(SQLException e)
	        	{
					JOptionPane.showMessageDialog(null, e);                    
	        	    
	        	} 
	        	catch (ClassNotFoundException ex) 
	        	{
	        	     Logger.getLogger(Round1B.class.getName()).log(Level.SEVERE, null, ex);
	    		}
	    		catch (Exception e) 
	    		{
	    			JTA1.setVisible(false);
					JL2.setVisible(false);
					JB2.setVisible(false);
					JLabel Exit=new JLabel("Game over please click on EXIT.....");
					timecounter.setVisible(false);	
					Exit.setBounds(45,300,500,400);
					Exit.setFont(new Font("Verdana",Font.BOLD,25));
					Exit.setForeground(Color.white);
					img.add(Exit);
	    		}
			}
		}//next button end

		public void check()
		{
			splitted = Answer[rank[quesNo]].split("\\s+");
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
    	            seconds--;
					if(seconds==0)
					{
						minutes--;
    	                seconds=59;
					}
					if(minutes<0 || seconds==0)
					{
						savedata();
					}
					timecounter.setText("    Time Counter : "+minutes+" minutes " +seconds+" seconds");
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
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Frenzy1","root","root");
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
	        	     Logger.getLogger(Round1B.class.getName()).log(Level.SEVERE, null, ex);
	    		}
	JF1.dispose();
	System.exit(0);
}
	
}
	public static void main(String args[])
	{	
		Round1B F = new Round1B();
	}

}

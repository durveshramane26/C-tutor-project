import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import javax.imageio.ImageIO;
import java.util.TimerTask;
import javax.swing.JScrollPane;

class header extends JPanel implements ActionListener
{
	JButton logo;
	JLabel title;
	
	header()
	{
		super();
		this.setMaximumSize(this.getPreferredSize());
		this.setLayout(new FlowLayout(0));
		this.setBackground(new Color(8388736));
		(this.logo=new JButton(new ImageIcon(new ImageIcon("7.png").getImage().getScaledInstance(100,50,4)))).setBorderPainted(false);
		this.logo.setContentAreaFilled(false);
		this.logo.addActionListener(this);
		(this.title=new JLabel("<html><style>font{color:#FFF8DC;font-size:20px;}</style><font>CONTROL STRUCTURES</font></html>")).setFont(new Font("Dina",3,24));
		this.add(this.logo);				
		this.add(this.title);
	}
	
	@Override
	public void actionPerformed(final ActionEvent actionEvent)
	{
		if(actionEvent.getSource()==this.logo)
		{
			Remove.remove();
			home.jf.add((Component)home.homepage);
			home.jf.revalidate();
                       	home.jf.repaint();
			home.jf.add((Component)home.menu,"West");
			home.jf.remove((Component)home.swap);
			home.jf.revalidate();
			home.jf.repaint();
		}
	}
}


class if_else extends JPanel implements ActionListener
{
	JPanel p;
	Image img;
	JButton prev,demo,next;
	JLabel contents;
	FileReader fr;
	BufferedReader br;
	JScrollPane js;
	JLabel l1,l2,l3,l1_demo,l2_demo,l3_demo,x_demo;
	String z;
	String boolv;
	int x=3;
	JButton b1;
	public static JFrame f;
	Dimension dim1;
	String wstr="",st;

	if_else()throws IOException
	{
		super();
		fr=new FileReader("infotxt/if_else.html");
		this.setLayout(new BorderLayout());
		this.p=new JPanel();
		(this.contents=new JLabel()).setText("");
		this.img=ImageIO.read(new File("ifelse.png"));
		this.prev=new JButton(new ImageIcon(new ImageIcon("prev.png").getImage().getScaledInstance(50,30,4)));
		this.next=new JButton(new ImageIcon(new ImageIcon("next.png").getImage().getScaledInstance(50,30,4)));
		this.demo=new JButton(new ImageIcon(new ImageIcon("demo.png").getImage().getScaledInstance(50,30,4)));
		this.prev.setContentAreaFilled(false);
		this.next.setContentAreaFilled(false);
		this.demo.setContentAreaFilled(false);	
		this.demo.setBorderPainted(false);	
		this.demo.addActionListener(this);
		this.prev.addActionListener(this);
		this.next.addActionListener(this);
		this.p.setBackground(Color.GRAY);
		this.p.add(this.prev);
		this.p.add(this.demo);
		this.p.add(this.next);
		this.add(this.contents,"North");
		this.add(this.p,"South");
		js=new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	}




	public void paintComponent(final Graphics graphics)
	{
		
		
		super.paintComponent(graphics);
		graphics.drawImage(this.img,0,0,this.getWidth(),this.getHeight(),null);
	}




	int validate(String s)
	{
		int i=0,f=0;
		char a[]=s.toCharArray();
		for(i=0;i<a.length;i++)
		{
				if(Character.isLetter(a[i]))
				{
					f=1;
					break;
				}
		}
			if(a.length==0)
				return 0;
			if(f==1)
				return 0;
			else
				return 1;
	}
	






	@Override
	public void actionPerformed(final ActionEvent actionEvent)
	{
		if(actionEvent.getSource()==this.prev)
		{
			Remove.remove();
			home.jf.add((Component)home.homepage);
			home.jf.revalidate();
			home.jf.repaint();
			home.jf.add((Component)home.menu,"West");
			home.jf.remove((Component)home.swap);
			home.jf.revalidate();
			home.jf.repaint();
		}
		else if(actionEvent.getSource() == this.next)
		{
			Remove.remove();
			home.jf.add((Component)home.info2,"Center");
			swapside.swap();
		}
		else if(actionEvent.getSource()==this.demo)
		{
			f=new JFrame("if else Animation");
			l1=new JLabel("<html><h3>Samplecode :</h3><br> #include&lt;stdio.h&gt;<br>void main()<br>{<br>int x=3;</html>");
			l2=new JLabel("<html><br>if(x&lt;5){<br>printf('Hello World');<br>}<br>else{<br>printf('Bye');<br>}</html>");
			l3=new JLabel("<html><br>}</html>");
			
			l2.setText("<html><br>if(x&lt;5){<br><span style='background-color:#FFE4B5;'>printf('Hello World');</span><br>}<br>else{<br>printf('Bye');<br>}</html>");



			l2.setBackground(Color.green);
			l3.setBackground(Color.green);
			
			l1_demo=new JLabel();
			l2_demo=new JLabel();		
			l3_demo=new JLabel();
			x_demo=new JLabel();
			x_demo.setText("<html><h2>X</h2></html>");
			x_demo.setBounds(155,50,40,40);
			
			b1=new JButton("Enter x");
			
			staticframe.createframe(f);
			staticframe.c1.add(l1);
			staticframe.c1.add(b1);
			staticframe.c1.add(l2);
			staticframe.c1.add(l3);
			String s1_demo=Integer.toString(x);
                   	l1_demo.setText("<html><h1>"+s1_demo+"</h1></html>");
			staticframe.d3.add(l1_demo);
			l2_demo.setText("<html><br><h3> 3 &lt;5 ;True</h3></html>");
			staticframe.d1.add(l2_demo);
			l3_demo.setText("<html><br><h3> Hello World</h3></html>");
			staticframe.d2.add(l3_demo);
			staticframe.demo.add(x_demo);
			b1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int f=0,i=0;
					JFrame f1=new JFrame();
					z=(JOptionPane.showInputDialog("Enter x"));
					while(validate(z)==0)
					{
						z=JOptionPane.showInputDialog("Invalid Value!Enter again!");
					}
				l1_demo.setText("<html><h1>"+z+"</h1></html>");
				staticframe.d3.add(l1_demo);
				
				if(Integer.parseInt(z)<5)
					boolv="True";
				else
					boolv="False";
			

				l2_demo.setText("<html><br><h3>"+z+"&lt;5;"+boolv+"</h3></html>");
				staticframe.d1.add(l2_demo);
				if(boolv.equals("True"))
				{
					l3_demo.setText("<html><br><h3> Hello world</h3></html>");
					
					l2.setText("<html><br>if(x&lt;5){<br><span style='background-color:#FFE4B5;'>printf('Hello world');</span><br>}<br>else{<br><span style='background-color:#FFE4B5;'>printf('Bye');</span><br>}</html>");
				
				}
				else
				{
					l3_demo.setText("<html><br><h3> Bye </h3></html>");
					  l2.setText("<html><br>if(x&lt;5){<br>printf('Hello world');<br>}<br>else{<br><span style='background-color:#FFE4B5;'>printf('Bye');</span><br>}</html>");

				}

				
					staticframe.d2.add(l3_demo);
			      }
			});
		}
	}
}






class threaddemo extends Thread
{
		
	String s1_demo;
	public void run()
	{
		try
		{
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		while(true)
		{
			//System.out.println("Hello");
			if(forloop.f.isDisplayable()==false)
				break;
			if(forloop.i==0)
			{
				forloop.l1_demo.setText("<html><h1>"+forloop.i+"</h1></html>");
				forloop.l2_demo[forloop.i].setText("<html><h3>"+forloop.i+" &lt; 4;True</h3></html>");
				staticframe.d1.add(forloop.l2_demo[forloop.i]);
				forloop.l3_demo[forloop.i].setText("<html><h3>Hello World</h3></html>");
				staticframe.d2.add(forloop.l3_demo[forloop.i]);
				//color for
				forloop.l1.setText("<html><h3> Sample Code:</h3> <br>#include&lt;stdio.h&gt;<br>void main()<br>{<br>int x=4;<br>for(<span style='background-color:#FFFF00;'>int i=0;</span>  <span style='background-color:#ADFF2F;'>i&lt;x</span>;i++;)</html>");
				forloop.l2.setText("<html>{<br><span style='background-color:#FFE4B5;'>printf('Hello World');</span><br>}<br>printf('Bye!');<br>}</html>");

				staticframe.c1.add(forloop.l1);
				staticframe.c1.add(forloop.l2);
				forloop.i++;
			}
			if(forloop.f.isDisplayable()==false)
				break;
			try
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			if(forloop.i==1)
			{
				forloop.l1_demo.setText("<html><h1>"+forloop.i+"</h1></html>");
				forloop.l2_demo[forloop.i].setText("<html><h3>"+forloop.i+"&lt; 4;True</h3></html>");
				staticframe.d1.add(forloop.l2_demo[forloop.i]);
				forloop.l3_demo[forloop.i].setText("<html><h3>Hello World</h3></html>");
				staticframe.d2.add(forloop.l3_demo[forloop.i]);
				forloop.i++;
				//color
				//forloop.l1.setText("<html><h3> Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br>"i	
				forloop.l1.setText("<html><h3> Sample Code:</h3> <br>#include&lt;stdio.h&gt;<br>void main()<br>{<br>int x=4;<br>for(int i=0;<span style='background-color:#FFFF00;'>i&lt;x;</span>  <span style='background-color:#ADFF2F;'>i++</span>)</html>");	
				forloop.l2.setText("<html>{<br><span style='background-color:#FFE4B5;'>printf('Hello World');</span><br>}<br>printf('Bye!');<br>}</html>");
			
				staticframe.c1.add(forloop.l1);
				staticframe.c1.add(forloop.l2);
			}
			if(forloop.f.isDisplayable()==false)
				break;
			try
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			if(forloop.i==2)
			{
				
				forloop.l1_demo.setText("<html><h1>"+forloop.i+"</h1></html>");
				forloop.l2_demo[forloop.i].setText("<html><h3>"+forloop.i+"&lt; 4;True</h3></html>");
				staticframe.d1.add(forloop.l2_demo[forloop.i]);
				forloop.l3_demo[forloop.i].setText("<html><h3>Hello World</h3></html>");
				staticframe.d2.add(forloop.l3_demo[forloop.i]);
				forloop.i++;
			}
		        if(forloop.f.isDisplayable()==false)
                                break;
                        try
                        {
                                Thread.sleep(3000);
                        }
                        catch(InterruptedException e)
                        {
                                System.out.println(e);
                        }
			if(forloop.i==3)
			{
				forloop.l1_demo.setText("<html><h1>"+forloop.i+"</h1></html>");
                                forloop.l2_demo[forloop.i].setText("<html><h3>"+forloop.i+"&lt; 4;True</h3></html>");
                                staticframe.d1.add(forloop.l2_demo[forloop.i]);
                                forloop.l3_demo[forloop.i].setText("<html><h3>Hello World</h3></html>");
                                staticframe.d2.add(forloop.l3_demo[forloop.i]);
				forloop.i++;
			}
			try
                        {
                                Thread.sleep(3000);
                        }
                        catch(InterruptedException e)
                        {
                                System.out.println(e);
                        }
			if(forloop.i==4)
			{
				forloop.l1_demo.setText("<html><h1>"+forloop.i+"</h1></html>");
                                forloop.l2_demo[forloop.i].setText("<html><h3>"+forloop.i+"&lt; 4;False</h3></html>");
                                staticframe.d1.add(forloop.l2_demo[forloop.i]);
                                forloop.l3_demo[forloop.i].setText("<html><h3>Bye </h3></html>");
                                staticframe.d2.add(forloop.l3_demo[forloop.i]);
                                forloop.i++;
				//color
				  forloop.l1.setText("<html><h3> Sample Code:</h3> <br>#include&lt;stdio.h&gt;<br>void main()<br>{<br>int x=4;<br>for(int i=0;<span style='background-color:#FFFF00;'>int i&lt;4;</span>  <span style='background-color:#ADFF2F;'>i++</span>)</html>"); 
                                forloop.l2.setText("<html>{<br>printf('Hello World');<br>}<br><span style='background-color:#FFE4B5;'>printf('Bye!');</span><br>}</html>");

                                staticframe.c1.add(forloop.l1);
                                staticframe.c1.add(forloop.l2);
                        }
			if(forloop.f.isDisplayable()==false)
				break;
			try	
			{
				Thread.sleep(3000);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			if(forloop.i==5)
			{
				forloop.i=0;
				for(int J=0;J<5;J++)
				{	
					forloop.l2_demo[J].setText("");
					staticframe.d1.add(forloop.l2_demo[J]);
					forloop.l3_demo[J].setText("");
					staticframe.d2.add(forloop.l3_demo[J]);
				}
			}
			if(forloop.f.isDisplayable()==false)
				break;
		}//while ends
	}//run ends
}//class ends

class forloop extends JPanel implements ActionListener
{
   public static JPanel p;
   public static Image img;
   public static JButton prev;
   public static JButton demo;
   public static JButton next;
   public static JLabel contents,l1,l2,l3,l1_demo,l2_demo[],l3_demo[],x_demo;
   public static JFrame f;
   public static Dimension dim1;
   public static int i;
   forloop()throws IOException
   {
	super();
	this.setLayout(new BorderLayout());
	this.p=new JPanel();
	this.img=ImageIO.read(new File("forloop.png"));
	this.prev=new JButton(new ImageIcon(new ImageIcon("prev.png").getImage().getScaledInstance(50,30,4)));
	this.next=new JButton(new ImageIcon(new ImageIcon("next.png").getImage().getScaledInstance(50,30,4)));
	this.demo=new JButton(new ImageIcon(new ImageIcon("demo.png").getImage().getScaledInstance(50,30,4)));
	this.prev.setContentAreaFilled(false);
	this.next.setContentAreaFilled(false);
	this.demo.setContentAreaFilled(false);
	this.demo.setBorderPainted(false);
	this.demo.addActionListener(this);	
	this.prev.addActionListener(this);	
	this.next.addActionListener(this);	
	this.p.setBackground(Color.GRAY);
	this.p.add(this.prev);
	this.p.add(this.demo);
	this.p.add(this.next);
	this.add(this.p,"South");
    }
	public void paintComponent(final Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(this.img,0,0,this.getWidth(),this.getHeight(),null);
	}
	@Override
	public void actionPerformed(final ActionEvent actionEvent)
	{
		if(actionEvent.getSource()==this.prev)
		{
			Remove.remove();
			home.jf.add((Component)home.info4,"Center");
			swapside.swap();
		}
		else if(actionEvent.getSource()==this.next)
		{
			 Remove.remove();
                        home.jf.add((Component)home.info6,"Center");
                        swapside.swap();
		}
		else if(actionEvent.getSource()==this.demo)
		{
			f=new JFrame();
			l1_demo=new JLabel();
			l2_demo=new JLabel[5];
			l3_demo=new JLabel[5];
			for(int i=0;i<5;i++)	
			{
				l2_demo[i]=new JLabel();
				l3_demo[i]=new JLabel();
			}
			l1=new JLabel("<html><h3>Sample code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br>int x=4;<br>for(int i=0;i&lt;x;i++)</html>");
			l2=new JLabel("<html>{<br>printf('Hello World!');<br>}printf('Bye!');<br>}</html>");
			l3=new JLabel();
		
			staticframe.createframe(f);	
			staticframe.c1.add(l1);
			staticframe.c1.add(l2);
			x_demo=new JLabel();
			x_demo.setText("<html><h2>i</h2></html>");
			x_demo.setBounds(155,50,40,40);
			staticframe.demo.add(x_demo);
			l1_demo.setText("");
			staticframe.d3.add(l1_demo);
			for(int i=0;i<5;i++)
			{
				l2_demo[i].setText("");
				staticframe.d1.add(l2_demo[i]);
				l3_demo[i].setText("");
				staticframe.d2.add(l3_demo[i]);
			}
			threaddemo d1=new threaddemo();
			i=0;
			d1.start();
		}
		
	}
}

class footer extends JPanel
{
  JLabel l2;
	footer()
	{
		super();
		this.setBackground(Color.BLACK);
		(this.l2=new JLabel()).setForeground(Color.WHITE);
		this.l2.setText("Copyright-*All rights reserved");
		this.l2.setFont(new Font("Serif",1,12));
		this.add(this.l2);
	}
}

class dowhiledemo extends Thread
{
  String s1_demo;
	public void run()
	{
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		while(true)
		{
			if(dowhile_loop.i==0)
			{
				dowhile_loop.l1_demo.setText("<html><h1>"+dowhile_loop.i+"</h1></html>");
/**/				dowhile_loop.l2_demo[dowhile_loop.i].setText("<html><br><span style='background-color:#FFFFE0';></span></html>");
                                dowhile_loop.l2_demo[dowhile_loop.i].setText("<html><br><h3>"+dowhile_loop.i+"&gt;1 ;True</h3></html>");
				staticframe.d1.add(dowhile_loop.l2_demo[dowhile_loop.i]);
				dowhile_loop.l3_demo[dowhile_loop.i].setText("<html><h3>Hello World!</h3></html>");
				staticframe.d2.add(dowhile_loop.l3_demo[dowhile_loop.i]);
				//color for
				dowhile_loop.l1.setText("<html><h3>Sample code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br>do</html>");									
				dowhile_loop.l2.setText("<html>{<br>printf('Hello World!');<br><span style='background-color:#FFFFE0;'>i++;</span><br>}while(i&gt;1);<br>printf('Bye!');<br>}</html>");
				staticframe.c1.add(dowhile_loop.l1);
				staticframe.c1.add(dowhile_loop.l2);
				dowhile_loop.i++;
			}
			if(dowhile_loop.f.isDisplayable() == false)
					break;
			try
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			if(dowhile_loop.i == 1)
			{
				dowhile_loop.l1_demo.setText("<html><h1>"+dowhile_loop.i+"</h1></html>");
				dowhile_loop.l2_demo[dowhile_loop.i].setText("<html><br><h3>"+dowhile_loop.i+"&gt;1 ;False</h3></html>");
				staticframe.d1.add(dowhile_loop.l2_demo[dowhile_loop.i]);

				dowhile_loop.l3_demo[dowhile_loop.i].setText("<html><h3>Bye!</h3></html>");

				staticframe.d2.add(dowhile_loop.l3_demo[dowhile_loop.i]);

				//color for
				dowhile_loop.l1.setText("<html><h3>Sample code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br>int i=0;<br>do</html>");
                                dowhile_loop.l2.setText("<html>{<br>printf('Hello World!');<br>i++;<br>}<span style=background-color:'#FFFFE0;'>while(i&gt;1);</span><br><span style='background-color:#FFE4B5;'>printf('Bye!');</span><br>}</html>");
                                staticframe.c1.add(dowhile_loop.l1);
                                staticframe.c1.add(dowhile_loop.l2);
                                dowhile_loop.i++;
			}
			if(dowhile_loop.f.isDisplayable()==false)
			{
				break;
			}
			try
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			if(dowhile_loop.i == 2)
			{
				dowhile_loop.i=0;
				for(int J=0;J<5;J++)
				{	
					dowhile_loop.l2_demo[J].setText("");
					staticframe.d1.add(dowhile_loop.l2_demo[J]);
					dowhile_loop.l3_demo[J].setText("");
					staticframe.d2.add(dowhile_loop.l3_demo[J]);
				}
			}
			if(dowhile_loop.f.isDisplayable() == false)
				break;
		}
	}
}

class dowhile_loop extends JPanel implements ActionListener
{
  public static JPanel p;
  public static Image img;
  public static JButton prev;
  public static JButton demo;
  public static JButton next;
  public static JLabel contents,l1,l2,l3,l1_demo,l2_demo[],l3_demo[],x_demo;
  public static JFrame f;
  public static Dimension dim1;
  public static int i;
  dowhile_loop()throws IOException
  {
	super();
	this.setLayout(new BorderLayout());
	this.p=new JPanel();
	this.img=ImageIO.read(new File("dowhile.png"));
	this.prev=new JButton(new ImageIcon(new ImageIcon("prev.png").getImage().getScaledInstance(50,30,4)));
	this.next=new JButton(new ImageIcon(new ImageIcon("next.png").getImage().getScaledInstance(50,30,4)));
	this.demo=new JButton(new ImageIcon(new ImageIcon("demo.png").getImage().getScaledInstance(50,30,4)));
	this.prev.setContentAreaFilled(false);
        this.next.setContentAreaFilled(false);
        this.demo.setContentAreaFilled(false);
        this.demo.setBorderPainted(false);
        this.demo.addActionListener(this);
        this.prev.addActionListener(this);
        this.next.addActionListener(this);
        this.p.setBackground(Color.GRAY);
        this.p.add(this.prev);
        this.p.add(this.demo);
        this.p.add(this.next);
        this.add(this.p,"South");
  }
  public void paintComponent(final Graphics graphics)
  {
	super.paintComponent(graphics);
	graphics.drawImage(this.img,0,0,this.getWidth(),this.getHeight(),null);
  }
  @Override
  public void actionPerformed(final ActionEvent actionEvent)
  {
	if(actionEvent.getSource() == this.prev)
	{
		Remove.remove();
		home.jf.add((Component)home.info2,"Center");
		swapside.swap();
	}
	else if(actionEvent.getSource() == this.next)
	{
		Remove.remove();
		home.jf.add((Component)home.info4,"Center");
		swapside.swap();
	}
	else if(actionEvent.getSource() == this.demo)
	{
		f=new JFrame("do-while animation");
		l1=new JLabel("<html><h3>Sample code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br>int i=0;<br>do</html>");
		l2=new JLabel("<html>{printf('Hello World!');<br>i++;<br>}while(i&gt;1);<br>}</html>");
		l3=new JLabel();
		l1_demo=new JLabel();
		l2_demo=new JLabel[5];
		l3_demo=new JLabel[5];
		
		for(int i=0;i<5;i++)
		{
			l2_demo[i]=new JLabel();
			l3_demo[i]=new JLabel();
		}

	staticframe.createframe(f);
	staticframe.c1.add(l1);
	staticframe.c1.add(l2);
	
	x_demo=new JLabel();
	x_demo.setText("<html><h2>i</h2></html>");
	x_demo.setBounds(155,50,40,40);
	staticframe.demo.add(x_demo);
	l1_demo.setText("");
	staticframe.d3.add(l1_demo);
	
	for(int i=0;i<5;i++)
	{
		l2_demo[i].setText("");
		staticframe.d1.add(l2_demo[i]);
		l3_demo[i].setText("");
		staticframe.d2.add(l3_demo[i]);
	}
	i=0;
	dowhiledemo d1=new dowhiledemo();
	d1.start();
  	}
   }
}

class switch_case extends JPanel implements ActionListener
{
	JPanel p,p1;
	Image img;
 	JButton prev;
	JButton demo;
	JButton next,b1;
	JLabel l1,l2,l3,l1_demo,l2_demo,l3_demo,x_demo,contents;
	
	JFrame f;
	JScrollPane jsp;
	BufferedReader br;
	StringBuffer sb;
	String line=null;
	Dimension dim1;
	String z;
	switch_case()throws IOException
	{
		super();
		this.setLayout(new BorderLayout());
		this.p=new JPanel();
		this.p1=new JPanel();
		contents=new JLabel();
		this.img=ImageIO.read(new File("f.jpg"));
		this.prev=new JButton(new ImageIcon(new ImageIcon("prev.png").getImage().getScaledInstance(50,30,4)));
		this.next=new JButton(new ImageIcon(new ImageIcon("next.png").getImage().getScaledInstance(50,30,4)));
		this.demo=new JButton(new ImageIcon(new ImageIcon("demo.png").getImage().getScaledInstance(50,30,4)));
		this.prev.setContentAreaFilled(false);
		this.next.setContentAreaFilled(false);
		this.demo.setContentAreaFilled(false);
		this.prev.addActionListener(this);
		this.next.addActionListener(this);
		this.demo.addActionListener(this);
		this.p.setBackground(Color.GRAY);
		this.p.add(this.prev);
		this.p.add(this.demo);
		this.p.add(this.next);
		br=new BufferedReader(new FileReader("switch.html"));
		sb=new StringBuffer();
		line=null;
		while((line=br.readLine())!=null)
		{
			sb.append(line+ "<br>");
		}
		line=sb.toString();
		contents.setText("<html><body background='file:f.jpg'><font color='black'>"+line+"</font></body></html>");//<font color='#ffdf00'>
		jsp=new JScrollPane(p1);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setPreferredSize(new Dimension(500,550));
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		//this.p.add(this.prev);
		//this.p.add(this.next);
		p1.add(contents);
		this.add(this.jsp,"North");
		this.add(this.p,"South");
	}
	
  	public void paintComponent(final Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(this.img,0,0,this.getWidth(),this.getHeight(),null);
	}
	int validate(String s)
	{
		int i=0,f=0;
		char a[]=s.toCharArray();
		for(i=0;i<a.length;i++)
		{
			if(Character.isLetter(a[i]))
			{
				f=1;
				break;
			}
		}
		if(a.length==0)
			return 0;
		if(f==1)
			return 0;
		else
			return 1;
	}
	@Override
	public void actionPerformed(final ActionEvent actionEvent)
	{
		if(actionEvent.getSource() == this.prev)
		{
			Remove.remove();
			home.jf.add((Component)home.info3,"Center");
			swapside.swap();
		}
		else if(actionEvent.getSource() == this.next)
		{
			Remove.remove();
			home.jf.add((Component)home.info5,"Center");
			swapside.swap();
		}
		else if(actionEvent.getSource() == this.demo)
		{
			f=new JFrame("Switch Animation");
			b1=new JButton("Enter i");
			l1=new JLabel("<html><h3>Sample Code:</h3>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=2;</span></html>");
			l3=new JLabel("<html><br>switch(i)</html>");
			l2=new JLabel("<html>{<br>case 1:printf('In case 1');<br>break;<br><br><span style='background-color:#FFFFE0;'>case 2:</span><span style='background-color:#FFE4B5';>printf('In case 2');</span><br>break;<br>case 3:printf('In case 3');<br>break;<br><br>default:printf('In default');<br>}}</html>");
			
			staticframe.createframe(f);
			
			staticframe.c1.add(l1);
			staticframe.c1.add(b1);
			staticframe.c1.add(l3);
			staticframe.c1.add(l2);
		
			l1_demo=new JLabel();
			l2_demo=new JLabel();
			l3_demo=new JLabel();
			
			x_demo=new JLabel();
			x_demo.setText("<html><h2>i</h2></html>");
			x_demo.setBounds(155,50,40,40);
			
			l1_demo.setText("<html><h1>"+ 2 +"</h1></html>");
			staticframe.d3.add(l3_demo);
			staticframe.demo.add(x_demo);
			
			b1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int f=0,i=0;
					z=(JOptionPane.showInputDialog("Enter i"));
					while(validate(z)==0)
					{
						z=JOptionPane.showInputDialog("Value invalid!!Enter again!");
					}
					l1_demo.setText("<html><h1>"+z+"</h1></html>");
					staticframe.d3.add(l1_demo);
					if(Integer.parseInt(z)==1)
					{
						l2_demo.setText("<html><br><h3>case 1:True</h3></html>");
						staticframe.d1.add(l2_demo);
						l3_demo.setText("<html><br><h3>In case 1</h3></html>");
						staticframe.d2.add(l3_demo);/**/
						l2.setText("<html>{<br><span style='background-color:#FFFFE0;'>case 1:</span><span style='background-color:#FFE4B5;'>printf('In case 1');</span><br>break;<br><br>case 2:printf('In case 2');<br>break;<br><br>case 3:printf('In case 3');<br>break;<br><br>default:printf('In default');<br>}</html>");
					}
					else if(Integer.parseInt(z)==2)
					{
						l2_demo.setText("<html><br><h3>case 2;True</h3></html>");
						staticframe.d1.add(l2_demo);
						l3_demo.setText("<html><br><h3>In case 2</h3></html>");
						staticframe.d2.add(l3_demo);
						l2.setText("<html>{<br>case 1:printf('In case 1');<br>break;<br><br><span style='background-color:#FFFFE0;'>case 2:</span><span style='background-color:#FFE4B5';>printf('In case 2');</span><br>break;<br>case 3:printf('In case 3');<br>break;<br><br>default:printf('In default');<br>}}</html>");
					}
					else if(Integer.parseInt(z)==3)
					{
						 l2_demo.setText("<html><br><h3>case 3;True</h3></html>");
                               		         staticframe.d1.add(l3_demo);
                                       	         l3_demo.setText("<html><br><h3>In case 2</h3></html>");
                                       	         staticframe.d2.add(l3_demo);
						l2.setText("<html>{<br>case 1:printf('In case 1');<br>break;<br><br>case 2:printf('In case 2');<br>break;<br><br><span style='background-color:#FFFFE0;'>case 3:</span><span style='background-color:#FFE4B5;'>printf('In case 3');</span><br>break;<br><br>default:printf('In default case');<br>}</html>");
					}
					else
					{
						l2_demo.setText("<html><br><h3>default;True</h3></html>");
						staticframe.d1.add(l2_demo);
						l3_demo.setText("<html><br><h3>In default case</h3></html>");
						staticframe.d2.add(l3_demo);
						l2.setText("<html>{<br>case 1:printf('In case 1');<br>break;<br><br>case 2:printf('in cae 2');<br>break;<br><br>case 3:printf('In case 3');<br>break;<br><br><span style='background-color:#FFFFE0;'>default:</span><span style='background-color:#FFE4B5;'>printf('In default case');</span><br>}</html>");
					}
				}	
		});
		}
		
	}
<}

class whiledemo extends Thread
{
  String s1_demo;
  public void run()
  {
	try
	{
		Thread.sleep(3000);	
	}
	catch(InterruptedException e)
	{
		System.out.println(e);
	}
	while(true)
	{
		if(while_loop.f.isDisplayable() == false)
		{
			break;
		}
		if(while_loop.i == 0)
		{
			while_loop.l1_demo.setText("<html><h1>"+while_loop.i+"</h1></html>");
			while_loop.l2_demo[while_loop.i].setText("<html><h3>"+while_loop.i+ "&lt;4;True</h3></html>");
			staticframe.d1.add(while_loop.l2_demo[while_loop.i]);
			while_loop.l3_demo[while_loop.i].setText("<html><h3>Hello World!</h3></html>");
			staticframe.d2.add(while_loop.l3_demo[while_loop.i]);
			//color for
			while_loop.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
			while_loop.l2.setText("<html>{<br><span style='background-color:#FFE4B5;'>printf('Hello World!');</span><br><span style=background-color:#ADFF2F;>i++;</span><br><br>printf('Bye!');<br>}</html>");
			staticframe.c1.add(while_loop.l1);
			staticframe.c1.add(while_loop.l2);
			while_loop.i++;
		}
		if(while_loop.f.isDisplayable()== false)
			break;
		try
		{
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		if(while_loop.i ==1)
		{
			 while_loop.l1_demo.setText("<html><h1>"+while_loop.i+"</h1></html>");
                        while_loop.l2_demo[while_loop.i].setText("<html><h3>"+while_loop.i+ "&lt;4;True</h3></html>");
                        staticframe.d1.add(while_loop.l2_demo[while_loop.i]);
                        while_loop.l3_demo[while_loop.i].setText("<html><h3>Hello World!</h3></html>");
                        staticframe.d2.add(while_loop.l3_demo[while_loop.i]);
                        while_loop.i++;
                        while_loop.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
                        while_loop.l2.setText("<html>{<br><span style='background-color:#FFE4B5;'>printf('Hello World!');</span><br><span style=background-color:#ADFF2F;>i++;</span><br><br>printf('Bye!');<br>}</html>");
                        staticframe.c1.add(while_loop.l1);
                        staticframe.c1.add(while_loop.l2);
                 }
		 if(while_loop.f.isDisplayable()== false)
                        break;
                try
                {
                        Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                        System.out.println(e);
                }
		 if(while_loop.i ==2)
                {
                         while_loop.l1_demo.setText("<html><h1>"+while_loop.i+"</h1></html>");
                        while_loop.l2_demo[while_loop.i].setText("<html><h3>"+while_loop.i+ "&lt;4;True</h3></html>");
                        staticframe.d1.add(while_loop.l2_demo[while_loop.i]);
                        while_loop.l3_demo[while_loop.i].setText("<html><h3>Hello World!</h3></html>");
                        staticframe.d2.add(while_loop.l3_demo[while_loop.i]);
                        while_loop.i++;
                        while_loop.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
                        while_loop.l2.setText("<html>{<br><span style='background-color:#FFE4B5;'>printf('Hello World!');</span><br><span style=background-color:#ADFF2F;>i++;</span><br><br>printf('Bye!');<br>}</html>");
                        staticframe.c1.add(while_loop.l1);
                        staticframe.c1.add(while_loop.l2);
                 }
                 if(while_loop.f.isDisplayable()== false)
                        break;
                try
                {
                        Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                        System.out.println(e);
                }
		 if(while_loop.i ==3)
                {
                         while_loop.l1_demo.setText("<html><h1>"+while_loop.i+"</h1></html>");
                        while_loop.l2_demo[while_loop.i].setText("<html><h3>"+while_loop.i+ "&lt;4;True</h3></html>");
                        staticframe.d1.add(while_loop.l2_demo[while_loop.i]);
                        while_loop.l3_demo[while_loop.i].setText("<html><h3>Hello World!</h3></html>");
                        staticframe.d2.add(while_loop.l3_demo[while_loop.i]);
                        while_loop.i++;
                        while_loop.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
                        while_loop.l2.setText("<html>{<br><span style='background-color:#FFE4B5;'>printf('Hello World!');</span><br><span style=background-color:#ADFF2F;>i++;</span><br><br>printf('Bye!');<br>}</html>");
                        staticframe.c1.add(while_loop.l1);
                        staticframe.c1.add(while_loop.l2);
                 }
                 if(while_loop.f.isDisplayable()== false)
                        break;
                try
                {
                        Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                        System.out.println(e);
                }
		 if(while_loop.i ==4)
                {
                         while_loop.l1_demo.setText("<html><h1>"+while_loop.i+"</h1></html>");
                        while_loop.l2_demo[while_loop.i].setText("<html><h3>"+while_loop.i+ "&lt;4;False</h3></html>");
                        staticframe.d1.add(while_loop.l2_demo[while_loop.i]);
                        while_loop.l3_demo[while_loop.i].setText("<html><h3>Bye!</h3></html>");
                        staticframe.d2.add(while_loop.l3_demo[while_loop.i]);
                        while_loop.i++;
                        while_loop.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
                        while_loop.l2.setText("<html>{<br><span style='background-color:#FFE4B5;'>printf('Hello World!');</span><br><span style=background-color:#ADFF2F;>i++;</span><br><br>printf('Bye!');<br>}</html>");
                        staticframe.c1.add(while_loop.l1);
                        staticframe.c1.add(while_loop.l2);
                 }
                 if(while_loop.f.isDisplayable()== false)
                        break;
                try
                {
                        Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                        System.out.println(e);
                }
	}
   }
}

class while_loop extends JPanel implements ActionListener
{
  public static JPanel p;
  public static Image img;
  public static JButton prev;
  public static JButton next;
  public static JButton demo;
  public static JLabel contents,l1,l2,l3,l1_demo,l2_demo[],l3_demo[],x_demo;
  public static JFrame f;
  public static Dimension dim1;
  public static int i;
  while_loop()throws IOException
  {
	super();
	this.setLayout(new BorderLayout());
	this.p=new JPanel();
	this.img=ImageIO.read(new File("while.png"));
	this.prev=new JButton(new ImageIcon(new ImageIcon("prev.png").getImage().getScaledInstance(50,30,4)));
	this.next=new JButton(new ImageIcon(new ImageIcon("next.png").getImage().getScaledInstance(50,30,4)));	
	this.demo=new JButton(new ImageIcon(new ImageIcon("demo.png").getImage().getScaledInstance(50,30,4)));
  	this.prev.setContentAreaFilled(false);
	this.next.setContentAreaFilled(false);
	this.demo.setContentAreaFilled(false);
 	this.demo.setBorderPainted(false);
	this.demo.addActionListener(this);
	this.prev.addActionListener(this);
	this.next.addActionListener(this);
	this.p.setBackground(Color.GRAY);
	this.p.add(this.prev);
	this.p.add(this.demo);
	this.p.add(this.next);
	this.add(this.p,"South");
  }
  public void paintComponent(final Graphics graphics)
  {
	super.paintComponent(graphics);
	graphics.drawImage(this.img,0,0,this.getWidth(),this.getHeight(),null);
  }
  @Override
  	 public void actionPerformed(final ActionEvent actionEvent)
  	{
		if(actionEvent.getSource()==this.prev)
		{
			Remove.remove();
			home.jf.add((Component)home.info1, "Center");
			swapside.swap();
		}
		else if(actionEvent.getSource()==this.next)
		{
			Remove.remove();
			home.jf.add((Component)home.info3,"Center");
			swapside.swap();
		}
		else if(actionEvent.getSource()==this.demo)
		{
			f=new JFrame("While loop");
			l1=new JLabel("<html><h3>Sample code:</h3><br>#include<&lt;stdio.h&gt;<br>void main()<br>{<br>int i=0;<br>while(i&lt;4)</html>");
			l2=new JLabel("<html>{<br>printf('Hello world');<br>i++;<br>}<br>}printf('Bye');<br>}</html>");
			l3=new JLabel();
			
			l1_demo=new JLabel();
			l2_demo=new JLabel[5];
			l3_demo=new JLabel[5];
			for(int i=0;i<5;i++)
			{
				l2_demo[i]=new JLabel();
				l3_demo[i]=new JLabel();
			}
			staticframe.createframe(f);
			staticframe.c1.add(l1);
			staticframe. c1.add(l2);
			x_demo=new JLabel();
			
			x_demo.setText("<html><h2>i</h2></html>");
			x_demo.setBounds(155,50,40,40);
			staticframe.demo.add(x_demo);
			
			l1_demo.setText("");
			staticframe.d3.add(l1_demo);
			for(int i=0;i<5;i++)
			{	
				l2_demo[i].setText("");
				staticframe.d1.add(l2_demo[i]);
				l3_demo[i].setText("");
				staticframe.d2.add(l3_demo[i]);
			}
			i=0;
			whiledemo d1=new whiledemo();
			d1.start();
		}
	}
}

class breakdemo extends Thread
{
	String s1_demo;
	public void run()
	{
		try
		{
			Thread.sleep(3000);
		}
		catch(InterruptedException e){System.out.println(e);}
		
		while(true)
		{
			if(breaks.f.isDisplayable()==false)
				break;
			if(breaks.i==0)
			{
				breaks.l1_demo.setText("<html><h1>"+breaks.i+"</h1></html>");
				breaks.l2_demo[breaks.i].setText("<html><h3>"+breaks.i+"&lt; 4 ;True</h3></html>");
				staticframe.d1.add(breaks.l2_demo[breaks.i]);
				breaks.l3_demo[breaks.i].setText("<html><h3>Helo World</h3></html>");
				staticframe.d2.add(breaks.l3_demo[breaks.i]);
				


				breaks.l1.setText("<html><h3>Sample Code:</h3><br>#include<&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;4)</span></html>");
				breaks.l2.setText("<html>{<br><span style='background-color:#FFE4B5;'>printf('Hello World');</span><br><span style='background-color:red;'>if(i==1)</span><br>break;<br><span style='background-color:#ADFF2F;'>i++;</span><br>}<br>printf('bye');<br>}</html>");
			
				staticframe.c1.add(breaks.l1);
				staticframe.c1.add(breaks.l2);
				breaks.i++;
			}
			if(breaks.f.isDisplayable()==false)
				break;
			try
			{
				Thread.sleep(3000);
			}catch(InterruptedException e){System.out.println(e);}
			
			if(breaks.i==1)
			{
				breaks.l1_demo.setText("<html><h1>"+breaks.i+"</h1></html>");
				breaks.l2_demo[breaks.i].setText("<html><h3>"+breaks.i+"&lt; 4 ; False</h3></html>");
				staticframe.d1.add(breaks.l2_demo[breaks.i]);
				breaks.l3_demo[breaks.i].setText("<html><h3>Bye</h3></html>");
				
				staticframe.d2.add(breaks.l3_demo[breaks.i]);
				breaks.i++;
				//color
				breaks.l1.setText("<html><h3>Sample Code:</h3><br> #include&lt;stdio.h&gt;<br>void main()<br>{<br>int i=0;<br><span style='background-color:#FFFFE0;'>while(i&lt;4)</span></html>");
			
				breaks.l2.setText("<html>{<br>printf('Hello World');<br><span style='background-color:green;'>if(i==1)</span><br>break;<br>i++;<br>}<br><span style='background-color:#FFE4B5;'>printf('Bye');</span><br>}</html>");
		
				staticframe.c1.add(breaks.l1);
				staticframe.c1.add(breaks.l2);
			}
			if(breaks.f.isDisplayable()==false)
				break;
			try
			{
				Thread.sleep(3000);
			}catch(InterruptedException e){System.out.println(e);}
			
			if(breaks.i==2)
			{
				breaks.i=0;
				for(int J=0;J<5;J++)
				{
					breaks.l2_demo[J].setText("");
					staticframe.d1.add(breaks.l2_demo[J]);
					breaks.l3_demo[J].setText("");
					staticframe.d2.add(breaks.l3_demo[J]);
				}
			}
			if(breaks.f.isDisplayable()==false)
				break;
		}
	}
}



class breaks extends JPanel implements ActionListener
{
	public static JPanel p,p1;
	public static Image img;
	public static JButton prev;
	public static JButton demo;
	public static JButton next;
	public static JLabel contents,l1,l2,l3,l1_demo,l2_demo[],l3_demo[],x_demo;
	
	public static JFrame f;
	public static Dimension dim1;
	public static int i;
	
	BufferedReader br;
	JScrollPane jsp;
	StringBuffer sb;
	String line;
	breaks() throws IOException{
	 	super();
		this.setLayout(new BorderLayout());
		this.p=new JPanel();
		this.p1=new JPanel();
		contents=new JLabel();
		
		this.img=ImageIO.read(new File("f.jpg"));
		(this.prev=new JButton(new ImageIcon(new ImageIcon("prev.png").getImage().getScaledInstance(50,30,4)))).setContentAreaFilled(false);
		this.demo=new JButton(new  ImageIcon(new ImageIcon("demo.png").getImage().getScaledInstance(50,30,4)));
		(this.next=new JButton(new ImageIcon(new ImageIcon("next.png").getImage().getScaledInstance(50,30,4)))).setContentAreaFilled(false);
		this.prev.setContentAreaFilled(false);
		this.demo.setContentAreaFilled(false);
		this.demo.setBorderPainted(false);
		this.demo.addActionListener(this);
		this.prev.addActionListener(this);
		this.next.addActionListener(this);
		this.p.setBackground(Color.GRAY);
		this.p.add(this.prev);
		this.p.add(this.demo);
		this.p.add(this.next);
		br= new BufferedReader(new FileReader("break1.html"));
		sb=new StringBuffer();
		line=null;
		while((line=br.readLine())!=null)
		{
			sb.append(line+"<br>");
		}
		line=sb.toString();
		contents.setText("<html><body background='file:f.jpg'>"+line+"</body></html>");
		jsp=new JScrollPane(p1);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setPreferredSize(new Dimension(500,550));
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		p1.add(contents);
		p1.setVisible(true);
		this.add(this.jsp,"North");
		this.add(this.p,"South");
	}
	public void paintComponent(final Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(this.img,0,0,this.getWidth(),this.getHeight(),null);
	}

	@Override
	public void actionPerformed(final ActionEvent actionEvent)
	{
		if(actionEvent.getSource()==this.prev)
		{
			Remove.remove();
			home.jf.add((Component)home.info5,"Center");
			swapside.swap();
		}
		else if(actionEvent.getSource()==this.demo)
		{
			f=new JFrame();
		
			l1=new JLabel("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br>int i=0;<br>while(i&lt;4(</html>");
			l2=new JLabel("<html>{<br>printf('Hello World');<br>if(i==1)<br>break;<br>i++;<br>}<br>printf('Bye');<br>}</html>");
			
			l3=new JLabel();
			l1_demo=new JLabel();
			l2_demo=new JLabel[5];
			l3_demo=new JLabel[5];
			for(int i=0;i<5;i++)
			{
				l2_demo[i]=new JLabel();
				l3_demo[i]=new JLabel();
			}
			
			staticframe.createframe(f);
			staticframe.c1.add(l1);
			staticframe.c1.add(l2);
			
			x_demo=new JLabel();
			x_demo.setText("<html><h2>i</h2></html>");
			x_demo.setBounds(155,50,40,40);
			staticframe.demo.add(x_demo);
			l1_demo.setText("");
			staticframe.d3.add(l1_demo);
			for(int i=0;i<5;i++)
			{
				l2_demo[i].setText("");
				staticframe.d1.add(l2_demo[i]);
				l3_demo[i].setText("");
				staticframe.d2.add(l3_demo[i]);
			}
			i=0;
			breakdemo d1=new breakdemo();
			d1.start();
		}
		else if(actionEvent.getSource()==this.next)
		{
			Remove.remove();
			home.jf.add((Component)home.info7,"Center");
			swapside.swap();
		}
	}
}
	
class info extends JPanel
{
	JPanel p;
	Image img;
	JButton left;
	JButton right;
	JLabel contents;
	static JLabel l1,l2;
	info(final String s)
	{
		super();
		l1=new JLabel("<html><h2><font style='color:orange;font-size:15px;'><u>CONTROL STRUCTURES TUTORIALS </u></font></h2></html>");
		l2=new JLabel("<html><font style='font-family:sans-serif;font-size:13px;'><font color='white'><i> A Control Structure is a block of programming that analyzes variables and chooses a direction in which to go based on given paramters. The term flow control details the direction the program takes.Hence it is the basic decision making process in computing;flowcontrol determines how a computer will respond when given certain conditions ans parameters.<br>There are three types of control structures. namely,<br><ul><li>Conditional Statements.(if-else,switch)<li> Unconditional Statements.(break,goto,continue)</li><li>Looping statements.(forloop,while,do-while)</li></ul></i></font></font></html>");
		
		this.setLayout(null);
		l1.setBounds(300,5,350,200);
		l2.setBounds(290,-50,450,700);
		add(l1);
		add(l2);
		this.p=new JPanel();
		this.img=new ImageIcon(s).getImage();
		
	}
	
		
	public void paintComponent(final Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(this.img,0,0,this.getWidth(),this.getHeight(),null);
	}
}


class Remove
{
	Remove()
	{
		super();
	}
		
	public static void remove()
	{
		home.jf.remove((Component)home.homepage);
		home.jf.remove((Component)home.info1);
		home.jf.remove((Component)home.info2);
		  home.jf.remove((Component)home.info3);
		  home.jf.remove((Component)home.info4);
		  home.jf.remove((Component)home.info5);
		  home.jf.remove((Component)home.info6);
		  home.jf.remove((Component)home.info7);
		  home.jf.remove((Component)home.info8);
		  //home.jf.remove((Component)home.info2);
	}
}

class sidemenu extends JPanel implements ActionListener
{
	JButton[] b;
	Image img;
	JLabel cs;
	
	sidemenu(final String s)throws IOException
	{
		super();
		this.b=new JButton[10];
		/**/this.add(this.cs=new JLabel("<html><style>font{color:#FFFFE0;font-size:10px;}</style><font{color:#FFFE0;font-size:10px;}</style><font color='#ef820d'>&nbsp;&nbsp;&nbsp;<u>STATEMENTS</u></font></html>"));
		final String[] array={ "IF-ELSE","WHILE","DO-WHILE","SWITCH","FOR LOOP","BREAK","GOTO","CONTINUE"};

		this.img=ImageIO.read(new File(s));
		this.setLayout(new GridLayout(0,1));
		this.setPreferredSize(new Dimension(150,60));
		this.setMaximumSize(this.getPreferredSize());
		for(int i=0;i<8;++i)
		{
			(this.b[i]=new JButton()).setForeground(Color.BLACK);
			this.b[i].setText(array[i]);
			this.b[i].setContentAreaFilled(false);
			this.b[i].addActionListener(this);
			this.add(this.b[i]);
		}
	}

	public void paintComponent(final Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(this.img,0,0,this.getWidth(),this.getHeight(),null);
	}
		@Override 
		public void actionPerformed(final ActionEvent actionEvent)
		{
			if(actionEvent.getSource()==this.b[0])
			{
				Remove.remove();
				home.jf.add((Component)home.info1,"Center");
				swapside.swap();
			}
			else if(actionEvent.getSource()==this.b[1])
                        {
                                Remove.remove();
                                home.jf.add((Component)home.info2,"Center");
                                swapside.swap();
                        }
			else if(actionEvent.getSource()==this.b[2])
                        {
                                Remove.remove();
                                home.jf.add((Component)home.info3,"Center");
                                swapside.swap();
                        }
			else if(actionEvent.getSource()==this.b[3])
                        {
                                Remove.remove();
                                home.jf.add((Component)home.info4,"Center");
                                swapside.swap();
                        }
			else if(actionEvent.getSource()==this.b[4])
                        {
                                Remove.remove();
                                home.jf.add((Component)home.info5,"Center");
                                swapside.swap();
                        }
			else if(actionEvent.getSource()==this.b[5])
                        {
                                Remove.remove();
                                home.jf.add((Component)home.info6,"Center");
                                swapside.swap();
                        }
			else if(actionEvent.getSource()==this.b[6])
                        {
                                Remove.remove();
                                home.jf.add((Component)home.info7,"Center");
                                swapside.swap();
                        }else if(actionEvent.getSource()==this.b[7])
                        {
                                Remove.remove();
                                home.jf.add((Component)home.info8,"Center");
                                swapside.swap();
                        }
			
		
	}
}


class swapside
{
	swapside()
	{
		super();
	}
	public static void swap()
	{
		home.jf.revalidate();
		home.jf.repaint();
		home.jf.add((Component)home.swap,"West");
		home.jf.remove((Component)home.menu);
		home.jf.revalidate();
		home.jf.repaint();
	}
	
}


class home implements ActionListener
{
	public static JFrame jf;
	public static JFrame start_up;
	public static header head;
	public static footer foot;
	public static sidemenu menu;
	public static sidemenu swap;
	public static info homepage;
	public static info startpage;
	public static if_else info1;
	public static while_loop info2;
	public static dowhile_loop info3;
	public static switch_case info4;
	public static forloop info5;
	public static breaks info6;
	public static goto1 info7;
	public static continue1 info8;
	Timer t;
	Dimension dim1;
	
	home() throws IOException
	{
		super();
		home.homepage=new info("back1.png");
		home.startpage=new info("f.jpg");
		home.head=new header();
		home.foot=new footer();
		home.info1=new if_else();
		home.info2=new while_loop();
		home.info3=new dowhile_loop();
		home.info4=new switch_case();
		home.info5=new forloop();
		home.info6=new breaks();
		home.info7=new goto1();
		home.info8=new continue1();
		home.menu=new sidemenu("17.jpg");
		home.swap=new sidemenu("17.jpg");
		home.jf.setSize(1200,800);
		final JFrame jf=home.jf;
		final JFrame jf2=home.jf;
		jf.setDefaultCloseOperation(3);
		home.jf.setTitle("C tutor");
		this.dim1=Toolkit.getDefaultToolkit().getScreenSize();
		this.t=new Timer(800,this);
		(home.start_up=new JFrame()).setSize(400,200);
		home.start_up.setDefaultCloseOperation(3);
		home.start_up.setUndecorated(true);
		home.start_up.setVisible(true);
		home.start_up.setLayout(null);
		home.start_up.setContentPane(new JLabel(new ImageIcon("a.png")));
		home.start_up.setSize(450,300);
		this.dim1=new Dimension();
		this.dim1=Toolkit.getDefaultToolkit().getScreenSize();
		home.start_up.setLocation(this.dim1.width/2-home.start_up.getSize().width/2,this.dim1.height/2);
		home.jf.add((Component)home.head,"North");
		home.jf.add((Component)home.homepage,"Center");
		home.jf.add((Component)home.menu,"West");
		home.jf.add((Component)home.foot,"South");
		this.t.start();
	}
	
	@Override
	public void actionPerformed(final ActionEvent actionEvent)
	{
		home.start_up.dispose();
		this.t.stop();
		home.jf.setVisible(true);
		home.jf.revalidate();
		home.jf.repaint();
	}
	
	static 
	{
		home.jf=new JFrame();
	}
}


class staticframe
{
	public static JFrame f1;
	public static Dimension dim1;
	public static JPanel code;
	public static JPanel demo,c1,d1,d2,d3;
	public static Border line;
	public static TitledBorder title1,title2;
	public static void createframe(JFrame f)
	{
		line=BorderFactory.createLineBorder(Color.black);
		title1=BorderFactory.createTitledBorder(line,"<html><h3>Conditions</h3></html>",TitledBorder.CENTER,0);
		title2=BorderFactory.createTitledBorder(line,"<html><h3>Output</h3></html>",TitledBorder.CENTER,0);
		dim1=new Dimension();
		code=new JPanel();
		demo=new JPanel();
		d1=new JPanel();
		d2=new JPanel();
		d3=new JPanel();
		
		f.setVisible(true);
		f.setLayout(new GridLayout(1,0));
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(700,500);
		dim1=Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim1.width/2-f.getSize().width/2,dim1.height/2-f.getSize().height/2);
		code.setBackground(new Color(0xF0F8FF));		
		code.setLayout(null);
		demo.setLayout(null);
		demo.setBackground(new Color(0xADD8E6));
		f.add(code);
		f.add(demo);
		c1=new JPanel();
		c1.setBackground(new Color(0xF0F8FF));
		c1.setLayout(new BoxLayout(c1,BoxLayout.Y_AXIS));
		c1.setBounds(50,60,200,400);
		code.add(c1);
		d1.setBackground(new Color(0xFFFFE0));
		d1.setBounds(20,210,140,250);
		d1.setLayout(new BoxLayout(d1,BoxLayout.Y_AXIS));
		d1.setBorder(title1);
		d2.setBackground(new Color(0xFFE4B5));
		d2.setBounds(170,210,140,250);
		d2.setLayout(new BoxLayout(d2,BoxLayout.Y_AXIS));
		d2.setBorder(title2);
		d3.setBackground(Color.orange);
		d3.setBounds(120,90,90,60);
		d3.setBorder(line);
		demo.add(d1);
		demo.add(d2);
		demo.add(d3);
	
	}
}





////*/
class goto1 extends JPanel implements ActionListener
{
	public static JPanel p,p1;
	public static Image img;
	public static JButton prev;
	public static JButton demo;
	public static JButton next;
	public static JLabel contents,l1,l2,l3,l1_demo,l2_demo[],l3_demo[],x_demo;
	
	public static JFrame f;
	public static Dimension dim1;
	public static int i;
	
	BufferedReader br;
	JScrollPane jsp;
	StringBuffer sb;
	String line;
	goto1() throws IOException{
	 	super();
		this.setLayout(new BorderLayout());
		this.p=new JPanel();
		this.p1=new JPanel();
		contents=new JLabel();
		
		this.img=ImageIO.read(new File("demo.png"));
		(this.prev=new JButton(new ImageIcon(new ImageIcon("prev.png").getImage().getScaledInstance(50,30,4)))).setContentAreaFilled(false);
		this.demo=new JButton(new  ImageIcon(new ImageIcon("demo.png").getImage().getScaledInstance(50,30,4)));
		(this.next=new JButton(new ImageIcon(new ImageIcon("next.png").getImage().getScaledInstance(50,30,4)))).setContentAreaFilled(false);
		this.prev.setContentAreaFilled(false);
		this.demo.setContentAreaFilled(false);
		this.demo.setBorderPainted(false);
		this.demo.addActionListener(this);
		this.prev.addActionListener(this);
		this.next.addActionListener(this);
		this.p.setBackground(Color.GRAY);
		this.p.add(this.prev);
		this.p.add(this.demo);
		this.p.add(this.next);
		br= new BufferedReader(new FileReader("goto1.html"));
		sb=new StringBuffer();
		line=null;
		while((line=br.readLine())!=null)
		{
			sb.append(line+"<br>");
		}
		line=sb.toString();
		contents.setText("<html><body background='file:f.jpg'><font color='yellow'>"+line+"</font></body><img src='goto1.jpg'/></html>");
		jsp=new JScrollPane(p1);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setPreferredSize(new Dimension(500,550));
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		p1.add(contents);
		
		this.add(this.jsp,"North");
		this.add(this.p,"South");
	}
	public void paintComponent(final Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(this.img,0,0,this.getWidth(),this.getHeight(),null);
	}

	@Override
	public void actionPerformed(final ActionEvent actionEvent)
	{
		if(actionEvent.getSource()==this.prev)
		{
			Remove.remove();
			home.jf.add((Component)home.info6,"Center");
			swapside.swap();
		}
		else if(actionEvent.getSource()==this.next)
		{
			Remove.remove();
			home.jf.add((Component)home.info8,"Center");
			swapside.swap();
		}
		else if(actionEvent.getSource()==this.demo)
		{
		f=new JFrame("Goto demo");
			l1=new JLabel("<html><h3>Sample code:</h3><br>#include<&lt;stdio.h&gt;<br>void main()<br>{<br>int i=0;<br>while(i&lt;4)</html>");
			l2=new JLabel("<html>{<br>if(i==2)<br>goto label;<br>printf('Hello world');<br>i++;<br><br>}label:printf('Bye');<br>}</html>");
			l3=new JLabel();
			
			l1_demo=new JLabel();
			l2_demo=new JLabel[5];
			l3_demo=new JLabel[5];
			for(int i=0;i<5;i++)
			{
				l2_demo[i]=new JLabel();
				l3_demo[i]=new JLabel();
			}
			staticframe.createframe(f);
			staticframe.c1.add(l1);
			staticframe. c1.add(l2);
			x_demo=new JLabel();
			
			x_demo.setText("<html><h2>i</h2></html>");
			x_demo.setBounds(155,50,40,40);
			staticframe.demo.add(x_demo);
			
			l1_demo.setText("");
			staticframe.d3.add(l1_demo);
			for(int i=0;i<5;i++)
			{	
				l2_demo[i].setText("");
				staticframe.d1.add(l2_demo[i]);
				l3_demo[i].setText("");
				staticframe.d2.add(l3_demo[i]);
			}
			i=0;
			gotodemo d1=new gotodemo();
			d1.start();
  	}
			  	
		
		
	}
}


class gotodemo extends Thread
{
		String s1_demo;
  public void run()
  {
	try
	{
		Thread.sleep(3000);	
	}
	catch(InterruptedException e)
	{
		System.out.println(e);
	}
	while(true)
	{
		if(goto1.f.isDisplayable() == false)
		{
			break;
		}
		if(goto1.i == 0)
		{
			goto1.l1_demo.setText("<html><h1>"+goto1.i+"</h1></html>");
			goto1.l2_demo[goto1.i].setText("<html><h3>"+goto1.i+ "&lt;4;True</h3></html>");
			staticframe.d1.add(goto1.l2_demo[goto1.i]);
			goto1.l3_demo[goto1.i].setText("<html><h3>Hello World!</h3></html>");
			staticframe.d2.add(goto1.l3_demo[goto1.i]);
			//color for
			goto1.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
			goto1.l2.setText("<html>{<br> if(i==2)<br>  goto label;<br><br><span style='background-color:#FFE4B5;'>printf('Hello World!');</span><br><span style=background-color:#ADFF2F;>i++;</span><br>}<br>label:printf('Bye!');<br>}</html>");
			staticframe.c1.add(goto1.l1);
			staticframe.c1.add(goto1.l2);
			goto1.i++;
		}
		if(goto1.f.isDisplayable()== false)
			break;
		try
		{
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		if(goto1.i == 1)
		{
			goto1.l1_demo.setText("<html><h1>"+goto1.i+"</h1></html>");
                      goto1.l2_demo[goto1.i].setText("<html><h3>"+goto1.i+ "&lt;4;True</h3></html>");
                        staticframe.d1.add(goto1.l2_demo[goto1.i]);
                        goto1.l3_demo[goto1.i].setText("<html><h3>Hello World!</h3></html>");
                        staticframe.d2.add(goto1.l3_demo[goto1.i]);
                       goto1.i++;
                       goto1.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
                       goto1.l2.setText("<html>{<br>if(i==2)<br>goto label;<br><span style='background-color:#FFE4B5;'>printf('Hello World!');</span><br><span style=background-color:#ADFF2F;>i++;</span><br>}<br>label:printf('Bye!');<br>}</html>");
                        staticframe.c1.add(goto1.l1);
                        staticframe.c1.add(goto1.l2);
                 }
		 if(goto1.f.isDisplayable()== false)
                        break;
                try
                {
                        Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                        System.out.println(e);
                }
		 if(goto1.i == 2)
                {
                        goto1.l1_demo.setText("<html><h1>"+goto1.i+"</h1></html>");
                       /* goto1.l2_demo[goto1.i].setText("<html><h3>"+goto1.i+ "&lt;4;True</h3></html>");
                        staticframe.d1.add(goto1.l2_demo[goto1.i]);*/
                     goto1.l3_demo[goto1.i].setText("<html><h3>Bye!</h3></html>");
                        staticframe.d2.add(goto1.l3_demo[goto1.i]);
                        goto1.i++;
                       goto1.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
                    goto1.l2.setText("<html>{<br><br><span style='background-color:#ADFF2F;'>if(i==2)<br>goto label;</span><br>printf('Hello World!');<br>i++;</span><br>}<br><span style=background-color:#ADFF2F;>label:printf('Bye!');</span><br>}</html>");
                        staticframe.c1.add(goto1.l1);
                        staticframe.c1.add(goto1.l2);
			//goto label;
			goto1.i++;
                 }
                /* if(goto1.f.isDisplayable()== false)
                        break;
                try
                {
                        Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                        System.out.println(e);
                }
		 if(goto1.i == 3)
                {
                       /* goto1.l1_demo.setText("<html><h1>"+goto1.i+"</h1></html>");
                        goto1.l2_demo[goto1.i].setText("<html><h3>"+goto1.i+ "&lt;4;True</h3></html>");
                        staticframe.d1.add(goto1.l2_demo[goto1.i]);
                       goto1.l3_demo[goto1.i].setText("<html><h3>Hello World!</h3></html>");
                        staticframe.d2.add(goto1.l3_demo[goto1.i]);
                       goto1.i++;
                       goto1.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
                       goto1.l2.setText("<html>{<br><br>if(i==2)<br>goto label;<br><span style='background-color:#FFE4B5;'>printf('Hello World!');</span><br><span style=background-color:#ADFF2F;>i++;</span><br><br><span style=background-color:#ADFF2F;>label:printf('Bye!');</span><br>}</html>");
                        staticframe.c1.add(goto1.l1);
                        staticframe.c1.add(goto1.l2);
                 }
                 if(goto1.f.isDisplayable()== false)
                        break;
                try
                {
                        Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                        System.out.println(e);
                }
		 if(goto1.i == 4)
                {
                         goto1.l1_demo.setText("<html><h1>"+goto1.i+"</h1></html>");
                       goto1.l2_demo[goto1.i].setText("<html><h3>"+goto1.i+ "&lt;4;False</h3></html>");
                        staticframe.d1.add(goto1.l2_demo[goto1.i]);
                        goto1.l3_demo[goto1.i].setText("<html><h3>Bye!</h3></html>");
                        staticframe.d2.add(goto1.l3_demo[goto1.i]);
                        goto1.i++;
                        goto1.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
                        goto1.l2.setText("<html>{<br><br>if(i==2)<br>continue;<br><span style='background-color:#FFE4B5;'>printf('Hello World!');</span><br><span style=background-color:#ADFF2F;>i++;</span><br><br>}printf('Bye!');<br>}</html>");
                        staticframe.c1.add(goto1.l1);
                        staticframe.c1.add(goto1.l2);
                 }
                 if(goto1.f.isDisplayable()== false)
                        break;
                try
                {
                        Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                        System.out.println(e);
                }*/
		
		
	}
   }

}


class contdemo extends Thread
{
	String s1_demo;
  public void run()
  {
	try
	{
		Thread.sleep(3000);	
	}
	catch(InterruptedException e)
	{
		System.out.println(e);
	}
	while(true)
	{
		if(continue1.f.isDisplayable() == false)
		{
			break;
		}
		if(continue1.i == 0)
		{
			continue1.l1_demo.setText("<html><h1>"+continue1.i+"</h1></html>");
			continue1.l2_demo[continue1.i].setText("<html><h3>"+continue1.i+ "&lt;4;True</h3></html>");
			staticframe.d1.add(continue1.l2_demo[continue1.i]);
			continue1.l3_demo[continue1.i].setText("<html><h3>Hello World!</h3></html>");
			staticframe.d2.add(continue1.l3_demo[continue1.i]);
			//color for
			continue1.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
			continue1.l2.setText("<html>{<br> if(i==2)<br> 	continue;<br><br><span style='background-color:#FFE4B5;'>printf('Hello World!');</span><br><span style=background-color:#ADFF2F;>i++;</span><br><br>printf('Bye!');<br>}</html>");
			staticframe.c1.add(continue1.l1);
			staticframe.c1.add(continue1.l2);
			continue1.i++;
		}
		if(continue1.f.isDisplayable()== false)
			break;
		try
		{
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		if(continue1.i == 1)
		{
			continue1.l1_demo.setText("<html><h1>"+continue1.i+"</h1></html>");
                      continue1.l2_demo[continue1.i].setText("<html><h3>"+continue1.i+ "&lt;4;True</h3></html>");
                        staticframe.d1.add(continue1.l2_demo[continue1.i]);
                        continue1.l3_demo[continue1.i].setText("<html><h3>Hello World!</h3></html>");
                        staticframe.d2.add(continue1.l3_demo[continue1.i]);
                       continue1.i++;
                       continue1.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
                       continue1.l2.setText("<html>{<br>if(i==2)<br>	continue;<br><span style='background-color:#FFE4B5;'>printf('Hello World!');</span><br><span style=background-color:#ADFF2F;>i++;</span><br><br>printf('Bye!');<br>}</html>");
                        staticframe.c1.add(continue1.l1);
                        staticframe.c1.add(continue1.l2);
                 }
		 if(continue1.f.isDisplayable()== false)
                        break;
                try
                {
                        Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                        System.out.println(e);
                }
		 if(continue1.i == 2)
                {
                       /*  continue1.l1_demo.setText("<html><h1>"+continue1.i+"</h1></html>");
                        continue1.l2_demo[continue1.i].setText("<html><h3>"+continue1.i+ "&lt;4;True</h3></html>");
                        staticframe.d1.add(continue1.l2_demo[continue1.i]);
                     continue1.l3_demo[continue1.i].setText("<html><h3>Hello World!</h3></html>");
                        staticframe.d2.add(continue1.l3_demo[continue1.i]);
                        continue1.i++;
                       continue1.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");*/
                    continue1.l2.setText("<html>{<br><br><span style='background-color:#ADFF2F;'>if(i==2)<br>continue;</span><br>printf('Hello World!');<br><span style=background-color:#ADFF2F;>i++;</span><br><br>printf('Bye!');<br>}</html>");
                        staticframe.c1.add(continue1.l1);
                        staticframe.c1.add(continue1.l2);
			
			continue1.i++;
                 }
                 if(continue1.f.isDisplayable()== false)
                        break;
                try
                {
                        Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                        System.out.println(e);
                }
		 if(continue1.i == 3)
                {
                        continue1.l1_demo.setText("<html><h1>"+continue1.i+"</h1></html>");
                        continue1.l2_demo[continue1.i].setText("<html><h3>"+continue1.i+ "&lt;4;True</h3></html>");
                        staticframe.d1.add(continue1.l2_demo[continue1.i]);
                       continue1.l3_demo[continue1.i].setText("<html><h3>Hello World!</h3></html>");
                        staticframe.d2.add(continue1.l3_demo[continue1.i]);
                       continue1.i++;
                       continue1.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
                       continue1.l2.setText("<html>{<br><br>if(i==2)<br>continue;<br><span style='background-color:#FFE4B5;'>printf('Hello World!');</span><br><span style=background-color:#ADFF2F;>i++;</span><br><br>printf('Bye!');<br>}</html>");
                        staticframe.c1.add(continue1.l1);
                        staticframe.c1.add(continue1.l2);
                 }
                 if(continue1.f.isDisplayable()== false)
                        break;
                try
                {
                        Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                        System.out.println(e);
                }
		 if(continue1.i == 4)
                {
                         continue1.l1_demo.setText("<html><h1>"+continue1.i+"</h1></html>");
                       continue1.l2_demo[continue1.i].setText("<html><h3>"+continue1.i+ "&lt;4;False</h3></html>");
                        staticframe.d1.add(continue1.l2_demo[continue1.i]);
                        continue1.l3_demo[continue1.i].setText("<html><h3>Bye!</h3></html>");
                        staticframe.d2.add(continue1.l3_demo[continue1.i]);
                        continue1.i++;
                        continue1.l1.setText("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br><span style='background-color:yellow;'>int i=0;</span><br><span style='background-color:#FFFFE0;'>while(i&lt;<4)</span></html>");
                        continue1.l2.setText("<html>{<br><br>if(i==2)<br>continue;<br><span style='background-color:#FFE4B5;'>printf('Hello World!');</span><br><span style=background-color:#ADFF2F;>i++;</span><br><br>}printf('Bye!');<br>}</html>");
                        staticframe.c1.add(continue1.l1);
                        staticframe.c1.add(continue1.l2);
                 }
                 if(continue1.f.isDisplayable()== false)
                        break;
                try
                {
                        Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                        System.out.println(e);
                }
	}
   }


}



class continue1 extends JPanel implements ActionListener
{
	
	public static JPanel p,p1;
	public static Image img;
	public static JButton prev;
	public static JButton demo;
	public static JButton next;
	public static JLabel contents,l1,l2,l3,l1_demo,l2_demo[],l3_demo[],x_demo;
	
	public static JFrame f;
	public static Dimension dim1;
	public static int i;
	
	BufferedReader br;
	JScrollPane jsp;
	StringBuffer sb;
	String line;
	continue1() throws IOException{
	 	super();
		this.setLayout(new BorderLayout());
		this.p=new JPanel();
		this.p1=new JPanel();
		contents=new JLabel();
		
		this.img=ImageIO.read(new File("a.png"));
		(this.prev=new JButton(new ImageIcon(new ImageIcon("prev.png").getImage().getScaledInstance(50,30,4)))).setContentAreaFilled(false);
		this.demo=new JButton(new  ImageIcon(new ImageIcon("demo.png").getImage().getScaledInstance(50,30,4)));
		
		this.prev.setContentAreaFilled(false);
		this.demo.setContentAreaFilled(false);
		this.demo.setBorderPainted(false);
		this.demo.addActionListener(this);
		this.prev.addActionListener(this);
		this.p.setBackground(Color.GRAY);
		this.p.add(this.prev);
		this.p.add(this.demo);
		br= new BufferedReader(new FileReader("continue1.html"));
		sb=new StringBuffer();
		line=null;
		while((line=br.readLine())!=null)
		{
			sb.append(line+"<br>");
		}
		line=sb.toString();
		contents.setText("<html><body background='f.jpg'>"+line+"</body></html>");
		jsp=new JScrollPane(p1);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setPreferredSize(new Dimension(500,550));
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		p1.add(contents);
		
		this.add(this.jsp,"North");
		this.add(this.p,"South");
	}
	public void paintComponent(final Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(this.img,0,0,this.getWidth(),this.getHeight(),null);
	}

	@Override
	public void actionPerformed(final ActionEvent actionEvent)
	{
		if(actionEvent.getSource()==this.prev)
		{
			Remove.remove();
			home.jf.add((Component)home.info7,"Center");
			swapside.swap();
		}
		
		else if(actionEvent.getSource()==this.demo)
		{
			/*
			final JPanel p2=new JPanel();
			final JPanel p1=new JPanel();
			f=new JFrame();
			JButton b=new JButton("Submit");
			JLabel l1,l2,l3;
			l1=new JLabel("<html><h3>Sample Code:</h3><br>#include&lt;stdio.h&gt;<br>void main()<br>{<br>int a=10;<br>do<br>{</html>");
			l2=new JLabel("<html>{<br>if(a==15)<br>{<br>a=a+1;<br>continue;<br>}<br>printf(''value of a:%d\n'',a);<br>a++;<br>while(a&lt;20);}</html>");
				
			p1.setSize(200,200);	
			p2.setSize(200,200);	
			f.add(p1);
			f.add(p1,BorderLayout.WEST);
			p2.setBackground(Color.white);
			f.add(p2,BorderLayout.EAST);
			JButton b1=new JButton("Run");
			b1.setBounds(50,370,100,50);
			
			f.setLayout(new GridLayout());
			l1.setBounds(50,50,250,250);
			l2.setBounds(50,175,240,250);			
			f.setVisible(true);
			f.setSize(700,500);
			//f.add(b);
			p2.setLayout(null);
			p2.add(l1);
			p2.add(l2);
			p2.add(b1);
			f.add(p1,BorderLayout.EAST);
			b1.addActionListener(new ActionListener(){		
			public void actionPerformed(ActionEvent e)
			{		JLabel l3;
					l3=new JLabel("<html><h2>Output:</h2><br><br>value of a:10<br>value of a:11<br>value of a:12<br>value of a:13<br>value of a:14<br>value of a:16<br>value of a:17<br>value of a:18<br>value of a:19<br></html>");
					l3.setBounds(50,-50,50,50);
					l3.setSize(500,500);
					p1.setLayout(null);
					p1.add(l3);
					l3.setVisible(true);
					p1.setBackground(Color.green);
					
				
					
			}
		});*/

		f=new JFrame("Continue demo");
			l1=new JLabel("<html><h3>Sample code:</h3><br>#include<&lt;stdio.h&gt;<br>void main()<br>{<br>int i=0;<br>while(i&lt;4)</html>");
			l2=new JLabel("<html>{<br>if(i==2)<br>continue;<br>printf('Hello world');<br>i++;<br>}<br>}printf('Bye');<br>}</html>");
			l3=new JLabel();
			
			l1_demo=new JLabel();
			l2_demo=new JLabel[5];
			l3_demo=new JLabel[5];
			for(int i=0;i<5;i++)
			{
				l2_demo[i]=new JLabel();
				l3_demo[i]=new JLabel();
			}
			staticframe.createframe(f);
			staticframe.c1.add(l1);
			staticframe. c1.add(l2);
			x_demo=new JLabel();
			
			x_demo.setText("<html><h2>i</h2></html>");
			x_demo.setBounds(155,50,40,40);
			staticframe.demo.add(x_demo);
			
			l1_demo.setText("");
			staticframe.d3.add(l1_demo);
			for(int i=0;i<5;i++)
			{	
				l2_demo[i].setText("");
				staticframe.d1.add(l2_demo[i]);
				l3_demo[i].setText("");
				staticframe.d2.add(l3_demo[i]);
			}
			i=0;
			contdemo d1=new contdemo();
			d1.start();
	  	}



			

		
	}
}
class index
{
	index()
	{
		super();
	}
	
	public static void main(final String[] array)throws IOException,Exception
	{
		new home();
	}
}

		

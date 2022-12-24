import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 import javax.swing.JPanel;
 import javax.swing.JFrame;
 import javax.swing.ImageIcon;
  import javax.swing.Timer;
 
public class water extends JPanel implements KeyListener,ActionListener
{
	int z=1;
	int x=290;
	int move=0;
	int score=0,lives=5;
	int y1=200;
	int y2=200;

	int y4=200;
	
	
	private int [] p1={10,60,110,160,210,260,310,360,410,460,510,560,610,660,};
	private int [] p2={30,80,130,180,230,280,330,380,430,480,530,580,630,680,40,90,140,190,240,290,340,390,440,490,540,590,640,690};
    private int [] p3={20,70,120,170,220,270,320,370,420,470,520,570,620,670};
		
		private boolean left=false;
	private boolean right=false;
	
	private Random r1=new Random();
	private Random r2=new Random();
private Random r3=new Random();
	
	private int pos1=r1.nextInt(14);
	private int pos2=r2.nextInt(28);
private int pos3=r3.nextInt(14);
	
	 private ImageIcon cloud;
	 private ImageIcon car;
	  private ImageIcon d1;
	  private ImageIcon d2;
	 private ImageIcon t1;
	 
	 private Timer timer;
	 private int delay=1;
	 
public water()
{
	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
	timer =new Timer(delay,this);
	timer.start();
}

public void paintComponent(Graphics g)
{
	
	
	// background colour
	g.setColor(Color.WHITE);
	g.fillRect(10,10,860,700);
	
	//inserting cloud
	cloud=new ImageIcon("cloud1.png");
	cloud.paintIcon(this,g,0,0);
	
	
	
	g.setColor(Color.black);
	g.setFont(new Font("arial",Font.PLAIN,14));
	g.drawString("SCORE :"+score,400,50);
	
	g.setColor(Color.black);
	g.setFont(new Font("arial",Font.PLAIN,14));
	g.drawString("LIFE  :"+lives,400,80);
	//inserting car
	if(move==0&&lives>0)
	{
	car=new ImageIcon("cp2.png");
	car.paintIcon(this,g,290,530);
}
else if(move>0&&lives>0)
{
	if(right)
	{
		car=new ImageIcon("cp2.png");
	car.paintIcon(this,g,x,530);
	}
	if(left)
	{
		car=new ImageIcon("cp2.png");
	car.paintIcon(this,g,x,530);
	}
}

d1=new ImageIcon("drop1.png");
t1=new ImageIcon("thund1.png");
d2=new ImageIcon("drop1.png");

d1.paintIcon(this,g,p1[pos1],y1);
d2.paintIcon(this,g,p3[pos3],y2);
t1.paintIcon(this,g,p2[pos2],y4);
if(z%7==0)
{
y1++;
y4++;
}
if(z%13==0)
{
	y2++;
}
z++;


if((p1[pos1]>=x&&p1[pos1]<=x+60) && y1+20==530)
{
	pos1=r1.nextInt(14);
	score++;
	y1=200;
}

if((p2[pos2]>=x&&p2[pos2]<=x+60) && y4+20==530)
{
	pos2=r2.nextInt(28);
    lives--;
    y4=200;
}
if((p3[pos3]>=x&&p3[pos3]<=x+60) && y2+20==530)
{
	pos3=r3.nextInt(14);
	score++;
	y2=200;
}


if(y1==600)
{
	pos1=r1.nextInt(14);
	pos2=r2.nextInt(28);
	y1=200;
	y4=200;
	lives--;
}
if(y2==600)
{
	pos3=r3.nextInt(14);
	
	y2=200;
	lives--;
}
if(lives<=0)
{
	left=false;
	right=false;
	g.setColor(Color.WHITE);
	g.fillRect(10,10,860,700);
	g.setColor(Color.RED);
g.setFont(new Font("arial",Font.BOLD,50));
g.drawString("GAME OVER",250,200);
	g.setColor(Color.black);
	g.setFont(new Font("arial",Font.BOLD,20));
	g.drawString("SCORE :"+score,350,300);
	g.setColor(Color.black);
	g.setFont(new Font("arial",Font.BOLD,50));
	g.drawString("PRESS SPACE TO PLAY AGAIN",80,400);
}
	
repaint();

	g.dispose();
	
	
}

	

public void actionPerformed(ActionEvent e)
 {
 }

public void keyPressed(KeyEvent e)
    {
		if(e.getKeyCode()== KeyEvent.VK_SPACE)
   {
	   move=0;
	   z=1;
	   score=0;
	   lives=5;
	   y1=200;
	   y2=200;
	    y4=200;
	    x=290;
	}
	   

   if(e.getKeyCode()== KeyEvent.VK_RIGHT)
   {
	   move++;
	   x=x+10;
	   if(x>700)
	   {
		   x=0;
	   }
	   right=true;
	   left=false;
   }
    if(e.getKeyCode()== KeyEvent.VK_LEFT)
   {
	   move++;
	   x=x-10;
	    if(x<0)
	   {
		   x=700;
	   }
	   right=false;
	   left=true;
   }
   
    }
    public void keyReleased(KeyEvent e)
    {
       
    }
    public void keyTyped(KeyEvent e)
    {
      
    }
public static void main(String[] args) 
{
            JFrame mainFrame = new JFrame();
            water w=new water();
            mainFrame.setBounds(10,10,860,700);
            mainFrame.setBackground(Color.WHITE);
            mainFrame.setTitle(" SAVE WATER");
            mainFrame.setResizable(false);
            mainFrame.setVisible(true);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.add(new water());
   }
   
 }      

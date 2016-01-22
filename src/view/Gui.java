package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.SecondaryLoop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import controler.Observer1;
import controler.SaveLoad;
import model.*;

import java.awt.Color;
import java.awt.FlowLayout;


public class Gui extends JPanel implements KeyListener  {
	/**
	 * 
	 */
	private Timer timer = null;
	private Timer Reminder=null;
	player player1;
	player player2;
	TakeShape take1;
	TakeShape take2;
	Observer1 observer1;
	Observer1 observer2;
	private static final long serialVersionUID = 1L;
	private ArrayList<Shape> shapes;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	JLabel lblNewLabel_4;
	String url1="../circusOfplates/src/File/player1";
	String url2="../circusOfplates/src/File/player2";
	int reminder=0;
	int secounds=60;
	
	public Gui() throws IOException{
		setBackground(Color.MAGENTA);
		setFocusable(true);
		addKeyListener(this);
		//setBackground(Color.GRAY);

		final Pool instance = Pool.getInstance();
		shapes=instance.getUnusedList();
		player1=new player("../circusOfplates/src/images/Superman.png",new Point(1200,600));
		player2=new player("../circusOfplates/src/images/Batman.png",new Point(100,600));
		take1=new TakeShape(player1);
		take2=new TakeShape(player2);
		observer1=new Observer1(take1);
		observer2=new Observer1(take2);
		
	
	timer = new Timer(20, new ActionListener() {

		
		 public void actionPerformed(ActionEvent e) {
//			 System.out.println(pressed.size());
			 
			 for(Integer k: pressed)
				{
				 System.out.println(pressed.size());

				
					if( k == KeyEvent.VK_RIGHT){
						System.out.println("saas");
						player1.setLocationX(Math.min(
								player1.getLocationX() + 10, getWidth() - 5));
						for(Shape shape : player1.playerRightHand){
							shape.x=player1.getLocationX()+70;
							shape.x=shape.x+10;
						}
						repaint();
						for(Shape shape : player1.playerLeftHand){
							shape.x=player1.getLocationX()-50;
							shape.x=shape.x-10;
						}
						repaint();
					}
						
					else if( k == KeyEvent.VK_LEFT){
						player1.setLocationX(Math.max(
								player1.getLocationX() - 10, 0));
						for(Shape shape : player1.playerRightHand){
							shape.x=player1.getLocationX()+70;
							shape.x=shape.x-10;
						}
						repaint();
						for(Shape shape : player1.playerLeftHand){
							shape.x=player1.getLocationX()-50;
							shape.x=shape.x-10;
						}
						repaint();
					}
						
					else if( k == KeyEvent.VK_D ){
						player2.setLocationX(Math.min(
								player2.getLocationX() + 10, getWidth() - 5));
						for(Shape shape : player2.playerRightHand){
							shape.x=player2.getLocationX()+70;
							shape.x=shape.x+10;
						}
						repaint();
						for(Shape shape : player2.playerLeftHand){
							shape.x=player2.getLocationX()-50;
							shape.x=shape.x-10;
						}
						repaint();
					}
					else if( k == KeyEvent.VK_A){
						player2.setLocationX(Math.max(
								player2.getLocationX() - 10, 0));
						for(Shape shape : player2.playerRightHand){
							shape.x=player2.getLocationX()+70;
							shape.x=shape.x-10;
						}
						repaint();
						for(Shape shape : player2.playerLeftHand){
							shape.x=player2.getLocationX()-50;
							shape.x=shape.x-10;
						}
						repaint();
					}
					repaint();
				}
			 reminder+=20;
			 if(reminder ==1000){
				 secounds--;
				reminder=0;
				 
				lblNewLabel_4.setText("reminder time"+" " +String.valueOf(secounds)+ " " + "seconds");
				 
			 }
			 if(secounds==0){
				 String winner1="";
				 if(player1.getScore()> player2.getScore()){
					 
					 winner1="player 1 has won ";
				 }
				 else if(player1.getScore()< player2.getScore()){
					
					 winner1="player 2 has won ";
					 
				 }else{
					
					 winner1="Ended as draw ";
					 
				 }
				 timer.stop();
				 int dialogResult = JOptionPane.showConfirmDialog (null,  winner1 + "\ndo you want to restart?","Game over",JOptionPane.YES_NO_OPTION);
				 if(dialogResult == JOptionPane.YES_OPTION){
					 	shapes=instance.getUnusedList();
					 	secounds=60;
					 	reminder=0;
					 	repaint();
					 	timer.start();
					 	player1=new player("../circusOfplates/src/images/Superman.png",new Point(1200,600));
						player2=new player("../circusOfplates/src/images/Batman.png",new Point(100,600));
						Random random=new Random();
						for (Shape shape: shapes) {
							if(shape.y>0){
								shape.y=-70;
								shape.inHand=false;
								shape.draw=false;
								shape.belongToPlayer=false;								
								shape.randomDelayedStart= random.nextInt(6000)+40;
								
							}
							
						}
						pressed = new HashSet<Integer>();
						player1.playerLeftHand=new ArrayList();
						player1.playerRightHand=new ArrayList();
						
						take1=new TakeShape(player1);
						take2=new TakeShape(player2);
						observer1=new Observer1(take1);
						observer2=new Observer1(take2);
						
						 
						 
						timer.start();
					   
						
					    
				 }
				 else {
					 System.exit(1);
				 }
				 
			 }
			
			 Shape shape;
             for (int i=0;i<shapes.size();i++) {
            	 shape=shapes.get(i);
            	 take1.takeInHand(shape);
            	 take2.takeInHand(shape);
            	 observer1.update(take1.update, true);
         		observer2.update(take2.update, true);
         		 lblNewLabel_3.setText(String.valueOf(player1.getScore()));
         		lblNewLabel_2.setText(String.valueOf(player2.getScore()));
         		
            	 //System.out.println(String.valueOf(player1.getScore()));
            	 setFocusable(true);
            	 shape.move(shape.y);
              //   System.out.println(shape.y);
                 shape.decreaseDelay();
                 repaint();
                 
               
                 
                 
             }
         }
     });
	
           setLayout(null);
//      JButton reset = new JButton("Reset");
//      reset.addActionListener(new ActionListener(){
//          public void actionPerformed(ActionEvent e) {
//              shapes =instance.getUnusedList();
//              timer.restart();
//              reset.setFocusable(false);
//          }
//      });
      
           JPanel panel = new JPanel();
           panel.setBounds(0, 0, 1370, 43);
           panel.setBackground(Color.ORANGE);
           panel.setLayout(null);
          // panel.add(reset);
           add(panel);
           
             
             
             
            JButton start = new JButton("Start");
            start.setBounds(642, 0, 83, 32);
            panel.add(start);
            
            JLabel lblNewLabel = new JLabel("New label");
            lblNewLabel.setIcon(new ImageIcon("../circusOfplates/src/images/what-is-my-credit-score-how-is-it-calculated.jpg"));
            lblNewLabel.setBounds(0, 0, 197, 43);
            panel.add(lblNewLabel);
            
            JLabel lblNewLabel_1 = new JLabel("New label");
            lblNewLabel_1.setIcon(new ImageIcon("../circusOfplates/src/images/what-is-my-credit-score-how-is-it-calculated.jpg"));
            lblNewLabel_1.setBounds(1163, 0, 197, 43);
            panel.add(lblNewLabel_1);
            
             lblNewLabel_2 = new JLabel("0");
            lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 30));
            lblNewLabel_2.setBackground(Color.BLACK);
            lblNewLabel_2.setBounds(204, 0, 111, 43);
            panel.add(lblNewLabel_2);
            
            lblNewLabel_3 = new JLabel("0");
            lblNewLabel_3.setBounds(1118, 0, 111, 43);
            lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 30));
            panel.add(lblNewLabel_3);
            
            JButton btnNewButton = new JButton("save");
            btnNewButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent arg0) {
            		SaveLoad save=new SaveLoad();
            		save.save(player1, url1);
            		save.save(player2, url2);
            		
            		btnNewButton.setFocusable(false);
            	}
            });
            btnNewButton.setBounds(553, 0, 89, 32);
            panel.add(btnNewButton);
            
            JButton btnNewButton_1 = new JButton("load");
            btnNewButton_1.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		SaveLoad load=new SaveLoad();
            		player1=load.load(url1);
            		player2=load.load(url2);
            		setfocusable();
            		timer.start();
            		btnNewButton_1.setFocusable(false);
            		
            	}
            });
            btnNewButton_1.setBounds(456, 0, 98, 32);
            panel.add(btnNewButton_1);
            
            lblNewLabel_4 = new JLabel("reminder 60 seconds\r\n");
            lblNewLabel_4.setFont(new Font("Serif", Font.BOLD, 30));
            lblNewLabel_4.setBounds(767, 0, 341, 32);
            panel.add(lblNewLabel_4);
            start.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    shapes=instance.getUnusedList();
                    timer.start();
                    start.setFocusable(false);
               	 
                }
            });
            
            
     
 }
	public void setfocusable(){
		this.setFocusable(true);
	}
	
    	
    
	@Override
	public Dimension getPreferredSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		   return new Dimension((int)width, (int)height);
		}
	
	 @Override
	 protected void paintComponent(Graphics g) {
		 
	       BufferedImage img = null;
		try {
			img = ImageIO.read(new File("../circusOfplates/src/images/nuclear_explosion_by_theabp-d59sy3y.gif"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 super.paintComponent(g);
		g.drawImage(img, 0,0, null);
    	
	        for (Shape shape : shapes) {
	   
	        //	System.out.println("here");
	            try {
					shape.drawShape(g);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
	           
	            
	            g.drawImage(player1.getImage(), player1.getLocationX(), player1.getLocationY(), null);
	            g.drawImage(player2.getImage(), player2.getLocationX(), player2.getLocationY(), null);
	          //  g.drawImage(shape.image, shape.x,shape.y, null);
	        }
	    }
	
    
	
	public player getPalyer1(){
		return this.player1;
	}
	public player getPalyer2(){
		return this.player2;
	}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            
            	//ImagePanel panel1 = new ImagePanel(new ImageIcon("F:/my study/proplem/circus of plates/src/images/nuclear.jpg").getImage());
            	JFrame frame=new JFrame();
            	JLayeredPane layeredPane = new JLayeredPane();
            	JPanel panel=new JPanel();
//            	ImageIcon image = new ImageIcon("F:/my study/proplem/circus of plates/src/images/nuclear.jpg");
//        		JLabel label = new JLabel(image);
//        		label.setBounds(0, 0, 500, 500);
//        		JPanel panel1 = new JPanel();
//        		panel1.add( label );
//        		panel1.setBounds(0, 0, 500, 500);
//        		System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssss");
//        		frame.add(panel1);
            	frame.getContentPane().setLayout(new BorderLayout());
            	try {
					panel.add(new Gui());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	frame.getContentPane().add(panel);
            	
            	
            	
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
            }
        });
		
		
		
	}
	
	private Set<Integer> pressed = new HashSet<Integer>();

	@Override
	public void keyPressed(KeyEvent e ) {
//		java.util.Timer time  = new java.util.Timer(); 
//		time.schedule(task, time);
		if(e.getKeyCode()==KeyEvent.VK_RIGHT 
				|| e.getKeyCode()==KeyEvent.VK_LEFT
				|| e.getKeyCode()==KeyEvent.VK_D 
				|| e.getKeyCode()==KeyEvent.VK_A )
			pressed.add(e.getKeyCode());

	}
	
	
	
	@Override
	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode()==KeyEvent.VK_RIGHT 
				|| e.getKeyCode()==KeyEvent.VK_LEFT 
				|| e.getKeyCode()==KeyEvent.VK_D 
				|| e.getKeyCode()==KeyEvent.VK_A )
		{
			
			pressed.remove(e.getKeyCode());
		}
		
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

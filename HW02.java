import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JFrame;

public class HW02 extends JFrame implements Runnable  {

	private Image carleft;
	private Image carright;
	private Image carDown;
	private Image carUp;
	private Random ran, ran2;
	private static int r;
	private static int x,x2;
	private static int y,y2;
	private static int z,z2,z3;
	private static int k,k2,k3;
	public static Semaphore mySemaphore;
	static Thread t1,t2,t3,t4,t5;
	
	

	private int r2;

	// creating the constructor
	public HW02() {

		//getting the image for carleft
		try {
			carleft = ImageIO.read(new FileImageInputStream(new File("car.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//getting the image for carright
		try {
			carright = ImageIO.read(new FileImageInputStream(new File("car2.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//getting the image for carDown
		try {
			carDown = ImageIO.read(new FileImageInputStream(new File("car3.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//getting the image for carUp
		try {
			carUp = ImageIO.read(new FileImageInputStream(new File("car4.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//CREATING MY FRAME
		setSize(800, 800);
		setVisible(true);
		setResizable(false);

	}

	

	//MY PAINT METHOD
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

		// drawing the road lines
		g.drawLine(325, 0, 325, 325);
		g.drawLine(475, 0, 475, 325);
		g.drawLine(0, 325, 325, 325);
		g.drawLine(475, 325, 800, 325);
		g.drawLine(0, 475, 325, 475);
		g.drawLine(475, 475, 800, 475);
		g.drawLine(325, 475, 325, 800);
		g.drawLine(475, 475, 475, 800);

		// drawing the intersection rectangle
		g.setColor(Color.yellow);
		g.fillRect(325, 325, 150, 150);

		g.setColor(Color.white);
		g.fillRect(0, 325, 325, 150);
		g.fillRect(325, 0, 150, 325);
		g.fillRect(475, 325, 325, 150);
		g.fillRect(325, 475, 150, 325);

		ran = new Random();
		ran2 = new Random();

		r = ran.nextInt(100);
		r2 = ran2.nextInt();

		//drawing the cars
		g.drawImage(carleft, x, 400, 60, 40, this);
		g.drawImage(carleft, x2-55, 400, 60, 40, this);
		
		g.drawImage(carright, 800-z, 350, 70, 70, this);
		g.drawImage(carright, 800-z2, 350, 70, 70, this);
	
		
		g.drawImage(carDown, 360, y, 30, 60, this);
		g.drawImage(carDown, 360, y2-40, 30, 60, this);
		
		g.drawImage(carUp, 400, 800-k, 30, 60, this);
		g.drawImage(carUp, 400, 800-k2, 30, 60, this);
		g.drawImage(carUp, 400, 800-k3, 30, 60, this);

	}

	//MY RUN METHOD
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.currentThread().sleep(r + 50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//controlling the conditions to recreate the cars when one exits the frame
			x=x+7;
			if(x>=800) {
				x2=x2+10;
			}
			
			
			k=k+6;
			if(800-k<=0) {
				k2=k2+8;
				k3=k3+5;
			}
			
			
			y=y+5;
			if(y>=800) y2=y2+7;
			
			z=z+8;
			if(800-z<=0) {
				z2=z2+6;
			}
			
			
			repaint();
			
		}
	}

	


	//My MAIN METHOD
		public static void main(String[] args) {

			HW02 f = new HW02();//creating the object
			Thread t= new Thread(f);//creating the thread
		
			 
			 //Starting The Thread
			t.start();
			
			}

		}
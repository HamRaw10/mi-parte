package main;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class window extends JFrame implements Runnable{
	
	public static final int WIDTH = 800, HEIGHT = 600;
	private Canvas canvas;
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public window()
	{
			setTitle("Xddd");
			setSize(WIDTH, HEIGHT);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
			
			canvas = new Canvas();
			
			canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
			canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
			canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
			canvas.setFocusable(true);
			
			add(canvas);
	        pack(); // Asegúrate de llamar a pack() para ajustar el tamaño de la ventana
	        setVisible(true);
	        
	        canvas.createBufferStrategy(3); // Crear la estrategia de búfer aquí

	}
	public static void main(String[] args){
		new window().start();
		
	}
	
	private void update()  {
		
	}
	
	private void draw() {
		bs = canvas.getBufferStrategy();
		
		if(bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		//------------------------
		
		g.drawRect(100, 100, 100, 100);
		
		//------------------------
		g.dispose();
		bs.show();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(running) {//Todo lo que va a pasar, cada fps
			draw();
			
		}
		
		stop();
	}
	private void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	private void stop() {
		try {
			Thread.sleep(16);
			running = false;
		}	catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

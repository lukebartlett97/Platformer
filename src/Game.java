import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class Game{
	JFrame window = null;
	JPanel panel = null;
	List<Platform> platforms = new ArrayList<>();
	List<Coin> coins = new ArrayList<>();
	int totalCoins = 0;
	Player player;
	boolean playing = true;
	long startTime;
	public Game(){
		window = new JFrame("Platformer");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new GamePanel(this);
		panel.setPreferredSize(new Dimension(1200,675));
		player = new Player(1005,250,20,20, this);
		Player.attach(player, panel);
		window.setContentPane(panel);
		window.pack();
		window.setLocation(75,0);
		window.setVisible(true);
		loadPlatforms();
		mainLoop();
	}
	
	public void mainLoop(){
		while(playing){
			for(GameObject gameObject: platforms){
				gameObject.update();
			}
			player.update();
			panel.repaint();
			sleep(15);
		}
		window.dispose();
	}
	public static void main(String[] args){
		while(true){
			new Game();
		}
	}
	public void sleep(int ms) {
		try { Thread.sleep(ms); } catch(InterruptedException e) {}
		}
	public void loadPlatforms(){
		//platforms.add(new Platform(325,140,50,50,this));
		//platforms.add(new ElevatorPlatform(450,100,50,10,this, false, 100, 300, 2));
		//coins.add(new Coin(345,125,10,10,this));
		
		//Top left coin and platform
		coins.add(new Coin(10,10,20,20,this));
		totalCoins++;
		platforms.add(new Platform(0,40,80,40,this));
		
		//Platform and X-Lift leading to coin
		platforms.add(new ElevatorPlatform(120,120,80,40,this, true, 120, 400, 2));
		platforms.add(new Platform(440,240,160,40,this));
		
		//Stairs
		platforms.add(new Platform(720,280,40,160,this));
		platforms.add(new Platform(760,320,40,120,this));
		platforms.add(new Platform(800,360,40,80,this));
		platforms.add(new Platform(840,400,40,40,this));
		
		//U-Shape
		platforms.add(new Platform(80,320,40,80,this));
		platforms.add(new Platform(80,400,200,40,this));
		platforms.add(new Platform(240,320,40,80,this));
		coins.add(new Coin(170,370,20,20,this));
		totalCoins++;
		
		//Y-Lift by U-Shape
		platforms.add(new ElevatorPlatform(320,360,120,40,this, false, 360, 640, 2));
		
		//Platform and coin under Y-Lift
		coins.add(new Coin(370,770,20,20,this));
		totalCoins++;
		platforms.add(new Platform(320,800,120,40,this));
		
		//Line under U-Shape
		platforms.add(new Platform(160,440,40,40,this));
		platforms.add(new Platform(160,520,40,280,this));
		
		//2 mini platforms on left with coin
		platforms.add(new Platform(0,400,80,40,this));
		platforms.add(new Platform(0,440,40,240,this));
		coins.add(new Coin(50,650,20,20,this));
		totalCoins++;
		platforms.add(new Platform(0,680,80,40,this));
		platforms.add(new Platform(0,800,80,40,this));
		
		//X-Lift at bottom left
		platforms.add(new ElevatorPlatform(0,960,120,40,this, true, 0, 480, 2));
		
		//Staircase leading up from bottom left with under-stairs coin
		platforms.add(new Platform(560,880,80,40,this));
		platforms.add(new Platform(640,760,80,40,this));
		platforms.add(new Platform(720,640,80,40,this));
		coins.add(new Coin(770,450,20,20,this));
		totalCoins++;
		
		//Y-Lift left of start and adjacent X-Lift
		platforms.add(new ElevatorPlatform(880,600,80,40,this, false, 600, 960, 2));
		platforms.add(new ElevatorPlatform(1080,800,120,40,this, true, 1080, 1280, 2));
		
		//Path and crusher
		platforms.add(new Platform(880,1040,160,40,this));
		platforms.add(new Platform(1000,1080,80,40,this));
		platforms.add(new Platform(1040,1120,80,40,this));
		platforms.add(new Platform(1080,1160,240,40,this));
		platforms.add(new Platform(1320,1000,40,200,this));
		platforms.add(new ElevatorPlatform(1240,1120,80,40,this, false, 1000, 1120, -2));
		
		//Platform right of start
		coins.add(new Coin(1170,410,20,20,this));
		totalCoins++;
		platforms.add(new Platform(1080,440,200,40,this));
		
		//Y-Lift right of start
		platforms.add(new ElevatorPlatform(1300,480,80,40,this, false, 120, 720, -4));
		
		//Top Left of Maze: 1400, 440
		platforms.add(new Platform(1400,440,40,320,this));
		platforms.add(new Platform(1440,560,120,40,this));
		platforms.add(new Platform(1440,720,280,40,this));
		platforms.add(new Platform(1480,640,160,40,this));
		platforms.add(new Platform(1600,440,40,160,this));
		platforms.add(new Platform(1640,560,40,40,this));
		platforms.add(new Platform(1600,600,200,40,this));
		platforms.add(new Platform(1680,680,40,40,this));
		coins.add(new Coin(1690,650,20,20,this));
		totalCoins++;
		platforms.add(new Platform(1760,640,40,120,this));
		
		//Islands Around maze
		platforms.add(new Platform(1400,880,160,40,this));
		platforms.add(new Platform(1680,840,120,40,this));
		platforms.add(new Platform(1880,760,80,40,this));
		platforms.add(new Platform(1840,640,80,40,this));
		platforms.add(new Platform(2080,720,40,40,this));
		platforms.add(new Platform(2240,720,40,40,this));
		platforms.add(new Platform(2360,640,40,40,this));
		coins.add(new Coin(2410,530,20,20,this));
		totalCoins++;
		
		//Platform above start
		coins.add(new Coin(1010,10,20,20,this));
		totalCoins++;
		platforms.add(new Platform(960,40,200,40,this));
		platforms.add(new Platform(1120,80,160,40,this));
		
		//Platform left of top Y-Lift
		platforms.add(new Platform(1520,120,160,40,this));
		
		//Moving Stairs
		platforms.add(new ElevatorPlatform(1840,160,40,40,this, false, 160, 400, 2));
		platforms.add(new ElevatorPlatform(1880,120,40,80,this, false, 120, 360, 2));
		platforms.add(new ElevatorPlatform(1920,80,40,80,this, false, 80, 320, 2));
		platforms.add(new ElevatorPlatform(1960,40,40,80,this, false, 40, 280, 2));
		platforms.add(new ElevatorPlatform(2000,0,40,80,this, false, 0, 240, 2));
		
		//Top right coin platform
		platforms.add(new Platform(2120,120,120,40,this));
		platforms.add(new Platform(2200,40,40,80,this));
		coins.add(new Coin(2170,90,20,20,this));
		totalCoins++;
		
		
		//Starting Platform
		platforms.add(new Platform(960,320,120,40,this));
		}
}

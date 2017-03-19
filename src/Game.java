import java.awt.Dimension;
import java.util.Timer;
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
	Clock clock;
	Timer clockTimer;
	int maxTime = 60;
	public Game(){
		window = new JFrame("Platformer");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new GamePanel(this);
		panel.setPreferredSize(new Dimension(1200,675));
		player = new Player(25,6,1,1, this);
		Player.attach(player, panel);
		window.setContentPane(panel);
		window.pack();
		window.setLocation(75,0);
		window.setVisible(true);
		loadPlatforms();
		clock = new Clock();
		clockTimer = new Timer();
		clockTimer.scheduleAtFixedRate(clock, 1000,1000);
		mainLoop();
	}
	
	public void mainLoop(){
		while(playing){
			for(Platform platform: platforms){
				platform.update();
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
		coins.add(new Coin(0,0,1,1,this));
		totalCoins++;
		platforms.add(new Platform(0,1,2,1,this));
		
		//Platform and X-Lift leading to coin
		platforms.add(new ElevatorPlatform(3,3,2,1,this, true, 3, 10, 2));
		platforms.add(new Platform(11,6,4,1,this));
		
		//Stairs
		platforms.add(new Platform(18,7,1,4,this));
		platforms.add(new Platform(19,8,1,3,this));
		platforms.add(new Platform(20,9,1,2,this));
		platforms.add(new Platform(21,10,1,1,this));
		
		//U-Shape
		platforms.add(new Platform(2,8,1,2,this));
		platforms.add(new Platform(2,10,5,1,this));
		platforms.add(new Platform(6,8,1,2,this));
		coins.add(new Coin(4,9,1,1,this));
		totalCoins++;
		
		//Y-Lift by U-Shape
		platforms.add(new ElevatorPlatform(8,9,3,1,this, false, 9, 16, 2));
		
		//Platform and coin under Y-Lift
		coins.add(new Coin(9,19,1,1,this));
		totalCoins++;
		platforms.add(new Platform(8,20,3,1,this));
		
		//Line under U-Shape
		platforms.add(new Platform(4,11,1,1,this));
		platforms.add(new Platform(4,13,1,7,this));
		
		//2 mini platforms on left with coin
		platforms.add(new Platform(0,10,2,1,this));
		platforms.add(new Platform(0,11,1,6,this));
		coins.add(new Coin(1,16,1,1,this));
		totalCoins++;
		platforms.add(new Platform(0,17,2,1,this));
		platforms.add(new Platform(0,20,2,1,this));
		
		//X-Lift at bottom left
		platforms.add(new ElevatorPlatform(0,24,3,1,this, true, 0, 12, 2));
		
		//Staircase leading up from bottom left with under-stairs coin
		platforms.add(new Platform(14,22,2,1,this));
		platforms.add(new Platform(16,19,2,1,this));
		platforms.add(new Platform(18,16,2,1,this));
		coins.add(new Coin(19,11,1,1,this));
		totalCoins++;
		
		//Y-Lift left of start and adjacent X-Lift
		platforms.add(new ElevatorPlatform(22,15,2,1,this, false, 15, 24, 2));
		platforms.add(new ElevatorPlatform(27,20,3,1,this, true, 27, 32, 2));
		
		//Path and crusher
		platforms.add(new Platform(22,26,4,1,this));
		platforms.add(new Platform(25,27,2,1,this));
		platforms.add(new Platform(26,28,2,1,this));
		platforms.add(new Platform(27,29,6,1,this));
		platforms.add(new Platform(33,25,1,5,this));
		platforms.add(new ElevatorPlatform(31,28,2,1,this, false, 25, 28, -2));
		
		//Platform right of start
		coins.add(new Coin(29,10,1,1,this));
		totalCoins++;
		platforms.add(new Platform(27,11,5,1,this));
		
		//Y-Lift right of start
		platforms.add(new ElevatorPlatform(33,12,2,1,this, false, 3, 18, -4));
		
		//Top Left of Maze: 1400, 440
		platforms.add(new Platform(35,11,1,8,this));
		platforms.add(new Platform(36,14,3,1,this));
		platforms.add(new Platform(36,18,7,1,this));
		platforms.add(new Platform(37,16,4,1,this));
		platforms.add(new Platform(40,11,1,4,this));
		platforms.add(new Platform(41,14,1,1,this));
		platforms.add(new Platform(40,15,5,1,this));
		platforms.add(new Platform(42,17,1,1,this));
		coins.add(new Coin(42,16,1,1,this));
		totalCoins++;
		platforms.add(new Platform(44,16,1,3,this));
		
		//Islands Around maze
		platforms.add(new Platform(35,22,4,1,this));
		platforms.add(new Platform(42,21,3,1,this));
		platforms.add(new Platform(47,19,2,1,this));
		platforms.add(new Platform(46,16,2,1,this));
		platforms.add(new Platform(52,18,1,1,this));
		platforms.add(new Platform(56,18,1,1,this));
		platforms.add(new Platform(59,16,1,1,this));
		coins.add(new Coin(60,13,1,1,this));
		totalCoins++;
		
		//Platform above start
		coins.add(new Coin(25,0,1,1,this));
		totalCoins++;
		platforms.add(new Platform(24,1,5,1,this));
		platforms.add(new Platform(28,2,4,1,this));
		
		//Platform left of top Y-Lift
		platforms.add(new Platform(38,3,4,1,this));
		
		//Moving Stairs
		platforms.add(new ElevatorPlatform(46,4,1,1,this, false, 4, 10, 2));
		platforms.add(new ElevatorPlatform(47,3,1,2,this, false, 3, 9, 2));
		platforms.add(new ElevatorPlatform(48,2,1,2,this, false, 2, 8, 2));
		platforms.add(new ElevatorPlatform(49,1,1,2,this, false, 1, 7, 2));
		platforms.add(new ElevatorPlatform(50,0,1,2,this, false, 0, 6, 2));
		
		//Top right coin platform
		platforms.add(new Platform(53,3,3,1,this));
		platforms.add(new Platform(55,1,1,2,this));
		coins.add(new Coin(54,2,1,1,this));
		totalCoins++;
		
		
		//Starting Platform
		platforms.add(new Platform(24,8,3,1,this));
		}
}

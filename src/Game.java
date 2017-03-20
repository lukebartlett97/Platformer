import java.awt.Dimension;
import java.util.Timer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class Game{
	static final double sizeMultiplier = 1;
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
	int maxTime = 90;
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
		LoadMap.map1(this);
		clock = new Clock();
		clockTimer = new Timer();
		clockTimer.scheduleAtFixedRate(clock, 1000,1000);
		System.out.println(totalCoins);
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
}

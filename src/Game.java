import java.awt.Dimension;
import java.io.IOException;
import java.util.Timer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class Game{
	static double sizeMultiplier = 1;
	static String mapSelected = "";
	JFrame window = null;
	JPanel panel = null;
	List<Platform> platforms = new ArrayList<>();
	List<Coin> coins = new ArrayList<>();
	List<Killer> killers = new ArrayList<>();
	List<Teleporter> teleporters = new ArrayList<>();
	int totalCoins = 0;
	Player player;
	boolean playing = true;
	long startTime;
	int gravity = 1;
	Clock clock;
	Timer clockTimer;
	//test
	boolean won = false;
	int maxTime = 90;
	public Game(String mapName, JFrame window){
		this.window = window;
		panel = new GamePanel(this);
		panel.setPreferredSize(new Dimension(1200,675));
		player = new Player(25,6,1,1, this);
		Player.attach(player, panel);
		this.window.setContentPane(panel);
		this.window.pack();
		panel.requestFocus();
		loadMap(mapName);
		clock = new Clock();
		clockTimer = new Timer();
		clockTimer.scheduleAtFixedRate(clock, 1000,1000);
	}
	public void loadMap(String mapName){
		switch(mapName){
		case "map1":
			LoadMap.map1(this);
			break;
		case "map2":
			LoadMap.map2(this);
			break;
		case "map3":
			LoadMap.map3(this);
			break;
		default:
			LoadMap.map1(this);
			break;
		}
	}
	public boolean play(){
		while(playing){
			for(Platform platform: platforms){
				platform.update();
			}
			player.update();
			panel.repaint();
			sleep(15);
		}
		return won;
	}
	
	public static void resetFrame(JFrame window, JPanel panel){
		window.remove(panel);
		window.revalidate();
		window.repaint();
	}
	public static void main(String[] args) throws IOException{
		JFrame window = new JFrame("Platformer");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(75,0);
		window.setPreferredSize(new Dimension(1200,675));
		window.setVisible(true);
		while(true){
			Menu menu = new Menu(window);
			String mapSelected = menu.mapSelected();
			Game.resetFrame(window,menu.panel);
			while(true){
				Game game = new Game(mapSelected, window);
				boolean playerWon = game.play();
				Game.resetFrame(window,game.panel);
				if(playerWon){break;}
			}
		}
	}
	public void sleep(int ms) {
		try { Thread.sleep(ms); } catch(InterruptedException e) {}
		}
}

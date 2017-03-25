import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) throws IOException {
		Data data = new Data(3);
		JFrame window = new JFrame("Platformer");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(75, 0);
		window.setPreferredSize(new Dimension(1200, 675));
		window.setVisible(true);
		while (true) {
			data.loadData();
			Menu menu = new Menu(window, data);
			String mapSelected = menu.mapSelected();
			Game.resetFrame(window, menu.panel);
			while (true) {
				Game game = new Game(mapSelected, window);
				Score playerScore = game.play();
				if (playerScore != null) {
					data.updateMapScore(mapSelected, playerScore);
					Game.resetFrame(window, game.panel);
					if (playerScore.complete) {
						break;
					}
				} else {
					break;
				}
			}
		}
	}

}

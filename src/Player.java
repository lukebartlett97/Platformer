import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.JPanel;

public class Player extends GameObject {
	Set<Integer> keysPressed;
	int fallingCount = 0;
	int coins = 0;

	static void attach(Player player, JPanel panel) {
		class PlayerKeyboardListener implements KeyListener {
			Player player;

			PlayerKeyboardListener(Player newPlayer) {
				player = newPlayer;
			}

			// When a key is pressed, add the event to the solver's queue
			public void keyPressed(KeyEvent e) {
				player.keysPressed.add(e.getKeyCode());
			}

			// These are needed to implement the KeyListener interface,
			// but they don't need to do anything
			public void keyReleased(KeyEvent e) {
				player.keysPressed.remove(e.getKeyCode());
			}

			public void keyTyped(KeyEvent e) {
			}
		}

		// Add one of these listeners to the panel
		panel.addKeyListener(new PlayerKeyboardListener(player));
		// The panel needs to be focusable so that it can receive KeyEvents
		panel.setFocusable(true);
	}

	public Player(int xPos, int yPos, int width, int height, Game game) {
		super(xPos, yPos, width, height, game, Color.BLACK);
		this.xPos += 10;
		this.yPos += 10;
		this.width = this.width / 2;
		this.height = this.height / 2;
		keysPressed = new HashSet<Integer>();
	}

	public boolean falling() {
		if (game.gravity > 0) {
			return clearBelow();
		} else {
			return clearAbove();
		}
	}

	public void update() {
		if (falling()) {
			if (fallingCount++ == 3) {
				accelerate(0, 1 * game.gravity);
				fallingCount = 0;
			}
		}
		if (keysPressed.contains(KeyEvent.VK_UP) || keysPressed.contains(KeyEvent.VK_SPACE)) {
			if (!falling()) {
				yVel = -8 * game.gravity;
			}
		}
		int direction = 0;
		if (keysPressed.contains(KeyEvent.VK_LEFT)) {
			direction += 1;
		}
		if (keysPressed.contains(KeyEvent.VK_RIGHT)) {
			direction += 2;
		}
		if (keysPressed.contains(KeyEvent.VK_ESCAPE)) {
			game.exited = true;
			game.playing = false;
		}
		switch (direction) {
		case 1:
			if (xVel > -6) {
				xVel += -1;
			}
			break;
		case 2:
			if (xVel < 6) {
				xVel += 1;
			}
			break;
		default:
			if (xVel > 0) {
				xVel += -1;
			} else if (xVel < 0) {
				xVel += 1;
			}
		}
		move();
		if (isDead()) {
			game.playing = false;
		}
		if (hasWon()) {
			game.won = true;
			game.playing = false;
		}
	}

	public void teleport() {
		for (Teleporter teleporter : game.teleporters) {
			if ((teleporter.getXPos() < xPos + width) && (teleporter.getXPos() + teleporter.getWidth() > xPos)
					&& (teleporter.getYPos() < yPos + height)
					&& (teleporter.getYPos() + teleporter.getHeight() > yPos)) {
				moveTo(teleporter.targetX, teleporter.targetY);
			}
		}
	}

	public void moveBy(int x, int y) {
		xPos += x;
		yPos += y;
		collectCoins();
		teleport();
	}

	public void move() {
		if (yVel > 0) {
			for (int i = 0; i < yVel; i++) {
				if (clearBelow()) {
					yPos += 1;
					collectCoins();
					teleport();
				} else {
					yVel = 0;
				}
			}
		} else if (yVel < 0) {
			for (int i = 0; i < -yVel; i++) {
				if (clearAbove()) {
					yPos += -1;
					collectCoins();
					teleport();
				} else {
					yVel = 0;
				}
			}
		}
		if (xVel < 0) {
			for (int i = 0; i < -xVel; i++) {
				if (clearLeft()) {
					xPos += -1;
					collectCoins();
					teleport();
				} else {
					xVel = 0;
				}
			}
		} else if (xVel > 0) {
			for (int i = 0; i < xVel; i++) {
				if (clearRight()) {
					xPos += 1;
					collectCoins();
					teleport();
				} else {
					xVel = 0;
				}
			}
		}
	}

	public void collectCoins() {
		Iterator<Coin> iterator = game.coins.iterator();
		while (iterator.hasNext()) {
			GameObject coin = iterator.next();
			if ((coin.getXPos() < xPos + width) && (coin.getXPos() + coin.getWidth() > xPos)
					&& (coin.getYPos() < yPos + height) && (coin.getYPos() + coin.getHeight() > yPos)) {
				coins++;
				iterator.remove();
			}
		}
	}

	public void moveTo(int x, int y) {
		this.xPos = x * 40 + 10;
		this.yPos = y * 40 + 10;
	}

	public boolean isDead() {
		if ((!clearBelow() && !clearAbove()) || (!clearLeft() && !clearRight())) {
			return true;
		}
		int biggestY = 0;
		for (Platform platform : game.platforms) {
			if (platform.yPos > biggestY) {
				biggestY = platform.yPos;
			}
		}
		if (yPos > biggestY + 600) {
			return true;
		}
		if (game.maxTime - game.clock.seconds <= 0) {
			return true;
		}
		for (Killer killer : game.killers) {
			if (game.player.getXPos() < killer.getXPos() + killer.getWidth()
					&& game.player.getXPos() + game.player.getWidth() > killer.getXPos()
					&& game.player.getYPos() < killer.getYPos() + killer.getHeight()
					&& game.player.getYPos() + game.player.getHeight() > killer.getYPos()) {
				return true;
			}
		}
		return false;
	}

	public boolean hasWon() {
		if (game.totalCoins == coins) {
			game.clockTimer.cancel();
			return true;
		}
		return false;
	}
}

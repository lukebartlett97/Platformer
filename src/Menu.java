import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu {

	private JButton map1 = new JButton("Map 1");
	private JButton map2 = new JButton("Map 2");
	private JButton map3 = new JButton("Map 3");
	public String selectedMap = "";
	public JFrame window;
	public JPanel panel;

	public Menu(JFrame window, Data data) throws IOException {
		// create a new panel with GridBagLayout manager
		JPanel newPanel = new JPanel(new GridBagLayout());
		this.window = window;
		this.panel = newPanel;
		panel.setPreferredSize(new Dimension(1200, 675));
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		// add components to the panel
		constraints.gridx = 0;
		constraints.gridy = 0;
		if (data.getMapScore(1) == null) {
			map1.setText("Map 1");
		} else if (data.getMapScore(1).complete) {
			map1.setForeground(new Color(0, 150, 0));
			map1.setText("Map 1 (Time Left: " + data.getMapScore(1).score + ")");
		} else {
			map1.setText("Map 1 (Coins: " + data.getMapScore(1).score + ")");
		}
		map1.setVerticalTextPosition(SwingConstants.BOTTOM);
		map1.setHorizontalTextPosition(SwingConstants.CENTER);
		try {
			BufferedImage image = ImageIO.read(this.getClass().getResource("/resources/map1.png"));
			map1.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		map1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// this makes sure the button you are pressing is the button
				// variable
				if (e.getSource() == map1) {
					selectedMap = "map1";
				}
			}
		});
		newPanel.add(map1, constraints);
		constraints.gridx = 1;
		if (data.getMapScore(2) == null) {
			map2.setText("Map 2");
		} else if (data.getMapScore(2).complete) {
			map2.setForeground(new Color(0, 150, 0));
			map2.setText("Map 2 (Time Left: " + data.getMapScore(2).score + ")");
		} else {
			map2.setText("Map 2 (Coins: " + data.getMapScore(2).score + ")");
		}

		map2.setVerticalTextPosition(SwingConstants.BOTTOM);
		map2.setHorizontalTextPosition(SwingConstants.CENTER);
		try {
			BufferedImage image = ImageIO.read(this.getClass().getResource("/resources/map2.png"));
			map2.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		map2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// this makes sure the button you are pressing is the button
				// variable
				if (e.getSource() == map2) {
					selectedMap = "map2";
				}
			}
		});
		newPanel.add(map2, constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		if (data.getMapScore(3) == null) {
			map3.setText("Map 3");
		} else if (data.getMapScore(3).complete) {
			map3.setForeground(new Color(0, 150, 0));
			map3.setText("Map 3 (Time Left: " + data.getMapScore(3).score + ")");
		} else {
			map3.setText("Map 3 (Coins: " + data.getMapScore(3).score + ")");
		}

		map3.setVerticalTextPosition(SwingConstants.BOTTOM);
		map3.setHorizontalTextPosition(SwingConstants.CENTER);
		try {
			BufferedImage image = ImageIO.read(this.getClass().getResource("/resources/map3.png"));
			map3.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		map3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// this makes sure the button you are pressing is the button
				// variable
				if (e.getSource() == map3) {
					selectedMap = "map3";
				}
			}
		});
		newPanel.add(map3, constraints);

		// add the panel to this frame
		window.add(newPanel);

		window.pack();
	}

	public String mapSelected() {
		while (selectedMap.equals("")) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return selectedMap;
	}
}
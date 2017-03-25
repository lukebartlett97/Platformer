import java.io.*;

public class Data {
	private Score[] scores;

	public Data(int maps) {
		this.scores = new Score[maps];
		try {
			loadData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateMapScore(int map, Score score) {
		map -= 1;
		if (scores[map] != null) {
			if (scores[map].complete) {
				if (!score.complete || score.score <= scores[map].score) {
					return;
				}
			} else {
				if (!score.complete && score.score <= scores[map].score) {
					return;
				}
			}
		}
		scores[map] = score;
		try {
			saveData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateMapScore(String map, Score score) {
		if (map.equals("map1")) {
			updateMapScore(1, score);
		}
		if (map.equals("map2")) {
			updateMapScore(2, score);
		}
		if (map.equals("map3")) {
			updateMapScore(3, score);
		}
	}

	public Score getMapScore(int map) {
		return scores[map - 1];
	}

	public void loadData() throws IOException {
		// TODO: Load data from file;
		if (getClass().getResource("/resources/data.txt") == null) {
			return;
		}
		InputStreamReader stream = new InputStreamReader(getClass().getResourceAsStream("/resources/data.txt"));
		BufferedReader in = new BufferedReader(stream);
		String line;
		int counter = 0;
		while ((line = in.readLine()) != null) {
			if (!line.equals("")) {
				String[] lineData = line.split("~");
				scores[counter] = new Score(Boolean.parseBoolean(lineData[0]), Integer.parseInt(lineData[1]));
			}
			counter++;
		}
		in.close();
		stream.close();
	}

	public void saveData() throws IOException {
		// TODO: Save data to file;
		OutputStreamWriter stream;
		try {
			stream = new OutputStreamWriter(new FileOutputStream(getClass().getResource("/resources/data.txt").getPath()));
			BufferedWriter out = new BufferedWriter(stream);
			for (Score score : scores) {
				if (score != null) {
					out.write(score.complete + "~" + score.score);
				}
				out.write("\n");
			}
			out.flush();
			out.close();
			stream.close();
		} catch (FileNotFoundException e) {
			stream = null;
		}
	}
}

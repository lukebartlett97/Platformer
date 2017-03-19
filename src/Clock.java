import java.util.TimerTask;

public class Clock extends TimerTask{
	int seconds = 0;
	@Override
	public void run() {
		seconds++;
		
	}

}

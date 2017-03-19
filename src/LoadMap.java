
public class LoadMap {
	public static void map1(Game game){
		//game.platforms.add(new Platform(325,140,50,50,game));
		//game.platforms.add(new ElevatorPlatform(450,100,50,10,game, false, 100, 300, 2));
		//game.coins.add(new Coin(345,125,10,10,game));
		
		//Top left coin and platform
		game.coins.add(new Coin(0,0,1,1,game));
		
		game.platforms.add(new Platform(0,1,2,1,game));
		
		//Platform and X-Lift leading to coin
		game.platforms.add(new ElevatorPlatform(3,3,2,1,game, true, 3, 10, 2));
		game.platforms.add(new Platform(11,6,4,1,game));
		
		//Stairs
		game.platforms.add(new Platform(18,7,1,4,game));
		game.platforms.add(new Platform(19,8,1,3,game));
		game.platforms.add(new Platform(20,9,1,2,game));
		game.platforms.add(new Platform(21,10,1,1,game));
		
		//U-Shape
		game.platforms.add(new Platform(2,8,1,2,game));
		game.platforms.add(new Platform(2,10,5,1,game));
		game.platforms.add(new Platform(6,8,1,2,game));
		game.coins.add(new Coin(4,9,1,1,game));
		
		
		//Y-Lift by U-Shape
		game.platforms.add(new ElevatorPlatform(8,9,3,1,game, false, 9, 16, 2));
		
		//Platform and coin under Y-Lift
		game.coins.add(new Coin(9,19,1,1,game));
		
		game.platforms.add(new Platform(8,20,3,1,game));
		
		//Line under U-Shape
		game.platforms.add(new Platform(4,11,1,1,game));
		game.platforms.add(new Platform(4,13,1,7,game));
		
		//2 mini game.platforms on left with coin
		game.platforms.add(new Platform(0,10,2,1,game));
		game.platforms.add(new Platform(0,11,1,6,game));
		game.coins.add(new Coin(1,16,1,1,game));
		
		game.platforms.add(new Platform(0,17,2,1,game));
		game.platforms.add(new Platform(0,20,2,1,game));
		
		//X-Lift at bottom left
		game.platforms.add(new ElevatorPlatform(0,24,3,1,game, true, 0, 12, 2));
		
		//Staircase leading up from bottom left with under-stairs coin
		game.platforms.add(new Platform(14,22,2,1,game));
		game.platforms.add(new Platform(16,19,2,1,game));
		game.platforms.add(new Platform(18,16,2,1,game));
		game.coins.add(new Coin(19,11,1,1,game));
		
		
		//Y-Lift left of start and adjacent X-Lift
		game.platforms.add(new ElevatorPlatform(22,15,2,1,game, false, 15, 24, 2));
		game.platforms.add(new ElevatorPlatform(27,20,3,1,game, true, 27, 32, 2));
		
		//Path and crusher
		game.platforms.add(new Platform(22,26,4,1,game));
		game.platforms.add(new Platform(25,27,2,1,game));
		game.platforms.add(new Platform(26,28,2,1,game));
		game.platforms.add(new Platform(27,29,6,1,game));
		game.platforms.add(new Platform(33,25,1,5,game));
		game.platforms.add(new ElevatorPlatform(31,28,2,1,game, false, 25, 28, -2));
		
		//Platform right of start
		game.coins.add(new Coin(29,10,1,1,game));
		
		game.platforms.add(new Platform(27,11,5,1,game));
		
		//Y-Lift right of start
		game.platforms.add(new ElevatorPlatform(33,12,2,1,game, false, 3, 18, -4));
		
		//Top Left of Maze: 1400, 440
		game.platforms.add(new Platform(35,11,1,8,game));
		game.platforms.add(new Platform(36,14,3,1,game));
		game.platforms.add(new Platform(36,18,7,1,game));
		game.platforms.add(new Platform(37,16,4,1,game));
		game.platforms.add(new Platform(40,11,1,4,game));
		game.platforms.add(new Platform(41,14,1,1,game));
		game.platforms.add(new Platform(40,15,5,1,game));
		game.platforms.add(new Platform(42,17,1,1,game));
		game.coins.add(new Coin(42,16,1,1,game));
		
		game.platforms.add(new Platform(44,16,1,3,game));
		
		//Islands Around maze
		game.platforms.add(new Platform(35,22,4,1,game));
		game.platforms.add(new Platform(42,21,3,1,game));
		game.platforms.add(new Platform(47,19,2,1,game));
		game.platforms.add(new Platform(46,16,2,1,game));
		game.platforms.add(new Platform(52,18,1,1,game));
		game.platforms.add(new Platform(56,18,1,1,game));
		game.platforms.add(new Platform(59,16,1,1,game));
		game.coins.add(new Coin(60,13,1,1,game));
		
		
		//Platform above start
		game.coins.add(new Coin(25,0,1,1,game));
		
		game.platforms.add(new Platform(24,1,5,1,game));
		game.platforms.add(new Platform(28,2,4,1,game));
		
		//Platform left of top Y-Lift
		game.platforms.add(new Platform(38,3,4,1,game));
		
		//Moving Stairs
		game.platforms.add(new ElevatorPlatform(46,4,1,1,game, false, 4, 10, 2));
		game.platforms.add(new ElevatorPlatform(47,3,1,2,game, false, 3, 9, 2));
		game.platforms.add(new ElevatorPlatform(48,2,1,2,game, false, 2, 8, 2));
		game.platforms.add(new ElevatorPlatform(49,1,1,2,game, false, 1, 7, 2));
		game.platforms.add(new ElevatorPlatform(50,0,1,2,game, false, 0, 6, 2));
		
		//Top right coin platform
		game.platforms.add(new Platform(53,3,3,1,game));
		game.platforms.add(new Platform(55,1,1,2,game));
		game.coins.add(new Coin(54,2,1,1,game));
		
		
		
		//Starting Platform
		game.platforms.add(new Platform(24,8,3,1,game));
	}
}


public class LoadMap {
	public static void map1(Game game){
		//game.platforms.add(new Platform(325,140,50,50,game));
		//game.platforms.add(new ElevatorPlatform(450,100,50,10,game, false, 100, 300, 2));
		//game.coins.add(new Coin(345,125,10,10,game));
		
		//Top left coin and platform
		game.player.moveTo(25,6);
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
	public static void map2(Game game){
		game.player.moveTo(2,3);
		//game.teleporters.add(new Teleporter(3,3,1,1,game,3,1));
		game.platforms.add(new Platform(0,-39,90,40,game));
		game.platforms.add(new Platform(0,5,90,40,game));
		game.platforms.add(new Platform(-39,-39,40,85,game));
		game.killers.add(new Killer(6,4,1,1,game));
		
		game.platforms.add(new ElevatorPlatform(8,1,2,1,game, false, 1, 4, 2));
		game.coins.add(new Coin(10,4,1,1,game));
		
		game.killers.add(new Killer(12,4,1,1,game));
		game.killers.add(new Killer(13,4,1,1,game));
		game.killers.add(new Killer(14,4,1,1,game));
		game.killers.add(new Killer(15,4,1,1,game));
		game.killers.add(new Killer(16,4,1,1,game));
		game.killers.add(new Killer(17,4,1,1,game));
		game.killers.add(new Killer(18,4,1,1,game));
		game.platforms.add(new ElevatorPlatform(12,3,1,1,game, true, 12, 18, 2));
		game.coins.add(new Coin(15,2,1,1,game));

		game.platforms.add(new Platform(22,4,1,1,game));
		game.killers.add(new Killer(23,4,1,1,game));
		game.coins.add(new Coin(24,4,1,1,game));
		game.killers.add(new Killer(25,4,1,1,game));
		game.platforms.add(new Platform(26,4,1,1,game));
		
		game.killers.add(new Killer(29,4,1,1,game));
		game.killers.add(new Killer(30,3,1,1,game));
		game.killers.add(new Killer(31,2,1,1,game));
		game.killers.add(new Killer(33,1,1,1,game));
		game.killers.add(new Killer(33,2,1,1,game));
		game.killers.add(new Killer(33,3,1,1,game));
		game.coins.add(new Coin(31,4,1,1,game));

		game.platforms.add(new Platform(36,1,4,2,game));
		game.platforms.add(new Platform(42,3,4,2,game));
		game.platforms.add(new ElevatorPlatform(36,3,1,2,game, true, 36, 41, 2));
		game.coins.add(new Coin(43,2,1,1,game));

		game.platforms.add(new ElevatorPlatform(48,1,2,1,game, false, 1, 4, 4));
		game.platforms.add(new ElevatorPlatform(50,4,2,1,game, false, 1, 4, 4));
		game.platforms.add(new ElevatorPlatform(52,1,2,1,game, false, 1, 4, 4));
		game.platforms.add(new ElevatorPlatform(54,4,2,1,game, false, 1, 4, 4));
		game.platforms.add(new ElevatorPlatform(56,1,2,1,game, false, 1, 4, 4));
		game.coins.add(new Coin(59,3,1,1,game));

		game.platforms.add(new Platform(61,1,1,3,game));
		game.platforms.add(new Platform(62,3,1,1,game));
		game.platforms.add(new Platform(64,3,3,2,game));
		game.platforms.add(new Platform(68,1,1,2,game));
		game.platforms.add(new ElevatorPlatform(62,1,1,2,game, true, 62, 67, 2));
		game.coins.add(new Coin(68,4,1,1,game));

		game.platforms.add(new Platform(71,2,1,3,game));
		game.killers.add(new Killer(72,4,1,1,game));
		game.platforms.add(new Platform(73,2,1,3,game));
		game.coins.add(new Coin(74,4,1,1,game));
		game.platforms.add(new Platform(75,2,1,3,game));
		game.killers.add(new Killer(76,4,1,1,game));
		game.platforms.add(new Platform(77,2,1,3,game));
		

		game.killers.add(new Killer(80,1,1,1,game));
		game.killers.add(new Killer(80,2,1,1,game));
		game.killers.add(new Killer(80,3,1,1,game));
		game.coins.add(new Coin(82,1,1,1,game));
		game.killers.add(new Killer(82,3,1,1,game));
		game.killers.add(new Killer(82,4,1,1,game));
		game.killers.add(new Killer(84,1,1,1,game));
		game.killers.add(new Killer(84,2,1,1,game));
		game.killers.add(new Killer(84,3,1,1,game));

		game.killers.add(new Killer(90,4,1,1,game));
		game.killers.add(new Killer(91,3,1,1,game));
		game.killers.add(new Killer(92,2,1,1,game));
		game.killers.add(new Killer(93,3,1,1,game));
		game.killers.add(new Killer(93,4,1,1,game));
		game.killers.add(new Killer(95,0,1,1,game));
		game.killers.add(new Killer(96,1,1,1,game));
		game.killers.add(new Killer(97,2,1,1,game));
		game.killers.add(new Killer(97,3,1,1,game));
		game.killers.add(new Killer(97,4,1,1,game));
		game.coins.add(new Coin(95,4,1,1,game));
		game.platforms.add(new Platform(94,5,3,1,game));
	}
	public static void map3(Game game){
		game.player.moveTo(15,14);
		
		//Edges
		game.platforms.add(new Platform(-40,-40,68,41,game));
		game.platforms.add(new Platform(-40,28,68,41,game));
		game.platforms.add(new Platform(-40,1,41,27,game));
		game.platforms.add(new Platform(27,-40,41,108,game));
		
		//Coins
		game.coins.add(new Coin(4,3,1,1,game));
		game.coins.add(new Coin(17,3,1,1,game));
		game.coins.add(new Coin(25,4,1,1,game));
		game.coins.add(new Coin(17,7,1,1,game));
		game.coins.add(new Coin(2,9,1,1,game));
		game.coins.add(new Coin(13,18,1,1,game));
		game.coins.add(new Coin(21,20,1,1,game));
		game.coins.add(new Coin(4,22,1,1,game));
		game.coins.add(new Coin(13,23,1,1,game));
		game.coins.add(new Coin(14,26,1,1,game));
		
		//Teleporters
		game.teleporters.add(new Teleporter(25,1,1,1,game,15,13));
		game.teleporters.add(new Teleporter(2,2,1,1,game,15,13));
		game.teleporters.add(new Teleporter(14,2,1,1,game,21,14));
		game.teleporters.add(new Teleporter(2,6,1,1,game,10,6));
		game.teleporters.add(new Teleporter(13,13,1,1,game,14,6));
		game.teleporters.add(new Teleporter(17,13,1,1,game,13,10));
		game.teleporters.add(new Teleporter(11,22,1,1,game,15,13));
		game.teleporters.add(new Teleporter(2,26,1,1,game,15,13));
		
		//Killers
		game.killers.add(new Killer(19,3,1,1,game));
		game.killers.add(new Killer(24,3,1,1,game));
		game.killers.add(new Killer(26,3,1,1,game));
		game.killers.add(new Killer(18,5,1,1,game));
		game.killers.add(new Killer(16,6,1,1,game));
		game.killers.add(new Killer(18,6,1,1,game));
		game.killers.add(new Killer(25,6,1,1,game));
		game.killers.add(new Killer(16,7,1,1,game));
		game.killers.add(new Killer(18,7,1,1,game));
		game.killers.add(new Killer(16,8,1,1,game));
		game.killers.add(new Killer(18,8,1,1,game));
		game.killers.add(new Killer(24,8,1,1,game));
		game.killers.add(new Killer(26,8,1,1,game));
		game.killers.add(new Killer(16,9,1,1,game));
		game.killers.add(new Killer(18,9,1,1,game));
		game.killers.add(new Killer(16,10,1,1,game));
		game.killers.add(new Killer(18,10,1,1,game));
		game.killers.add(new Killer(16,11,1,1,game));
		game.killers.add(new Killer(25,11,1,1,game));
		game.killers.add(new Killer(24,12,1,1,game));
		game.killers.add(new Killer(26,13,1,1,game));
		game.killers.add(new Killer(25,15,1,1,game));
		game.killers.add(new Killer(2,16,1,1,game));
		game.killers.add(new Killer(4,19,1,1,game));
		game.killers.add(new Killer(11,19,1,1,game));
		game.killers.add(new Killer(15,19,1,1,game));
		game.killers.add(new Killer(15,23,1,1,game));
		game.killers.add(new Killer(16,23,1,1,game));
		game.killers.add(new Killer(17,23,1,1,game));
		game.killers.add(new Killer(18,23,1,1,game));
		
		//Platforms
		game.platforms.add(new Platform(1,4,5,1,game));
		game.platforms.add(new Platform(5,5,2,1,game));
		game.platforms.add(new Platform(6,6,2,1,game));
		game.platforms.add(new Platform(7,7,2,1,game));
		game.platforms.add(new Platform(8,8,8,1,game));
		game.platforms.add(new Platform(12,1,1,7,game));
		game.platforms.add(new Platform(13,4,7,1,game));
		game.platforms.add(new Platform(19,5,1,4,game));
		game.platforms.add(new Platform(20,8,1,1,game));
		game.platforms.add(new Platform(23,1,1,15,game));
		game.platforms.add(new Platform(22,5,1,1,game));
		game.platforms.add(new Platform(22,11,1,1,game));
		game.platforms.add(new Platform(15,9,1,3,game));
		game.platforms.add(new Platform(11,12,12,1,game));
		game.platforms.add(new Platform(1,8,3,1,game));
		game.platforms.add(new Platform(3,9,2,1,game));
		game.platforms.add(new Platform(4,10,2,1,game));
		game.platforms.add(new Platform(5,11,2,1,game));
		game.platforms.add(new Platform(6,12,3,1,game));
		game.platforms.add(new Platform(8,13,1,3,game));
		game.platforms.add(new Platform(1,15,5,1,game));
		game.platforms.add(new Platform(1,24,5,1,game));
		game.platforms.add(new Platform(11,13,1,4,game));
		game.platforms.add(new Platform(12,16,8,1,game));
		game.platforms.add(new Platform(19,13,1,14,game));
		game.platforms.add(new Platform(20,18,7,1,game));
		game.platforms.add(new Platform(3,20,14,1,game));
		game.platforms.add(new Platform(9,21,1,4,game));
		game.platforms.add(new Platform(10,24,9,1,game));
		game.platforms.add(new Platform(11,25,1,2,game));
		game.platforms.add(new Platform(15,25,1,2,game));
		game.platforms.add(new Platform(9,26,1,2,game));
		game.platforms.add(new Platform(13,26,1,2,game));
		game.platforms.add(new Platform(17,26,1,2,game));
		
		//Elevators
		game.platforms.add(new ElevatorPlatform(0,12,1,1,game, true, 0, 1, 1));
		game.platforms.add(new ElevatorPlatform(6,15,2,1,game, false, 15, 19, 2));
		game.platforms.add(new ElevatorPlatform(24,2,3,1,game, false, 2, 18, 2));
		game.platforms.add(new ElevatorPlatform(15,23,4,1,game, false, 23, 24, 1));
		game.platforms.add(new ElevatorPlatform(22,21,1,1,game, true, 22, 23, 2));
		game.platforms.add(new ElevatorPlatform(26,24,1,1,game, false, 24, 25, 2));
	}
}

package MapGen;

import Felder.Feld;

public class TestMain {
	
	public static MapGen mapGen;

	/**
	 * @param args
	 */
	public void generate() 
	{
		mapGen = new MapGen();
		
		Feld[][] map = mapGen.generiereMap(30, 30, 25, 75, 0, 0);
		
//		for(int i = 0; i < map.length; i++)
//		{
//			for(int j = 0; j < map[0].length; j++)
//			{
//				System.out.println(map[i][j].getClass().getName() + " PosX " + i + " PosY " + j);
//			}
//		}
	}

}

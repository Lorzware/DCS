package MapGen;

import Felder.Feld;

public class MapGen 
{
	public MapGen(Feld[][] map, int wasserSlider, int gwSlider, int wuestenSlider, int tundraSlider)
	{
		int wasserMenge = berechneMenge(wasserSlider, gwSlider, wuestenSlider, tundraSlider, map);
		int wuestenMenge = berechneMenge(wuestenSlider,wasserSlider, gwSlider, tundraSlider, map);
		int tundraMenge = berechneMenge(tundraSlider, wasserSlider, gwSlider, wuestenSlider, map);
		
		erzeugeWasser(wasserMenge, map);
		
		erzeugeGruenflaechen(map);
	}
	
	
	private void erzeugeWasser(int wasserMenge, Feld[][] map)
	{
		int wasserBen = wasserMenge;
		while(wasserBen > 0)
		{
			int startx = 0;
			int starty = 0;
			boolean besetzt = true;
			while(besetzt)
			{
				startx = (int)(Math.random()*map.length);
				starty = (int)(Math.random()*map[0].length);
				
				besetzt = !(map[startx][starty] == null);
			}
			for(int j = 0; j < 3; j++)
			{
				wasserBen = setzeWasser(map, startx, starty, wasserBen);
			}
			
			wasserBen--;
		}
		
	}
	
	private int setzeWasser(Feld[][] map, int startx, int starty, int benoetigt)
	{
		int i = 10;
		
		while( (i > 0) && (benoetigt > 0) )
		{
			if(!!(map[startx][starty] == null))
			{
				map[startx][starty] = new WasserCreator().createFeld();
				benoetigt --;
				i--;
			}	
			
			boolean inFeld = false;
			while(inFeld == false)
			{
				int richtung = (int)(Math.random()*4);
			
				if(richtung == 0)
				{
					startx++;
				}
				if(richtung == 1)
				{
					startx--;
				}
				if(richtung == 2)
				{
					starty++;
				}
				if(richtung == 3)
				{
					starty--;
				}
				
				if(((startx >= 0 ) &&(starty < map[0].length)) && ((starty >= 0 ) &&(startx < map.length)))
				{
					inFeld = true;
				}
			}
		}
		
		return benoetigt;
	}
	
	
	private void erzeugeGruenflaechen(Feld[][] map)
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[i].length; j++)
			{
				if(map[i][j] == null)
				{
					map[i][j] = new GruenflaechenCreator().createFeld();
				}
			}
		}
	}
	
	
	private int berechneMenge(int a, int b, int c, int d, Feld[][] map)
	{
		double anteil = a/((a+b+c+d)/100);
		
		// Fehler wegen Cast zu int! Koennte passieren dass es weniger Felder als im Array gibt
		int menge = (int) ((map.length * map[0].length) * (anteil/100));
		
		return menge;
	}
}

package MapGen;

import Felder.Feld;

public class MapGen 
{
	
	private int wasserMenge;
	private int wuestenMenge;
	private int tundraMenge;
	private Feld[][] map;
	
	
	
	public Feld[][] generiereMap(int mapGroesseX, int mapGroesseY, int wasserSlider, int gwSlider, int wuestenSlider, int tundraSlider, int rohstoffSlider)
	{
		map = new Feld[mapGroesseX][mapGroesseY];
		
		berechneMengen(wasserSlider, gwSlider, wuestenSlider, tundraSlider);
		
		erzeugeWasser();
		
		int polPosition = (int) (Math.random()*4);
		erzeugeTundra(polPosition);
		erzeugeWueste(polPosition);
		
		erzeugeGruenflaechen();
		
		erzeugeRohstoffe(rohstoffSlider);
		return map;
	}

	
	public Feld[][] verteileRohstoffeNeu(Feld[][] map, int rohstoffSlider)
	{
		this.map = map;
		
		entferneRohstoffe();
		erzeugeRohstoffe(rohstoffSlider);
		
		return map;
	}
	

	public Feld[][] generiereStartMap(int mapGroesseX, int mapGroesseY)
	{
		map = new Feld[mapGroesseX][mapGroesseY];
		
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[i].length; j++)
			{
				map[i][j] = new WasserCreator().createFeld();
			}
		}
		return map;
	}
	

	private void entferneRohstoffe() 
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[i].length; j++)
			{
				map[i][j].setBesetzt(false);
			}
		}
	}
	
	
	private void erzeugeRohstoffe(int rohstoffSlider) 
	{
		int menge = (int) ((map.length * map[0].length) - wasserMenge * rohstoffSlider / 100);
		
		for(int i = 0; i < menge; i++)
		{
			boolean plazierbar = false;
			int[] rndPosi = erzeugeRandomMapPosition();
			
			while(!plazierbar)
			{
				if(!(map[rndPosi[0]][rndPosi[1]] == null || map[rndPosi[0]][rndPosi[1]] instanceof Felder.Wasser || map[rndPosi[0]][rndPosi[1]].isBesetzt()))
					plazierbar = true;
				else
					rndPosi = erzeugeRandomMapPosition();
			}
			map[rndPosi[0]][rndPosi[1]].setRessourcen(true);
		}
	}
	
	
	private void erzeugeWueste(int polPosition) 
	{
	
	}

	
	private void erzeugeTundra(int polPosition) 
	{
		
	}

	
	private void erzeugeWasser()
	{
		int anzahlFlecken = bestimmeAnzahlSpots(wasserMenge);
		System.out.println("Fleckenanzahl: " + anzahlFlecken);
		int[] fleckengroesse = berechneFleckengroesse(anzahlFlecken);
		
		for(int i = 0;i < fleckengroesse.length ; i++)
		{
			System.out.println("Fleck " + i + " groesse " + fleckengroesse[i]);
			setzeWasser(fleckengroesse[i]);
		}
	}
	
	
	private int[] berechneFleckengroesse(int anzahlFlecken)
	{
		int[] fleckengroesse = new int[anzahlFlecken];
		
		if ( fleckengroesse.length == 1)
		{
			fleckengroesse[0] = wasserMenge;
		}
		
		if ( fleckengroesse.length == 2)
		{
			fleckengroesse[0] = (int) (wasserMenge * Math.random());
			fleckengroesse[1] = wasserMenge - fleckengroesse[0];
		}
		
		if ( fleckengroesse.length == 3)
		{
			fleckengroesse[0] = (int) (wasserMenge * Math.random());
			fleckengroesse[1] = (int) ((wasserMenge - fleckengroesse[0]) * Math.random());
			fleckengroesse[2] = wasserMenge - fleckengroesse[1] - fleckengroesse[0];
		}
		return fleckengroesse;
	}

	
	private int bestimmeAnzahlSpots(int menge) 
	{
		if (menge > 50)
		{
			return (int) (1+Math.random()*2);
		}
		else if (menge < 20)
		{
			return 1;
		}
		else
		{
			return (int) (1+Math.random()*1);
		}
	}

	
	private void setzeWasser(int anzahl)
	{
		int zuVerteilen = anzahl;
		
		int[] pos = sucheWasserStartPunkt();
		System.out.println("FleckstartPosX: " + pos[0] + " PosY: " + pos[1]);
		while(zuVerteilen > 0)
		{
			if(map[pos[0]][pos[1]] == null)
			{
				map[pos[0]][pos[1]] = new WasserCreator().createFeld();
				zuVerteilen--;
			}
			
			pos = berechneneuePos(pos);
		}
	}
	
	
	private int[] berechneneuePos(int[] pos) 
	{
		int[] neuePos = new int[2];
		neuePos[0] = pos[0];
		neuePos[1] = pos[1];
		
		boolean inFeld = false;
		while(!inFeld)
		{
			
			int richtung = (int)(Math.random()*4);
			
			if (richtung == 0)
			{
				neuePos[0] = pos[0]+1;
			}
			if (richtung == 1)
			{
				neuePos[0] = pos[0]-1;
			}
			if (richtung == 2)
			{
				neuePos[1] = pos[1]+1;
			}
			if(richtung == 3)
			{
				neuePos[1] = pos[1]-1;
			}
			
			inFeld = checkInMap(neuePos);
		}
		return neuePos;
	}

	
	private boolean checkInMap(int[] pos)
	{
		if(pos[0]<0 || pos[0]>=map.length || pos[1]<0 || pos[1]>=map[0].length)
			return false;
		return true;
	}
	
	
	private int[] sucheWasserStartPunkt() 
	{
		int[] start = null;
		
		boolean besetzt = true;
		
		while(besetzt)
		{
			start = erzeugeRandomMapPosition();
			start[0] = (int)(Math.random()*map.length);
			start[1] = (int)(Math.random()*map[0].length);
			if ((map[start[0]][start[1]] == null))
			{
				besetzt = false;
			}
		}
		return start;
	}
	
	
	private int[] erzeugeRandomMapPosition()
	{
		int[] rndPosi = new int[2];
		rndPosi[0] = (int)(Math.random()*map.length);
		rndPosi[1] = (int)(Math.random()*map[0].length);
		
		return rndPosi;
	}


	private void erzeugeGruenflaechen()
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
	
	
	private void berechneMengen(int wasserSlider, int gwSlider,
			int wuestenSlider, int tundraSlider) 
	{
		
		wasserMenge = berechneFeldMenge(wasserSlider, gwSlider, wuestenSlider, tundraSlider);
		wuestenMenge = berechneFeldMenge(wuestenSlider,wasserSlider, gwSlider, tundraSlider);
		tundraMenge = berechneFeldMenge(tundraSlider, wasserSlider, gwSlider, wuestenSlider);
	}
	
	
	private int berechneFeldMenge(int a, int b, int c, int d)
	{
		double anteil = a/((a+b+c+d)/100);
		
		// Fehler wegen Cast zu int! Koennte passieren dass es weniger Felder als im Array gibt
		int menge = (int) ((map.length * map[0].length) * (anteil/100));
		
		return menge;
	}
}

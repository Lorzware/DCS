package MapGen;

import Felder.Feld;

public class MapGen 
{
	
	private int wasserMenge;
	private int wuestenMenge;
	private int tundraMenge;
	private Feld[][] map;
	
	
	public Feld[][] generiereMap(int mapGroesseX, int mapGroesseY, int wasserSlider, int gwSlider, int wuestenSlider, int tundraSlider)
	{
		map = new Feld[mapGroesseX][mapGroesseY];
		
		berechneMengen(wasserSlider, gwSlider, wuestenSlider, tundraSlider);
		
		erzeugeWasser();
		erzeugeTundra();
		erzeugeWueste();
		
		erzeugeGruenflaechen();
		return map;
	}

	
	private void erzeugeWueste() 
	{
		// TODO Auto-generated method stub
		
	}

	private void erzeugeTundra() 
	{
		// TODO Auto-generated method stub
		
	}

	
	private void erzeugeWasser()
	{
		int anzahlFlecken = bestimmeAnzahlSpots(wasserMenge);

		int[] fleckengroesse = berechneFleckengroesse(anzahlFlecken);
		
		for(int i = 0;i < fleckengroesse.length ; i++)
		{
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
			return (int) (Math.random()*3);
		}
		else if (menge < 20)
		{
			return 1;
		}
		else
		{
			return (int) (Math.random()*2);
		}
	}

	
	private void setzeWasser(int anzahl)
	{
		int zuVerteilen = anzahl;
		
		int[] pos = sucheWasserStartPunkt();
		
		while(zuVerteilen > 0)
		{
			if(map[pos[0]][pos[1]] == null)
			{
				map[pos[0]][pos[1]] = new WasserCreator().createFeld();
				zuVerteilen--;
			}
			
			berechneneuePos(pos);
		}
	}
	
	
	private void berechneneuePos(int[] pos) 
	{
		int[] neuePos = pos;
		
		boolean inFeld = false;
		while(inFeld)
		{
			int richtung = (int)(Math.random()*4);
		
			switch(richtung)
			{
				case 0:	neuePos[0]++;
						break;
				case 1:	neuePos[0]--;
						break;
				case 2:	neuePos[1]++;
						break;
				case 3:	neuePos[1]--;	
						break;
			}
			
			inFeld = checkInMap(neuePos);
			if(inFeld)
			{
				pos = neuePos;
			}
		}
	}

	private boolean checkInMap(int[] pos)
	{
		if(pos[0]<0 || pos[0]>map.length || pos[1]<0 || pos[1]>map[0].length)
			return false;
		return true;
	}
	
	
	private int[] sucheWasserStartPunkt() 
	{
		int[] start = new int[2]; // x, y
		
		boolean besetzt = true;
		
		while(besetzt)
		{
			start[0] = (int)(Math.random()*map.length);
			start[1] = (int)(Math.random()*map[0].length);
				
			if ((map[start[0]][start[1]] == null))
			{
				besetzt = false;
			}
		}
		return start;
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

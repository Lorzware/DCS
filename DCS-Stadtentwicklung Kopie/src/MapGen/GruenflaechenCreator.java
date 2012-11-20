package MapGen;

import Felder.*;

public class GruenflaechenCreator extends FeldCreator
{

	@Override
	protected Feld factoryMethod() 
	{
		GruenFlaeche gruenflaeche = new GruenFlaeche();
		
		return gruenflaeche;
	}

}

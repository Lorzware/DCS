package MapGen;

import Felder.*;


public abstract class FeldCreator 
{
	public Feld createFeld()
	{
		Feld feld = factoryMethod();
		
		return feld;
	}
	
	protected abstract Feld factoryMethod();
}

package MapGen;

import Felder.*;;

public class WasserCreator extends FeldCreator
{

	@Override
	protected Feld factoryMethod() 
	{
		Wasser wasser = new Wasser();
		
		return wasser;
	}

}

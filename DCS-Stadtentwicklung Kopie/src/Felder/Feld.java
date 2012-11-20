package Felder;

public abstract class Feld 
{
	
	private boolean besetzt;
	private boolean ressourcen;
	
	
	
	public boolean isBesetzt() 
	{
		return besetzt;
	}
	
	public void setBesetzt(boolean besetzt)
	{
		this.besetzt = besetzt;
	}
	
	public boolean isRessourcen() 
	{
		return ressourcen;
	}
	
	public void setRessourcen(boolean ressourcen) 
	{
		this.ressourcen = ressourcen;
	}

}

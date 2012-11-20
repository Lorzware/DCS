package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Die Klasse BuildingPanel ist eine Komponente des MainPanels
 * @author lorenz
 *
 */
public class BuildingPanel extends JPanel
{
	//Alle grafische Komponenten des BuildingPanels;
	private JPanel pRathaus, pGewerbegebaeude, pBauernhof, pFabrik;
	private JLabel lRathaus, lGewerbegebaeude, lBauernhof, lFabrik;
	
	//Alle Komponenten des Layouts
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	
	
	
	/**
	 * Konstruktor
	 */
	public BuildingPanel()
	{	
		initLayout();
		initPanel();
		initLabel();
	}
	
	
	
	/**
	 * initialisiert das Layout des BuildingPanels.
	 * Es handelt sich hierbei um ein GridbagLayout.
	 */
	private void initLayout()
	{
		gbl = new GridBagLayout();
		gbl.rowHeights = new int[]{60,40};
		gbl.columnWidths = new int[]{76,66,66,76};
		setLayout(gbl);
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
	}
	
	
	
	/**
	 * initialisiert die Panels des BuildingPanels
	 * Alle Panels werden einheitlich initialisiert.
	 */
	private void initPanel()
	{
		gbc.insets = new Insets(15, 23, 5, 13);
		
		setLayoutPositionAndSize(0, 0);
		pRathaus = new JPanel();
		pRathaus.setBackground(Color.blue);
		add(pRathaus, gbc);
		
		gbc.insets = new Insets(15, 13, 5, 13);
		
		setLayoutPositionAndSize(1, 0);
		pGewerbegebaeude = new JPanel();
		pGewerbegebaeude.setBackground(Color.blue);
		add(pGewerbegebaeude, gbc);
		
		setLayoutPositionAndSize(2, 0);
		pBauernhof = new JPanel();
		pBauernhof.setBackground(Color.blue);
		add(pBauernhof, gbc);
		
		
		gbc.insets = new Insets(15, 13, 5, 23);
		setLayoutPositionAndSize(3, 0);
		pFabrik = new JPanel();
		pFabrik.setBackground(Color.blue);
		add(pFabrik, gbc);
	}
	
	
	
	/**
	 * initialsiert die Labels des BuildingPanels
	 * Alle Labels werden einheitlich initialisiert.
	 */
	private void initLabel()
	{
		gbc.insets = new Insets(0, 10, 10, 0);
		
		setLayoutPositionAndSize(0, 1);
		lRathaus = new JLabel("Rathaus", JLabel.CENTER);
		add(lRathaus, gbc);
		
		gbc.insets = new Insets(0, 0, 10, 0);
		
		setLayoutPositionAndSize(1, 1);
		lGewerbegebaeude = new JLabel("Gewerbe", JLabel.CENTER);
		add(lGewerbegebaeude, gbc);
		
		setLayoutPositionAndSize(2, 1);
		lBauernhof = new JLabel("Bauernhof", JLabel.CENTER);
		add(lBauernhof, gbc);
		
		gbc.insets = new Insets(0, 0, 10, 10);
		
		setLayoutPositionAndSize(3, 1);
		lFabrik = new JLabel("Fabrik", JLabel.CENTER);
		add(lFabrik, gbc);
	}
	
	
	
	/**
	 * Konfiguriert das GridbagConstraints mit den uebergebenen Werten.
	 * @param gridX vom Typ Integer
	 * @param gridY vom Typ Integer
	 */
	private void setLayoutPositionAndSize(int gridX, int gridY)
	{
		gbc.gridx = gridX;
		gbc.gridy = gridY;
	}



	public JPanel getpRathaus() {
		return pRathaus;
	}



	public JPanel getpGewerbegebaeude() {
		return pGewerbegebaeude;
	}



	public JPanel getpBauernhof() {
		return pBauernhof;
	}



	public JPanel getpFabrik() {
		return pFabrik;
	}



	public JLabel getlRathaus() {
		return lRathaus;
	}



	public JLabel getlGewerbegebaeude() {
		return lGewerbegebaeude;
	}



	public JLabel getlBauernhof() {
		return lBauernhof;
	}



	public JLabel getlFabrik() {
		return lFabrik;
	}
}

package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

/**
 * Die Klasse WorldConfigurationPanel ist eine Komponente des MainPanels.
 * @author lorenz
 *
 */
public class WorldConfigurationPanel extends JPanel
{
	//Alle grafischen Komponenten, die innerhalb dieses Panels sind
	public JLabel lWasser, lTundra, lWiese, lWueste, lRohstoffdichte;
	private JSlider sWasser, sTundra, sWiese, sWueste, sRohstoffdichte;
	private JButton bGenerieren, bGeneriereRohstoffe;
	
	//Komponenten, die das Layout betreffen.
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	
	
	
	/**
	 * Konstruktor
	 */
	public WorldConfigurationPanel()
	{
		super();
		
		//die verschiedenen Komponenten werden mit Default-Werten initialisiert.
		initLayout();
		initLabel();
		initSlider();
		initButton();
	}
	
	
	
	
	/**
	 * initalisiert das Layout des WorldConfigurationPanels.
	 * Es handelt sich hierbei um ein GridbagLayout.
	 */
	private void initLayout()
	{
		gbl = new GridBagLayout();
		gbl.rowHeights = new int[]{30,29,30,29,30,29,30,29,45,29,20};	//Hoehe von 330 Pixel
		gbl.columnWidths = new int[]{122, 162};							//Breite von 284 Pixel
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		setLayout(gbl);
	}
	
	
	
	/**
	 * initalisiert die Labels des WorldConfigurationPanels.
	 * Hierbei werden alle Labels einheitlich initialisiert.
	 */
	private void initLabel()
	{
		gbc.insets = new Insets(0, 15, 0, 15);
		setLayoutPositionAndSize(0,0,2,1);
		lWasser = new JLabel("Wasser");
		lWasser.setVerticalAlignment(JLabel.BOTTOM);
		add(lWasser, gbc);
		
		setLayoutPositionAndSize(0, 2, 2, 1);
		lTundra = new JLabel("Tundra");
		lTundra.setVerticalAlignment(JLabel.BOTTOM);
		add(lTundra, gbc);
		
		setLayoutPositionAndSize(0, 4, 2, 1);
		lWiese = new JLabel("Wiese");
		lWiese.setVerticalAlignment(JLabel.BOTTOM);
		add(lWiese, gbc);
		
		setLayoutPositionAndSize(0, 6, 2, 1);
		lWueste = new JLabel("Wueste");
		lWueste.setVerticalAlignment(JLabel.BOTTOM);
		add(lWueste, gbc);
		
		setLayoutPositionAndSize(0, 8, 2, 1);
		lRohstoffdichte = new JLabel("Rohstoffdichte");
		lRohstoffdichte.setVerticalAlignment(JLabel.BOTTOM);
		add(lRohstoffdichte, gbc);
	}
	
	
	
	/**
	 * initialisiert die Slider des WorldConfigurationPanels.
	 * Hierbei werden alle Slider einheitlich initialisiert.
	 */
	private void initSlider()
	{
		gbc.insets = new Insets(0, 0, 0, 0);
		
		setLayoutPositionAndSize(0, 1, 2, 1);
		sWasser = new JSlider();
		add(sWasser, gbc);		
		
		setLayoutPositionAndSize(0, 3, 2, 1);
		sTundra = new JSlider();
		add(sTundra, gbc);
		
		setLayoutPositionAndSize(0, 5, 2, 1);
		sWiese = new JSlider();
		add(sWiese, gbc);
		
		setLayoutPositionAndSize(0, 7, 2, 1);
		sWueste = new JSlider();
		add(sWueste, gbc);
		
		setLayoutPositionAndSize(0, 9, 2, 1);
		sRohstoffdichte = new JSlider();
		add(sRohstoffdichte, gbc);
	}
	
	
	
	/**
	 * initialisert die Buttons des WorldConfigurationPanels.
	 * Hierbei werden alle Slider einheitlich initialsiert.
	 */
	private void initButton()
	{
		gbc.insets = new Insets(0, 6, 0, 0);
		
		setLayoutPositionAndSize(0, 11, 1, 1);
		bGenerieren = new JButton("Generieren");
		add(bGenerieren, gbc);
		
		
		gbc.insets = new Insets(0, 0, 0, 6);
		
		setLayoutPositionAndSize(1, 11, 1, 1);
		bGeneriereRohstoffe = new JButton("Verteile Rohstoffe");
		add(bGeneriereRohstoffe, gbc);
		
	}
	
	
	
	/**
	 * konfigurert das GridbagConstraints mit den uebergebenen Werten.
	 * @param gridX vom typ Integer
	 * @param gridY vom typ Integer
	 * @param gridWidth vom typ integer
	 * @param gridHeight vom Typ Integer
	 */
	private void setLayoutPositionAndSize(int gridX, int gridY, int gridWidth, int gridHeight)
	{
		gbc.gridx = gridX;
		gbc.gridy = gridY;
		gbc.gridwidth = gridWidth;
		gbc.gridheight = gridHeight;
	}




	public JSlider getsWasser() {
		return sWasser;
	}




	public JSlider getsTundra() {
		return sTundra;
	}




	public JSlider getsWiese() {
		return sWiese;
	}




	public JSlider getsWueste() {
		return sWueste;
	}




	public JSlider getsRohstoffdichte() {
		return sRohstoffdichte;
	}




	public JButton getbGenerieren() {
		return bGenerieren;
	}




	public JButton getbGeneriereRohstoffe() {
		return bGeneriereRohstoffe;
	}
}

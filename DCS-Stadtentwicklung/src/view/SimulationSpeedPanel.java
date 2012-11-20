package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * Diese Klasse SimulationSpeedPanel ist eine Komponente des MainPanels
 * @author lorenz
 *
 */
public class SimulationSpeedPanel extends JPanel
{
	//Alle grafischen Komponenten des SimulationSpeedPanels
	private JLabel lGeschwindigkeit, lMaximalSpeed;
	private JButton bStart;
	private JTextField tfMaximalSpeed;
	private JSlider sSpeed;
	
	//Alle Kompontenen des Layouts
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	
	
	
	/**
	 * Konstruktor
	 */
	public SimulationSpeedPanel()
	{
		super();
		
		initLayout();
		initLabel();
		initButton();
		initTextField();
		initSlider();
	}
	
	
	
	/**
	 * initialisiert das Layout des SimulationSpeedPanels.
	 * Es handelt sich hierbei um ein GridbagLayout
	 */
	private void initLayout()
	{
		gbl = new GridBagLayout();
		gbl.columnWidths = new int[]{60,400,40,80,70};
		gbl.rowHeights = new int[]{29};
		setLayout(gbl);
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
	}
	
	
	
	/**
	 * initialisiert die Labels des SimulationSpeedPanels.
	 * Es werden alle Label einheitlich initialisiert.
	 */
	private void initLabel()
	{
		gbc.insets = new Insets(0, 15, 0, 0);
		
		setLayoutPosition(0, 0);
		lGeschwindigkeit = new JLabel("Geschwindigkeit");
		lGeschwindigkeit.setHorizontalAlignment(SwingConstants.LEFT);
		add(lGeschwindigkeit, gbc);
		
		gbc.insets = new Insets(0, 0, 0, 0);
		
		setLayoutPosition(2, 0);
		lMaximalSpeed = new JLabel("max");
		add(lMaximalSpeed, gbc);
	}
	
	
	
	/**
	 * initialisiert das Button des SimulationSpeedPanels.
	 */
	private void initButton()
	{
		gbc.insets = new Insets(0, 0, 0, 5);
		
		setLayoutPosition(4, 0);
		bStart = new JButton("Start");
		add(bStart, gbc);
	}
	
	
	
	/**
	 * initialisiert das TextFeld des SimulationSpeedPanels.
	 */
	private void initTextField()
	{
		setLayoutPosition(3, 0);
		tfMaximalSpeed = new JTextField();
		add(tfMaximalSpeed, gbc);
	}
	
	
	
	/**
	 * initialisiert den Slider des SimulationSpeedPanels.
	 */
	private void initSlider()
	{
		setLayoutPosition(1, 0);
		sSpeed = new JSlider();
		add(sSpeed, gbc);
	}
	
	
	
	/**
	 * konfiguriert das GrifbagConstraints mit den uebergebenen Werten.
	 * @param gridX vom Typ Integer
	 * @param gridY vom typ Integer
	 */
	private void setLayoutPosition(int gridX, int gridY)
	{
		gbc.gridx = gridX;
		gbc.gridy = gridY;
	}
}

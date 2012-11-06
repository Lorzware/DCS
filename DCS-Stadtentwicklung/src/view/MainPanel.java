package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
/**
 * Die Klasse MainPanel ist eine von fuenf Komponenten des MainFrames.
 * Sie Beinhaltet die Panels WorldConfigurationPanel, //TODO
 * @author lorenz
 *
 */
public class MainPanel extends JPanel
{
	//Die grafischen Komponenten des MainPanels
	private WorldConfigurationPanel pWorldConfiguration;
	private BuildingPanel pBuilding;
	private StatisticPanel pStatistic;
	private SimulationSpeedPanel pSimulationSpeed;
	
	//Die Komponenten des Layouts
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	
	
	
	/**
	 * Konstruktor
	 */
	public MainPanel()
	{
		super();
		
		initLayout();
		initPanel();
	}
	
	
	
	/**
	 * initialisert das Layout des MainPanels.
	 * Hierbei handelt es sich um ein GridbagLayout
	 */
	private void initLayout()
	{
		gbl = new GridBagLayout();
		gbl.columnWidths = new int[]{284,700};
		gbl.rowHeights = new int[]{330, 90,100, 29};
		setLayout(gbl);
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
	}
	
	
	
	/**
	 * initialisiert die verschiedenen Panels des MainPanels
	 * Hierbei werden alle Panels einheitlich initialisiert
	 */
	private void initPanel()
	{
		gbc.insets = new Insets(7, 10, 0, 5);
		
		setLayoutPositionAndSize(0, 0, 1, 1);
		pWorldConfiguration = new WorldConfigurationPanel();
		pWorldConfiguration.setBorder(BorderFactory.createLineBorder(Color.gray));
		pWorldConfiguration.setBorder(BorderFactory.createTitledBorder("Konfiguration der Welt"));
		add(pWorldConfiguration, gbc);
		
		gbc.insets = new Insets(5, 10, 0, 5);
		
		setLayoutPositionAndSize(0, 1, 1, 1);
		pBuilding = new BuildingPanel();
		pBuilding.setBorder(BorderFactory.createLineBorder(Color.gray));
		pBuilding.setBorder(BorderFactory.createTitledBorder("Gebäude"));
		add(pBuilding, gbc);
		
		gbc.insets = new Insets(5, 10, 10, 5);
		
		setLayoutPositionAndSize(0, 2, 1, 2);
		pStatistic = new StatisticPanel();
		pStatistic.setBorder(BorderFactory.createLineBorder(Color.gray));
		pStatistic.setBorder(BorderFactory.createTitledBorder("Statistik"));
		add(pStatistic, gbc);
		
		gbc.insets = new Insets(5, 0, 10, 5);
		
		setLayoutPositionAndSize(1, 3, 1, 1);
		pSimulationSpeed = new SimulationSpeedPanel();
		pSimulationSpeed.setBorder(BorderFactory.createLineBorder(Color.gray));
		pSimulationSpeed.setBorder(BorderFactory.createTitledBorder("Konfiguration der Simulation"));
		add(pSimulationSpeed, gbc);
	}
	
	
	
	/**
	 * Konfiguriert das GridbagConstraints mit den uebergebenen Werten.
	 * @param gridX vom Typ Integer
	 * @param gridY vom typ Integer
	 * @param gridWidth vom typ Integer
	 * @param gridHeight vom Typ Integer
	 */
	private void setLayoutPositionAndSize(int gridX, int gridY, int gridWidth, int gridHeight)
	{
		gbc.gridx = gridX;
		gbc.gridy = gridY;
		gbc.gridwidth = gridWidth;
		gbc.gridheight = gridHeight;
		
	}
}

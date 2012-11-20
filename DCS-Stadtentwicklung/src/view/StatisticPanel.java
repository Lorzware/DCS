package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Die Klasse StatisticPanel ist eine Komponente des MainPanels
 * @author lorenz
 *
 */
public class StatisticPanel extends JPanel
{
	//Alle grafischen Komponenten des StatisticPanel
	private JLabel lEinwohner, lGewerbe, lLandwirtschaft, lIndustrie;
	private JTextField tfEinfohner, tfGewerbe, tfLandwirtschaft, tfIndustrie;
	
	//Alle Komponenten des Layouts
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	
	
	
	/**
	 * Konstruktor
	 */
	public StatisticPanel()
	{
		super();
		
		initLayout();
		initLabel();
		initTextField();
	}
	
	
	
	/**
	 * initialisiert das Layoutdes StatisticPanels
	 * Es handelt sich hierbei um ein GridbagLayout.
	 */
	private void initLayout()
	{
		gbl = new GridBagLayout();
		gbl.rowHeights = new int[]{40,30,30,40};
		gbl.columnWidths = new int[]{130, 154};
		setLayout(gbl);
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
	}
	
	
	
	/**
	 * initialisiert die Labels des StatisticPanels
	 * Alle Labels werden einheitlich initialisiert.
	 */
	private void initLabel()
	{
		gbc.insets = new Insets(10, 15, 0, 0);
		
		setLayoutPosition(0, 0);
		lEinwohner = new JLabel("Einwohner");
		add(lEinwohner, gbc);
		
		gbc.insets = new Insets(0, 15, 0, 0);
		
		setLayoutPosition(0, 1);
		lGewerbe = new JLabel("Gewerbe");
		add(lGewerbe, gbc);
		
		setLayoutPosition(0, 2);
		lLandwirtschaft = new JLabel("Landwirtschaft");
		add(lLandwirtschaft, gbc);
		
		gbc.insets = new Insets(0, 15, 10, 0);
		
		setLayoutPosition(0, 3);
		lIndustrie = new JLabel("Industrie");
		add(lIndustrie, gbc);
	}
	
	
	
	/**
	 * initialisiert die TextFields des StatisticPanels.
	 * Alle Textfields werden einheitlich initialisiert.
	 */
	private void initTextField()
	{
		gbc.insets = new Insets(10, 0, 0, 70);
		
		setLayoutPosition(1, 0);
		tfEinfohner = new JTextField();
		tfEinfohner.setEnabled(false);
		add(tfEinfohner, gbc);
		
		gbc.insets = new Insets(0, 0, 0, 70);
		
		setLayoutPosition(1, 1);
		tfGewerbe = new JTextField();
		tfGewerbe.setEnabled(false);
		add(tfGewerbe, gbc);
		
		setLayoutPosition(1, 2);
		tfLandwirtschaft = new JTextField();
		tfLandwirtschaft.setEditable(false);
		add(tfLandwirtschaft, gbc);
		
		gbc.insets = new Insets(0, 0, 10, 70);
		
		setLayoutPosition(1, 3);
		tfIndustrie = new JTextField();
		tfIndustrie.setEnabled(false);
		add(tfIndustrie, gbc);
	}
	
	
	
	/**
	 * Konfiguriert das GridbagConstraints mit den uebergebenen Werten.
	 * @param gridX vom Typ Integer
	 * @param gridY vom Typ Integer
	 */
	private void setLayoutPosition(int gridX, int gridY)
	{
		gbc.gridx = gridX;
		gbc.gridy = gridY;
	}



	public JTextField getTfEinfohner() {
		return tfEinfohner;
	}



	public JTextField getTfGewerbe() {
		return tfGewerbe;
	}



	public JTextField getTfLandwirtschaft() {
		return tfLandwirtschaft;
	}



	public JTextField getTfIndustrie() {
		return tfIndustrie;
	}
}

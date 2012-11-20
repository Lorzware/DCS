package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import static konstanten.GUIKonstanten.*;

public class MainFrame
{
	private JFrame frame;
	private MainPanel pMain;
	private MenuBarCustom menu;
	
	public MainFrame()
	{
		frame = new JFrame(MAIN_FRAME_NAME);
		initMenu();
		pMain = new MainPanel();
		frame.add(pMain);
		frame.pack();
		initalize();
	}
	
	/**
	 * Initialisiert den Hauptframe
	 */
	private void initalize()
	{
		// Close Operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(MAIN_FRAME_RESIZEABLE);	
		frame.setVisible(MAIN_FRAME_VISIBILITY);
	}
	
	private void initMenu()
	{
		menu = new MenuBarCustom();
		frame.setJMenuBar(menu);
	}
	
}

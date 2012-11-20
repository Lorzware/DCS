package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBarCustom extends JMenuBar
{
	private JMenu menu;
	public MenuBarCustom()
	{
		super();
		initMenu();
	}
	
	private void initMenu()
	{
		menu = new JMenu("Datei");
		menu.add(new AbstractAction("Neu") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		menu.add(new AbstractAction("Speichern") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		menu.add(new AbstractAction("Laden") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		menu.add(new AbstractAction("Beenden") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		add(menu);
	}

	public JMenu getMenu() {
		return menu;
	}
}

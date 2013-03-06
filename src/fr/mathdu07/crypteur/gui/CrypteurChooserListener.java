package fr.mathdu07.crypteur.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import fr.mathdu07.crypteur.CrypteurOutput;
import fr.mathdu07.crypteur.mode.CrypteurEnum;

public class CrypteurChooserListener implements ItemListener {
	
	private CrypteurOutput out;
	
	public CrypteurChooserListener(CrypteurOutput out){
		this.out = out;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource() instanceof CrypteurChooserMode){
			CrypteurEnum mode = ((CrypteurChooserMode) e.getSource()).getCrypteurMethod();
			
			if(mode == null)
				return;
			
			if (mode.equals(CrypteurEnum.CESAR))
				out.setKeyAsInteger(25);
			else
				out.setKeyAsCharacter();
		}

	}

}

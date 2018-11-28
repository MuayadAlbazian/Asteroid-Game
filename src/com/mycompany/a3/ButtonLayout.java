package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.plaf.Border;

public class ButtonLayout extends Button{
	
	public ButtonLayout(String text) {
		getUnselectedStyle().setBgTransparency(255);
		getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		getAllStyles().setPadding(TOP, 1);
		getAllStyles().setPadding(BOTTOM, 1);
		getUnselectedStyle().setBorder(Border.createLineBorder(1, ColorUtil.WHITE));
		
	}

}

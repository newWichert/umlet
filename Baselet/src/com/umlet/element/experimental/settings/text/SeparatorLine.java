package com.umlet.element.experimental.settings.text;

import com.baselet.control.Constants.AlignHorizontal;
import com.baselet.diagram.draw.BaseDrawHandler;
import com.umlet.element.experimental.PropertiesConfig;
import com.umlet.element.experimental.helper.XPoints;

public class SeparatorLine implements Facet {

	private boolean setHAlignToLeftAfterLine;
	private static final int H_SPACE = 4;

	public SeparatorLine() {
		this(false);
	}

	public SeparatorLine(boolean setHAlignToLeftAfterLine) {
		this.setHAlignToLeftAfterLine = setHAlignToLeftAfterLine;
	}
	
	@Override
	public void handleLine(String line, BaseDrawHandler drawer, PropertiesConfig propConfig) {
		if (setHAlignToLeftAfterLine) {
			propConfig.sethAlign(AlignHorizontal.LEFT);
		}
		float linePos = propConfig.getDividerPos(drawer.textHeight());
		XPoints xPos = propConfig.getXLimits(linePos);
		drawer.drawLine(xPos.getLeft()+1, linePos, xPos.getRight()-1, linePos);
		propConfig.addToYPos(H_SPACE);
	}

	@Override
	public boolean checkStart(String line) {
		return line.equals("--");
	}

	@Override
	public boolean replacesText(String line) {
		return true;
	}

}

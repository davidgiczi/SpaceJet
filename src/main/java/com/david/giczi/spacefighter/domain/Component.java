package com.david.giczi.spacefighter.domain;

import com.david.giczi.spacefighter.config.Config;

public class Component {

	
	private int logicBoardIndex;
	private int viewBoard_x;
	private int viewBoard_y;
	private String color;
	
	
	public Component(int logicBoardIndex) {

		this.logicBoardIndex = logicBoardIndex;
		this.viewBoard_x = clacViewBoardCoordsFromLogicBoardIndex(logicBoardIndex)[0];
		this.viewBoard_y = clacViewBoardCoordsFromLogicBoardIndex(logicBoardIndex)[1];
	}

	public Component(int viewBoard_x, int viewBoard_y) {
		
		this.viewBoard_x = viewBoard_x;
		this.viewBoard_y = viewBoard_y;
		this.logicBoardIndex = calcLogicBoardIndexFromViewBoardCoords(viewBoard_x, viewBoard_y);
	}
	
	
	private int calcLogicBoardIndexFromViewBoardCoords(int x, int y) {
		
		return  x * Config.BOARD_COLS + y;
	}
	
	private int[] clacViewBoardCoordsFromLogicBoardIndex(int logicBoardIndex) {
		
		int[] coords = new int[2];
		
		coords[0] = (int) (logicBoardIndex / Config.BOARD_COLS);
		coords[1] = logicBoardIndex % Config.BOARD_COLS;
		
		return coords;
	}

	public int getLogicBoardIndex() {
		return logicBoardIndex;
	}


	public void setLogicBoardIndex(int logicBoardIndex) {
		this.logicBoardIndex = logicBoardIndex;
		this.viewBoard_x = clacViewBoardCoordsFromLogicBoardIndex(logicBoardIndex)[0];
		this.viewBoard_y = clacViewBoardCoordsFromLogicBoardIndex(logicBoardIndex)[1];
	}


	public int getViewBoard_x() {
		return viewBoard_x;
	}


	public void setViewBoardCoords(int viewBoard_x, int viewBoard_y) {
		this.viewBoard_x = viewBoard_x;
		this.viewBoard_y = viewBoard_y;
		this.logicBoardIndex = calcLogicBoardIndexFromViewBoardCoords(viewBoard_x, viewBoard_y);
	}


	public int getViewBoard_y() {
		return viewBoard_y;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + viewBoard_x;
		result = prime * result + viewBoard_y;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Component other = (Component) obj;
		if (viewBoard_x != other.viewBoard_x)
			return false;
		if (viewBoard_y != other.viewBoard_y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Component [logicBoardIndex=" + logicBoardIndex + ", viewBoard_x=" + viewBoard_x + ", viewBoard_y="
				+ viewBoard_y + ", color=" + color + "]";
	}

	
}

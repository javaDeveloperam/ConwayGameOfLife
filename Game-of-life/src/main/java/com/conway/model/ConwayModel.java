package com.conway.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
@Component
public class ConwayModel {
	private int xCordinate, yCordinate;

	public int getxCordinate() {
		return xCordinate;
	}

	public void setxCordinate(int xCordinate) {
		this.xCordinate = xCordinate;
	}

	public int getyCordinate() {
		return yCordinate;
	}

	public void setyCordinate(int yCordinate) {
		this.yCordinate = yCordinate;
	}

	public boolean isAutoPlay() {
		return isAutoPlay;
	}

	public void setAutoPlay(boolean isAutoPlay) {
		this.isAutoPlay = isAutoPlay;
	}

	public String getliveCellList() {
		return liveCellList;
	}

	public void setliveCellList(String liveCellList) {
		this.liveCellList = liveCellList;
	}

	private boolean isAutoPlay;
	private String liveCellList;
}

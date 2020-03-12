package com.conway.bussinessLogic;

import java.util.ArrayList;

public class RuleRunner {

	public ArrayList<Integer> getAdjusentCells(int x, int y, int selectedCell) {
		int totalCell = x * y;
		int cellValue = selectedCell + x;
		ArrayList<Integer> adjusentAL = new ArrayList<Integer>();

		for (int i = 0; i <= 2; i++) {
			if (cellValue > totalCell || cellValue < 1) {
				cellValue = cellValue - x;
				continue;
			}
			int currentX = cellValue / x + 1;
			if (cellValue % x == 0) {
				currentX--;
			}
			int xEnd = currentX * x;
			int xStart = xEnd - x + 1;
			if ((cellValue - 1) >= xStart && (cellValue - 1) <= xEnd) {
				adjusentAL.add(cellValue - 1);
			}
			if (cellValue >= xStart && cellValue <= xEnd && cellValue != selectedCell) {
				adjusentAL.add(cellValue);
			}
			if (cellValue + 1 >= xStart && cellValue + 1 <= xEnd) {
				adjusentAL.add(cellValue + 1);
			}
			cellValue = cellValue - x;
		}
		return adjusentAL;
	}

	public boolean runRules(ArrayList<Integer> selectedCellList, int cell, int adjusentLiveCount) {
		boolean isCellLiveinNextGen = false;

		if (selectedCellList.contains(cell)) {
			if (adjusentLiveCount == 2 || adjusentLiveCount == 3) {
				isCellLiveinNextGen = true;
			}
		} else {
			if (adjusentLiveCount == 3) {
				isCellLiveinNextGen = true;
			}
		}
		return isCellLiveinNextGen;

	}

	/**
	 * 
	 * @param adjusentCellList
	 * @param selectedCellList
	 * @return
	 */
	public int getLiveAdjusentCellCount(ArrayList<Integer> adjusentCellList, ArrayList<Integer> selectedCellList) {
		int liveCount = 0;
		for (int i = 0; i < adjusentCellList.size(); i++) {

			if (selectedCellList.contains(adjusentCellList.get(i))) {
				liveCount++;
			}
		}
		return liveCount;
	}
/**
 * 
 * @param selectedAL
 * @param selectedCells
 */
	public void convertStringToArraylist(ArrayList<Integer> selectedAL, String selectedCells) {
		String[] selectedArray = selectedCells.split(",");
		for (int i = 0; i < selectedArray.length; i++) {
			selectedAL.add(Integer.parseInt(selectedArray[i]));
		}
	}

}

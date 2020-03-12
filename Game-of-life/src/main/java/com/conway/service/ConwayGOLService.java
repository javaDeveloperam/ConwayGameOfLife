package com.conway.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.conway.bussinessLogic.RuleRunner;
import com.conway.model.ConwayModel;

@Service
public class ConwayGOLService {
	/**
	 * 
	 * @param conModel
	 * @return
	 */
	public String findNextGeneration(ConwayModel conModel) {
		int x = conModel.getxCordinate();
		int y = conModel.getyCordinate();
		String selectedCells = conModel.getliveCellList();
		int totalCells = x * y;
		RuleRunner ruleRunner = new RuleRunner();
		ArrayList<Integer> selectedCellAL = new ArrayList<Integer>();
		String nextGenCellList = "";
		ruleRunner.convertStringToArraylist(selectedCellAL, selectedCells);
		for (int i = 0; i < totalCells; i++) {
			ArrayList<Integer> adjusentCellList = ruleRunner.getAdjusentCells(x, y, i + 1);
			int adjusentLiveCount = ruleRunner.getLiveAdjusentCellCount(adjusentCellList, selectedCellAL);
			boolean isCellLiveInNextGen = ruleRunner.runRules(selectedCellAL, i + 1, adjusentLiveCount);

			if (isCellLiveInNextGen) {
				if (!nextGenCellList.isEmpty()) {
					nextGenCellList += ",";
				}
				nextGenCellList += "" + (i + 1);
			}
		}
		return nextGenCellList;
	}

}

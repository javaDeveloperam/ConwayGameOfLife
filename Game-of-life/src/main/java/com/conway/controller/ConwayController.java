package com.conway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.conway.model.ConwayModel;
import com.conway.service.ConwayGOLService;
/**
 * Controller
 * @author amitmu
 *
 */
@Controller
public class ConwayController {

	@Autowired
	ConwayGOLService golService;
	@Autowired
	ConwayModel conwayModel;

	/**
	 * Load initial state of grid
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/conway", method = RequestMethod.GET)
	public String loadConwayGameOfLife(ModelMap map) {
		ConwayModel model = new ConwayModel();
		model.setxCordinate(5);
		model.setyCordinate(5);
		map.addAttribute("ConwayModel", model);
		return "conway";
	}

	/**
	 * Redirect to service get next direction
	 * 
	 * @param map
	 * @param conModel
	 * @param liveCellList
	 * @param xCordinate
	 * @param yCordinate
	 * @return
	 */
	@RequestMapping(value = "/conway", method = RequestMethod.POST)
	public String findNextGeneration(ModelMap map, @ModelAttribute("ConwayModel") ConwayModel conModel,
			@RequestParam(value = "liveCellList", required = false) String liveCellList,
			@RequestParam(value = "xCordinate", required = false) int xCordinate,
			@RequestParam(value = "yCordinate", required = false) int yCordinate) {
		System.out.println("Post request" + xCordinate + "   " + yCordinate + "    " + liveCellList);
		liveCellList = golService.findNextGeneration(conModel);
		conModel.setliveCellList(liveCellList);
		map.addAttribute("ConwayModel", conModel);
		map.put("xCordinate", conModel.getxCordinate());
		map.put("yCordinate", conModel.getyCordinate());
		map.put("LiveCellList", liveCellList);
		System.out.println("7,8,9");
		System.out.println("Live cell list   " + liveCellList);
		return "conway";
	}
}

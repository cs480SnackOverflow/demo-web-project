package edu.csupomona.cs480.controller;

import edu.csupomona.cs480.data.entity.SetMetadata;
import edu.csupomona.cs480.service.SetMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SetMetadataController {

	private SetMetadataService setMetadataService;

	@Autowired
	public void setSetMetadataService(SetMetadataService setMetadataService) {
		this.setMetadataService = setMetadataService;
	}

	//Returns the requested SetMetadata
	@RequestMapping(value = "setmetadata/get/{id}")
	public String getSet(@PathVariable Integer id, Model model) {
		model.addAttribute("setmetadata", setMetadataService.getSetMetadataById(id));
		return "setmetadata";
	}

	//Creates and updates the values of a SetMetadata
	@RequestMapping(value = "setmetadata/set", method = RequestMethod.POST)
	public String setSet(SetMetadata setMetadata) {
		setMetadataService.saveSetMetadata(setMetadata);
		return "redirect:/setmetadata/get/" + setMetadata.getSetId();
	}
}
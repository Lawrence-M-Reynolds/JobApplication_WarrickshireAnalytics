package com.reynolds.lawrence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.reynolds.lawrence.bean.CsvData;
import com.reynolds.lawrence.manager.CsvManager;
import com.reynolds.lawrence.manager.DataProcessorManager;

@Controller
@RequestMapping("/")
public class MainController {
	private String viewName = "csvUploadPage";

	private CsvManager csvManager;
	private DataProcessorManager dataProcessorManager;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadMainPage() {
		return viewName;
	}

	@RequestMapping(value = "/processUploadedCSVFile", method = RequestMethod.POST)
	public ModelAndView processFileUpload(
			@RequestParam(value = "csvUpload", required = true) MultipartFile csvUpload) {
		ModelAndView modelAndView = new ModelAndView(viewName);

		//TODO - Need to include validation.
		
		// Get the CSV data beans from the file.
		CsvData csvData = csvManager.processCsvFile(csvUpload);
		
		// Filter the beans
		CsvData filteredCsvData = dataProcessorManager.filterBeans(csvData);
		
		modelAndView.addObject("filteredCsvData", filteredCsvData);
		return modelAndView;
	}

	public CsvManager getCsvManager() {
		return csvManager;
	}

	@Autowired
	public void setCsvManager(CsvManager csvManager) {
		this.csvManager = csvManager;
	}
	
	public DataProcessorManager getDataProcessorManager() {
		return dataProcessorManager;
	}

	@Autowired
	public void setDataProcessorManager(DataProcessorManager dataProcessorManager) {
		this.dataProcessorManager = dataProcessorManager;
	}
}

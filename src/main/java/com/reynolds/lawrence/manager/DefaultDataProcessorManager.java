package com.reynolds.lawrence.manager;

import org.springframework.stereotype.Component;

import com.reynolds.lawrence.bean.CsvData;

/**
 * Class to process data.
 * @author lawrencereynolds
 *
 */
@Component
public class DefaultDataProcessorManager implements DataProcessorManager {


	public CsvData filterBeans(CsvData csvData) {
		// TODO - Just returning the same data here without filtering. Please
		// implement the logic to do the necessary filtering.
		return csvData;
	}

}

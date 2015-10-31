package com.reynolds.lawrence.manager;

import com.reynolds.lawrence.bean.CsvData;

public interface DataProcessorManager {

	/**
	 * Filters the {@link CsvData}.
	 */
	public CsvData filterBeans(CsvData csvData);

}

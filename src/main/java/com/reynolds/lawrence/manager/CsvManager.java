package com.reynolds.lawrence.manager;

import org.springframework.web.multipart.MultipartFile;

import com.reynolds.lawrence.bean.CsvData;

/**
 * Performs tasks related to CSV files.
 * @author lawrencereynolds
 *
 */
public interface CsvManager {

	/**
	 * Parses a CSV file from a {@link MultipartFile} and returns
	 * the data as a {@link CsvData} bean.
	 * @param csvUpload
	 * @return
	 */
	public CsvData processCsvFile(MultipartFile csvUpload);

}

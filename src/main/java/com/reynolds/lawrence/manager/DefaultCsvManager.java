package com.reynolds.lawrence.manager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reynolds.lawrence.bean.CsvData;
import com.reynolds.lawrence.bean.CsvRow;

/**
 * Implementation of the {@link CsvManager} that uses the apache commons
 * {@link CSVParser}.
 * 
 * @author lawrencereynolds
 *
 */
@Service
public class DefaultCsvManager implements CsvManager {

	// Move these to a constants file.
	private static final String IDENTIFIER_HEADER = "Id";
	private static final String DECISION_HEADER = "Decision";
	private static final String VAR_HEADER = "Var";

	public CsvData processCsvFile(MultipartFile csvUpload) {
		/*
		 * Method is quite long so maybe refactor this into smaller methods.
		 */
		CsvData csvData = new CsvData();

		InputStream inputStream = null;
		CSVParser csvFileParser = null;
		try {
			inputStream = csvUpload.getInputStream();
			CSVFormat csvFileFormat = CSVFormat.DEFAULT;

			csvFileParser = new CSVParser(new InputStreamReader(inputStream),
					csvFileFormat);

			List<CSVRecord> csvRecords = csvFileParser.getRecords();

			// Get the first row which should be the headers
			CSVRecord headerRow = csvRecords.remove(0);

			// Determine where the columns are and add headers to the csvData
			// bean.
			Map<String, Integer> headerIndexMap = new HashMap<String, Integer>();
			int index = 0;
			for (String header : headerRow) {
				headerIndexMap.put(header, index);
				csvData.getColumnHeaderList().add(header);
				index++;
			}

			int numberOfVars = (index - 2);

			// Create the CsvRow beans.
			for (CSVRecord csvRecord : csvRecords) {
				CsvRow row = new CsvRow();
				row.setIdentifier(Integer.parseInt(csvRecord.get(headerIndexMap
						.get(IDENTIFIER_HEADER))));
				int decisionIntValue = Integer.parseInt(csvRecord
						.get(headerIndexMap.get(DECISION_HEADER)));
				
				//Storing as a boolean so that filtering is cleaner.
				row.setDecision(decisionIntValue != 0);

				for (int i = 1; i == numberOfVars; i++) {
					String varColumnHeader = VAR_HEADER + i;
					Long var = Long.parseLong(csvRecord.get(headerIndexMap
							.get(varColumnHeader)));
					row.getVariables().put(varColumnHeader, var);
				}
				csvData.getCsvRows().add(row);
			}
		} catch (IOException e) {
			e.printStackTrace();
			// Create a new exception type and throw up to the controller from
			// here.
		} finally {
			try {
				inputStream.close();
				csvFileParser.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return csvData;
	}
}

package com.reynolds.lawrence.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds all of the information from a parsed CSV file.
 * @author lawrencereynolds
 *
 */
public class CsvData {

	private List<String> columnHeaderList = new ArrayList<String>();
	private List<CsvRow> csvRows = new ArrayList<CsvRow>();

	public List<String> getColumnHeaderList() {
		return columnHeaderList;
	}
	public void setColumnHeaderList(List<String> columnHeaderList) {
		this.columnHeaderList = columnHeaderList;
	}
	public List<CsvRow> getCsvRows() {
		return csvRows;
	}
	public void setCsvRows(List<CsvRow> csvRows) {
		this.csvRows = csvRows;
	}
	
}

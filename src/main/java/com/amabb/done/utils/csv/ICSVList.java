package com.amabb.done.utils.csv;

public interface ICSVList {

	String CSV_SEPARATOR = "\t";
	
	String CSV_LR = "\r\n";

	String toCSV() throws IllegalArgumentException, IllegalAccessException;
}

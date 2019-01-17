package com.glassdoor.tests;

import java.util.ArrayList;

public class Result {
	private String browser;
	public ArrayList<String> result = new ArrayList<String>();
	
	public void print() {
		if(result.isEmpty() == false) {
			System.out.println();
			System.out.println(browser + " RESULTS");
			System.out.println("-----------------");
			
			for(String data : result) {
				System.out.println(data);
			}
		}
	}
	
	public void add(String data) {
		result.add(data);
	}
	
	public void setBrowser(String b) {
		this.browser = b;
	}

}

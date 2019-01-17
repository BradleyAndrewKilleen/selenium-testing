package com.glassdoor.tests;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GlassdoorJobSearch {

	public static void main(String[] args) {
		
		ArrayList<Result> endResult = new ArrayList<Result>();
		
		UserSelection us = new UserSelection();
		us.print();
		
		Scanner s = new Scanner(System.in);
		int userChoice = s.nextInt();
		s.close();
		
		if(userChoice == 1 || userChoice == 0) {
			//Communicate with user via console
			System.out.println("Spinning up FireFox instance and testing");
			
			//Create driver with desired browser (1 for FF, 2 for Chrome)
			WebDriver driver = new Driver().setBrowser(1);

			//Run test by going to webpage and entering search data
			Test t = new Test();
			t.performTests(driver);
			
			//Create local data for search results info
			WebElement firstSearchResult = driver.findElement(By.xpath("//li[@class = 'jl selected']"));
			String listFirstItem  = firstSearchResult.getAttribute("data-normalize-job-title");
			String firstPostAge = firstSearchResult.findElement(By.xpath("//span[@class = 'minor']")).getText();
			String firstPostSalary = firstSearchResult.findElement(By.xpath("//span[@class = 'green small']")).getText();
			
			//Create local data for other search results displayed on page
			List<WebElement> otherSearchResults = driver.findElements(By.xpath("//li[@class = 'jl']"));
			List<String> otherSearchResultTitles = new ArrayList<String>();
			
			for(WebElement we : otherSearchResults) {
				otherSearchResultTitles.add(we.getAttribute("data-normalize-job-title"));
			}
			
			//Store data in result object
			Result testResults = new Result();
			testResults.setBrowser("FIREFOX");
			testResults.add("Search Result Title Page: " + driver.getTitle());
			testResults.add("Top Result: " + listFirstItem);
			testResults.add("Top Result Post Age: " + firstPostAge);
			testResults.add("Top Result Projected Salary: " + firstPostSalary);
			testResults.add("---------------------------------------");
			
			for(String x : otherSearchResultTitles) {
				testResults.add("Other Search Result: " + x);
			}
			
			//Close browser
			driver.close();
			System.out.println("FireFox Test Complete");
			System.out.println();
			
			//Add individual test results to endResult for later printing
			endResult.add(testResults);
		}
		
		if (userChoice == 2 || userChoice == 0) {
			System.out.println("Spinning up Chrome instance and testing");
			
			WebDriver driver = new Driver().setBrowser(2); //Add driver info to driver
			
			Test t = new Test();
			t.performTests(driver);
			
			//Create local data for search results info
			WebElement firstSearchResult = driver.findElement(By.xpath("//li[@class = 'jl selected']"));
			String listFirstItem  = firstSearchResult.getAttribute("data-normalize-job-title");
			String firstPostAge = firstSearchResult.findElement(By.xpath("//span[@class = 'minor']")).getText();
			String firstPostSalary = firstSearchResult.findElement(By.xpath("//span[@class = 'green small']")).getText();
			
			//Create local data for other search results displayed on page
			List<WebElement> otherSearchResults = driver.findElements(By.xpath("//li[@class = 'jl']"));
			List<String> otherSearchResultTitles = new ArrayList<String>();
			
			for(WebElement we : otherSearchResults) {
				otherSearchResultTitles.add(we.getAttribute("data-normalize-job-title"));
			}
			
			//Store data in result object
			Result testResults = new Result();
			testResults.setBrowser("CHROME");
			testResults.add("Search Result Title Page: " + driver.getTitle());
			testResults.add("Top Result: " + listFirstItem);
			testResults.add("Top Result Post Age: " + firstPostAge);
			testResults.add("Top Result Projected Salary: " + firstPostSalary);
			testResults.add("---------------------------------------");
			
			for(String x : otherSearchResultTitles) {
				testResults.add("Other Search Result: " + x);
			}
			
			//Close browser
			driver.close();
			System.out.println("Chrome Test Complete");
			System.out.println();
			
			//Add individual test results to endResult for later printing
			endResult.add(testResults);
		}
		
		
		System.out.println("All testing complete. Results printed below.");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		
		for (Result r : endResult) {
			r.print();
		}
		
	}
}

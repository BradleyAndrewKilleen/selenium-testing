package com.glassdoor.tests;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Test {
	public Test() {
		
	}
	
	public void performTests(WebDriver d) {
		//Set webpage
		d.get("https://www.glassdoor.com/");
		
		//Enter search data
		d.findElement(By.id("KeywordSearch")).sendKeys("Appfolio Quality");
		
		//Find location field, clear, and enter Santa Barbara
		//d.findElement(By.id("LocationSearch")).click();
		//d.findElement(By.id("LocationSearch")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		//d.findElement(By.id("LocationSearch")).sendKeys(Keys.DELETE);
		//d.findElement(By.id("LocationSearch")).sendKeys("Santa Barbara, CA");
		
		//Find FindJobs button and click
		d.findElement(By.id("HeroSearchButton")).click();
	}
}

package com.hrm.master;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LibraryHrm {

	static WebDriver driver;
	static String Expval, Actval;

	public static void Launch_Url(String Url) throws Exception {

		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		driver = new FirefoxDriver();
		Thread.sleep(1000);
		driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		// System.out.println("driver" + driver);
		// Url
		Expval = "LOGIN panel";
		driver.get(Url);
		Thread.sleep(2000);
		System.out.println("Title is:" + driver.getTitle());
		Thread.sleep(1000);
		Actval = driver.findElement(By.id("logInPanelHeading")).getText();
		if (Expval.equalsIgnoreCase(Actval)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	public static void Admin_Login(String un, String pwd) throws Exception {
		// Login
		Expval = "Dashboard";
		driver.findElement(By.id("txtUsername")).sendKeys(un);
		Thread.sleep(2000);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		Thread.sleep(3000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);

		Actval = driver.findElement(By.id("menu_dashboard_index")).getText();
		Thread.sleep(2000);
		if (Expval.equalsIgnoreCase(Actval)) {
			System.out.println("Application launched successfully...");
		} else {
			System.out.println("Failed to login");
		}
	}

	public static String myInfo(String st1, String st2, String cty, String zp, String cntry, String mbl, String mail)
			throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//b[contains(text(),'My Info')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Contact Details')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("contact_street1")).sendKeys(st1);
		Thread.sleep(2000);
		driver.findElement(By.id("contact_street2")).sendKeys(st2);
		Thread.sleep(2000);
		driver.findElement(By.id("contact_city")).sendKeys(cty);
		Thread.sleep(2000);
		driver.findElement(By.id("contact_emp_zipcode")).sendKeys(zp);
		Thread.sleep(2000);
		WebElement cnt = driver.findElement(By.id("contact_country"));
		Select sl = new Select(cnt);
		sl.selectByVisibleText(cntry);
		Thread.sleep(2000);
		driver.findElement(By.id("contact_emp_mobile")).sendKeys(mbl);
		Thread.sleep(2000);
		driver.findElement(By.id("contact_emp_oth_email")).sendKeys(mail);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);

		return Actval;
	}

}

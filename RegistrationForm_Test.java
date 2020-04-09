package BootCamp_Test;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Com.homedepot.auto.BootCamp.HomeDepot_locat;

	public class RegistrationForm_Test {
		public static WebDriver driver=null;
		
		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kuria\\Desktop\\selenium\\BootCamp\\Drivers\\chromedriver.exe");
		}
		@BeforeMethod
		public void beforeMethod() {
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		@Test
		@Parameters ({"url", "email", "pass", "zip","phone"})
		public void test(String url, String email,
				String pass, String zip, String phone)  throws InterruptedException, IOException  {
			driver.get(url);
			HomeDepot_locat make = new HomeDepot_locat(driver);
			make.myAccountClick();
			Thread.sleep(300);
			TakeScreenshot("0");
			make.registerClick();
			Thread.sleep(300);
			TakeScreenshot("1");
			make.emailFill(email);
			make.passwordFill(pass);
			make.showPasswordClick();
			make.zipCodeFill(zip);
			make.phoneNumberFil(phone);
			make.phoneNumberVerifyClick();
			TakeScreenshot("2");
			Thread.sleep(300);
			make.accountRegisterBtnClick();
			Thread.sleep(2500);
			TakeScreenshot("3");
			make.refreshPage();
			Thread.sleep(2500);
			TakeScreenshot("4");
			}
		@AfterMethod
		public void afterMethod() throws InterruptedException {
			Thread.sleep(5000);
			driver.quit();	}
		public static void TakeScreenshot(String number) throws IOException {
			String directory="C:\\Users\\Kuria\\Desktop\\Screenshots";	
			File dirName=new File(directory+driver.getTitle()+" - "+number+".png");
			File sourcefile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourcefile, dirName);
			Reporter.log("<br><img src='"+dirName+"'height='380' width='400'/><br>");
		}
	}




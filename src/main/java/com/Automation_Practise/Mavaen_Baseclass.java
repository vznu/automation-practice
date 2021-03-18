package com.Automation_Practise;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mavaen_Baseclass {

public static  WebDriver driver; 
	
	public static WebDriver getbrowser(String type) {
	
		if (type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (type.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Driver\\geckodriver.exe" );
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		return driver;	
	}
	
	
		//Click
		public static void clickOnElement(WebElement element) {
			element.click();
		}
	
	
		//SendKeys
		public static void inputValueElement(WebElement element,String value) { 
			element.sendKeys(value);
		}
		
		
		//GetUrl
		public static void getUrl(String Url) {
			driver.get(Url);
		}
		
		//GetTitle
		public static void getTitle() {
			String title = driver.getTitle();
			System.out.println(title);
		}		
		
		//Navigate To
		public static void To(String url) {
			driver.navigate().to(url);
		}
		
		//Navigate Forward
		public static void Forward() {
			driver.navigate().forward();
		}
		
		//Navigate back
		public static void back() {
			driver.navigate().back();
		}
		
		//Refresh
		public static void Refresh() {
			driver.navigate().refresh();
		}
		
		//Close
		public static void close() {
			driver.close();
		}
		
		//Quit
		public static void quit() {
			driver.quit();
		}
		
		//ImplicitWait
		public static void implicitWait(int w) {
			driver.manage().timeouts().implicitlyWait(w, TimeUnit.SECONDS);
		}
		
		//ExplicitWait
		public static void explicitWait(WebElement element,int w) {
			WebDriverWait wait = new WebDriverWait(driver, w);
			wait.until(ExpectedConditions.visibilityOf(element));

		}
		//checkBox
		public static void checkBox(WebElement element) {
			element.click();
		}
		
		//ScreenShot
		public static void takeSnap(String folder) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(folder);
			FileUtils.copyFile(source, destination);
		}
		
		//single drop down
		public static void selectTheElement(WebElement element, String option ,String value) {
			Select s =new Select(element);
		
		if (option.equalsIgnoreCase("value")) {
		s.selectByValue(value);
		}
		
		else if (option.equalsIgnoreCase("text")) {
		s.selectByVisibleText(value);
		}
		
		else if (option.equalsIgnoreCase("index")) {
		int parseInt = Integer.parseInt(value);
		s.selectByIndex(parseInt);
		System.out.println(parseInt);
		}
		}
		
		//Alert
		public static void alert(String alt) {
			Alert alert = driver.switchTo().alert();
		if (alt.equalsIgnoreCase("accept")) {
			alert.accept();
		}
		else if (alt.equalsIgnoreCase("dismiss")) {
			alert.dismiss();
		}
		else if (alt.equalsIgnoreCase("text")) {
			String text = alert.getText();
			System.out.println(text);
		}
		}
		
		//Actions
		public static void mouseOver(WebElement element,String act) {
			Actions a=new Actions(driver);
			if (act.equalsIgnoreCase("move")) {
				a.moveToElement(element).build().perform();
			} 
			else if (act.equalsIgnoreCase("click")) {
				a.click(element).build().perform();
			
			}
			else if (act.equalsIgnoreCase("rightclick")) {
				a.contextClick().build().perform();
			}
		}
		
		//robot
		public static void robot(WebElement element,String key) throws AWTException {
			Robot r=new Robot();
			if (key.equalsIgnoreCase("down")) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}
			else if (key.equalsIgnoreCase("enter")) {
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyPress(KeyEvent.VK_ENTER);
			}

			}
		
		//multiDrop down
		 public static List<WebElement> selectTheElements(WebElement element,String size) {
			Select s = new Select(element);
			List<WebElement> getoption = s.getOptions();
			for (WebElement getoptions : getoption) {
				String text = getoptions.getText();
				System.out.println(text);
			}
			int size1 = getoption.size();
			System.out.println(size1);
	
		return getoption;
		 }
		
		 //getAllSelected
			public static void getAllSelected(WebElement element,String options,String value) {
				Select s=new Select(element);
				if (options.equalsIgnoreCase("index")) {
					int parseInt = Integer.parseInt(value);
					s.selectByIndex(parseInt);
				}
				List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
				for (WebElement selected : allSelectedOptions) {
					String text1 = selected.getText();
					System.out.println(text1);
				}
			}
		
			//getFirstSelected
			public static void getFirstSelected(WebElement element) {
				Select s=new Select(element);
				WebElement firstSelectedOption = s.getFirstSelectedOption();
				System.out.println(firstSelectedOption.getText());


			}
		 
			//isSelected
			public static void isSelected(WebElement element) {
			boolean selected = element.isSelected();
			System.out.println(selected);

		}
			//isEnabled
			public static void isEnabled(WebElement element) {
			boolean enabled = element.isEnabled();
			System.out.println(enabled);

			}
			
			//isDisplayed
			public static void isDisplayed(WebElement element) {
			boolean displayed = element.isDisplayed();
			System.out.println(displayed);

			}
			//webElement method sendKeys
			public static void sendKeys(WebElement element,String value) {
			try {
				element.sendKeys(value);
			} catch (Exception e) {
				e.printStackTrace();
			}

			}
	
			//clear
			public static void clear(WebElement element) {
			element.clear();

			}
			//isMultiple
			public static void isMultiple(WebElement element) {

				Select s=new Select(element);
				boolean multiple = s.isMultiple();
				System.out.println(multiple);

			}
		
			//getAttribute
		 public static void getAttributes(WebElement element,String value,String options) {
				if (value.equalsIgnoreCase("value")) {
					String attribute = element.getAttribute(options);
					System.out.println(attribute);
				}
				else if (value.equalsIgnoreCase("dom")) {
					String attribute2 = element.getAttribute(options);
					System.out.println(attribute2);
				}
			}
		//frames
		 public static void frames(WebElement element) {
		 	driver.switchTo().frame(element);
		 }
		 //mainframe
		 public static void mainFrame() {
		 	driver.switchTo().defaultContent();
		 }
		 //switch to frame
		 public static void switchToFrame() {

			 driver.switchTo().frame(0);

			 }
		 
		//scroll
		 public static void scroll(WebElement element,String option) {

		 	JavascriptExecutor js=(JavascriptExecutor) driver;
		 	if (option.equalsIgnoreCase("view")) {
		 		js.executeScript("arguments[0].scrollIntoView()", element);
		 	}
		 	else if (option.equalsIgnoreCase("pixel")) {
		 		js.executeScript("window.scrollBy(0,1000)");
		 	}

		 }

		//windowsHandles
		 public static void windowsHandles(String type,String destination ) {
		 	if (type.equalsIgnoreCase("singlewindow")) {
		 		String windowHandle = driver.getWindowHandle();
		 		System.out.println(windowHandle);
		 	}else if (type.equalsIgnoreCase("multiplewindows")) {
		 		Set<String> allwindow = driver.getWindowHandles();
		 		for (String all : allwindow) {
		 			String title = driver.switchTo().window(all).getTitle();
		 			System.out.println(title);
		 		}
		 		
		 		String actualtitle=destination;
		 				
		 		for (String id : allwindow) {
		 			if (driver.switchTo().window(id).getTitle().equals(destination)) {
		 				break;
		 			}
		 		}
		 	}}
	
}

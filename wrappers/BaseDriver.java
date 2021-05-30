package wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver implements Browser, Element, Select, TargetLocator {

	public static RemoteWebDriver driver;

	@Override
	public boolean startApp(String browser, String url) {

		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			} else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else {
				System.err.println("This browser "+browser+" is not supported");
				return false;
			}

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("The browser "+browser+" launched successfully");
			return true;

		} catch (Exception e) {
			System.err.println("The browser "+browser+" could not be launched");
			return false;
		}

	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> allWindows = new ArrayList<String>(windowHandles);
			String windowHandle = allWindows.get(index);
			driver.switchTo().window(windowHandle);
			System.out.println("The Window of the index "+index+" switched");
		} catch (Exception e) {
			System.err.println("The Window of the index "+index+" could not be switched");
		}
		
	}

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			System.out.println("Moved to frame "+ele);
		} catch (Exception e) {
			System.out.println("Unable to Move to frame "+ele);
		}

	}

	@Override
	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			System.out.println("Alert accepted Successfully");
		} catch (Exception e) {
			System.err.println("Alert not accepted");
		}

	}

	@Override
	public void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			System.out.println("Alert dismissed Successfully");
		} catch (Exception e) {
			System.err.println("Alert not dismissed");
		}

	}

	@Override
	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert text" +text+" captured successfully");
		return null;
	}

	@Override
	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		try {
			selectDropDownUsingVisibleText(ele, value);
			System.out.println("The dropdown "+ele+" is selected with the Visible text "+value+"");
		} catch (Exception e) {
			System.err.println("The dropdown "+ele+" is not selected with the Visible texts "+value+"");
		}
		
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			selectDropDownUsingValue(ele,value);
			System.out.println("The dropdown "+ele+" is selected with the value "+value+"");
		} catch (Exception e) {
			System.err.println("The dropdown "+ele+" is selected with the value "+value+"");
		}
	
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			selectDropDownUsingIndex(ele,index);
			System.out.println("The dropdown "+ele+" is selected with the index "+index+"");
		} catch (Exception e) {
			System.err.println("The dropdown "+ele+" is selected with the value "+index+"");
		}

	}

	@Override
	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The element "+ele+" is typed with the value "+data);
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be typed with the value "+data);
		}

	}
	
	@Override
	public void typeAndEnter(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			ele.sendKeys(Keys.ENTER);
			System.out.println("The element "+data+" is typed and entered with the value "+ele+"Pressed ENTER Key");
		} catch (Exception e) {
			System.err.println("The element "+data+" could not be typed and entered with the value "+ele+"Issue with Pressing ENTER Key");
		}

	}
	

	@Override
	public void click(WebElement ele) {	
		try {
			ele.click();
			System.out.println("The element "+ele+" is clicked");
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be clicked");
		}

	}

	@Override
	public String getText(WebElement ele) {
		try {
			String text = ele.getText();
			System.out.println("The text of "+ele+" is "+text);
			return text;
		} catch (Exception e) {
			System.err.println("The text of "+ele+" is not available");
			return null;
		}
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			String text = ele.getText();
			if(ele.getText().equals(expectedText)) {
				System.out.println("The element "+ele+" has the exact text as "+expectedText);
			}
		} catch (Exception e) {
			System.err.println("The element "+ele+" is not having exact text as "+expectedText);
		}
		
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			String text = ele.getText();
			if(ele.getText().contains(expectedText)) {
				System.out.println("The element contains the text "+expectedText);
			}
		} catch (Exception e) {
			System.err.println("The element dis not contains the text "+expectedText);
		}	
		
	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			String attributevalue = ele.getAttribute(attribute);
			if(attribute.equals(value)) {
				System.out.println("The attribute "+attribute+" of element "+ele+" has the exact expected value "+value);
			}
		} catch (Exception e) {
			System.err.println("The attribute "+attribute+" of element "+ele+" is not having the exact expected value "+value);
		}
		
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			String attributevalue = ele.getAttribute(attribute);
			if(attribute.contains(value)) {
				System.out.println("The attribute "+attribute+" of element "+ele+" has the exact expected value "+value);
			}
		} catch (Exception e) {
			System.err.println("The attribute "+attribute+" of element "+ele+" is not having the exact expected value "+value);
		}

	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			ele.isSelected();
			System.out.println("The element "+ele+" is selected");
		} catch (Exception e) {
			System.err.println("The element "+ele+" is not selected");
		}
	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		try {
			ele.isDisplayed();
			System.out.println("The element "+ele+" is displayed");
		} catch (Exception e) {
			System.err.println("The element "+ele+" is not displayed");
		}

	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator.toLowerCase()) {
			case "id": return driver.findElement(By.id(locValue));
			case "name": return driver.findElement(By.name(locValue));
			case "link": return driver.findElement(By.linkText(locValue));
			case "class": return driver.findElement(By.className(locValue));
			case "tag": return driver.findElement(By.tagName(locValue));
			case "xpath": return driver.findElement(By.xpath(locValue));
			case "css": return driver.findElement(By.cssSelector(locValue));
			case "partial": return driver.findElement(By.partialLinkText(locValue));
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element could not be found for the locator "+locator+" with value "+locValue);
		}
		return null;

	}

	@Override
	public boolean verifyExactTitle(String expectedTitle) {
		try {
			String title = driver.getTitle();
			if(title.equals(expectedTitle)) {
				System.out.println("Browser title is the same as the expected title :"+expectedTitle);
			}
			return true;
		} catch (Exception e) {
			System.err.println("Browser title is not the same as the expected title :"+expectedTitle);
			return false;
		}
	}

	@Override
	public boolean verifyPartialTitle(String expectedTitle) {
		try {
			String title = driver.getTitle();
			if(title.contains(expectedTitle)) {
				System.out.println("Browser title contains the expected title :"+expectedTitle);
			}
			return true;
		} catch (Exception e) {
			System.err.println("Browser title does not contain the expected title :"+expectedTitle);
			return false;
		}	
	}

	@Override
	public void closeActiveBrowser() {
		try {
			driver.close();
			System.out.println("The active browser is closed");
		} catch (Exception e) {
			System.err.println("The active browser is closed");
		}

	}

	@Override
	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("All the opened browsers are closed");
		} catch (Exception e) {
			System.err.println("All the opened browsers are not closed");
		}

	}





}

package test.wa.automation.util;

import java.util.List;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AutoUtil {
	
	public WebElement GetWebElement(String path, WebDriver driver) {
		ByXPath xPath = new ByXPath(path);
		WebElement element = driver.findElement(xPath);
		
		return element;
	}
	
	/*
	 * WebElement를 리스트로 받는다.
	 */
	public List<WebElement> GetWebElementList(String path, WebDriver driver) {
		ByXPath xPath = new ByXPath(path);
		List<WebElement> elements = driver.findElements(xPath);
		
		return elements;
	}
	
	public void ClickAction(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).click().perform();
	}
	
	/*
	 * string 값을 필드에 입력한다.
	 */
	public void SendKeyAction(String path, WebDriver driver, String string) {
		ByXPath xPath = new ByXPath(path);
		new Actions(driver).sendKeys(driver.findElement(xPath), string).build().perform();
	}
	/*
	 * key 값을 필드에 입력한다. (ex - Keys.ENTER 엔터를 입력)
	 */
	public void SendKeyAction(String path, WebDriver driver, Keys key) {
		ByXPath xPath = new ByXPath(path);
		new Actions(driver).sendKeys(driver.findElement(xPath), key).build().perform();
	}
	/*
	 * key 값을 필드에 입력 후 String 값을 입력한다.
	 * 보통 key 부분에 Keys.chord(Keys.control, "a")를 입력하는데 이는 ctrl + a를 누르는 것과 같다.
	 */
	public void SendKeyAction(String path, WebDriver driver, String key, String text) {
		ByXPath xPath = new ByXPath(path);
		new Actions(driver).sendKeys(driver.findElement(xPath), key, text).build().perform();
	}
}

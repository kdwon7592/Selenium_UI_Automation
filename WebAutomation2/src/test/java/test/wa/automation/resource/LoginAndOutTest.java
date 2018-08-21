package test.wa.automation.resource;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import test.wa.automation.util.AutoUtil;

public class LoginAndOutTest {

	AutoUtil autoUtil = new AutoUtil();

	public void Promanager_Login(WebDriver driver) throws InterruptedException {
		/*
		 * 로그인
		 */
		ById id = new ById("input-id");
		ById pwd = new ById("input-password");

		new Actions(driver).sendKeys(driver.findElement(id), "admin").build().perform();
		Thread.sleep(1 * 1000);
		new Actions(driver).sendKeys(driver.findElement(pwd), "admin").build().perform();
		Thread.sleep(1 * 1000);

		WebElement element = autoUtil.GetWebElement("//top-button[@text=\"Login\"]", driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1000);

	}

	public void Promanager_Logout(WebDriver driver) throws InterruptedException {
		WebElement element = autoUtil.GetWebElement("//*[@id=\"logOut\"]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1000);

		element = autoUtil.GetWebElement("//top-button[@text=\"Login\"]", driver);
		assertEquals(element.getText(), "Login");
		Thread.sleep(1000);
	}
}

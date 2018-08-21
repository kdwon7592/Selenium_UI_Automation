package test.wa.automation.resource;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.wa.automation.util.AutoUtil;

public class NodeTest {

	AutoUtil autoUtil = new AutoUtil();
	
	public void Promanager_Node_Create(WebDriver driver) throws InterruptedException {
		/*
		 * Node 메뉴 버튼 클릭
		 */
		WebElement element = autoUtil.GetWebElement("//*[@id=\"lnb-menu\"]/div/div/ul/li[2]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1 * 1000);
				
		/*
		 * Node Management 클릭
		 */
		element = autoUtil.GetWebElement("//*[@id=\"lnb-menu\"]/div/div/ul/li[2]/ul/li/a", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1 * 1000);

		/*
		 * Create New Node 버튼 클릭
		 */
		element = autoUtil.GetWebElement("//button[@type=\"button\" and contains(.,\"Create New Node\")]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1 * 1000);
		/*
		 * Node 생성을 위한 입력값 입력
		 */
		autoUtil.SendKeyAction("//*[@id=\"nodeDiaName\" and @class=\"top-textfield-text\"]", driver, "test");
		autoUtil.SendKeyAction("//*[@id=\"nodeDiaIP\" and @class=\"top-textfield-text\"]", driver, "1234");
		autoUtil.SendKeyAction("//*[@id=\"nodeDiaFilePort\" and @class=\"top-textfield-text\"]", driver, "1234");
		autoUtil.SendKeyAction("//*[@id=\"nodeDiaHttpPort\" and @class=\"top-textfield-text\"]", driver, "1234");
		autoUtil.SendKeyAction("//*[@id=\"nodeDiaTcpPort\" and @class=\"top-textfield-text\"]", driver, "1234");
		Thread.sleep(1 * 1000);

		element = autoUtil.GetWebElement("//*[@id=\"nodeCreateBtn\"]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1 * 1000);

		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), "SUCCESS");
		alert.accept();

		Thread.sleep(1 * 1000);

	}

	public void Promanager_Node_Update(WebDriver driver) throws InterruptedException{		WebElement element = autoUtil.GetWebElement("//top-menu[@items=\"nodeManageItems.nodeActionItems\"]/div/div/a", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1*1000);

		element = autoUtil.GetWebElement("//top-menu[@items=\"nodeManageItems.nodeActionItems\"]/div/div/ul/li/a", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1*1000);
		
		/*
		 * Node 생성을 위한 입력값 입력
		*/
		autoUtil.SendKeyAction("//*[@id=\"nodeDiaName\" and @class=\"top-textfield-text\"]", driver, Keys.chord(Keys.CONTROL, "a"), "update");
		autoUtil.SendKeyAction("//*[@id=\"nodeDiaIP\" and @class=\"top-textfield-text\"]", driver, Keys.chord(Keys.CONTROL, "a"), "12345");
		autoUtil.SendKeyAction("//*[@id=\"nodeDiaFilePort\" and @class=\"top-textfield-text\"]", driver, Keys.chord(Keys.CONTROL, "a"), "12345");
		autoUtil.SendKeyAction("//*[@id=\"nodeDiaHttpPort\" and @class=\"top-textfield-text\"]", driver, Keys.chord(Keys.CONTROL, "a"), "12345");
		autoUtil.SendKeyAction("//*[@id=\"nodeDiaTcpPort\" and @class=\"top-textfield-text\"]", driver, Keys.chord(Keys.CONTROL, "a"), "12345");	
		Thread.sleep(1 * 1000);
		element = autoUtil.GetWebElement("//*[@id=\"nodeCreateBtn\"]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1 * 1000);

		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), "SUCCESS");
		alert.accept();

		Thread.sleep(1 * 1000);
	}
	
	public void Promanager_Node_Search(WebDriver driver) throws InterruptedException{
		autoUtil.SendKeyAction("//*[@id=\"filter_text\" and @class=\"top-textfield-text\"]", driver, "update");
		autoUtil.SendKeyAction("//*[@id=\"filter_text\" and @class=\"top-textfield-text\"]", driver, Keys.ENTER);	
		Thread.sleep(1*1000);
		WebElement element = autoUtil.GetWebElement("//*[@id=\"nodeManageTable\"]/div/div[2]/div[2]/table/tbody/tr[1]/td[1]", driver);
		assertEquals(element.getText(), "update");
	}
	
	public void Promanager_Node_Delete(WebDriver driver) throws InterruptedException{
		WebElement element = autoUtil.GetWebElement("//top-menu[@items=\"nodeManageItems.nodeActionItems\"]/div/div/a", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1*1000);
		element = autoUtil.GetWebElement("//top-menu[@items=\"nodeManageItems.nodeActionItems\"]/div/div/ul/li[2]/a", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1*1000);
		element = autoUtil.GetWebElement("//*[@id=\"nodeCreateBtn\"]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1 * 1000);

		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), "SUCCESS");
		alert.accept();
		Thread.sleep(1 * 1000);
	}
}
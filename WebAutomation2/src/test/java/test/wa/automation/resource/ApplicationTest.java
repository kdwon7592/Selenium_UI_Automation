package test.wa.automation.resource;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.wa.automation.util.AutoUtil;

public class ApplicationTest {
	AutoUtil autoUtil = new AutoUtil();
	
	
	public void Promanager_Application_Create(WebDriver driver) throws InterruptedException {
//		Create Application을 클릭한다.
		WebElement element = autoUtil.GetWebElement("//img[contains(@src,'img/dev/AddProject.svg')]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1000);
		
//		Application 정보를 입력한다. 
		autoUtil.SendKeyAction("//*[@id=\"app_dialog_physicalName\" and @class=\"top-textfield-text\"]", driver, "TestApp");
		autoUtil.SendKeyAction("//*[@id=\"app_dialog_logicalName\" and @class=\"top-textfield-text\"]", driver, "TestApp");
		autoUtil.SendKeyAction("//*[@id=\"app_dialog_package\" and @class=\"top-textfield-text\"]", driver, "com.test");
		autoUtil.SendKeyAction("//*[@id=\"app_dialog_description\" and @class=\"top-textarea-root\"]", driver, "Web UI Automation Test");
		Thread.sleep(1000);
		
//		ok 버튼을 클릭한다.
		element = autoUtil.GetWebElement("//*[@id=\"app_dialog_ok\"]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1000);
		
//		Application이 생성되었는지 확인한다.
		element = autoUtil.GetWebElement("//a[@class=\"top-textview-url\" and contains(.,\"TestApp\")]", driver);
		assertEquals(element.getText(), "TestApp");
	}
	
	public void Promanager_Application_Search(WebDriver driver) throws InterruptedException {
//		검색창에 Application 이름을 넣어준다.
		autoUtil.SendKeyAction("//*[@id=\"filter_text\"]", driver, "TestApp");
		autoUtil.SendKeyAction("//*[@id=\"filter_text\"]", driver, Keys.ENTER);
		Thread.sleep(1000);
		
//		검색 결과가 정상적으로 나왔는지 확인한다.
		WebElement element = autoUtil.GetWebElement("//a[@class=\"top-textview-url\" and contains(.,\"TestApp\")]", driver);
		assertEquals(element.getText(), "TestApp");
		Thread.sleep(1000);
	}
	
	public void Promanager_Application_Update(WebDriver driver) throws InterruptedException{
//		Edit 버튼을 클릭한다. 
		WebElement element = autoUtil.GetWebElement("//*[@class=\"overveiw-select-config\"]/div", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1000);
		
//		Edit 버튼 안의 Edit 버튼을 클릭한다.
		element = autoUtil.GetWebElement("//*[@class=\"top-selectbox-option option_0 active\" and contains(.,\"Edit\")]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1000);
		
//		Update 정보를 입력한다.
		autoUtil.SendKeyAction("//*[@id=\"app_dialog_logicalName\" and @class=\"top-textfield-text\"]", driver, Keys.chord(Keys.CONTROL, "a"), "update");
		autoUtil.SendKeyAction("//*[@id=\"app_dialog_package\" and @class=\"top-textfield-text\"]", driver, Keys.chord(Keys.CONTROL, "a"), "com.update");
		autoUtil.SendKeyAction("//*[@id=\"app_dialog_description\" and @class=\"top-textarea-root\"]", driver, "Application_Update");
		Thread.sleep(1000);
		
//		OK버튼을 클릭한다.
		element = autoUtil.GetWebElement("//*[@id=\"app_dialog_ok\"]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1000);
		
//		Update가 잘 되었는지 확인하기 위해 다시한번 Edit을 클릭한다. (이유는 Physical Name이 변경되지 않았기에 Logical Name을 확인하기 위해서 이다.)
		element = autoUtil.GetWebElement("//*[@class=\"overveiw-select-config\"]/div", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1000);
		
//		Edit버튼 안의 Edit 버튼을 클릭한다.
		element = autoUtil.GetWebElement("//*[@class=\"top-selectbox-option option_0 active\" and contains(.,\"Edit\")]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1000);
		
//		LogicalName의 값이 Update로 변경되었는지 확인한다.
		element = autoUtil.GetWebElement("//*[@id=\"app_dialog_logicalName\" and @class=\"top-textfield-text\"]", driver);
		assertEquals(element.getAttribute("value"),"update");
		Thread.sleep(1000);
		
//		확인이 되었으면 Ok 버튼을 클릭한다.
		element = autoUtil.GetWebElement("//*[@id=\"app_dialog_ok\"]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1000);
	}
	
	public void Promanager_Application_delete(WebDriver driver) throws InterruptedException {
//		Edit 버튼을 클릭한다. 
		WebElement element = autoUtil.GetWebElement("//*[@class=\"overveiw-select-config\"]/div", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1000);
		
//		Edit 버튼 안의 Delete 버튼을 클릭한다.
		element = autoUtil.GetWebElement("//*[@class=\"top-selectbox-option option_1\" and contains(.,\"Delete\")]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1000);
		
//		OK버튼을 클릭한다.
		element = autoUtil.GetWebElement("//*[@id=\"app_dialog_ok\"]", driver);
		autoUtil.ClickAction(driver, element);
		Thread.sleep(1000);
	}
}
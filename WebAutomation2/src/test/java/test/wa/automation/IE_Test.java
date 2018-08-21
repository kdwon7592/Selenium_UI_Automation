package test.wa.automation;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.wa.automation.resource.ApplicationTest;
import test.wa.automation.resource.LoginAndOutTest;
import test.wa.automation.resource.NodeTest;
import test.wa.automation.util.LoadConfig;

public class IE_Test {

	private static WebDriver driver;
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String IEDRIVER_FILE_PATH;
	LoginAndOutTest logInOut = new LoginAndOutTest();
	NodeTest nodeTest = new NodeTest();
	ApplicationTest appTest = new ApplicationTest();
	LoadConfig loadConfig = new LoadConfig();
	
	@BeforeClass
	public void setUp() throws Exception {
		// 크롬 드라이버 파일 경로
		IEDRIVER_FILE_PATH = "src/test/resources/webdriver/IEDriverServer.exe";
		
		System.setProperty("webdriver.ie.driver", IEDRIVER_FILE_PATH);
		
		driver = new InternetExplorerDriver();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get(loadConfig.getProperty("test"));
	}

	@Test(priority = 1)
	public void TC_AUTO_PROMANAGER_LOGIN() throws InterruptedException {
		logInOut.Promanager_Login(driver);
	}
	
	@Test(priority = 2)
	public void TC_AUTO_PROMANAGER_000() throws InterruptedException{
		appTest.Promanager_Application_Create(driver);
	}
	
	@Test(priority = 3)
	public void TC_AUTO_PROMANAGER_001() throws InterruptedException{
		appTest.Promanager_Application_Search(driver);
	}
	
	@Test(priority = 4)
	public void TC_AUTO_PROMANAGER_002() throws InterruptedException{
		appTest.Promanager_Application_Update(driver);
	}
	
	@Test(priority = 5)
	public void TC_AUTO_PROMANAGER_003() throws InterruptedException{
		appTest.Promanager_Application_delete(driver);
	}
	
	@Test(priority = 6)
	public void TC_AUTO_PROMANAGER_300() throws InterruptedException{
		nodeTest.Promanager_Node_Create(driver);
	}
	
	@Test(priority = 7)
	public void TC_AUTO_PROMANAGER_301() throws InterruptedException{
		nodeTest.Promanager_Node_Update(driver);
	}
	
	@Test(priority = 8)
	public void TC_AUTO_PROMANAGER_302() throws InterruptedException{
		nodeTest.Promanager_Node_Search(driver);
	}
	
	@Test(priority = 9)
	public void TC_AUTO_PROMANAGER_303() throws InterruptedException{
		nodeTest.Promanager_Node_Delete(driver);
	}
	
	@Test(priority = 10)
	public void TC_AUTO_PROMANAGER_LOGOUT() throws InterruptedException{
		logInOut.Promanager_Logout(driver);
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.close(); // driver.quit() 사용시 오류나는 경우 있음
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}

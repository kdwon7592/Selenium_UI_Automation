package test.wa.automation;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.wa.automation.resource.ApplicationTest;
import test.wa.automation.resource.LoginAndOutTest;
import test.wa.automation.resource.NodeTest;
import test.wa.automation.util.LoadConfig;

public class ChromeTest {

	private static WebDriver driver;
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String CHROMEDRIVER_FILE_PATH;
	LoginAndOutTest logInOut = new LoginAndOutTest();
	NodeTest nodeTest = new NodeTest();
	ApplicationTest appTest = new ApplicationTest();
	LoadConfig loadConfig = new LoadConfig();

	@BeforeClass
	public void setUp() throws Exception {
		// 크롬 드라이버 파일 경로
		CHROMEDRIVER_FILE_PATH = "src/test/resources/webdriver/chromedriver_win.exe";
		ChromeOptions options = new ChromeOptions();
//		 options.addArguments("--headless");// 리눅스 서버에서는 화면이 존재하지 않기때문에 Headless를 통해서
		// 창을 띄우지 않고, 화면을 그려주는 렌더링을 통해 실제 브라우저와 동일하게 동작.
		options.addArguments("--window-size=1920,1080");
		
		System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_FILE_PATH);
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get(loadConfig.getProperty("test"));
	}

	@Test(priority = 1)
	public void TC_AUTO_MANAGER_LOGIN() throws InterruptedException {
		logInOut.manager_Login(driver);
	}
	
	@Test(priority = 2)
	public void TC_AUTO_MANAGER_000() throws InterruptedException{
		appTest.manager_Application_Create(driver);
	}
	
	@Test(priority = 3)
	public void TC_AUTO_MANAGER_001() throws InterruptedException{
		appTest.manager_Application_Search(driver);
	}
	
	@Test(priority = 4)
	public void TC_AUTO_MANAGER_002() throws InterruptedException{
		appTest.manager_Application_Update(driver);
	}
	
	@Test(priority = 5)
	public void TC_AUTO_MANAGER_003() throws InterruptedException{
		appTest.manager_Application_delete(driver);
	}
	
	@Test(priority = 6)
	public void TC_AUTO_MANAGER_300() throws InterruptedException{
		nodeTest.manager_Node_Create(driver);
	}
	
	@Test(priority = 7)
	public void TC_AUTO_MANAGER_301() throws InterruptedException{
		nodeTest.manager_Node_Update(driver);
	}
	
	@Test(priority = 8)
	public void TC_AUTO_MANAGER_302() throws InterruptedException{
		nodeTest.manager_Node_Search(driver);
	}
	
	@Test(priority = 9)
	public void TC_AUTO_MANAGER_303() throws InterruptedException{
		nodeTest.manager_Node_Delete(driver);
	}
	
	@Test(priority = 10)
	public void TC_AUTO_MANAGER_LOGOUT() throws InterruptedException{
		logInOut.manager_Logout(driver);
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

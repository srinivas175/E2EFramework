package com.java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import com.java.objects.ResultDetails;

public class AppTestType {

	Robot robot;
	String folderStructure = System.getProperty("user.dir");
	String downloadFilepath = folderStructure + "/../Reports";
	String autoItfilespath = folderStructure + "/../Framework";
	File file;
	public static HSSFWorkbook myExcelBook;
	public static HSSFSheet myExcelSheet;	
	public static String paramName;
	public static String paramValue;
	public static String newTestEmailID;
	public static String testDataSource;
	public static String firstName;
	public static String lastName;
	public static String newEmailID;

	public enum AppKeyWords {
		WAITFORFRAME,
		SELECTDEFAULTFRAME,
		JCLICK,
		JDBLCLICK,
		JENTERINPUT,
		CLEARCOOKIES,
		CHROMECLEARCACHE,		
		SCROLLDOWN,		
		MOBILEWEBSCROLLDOWN,
		ENTERSTOREDVALUE,
		SELECTWITHINDEX,
		ENTERRANDOMID,
		STORETEXTBOXVALUE,		
		CREATENEWEMAIL,		
		ACCEPTALERT,
		DISCOUNTBYVALUE,
		DISCOUNTBYVALUE1,
		DISCOUNTBY50PERCENT,
		DISCOUNTBY50PERCENT1,
		DISCOUNTBY100PERCENT,
		SELECTBYTEXT,
		VERIFY50PERCENTAPPLIED,
		SMILEPAY50PERCENTDISCOUNT,		
		SMILEPAYDISCOUNTBYVALUE,
		VERIFYSMILEPAYCFDISCOUNT,		
		KLARNA10PERCENTDISCOUNT,
		KLARNADISCOUNTBYVALUE,
		VERIFYKLARNACFDISCOUNT,
		ENTERFIRSTNAME,
		ENTERLASTNAME,		
		DBLCLICK,
		ENTERPASTDATE,
		RYADAY,
		RYAMONTH,
		RYAYEAR,
		RYADAY1,
		RYAMONTH1,
		RYAYEAR1,
		VERIFYTEXT,
		VERIFYTBOXVALUE,
		VERIFYLBLTEXT,		
		SMILEETA,
		SMILEETA1,
		SMILEETA2,
		CURRENTDATE,
		TODAY,
		ENDDATE,
		CURRENTDATE1,
		ENDDATE1,
		ENDDATE2,
		MOBILEINPUT,
		HIDEKEYPAD,
		MOBILEEMAIL,		
		CLICKONTEXT,
		ENTERRYKCODE,		
		ELEMENTNOTPRESENT,
		CHECKCHECKBOX,
		VERIFYEMAILEXISTS,		
		CHROMEMOBILEVIEW,		
		VERIFYURL,
		/*VERIFYKEYBOARDISPRESENT,*/
		CLOSECHILDWINDOW,
		CHILDWINDOW,
		HANDLEFRIENDLYBUY,
		CAPTURESCREEN,
		
		AUTOITFILEUPLOAD,
		STOREOUTERVALUE,
				
		KEYBOARDENTER,
		IMAGECOMPARE,		
	
		CLICKONPATIENTNAME,		
		CLICKONDATE,		
		SELECTFROMDD,
		SWITCHCONTEXT,
		DEVICESCROLLDOWN,				
		DDSELECT		
	};

	TestType tt;

	public AppTestType(TestType tt) {
		this.tt = tt;
	}

	Properties properties;
	public static ResultDetails resultDetails = new ResultDetails();

	public ResultDetails performAction(WebDriver webdriver, String fieldText,
			String value, String action, String fieldName) {

		try {

			AppKeyWords keys = AppKeyWords.valueOf(action.toUpperCase());

			switch (keys) {				
			case DEVICESCROLLDOWN:
				deviceScrollDown(webdriver,value);
				break;
				
			case IMAGECOMPARE:
				ImageCompare();
				break;
				
			case MOBILEWEBSCROLLDOWN:
				mobileWebScrollDown(webdriver,fieldText);
				break;
				
			case SWITCHCONTEXT:
				switchContext(webdriver,value);
				break;
				
			case SELECTWITHINDEX:
				selectWithIndex(webdriver,fieldText,value,action,fieldName);
				break;
				
			case CAPTURESCREEN:
				captureScreen(webdriver,value);
				break;
				
			case ELEMENTNOTPRESENT:
				elementNotPresent(webdriver,fieldText);
				break;
				
			/*
			case VERIFYKEYBOARDISPRESENT:
				verifyKeyBoardIsPresent(webdriver);
				break;
				*/
							
			case VERIFYEMAILEXISTS:
				verifyEmailExists(webdriver);
				break;
				
			case CHILDWINDOW:
				childWindow(webdriver);
				break;
				
			case CLOSECHILDWINDOW:
				closeChildWindow(webdriver);
				break;
				
			case MOBILEINPUT:
				mobileInput(webdriver,fieldText,value);
				break;
				
			case CHROMEMOBILEVIEW:
				ChromeMobileView(webdriver,value);
				break;
				
			case VERIFYURL:
				verifyURL(webdriver,value);
				break;				
				
			case MOBILEEMAIL:
				mobileEmail(webdriver,fieldText);
				break;
			
			case HANDLEFRIENDLYBUY: 	
				handleFriendlyBuy(webdriver,fieldText);
				break;
				
			case SMILEETA:
				smileETA(value);
				break;
				
			case SMILEETA1:
				smileETA1(value);
				break;
				
			case SMILEETA2:
				smileETA2(value);
				break;
				
			case CURRENTDATE:
				currentDate(value);
				break;
				
			case ENDDATE:
				endDate(value);
				break;
			
			case CURRENTDATE1:
				currentDate1(value);
				break;
				
			case ENDDATE1:
				endDate1(value);
				break;
				
			case ENDDATE2:
				endDate2(value);
				break;
				
			case VERIFYTEXT:
				verifyText(webdriver,fieldText,value,action,fieldName);
				break;
				
			case CHECKCHECKBOX:
				checkCheckBox(webdriver,fieldText);
				break;
				
			case HIDEKEYPAD:
				hideKeyPad(webdriver);
				break;				
				
			case VERIFYTBOXVALUE:
				verifyTboxValue(webdriver,fieldText,value,action,fieldName);
				break;							
				
			case VERIFYLBLTEXT:
				verifylblText(webdriver,fieldText,value,action,fieldName);
				break;
				
			case DDSELECT:
				ddSelect(webdriver,fieldText,value,action,fieldName);
				break;
				
			case ENTERRYKCODE:
				enterRykCode(webdriver,fieldText,value);
				break;
				
			case SELECTFROMDD:
				selectFromDD(webdriver,fieldText,value,action,fieldName);
				break;

			case JCLICK:
				Jclick(webdriver, fieldText);				
				break;
				
			case JDBLCLICK:
				JDblClick(webdriver,fieldText,value,action,fieldName);				
				break;
				
			case JENTERINPUT:
				JEnterInput(webdriver,fieldText,value,action,fieldName);				
				break;

			case CLEARCOOKIES:

				clearCookies(webdriver);

				resultDetails.setFlag(true);
				break;
				
			case CHROMECLEARCACHE:
				chromeClearCache(webdriver);				
				break;							

			case SELECTDEFAULTFRAME:

				webdriver.switchTo().defaultContent();

				resultDetails.setFlag(true);
				break;
			

			case WAITFORFRAME:
				if (value.isEmpty()) {
					value = "20";
				}

				WebDriverWait wait = new WebDriverWait(webdriver,
						Integer.parseInt(value));
				wait.until(ExpectedConditions
						.presenceOfAllElementsLocatedBy((By.xpath(fieldText))));
				resultDetails.setFlag(true);

				break;
				
			case ENTERSTOREDVALUE:
				enterstoredvalue(webdriver, fieldText, value, action, fieldName);
				break;
				
			case STORETEXTBOXVALUE:
				storeTextboxValue(webdriver, fieldText, value, action, fieldName);
				break;			
				
			case CREATENEWEMAIL:
				createNewEmail(webdriver, fieldText, action, fieldName);
				break;			
				
			case ACCEPTALERT:
				acceptAlert(webdriver, action, fieldName);
				break;			
				
			case DISCOUNTBYVALUE:
				discountByValue(webdriver, action, fieldName);
				break;
				
			case DISCOUNTBYVALUE1:
				discountByValue1(webdriver, action, fieldName);
				break;
				
			case DISCOUNTBY50PERCENT:
				discountBy50Percent(webdriver, action, fieldName);
				break;
				
			case DISCOUNTBY50PERCENT1:
				discountBy50Percent1(webdriver, action, fieldName);
				break;
				
			case DISCOUNTBY100PERCENT:
				discountBy100Percent(webdriver, value, action, fieldName);
				break;
				
			case SELECTBYTEXT:
				selectByText(webdriver, fieldText, value, action, fieldName);
				break;
				
			case VERIFY50PERCENTAPPLIED:
				verify50PercentApplied(webdriver, action, fieldName);
				break;

			case SMILEPAY50PERCENTDISCOUNT:
				smilePay50PercentDiscount(webdriver, action, fieldName);
				break;
				
			case SMILEPAYDISCOUNTBYVALUE:
				smilePayDiscountByValue(webdriver, action, fieldName);
				break;
				
			case VERIFYSMILEPAYCFDISCOUNT:
				verifySmilePayCFDiscount(webdriver, action, fieldName);
				break;			
				
			case KLARNA10PERCENTDISCOUNT:
				klarna10PercentDiscount(webdriver, action, fieldName);
				break;
				
			case KLARNADISCOUNTBYVALUE:
				klarnaDiscountByValue(webdriver, action, fieldName);
				break;
				
			case VERIFYKLARNACFDISCOUNT:
				verifyKlarnaCFDiscount(webdriver, action, fieldName);
				break;
				
			case ENTERFIRSTNAME:
				enterFirstName(webdriver, fieldText, action, fieldName);
				break;
				
			case ENTERLASTNAME:
				enterLastName(webdriver, fieldText, action, fieldName);
				break;			
				
			case DBLCLICK:
				dblClick(webdriver, fieldText, value, action, fieldName);
				break;
				
			case ENTERPASTDATE:
				enterPastDate(webdriver, fieldText);
				break;
				
			case TODAY:
				toDay(webdriver, fieldText);
				break;	
				
			case RYADAY:
				ryaDay(webdriver, fieldText);
				break;
			
			case RYAMONTH:
				ryaMonth(webdriver, fieldText);
				break;
				
			case RYAYEAR:
				ryaYear(webdriver, fieldText);
				break;
				
			case RYADAY1:
				ryaDay1(webdriver, fieldText);
				break;
			
			case RYAMONTH1:
				ryaMonth1(webdriver, fieldText);
				break;
				
			case RYAYEAR1:
				ryaYear1(webdriver, fieldText);
				break;
								
			case SCROLLDOWN:
				scrollDown(webdriver, fieldText);
				break;					
						
			case AUTOITFILEUPLOAD:
				autoItFileUpLoad(webdriver, fieldText, value, action, fieldName);
				break;
				
			case ENTERRANDOMID:
				enterRandomID(webdriver, fieldText, value, action, fieldName);
				break;
			
			case STOREOUTERVALUE:
				try {
					tt.driver.hMap.put(fieldText, getTestData(value));
					resultDetails.setFlag(true);
				} catch (Exception e) {
					resultDetails.setFlag(false);
				}

				break;
				
			case KEYBOARDENTER:
				try
				{
				WebElement element = webdriver.findElement(By.xpath(fieldText));
				element.sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				resultDetails.setFlag(true);

				}catch (Exception ex) {
				resultDetails.setFlag(false);
				ex.printStackTrace();
				}
				break;

				
			case CLICKONPATIENTNAME:
				CLICKONPATIENTNAME(webdriver, fieldText, value, action, fieldName);
				break;
				
			case CLICKONTEXT:
				clickOnText(webdriver, fieldText, value, action, fieldName);
				break;
						
			case CLICKONDATE:
				clickONDate(webdriver,fieldText,value,action,fieldName);
				break;			

			}

		} catch (IllegalArgumentException e) {
			resultDetails.setErrorMessage(" Unable to find keyword " + action
					+ "in AppTestType");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			resultDetails.setErrorMessage(" Exception in executing the action "
					+ action);
			System.out.println(e.getMessage());
		}
		return resultDetails;
	}
	
	private void deviceScrollDown(WebDriver webdriver, String fieldText) {		
		try {
			System.out.println("Step1");
			WebElement elescr = getWebElement(webdriver, fieldText);
			System.out.println("Step2");
			JavascriptExecutor js = (JavascriptExecutor) ((AppiumDriver)((RemoteWebDriver)webdriver));
			System.out.println("Step3");
			HashMap scrollObjects = new HashMap();
			System.out.println("Step4");		
			scrollObjects.put("direction", "down");
			System.out.println("Step5");
			scrollObjects.put("element", ((RemoteWebElement) elescr).getId());
			System.out.println("Step6");
			js.executeScript("mobile: scrollTo", scrollObjects);
			System.out.println("Step7");
			Thread.sleep(1000);
			System.out.println("Step8");
			resultDetails.setFlag(true);
		} catch (InterruptedException e) {
			resultDetails.setFlag(false);
			e.printStackTrace();
		}
	}
	
	private void mobileWebScrollDown(WebDriver webdriver, String fieldText) {		
		try {			
			WebElement elescr = getWebElement(webdriver, fieldText);
			
			int scrollCount = 1;
			do {
				//System.out.println("Scroll Count: " + scrollCount);
				if(elescr.isDisplayed()) {
					System.out.println("Found the element");
					//JavascriptExecutor js = (JavascriptExecutor) webdriver;
					//js.executeScript("arguments[0].click();", elescr);				
					scrollCount = 101;
				}
				else {
					webdriver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
				}
				scrollCount++;
			} while (scrollCount <= 100);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void hideKeyPad(WebDriver webdriver) {
		try {
			((AppiumDriver)((RemoteWebDriver)webdriver)).hideKeyboard();				
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void scrollDown(WebDriver webdriver, String fieldText) {
		try {			
			WebElement elescr = getWebElement(webdriver, fieldText);
				
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView(true);", elescr);			
			Thread.sleep(3000);
				
			resultDetails.setFlag(true);

		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}	
	
	private void switchContext(WebDriver webdriver, String value) {
		String data = getTestData(value);
		try{
			System.out.println("Switching to "+data+" App");
			//tt.driver.log.info("Switching to "+data+" App");
			boolean ViewFound = false;
			Set<String> contextNames = ((AppiumDriver)((RemoteWebDriver)webdriver)).getContextHandles();
			for (String contextName : contextNames) {
				System.out.println(contextName);
				if (contextName.contains(data)){
					ViewFound=true;
					((AppiumDriver)((RemoteWebDriver)webdriver)).context(contextName);
					resultDetails.setFlag(true);
				}
			}
			if(!ViewFound)
			{
				System.out.println("Could not found "+data+" App in the page");
				System.out.println("Found: "+contextNames+" in the page");
				//tt.driver.log.error("Could not found "+data+" App in the page");
				//tt.driver.log.error("Found: "+contextNames+" in the page");
				resultDetails.setFlag(false);
			}			
		}catch(Exception e)
		{
			System.out.println("Unable to Switch to "+data+" App");
			System.out.println(e.getMessage());
			//tt.driver.log.info("Unable to Switch to "+data+" App");
			//tt.driver.log.error(e.getMessage());
			resultDetails.setFlag(false);
		}
	}
	
	
	private void captureScreen(WebDriver webdriver, String value) {		
		SimpleDateFormat sdfDate = new SimpleDateFormat("MMddyy");//dd/MM/yyyy
		Date now = new Date();
		Date date = new Date();   // given date
		Calendar calendar = Calendar.getInstance(); // creates a new calendar instance
		calendar.setTime(date);   // assigns calendar to given date 
		String strDate = sdfDate.format(now);
		String str = value;
		String[] arrOfStr = str.split("_", 2);
		String caseName = arrOfStr[0];
		String stepNo = arrOfStr[1];
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		try {		
			File scrFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/../../media/CompareImages/" + caseName + "_" + strDate + "_" + hours + minutes + "/" + value + "_" + System.currentTimeMillis() + ".png"));
			System.out.println("Screenshot captured sucessfully.");
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
		
		callCompareAPI(caseName, stepNo);
		callImgSaveAPI();
	}
	
	private static HttpURLConnection con;
	
	private void callCompareAPI(String casename, String stepno) {
		// call API

        String url = "http://127.0.0.1:8000/api/upload/test_suite/";
        String urlParameters = "step_no="+stepno+"&case_no="+casename;
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Java client");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postData);
            }

            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }

            System.out.println(content.toString());

        }catch(Exception e)
		{
			System.out.println("Got an Error");
		}finally {
            
            con.disconnect();
        }
    }
	
	private void callImgSaveAPI() {
		// call API
		try{
			URL url = new URL("http://127.0.0.1:8000/api/upload/res_image/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : "
						+ conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();
		
		} catch (Exception e) {
		System.out.println("Exception in NetClientGet:- " + e);
		}
    }
	
	private void selectWithIndex(WebDriver webdriver, String fieldText, String value, String action, String fieldName) {
		String obj = "";
		
		if (fieldText.substring(3,fieldText.length()).startsWith("obj:")) {
		
		obj = fieldText.toLowerCase();
		String temp = obj.substring(7);
		
		obj =tt.driver.objRepo.getProperty(temp,temp);
		
		System.out.println(" Field = " + obj);
		}else if(fieldText.startsWith("//")){
			obj = fieldText;
		}else if(fieldText.substring(3,fieldText.length()).startsWith("//")){
			obj = fieldText.substring(3, fieldText.length());
		}	
		
		//String fieldLocator = fieldText.substring(3, fieldText.length());
		try {		
			
			By locator = WebDriverUtils.locatorToByObj(webdriver, obj);
			WebElement ele= webdriver.findElement(locator);
			ele.click();
			
			Select ddList = new Select(ele);
			ddList.selectByIndex(Integer.parseInt(value.trim()));
									
			//System.out.println(tt.driver.hMap.get(value));
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
				
	}
	
	private void ImageCompare() {
		try {			
			String command = "cmd /c python D:/GitHub/praveen/invoke.py";
			Process p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader brInputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader brErrorStream = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String line;
			while ((line = brInputStream.readLine()) != null) {
				System.out.println(line);
			}
			brInputStream.close();
			while ((line = brErrorStream.readLine()) != null) {
				System.out.println(line);
			}
			brErrorStream.close();
			p.waitFor();
			System.out.println("Done.");

			p.destroy();
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
		
	}
	
	
	private void handleFriendlyBuy(WebDriver webdriver, String fieldText) {
		try {
			WebElement myFrame = null;
			WebElement ele = null;
			try {
				myFrame = webdriver.findElement(By.id("fbuy_iFrameResizer"));
				webdriver.switchTo().frame(myFrame);
			} catch (Exception ex) {
				System.out.println("Did not find Friendly Buy Popup");
			}
			
			if (webdriver.findElements(By.xpath("//h1[contains(text(),'Get $100 when your')]")).size() != 0) {				
				System.out.println("Found Friendly Buy Popup");
				webdriver.switchTo().defaultContent();
				ele = getWebElement(webdriver, fieldText);				
				((JavascriptExecutor)webdriver).executeScript("arguments[0].click();", ele);								
			}
			else {
				System.out.println("Did not find Friendly Buy Popup");
			}
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void clickONDate(WebDriver webdriver, String fieldText, String value, String action, String fieldName) {
		try{
			String locator = "//h5/following-sibling::div[2]//following::div[@class='scanshop-day ' and @data-index='" + value.trim() +"']";

			WebElement date = webdriver.findElement(By.xpath(locator));
			((JavascriptExecutor)webdriver).executeScript("arguments[0].click();", date);
			//date.click();
			
			resultDetails.setFlag(true);
		}
		catch(Exception e){
			e.printStackTrace();
			resultDetails.setFlag(false);
		}
				
	}
	
	private void closeChildWindow(WebDriver webdriver) {				
		try{
			webdriver.close();			
			resultDetails.setFlag(true);
		}catch(Exception e){
			e.printStackTrace();
			resultDetails.setFlag(false);
		}
	}
	
	private void childWindow(WebDriver webdriver) {				
		try{
			String parentWindow = webdriver.getWindowHandle();			
		
			for (String myWindow : webdriver.getWindowHandles() ) {
				if(!myWindow.equals(parentWindow)) {
					webdriver.switchTo().window(myWindow);									
				}
			}
			
			resultDetails.setFlag(true);
		}catch(Exception e){
			e.printStackTrace();
			resultDetails.setFlag(false);
		}
	}
	
	private void clickOnText(WebDriver webdriver, String fieldText, String value, String action,	String fieldName) {
		String textToClick = getTestData(value);
			//String fname = getTestData("dt:firstname#1");
			//String lname = getTestData("dt:lastname#1");
		
		try{
			String locator = "//*[contains(text(),'"+ textToClick +"')]";
			getWebElement(webdriver, locator).click();
			resultDetails.setFlag(true);
			
		}catch(Exception e){
			e.printStackTrace();
			resultDetails.setFlag(false);
		}
	}

	private void CLICKONPATIENTNAME(WebDriver webdriver, String fieldText, String value, String action,	String fieldName) {
			//String fname = firstname;
			//String fname = getTestData("dt:firstname#1");
			//String lname = getTestData("dt:lastname#1");
		System.out.println("First Name is:" + firstName);
		
		try{
			String locator = "//*[contains(text(),'"+ firstName +"')]";			
			getWebElement(webdriver, locator).click();
			resultDetails.setFlag(true);
			
		}catch(Exception e){
			e.printStackTrace();
			resultDetails.setFlag(false);
		}
		
	}
	
	/*
	private void verifyKeyBoardIsPresent(WebDriver webdriver) {		
		try {
			boolean keyboardShown = ((AppiumDriver)((RemoteWebDriver)webdriver)).isKeyboardShown();	
			if(keyboardShown) {
				System.out.println("Keyboard is Shown on Device.");
				resultDetails.setFlag(true);
			} else {
				System.out.println("Keyboard is Shown on Device.");
				resultDetails.setFlag(false);
			}
		} catch(Exception e){
			e.printStackTrace();
			resultDetails.setFlag(false);
		}
	}
	*/
	
	private void verifyEmailExists(WebDriver webdriver) {		
		try {
			String locator = "//*[contains(text(),'"+ newEmailID +"')]";
			List<WebElement> emailId = webdriver.findElements(By.xpath(locator));
			if(emailId.size() > 0) {
				System.out.println("Found Email id: " + newEmailID);
				resultDetails.setFlag(true);
			} else {
				System.out.println("Did not Find Email id: " + newEmailID);
				resultDetails.setFlag(false);
			}
		} catch(Exception e){
			e.printStackTrace();
			resultDetails.setFlag(false);
		}
	}

	private void clearCookies(WebDriver webdriver) {
		// TODO Auto-generated method stub

		try {
			webdriver.manage().deleteAllCookies();
			resultDetails.setFlag(true);
		} catch (Exception e) {
			e.printStackTrace();
			resultDetails.setFlag(false);
		}

	}
	
	private void chromeClearCache(WebDriver webdriver) {
		try {			
			webdriver.get("chrome://settings/clearBrowserData");
			webdriver.findElement(By.cssSelector("* /deep/ #clearBrowsingDataConfirm")).click();
			Thread.sleep(3000);
			resultDetails.setFlag(true);
		} catch (Exception e) {
			e.printStackTrace();
			resultDetails.setFlag(false);
		}

	}	

	private void JEnterInput(WebDriver webdriver, String fieldText, String value, String action, String fieldName) {
		// TODO Auto-generated method stub
		WebElement ele = null;
		try {
			ele = getWebElement(webdriver, fieldText);
			String data = getTestData(value);
			JavascriptExecutor js = (JavascriptExecutor) webdriver;
			js.executeScript("arguments[0].value='"+data+"';", ele);			
			resultDetails.setFlag(true);
		} catch (Exception e) {
			e.printStackTrace();
			resultDetails.setFlag(false);
		}

	}
	
	private void Jclick(WebDriver webdriver, String fieldText) {
		// TODO Auto-generated method stub
		WebElement ele = null;
		try {
			ele = getWebElement(webdriver, fieldText);
			JavascriptExecutor js = (JavascriptExecutor) webdriver;
			js.executeScript("arguments[0].click();", ele);			
			resultDetails.setFlag(true);
		} catch (Exception e) {
			e.printStackTrace();
			resultDetails.setFlag(false);
		}

	}
	
	private void enterPastDate(WebDriver webdriver, String fieldText) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String presentDate = dateFormat.format(date);        
			//System.out.println("Present Date: " + presentDate);

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -8);
			Date presentDate1 = cal.getTime();    
			String pastDate = dateFormat.format(presentDate1);
			//System.out.println("Past Date: " + pastDate);
			
			WebElement ele = getWebElement(webdriver, fieldText);
			ele.clear();
			ele.sendKeys(pastDate);
			
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void verifyURL(WebDriver webdriver, String value) {					
		try {									
			String currentUrl = webdriver.getCurrentUrl();
			String expectedUrl = getTestData(value);
			
			if(currentUrl.startsWith(expectedUrl)) {
				System.out.println("On Same url");
				resultDetails.setFlag(true);
			}
			else {
				System.out.println("On Different url");
				resultDetails.setFlag(false);
			}					
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	private WebDriver ChromeMobileView(WebDriver webdriver, String value) {
		try {
			String data = getTestData(value);
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", data);
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			webdriver.quit();

			webdriver = new ChromeDriver(chromeOptions);			
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
		return webdriver;
	}
	
	private void toDay(WebDriver webdriver, String fieldText) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			Date date = new Date();
			String presentDate = dateFormat.format(date);        
			//System.out.println("Present Date: " + presentDate);
			
			WebElement ele = getWebElement(webdriver, fieldText);
			ele.clear();
			ele.sendKeys(presentDate);
			
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void ryaDay(WebDriver webdriver, String fieldText) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date date = new Date();
			String presentDate = dateFormat.format(date);        
			//System.out.println("Present Date: " + presentDate);
			
			WebElement ele = getWebElement(webdriver, fieldText);
			ele.clear();
			ele.sendKeys(presentDate);
			
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void ryaMonth(WebDriver webdriver, String fieldText) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM");
			Date date = new Date();
			String presentDate = dateFormat.format(date);        
			//System.out.println("Present Date: " + presentDate);
			
			WebElement ele = getWebElement(webdriver, fieldText);
			ele.clear();
			ele.sendKeys(presentDate);
			
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void ryaYear(WebDriver webdriver, String fieldText) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy");
			Date date = new Date();
			String presentDate = dateFormat.format(date);        
			//System.out.println("Present Date: " + presentDate);			
			
			WebElement ele = getWebElement(webdriver, fieldText);
			ele.clear();
			ele.sendKeys(presentDate);
			
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void ryaDay1(WebDriver webdriver, String fieldText) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -7);
			Date date = cal.getTime();
			String presentDate = dateFormat.format(date);        
			//System.out.println("Present Date: " + presentDate);
			
			WebElement ele = getWebElement(webdriver, fieldText);
			ele.clear();
			ele.sendKeys(presentDate);
			
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void ryaMonth1(WebDriver webdriver, String fieldText) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -7);
			Date date = cal.getTime();
			String presentDate = dateFormat.format(date);        
			//System.out.println("Present Date: " + presentDate);
			
			WebElement ele = getWebElement(webdriver, fieldText);
			ele.clear();
			ele.sendKeys(presentDate);
			
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void ryaYear1(WebDriver webdriver, String fieldText) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -7);
			Date date = cal.getTime();			
			String presentDate = dateFormat.format(date);        
			//System.out.println("Present Date: " + presentDate);			
			
			WebElement ele = getWebElement(webdriver, fieldText);
			ele.clear();
			ele.sendKeys(presentDate);
			
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void currentDate(String value) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MMMMM d, yyyy");
			
			Calendar cal = Calendar.getInstance();			
			Date presentDate1 = cal.getTime();    
			String curDate = dateFormat.format(presentDate1);
			System.out.println("Current Date is: " + curDate);
						
			tt.driver.hMap.put(value, curDate);
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	private void currentDate1(String value) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MMMMM d, yyyy");
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -7);
			Date presentDate1 = cal.getTime();    
			String curDate = dateFormat.format(presentDate1);
			System.out.println("Current Date is: " + curDate);
						
			tt.driver.hMap.put(value, curDate);
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	private void smileETA(String value) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd");
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, +392);
			Date presentDate1 = cal.getTime();    
			String etaDate = dateFormat.format(presentDate1);
			System.out.println("ETA Date is: " + etaDate);
						
			tt.driver.hMap.put(value, etaDate);
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	private void smileETA1(String value) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd");
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, +385);
			Date presentDate1 = cal.getTime();    
			String etaDate = dateFormat.format(presentDate1);
			System.out.println("ETA Date is: " + etaDate);
						
			tt.driver.hMap.put(value, etaDate);
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	private void smileETA2(String value) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd");
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, +14);
			Date presentDate1 = cal.getTime();    
			String etaDate = dateFormat.format(presentDate1);
			System.out.println("ETA Date is: " + etaDate);
						
			tt.driver.hMap.put(value, etaDate);
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	private void endDate(String value) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MMMMM d, yyyy");
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, +392);			
			Date presentDate1 = cal.getTime();    
			String lastDate = dateFormat.format(presentDate1);
			System.out.println("Current Date is: " + lastDate);
						
			tt.driver.hMap.put(value, lastDate);
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	private void endDate1(String value) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MMMMM d, yyyy");
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, +385);			
			Date presentDate1 = cal.getTime();    
			String lastDate = dateFormat.format(presentDate1);
			System.out.println("Current Date is: " + lastDate);
						
			tt.driver.hMap.put(value, lastDate);
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	private void endDate2(String value) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MMMMM d, yyyy");
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, +14);			
			Date presentDate1 = cal.getTime();    
			String lastDate = dateFormat.format(presentDate1);
			System.out.println("Current Date is: " + lastDate);
						
			tt.driver.hMap.put(value, lastDate);
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	private void enterRykCode(WebDriver webdriver, String fieldText, String value) throws FileNotFoundException, IOException {
		WebElement ele = getWebElement(webdriver, fieldText);
		String sheetName = getTestData(value);
		try {
			int rowNo = 0;
			String testInputFile = System.getProperty("user.dir") + "/../TestInputs/RetailKit.xls";
	        FileInputStream file = new FileInputStream(new File(testInputFile));
	        myExcelBook = new HSSFWorkbook(file);
	        myExcelSheet = myExcelBook.getSheet(sheetName);
	        if (myExcelSheet == null) {
	            System.out.println(sheetName + "Sheet does not exist");
	        }
	        
	        String retailKit = myExcelSheet.getRow(0).getCell(0).toString();
			System.out.println("code is: " + retailKit);
			ele.sendKeys(retailKit);
			
	        int lastRowNum = myExcelSheet.getLastRowNum();
	        if (rowNo >= 0 && rowNo < lastRowNum) {
	        	myExcelSheet.shiftRows(rowNo + 1, lastRowNum, -1);
	        }
	        
	        if (rowNo == lastRowNum) {
	        	HSSFRow removingRow = myExcelSheet.getRow(rowNo);
	            if(removingRow != null) {
	            	myExcelSheet.removeRow(removingRow);
	            }
	        }
	        file.close();
	        FileOutputStream outFile = new FileOutputStream(new File(testInputFile));
	        myExcelBook.write(outFile);
	        outFile.close();
			
			resultDetails.setFlag(true);			
	    } catch(Exception ex) {
	        resultDetails.setFlag(false);
			ex.printStackTrace();
	    } 
	}
			
	private void storeTextboxValue(WebDriver webdriver, String fieldText, String value, String action, String fieldName) {
		try {									
			WebElement ele = getWebElement(webdriver, fieldText);
			String eleValue = ele.getAttribute("value").trim();
			tt.driver.hMap.put(value, eleValue);
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void enterRandomID(WebDriver webdriver, String fieldText, String value, String action, String fieldName) {
		String randomEmailID = getRandomGmailID();
		
		try {									
			WebElement ele= getWebElement(webdriver, fieldText);
			ele.sendKeys(randomEmailID);			
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	private void enterstoredvalue(WebDriver webdriver, String fieldText,String value, String action, String fieldName) {		
		String obj="";
		
		if (fieldText.substring(3,fieldText.length()).startsWith("obj:")) {
		
		obj = fieldText.toLowerCase();
		String temp = obj.substring(7);
		
		obj =tt.driver.objRepo.getProperty(temp,temp);
		
		System.out.println(" Field = " + obj);
		}else if(fieldText.startsWith("//")){
			obj = fieldText;
		}else if(fieldText.substring(3,fieldText.length()).startsWith("//")){
			obj = fieldText.substring(3, fieldText.length());
		}	
		
		//String fieldLocator = fieldText.substring(3, fieldText.length());
		try {
			
//			WebElement ele = null;
			
			By locator = WebDriverUtils.locatorToByObj(webdriver, obj);
			WebElement ele= webdriver.findElement(locator);
			
			System.out.println(tt.driver.hMap.get(value));
			System.out.println();
			ele.clear();
			ele.sendKeys(tt.driver.hMap.get(value));
						
			//System.out.println(tt.driver.hMap.get(value));
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void verifyText(WebDriver webdriver, String fieldText,String value, String action, String fieldName) {		
		String obj="";
		
		if (fieldText.substring(3,fieldText.length()).startsWith("obj:")) {
		
		obj = fieldText.toLowerCase();
		String temp = obj.substring(7);
		
		obj =tt.driver.objRepo.getProperty(temp,temp);
		
		System.out.println(" Field = " + obj);
		}else if(fieldText.startsWith("//")){
			obj = fieldText;
		}else if(fieldText.substring(3,fieldText.length()).startsWith("//")){
			obj = fieldText.substring(3, fieldText.length());
		}	
		
		//String fieldLocator = fieldText.substring(3, fieldText.length());
		try {
			boolean result = true;
//			WebElement ele = null;
			
			By locator = WebDriverUtils.locatorToByObj(webdriver, obj);
			WebElement ele= webdriver.findElement(locator);
			
			String txtToCompare = tt.driver.hMap.get(value);
			System.out.println("Value from Hash Map: " + txtToCompare);
			String elementText = ele.getText();
			System.out.println("Value from WebElement: " + elementText);
			
			if(txtToCompare.equalsIgnoreCase(elementText)) {
				result = true;
			}
			else {
				result = false;
			}
			
			//System.out.println();
			//ele.clear();
			//ele.sendKeys(tt.driver.hMap.get(value));
						
			//System.out.println(tt.driver.hMap.get(value));
			resultDetails.setFlag(result);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void verifyTboxValue(WebDriver webdriver, String fieldText,String value, String action, String fieldName) {		
		try {
			boolean result = true;			
						
			WebElement ele = getWebElement(webdriver, fieldText);
			String elementText = ele.getAttribute("value").trim();
			System.out.println("Value present in TextBox: " + elementText);
			
			String txtToCompare = getTestData(value);
			System.out.println("Value to validate: " + txtToCompare);
			
			if(txtToCompare.equalsIgnoreCase(elementText)) {
				result = true;
			}
			else {
				result = false;
			}
						
			resultDetails.setFlag(result);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void verifylblText(WebDriver webdriver, String fieldText,String value, String action, String fieldName) {		
		try {
			boolean result = true;			
						
			WebElement ele = getWebElement(webdriver, fieldText);
			String elementText = ele.getText();
			System.out.println("Value present on Lable: " + elementText);
			
			String txtToCompare = getTestData(value);
			System.out.println("Value to validate: " + txtToCompare);
			
			if(txtToCompare.equalsIgnoreCase(elementText)) {
				result = true;
			}
			else {
				result = false;
			}
						
			resultDetails.setFlag(result);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}

	private void ddSelect(WebDriver webdriver, String fieldText,String value, String action, String fieldName) {					
		try {									
			WebElement ele= getWebElement(webdriver,fieldText);
			
			Select ddList = new Select(ele);
			ddList.selectByVisibleText(getTestData(value));		
			
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
		
	}	
	
	private void selectFromDD(WebDriver webdriver, String fieldText,String value, String action, String fieldName) {		
					
		try {
			
			String data = getTestData(value);		
			
			WebElement ele = getWebElement(webdriver,fieldText);
			for(int i = 0; i < Integer.parseInt(data); i++) {
				ele.sendKeys(Keys.DOWN);
			}					
			ele.sendKeys(Keys.RETURN);
			
			//((JavascriptExecutor)webdriver).executeScript("arguments[0].click();", ele);
			//((JavascriptExecutor)webdriver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", ele, data);
			//((JavascriptExecutor)webdriver).executeScript("arguments[0].click();", ele);
			
			/*
			Actions act = new Actions(webdriver);
			act.moveToElement(ele).click();
			act.perform();
			*/
			
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
		
	}
	
	private void autoItFileUpLoad(WebDriver webdriver, String fieldText,
			String value, String action, String fieldName) {
		
		try {
		    Capabilities cap = ((RemoteWebDriver) webdriver).getCapabilities();
			String browser = cap.getBrowserName().toLowerCase();
			
			Runtime.getRuntime().exec(autoItfilespath+"\\MulitpleBrowser.exe"+" "+ value +" "+ browser); 
			
			resultDetails.setFlag(true);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			resultDetails.setFlag(false);
		}
	}
	
	private void checkCheckBox(WebDriver webdriver, String fieldText) {
		try {
			WebElement ele= getWebElement(webdriver,fieldText);
		    
			if(!ele.isSelected()) {
				ele.click();
				resultDetails.setFlag(true);
			}
			else {
				resultDetails.setFlag(false);
			}			
			
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private WebElement getWebElement(WebDriver webdriver,String fieldText){		
		String obj="";			
		System.out.println("----------------setting values---------------");
		
		if (fieldText.substring(3,fieldText.length()).startsWith("obj:")) {
		
		obj = fieldText.toLowerCase();
		String temp = obj.substring(7);
		
		obj =tt.driver.objRepo.getProperty(temp,temp);
		
		System.out.println(" Field = " + obj);
		}else if(fieldText.startsWith("//") | (fieldText.startsWith("("))){
			obj = fieldText;
		}else if(fieldText.substring(3,fieldText.length()).startsWith("//")){
			obj = fieldText.substring(3, fieldText.length());
		}	
		
		System.out.println("Field: "+obj);
		
		By locator = WebDriverUtils.locatorToByObj(webdriver, obj);
		WebElement ele= webdriver.findElement(locator);
		
		return ele;
	}
	
	private String getTestData(String value){
		String tempValue="";
		String data="";
		if (value.startsWith("dt:")) {
            tempValue = value.substring(3, value.length()).replace("#", "");
            data = tt.driver.parameterDetails.get(tempValue.toLowerCase());
     } else
    	data = value.trim();
		System.out.println("Value: "+value);
		System.out.println();
		return data;
	}
	
	private static String getRandomGmailID() {
		String randomID = UUID.randomUUID().toString().replaceAll("-", "").concat("@gmail.com");
		return randomID;		
	}
	
	/*	
	private void incrementNumber(WebDriver webdriver, String fieldText, String value, String action, String fieldName) throws Exception {
		try {
			try {	    	
	    	File xmlFile = new File("/E2E Framework/TestInputs/Config.xml");
	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
	    				
			doc.getDocumentElement().normalize();
			String rootNode =  doc.getDocumentElement().getNodeName();			
			
			NodeList nList = doc.getElementsByTagName(rootNode);
			testDataSource = (String) ((Element) nList.item(0)).getElementsByTagName("testDataSource").item(0).getChildNodes().item(0).getNodeValue().trim();			
			} 
			catch (Exception ex) {
				ex.printStackTrace();
			}		
		
			String testInputFile = "/E2E Framework/TestInputs/" + testDataSource;			
		
			myExcelBook = new HSSFWorkbook(new FileInputStream(testInputFile));
			myExcelSheet = myExcelBook.getSheet("TestData");		
		
			int rowCount = myExcelSheet.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) {
				try {
					paramName = myExcelSheet.getRow(i).getCell(0).toString();					
				
					if (paramName.equalsIgnoreCase(fieldText)) {						
						String count = myExcelSheet.getRow(i).getCell(1).toString();						
						int incCount = Integer.parseInt(count) + 1;
						paramValue = String.valueOf(incCount);
						myExcelSheet.getRow(i).createCell(1);
						myExcelSheet.getRow(i).getCell(1).setCellValue(String.valueOf(incCount));
						break;
					}								
				}
				catch (Exception e) {
					e.printStackTrace();
				}			
			}
			myExcelBook.write(new FileOutputStream(testInputFile));
			resultDetails.setFlag(true);
		}
		catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	*/
	
	private void mobileEmail(WebDriver webdriver, String fieldText) {
		String data = newEmailID;
		
		try {
			WebElement ele= getWebElement(webdriver,fieldText);
			ele.clear();
			ele.sendKeys(data);
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.getMessage();
		}
	}
	
	private void mobileInput(WebDriver webdriver, String fieldText, String value) {
		String data = getTestData(value);
		
		try {
			WebElement ele= getWebElement(webdriver,fieldText);
			ele.clear();
			ele.sendKeys(data);
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.getMessage();
		}
	}
	
	private void elementNotPresent(WebDriver webdriver, String fieldText) {
		String obj = "";
		
		if (fieldText.substring(3,fieldText.length()).startsWith("obj:")) {
		
		obj = fieldText.toLowerCase();
		String temp = obj.substring(7);
		
		obj =tt.driver.objRepo.getProperty(temp,temp);
		
		System.out.println(" Field = " + obj);
		}else if(fieldText.startsWith("//")){
			obj = fieldText;
		}else if(fieldText.substring(3,fieldText.length()).startsWith("//")){
			obj = fieldText.substring(3, fieldText.length());
		}	
		
		//String fieldLocator = fieldText.substring(3, fieldText.length());
		try {		
			
			By locator = WebDriverUtils.locatorToByObj(webdriver, obj);
			webdriver.findElement(locator);
			System.out.println("Element Present.");
			resultDetails.setFlag(false);			
			
		} catch (Exception ex) {
			resultDetails.setFlag(true);
			System.out.println("Element Not Present.");			
		}
	}
	
	private void enterFirstName(WebDriver webdriver, String fieldText, String action, String fieldName) {
		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyMMddHms");
			Date now = new Date();
			String strDate = sdfDate.format(now);			
			
			firstName = "Sdc_" + strDate;
			//System.out.println("First Name is: " + firstName);			
			
			WebElement ele= getWebElement(webdriver,fieldText);			
			ele.clear();
			ele.sendKeys(firstName.trim());
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.getMessage();
		}		
	}
	
	private void enterLastName(WebDriver webdriver, String fieldText, String action, String fieldName) {
		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyMMddHms");
			Date now = new Date();
			String strDate = sdfDate.format(now);
			
			lastName = "Auto_" + strDate;
			//System.out.println("Last Name is: " + lastName);
			
			WebElement ele= getWebElement(webdriver,fieldText);			
			ele.clear();
			ele.sendKeys(lastName.trim());
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.getMessage();
		}		
	}
	
	/*
	private static String getCurrentNumber() throws Exception {
		String testInputFile = "/E2E Framework/TestInputs/" + testDataSource;
			
		myExcelBook = new HSSFWorkbook(new FileInputStream(testInputFile));
		myExcelSheet = myExcelBook.getSheet("TestData");			
			
		int rowCount = myExcelSheet.getLastRowNum();
		for (int i = 1; i <= rowCount; i++) {
			paramName = myExcelSheet.getRow(i).getCell(0).toString();
			//System.out.println("Parameter Name: " + paramName);
			if (paramName.equalsIgnoreCase("testEmailNumber")) {
				paramValue = myExcelSheet.getRow(i).getCell(1).toString();
				//System.out.println("Parameter Value: " + paramValue);
				break;					
			}				
		}
		return paramValue;
	} */	
	
	/* Email ID Format: "sdcautotest+test" + paramValue + "@gmail.com" */
	/*
	private void enterNewEmail(WebDriver webdriver, String fieldText, String action, String fieldName) throws Exception {										
		try {			
			File xmlFile = new File("/E2E Framework/TestInputs/Config.xml");
	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
	    				
			doc.getDocumentElement().normalize();
			String rootNode =  doc.getDocumentElement().getNodeName();			
			
			NodeList nList = doc.getElementsByTagName(rootNode);
			testDataSource = (String) ((Element) nList.item(0)).getElementsByTagName("testDataSource").item(0).getChildNodes().item(0).getNodeValue().trim();
			
			String testInputFile = "/E2E Framework/TestInputs/" + testDataSource;
			
			myExcelBook = new HSSFWorkbook(new FileInputStream(testInputFile));
			myExcelSheet = myExcelBook.getSheet("TestData");			
			
			int rowCount = myExcelSheet.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) {
				paramName = myExcelSheet.getRow(i).getCell(0).toString();
				//System.out.println("Parameter Name: " + paramName);
				if (paramName.equalsIgnoreCase("testEmailNumber")) {
					paramValue = myExcelSheet.getRow(i).getCell(1).toString();
					//System.out.println("Parameter Value: " + paramValue);
					break;					
				}				
			}			
			String newEmailID = "sdcautotest+test" + paramValue + "@gmail.com";								
			
			WebElement ele= getWebElement(webdriver,fieldText);
			ele.clear();
			ele.sendKeys(newEmailID);
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.getMessage();
		}		
	}
	*/
	
	private void createNewEmail(WebDriver webdriver, String fieldText, String action, String fieldName) throws Exception {										
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd_HHmmss");//dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
			
		newEmailID = "sdcautotest+test" + strDate + "@gmail.com";
		try	{
			WebElement ele= getWebElement(webdriver,fieldText);
			ele.clear();
			ele.sendKeys(newEmailID);
			resultDetails.setFlag(true);				
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}			
	}
	
	private void acceptAlert(WebDriver webdriver, String action, String fieldName) {
		try {
			Alert alert = webdriver.switchTo().alert();
			alert.accept();
			resultDetails.setFlag(true);
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}
	}
	
	private void discountByValue1(WebDriver webdriver, String action, String fieldName) {					
		try {			
			WebElement ele = webdriver.findElement(By.xpath("//span[@class='eyebrow blurple fullpay-grand-total']"));
			double valBeforeDiscountCode = Double.parseDouble(ele.getText());
			System.out.println("Value before Discount Code: " + valBeforeDiscountCode);
			
			webdriver.findElement(By.xpath("//input[contains(@placeholder,'promo code')]")).sendKeys("SDCVALUE30");
			webdriver.findElement(By.xpath("//button[text()='Apply']")).click();
			double expectdValue = valBeforeDiscountCode - 30.00;
			System.out.println("Expected value after Applying discount code: " + expectdValue);
			try{
					Thread.sleep(2000);
				}catch(Exception e){
					
				}
			WebElement ele1 = webdriver.findElement(By.xpath("//span[@class='eyebrow blurple fullpay-grand-total']"));
			ele1.click();
			double valAfterDiscountCode = Double.parseDouble(ele1.getText());
			System.out.println("Value After Discount Code: " + valAfterDiscountCode);
			if(valBeforeDiscountCode == 00.00) {
				expectdValue = 00.00;
			}
			
			if(expectdValue == valAfterDiscountCode) {
				resultDetails.setFlag(true);
			}
			else {
				resultDetails.setFlag(false);
			}			
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	/* Coupone code used SDCVALUE30 - Discount of 30$ */
	private void discountByValue(WebDriver webdriver, String action, String fieldName) {					
		try {			
			WebElement ele = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[4]/div[1]/div/div[2]/span[2]"));
			WebElement ele1 = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[4]/div[5]/div/div[2]/span[2]"));
			
			double valBeforeDiscountCode = Double.parseDouble(ele.getText());
			System.out.println("Value before Discount Code: " + valBeforeDiscountCode);
			
			//webdriver.findElement(By.xpath("//input[@placeholder='promo code']")).sendKeys("SDCVALUE30");
			//webdriver.findElement(By.xpath("//button[text()='Apply']")).click();
			double expectdValue = valBeforeDiscountCode - 30.00;
			System.out.println("Expected value after Applying discount code: " + expectdValue);
			
			//WebElement ele1 = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[4]/div[5]/div/div[2]/span[2]"));			
			double valAfterDiscountCode = Double.parseDouble(ele1.getText());
			System.out.println("Value After Discount Code: " + valAfterDiscountCode);
			if(valBeforeDiscountCode == 00.00) {
				expectdValue = 00.00;
			}
			
			if(expectdValue == valAfterDiscountCode) {
				resultDetails.setFlag(true);
			}
			else {
				resultDetails.setFlag(false);
			}			
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	/* Coupone code used SDCVALUE30 - Discount of 30$ */
	private void klarnaDiscountByValue(WebDriver webdriver, String action, String fieldName) {					
		try {			
			WebElement ele = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[5]/div/div[1]/div/div[2]/span[2]"));
			WebElement ele1 = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[5]/div/div[5]/div/div[2]/span[2]"));
			
			double valBeforeDiscountCode = Double.parseDouble(ele.getText());
			System.out.println("Value before Discount Code: " + valBeforeDiscountCode);
			
			//webdriver.findElement(By.xpath("//input[@placeholder='promo code']")).sendKeys("SDCVALUE30");
			//webdriver.findElement(By.xpath("//button[text()='Apply']")).click();
			double expectdValue = valBeforeDiscountCode - 30.00;
			System.out.println("Expected value after Applying discount code: " + expectdValue);
			
			//WebElement ele1 = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[5]/div/div[5]/div/div[2]/span[2]"));			
			double valAfterDiscountCode = Double.parseDouble(ele1.getText());
			System.out.println("Value After Discount Code: " + valAfterDiscountCode);
			if(valBeforeDiscountCode == 00.00) {
				expectdValue = 00.00;
			}
			
			if(expectdValue == valAfterDiscountCode) {
				resultDetails.setFlag(true);
			}
			else {
				resultDetails.setFlag(false);
			}			
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	/* Coupone code used SDCPERCENTAGE50 - Discount of 50% */
	private void discountBy50Percent1(WebDriver webdriver, String action, String fieldName) {					
		try {			
			WebElement ele = webdriver.findElement(By.xpath("//span[@class='eyebrow blurple fullpay-grand-total']"));
			double valBeforeDiscountCode = Double.parseDouble(ele.getText());
			System.out.println("Value before Discount Code: " + valBeforeDiscountCode);
			
			webdriver.findElement(By.xpath("//input[contains(@placeholder,'promo code')]")).sendKeys("SDCPERCENTAGE50");
			webdriver.findElement(By.xpath("//button[text()='Apply']")).click();
			double expectdValue = valBeforeDiscountCode / 2;
			System.out.println("Expected value after Applying discount code: " + expectdValue);
			try{
					Thread.sleep(2000);
				} catch(Exception e){
					
				}
			WebElement ele1 = webdriver.findElement(By.xpath("//span[@class='eyebrow blurple fullpay-grand-total']"));
			ele1.click();
			double valAfterDiscountCode = Double.parseDouble(ele1.getText());
			System.out.println("Value After Discount Code: " + valAfterDiscountCode);
			if(valBeforeDiscountCode == 00.00) {
				expectdValue = 00.00;
			}
			
			if(expectdValue == valAfterDiscountCode) {
				resultDetails.setFlag(true);
			}
			else {
				resultDetails.setFlag(false);
			}			
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	/* Coupone code used SDCPERCENTAGE50 - Discount of 50% */
	private void discountBy50Percent(WebDriver webdriver, String action, String fieldName) {					
		try {			
			WebElement ele = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[4]/div[1]/div/div[2]/span[2]"));
			WebElement ele1 = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[4]/div[5]/div/div[2]/span[2]"));			
			
			double valBeforeDiscountCode = Double.parseDouble(ele.getText());
			System.out.println("Value before Discount Code: " + valBeforeDiscountCode);
			
			//webdriver.findElement(By.xpath("//input[@placeholder='promo code']")).sendKeys("SDCPERCENTAGE50");
			//webdriver.findElement(By.xpath("//button[text()='Apply']")).click();
			double expectdValue = valBeforeDiscountCode / 2;
			System.out.println("Expected value after Applying discount code: " + expectdValue);			
			//WebElement ele1 = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[4]/div[5]/div/div[2]/span[2]"));			
			double valAfterDiscountCode = Double.parseDouble(ele1.getText());
			System.out.println("Value After Discount Code: " + valAfterDiscountCode);
			if(valBeforeDiscountCode == 00.00) {
				expectdValue = 00.00;
			}
			
			if(expectdValue == valAfterDiscountCode) {				
				resultDetails.setFlag(true);
			}
			else {				
				resultDetails.setFlag(false);
			}			
		} catch (Exception ex) {			
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}	
	
	/* Coupone code used SDCPERCENTAGE10 - Discount of 10% */
	private void klarna10PercentDiscount(WebDriver webdriver, String action, String fieldName) {					
		try {			
			WebElement ele = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[5]/div/div[1]/div/div[2]/span[2]"));
			WebElement ele1 = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[5]/div/div[5]/div/div[2]/span[2]"));			
			
			double valBeforeDiscountCode = Double.parseDouble(ele.getText());
			System.out.println("Value before Discount Code: " + valBeforeDiscountCode);
			
			//webdriver.findElement(By.xpath("//input[@placeholder='promo code']")).sendKeys("SDCPERCENTAGE10");
			//webdriver.findElement(By.xpath("//button[text()='Apply']")).click();
			double discountAmount = (valBeforeDiscountCode * 10) / 100;
			System.out.println("Discount amount is: " + discountAmount);
			double expectdValue = valBeforeDiscountCode - discountAmount;
			System.out.println("Expected value after Applying discount code: " + expectdValue);
			
			//WebElement ele1 = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[5]/div/div[5]/div/div[2]/span[2]"));			
			double valAfterDiscountCode = Double.parseDouble(ele1.getText());
			System.out.println("Value After Discount Code: " + valAfterDiscountCode);
			if(valBeforeDiscountCode == 00.00) {
				expectdValue = 00.00;
			}
			
			if(expectdValue == valAfterDiscountCode) {
				resultDetails.setFlag(true);
			}
			else {
				resultDetails.setFlag(false);
			}			
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	/* Coupone code used SDCPERCENTAGE50 - Discount of 50% */
	private void smilePay50PercentDiscount(WebDriver webdriver, String action, String fieldName) {					
		try {
			/*
			WebElement ele = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[6]/div/div[6]/div/div[2]/span[2]"));
			double valBeforeDiscountCode = Double.parseDouble(ele.getText());
			System.out.println("Value before Discount Code: " + valBeforeDiscountCode);
			
			webdriver.findElement(By.xpath("//input[@placeholder='promo code']")).sendKeys("SDCPERCENTAGE50");
			webdriver.findElement(By.xpath("//button[text()='Apply']")).click();
			double expectdValue = valBeforeDiscountCode / 2;
			System.out.println("Expected value after Applying discount code: " + expectdValue);
			Thread.sleep(1000);			
			double valAfterDiscountCode = Double.parseDouble(ele.getText());
						
			System.out.println("Value After Discount Code: " + valAfterDiscountCode);
			
			if(valBeforeDiscountCode == 00.00) {
				expectdValue = 00.00;
			}
			
			if(expectdValue == valAfterDiscountCode) {
				resultDetails.setFlag(true);
			}
			else {
				resultDetails.setFlag(false);
			}
			*/
			
			
			WebElement grandTotal = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[6]/div/div[1]/div/div[2]/span[2]"));
			WebElement grandTotal1 = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[6]/div/div[6]/div/div[2]/span[2]"));
			WebElement monthlyInstallment = webdriver.findElement(By.xpath("//span[@class='eyebrow installment-price']"));
			WebElement todaysPayment = webdriver.findElement(By.xpath("//div[@class='smilepay-summary smilepay-classic']//span[@class='initial-payment eyebrow blurple']"));
			
			double valBeforeDiscountCode = Double.parseDouble(grandTotal.getText());
			System.out.println("Value before Discount Code: " + valBeforeDiscountCode);
			
			//webdriver.findElement(By.xpath("//input[@placeholder='promo code']")).sendKeys("SDCPERCENTAGE50");
			//webdriver.findElement(By.xpath("//button[text()='Apply']")).click();
			double expectdValue = valBeforeDiscountCode / 2;
			System.out.println("Expected value after Applying discount code: " + expectdValue);
			
			//WebElement grandTotal1 = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[6]/div/div[6]/div/div[2]/span[2]"));			
			double valAfterDiscountCode = Double.parseDouble(grandTotal1.getText());
			System.out.println("Value After Discount Code: " + valAfterDiscountCode);			
			
			//WebElement monthlyInstallment = webdriver.findElement(By.xpath("//span[@class='eyebrow installment-price']"));
			int valMonthlyInstallment = (int)(Double.parseDouble(monthlyInstallment.getText()));
			System.out.println("Monthly Installment is: " + valMonthlyInstallment);
			
			//WebElement todaysPayment = webdriver.findElement(By.xpath("//div[@class='smilepay-summary smilepay-classic']//span[@class='initial-payment eyebrow blurple']"));
			double valTodaysPayment = Math.abs(Double.parseDouble(todaysPayment.getText()));
			int valMonthlyInstallment1 = (int)(valAfterDiscountCode - valTodaysPayment) / 24;
			System.out.println("Monthly Installment after calculation is: " + valMonthlyInstallment1);
						
			if(valBeforeDiscountCode == 00.00) {
				expectdValue = 00.00;
				//valMonthlyInstallment = 89.00;
			}
			
			if((expectdValue == valAfterDiscountCode) && (valMonthlyInstallment == valMonthlyInstallment1)){
				resultDetails.setFlag(true);
			}
			else {
				resultDetails.setFlag(false);
			}
		} catch (Exception ex) {			
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	/* Coupone code used SDCVALUE30 - Discount of 30$ */
	private void smilePayDiscountByValue(WebDriver webdriver, String action, String fieldName) {					
		try {
			WebElement ele = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[6]/div/div[1]/div/div[2]/span[2]"));
			WebElement ele1 = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[6]/div/div[6]/div/div[2]/span[2]"));
			WebElement monthlyInstallment = webdriver.findElement(By.xpath("//span[@class='eyebrow installment-price']"));
			WebElement todaysPayment = webdriver.findElement(By.xpath("//div[@class='smilepay-summary smilepay-classic']//span[@class='initial-payment eyebrow blurple']"));
			
			double valBeforeDiscountCode = Double.parseDouble(ele.getText());
			System.out.println("Value before Discount Code: " + valBeforeDiscountCode);
			
			//webdriver.findElement(By.xpath("//input[@placeholder='promo code']")).sendKeys("SDCVALUE30");
			//webdriver.findElement(By.xpath("//button[text()='Apply']")).click();
			double expectdValue = valBeforeDiscountCode - 30.00;
			System.out.println("Expected value after Applying discount code: " + expectdValue);
			
			//WebElement ele1 = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[6]/div/div[6]/div/div[2]/span[2]"));			
			double valAfterDiscountCode = Double.parseDouble(ele1.getText());						
			System.out.println("Value After Discount Code: " + valAfterDiscountCode);
			
			//WebElement monthlyInstallment = webdriver.findElement(By.xpath("//span[@class='eyebrow installment-price']"));
			int valMonthlyInstallment = (int)(Double.parseDouble(monthlyInstallment.getText()));
			System.out.println("Monthly Installment is: " + valMonthlyInstallment);
			
			//WebElement todaysPayment = webdriver.findElement(By.xpath("//div[@class='smilepay-summary smilepay-classic']//span[@class='initial-payment eyebrow blurple']"));
			double valTodaysPayment = Math.abs(Double.parseDouble(todaysPayment.getText()));
			int valMonthlyInstallment1 = (int)(valAfterDiscountCode - valTodaysPayment) / 24;
			System.out.println("Monthly Installment after calculation is: " + valMonthlyInstallment1);
			
			if(valBeforeDiscountCode == 00.00) {
				expectdValue = 00.00;
			}
			
			if((expectdValue == valAfterDiscountCode) && (valMonthlyInstallment == valMonthlyInstallment1)) {
				resultDetails.setFlag(true);
			}
			else {
				resultDetails.setFlag(false);
			}			
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	/* Verify - Discount of 50% is Applied */
	private void verifySmilePayCFDiscount(WebDriver webdriver, String action, String fieldName) {					
		try {			
			WebElement eleSubTotal = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[6]/div/div[1]/div/div[2]/span[2]"));
			double valBeforeDiscountCode = Double.parseDouble(eleSubTotal.getText());
			System.out.println("Value before Discount Code: " + valBeforeDiscountCode);
						
			double expectdValue = valBeforeDiscountCode / 2;
			System.out.println("Expected value after Applying discount code: " + expectdValue);
			try{
					Thread.sleep(2000);
				}catch(Exception e){
					
				}
			WebElement eleTotal = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[6]/div/div[6]/div/div[2]/span[2]"));			
			eleTotal.click();
			double valAfterDiscountCode = Double.parseDouble(eleTotal.getText());
			System.out.println("Value After Discount Code: " + valAfterDiscountCode);
			
			WebElement monthlyInstallment = webdriver.findElement(By.xpath("//span[@class='eyebrow installment-price']"));
			int valMonthlyInstallment = (int)(Double.parseDouble(monthlyInstallment.getText()));
			System.out.println("Monthly Installment is: " + valMonthlyInstallment);
			
			WebElement todaysPayment = webdriver.findElement(By.xpath("//div[@class='smilepay-summary smilepay-classic']//span[@class='initial-payment eyebrow blurple']"));
			double valTodaysPayment = Math.abs(Double.parseDouble(todaysPayment.getText()));
			int valMonthlyInstallment1 = (int)(valAfterDiscountCode - valTodaysPayment) / 24;
			System.out.println("Monthly Installment after calculation is: " + valMonthlyInstallment1);
			
			if(valBeforeDiscountCode == 00.00) {
				expectdValue = 00.00;
			}
			
			if((expectdValue == valAfterDiscountCode)  && (valMonthlyInstallment == valMonthlyInstallment1)) {
				resultDetails.setFlag(true);
			}
			else {
				resultDetails.setFlag(false);
			}			
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	/* Verify - Discount of 50% is Applied */
	private void verify50PercentApplied(WebDriver webdriver, String action, String fieldName) {					
		try {			
			WebElement eleSubTotal = webdriver.findElement(By.xpath("//span[@class='eyebrow subtotal']"));
			double valBeforeDiscountCode = Double.parseDouble(eleSubTotal.getText());
			System.out.println("Value before Discount Code: " + valBeforeDiscountCode);
						
			double expectdValue = valBeforeDiscountCode / 2;
			System.out.println("Expected value after Applying discount code: " + expectdValue);
			try{
					Thread.sleep(2000);
				}catch(Exception e){
					
				}
			WebElement eleTotal = webdriver.findElement(By.xpath("//span[@class='eyebrow blurple fullpay-grand-total']"));			
			eleTotal.click();
			double valAfterDiscountCode = Double.parseDouble(eleTotal.getText());
			System.out.println("Value After Discount Code: " + valAfterDiscountCode);
			if(valBeforeDiscountCode == 00.00) {
				expectdValue = 00.00;
			}
			
			if(expectdValue == valAfterDiscountCode) {
				resultDetails.setFlag(true);
			}
			else {
				resultDetails.setFlag(false);
			}			
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	/* Verify - Discount of 30$ is Applied */
	private void verifyKlarnaCFDiscount(WebDriver webdriver, String action, String fieldName) {					
		try {			
			WebElement eleSubTotal = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[5]/div/div[1]/div/div[2]/span[2]"));
			double valBeforeDiscountCode = Double.parseDouble(eleSubTotal.getText());
			System.out.println("Value before Discount Code: " + valBeforeDiscountCode);
						
			double expectdValue = valBeforeDiscountCode - 30;
			System.out.println("Expected value after Applying discount code: " + expectdValue);
			try{
					Thread.sleep(2000);
				}catch(Exception e){
					
				}
			WebElement eleTotal = webdriver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div[5]/div/div[5]/div/div[2]/span[2]"));			
			eleTotal.click();
			double valAfterDiscountCode = Double.parseDouble(eleTotal.getText());
			System.out.println("Value After Discount Code: " + valAfterDiscountCode);
			if(valBeforeDiscountCode == 00.00) {
				expectdValue = 00.00;
			}
			
			if(expectdValue == valAfterDiscountCode) {
				resultDetails.setFlag(true);
			}
			else {
				resultDetails.setFlag(false);
			}			
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	/* Coupone code used SDCPERCENTAGE100 - Discount of 100% */
	private void discountBy100Percent(WebDriver webdriver, String value, String action, String fieldName) {
		String data = getTestData(value);
		
		try {			
			WebElement ele = webdriver.findElement(By.xpath("//span[@class='eyebrow blurple fullpay-grand-total']"));
			double valBeforeDiscountCode = Double.parseDouble(ele.getText());
			System.out.println("Value before Discount Code: " + valBeforeDiscountCode);
			
			webdriver.findElement(By.xpath("//input[contains(@placeholder,'promo code')]")).sendKeys(data);
			webdriver.findElement(By.xpath("//button[text()='Apply']")).click();
			double expectdValue = valBeforeDiscountCode - valBeforeDiscountCode;
			System.out.println("Expected value after Applying discount code: " + expectdValue);
			try{
					Thread.sleep(2000);
				}catch(Exception e){
					
				}
			WebElement ele1 = webdriver.findElement(By.xpath("//span[@class='eyebrow blurple fullpay-grand-total']"));
			ele1.click();
			double valAfterDiscountCode = Double.parseDouble(ele1.getText());
			System.out.println("Value After Discount Code: " + valAfterDiscountCode);
			if(valBeforeDiscountCode == 00.00) {
				expectdValue = 00.00;
			}
			
			if(expectdValue == valAfterDiscountCode) {
				resultDetails.setFlag(true);
			}
			else {
				resultDetails.setFlag(false);
			}			
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	/* Select from Drop down control with the given text. */
	private void selectByText(WebDriver webdriver, String fieldText, String value, String action, String fieldName) {					
		try {			
			WebElement ele= getWebElement(webdriver,fieldText);
			//System.out.println("DropDown element found");
			
			String data = getTestData(value);
			
			Select ddList = new Select(ele);
			List<WebElement> dd = ddList.getOptions();
			for (int j = 0; j < dd.size(); j++) {				
				//System.out.println(dd.get(j).getText());
				if(dd.get(j).getText().contains(data)) {
					//System.out.println("Element Found.");
					//ele.sendKeys(Keys.DOWN);
					//ele.sendKeys(Keys.RETURN);
					resultDetails.setFlag(true);
					break;
				}
				else {
					//System.out.println("Element Not Found.");
					resultDetails.setFlag(false);
				}
				ele.sendKeys(Keys.DOWN);
			}			
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}
	
	private void JDblClick(WebDriver webdriver, String fieldText, String value, String action, String fieldName) {
		WebElement ele = null;
		try {
			ele = getWebElement(webdriver, fieldText);
			JavascriptExecutor js = (JavascriptExecutor) webdriver;
			js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ele);
			//js.executeScript("arguments[0].doubleClick();", ele);			
			resultDetails.setFlag(true);

		} catch (Exception e) {
			e.printStackTrace();
			resultDetails.setFlag(false);

		}		
	}
	
	private void dblClick(WebDriver webdriver, String fieldText, String value, String action, String fieldName) {
		try {
			WebElement ele= getWebElement(webdriver,fieldText);
			Actions act  = new Actions(webdriver);
			act.doubleClick(ele).perform();
			//act.build().perform();
			resultDetails.setFlag(true);			
		} catch (Exception ex) {
			resultDetails.setFlag(false);
			ex.printStackTrace();
		}		
	}	
}
package pk_Functions

/*Created By Asmaa Elsayed Ibrahim
 * Date 25/12/2018
 * Function: This Class Contains Three functions 
 * 1- First Function: clicking on certain item by selecting string to click  
 * 2- Second Function: getting all items in LOV and numbers of items and check if it is matched with expected or not
 * 3- Third Function: clicking on certain item by selecting index to click  
 */

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.sql.Connection
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword

public class CS_StaticListUsingLiTag {

	private static TestObject dropdown = null;
	private static List<WebElement> allItems= null;
	private static WebElement dropDownList;

	// Clicking on certain item using name of item
	// Input: x-path of drop down list, x-path of container, items of static LOV
	// Output: There isn't output

	@Keyword
	def LovSearchFun (String dropdownObjectXpath, String ContainerObjectXpath, String text) {

		// Assuming you have to click the "drop down" to open it
		// TestObject dropDown = findTestObject(dropdownObjectHierarchy)
		// WebUI.click(dropDown)

		// Using driver
		WebDriver driver = DriverFactory.getWebDriver()

		// Assuming you have x-path of drop down  to click the "drop down" to open it
		dropDownList=driver.findElement(By.xpath(dropdownObjectXpath));
		dropDownList.click()

		// Getting all items in list called allItems
		allItems = driver.findElements(By.xpath(ContainerObjectXpath));
		int itemNo
		WebUI.delay(4)
		// Loop on all items to click on the desired text in LOV
		for( itemNo=1 ; itemNo<=allItems.size() ; itemNo++){
			if (allItems[itemNo-1].getText().equals(text)) {
				allItems[itemNo-1].click(); // Click the desired option
				// Once found desired text then break the for loop
				break;
			}
		}
	}

	// Getting all items in LOV and numbers of items and  decide if it matched with expected one or not
	// Inputs: x-path of drop down list, x-path of container , Expected items of static LOV
	// Output: String (" matched , not matched ")

	@Keyword
	def LovMatchItemsFun (String dropdownObjectXpath, String ContainerObjectXpath, List<String> expectedItems ) {

		// Using driver
		WebDriver driver = DriverFactory.getWebDriver()

		// Assuming you have x-path of drop down  to click the "drop down" to open it
		dropDownList=driver.findElement(By.xpath(dropdownObjectXpath));
		dropDownList.click()

		// Getting all items in list called allItems
		allItems = driver.findElements(By.xpath(ContainerObjectXpath));

		int itemsNum
		String status

		List<String> actualItems = new ArrayList<String>()

		// Print Number of Items in LOV
		println ( "Number of Items :  "+ allItems.size())
		WebUI.delay(4)

		for( itemsNum=1 ; itemsNum<=allItems.size() ; itemsNum++){
			actualItems.add(allItems[itemsNum-1].getText())

			// print each item in LOV
			println (actualItems[itemsNum-1])
		}

		// Test matching between expected and actual result
		if (actualItems.equals(expectedItems) ){
			status= "Matched"
		}else {
			status= "Not Matched"
		}

		// Print the status
		println status
		assert status == "Matched"
	}

	// Clicking on certain item by index
	// Input: x-path of drop down list, x-path of container, items of static LOV
	// Output: There isn't output

	@Keyword
	def LovSearchIndexFun(String dropdownObjectXpath, String ContainerObjectXpath, int index) {

		// Using driver
		WebDriver driver = DriverFactory.getWebDriver()

		// Assuming you have x-path of drop down  to click the "drop down" to open it
		dropDownList=driver.findElement(By.xpath(dropdownObjectXpath));
		dropDownList.click()

		// Getting all items in list called allItems
		allItems = driver.findElements(By.xpath(ContainerObjectXpath));
		int itemNo
		WebUI.delay(4)

		//  click on the desired text in LOV
		allItems[index-1].click(); // Click the desired option

	}

}
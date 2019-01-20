package pk_Functions
/* Created By Asmaa Elsayed Ibrahim
 * Date 25/12/2018
 * Usage: Getting all objects (name, attributes and values) existing in excel sheet and return them in list
 * Input: This Function takes only two inputs 1- File name    2- Sheet name 
 * Output: Output is list of object 
 */

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import javax.lang.model.element.VariableElement
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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testdata.reader.ExcelFactory
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testdata.ExcelData

public class CS_AllPageObject {

	//Getting all objects (name, attributes and values) existing in excel sheet and return them in list
	@Keyword
	List<TestObject> AllPageObjectFun (String fileName , String sheetName  ){

		List<TestObject> list = new ArrayList<TestObject>()

		int row

		// take file name and sheet name to get object
		ExcelData  data = findTestData(fileName)
		data.changeSheet(sheetName)

		//  loop to get all object in excel sheet by using numbers of row
		for (row = 1; row < data.getRowNumbers()+1; row++) {

			//create new object and change it's property (Attribute , Value of it's attribute )
			TestObject flexibleTestObject = new TestObject()
			flexibleTestObject.addProperty(data.getValue(2, row), ConditionType.EQUALS, data.getValue(3, row))

			//add above object into list
			list.add(flexibleTestObject)
		}

		// return list of object
		return list
	}
}

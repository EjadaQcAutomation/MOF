package pk_Functions
/* Created By Asmaa Elsayed Ibrahim
 * Date 25/12/2018
 * Usage: Getting certain objects (names, attributes and values) by names existing in excel sheet and return them in list
 * Input: This Function takes only two inputs 1- File name    2- Sheet name   3-Fields Names
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

public class CS_SpecificObject {

	//Getting only objects (name, attributes and values) selected by names existing in excel sheet and return them in list
	@Keyword
	List<TestObject> ObjectFun (String fileName , String sheetName , List<TestObject> fieldsNames ){
		List<TestObject> list = new ArrayList<TestObject>()
		int row
		int fieldNo
		int index
		// Take file name and sheet name to get object
		ExcelData  data = findTestData(fileName)
		data.changeSheet( sheetName)

		List<TestObject> data1 = data.getAllData()

		List<String> valueOfRow = new ArrayList<String>()

		//Looping on excel file of object
		for ( row = 1;  row < data.getRowNumbers()+1;  row++) {
			valueOfRow.add(data.getValue(1, row))
		}

		for (fieldNo  = 1; fieldNo  <= fieldsNames.size(); fieldNo ++) {
			index = valueOfRow.indexOf(fieldsNames[(fieldNo -1)]);

			//Create new object and change it's property (Attribute , Value of it's attribute )
			TestObject flexibleTestObject = new TestObject()
			flexibleTestObject.addProperty(data.getValue(2,index+1), ConditionType.EQUALS, data.getValue(3, index+1))

			//Add above object into list
			list.add(flexibleTestObject)
		}




		/*
		 //Looping on Fields names
		 for (fieldNo  = 1; fieldNo  <= fieldsNames.size(); fieldNo ++) {
		 //Looping on excel file of object
		 for ( row = 1;  row < data.getRowNumbers()+1;  row++) {
		 //Compare between each row in column "1" in excel sheet of object and value existing in fields names to get it's row in excel sheet of object
		 if (data.getValue(1, row)== fieldsNames[(fieldNo -1)]){
		 //Create new object and change it's property (Attribute , Value of it's attribute )
		 TestObject flexibleTestObject = new TestObject()
		 flexibleTestObject.addProperty(data.getValue(2,  row), ConditionType.EQUALS, data.getValue(3,  row))
		 //Add above object into list
		 list.add(flexibleTestObject)
		 //If found the value of fields names same as certain row in excel sheet of object then break loop
		 break
		 }
		 }
		 }
		 */

		//Return list of selected object
		return list
	}
}

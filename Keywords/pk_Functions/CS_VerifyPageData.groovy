package pk_Functions
/* Created By Azza Salah
 * Date 2/1/2018
 * Usage: Retrieve data of all fields in Edit mode and compare them by data in excel file
 * Input: This Function takes only two inputs 1- File name(object repository file)    2- Sheet name
 */
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.ExcelData
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class CS_VerifyPageData {
	
	@Keyword
	CheckMatching(  List<TestObject> fieldsNames, String fileName , String sheetName , List<TestObject> fieldsData ){

		//calling pk_Functions.CS_SpecificObject()
		pk_Functions.CS_SpecificPageObject SpecificObject	=new pk_Functions.CS_SpecificPageObject()

		//getting certain objects that selected using Fields names inputs then stored in list by calling ObjectFun function
		List<TestObject> listObject = new ArrayList<TestObject>(SpecificObject.ObjectFun(fileName ,sheetName , fieldsNames))
		int column
		int index

		// getting data of object
		ExcelData  data = findTestData(fileName)
		data.changeSheet( sheetName)

		//loop for setting data into list object that stored in list using 	SpecificPageObject function
		for (column = 1; column <= listObject.size(); column++) {

			//getting index of row in object file belongs to every items in order of Fields name
			index = SpecificObject.valueOfRow.indexOf(fieldsNames[(column -1)]);
			//if type equals text
			WebUI.getText(listObject[(column - 1)], fieldsData[(column-1)])
				//if type equals LOV by select tag
				
		///loop for setting data into list object that stored in list using AllPageObjectFun function and compare each value in the list by each value in excel
		for (column = 1; column <= listObject.size(); column++) {
			<<<<<<< HEAD
			findTestData(DataFileName).changeSheet(DatasheetName).getValue(column,1)

			WebUI.verifyMatch(WebUI.getAttribute(listObject[(column-1)],'value'), findTestData(DataFileName).changeSheet(DatasheetName).getValue(column,1), false, FailureHandling.STOP_ON_FAILURE)
			=======
			String Expected_Data= findTestData(DataFileName).changeSheet(DatasheetName).getValue(column,1)
			WebUI.verifyMatch(WebUI.getAttribute(listObject[(column-1)],'value'), Expected_Data, false, FailureHandling.STOP_ON_FAILURE)
			>>>>>>> branch 'master' of https://github.com/EjadaQcAutomation/MOF
		}
	}
}


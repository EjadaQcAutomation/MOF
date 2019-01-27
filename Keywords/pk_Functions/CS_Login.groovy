package pk_Functions

/* Created By Asmaa Elsayed Ibrahim
 * Date 25/12/2018
 * Usage: Getting all objects (name, attributes and values) existing in excel sheet and return them in list
 * Input: This Function takes inputs as 
 * 1- url   2- userNameObject   3- passwordObject  4- userNameVariable  5- passwordVariable  6- loginObject
 * Output: Output is list of object 
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
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class CS_Login {

	@Keyword
	def LoginFun(TestObject Null, String url ,TestObject userNameObject ,TestObject passwordObject ,String userNameVariable ,String passwordVariable ,TestObject loginObject) {
		WebUI.openBrowser(url)

		WebUI.setText(userNameObject , userNameVariable )

		WebUI.setText(passwordObject ,  passwordVariable)

		WebUI.click(loginObject)
	}
}



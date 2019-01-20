package pk_Functions

//Created by :Asmaa Elsayed Ibrahim
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
	def LoginFun(TestObject Null , String URL,TestObject UsrNme_obj ,TestObject Pswrd_obj ,String UsrNme_Var ,String Pswrd_var ,TestObject Login_obj) {
		WebUI.openBrowser(URL)

		WebUI.setText(UsrNme_obj , UsrNme_Var )

		WebUI.setText(Pswrd_obj ,  Pswrd_var)

		WebUI.click(Login_obj)
	}
}



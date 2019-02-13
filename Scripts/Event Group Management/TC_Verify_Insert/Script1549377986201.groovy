import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

WebUI.click(findTestObject('Event Group Managemnt/BTN_Clear'))

WebUI.delay(2)

WebUI.acceptAlert()

CustomKeywords.'pk_Functions.CS_SpecificPageData.DataFun'(['Code_Search'], 'Event Group Management/MOF_NE_Event Group ManagementObjectRepository', 
    'Sheet1', [Code])


WebUI.delay(2)

WebUI.click(findTestObject('Event Group Managemnt/BTN_Search'))

WebUI.delay(4)

if (Search == "SearchYes") {
	
CustomKeywords.'pk_Functions.CS_WebtableVerification.ValidateSearchParameters'('Search', 'Event Group Management/MOF_NE_Event Group ManagementObjectRepository', 
    'Sheet1', [Code, EnglishDescription, ArabicDescription], 0)

}

WebUI.delay(2)

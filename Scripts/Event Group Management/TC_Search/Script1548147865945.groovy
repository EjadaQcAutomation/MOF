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

CustomKeywords.'pk_Functions.CS_Login.LoginFun'(findTestObject(null), 'http://192.168.0.190:8080/mof/#/', findTestObject(
        'Login/Username'), findTestObject('Login/Password'), 'AAttia', '123', findTestObject('Login/Login'))

WebUI.click(findTestObject('NE_SideMenu'))

WebUI.click(findTestObject('NE_EventGroupManagement'))

Search Parameter entry using excel sheet  = CustomKeywords.'pk_Functions.CS_SpecificPageData.DataFun'(['Code'], 'Event Group Management/EventManagementGPUpdate_ObjectRepository', 
    'Search_Parameters', [Code])

WebUI.click(findTestObject('Event Group Managemnt/BTN_Search'))

WebUI.delay(1)

CustomKeywords.'pk_Functions.CS_WebtableVerification.ValidateSearchParameters'('Search', 'xpath', '//*[@id="app-form"]/div/app-body/div/div/div[2]/div[2]/app-event-categories-management-layout/div/div[2]/div/app-event-categories-management-list/p-panel/div/div[2]/div[1]/div/div/p-datatable/div/div[2]', 
    [Code, ArabicDescription, EnglishDescription], 0)

WebUI.click(findTestObject('Event Group Managemnt/BTN_Clear'))

CustomKeywords.'pk_Functions.CS_WebtableVerification.ValidateSearchParameters'('Clear', 'xpath', '//*[@id="app-form"]/div/app-body/div/div/div[2]/div[2]/app-event-categories-management-layout/div/div[2]/div/app-event-categories-management-list/p-panel/div/div[2]/div[1]/div/div/p-datatable/div/div[2]', 
    [], 0)


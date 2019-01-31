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

WebUI.click(findTestObject('Event Group Managemnt/BTN_Search'))

WebUI.delay(5)

CustomKeywords.'pk_Functions.CS_SelectRecordFromWebtable_IPO.SelectRecordFromWebtableFun'('Event Group Management/MOF_NE_Event Group ManagementObjectRepository', 
    'a', '1', 0, 3, 2)

WebUI.delay(5)

CustomKeywords.'pk_Functions.CS_SpecificPageData.DataFun'(['Arabic Description', 'English Description'], 'Event Group Management/MOF_NE_Event Group ManagementObjectRepository', 
    'Sheet1', [ArabicDescription, EnglishDescription])

WebUI.click(findTestObject('Event Group Managemnt/BTN_Save'))

WebUI.click(findTestObject('Event Group Managemnt/BTN_Back'))

WebUI.delay(2)

CustomKeywords.'pk_Functions.CS_SelectRecordFromWebtable_IPO.SelectRecordFromWebtableFun'('Event Group Management/MOF_NE_Event Group ManagementObjectRepository', 
    'Sheet1', '1', 0, 3, 1)

WebUI.delay(1)

CustomKeywords.'pk_Functions.CS_VerifyPageData.CheckMatching'('Event Group Management/MOF_NE_Event Group ManagementObjectRepository', 
    'Sheet1', 'Event Group Management/EventManagemntGPUpdate_Data', 'Update_Data')


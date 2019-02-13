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

not_run: CustomKeywords.'pk_Functions.CS_Login.LoginFun'(findTestObject(null), 'http://192.168.0.190:8080/mof/#/', findTestObject(
        'Login/Username'), findTestObject('Login/Password'), 'AAttia', '123', findTestObject('Login/Login'))

not_run: WebUI.delay(1)

not_run: WebUI.click(findTestObject('NE_SideMenu'))

not_run: WebUI.click(findTestObject('NE_EventGroupManagement'))

not_run: WebUI.click(findTestObject('Event Group Managemnt/BTN_Search'))

WebUI.delay(2)

CustomKeywords.'pk_Functions.CS_ClickingonUpdateorDeletebutton_Fulltabl.SelectRecordFromWebtableFun'('UpdateYes', 0, 3, 
    'Event Group Management/MOF_NE_Event Group ManagementObjectRepository', 'Sheet1', Code)

if (ActionType == 'UpdateYes') {
    WebUI.delay(1)

    CustomKeywords.'pk_Functions.CS_SpecificPageData.DataFun'(['Arabic Description', 'English Description'], 'Event Group Management/MOF_NE_Event Group ManagementObjectRepository', 
        'Sheet1', [ArabicDescription, EnglishDescription])

    WebUI.delay(1)

    WebUI.click(findTestObject('BTN_Save'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Event Group Managemnt/BTN_Back (1)'))

    WebUI.delay(1)
}


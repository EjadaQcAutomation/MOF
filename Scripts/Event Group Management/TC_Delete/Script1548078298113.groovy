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

CustomKeywords.'pk_Functions.CS_SelectRecordFromWebtable_IPO.SelectRecordFromWebtableFun'('xpath', '//*[@id="app-form"]/div/app-body/div/div/div[2]/div[2]/app-event-categories-management-layout/div/div[2]/div/app-event-categories-management-list/p-panel/div/div[2]/div[1]/div/div/p-datatable/div/div[2]/table', 
    code, 0, 3, 3)

WebUI.delay(2)

CustomKeywords.'pk_Functions.CS_SpecificPageData.DataFun'(['pop_up', 'delete_no', 'delete_yes'], 'Event Group Management/MOF_NE_Event Group ManagementObjectRepository', 
    'Sheet1', [pop_up, delete_no, delete_yes])

WebUI.delay(2)

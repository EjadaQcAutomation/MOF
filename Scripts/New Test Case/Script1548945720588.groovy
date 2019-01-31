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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://192.168.0.190:8080/mof/#/login')

WebUI.setText(findTestObject('Object Repository/test/Page_MOF/input_User ID_userId'), 'AAtia')

WebUI.setEncryptedText(findTestObject('Object Repository/test/Page_MOF/input_Password_password'), 'tzH6RvlfSTg=')

WebUI.click(findTestObject('Object Repository/test/Page_MOF/span_Login'))

WebUI.click(findTestObject('Object Repository/test/Page_MOF/html_MOF         media screen'))

WebUI.setText(findTestObject('Object Repository/test/Page_MOF/input_User ID_userId'), 'AAttia')

WebUI.click(findTestObject('Object Repository/test/Page_MOF/span_Login'))

WebUI.click(findTestObject('Object Repository/test/Page_MOF/a_PSR'))

WebUI.click(findTestObject('Object Repository/test/Page_MOF/a_NE'))

WebUI.click(findTestObject('Object Repository/test/Page_MOF/a_Event Group Management'))

WebUI.click(findTestObject('Object Repository/test/Page_MOF/span_Search'))

WebUI.click(findTestObject('Object Repository/test/Page_MOF/span_ui-btn_ui-button-icon-lef'))

WebUI.click(findTestObject('Object Repository/test/Page_MOF/span_Yes'))

WebUI.click(findTestObject('Object Repository/test/Page_MOF/span_ui-btn_ui-button-icon-lef'))

WebUI.click(findTestObject('Object Repository/test/Page_MOF/span_No'))

WebUI.closeBrowser()


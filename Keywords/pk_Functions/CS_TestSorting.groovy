import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import java.util.Collections;

import internal.GlobalVariable

public class TestSorting {
	@Keyword
	Test_Sorting(String SortType , String webtableAttribute ,String webtablelocatorValue ,int column_num){
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement Table
		//To locate table'
		if (webtableAttribute=='xpath'){
			Table = driver.findElement(By.xpath(webtablelocatorValue))
		}
	
		else{
			Table = driver.findElement(By.xpath("//*[@"+webtableAttribute+"="+webtablelocatorValue+"]"))
		}
	
		//‘To locate rows of table it will Capture all the rows available in the table’
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
	
		//‘To calculate no of rows In table’
		int rows_count = rows_table.size()
		String[] celltext = new String[rows_count]
		String[] celltext2 = new String[rows_count]
		for (int row = 1; row < rows_count; row++) {
			//‘To locate columns(cells) of that specific row’
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))
	
			//‘It will retrieve text from 1st cell’
			String celltext_1 = Columns_row.get(column_num).getText()
			(celltext[row]) = celltext_1
			
		}
		// original list
		List<WebElement> celltext_list
		celltext_list = Arrays.asList(celltext)
		
		List<WebElement> listAsc 
		listAsc=celltext_list.sort()
		println(listAsc)
		List<WebElement> listDes //List is in Desc order
		listDes =celltext_list.reverse();
		println(listDes)
if(SortType=='asc'){
	WebUI.click(findTestObject('Event Group Managemnt/BTN_Sort'))
	for (int row = 1; row < rows_count; row++) {
		//‘To locate columns(cells) of that specific row’
		List<WebElement> Columns_row2 = rows_table.get(row).findElements(By.tagName('td'))

		//‘It will retrieve text from 1st cell’
		String celltext_1_2 = Columns_row2.get(column_num).getText()
		(celltext2[row]) = celltext_1_2
		
	}
	// list after first click 
	List<WebElement> celltext_list2
	celltext_list2 = Arrays.asList(celltext)
	println(celltext_list2)
	if(celltext_list2.equals(listAsc)){
		println("Celltext is in ascending order")
	}
	else{
		println("Celltext is in not ascending order")
	
	}}
else {
	WebUI.delay(2)
	WebUI.click(findTestObject('Event Group Managemnt/BTN_Sort'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Event Group Managemnt/BTN_Sort'))

	for (int row = 1; row < rows_count; row++) {
		//‘To locate columns(cells) of that specific row’
		List<WebElement> Columns_row2 = rows_table.get(row).findElements(By.tagName('td'))

		//‘It will retrieve text from 1st cell’
		String celltext_1_2 = Columns_row2.get(column_num).getText()
		(celltext2[row]) = celltext_1_2
		
	}
	// list after first click
	List<WebElement> celltext_list2
	celltext_list2 = Arrays.asList(celltext)
	println(celltext_list2)
	if(celltext_list2.equals(listDes)){
		println("Celltext is in descending order")
	}
	else{
		println("Celltext is in not descending order")
	
	}
	}
		
	}}

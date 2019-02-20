package pk_Functions
/* Created By ‘Ebtehal Gamal Yusuf and Asmaa El-Sayed’
 * Date 13/01/2019
 * Usage:This Function is used to compare record in grid with expected result it can be used to validate that search parameters filters data , validate clear grid after clear action and validate  deleted record from grid                                                                                                                             
 * Input:There are four inputs required for this function (String actionType, String fileName ,String sheetName , List expectedValues = [], int uniqueColumn) 
 * Output:Ensure that record is matched with expected record or not 
 */
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.ExcelData
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType

public class CS_WebtableVerification{
	String webtableAttribute
	String webtablelocatorValue
	WebElement Table
	List<WebElement> rows_table
	@Keyword

	//Setting keyword inputs
	ValidateSearchParameters (String actionType, String fileName ,String sheetName , List expectedValues = [], int uniqueColumn ) {
		List<String> valueOfRow = new ArrayList<String>()
		// Take file name and sheet name to get object
		ExcelData  data = findTestData(fileName)
		data.changeSheet( sheetName)
		data.getAllData()
		int row
		int fieldNo
		int index
		//Looping on excel file of object
		for ( row = 1;  row < data.getRowNumbers()+1;  row++) {
			valueOfRow.add(data.getValue(1, row))
		}
		index = valueOfRow.indexOf("Table");
		webtableAttribute  = data.getValue(3,index+1)
		webtablelocatorValue  = data.getValue(4,index+1)
		List<String> Columns_row_text  = new ArrayList<String>()
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> Columns_row


		//To locate table'
		WebUI.delay(3)
		if (webtableAttribute=='xpath'){
			Table = driver.findElement(By.xpath(webtablelocatorValue))

		}
		else{
			Table = driver.findElement(By.xpath("//*[@"+webtableAttribute+"="+webtablelocatorValue+"]"))

		}

		//Next Page Button Locater Detection
		int indexNext_Page = valueOfRow.indexOf("NextPage");
		TestObject NextPage = new TestObject()
		NextPage.addProperty(data.getValue(3, indexNext_Page+1), ConditionType.EQUALS, data.getValue(4, indexNext_Page+1))
		String NextPageAttribute =  data.getValue(5, indexNext_Page+1)
		String NextPageAttribute_Value =  data.getValue(6, indexNext_Page+1)

		//First Page Button Locater Detection
		int indexFirst_Page = valueOfRow.indexOf("FirstPage");
		TestObject FirstPage = new TestObject()
		FirstPage.addProperty(data.getValue(3, indexFirst_Page+1), ConditionType.EQUALS, data.getValue(4, indexFirst_Page+1))
		//End of First Page Button Locater Detection

		//Navigating to First Page
		WebUI.click(FirstPage)
		WebUI.delay(2)

		//To locate rows of table it will Capture all the rows available in the table
		rows_table = Table.findElements(By.tagName('tr'))
		//To calculate no of rows In table'
		int rows_count = rows_table.size()

		//Loop will execute for all the rows of the table
		Loop:
		int rowTable = 1
		for (rowTable ; rowTable < rows_count; rowTable++) {

			println rowTable
			//To locate columns(cells) of that specific row'

			Columns_row = rows_table.get(rowTable).findElements(By.tagName('td'))
			//To calculate no of columns(cells) In that specific row
			int columns_count = expectedValues.size()
			println (Columns_row.get(uniqueColumn).getText())
			//Checking if firstCell text is matched with the expected value
			if ((Columns_row.get(uniqueColumn).getText() != expectedValues[uniqueColumn])&&(rowTable==rows_count - 1)&&(WebUI.getAttribute(NextPage,NextPageAttribute)==NextPageAttribute_Value)) {
				WebUI.click(NextPage)
				WebUI.delay(3)
				println "no in page "
				rows_table = Table.findElements(By.tagName('tr'))
				println " soma "
				//To calculate no of rows In table'
				rows_count = rows_table.size()
				rowTable=0

			}
			else if (Columns_row.get(uniqueColumn).getText() == expectedValues[uniqueColumn]) {
				println "yes in page "
				for (int column = 0 ; column < columns_count ;column++){

					Columns_row_text.add(Columns_row.get(column).getText())
				}
				break
			}
		}

		//Compare the actual record with expected record data inserted as inputs to the keyword according tp required action
		if (actionType=='SearchYes'){
			assert Columns_row_text == expectedValues
			assert rows_count == 2
		}
		else if(actionType=='Clear'){
			assert Columns_row.size() == 1
		}
		else if(actionType=='DeleteYes'){
			assert Columns_row_text == []
		}
		else {
			assert Columns_row_text == expectedValues

		}
	}

}

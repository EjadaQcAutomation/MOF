package pk_Functions
/* Created By ‘Asmaa El-Sayed and Ebtehal Gamal Yusuf ’
 * Date 13/02/2019
 * Usage:This function is used Update or Delete or View records listed in excel sheet by checking flags over webtable with multiple pages
 * Input: There are six inputs required for this function 
 1.actionType: Update or Delete or View
 2.expectedValueColumn: the column where unique id is located in table 
 3.actionButtonColumn: the column where action button is located in table 
 4.objectfileName: The file name of object repositories
 5.objectsheetName: Sheet name in excel file
 6.code: The column in excel sheet which contains unique id 
 * Output: All records in excel file are updated or deleted according to Delete and Update flag in file
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
import com.kms.katalon.core.testdata.ExcelData
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import javax.lang.model.element.VariableElement
import login_object.loginObject.*
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import internal.GlobalVariable
public class CS_ClickingonActionButtonswithPagination {
	TestObject delete
	int row
	int fieldNo
	int index
	int rowT
	int indexT
	int indexDelete
	WebElement Table
	int PagesCount=0
	int Matched=0
	int x
	int z
	int rows_count
	List<WebElement> Cols
	List<WebElement> RowsN = new ArrayList<WebElement>()

	@Keyword

	SelectRecordFromWebtableFun (String actionType,int expectedValueColumn, int actionButtonColumn ,String objectfileName,String objectsheetName, String code) {



		WebDriver ndriver = DriverFactory.getWebDriver()

		//Table locater____________________
		List<String> valueOfRowT = new ArrayList<String>()
		// Take file name and sheet name to get object
		ExcelData  dataObject = findTestData(objectfileName)
		dataObject.changeSheet(objectsheetName)
		dataObject.getAllData()
		//Looping on excel file of object
		for ( rowT = 1;  rowT < dataObject.getRowNumbers()+1;  rowT++) {
			valueOfRowT.add(dataObject.getValue(1, rowT))
		}
		indexT = valueOfRowT.indexOf("Table");
		String  webtableAttribute  = dataObject.getValue(3,indexT+1)
		String webtablelocatorValue  = dataObject.getValue(4,indexT+1)
		if (webtableAttribute=='xpath'){
			Table = ndriver.findElement(By.xpath(webtablelocatorValue))
		}
		else{
			Table = ndriver.findElement(By.xpath("//*[@"+webtableAttribute+"="+webtablelocatorValue+"]"))
		}
		//End of table locater____________________

		//Next Page Button Locater Detection
		int indexNext_Page = valueOfRowT.indexOf("NextPage");
		//println indexNext_Page
		TestObject NextPage = new TestObject()
		NextPage.addProperty(dataObject.getValue(3, indexNext_Page+1), ConditionType.EQUALS, dataObject.getValue(4, indexNext_Page+1))
		String NextPageAttribute =  dataObject.getValue(5, indexNext_Page+1)
		String NextPageAttribute_Value =  dataObject.getValue(6, indexNext_Page+1)

		//First Page Button Locater Detection
		int indexFirst_Page = valueOfRowT.indexOf("FirstPage");
		//println indexFirst_Page
		TestObject FirstPage = new TestObject()
		FirstPage.addProperty(dataObject.getValue(3, indexFirst_Page+1), ConditionType.EQUALS, dataObject.getValue(4, indexFirst_Page+1))
		//End of First Page Button Locater Detection

		//Navigating to First Page
		WebUI.click(FirstPage)
		WebUI.delay(2)

		if(actionType=="UpdateYes" ||actionType== "DeleteYes" ||actionType== "DeleteNo" || actionType== "ViewYes" ){

			//Extracting Rows of each webtable page
			RowsN = Table.findElements(By.tagName('tr'))
			println RowsN.size()
			rows_count = RowsN.size()

			//Looping over each row to get it column data to compare it to expected value
			table: for (int i = 1; i < rows_count; i++) {
				x++
				//Extracting data from each row
				Cols = RowsN.get(i).findElements(By.tagName('td'))
				println  ('Cols1:' + x )

				//Looping over pages
				if ((Cols.get(expectedValueColumn).getText() != code)&&(i==rows_count- 1)&&(WebUI.getAttribute(NextPage,NextPageAttribute)==NextPageAttribute_Value)) {
					WebUI.click(NextPage)
					WebUI.delay(3)
					println "yes in page "
					RowsN = Table.findElements(By.tagName('tr'))
					println " Rows are detected  "

					//Counter is reset to start looping over new page
					//To calculate no of rows In table'
					rows_count = RowsN.size()
					i=0
				}

				//Comparing  expected unique id of unique id in row
				else if(Cols.get(expectedValueColumn).getText().equalsIgnoreCase(code)) {
					Matched =1
					println "Matched"
					//Taking action to the selected record according to actionType input
					if (actionType=='UpdateYes'){
						println 'UpdateYes'
						//Clicking on Update for the selected record in grid
						Cols.get(actionButtonColumn).findElement(By.xpath('span/button[2]')).click();
					}
					else if ((actionType=='DeleteNo') || (actionType=='DeleteYes') ){
						//Clicking on Delete for the selected record in grid
						Cols.get(actionButtonColumn).findElement(By.xpath('span/button[3]')).click() ;

						//Locating Delete No or Delete Yes button according to actionType variable
						indexDelete = valueOfRowT.indexOf(actionType);
						int indexPopUp = valueOfRowT.indexOf("pop_up");
						println indexPopUp
						TestObject PopUp = new TestObject()
						PopUp.addProperty(dataObject.getValue(3, indexPopUp+1), ConditionType.EQUALS, dataObject.getValue(4, indexPopUp+1))
						println (dataObject.getValue(4, indexPopUp+1))
						delete = new TestObject()
						delete.addProperty(dataObject.getValue(3, indexDelete+1), ConditionType.EQUALS, dataObject.getValue(4, indexDelete+1))
						WebUI.delay(1)
						WebUI.click(PopUp)
						WebUI.delay(1)
						println " delete"
						//Click on No or Yes in deletion alert
						WebUI.click(delete)
					}
					//Clicking on View for the selected record in grid
					else if (actionType=='ViewYes'){
						WebUI.delay(1)
						Cols.get(actionButtonColumn).findElement(By.xpath('span/button[1]')).click() ;
					}
					break
				}
			}



		}

	}
}


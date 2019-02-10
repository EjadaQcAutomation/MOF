package pk_Functions
/* Created By ‘Asmaa El-Sayed and Ebtehal Gamal Yusuf ’
 * Date 04/02/2019
 * Usage:This function is Update or Delete records listed in excel sheet by checking flags
 * Input: There are six inputs required for this function 
 1.actionType: Update or Delete
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
public class CS_ClickingonUpdateorDeletebutton_Fulltabl {
	TestObject delete
	int row
	int fieldNo
	int index
	int rowT
	int indexT
	int indexDelete
	WebElement Table
	private static TestObject dropdown = null;
	private static List<WebElement> allItems= null;
	private static WebElement dropDownList;
	//TestObject button
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

		//Detecting NextPage button and its attribute
		int indexNext_Page = valueOfRowT.indexOf("NextPage");
		println indexNext_Page
		TestObject NextPage = new TestObject()
		NextPage.addProperty(dataObject.getValue(3, indexNext_Page+1), ConditionType.EQUALS, dataObject.getValue(4, indexNext_Page+1))
		println (dataObject.getValue(4, indexNext_Page+1))
		String NextPageAttribute =  dataObject.getValue(5, indexNext_Page+1)
		String NextPageAttribute_Value =  dataObject.getValue(6, indexNext_Page+1)
//Locating Last Page
		int indexLast_Page = valueOfRowT.indexOf("LastPage");
		println indexLast_Page
		TestObject LastPage = new TestObject()
		LastPage.addProperty(dataObject.getValue(3, indexLast_Page+1), ConditionType.EQUALS, dataObject.getValue(4, indexLast_Page+1))
		println (dataObject.getValue(4, indexLast_Page+1))
		String LastPageAttribute =  dataObject.getValue(5, indexLast_Page+1)
		String LastPageAttribute_Value =  dataObject.getValue(6, indexLast_Page+1)
		//		//Detecting PreviousPage button and its attribute
		//		int indexPrevious_Page = valueOfRowT.indexOf("PreviousPage");
		//		println indexPrevious_Page
		//		TestObject PreviousPage = new TestObject()
		//		PreviousPage.addProperty(dataObject.getValue(3, indexPrevious_Page+1), ConditionType.EQUALS, dataObject.getValue(4, indexPrevious_Page+1))
		//		println (dataObject.getValue(4, indexPrevious_Page+1))
		//		dataObject.getValue(3, indexPrevious_Page+1)
		//		String PreviousPageAttribute =  dataObject.getValue(5, indexPrevious_Page+1)
		//		String PreviousPageAttribute_Value =  dataObject.getValue(6, indexPrevious_Page+1)
		//		//WebUI.click(PopUp)

		//_________

		//Detecting Update or Delete flag in excel file according to actionType variable
		//Saving Grid rows in list
		//String ClickableNext = WebUI.getAttribute(nextPage,'tabindex')
		List<WebElement> Rows = new ArrayList<WebElement>()
		Rows = Table.findElements(By.tagName('tr'))
		println Rows.get(0).getText()
		//println Rows.get(10).getText()
		println  ('Rows0:'+ Rows.size())
		WebUI.delay(6)
		println WebUI.getAttribute(NextPage,'tabindex')
		//TestObject LastPage = new TestObject()
		//LastPage.addProperty("xpath", ConditionType.EQUALS,"//*[@id='app-form']/div/app-body/div/div/div[2]/div[2]/app-event-categories-management-layout/div/div[2]/div/app-event-categories-management-list/p-panel/div/div[2]/div[1]/div/div/p-datatable/div/p-paginator/div/a[4]")
		while(WebUI.getAttribute(NextPage,'tabindex')=="0"){
			WebUI.delay(10)
			WebUI.click(NextPage)
			WebUI.delay(10)
			//println Rows.get(9).getText()
			Rows.addAll(Table.findElements(By.tagName('tr')))
			println  ('Rows1:'+ Rows.size())
			WebUI.delay(5)
		}
		println Rows.get(24).getText()
	
		//println  ('Rows3:'+ Rows.getvalue())
		//		WebDriver driver = DriverFactory.getWebDriver()
		//		// Getting all items in list called allItems
		//		allItems = driver.findElements(By.xpath("//*[@id='app-form']/div/app-body/div/div/div[2]/div[2]/app-event-categories-management-layout/div/div[2]/div/app-event-categories-management-list/p-panel/div/div[2]/div[1]/div/div/p-datatable/div/p-paginator/div/span"));
		//		int Ribbon_Size
		//		//Get the number of list items in the ribbon and turn it into a List
		//		Ribbon_Size =allItems.size()
		//		println  (Ribbon_Size)

		//		if(actionType=="Update" ||actionType== "DeleteYes" ||actionType== "DeleteNo"){
		//
		//			//Loop will execute for all the rows of the table'
		//			table: for (int i = 1; i < Rows.size(); i++) {
		//
		//				//To locate columns(cells) of that specific row'
		//				List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
		//
		//				//Detecting unique id of records that contains Update or Delete
		//				if (Cols.get(expectedValueColumn).getText().equalsIgnoreCase(code)) {
		//					WebUI.delay(4)
		//					//Doing action to the selected record according to actionType input
		//
		//					if (actionType=='Update'){
		//						println 'update'
		//
		//						//Clicking on Update for the selected record in grid
		//						Cols.get(actionButtonColumn).findElement(By.xpath('span/button[2]')).click() ;
		//						WebUI.delay(4)
		//
		//					}
		//					else if ((actionType=='DeleteNo') || (actionType=='DeleteYes') ){
		//
		//						//Clicking on Delete for the selected record in grid
		//						Cols.get(actionButtonColumn).findElement(By.xpath('span/button[3]')).click() ;
		//
		//						//Locating Delete No or Delete Yes button according to actionType variable
		//						indexDelete = valueOfRowT.indexOf(actionType);
		//						int indexPopUp = valueOfRowT.indexOf("pop_up");
		//						println indexPopUp
		//						TestObject PopUp = new TestObject()
		//						PopUp.addProperty(dataObject.getValue(3, indexPopUp+1), ConditionType.EQUALS, dataObject.getValue(4, indexPopUp+1))
		//						println (dataObject.getValue(4, indexPopUp+1))
		//						delete = new TestObject()
		//						delete.addProperty(dataObject.getValue(3, indexDelete+1), ConditionType.EQUALS, dataObject.getValue(4, indexDelete+1))
		//						WebUI.delay(2)
		//						WebUI.click(PopUp)
		//						WebUI.delay(3)
		//
		//						println " delete"
		//						//Click on No or Yes in deletion alert
		//						WebUI.click(delete)
		//					}
		//					break
		//				}
		//			}
		//		}
	}
}


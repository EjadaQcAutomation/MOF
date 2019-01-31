package pk_Functions
/* Created By ‘Asmaa El-Sayed and Ebtehal Gamal Yusuf ’
 * Date 21/01/2019
 * Usage:This function is used to select record from webtable and click on any action button
 * Input: There are four inputs required for this function (Webtable locator ,Expected Value,Exepcted Value Column Value and Action Button Column Value) 
 * Output: Required record is located and actions button can be deteceted 
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
public class testClick {
	//TestObject button
	@Keyword
	SelectRecordFromWebtableFun (String actionType,int expectedValueColumn,int flagColumn, int actionButtonColumn ,String objectfileName,String objectsheetName,String datafileName ,String datasheetName) {

		int row
		int fieldNo
		int index
		int rowT
		int indexT
		int indexDelete
		WebElement Table
		WebElement Delete
		WebDriver ndriver = DriverFactory.getWebDriver()
		println flagColumn
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

		//End of table locater____________________

		//Get all ids with Update Flag or Delete________
		List<String> valueOfRow = new ArrayList<String>()
		// Take file name and sheet name to get object
		ExcelData  data = findTestData(datafileName)
		data.changeSheet(datasheetName)
		data.getAllData()

		println(data.getValue(flagColumn, 1))
		List<String> updatedRecords = new ArrayList<String>()
		//Looping on excel file of object
		for ( row = 1;  row < data.getRowNumbers()+1;  row++) {
			//println('yes')
			//valueOfRow.add(data.getValue(1, row))
			if (data.getValue(flagColumn, row)==actionType){
				updatedRecords.add(data.getValue(1,row))
				println('yes')
				println updatedRecords[row-1]
			}
		}

		//To locate rows of table it will Capture all the rows available in the table '

		List<WebElement> Rows = Table.findElements(By.tagName('tr'))
		//println('No. of rows: ' + Rows.size())


		//Loop will execute for all the rows of the table'
		table: for (int i = 1; i < Rows.size(); i++) {
			//To locate columns(cells) of that specific row'
			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
			//println('No. of colns: ' + Cols.size())
			//Verifying the expected text in the each cell in specified column
			if (Cols.get(expectedValueColumn).getText().equalsIgnoreCase(updatedRecords[GlobalVariable.y])) {

				//2To locate anchor in the expected value matched row to perform action'
				WebUI.delay(4)
				//Doing action to the selected record by clicking on actions button in predefined column
				if (actionType=='Update'){
					Cols.get(actionButtonColumn).findElement(By.xpath('span/button[2]')).click() ;
					WebUI.delay(4)
				}
				else if ((actionType=='DeleteNo') || (actionType=='DeleteYes') ){
					Cols.get(actionButtonColumn).findElement(By.xpath('span/button[3]')).click() ;
					WebUI.delay(1)
					//Locating Delete Yes button

					indexDelete = valueOfRowT.indexOf(actionType);

					if ( dataObject.getValue(3,indexDelete+1)=='xpath'){
						Delete = ndriver.findElement(By.xpath(dataObject.getValue(4,indexDelete+1)))
					}
					else{
						Delete = ndriver.findElement(By.xpath("//*[@"+ dataObject.getValue(3,indexDelete+1)+"="+dataObject.getValue(4,indexDelete+1)+"]"))
					}
					Delete.click()

				}
				break
			}
		}
		(GlobalVariable.y)++

	}
}




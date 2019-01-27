package pk_Functions
/* Created By ‘Ebtehal Gamal Yusuf’
 * Date 06/01/2019
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
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable as GlobalVariable
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

public class CS_SelectRecordFromWebtable {

	@Keyword
	SelectRecordFromWebtableFun (String webtableId , String expectedValue , int expectedValueColumn , int actionButtonColumn ) {

		WebDriver ndriver = DriverFactory.getWebDriver()

		//To locate table'
		WebElement Table = ndriver.findElement(By.id(webtableId))

		//To locate rows of table it will Capture all the rows available in the table '
		List<WebElement> Rows = Table.findElements(By.tagName('tr'))
		println('No. of rows: ' + Rows.size())

		//Find a matching text in a table and performing action'
		//Loop will execute for all the rows of the table'
		table: for (int i = 1; i < Rows.size(); i++) {
			//To locate columns(cells) of that specific row'
			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
			println('No. of colns: ' + Cols.size())

			// for (int j = 0; j < Cols.size(); j++) {
			//Verifying the expected text in the each cell in specified column
			if (Cols.get(expectedValueColumn).getText().equalsIgnoreCase(expectedValue)) {

				//2To locate anchor in the expected value matched row to perform action'
				//Cols.get(4).findElement(By.tagName('a')).click()
				WebUI.delay(4)

				//Doing action to the selected record by clicking on actions button in predefined column
				Cols.get(actionButtonColumn).findElement(By.tagName('a')).click() ;
				WebUI.delay(4)
				break
			}
		}
	}
}

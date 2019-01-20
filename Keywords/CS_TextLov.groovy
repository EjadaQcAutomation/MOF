package pk_Functions

//created By:Asmaa Elsayed Ibrahim
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
import com.kms.katalon.core.testdata.reader.ExcelFactory
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testdata.ExcelData
import internal.GlobalVariable

public class CS_TextLov {

	@Keyword

	TextLovFun (  String fileName , String sheetName , List<TestObject> fieldsData ){

		List<TestObject> listObject = new ArrayList<TestObject>((new pk_Functions.CS_AllPageObject()).AllPageObjectFun (fileName , sheetName ))

		int column
		ExcelData  data = findTestData(fileName)
		data.changeSheet( sheetName)

		//loop for setting data into list object that stored in list using AllPageObjectFun function
		for (column = 1; column <= listObject.size(); column++) {


			if (data.getValue(4, column)=="txt"){

				WebUI.setText(listObject[(column - 1)], fieldsData[(column-1)])

			}else if (data.getValue(4, column)=="lov-select-tag"){

				WebUI.selectOptionByLabel(listObject[(column - 1)],fieldsData[(column-1)], false)

			}else if (data.getValue(4, column)=="lov-ul-tag"){

				String string =data.getValue(3 , column)
				String[] parts = string.split("&&&")
				String part1 = parts[0]
				String part2 = parts[1]
				println part1
				println part2
				println fieldsData[(column-1)]

				//	(new pk_Functions.CS_StaticListUsingLiTag()).LovSearchFun (part1 , part2 ,fieldsData[(column-1)] )
				//	(new pk_Functions.CS_StaticListUsingLiTag()).LovMatchItemsFun (part1 , part2 ,[])

				(new pk_Functions.CS_StaticListUsingLiTag()).LovSearchFun (part1 , part2 ,fieldsData[(column-1)] )

			}
		}
	}
}

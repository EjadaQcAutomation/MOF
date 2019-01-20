package pk_Functions

/*Created By " Asmaa Elsayed Ibrahim
 * Date 25/12/2018
 * Function :'this class contains six functions 
 * First one for connection with DB 
 * Second one for writing query 
 * Third one for close connection 
 * Forth one for getting result as one string 
 * Fifth one for using the above functions in order (open connection ,writing query , getting result , close connection )
 * Input :  we use the fifth function with input as( localHost ,  port ,  serverName ,  username,  password , Query)
 * Output : output of the fifth function is string value used for verify text
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
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.awt.List
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Driver;
import internal.GlobalVariable
import java.sql.ResultSetMetaData;
public class CS_DataBase {
	private static Connection connection = null;
	private static ResultSet rs = null;
	private static String cell_insert ;
	private static ArrayList<ArrayList<String>> list1 = new ArrayList<ArrayList<String>>()
	private static ArrayList<String> list2 = new ArrayList<String>()


	@Keyword
	Connection connectDB_OrcalSql(String localHost , String port , String serverName , String username, String password){

		if(connection != null && !connection.isClosed()){
			connection.close()
		}

		//Load mysql jdbc driver
		String driverName = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);

		//Create Connection to DB
		connection = DriverManager.getConnection("jdbc:oracle:thin:@//"+localHost+":"+port+"/"+serverName,username,password);


		return connection
	}


	@Keyword
	def executeQuery_OrcalSql(String queryString  ) {
		Statement stm = connection.createStatement()
		rs = stm.executeQuery(queryString)
		return rs
	}

	@Keyword
	def closeDatabaseConnection_OrcalSql() {
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = null
	}


	//	@Keyword
	//	def execute_OrcalSql(String queryString) {
	//		Statement stm = connection.createStatement()
	//		boolean result = stm.execute(queryString)
	//		println  result
	//		return result
	//	}

	@Keyword
	def result_OrcalSql() {

		//No Of Column

		ResultSetMetaData rsmd = rs.getMetaData()

		int NumOfCol=rsmd.getColumnCount()

		System.out.println("Query Executed!! No of Colm="+NumOfCol)

		int i
		int y =1
		String cell_insert


		while (rs.next()){

			list2 = new ArrayList<String>()

			for (i =1 ; i <= NumOfCol; i++ ){

				cell_insert = rs.getString(i)

				list2.add(cell_insert)
			}
			list1.add(list2)
		}

		return 	 list1
	}

	@Keyword
	def DbaseFun(String localHost , String port , String serverName , String username, String password , String Query){

		connectDB_OrcalSql(localHost, port, serverName , username, password)

		executeQuery_OrcalSql(Query)

		ArrayList<ArrayList<String>>  result = result_OrcalSql()

		//List<String> list2=result_OrcalSql()

		closeDatabaseConnection_OrcalSql()

		return result
	}

}

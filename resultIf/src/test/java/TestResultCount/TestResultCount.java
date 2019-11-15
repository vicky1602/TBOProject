package TestResultCount;

import org.apache.commons.mail.EmailException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Report.sending_email;
import ResultCount.ResultCount;
import io.restassured.RestAssured;
import utility.ExcelReader;
import Resources.base;

public class TestResultCount extends ResultCount {

	public static ExcelReader exe = new ExcelReader("E:\\Testexcel.xls");
	// public static String domestic_orgin=exe.getCellData("Sheet1", 0, 4);
	// public static String domestic_destination=exe.getCellData("Sheet1", 1, 4);
	// public static String international_orgin=exe.getCellData("Sheet1", 0, 3);
	// public static String international_destination=exe.getCellData("Sheet1", 1,
	// 3);
	public static String PreferredDepartureTime = exe.getCellData("Sheet1", 2, 2);
	public static String PreferredDepartureTime1 = exe.getCellData("Sheet1", "PreferredDepartureTime", 2);
	public static String PreferredArrivalTime = exe.getCellData("Sheet1", "PreferredArrivalTime", 2);

	@BeforeMethod
	public static void URLForAPI() {
		RestAssured.baseURI = prop.getProperty("url");

	}

	@Test(priority = 1)
	public static void LccDomesticOneWayOneAdult_Case1() {
		OneWaySearch(1, 0, 0, "DAC", "JSR", PreferredDepartureTime, PreferredArrivalTime, 2);
		ResultCount(2);
		SupplierWiseCount(2);
	}

	@Test(priority = 2)
	public static void DomesticOneWayOneAdult_Case1() {
		OneWaySearch(1, 0, 0, "BKK", "SIN", PreferredDepartureTime, PreferredArrivalTime, 3);
		ResultCount(3);
		SupplierWiseCount(3);
	}

	@Test(priority = 3)
	public static void DomesticOneWayTwoAdult_Case1() {
		OneWaySearch(1, 0, 0, "DXB", "MNN", PreferredDepartureTime, PreferredArrivalTime, 4);
		ResultCount(4);
		SupplierWiseCount(4);
	}

	@Test(priority = 4)
	public static void DomesticOneWayTAdult1_Case1() {
		OneWaySearch(1, 0, 0, "CAI", "DXB", PreferredDepartureTime, PreferredArrivalTime, 5);
		ResultCount(5);
		SupplierWiseCount(5);
	}

	/*
	 * //@Test(priority=5) public static void DomesticOneWayTWAdult_Case1() {
	 * OneWaySearch(1,0,0,"BAH","BGW",PreferredDepartureTime,PreferredArrivalTime,6)
	 * ; ResultCount(6); SupplierWiseCount(6); }
	 */
/////////////////////////////////////////////////
	@Test(priority = 5)
	public static void AirArabia_Case1() {
		OneWaySearch(1, 0, 0, "SHJ", "COK", PreferredDepartureTime, PreferredArrivalTime, 7);
		ResultCount(7);
		SupplierWiseCount(7);
	}

	@Test(priority = 6)
	public static void Sabre_Case1() {
		OneWaySearch(1, 0, 0, "MNL", "HKG", PreferredDepartureTime, PreferredArrivalTime, 8);
		ResultCount(8);
		SupplierWiseCount(8);
	}

	/*
	 * @Test(priority=8) public static void AirIndiaExpress_Case1() {
	 * OneWaySearch(1,0,0,"AUH","DEL",PreferredDepartureTime,PreferredArrivalTime,9)
	 * ; ResultCount(9); SupplierWiseCount(9); }
	 */

	@Test(priority = 7)
	public static void Mondee_Case1() {
		OneWaySearch(1, 0, 0, "LAX", "SIN", PreferredDepartureTime, PreferredArrivalTime, 10);
		ResultCount(10);
		SupplierWiseCount(10);
	}

	/*
	 * //@Test(priority=10) public static void TravelFusion_Case1() {
	 * OneWaySearch(1,0,0,"RUH","JED",PreferredDepartureTime,PreferredArrivalTime,11
	 * ); ResultCount(11); SupplierWiseCount(11); }
	 */
//	@Test(priority=8)
	public static void FlightExpertAmadeus_Case1() {
		OneWaySearch(1, 0, 0, "DAC", "DXB", PreferredDepartureTime, PreferredArrivalTime, 12);
		ResultCount(12);
		SupplierWiseCount(12);
	}

	/*
	 * //@Test(priority=12) public static void PKFare_Case1() {
	 * OneWaySearch(1,0,0,"BKK","NGO",PreferredDepartureTime,PreferredArrivalTime,13
	 * ); ResultCount(13); SupplierWiseCount(13); }
	 */
	@Test(priority = 9)
	public static void PegasusAirways_Case1() {
		OneWaySearch(1, 0, 0, "CGK", "JED", PreferredDepartureTime, PreferredArrivalTime, 14);
		ResultCount(14);
		SupplierWiseCount(14);
	}

	@Test(priority = 10)
	public static void AvivaCenterAmadeus_Case1() {
		OneWaySearch(1, 0, 0, "CAN", "PEK", PreferredDepartureTime, PreferredArrivalTime, 15);
		ResultCount(15);
		SupplierWiseCount(15);
	}

	@Test(priority = 11)
	public static void FlightExperAmadeus_Case1() {
		OneWaySearch(1, 0, 0, "GYD", "TBS", PreferredDepartureTime, PreferredArrivalTime, 6);
		ResultCount(6);
		SupplierWiseCount(6);
	}

	/*
	 * //@Test(priority=15) public static void AbbeyTravelAmadeus_Case1() {
	 * OneWaySearch(1,0,0,"CGK","DXB",PreferredDepartureTime,PreferredArrivalTime,16
	 * ); ResultCount(16); SupplierWiseCount(16); }
	 */
		@AfterClass
	public static void sendreport() throws EmailException {
		sending_email.attachement();
		// report.endTest(test);
		// report.flush();
	}

}

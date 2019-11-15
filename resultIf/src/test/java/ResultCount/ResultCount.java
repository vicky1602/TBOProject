package ResultCount;

import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import OnewaySearch.OnewayBody;
import Resources.base;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import one.util.streamex.StreamEx;
import utility.ExcelReader;

public class ResultCount extends base {
	
	public static ExcelReader exe=new ExcelReader("E:\\TimeSuplierCount.xls");
	public static long lStartTime;
	public static long lEndTime;
	public static long output;
	public static JsonPath jsonway;
	public static String ResultID;
	public static ArrayList<String> ResultID1;
	public static HashMap<Integer,String> hm=new HashMap<Integer,String>();
	public static String Supplier;
	
	public static void outputtime(int rownum)
	{
		output = lEndTime - lStartTime;
		System.out.println("Elapsed time in milliseconds in oneway search: " + output / 1000000);
		String TimeTaken=Long.toString(output/ 1000000);
		exe.setCellData("Sheet1", "TimeCompleteSearch", rownum, TimeTaken);
	}
	
	
	public static void OneWaySearch(int adultcount, int childCount, int infantCount, String orgin, String destination,
			String PreferredDepartureTime, String PreferredArrivalTime,int row) 
	{
		lStartTime = System.nanoTime();
		Response res = given().header("Content-Type", "application/json")
				.body(OnewayBody.body(adultcount, childCount, infantCount, orgin, destination, PreferredDepartureTime, PreferredArrivalTime))
				.post("/V1/Search/Search").then().statusCode(200).extract().response();
			lEndTime = System.nanoTime();
			outputtime(row);
			
		String response = res.asString();
		jsonway = new JsonPath(response);
		String Errormessage = jsonway.get("Errors[0].UserMessage");
		System.out.println("Error message is "+Errormessage);
		String TrackingID = jsonway.get("TrackingId");
		ResultID = jsonway.get("Results[0][0].ResultId");
		exe.setCellData("Sheet1", "Origin", row, orgin);
		exe.setCellData("Sheet1", "Destination", row, destination);
	}
	
		public static void ResultCount(int row)
		{
			int count = 0;
			String NoResult="No Result Found";
			ResultID1=jsonway.get("Results[0]");
			if(ResultID!=NoResult)
			{
				for(int i=0;i<ResultID1.size()-1;i++)
				{
					jsonway.get("Results[0][" + i + "]");
					count++;
				}
			System.out.println("Total result count are "+ count);
			String Count=Integer.toString(count) ;
			exe.setCellData("Sheet1", "ResultCount", row, Count);
			}	
		}
		
		public static void SupplierWiseCount(int row)
		{
			List<Integer> list1 = new ArrayList<Integer>();
			for(int i=0;i<ResultID1.size()-1;i++)
				{	
					list1.add((Integer) jsonway.get("Results[0]["+ i +"].ResultBookingSource"));
				}
			System.out.println(list1);
			
			Map<Integer, Integer> duplicates = new HashMap<Integer, Integer>();
			int count = 0;
			for (Integer str : list1) {
		         if (duplicates.containsKey(str)) {
		            duplicates.put(str, duplicates.get(str) + 1);
      
		         } else {
		            duplicates.put(str, 1);
		            count++;
		            System.out.println(count);
		         }
		      }
		 
			int i=1;
		      for (Entry<Integer, Integer> entry : duplicates.entrySet()) {
		    	  	System.out.println(entry.getKey() + " = " + entry.getValue());
		    	  	Supplier=Integer.toString(entry.getKey());
		    	  System.out.println("Value of supplier is " +Supplier);
		    	  	//String Supplier1=hm.get(2);
		    	  	suppliername();
		    	  	String str=hm.get(entry.getKey()).toString(); 
		    	  //	System.out.println(suppliername(2));
		    	  	System.out.println("value from the hash map is " + hm.get(entry.getKey()));
		    	  	String ResultC=Integer.toString(entry.getValue());
		    	  	exe.setCellData("Sheet1", "Supplier"+i, row, str);
		    	  	exe.setCellData("Sheet1", "Count"+i, row, ResultC);
		    	  	i++;
		      }
		    	  	 
			       /*  do
			         {
			        	 
			        	 System.out.println("value of supplier is " +Supplier);
		        	 exe.setCellData("Sheet1", "Supplier"+i, 2, Supplier);
		        	
		        	
		        	 i++;
		         }while(i<=count);*/
	         }
		
		 		
		
		//Enum for the suppliername
		public static void suppliername()
		{
		   hm.put(0, "NoSource" );
		   hm.put(1, "UniversalAPI");	  		
		   hm.put(2,"TBOAir");		
		   hm.put(3,"Amadeus");	
		   hm.put(4	,"AirAsia");
		   hm.put(6	,"FlyDubai");
		   hm.put(7,"AirArabia");
		   hm.put(8,"Pyton");
		   hm.put(9	,"Sabre");
		   hm.put(16,"Iati");
		   hm.put(17,"Flynas ");
		   hm.put(18,"Indigo ");
		   hm.put(26,"Jazeera "	);
		   hm.put(27, "AirIndiaExpress");
		   hm.put(28, "FlyScoot");
		   hm.put(29, "Monde");
		   hm.put(30,"BlueSkyAmadeus");
		   hm.put(31,"DnataAmadeus");
		   hm.put(32,"TravelFusion");
		   hm.put(33,"ArabJetAmadeus");
		   hm.put(34, "XMLAgency");
		   hm.put(35,"FlightExpertAmadeus");
		   hm.put(36, "PKFare");
		   hm.put(37,"Galileo");
		   hm.put(38,"VoytraAmadeus");
		   hm.put(39,"BrightsunAmadeus");
		   hm.put(40,"SatGuruAmadeus");
		   hm.put(41,"PegasusAirways");
		   hm.put(42,"AvivaCenterAmadeus");
		   hm.put(43,"GMToursAmadeus");
		   hm.put(44,"AbbeyTravelAmadeus");
		   hm.put(45,"ShroffTravelAmadeus");
		   hm.put(46, "ClassicTravelAmadeus");
		}
			
}



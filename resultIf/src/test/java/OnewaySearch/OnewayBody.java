package OnewaySearch;

import java.util.ArrayList;
import java.util.List;

import Resources.base;
import utility.ExcelReader;
import utility.JavatoJsonConvertion;

public class OnewayBody  extends base{
	
	public static OnewayGetterSetter body(int AdultCount, int ChildCount,int InfantCount,String origin, String Destination,
			String PreferredDepartureTime,String PreferredArrivalTime )
	{
		OnewayGetterSetter result2=new OnewayGetterSetter();
		result2.setIPAddress("192.168.6.68");
		result2.setTokenId(prop.getProperty("TokenId"));
		//result2.setTokenId("7d0073b8-5e8a-4b60-a77a-5a9c80cbca42");
		result2.setJourneyType(1);
		result2.setAdultCount(AdultCount);
		result2.setChildCount(ChildCount);
		result2.setInfantCount(InfantCount);
		result2.setFlightCabinClass(1);
		ArrayList<Segment> all = new ArrayList<Segment>();
		all.add(OnewayBody.getSegmentResult(origin,Destination,PreferredDepartureTime,PreferredArrivalTime));
		result2.setSegment(all);
		System.out.println(JavatoJsonConvertion.JasonToJavaConvertor(result2));		
		return result2;
	}
	
	public static Segment getSegmentResult(String origin,String Destination,String PreferredDepartureTime,
			String PreferredArrivalTime ) 
	{
		Segment segment = new Segment();
		ExcelReader exe=new ExcelReader("E:\\Testexcel.xls");
		segment.setOrigin(origin);
		segment.setDestination(Destination);
		segment.setPreferredDepartureTime(PreferredDepartureTime);
		segment.setPreferredArrivalTime(PreferredArrivalTime);
		List<String> msg = new ArrayList<String>();
		//	msg.add(exe.getCellData("Sheet1", 4, 2));
		//msg.add(exe.getCellData("Sheet1", 4, 3));
		//msg.add(exe.getCellData("Sheet1", 4, 4));
		segment.setPreferredAirlines(msg);
		System.out.println(JavatoJsonConvertion.JasonToJavaConvertor(segment));
		return segment;
	}

}

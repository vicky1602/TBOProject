package OnewaySearch;

import java.util.ArrayList;

public class OnewayGetterSetter {

	private String IPAddress;
	private String TokenId;
	private int JourneyType;
	private int AdultCount;
	private int ChildCount;
	private int InfantCount;
	private int FlightCabinClass;
	private String PreferredCarrier;
	private ArrayList<Segment> segment;
	
	public ArrayList<Segment> getSegment() {
		return segment;
	}

	public void setSegment(ArrayList<Segment> segment) {
		this.segment = segment;
	}
	
	public String getIPAddress() {
		return IPAddress;
	}
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}
	public String getTokenId() {
		return TokenId;
	}
	public void setTokenId(String tokenId) {
		TokenId = tokenId;
	}
	public int getJourneyType() {
		return JourneyType;
	}
	public void setJourneyType(int journeyType) {
		JourneyType = journeyType;
	}
	public int getAdultCount() {
		return AdultCount;
	}
	public void setAdultCount(int adultCount) {
		AdultCount = adultCount;
	}
	public int getChildCount() {
		return ChildCount;
	}
	public void setChildCount(int childCount) {
		ChildCount = childCount;
	}
	public int getInfantCount() {
		return InfantCount;
	}
	public void setInfantCount(int infantCount) {
		InfantCount = infantCount;
	}
	public int getFlightCabinClass() {
		return FlightCabinClass;
	}
	public void setFlightCabinClass(int flightCabinClass) {
		FlightCabinClass = flightCabinClass;
	}
	public String getPreferredCarrier() {
		return PreferredCarrier;
	}
	public void setPreferredCarrier(String preferredCarrier) {
		PreferredCarrier = preferredCarrier;
	}
}
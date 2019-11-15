package OnewaySearch;

import java.util.List;

public class Segment {
	
	private String Origin;
	private String Destination;
	private String PreferredDepartureTime;
	private String PreferredArrivalTime;
	private List<String> PreferredAirlines;
	
	public String getOrigin() {
		return Origin;
	}
	public void setOrigin(String origin) {
		Origin = origin;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public String getPreferredDepartureTime() {
		return PreferredDepartureTime;
	}
	public void setPreferredDepartureTime(String preferredDepartureTime) {
		PreferredDepartureTime = preferredDepartureTime;
	}
	public String getPreferredArrivalTime() {
		return PreferredArrivalTime;
	}
	public void setPreferredArrivalTime(String preferredArrivalTime) {
		PreferredArrivalTime = preferredArrivalTime;
	}
	public List<String> getPreferredAirlines() {
		return PreferredAirlines;
	}
	public void setPreferredAirlines(List<String> preferredAirlines) {
		PreferredAirlines = preferredAirlines;
	}

}

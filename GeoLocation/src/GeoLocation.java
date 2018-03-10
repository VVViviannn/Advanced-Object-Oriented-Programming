package eecs2030.assignment;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;
 
public class GeoLocation {
	private final double longitude;
	private final double latitude;
	
	private static final Map<String, GeoLocation> instances = new TreeMap<String, GeoLocation>();
	private static final double EARTH_RADIUS = 6371.0;
	private static int count = 0;

	
	private GeoLocation(double longitude, double latitude){
		
	  if(latitude < -90 || latitude > 90) {
	   throw new IllegalArgumentException("Latitude must between -90 to +90.");
	  }
	  this.latitude = latitude;
	  
	  if(longitude < -180 || longitude > 180) {
	   throw new IllegalArgumentException("Longitude must between -180 to +180.");
	  }
	  
	  this.longitude = longitude;
	 }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeoLocation other = (GeoLocation) obj;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		return true;
	}
	
	public int getGMTHourOffset(){
		
		return (int) ((this.longitude) / 15);
	}
	
	@Override
	 public String toString() {
	  DecimalFormat myLongitudeFormatter = new DecimalFormat("000.0000");
	  DecimalFormat myLatitudeFormatter = new DecimalFormat("00.0000");
	  String logd = myLongitudeFormatter.format(longitude);
	  String latid = myLatitudeFormatter.format(latitude);
	  if (longitude < 0) {
	   if (latitude < 0) {
	    return "GeoLocation [longitude = " + logd + ", latitude = " + latid + "]";
	   } else {
		    return "GeoLocation [longitude = " + logd + ", latitude = +" + latid + "]";
		   }
		  } else {
		   if (latitude < 0) {
		    return "GeoLocation [longitude = +" + logd + ", latitude = " + latid + "]";
		   } else {
		    return "GeoLocation [longitude = +" + logd + ", latitude = +" + latid + "]";
		   }
		  }
		 }
}

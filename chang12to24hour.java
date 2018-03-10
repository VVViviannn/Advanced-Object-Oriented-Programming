package test2;

public class Hour {

	public static final String AM = "AM";
	public static final String PM = "PM";
	private int hour;
	
	public static boolean isValid(int hour){
		return hour >= 0 && hour <= 23;
	}
	
	public static boolean isValid(int hour, String ampm){
		return hour >= 0 && hour <= 12 && (ampm.equals(Hour.AM) ||ampm.equals(Hour.PM) );
	}
	
	//not good!
	public static void check12(int hour, String ampm){
		if(!Hour.isValid(hour, ampm)){
			throw new IllegalArgumentException("not valid 12-hour clock");
		}
	}
	
	public static void check24(int hour) {
        if (!Hour.isValid(hour)) {
            throw new IllegalArgumentException("not valid 24-hour clock");
        }
    }
	
	public static int to24HourClock(int hour, String ampm){
		Hour.check12(hour, ampm);
		if(hour == 12 && ampm.equals(Hour.AM)){
			return 0;
		}else if(ampm.equals(Hour.AM)){
			return hour;
		}else{
		return hour + 12;
		}
	}
	
	public static int to12HourClock(int hour){
		Hour.check24(hour);
		if(hour == 0 || hour == 12){
			return 0;
		}else if(hour < 12){
			return hour;
		}
		return hour - 12;
	}
	public int getHour(){
		return this.hour;
	}
	
	public void setHour(int hour){
		Hour.check24(hour);
		this.hour = hour;
	}
	
	public void setHour(int hour, String ampm){
		Hour.check12(hour, ampm);
		this.hour = Hour.to24HourClock(hour, ampm);
	}
	
	public boolean equals(String h){
		String[] parts = h.split(" ");
		int hour = Integer.parseInt(parts[0]);
		String ampm = parts[1];
		boolean eq = h != null && Hour.isValid(hour, ampm);
		if(eq){
			eq = this.hour == Hour.to24HourClock(hour, ampm);
		}
		return eq;
	}
	
	public Hour(int hour){
		Hour.check24(hour);
		this.hour = hour;
	}
	
	public Hour(int hour, String ampm){
		Hour.check12(hour, ampm);
		this.hour = Hour.to24HourClock(hour, ampm);
	}
	
	public Hour(Hour other){
		this.hour = other.hour;
	}
	
	public static void main(){
	Hour hour = new Hour(18);
		hour.equals("6 PM");
		hour.equals("6 AM");
		hour.equals("1 lalalal");
	}
}



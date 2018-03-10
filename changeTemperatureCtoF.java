package test2;


public class Temperature {
	public static final String CELCIUS = "C";
	public static final String FAHRENHEIT = "F";
	private double degC;
    private double degF;
    private String units;
	
	public double getTemperature(){
		if(this.units.equals(Temperature.CELCIUS)){
			return degC;
		}
		return degF;
	}
	
	public final void setTemperature(double temp){
		if(this.units.equals(Temperature.CELCIUS)){
			this.degC = temp;
		}
		this.degF = temp;
	}
	
	public String getUnits(){
		return this.units;
	}
	
	public final void setUnits(String units){
		if(this.units != Temperature.CELCIUS || this.units != Temperature.FAHRENHEIT ){
			throw new IllegalArgumentException("not valid units");
		}
		this.units = units;
	}
	
	public static double toCelcius(double degF){
			return (degF - 32.0) * (5.0 / 9.0);
	}
	
	public static double toFahrenheit(double degC){
		return  degC * (9.0 / 5.0) + 32.0;
	}
	
	
	public String toString(){
		if(this.units == Temperature.CELCIUS){
			return this.getTemperature() + Temperature.CELCIUS;
		}	
		else{
			return this.getTemperature() + Temperature.FAHRENHEIT;
		}
	}
	
	public Temperature(){
		this.degC = 0.0;
		//this(0.0, Temperature.CELCIUS);
	}
	
	public Temperature(Temperature other) {
        this(other.getTemperature(), other.getUnits());
    }

	 public Temperature(double temp, String units) {
	        this.setUnits(units);
	        this.setTemperature(temp);
	}

}

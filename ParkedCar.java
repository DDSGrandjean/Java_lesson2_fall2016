public class ParkedCar
{
	private ParkingMeter meter;
	
	private enum Make { Nissan, Subaru, Ferrarri, Lexus, Unidentified };
	private Make make = Make.Nissan;
	
	private String model;
	private String color;
	private String license;
	private int minutes;
	
	//Default Constructor
	public ParkedCar(){}
	
	/**
	 * ParkedCar class constructor
	 * @param make_b	the make of the car
	 * @param mod		the model of the car
	 * @param col		the color of the car
	 * @param licNum	the car's license number
	 * @param min		time car has been parked for
	 */
	public ParkedCar(String make_b, String mod, String col, String licNum, int min)
	{
		setMake(make_b);
		model = mod;
		color = col;
		license = licNum;
		minutes = min;
	}
	
	/**
	 * isEqual() compares a ParkedCar object to current object and returns true
	 * if they are the same, false if they are not.
	 * @param car the car to compare this object to.
	 * @return	Whether or not the cars are the same.
	 */
	public boolean isEqual(ParkedCar car)
	{
		if(meter.isEqual(car.meter) &
		   make.equals(car.getMake()) &
		   model.equals(car.getModel()) &
		   color.equals(car.getColor()) &
		   license.equals(car.getLicense()) &
		   minutes == car.getMinutes())
		   	return true;
		else
			return false;
	}
	/**
	 * setPArkingMeter() creates a parking meter object for a parked car.
	 * @param minutes Amount of time bought in minutes.
	 */
	public void setParkingMeter(int minutes) { meter = new ParkingMeter(minutes); }
	/**
	 * getParkingMeterTime() allows an officer to retrieve the purchased time on a meter.
	 * @return Purchased time on the meter.
	 */
	public int getParkingMeterTime() { return meter.getMinutes(); }
	/**
	 * setMake() sets the value of field make to make_b.
	 * @param make_b The make of the care.
	 */
	public void setMake(String make_b) 
	{ 
		switch (make_b.toUpperCase())
		{
			case "NISSAN":
				make = Make.Nissan;
				break;
			case "SUBARU":
				make = Make.Subaru;
				break;
			case "FERRARRI":
				make = Make.Ferrarri;
				break;
			case "LEXUS":
				make = Make.Lexus;
				break;
			default:
				make = Make.Unidentified;
				break;
		}
	}
	/**
	 * setModel() sets value of field model to mod.
	 * @param mod The model of the car.
	 */
	public void setModel(String mod) { model = mod; }
	/**
	 * setColor() sets value of field color to col.
	 * @param col The color of the car.
	 */
	public void setColor(String col) { color = col; }
	/**
	 * setLicense() sets the value of field license to licNum.
	 * @param licNum The car's license number.
	 */
	public void setLicense(String licNum) { license = licNum; }
	/**
	 * setMinutes() sets the value of field minutes to min.
	 * @param sec Amount of minutes purchased.
	 */
	public void setMinutes(int min) { minutes = min; }
	/**
	 * getMake() returns the value of field make.
	 * @return The make of the car.
	 */
	public String getMake() 
	{
		switch (make)
		{
			case Nissan:
				return "Nissan";
			case Subaru:
				return "Subaru";
			case Ferrarri:
				return "Ferrarri";
			case Lexus:
				return "Lexus";
			case Unidentified:
				return "Unidentified";
			default:
				return "Error - not found";
		}
	}
	/**
	 * getModel() returns the value of field model.
	 * @return The model of the car.
	 */
	public String getModel() { return model; }
	/**
	 * getColor() returns the value of field color.
	 * @return The color of the car.
	 */
	public String getColor() { return color; }
	/**
	 * getLicense() returns the value of field license.
	 * @return The car's license number.
	 */
	public String getLicense() { return license; }
	/**
	 * getMinutes() returns the value of field minutes
	 * @return The amount of minutes purchased.
	 */
	public int getMinutes() { return minutes; }
	
	/**
	 * toString() returns a formatted string.
	 * @return Formatted string.
	 */
	public String toString()
	{
		return String.format("*** Car ***\nMake: %s\nModel: %s\nColor: %d\nLicense: %s\nMinutes Parked: %d", 
						     make, model, color, license, minutes);
	}
}

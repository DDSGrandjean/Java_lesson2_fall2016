public class ParkingMeter 
{
	private int minutesPurchased;
	
	//Default constructor
	public ParkingMeter(){}
	
	/**
	 * isEqual() compares two ParkingMeter objects and returns true
	 * if they are the same, and false if they aren't.
	 * @param meter the object to compare this object to.
	 * @return	Whether or not the objects are the same.
	 */
	public boolean isEqual(ParkingMeter meter)
	{
		if(minutesPurchased == meter.minutesPurchased)
			return true;
		else
			return false;
	}
	/**
	 * ParkingMeter class constructor.
	 * @param min the amount of minutes purchased.
	 */
	public ParkingMeter(int min)
	{
		minutesPurchased = min;
	}
	/**
	 * setMinutes() sets the value of field minutesPurchased to min.
	 * @param min Amount of time purchased.
	 */
	public void setMinutes(int min) { minutesPurchased = min; }
	/**
	 * getMinutes() returns the amount of time purchased in minutes.
	 * @return Minutes purchased.
	 */
	public int getMinutes() { return minutesPurchased; }
	/**
	 * toString() returns a formatted string.
	 * @return Formatted string.
	 */
	public String toString()
	{
		return String.format("Minutes purchase: %d", minutesPurchased);
	}
}

public class PoliceOfficer 
{
	//Field declaration
	private ParkedCar illegalCar;	//Illegally parked car object
	private ParkingTicket ticket;	//Ticket generated if a fine is needed
	
	private String name;			//Officer's name
	private int badge;				//Officer's badge number
	
	//Default Constructor
	public PoliceOfficer(){}
	
	/**
	 * PoliceOfficer class constructor
	 * @param n			the officer's name
	 * @param badge_b	the officer's badge number
	 */
	public PoliceOfficer(String n, int badge_b)
	{
		name = n;
		badge = badge_b;
	}
	/**
	 * PoliceOfficer class constructor
	 * @param n			the officer's name
	 * @param badge_b	the officer's badge number
	 * @param car 		the car being inspected
	 */
	public PoliceOfficer(String n, int badge_b, ParkedCar car)
	{
		name = n;
		badge = badge_b;
		illegalCar = car;
	}
	/**
	 * checkMeter() compares the time purchased on the meter to how long the car
	 * has been parked for. If the car has been parked longer then it paid for,
	 * a fine is generated, else, the officer's walks away.
	 * @param car The car that is being inspected by the officer.
	 */
	public boolean checkMeter(ParkedCar car)
	{
		if(car.getMinutes() > car.getParkingMeterTime())
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * isEqual() compares a PoliceOfficer object to this object and
	 * returns true if they are the same, and false if they are not.
	 * @param officer the PoliceOfficer object to compare this object to.
	 * @return Whether or not the two objects are the same.
	 */
	public boolean isEqual(PoliceOfficer officer)
	{
		if(illegalCar.isEqual(officer.illegalCar) &
	       ticket.isEqual(officer.ticket) &
	       name.equals(officer.getName()) &
	       badge == officer.getBadge())
			return true;
		else
			return false;
	}
	/**
	 * setCar() sets the value of illegalCar to the object car
	 * @param car
	 */
	public void setCar(ParkedCar car) { illegalCar = car; }
	/**
	 * setName() sets the value of field name to n.
	 * @param n The officer's name.
	 */
	public void setName(String n) {	name = n; }
	/**
	 * setBadge() sets the value of field badge to badge_b.
	 * @param badge_b The officer's badge number.
	 */
	public void setBadge(int badge_b) { badge = badge_b; }
	/**
	 * getCar() returns the object illegalCar.
	 * @return The car being inspected.
	 */
	public ParkedCar getCar() { return illegalCar; }
	/**
	 * getName() returns the value of field name.
	 * @return The officer's name.
	 */
	public String getName() { return name; }
	/**
	 * getBadge() returns the value of field badge.
	 * @return The officer's badge number.
	 */
	public int getBadge() { return badge; }	
	/**
	 * toString() returns a formatted string of the officer's name and badge number.
	 * @return Formatted string.
	 */
	public String toString()
	{
		return String.format("Name: %s\nBadge: %d", name, badge);
	}
}

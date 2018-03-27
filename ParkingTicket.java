public class ParkingTicket
{
	private static int numTicket = 1;
	private ParkedCar illegalCar;
	
	private double fine;
	private String officerName;
	private int badgeNumber;
	private int difference;
	private int baseDiff;
	
	//Default constructor
	public ParkingTicket(){}
	
	/**
	 * ParkingTicket class constructor.
	 * @param car 		the car that is being fined.
	 * @param name 		the officer's name.
	 * @param badge 	the officer's badge number.
	 */
	public ParkingTicket(ParkedCar car, String name, int badge)
	{
		illegalCar = car;
		officerName = name;
		badgeNumber = badge;
		fine = 25.0;
	}
	
	/**
	 * calculateFine() calculates the fine amount based on how long the car has been parked for.
	 */
	public void calculateFine()
	{
		difference = illegalCar.getMinutes() - illegalCar.getParkingMeterTime();
		baseDiff = difference;
		
		while(difference - 60 > 0)
		{
			fine += 10.0;
			difference -= 60;
		}
			
	}
	/**
	 * setParkedCar() sets the value of field illegalCar to the object car.
	 * @param car The illegally parked car.
	 */
	public void setParkedCar(ParkedCar car){ illegalCar = car; }
	/**
	 * setOfficerName() sets the value of field officerName to name.
	 * @param name The officer's name.
	 */
	public void setOfficerName(String name) { officerName = name; }
	/**
	 * setBadgeNumber() sets the value of the field badgeNumber to badge
	 * @param badge
	 */
	public void setBadgeNumber(int badge) { badgeNumber = badge; }
	/**
	 * isEqual() compares two objects of type ParkingTicket and returns true if 
	 * they are the same, and false if they are not
	 * @param ticket
	 * @return Whether or not these two tickets are the same.
	 */
	public boolean isEqual(ParkingTicket ticket)
	{
		if(illegalCar.isEqual(ticket.illegalCar) &
		   fine == ticket.fine &
		   officerName.equals(ticket.officerName) &
		   badgeNumber == ticket.badgeNumber)
			return true;
		else
			return false;
	}
	/**
	 * toString() returns a formatted String
	 * @return Formatted string of the ticket written
	 */
	public String toString()
	{
		calculateFine();
		numTicket++;
		
		return String.format("*\t*** Ticket #%d ***\n" +
							 "* Officer Name: %s\n" +
			                 "* Officer Badge: %s\n" +
							 "*--------------------------\n" +
			                 "*\t*** Car ***\n" +
			                 "* Make: %s\n* Model: %s\n" +
			                 "* Color: %s\n* License: %s\n*\n" +
			                 "* Time Purchased: %d:%02d\n" +
			                 "* Overtime: %d:%02d\n" +
			                 "*--------------------------\n" +
			                 "* Fine Amount: $%,.2f", numTicket, officerName, badgeNumber, illegalCar.getMake(), 
			                 illegalCar.getModel(), illegalCar.getColor(), illegalCar.getLicense(),
			                 illegalCar.getParkingMeterTime() / 60, (illegalCar.getParkingMeterTime() - ((illegalCar.getParkingMeterTime() / 60) * 60)),
			                 baseDiff / 60, (baseDiff - ((baseDiff / 60) * 60)), fine);
	}
}

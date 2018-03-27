/**
 * @author Dylan Grandjean
 * September 12, 2016
 * Lesson 2 - Lab`
 * 
 * This program is designed to write tickets for
 * illegally parked cars. These tickets contain information
 * about the officer, the car, the fine, and the parking
 * meter that measured the time.
 */
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);		//Scanner class used to read user inputs
		PoliceOfficer officer;							//Officer in charge of giving ticket
		ParkedCar illegalCar;							//Car that will be inspected by officer
		ParkingTicket ticket;							//Ticket to be given to an illegally parked car
		
		int x = 0;									    //Loop sentinel
		String name;									//Officer's name
		String make;									//Car's make
		String model;									//Car's model
		String color;									//Car's color
		String license;									//Car's license number
		String answer;									//Answer to whether or not the user wishes to restart the application
		int badgeNum;									//Officer's badge number
		int minutes;									//Minutes the car has been parked for
		int minutesPurchased;							//Minutes purchased by car driver
		boolean carIsFined;								//Determines whether are not a car needs to be fined.
		
		//Greet the user
		System.out.println("Hello,\nLet's get started");
		
		//Begin application loop
		while (x != -1)
		{
			//Prompt user for information regarding the officer
			System.out.print("First of all, what is your name Officer? ");
			name = userInput.nextLine();
			
			System.out.print("It's nice to meet you Officer " + name + ", can I have your badge number?\n" +
							 "Note: a badge number is only comprised of numbers\n" +
							 "Badge number: ");
			badgeNum = userInput.nextInt();
			userInput.nextLine();
			
			//Create a PoliceOfficer object
			officer = new PoliceOfficer(name, badgeNum);
			
			//Prompt user regarding the car being inspected
			System.out.print("\n" + badgeNum + ".. Alright! And what was the make of the car?\n" +
					         "Select one of the answer below:\n" +
					         "1. Nissan\n" +
					         "2. Subaru\n" +
					         "3. Ferrarri\n" +
					         "4. Lexus\n\n" +
					         "Your answer: ");
			make = userInput.nextLine();
			System.out.print("What was that " + make + "'s model?: ");
			model = userInput.nextLine();
			System.out.print("Hmm.. " + model + ".. Do you happen to remember the color? ");
			color = userInput.nextLine();
			System.out.print("A " + color.toLowerCase() + " " + make + " " + model + "?\n" +
							 "That may not be enough, you wouldn't know" +
							 " the license number by any chance? ");
			license = userInput.nextLine();
			System.out.print(license + "!? I'm impressed by your memory!\n");
			System.out.print("Now, how long how many minutes has this car been parked here for? ");
			minutes = userInput.nextInt();
			userInput.nextLine();
			System.out.print("And how many minutes were purchased on the meter? ");
			minutesPurchased = userInput.nextInt();
			userInput.nextLine();
			
			//Creates the ParkedCar and ParkingMeter objects associated to this police officer
			illegalCar = new ParkedCar(make, model, color, license, minutes);
			illegalCar.setParkingMeter(minutesPurchased);
			
			carIsFined = officer.checkMeter(illegalCar);
			if(carIsFined)
			{
				System.out.println("\nThis car is clearly in violation of the city's laws regarding parking regulation!\n" +
								   "Let's print a ticket and show'em how the law works.\n");
				ticket = new ParkingTicket(illegalCar, name, badgeNum);
				System.out.println(ticket.toString());
			}
			else
			{
				int time = illegalCar.getParkingMeterTime() - illegalCar.getMinutes();
				System.out.printf("\nAll clear! This car still has %d:%02d left.",
								  time / 60, (time - ((time / 60) * 60)));
			}
			System.out.print("\nWould you like to inspect another car?\n(Yes/No): ");
			answer = userInput.nextLine();
			x = answer.toUpperCase().equals("NO") ? -1 : 0;
			
			
		}
		userInput.close();
	}
}

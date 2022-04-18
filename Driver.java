import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Driver {
    private static ArrayList<RescueAnimal> dogList = new ArrayList<RescueAnimal>();
    private static ArrayList<RescueAnimal> monkeyList = new ArrayList<RescueAnimal>();
    // Instance variables (if needed)

    public static void main(String[] args) {
    	Scanner scnr = new Scanner(System.in);
    	String x = "";
    	
        initializeDogList();
        initializeMonkeyList();
        
      // while loop for menu options
        while (!x.equals("q")) {
        	try {
        		displayMenu();
        		x = scnr.nextLine().strip();
        		System.out.println();	
        		
        		switch (x) {
        		case "1": 
        			intakeNewDog(scnr); 
        			break;
        		case "2":
        			intakeNewMonkey(scnr);
        			break;
        		case "3":
        			reserveAnimal(scnr);
        			break;
        		case "4":
        			printAnimals(dogList);
        			break;
        		case "5":
        			printAnimals(monkeyList);
        			break;
        		case "6":
        			ArrayList<RescueAnimal> allAnimals = new ArrayList<RescueAnimal>();
        			for (RescueAnimal d: dogList) {
        				if (d.getTrainingStatus().equalsIgnoreCase("in service") && d.getReserved() == false) {
        					allAnimals.add(d);
        				}
        			}
        			for (RescueAnimal m: monkeyList) {
        				if (m.getTrainingStatus().equalsIgnoreCase("in service") && m.getReserved() == false) {
        					allAnimals.add(m);
        				}
        			}
        			printAnimals(allAnimals);
        			break;
        		default:
        			System.out.print("\t\tInvalid Input!");
        		}
        		
        		
        }
        	catch(InputMismatchException e){
        		System.out.println("Incorrect input type");
        		scnr.nextLine();
        	}
        }
        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", 1, 25.6, "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", 3, 35.2, "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", 4, 25.6, "12-12-2019", "Canada", "in service", false, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Bananas", "Capuchin", "male", 2, 50, "05-15-2021", "United States", "intake", false, "United States", 2.2, 4.5, 6.7);
    	Monkey monkey2 = new Monkey("Willy", "Macaque", "male", 1, 43, "08-24-2021", "Brazil", "intake", false, "United States", 1.7, 3.5, 5.2);
    	Monkey monkey3 = new Monkey("Sandy", "Tamarin", "female", 4, 75, "10-03-2018", "China", "in service", false, "United States", 3.1, 5.2, 8.1);
    	
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    	monkeyList.add(monkey3);

    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scnr) {
        System.out.println("What is the dog's name?");
        String name = scnr.nextLine();
        for(RescueAnimal dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system");
                return; //returns to menu
            }
        }			
        // gets all needed input for new dog
        System.out.println("What is the dog's breed?");
        String breed = scnr.nextLine();
        System.out.println("What is the dog's gender?");
        String gender = scnr.nextLine();
        System.out.println("What is the dog's age?");
        int age = scnr.nextInt();
        scnr.nextLine();
        System.out.println("What is the dog's weight?");
        double weight = scnr.nextDouble();
        scnr.nextLine();
        System.out.println("When is the dog's acquired? (date)");
        String acqDate= scnr.nextLine();
        System.out.println("What is the dog's acquisition country?");
        String acqCountry = scnr.nextLine();
        System.out.println("What is the dog's status?");
        String status = scnr.nextLine();
        System.out.println("Is the dog reserved? (Y/N)");
        String yn = scnr.next();
        scnr.nextLine();
        boolean reserved;
        if (yn.equalsIgnoreCase("y")) {
        	reserved = true;
        }
        else {
        	reserved = false;
        }
       
        System.out.println("What is the dog's in-service country?");
        String servCountry = scnr.nextLine();
        // creates new dog
        Dog dog = new Dog(name.strip(), breed.strip(), gender.strip(), age, weight, acqDate.strip(), acqCountry.strip(), status.strip(), reserved, servCountry.strip());
        
        dogList.add(dog);
        // adds dog to list
        
        // Add the code to instantiate a new dog and add it to the appropriate list
    }
 

        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scnr) {
        	System.out.println("What is the monkey's name?");
            String name = scnr.nextLine();
            scnr.nextLine();
            for(RescueAnimal monkey: monkeyList) {
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system");
                    return; //returns to menu
                }
            }
            
            String species;
            // validates whether correct species
            do { 
            System.out.println("What is the monkey's species?");
            species = scnr.nextLine();
            } while (!species.equalsIgnoreCase("Capuchin") && !species.equalsIgnoreCase("Guenon") && !species.equalsIgnoreCase("Macaque") && !species.equalsIgnoreCase("Marmoset") && !species.equalsIgnoreCase("Squirrel monkey") && !species.equalsIgnoreCase("Tamarin"));
            // gets all needed input
            System.out.println("What is the monkey's gender?");
            String gender = scnr.nextLine();
            System.out.println("What is the monkey's age?");
            int age = scnr.nextInt();
            scnr.nextLine();
            System.out.println("What is the monkey's weight?");
            double weight = scnr.nextDouble();
            scnr.nextLine();
            System.out.println("When is the monkey's acquired? (date)");
            String acqDate= scnr.nextLine();
            System.out.println("What is the monkey's acquisition country?");
            String acqCountry = scnr.nextLine();
            System.out.println("What is the monkey's status?");
            String status = scnr.nextLine();
            System.out.println("Is the monkey reserved? (Y/N)");
            String yn = scnr.next();
            scnr.nextLine();
            boolean reserved;
            if (yn.equalsIgnoreCase("y")) {
            	reserved = true;
            }
            else {
            	reserved = false;
            }
           
            System.out.println("What is the monkey's in-service country?");
            String servCountry = scnr.nextLine();
            System.out.println("What is the monkey's tail length?");
            double tailLength = scnr.nextDouble();
            scnr.nextLine();
            System.out.println("What is the monkey's height?");
            double height = scnr.nextDouble();
            scnr.nextLine();
            System.out.println("What is the monkey's body length?");
            double bodyLength = scnr.nextDouble();
            scnr.nextLine();
            //creates new monkey
            Monkey monkey = new Monkey(name.strip(), species.strip(), gender.strip(), age, weight, acqDate.strip(), acqCountry.strip(), status.strip(), reserved, servCountry.strip(), tailLength, height, bodyLength);
            //adds to list
            monkeyList.add(monkey);
        	
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scnr) {
        	//gets input to validate
        	
        	System.out.println("What is the animals name");
        	String name = scnr.nextLine().strip();
        	System.out.println("What is the in-service country for the animal");
        	String country = scnr.nextLine().strip();
        	
        	//checks for animal and changes reserved status
        	for(RescueAnimal dog: dogList) {
                if(dog.getName().equalsIgnoreCase(name) && dog.getAcquisitionLocation().equalsIgnoreCase(country)) {
                	dog.setReserved(!dog.getReserved());
                	return;
                }
                
        	}
        	for(RescueAnimal monkey: monkeyList) {
                if(monkey.getName().equalsIgnoreCase(name) && monkey.getAcquisitionLocation().equalsIgnoreCase(country)) {
                	monkey.setReserved(!monkey.getReserved());
                }
                
        	}
        	
        }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals(ArrayList<RescueAnimal> list) {
        	for (RescueAnimal a: list) {
        		System.out.println("Name: " + a.getName() + "  Status: " + a.getTrainingStatus() + "  Acquisition country: " + a.getAcquisitionLocation() + "  Reserved: " + a.getReserved());
        		System.out.println();
        	}
        	System.out.println();
        	}
    // Wasnt sure whether to add overridden methods in classes rescue animal, dog and monkey 
    // so i used 2 list parameters to fix this
           
            	
        }


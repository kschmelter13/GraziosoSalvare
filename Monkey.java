
public class Monkey extends RescueAnimal {
	
	private double tailLength;
	private double height;
	private double bodyLength;
	private String species;
	
	// Default constructor
	public Monkey() {
	}
	
	// Init constructor
	public Monkey(String name, String species, String gender, int age,
		    double weight, String acquisitionDate, String acquisitionCountry,
			String trainingStatus, boolean reserved, String inServiceCountry, double tailLength, double height, double bodyLength) {
		setName(name);
		setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        
	}
	
	// Accessor Method
	public double getTailLength() {
		return tailLength;
	}
	// Mutator Method
	public void setTailLength(double tailLength) {
		this.tailLength = tailLength;
	}
	// Accessor Method
	public double getHeight() {
		return height;
	}
	// Mutator Method
	public void setHeight(double height) {
		this.height = height;
	}
	// Accessor Method
	public double getBodyLength() {
		return bodyLength;
	}
	// Mutator Method
	public void setBodyLength(double bodyLength) {
		this.bodyLength = bodyLength;
	}
	// Accessor Method
	public String getSpecies() {
		return species;
	}
	// Mutator Method
	public void setSpecies(String species) {
		this.species = species;
	}
	
}

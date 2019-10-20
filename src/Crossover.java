import java.util.Random;

// Perform crossover
public class Crossover {

	// Variables
	private double pc;
	private int firstPointer, secondPointer;
	private String[] individuals, offSprings;
		
    // Take individuals
    public Crossover(String[] individuals) {
    	this.pc = 0.7;
    	this.individuals = individuals;
    	this.firstPointer = 2;
    	this.offSprings = new String[individuals.length];
    }

    // Perform single point crossover process
    public String [] performCrossover() {
    	Random rg = new Random();
    	double firstPointerD = generateRandom((double)individuals[0].length()-1, 0.00);
    	firstPointer = (int) Math.ceil(firstPointerD);
    	//System.out.println("firstPointer: " + firstPointer);
    	String offSpring1,offSpring2;
    	for(int i = 0; i < individuals.length ; i+=2) {
    		// Check crossover probability
    		if(generateRandom(1,0) > pc) {
    			offSprings[i] = individuals[i];
        		offSprings[i+1] = individuals[i+1];
        		//System.out.println("No");
        		continue;
    		}
			offSpring1 = individuals[i].substring(0,firstPointer) + individuals[i+1].substring(firstPointer,individuals[i+1].length());
    		offSpring2 = individuals[i+1].substring(0,firstPointer) + individuals[i].substring(firstPointer,individuals[i].length());
    		offSprings[i] = offSpring1;
    		offSprings[i+1] = offSpring2;
    	}
    	return offSprings;
    }

    // return Inputs
    public void print() {
    	for(int i = 0; i < offSprings.length ; i++) {
    		System.out.println(offSprings[i]);
    	}
    }
    	
    // return Inputs
    public void getNewIndividuals() {
    	
    }
    
    // To generate random number
    public double generateRandom(double max , double min) {
    	Random randomNum = new Random();
    	double random = randomNum.nextDouble() * (max-min) + min;
    	return random;
    }

}

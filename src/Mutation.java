import java.util.Random;
// Perform mutation
public class Mutation {
	
	// Variables
	private String[] chromosomes;
	
	// Constructor 
	public Mutation(String [] inputs){
		chromosomes = inputs;
	}
	  
    // Return inputs after mutation process
    public String[] getInputs() {
    	return chromosomes;
    }
    
    public double generateRandom(double max , double min) {
    	Random randomNum = new Random();
    	double random = randomNum.nextDouble() * (max-min) + min;
    	return random;
    }
    
    // Check mutation and change if yes
    public  String changeChromosome(String chromosome) {
    	double randomVar = 0.0 ;
    	char []charChromo = chromosome.toCharArray();
    	for(int i = 0 ; i < charChromo.length ; i++) {
    		randomVar = generateRandom(0.0 , 1);
    		
    		if(randomVar < 0.02) {
    			// smaller than 0.05 or not  to perform mutation
     	    	if(charChromo[i] == '1'){
    	    		charChromo[i] = '0';
    	    	} else {
    	    		charChromo[i] = '1';
    	    	}
        	} else {
        		continue;
        	}
    		
    	}
	    String general = new String(charChromo);  // convert char array after mutation to string 
		return general;	
    }
    
    // Do Mutation for all offsprings
    public String [] performMutation() {
    	for(int i = 0 ; i < chromosomes.length ; i++) {
    		chromosomes[i] = changeChromosome(chromosomes[i]);
    	} 
    	return chromosomes;
    }
}
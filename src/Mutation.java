import java.util.Random;
// Perform mutation
public class Mutation {
	
	 String[] chromosomes;
	
	// .0101010 1010101 
    // Get current generation individuals
	
    public static String[] setInputs(String[]chro) {
    	
    	chro = new String[5];
    	chro[0] = "01011";
    	chro[1] = "11111"; 
    	chro[2] = "11100";
    	chro[3] = "00000";
   		chro[4] = "10100";
   		return chro;
    } 

    // Check mutation some input
    public void checkMutation() {
    		
    }

    // Return inputs after mutation process
    public void getInputs() {

    }
    
    public static double generateRandom(double max , double min) {
		
    	Random randomNum = new Random();
    	double random = randomNum.nextDouble() * (max-min) + min;
    	return random;
    	
    }
    
    public static String changeChromosome(String chromosome) {
    	double randomVar = 0.0 ;
    	char []charChromo = chromosome.toCharArray();
    	
    	for(int i = 0 ; i < charChromo.length ; i++) {
    		randomVar = generateRandom(0.0 , 0.1);
    		
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
    
    
    public static void  main(String args[]) {
    	
    	String []chromos = null;
    	chromos = setInputs(chromos);

    	for(int i = 0 ; i < chromos.length ; i++) {
    		chromos[i] = changeChromosome(chromos[i]);
    		System.out.println("***************");
    		System.out.println(chromos[i]);
    			
    	}
    	
    	//System.out.println(changeChromosome("0110110"));
    }

}

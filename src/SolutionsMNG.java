import java.util.Random;

// Handle everything related to solutions individuals
public class SolutionsMNG {

    // Variables
    private int numOfInd, numOfInputs;
    private String[] individuals;
    
    // Constructor
    public SolutionsMNG(int numOfIndividuals, int numOfInputs) {
        this.numOfInd = numOfIndividuals;
        this.numOfInputs = numOfInputs;
        this.individuals = new String[numOfInd];
        this.initialize();
    }


    // Initialize first random solutions
    public void initialize() {
        for (int i = 0; i < numOfInd; i++) {
            individuals[i] = generateInd();
        }
    }

    // Generate random solution
    public String generateInd() {
        String binary = "";
        int range = (int) Math.pow(2, numOfInputs) - 1;
        Random rg = new Random();
        int n = rg.nextInt(range);
        String binaryrep = toBinary(n);
        if (binaryrep.length() <= numOfInputs) {
            for (int i = 0; i < numOfInputs - binaryrep.length(); i++) {
                binary += "0";
            }
            binary += binaryrep;
        }
        return binary;
    }

    // Encode generated solutions
    public static String toBinary(int rand) {
        String binary = "";
        while (rand > 0) {
            binary = ((rand % 2) == 0 ? "0" : "1") + binary;
            rand = rand / 2;
        }
        return binary;
    }

    // To print individuals
    public void print() {
        for (int i = 0; i < numOfInd; i++) {
            System.out.println(individuals[i]);
        }
    }

    // Evaluate individual fitness
    public int fitnessfunction(String binary, int[] benefits) {
        int b = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                b += benefits[i];
            }
        }
        return b;
    }

    // Calculate fitness function for all individuals
    public int[] calcAllFintenss(int[] benefits) {
        int[] fitnessValues = new int[numOfInd];
        for (int i = 0; i < numOfInd; i++) {
            fitnessValues[i] = fitnessfunction(individuals[i],benefits);
        }
        return fitnessValues;
    }
    // Setters and Getters
    public int getNumOfInd() {
		return numOfInd;
	}


	public void setNumOfInd(int numOfInd) {
		this.numOfInd = numOfInd;
	}


	public int getNumOfInputs() {
		return numOfInputs;
	}


	public void setNumOfInputs(int numOfInputs) {
		this.numOfInputs = numOfInputs;
	}


	public void setIndividuals(String[] individuals) {
		this.individuals = individuals;
	}

    public String[] getIndividuals() {
    	return this.individuals;
    }
    
}

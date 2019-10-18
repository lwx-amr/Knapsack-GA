import java.util.Random;

// Handle everything related to solutions individuals
public class SolutionsMNG {

    // Variables
    private int numOfInd, numOfInputs;
    private String[] individuals;
    private int[] weights, benefits;
    
    public SolutionsMNG(int numOfIndividuals, int numOfInputs) {
        this.numOfInd = numOfIndividuals;
        this.numOfInputs = numOfInputs;
        this.individuals = new String[numOfInd];
        this.weights = new int[numOfInputs];
        weights[0] = 4;
        weights[1] = 7;
        weights[2] = 5;
        weights[3] = 6;
        this.benefits= new int[numOfInputs];
        benefits[0] = 4;
        benefits[1] = 6;
        benefits[2] = 3;
        benefits[3] = 3;
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
    public int fitnessfunction(String binary, int[] weights, int[] benefits) {
        int w = 0, b = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                w += weights[i];
                b += benefits[i];
            }
        }
        return b;
    }

    // Calculate fitness function for all individuals
    public int[] calcAllFintenss() {
        int[] fitnessValues = new int[numOfInd];
        for (int i = 0; i < numOfInd; i++) {
            fitnessValues[i] = fitnessfunction(individuals[i], weights, benefits);
        }
        return fitnessValues;
    }

    public static void main(String args[]) {
        SolutionsMNG s = new SolutionsMNG(4, 4);
        s.initialize();
        s.print();
        int[] fintessValues = s.calcAllFintenss();
        Selection obj = new Selection(s.numOfInd);
        obj.doSelection(s.individuals, fintessValues);
        //Crossover obj = new Crossover(s.individuals);
        //obj.performCrossover("multi");
    }
}

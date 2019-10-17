// Handle everything related to solutions individuals
public class SolutionsMNG {

    // Variables
    int numOfInd, numOfInputs;
    String[] individuals;

    public SolutionsMNG(int numOfIndividuals, int numOfInputs) {
        this.numOfInd = numOfIndividuals;
        this.numOfInputs = numOfInputs;
        this.individuals = new String[numOfInd];
    }


    // Initialize first random solutions
    public void initialize() {
        for (int i = 0; i < numOfInd; i++) {
            individuals[i] = generateInd();
        }
    }

    // Generate random solution
    public String generateInd() {
        String sol = "";
        
        return sol;
    }

    // Evaluate solution fitness
    public void evaluation() {

    }

    // Encode generated solutions
    public void enCoder() {

    }

    // Save best
    public void bestChecker() {

    }
}

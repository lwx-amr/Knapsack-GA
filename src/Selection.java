import java.util.Random;

// To handle selection process
public class Selection {

    // Variables
    private int numOfInd, numOfSelection;

    public Selection(int numOfInd) {
        this.numOfInd = numOfInd;
        this.numOfSelection = 4; // We will change this value later
    }

    public void doSelection(String[] binary, int[] fitnessValues) {
        int totalweight = 0;
        String[] choosenelements = new String[numOfInd];
        for (int i = 0; i < fitnessValues.length; i++) {
            totalweight += fitnessValues[i];
        }
        int partialsum = 0;
        Random rg = new Random();
        int Random = rg.nextInt(totalweight - 1);
        for (int j = fitnessValues.length - 1; j >= 0; j--) {
        	while (partialsum <= Random) {
                partialsum += fitnessValues[j];
            }
            choosenelements[j] = binary[j];
        }
        for (int h = 0; h < numOfInd; h++) {
        	System.out.println("choosen");
        	System.out.println(choosenelements[h]);
        }
    }
}

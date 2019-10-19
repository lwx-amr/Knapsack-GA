import java.util.Vector;

// Implementation of algorithm
public class ALGImplementation {

	// Objects
	private FilesController fileController;
	private SolutionsMNG solver;
	private Mutation mutation;
	private Replacement replacer;
	
	
	// Variables 
	private String [] individuals; 
	private Vector<Problem> problems;
	private int numOfInputs, numOfSelection;
	
	// Constructor
	public ALGImplementation() {
		this.fileController = new FilesController("input_example.txt");
		this.numOfSelection = 8;
	}
	
    // Execute algorithm repetitive steps
    public void executeProcess(int i) {

        // Call SolutionMNG to evaluate solutions
    	int[] fintessValues = solver.calcAllFintenss(problems.elementAt(i).getBenefits());

        // Perform Selection
        Selection selectObj = new Selection(individuals, numOfSelection);
        String[] choosenelements = selectObj.doSelection(fintessValues);
        
        System.out.println("\n ------------ Selection ------------ ");
        for (int j = 0; j < numOfSelection; j++) {
        	System.out.println(choosenelements[j]);
        }
        
        // Perform crossover
        Crossover crossObj = new Crossover(choosenelements);
        String[] offSprings = crossObj.performCrossover("single");
        
        System.out.println("\n ------------ Crossover ------------ ");
        for (int j = 0; j < numOfSelection; j++) {
        	System.out.println(offSprings[j]);
        }
        
        
        // Perform mutation
        mutation = new Mutation(offSprings);
        String[] mutatedOffSprings = mutation.performMutation();

        System.out.println("\n ------------ Mutation ------------ ");
        for (int j = 0; j < numOfSelection; j++) {
        	System.out.println(mutatedOffSprings[j]);
        }
        
        // Perform replacement
        replacer = new Replacement(individuals, mutatedOffSprings, problems.elementAt(i).getBenefits(), solver);
        individuals = replacer.perfomReplacment();
       
    }

    // Perform all Algorithm steps
    public void algTrigger() {

        // File or Screen
    	
    	// Read inputs from file
    	problems = new Vector<Problem>();
    	fileController.	readInputs();
    	problems = fileController.getInputs();
    	
        // Call SolutionMNG to initialize and encode solutions
    	//int numOfProblems = problems.size();
    	numOfInputs = problems.elementAt(0).getBenefits().length;
		solver = new SolutionsMNG(20, numOfInputs);
		individuals = solver.getIndividuals();
    	
		System.out.println(" ----------- Init ------------- ");
		solver.print();
		
		// Solve all problems
        for(int i = 0; i < 20; i++ ){
        	executeProcess(0);
        }

    }
    
    public static void main (String args[]) {
    	ALGImplementation obj = new ALGImplementation();
    	obj.algTrigger();
    }
}

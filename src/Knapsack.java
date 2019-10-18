
public class Knapsack {
	public static void knapsack(int N, int S, int[]weight,int[]benefit) {
		String [] binary;
		int [] weights = new int [4];
		int[] benefits = new int [4];
		binary = new String [4];
		String binary1 = null;
		for (int i=0 ; i<4 ; i++){
			binary1=Generate_Random_Pop.randompopulation(N);
			binary[i]=binary1;
			
			int weightt=Fitness_Function.fitnessfunction(binary1,weight,benefit,S);
			System.out.println("weight ="+weightt+"el size ="+S);
			if (weightt>S){
			System.out.println("kberaaaaaa /n");
			String temp=Valid_weight.surprise(N, S, weight, benefit, weightt);
				binary[i]=temp;
			weights[i] = GA.W;
			benefits[i] = GA.B;
	
				
				
				
			}
			else{

			weights[i] = GA.W;
			benefits[i] = GA.B;
		}}
		Selection.selection(binary,weights,benefits);
		
	}	
		

	}


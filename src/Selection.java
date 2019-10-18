
public class Selection {
	public static void selection(String [] binary, int[] weights, int[] benefits){
		int totalweight =0;
		String [] choosenelement = new String [4];
		float []probability = new float[4];
		for (int i =0 ; i<weights.length; i++){
			totalweight+=weights[i];
			//System.out.println("weights "+ totalweight);
		}
		for (int i=0 ; i< weights.length ; i++){
			if (totalweight>0){
			probability[i]=(float)weights[i]/(float)totalweight;}
			else{
				probability[i]=0;
			}
			
			//System.out.println("PROBAB"+probability[i] + "\n");
		}
		double partialsum=probability[0];
		
		 double Random= Math.random();
		
		 for(int j=0 ; j<4 ; j++){
			 if (partialsum>=Random){
				 choosenelement[j]=binary[j];
			 }
			 else {
				 partialsum+=probability[j];
			 }
		 
		}
		for(int h=0 ; h<4 ; h++){
			System.out.println("choosen");
			System.out.println(choosenelement[h]);
		}
	}
}

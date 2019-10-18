import java.util.Random;

public class Selection {
	public static void selection(String [] binary, int[] weights, int[] benefits){
		int totalweight =0;
		String [] choosenelement = new String [4];
		float []probability = new float[4];
		for (int i =0 ; i<weights.length; i++){
			totalweight+=weights[i];
			//System.out.println("weights "+ totalweight);
		}
		/*
		for (int i=0 ; i< weights.length ; i++){
			if (totalweight>0){
			probability[i]=(float)weights[i]/(float)totalweight;}
			else{
				probability[i]=0;
			}
			*/
			//System.out.println("PROBAB"+probability[i] + "\n");
		
		int partialsum=0;
		
		Random rg = new Random();
	    int Random = rg.nextInt(totalweight-1);
	    
		 for(int j=3 ; j>=0 ; j--){
			 while(partialsum<=Random) {
			 partialsum+=weights[j];
			 }
			
				 choosenelement[j]=binary[j];
				
		 } 
		for(int h=0 ; h<4 ; h++){
			System.out.println("choosen");
			System.out.println(choosenelement[h]);
		}
	}
	
}

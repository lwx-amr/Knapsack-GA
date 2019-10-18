import java.util.Random;

public class Generate_Random_Pop {
	
	public static String randompopulation(int N){
		String binary="";
		int range=(int) Math.pow(2,N)-1;
	    Random rg = new Random();
	    int n = rg.nextInt(range);
	    String binaryrep  = toBinary(n);
	    System.out.println("random " + n);
	    
	    if(binaryrep.length()<=N){
	    	for (int i =0 ; i<N-binaryrep.length();i++){
	    		binary+="0";
	    	}
	    	binary+=binaryrep;
	    }
	   // System.out.println("Binary after editing " + binary);
	    return binary;
	}
	
	public static String toBinary(int rand)
	{
	    String binary = "";
	    while (rand > 0)
	    {
	        binary =  ( (rand % 2 ) == 0 ? "0" : "1") +binary;
	        rand = rand / 2;
	    }
	    return binary;
	}
}

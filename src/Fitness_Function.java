
public class Fitness_Function {
	public static int fitnessfunction(String binary,int [] weight, int[]benefit, int S){
		int w=0,b=0;
		//System.out.println("bara");
		for (int i=0 ; i< binary.length() ; i++){
			//System.out.println("gwa");
			if (binary.charAt(i) == '1'){
			
			    w+=weight[i];
				b+=benefit[i];
				//System.out.println(weight[i] + " ++++ "+benefit[i]);
				
			}
		}
		System.out.println("weight " + w +" benefit " + b);
		GA.W=w;
		GA.B=b;
		
		return w;
	}
}

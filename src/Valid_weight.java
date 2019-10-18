
public class Valid_weight {
public static String surprise(int N,int S, int[]weight,int[]benefit,int initial) {
	int weightt=initial;
	String temp="";
	while(weightt>S) {
	 temp=Generate_Random_Pop.randompopulation(N);

     int h=Fitness_Function.fitnessfunction(temp,weight,benefit,S);
     System.out.println(h);
     weightt=h;
	}
	System.out.println("tmaaam ybasha" + temp);
	return temp;
}
}

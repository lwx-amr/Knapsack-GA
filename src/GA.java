import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class GA {
	public static int W=0;
	public static int B=0;
	public static void main(String[] args)throws Exception 
	  { 
	
	  Scanner scanner = new Scanner(new File("input_example.txt"));
	  BufferedReader input = new BufferedReader(new FileReader(new File("input_example.txt")));
	  int C = 0, N = 0 , S = 0;
	  String[] splitted = null; 
	  int []weight=null;
	  int []benefit=null;
	  C = scanner.nextInt(); //number of test cases
	  for (int i = 0 ; i < C ; i++){
		  String temp = null;
		  
		  N = scanner.nextInt(); 		  
		  S = scanner.nextInt(); 
		  weight = new int[N];
		  benefit = new int[N];
		  System.out.println("N "+ N);
		  System.out.println("S " + S);
		  for (int j=0 ; j< N ; j++){
			  if (scanner.hasNext()){
				weight[j]=scanner.nextInt();
				benefit[j]=scanner.nextInt(); 
			  }
		  }
		  Knapsack.knapsack(N,S,weight,benefit);
	  }
	//  scanner.close();
	  } 

}

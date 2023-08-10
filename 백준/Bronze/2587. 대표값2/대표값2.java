import java.util.*;
import java.io.*;


public class Main{
	public static int arr[][];
	public static int N;
	public static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer("");
		
		int arr[] = new int[5];
		int sum = 0;
		for(int i = 0; i < 5; i++){
			arr[i] = Integer.parseInt(reader.readLine());
			sum+= arr[i];
		}
		System.out.println(sum/5);
		
		Arrays.sort(arr);
		
		
		System.out.println(arr[arr.length/2]);


		reader.close();
		writer.flush();
		writer.close();
	}

}

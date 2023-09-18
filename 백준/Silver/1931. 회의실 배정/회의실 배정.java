import java.util.*;
import java.io.*;


public class Main{
	public static void main(String[] args) throws IOException{
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer("");
		
		

		int numTime = Integer.parseInt(reader.readLine());
		
		int[][] data = new int[numTime][2];
		
		for(int i = 0; i < numTime; i++){
			st = new StringTokenizer(reader.readLine());
			data[i][0] = Integer.parseInt(st.nextToken()); 
			data[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(data, (a, b)->{
			if(a[1] == b[1]) return a[0] - b[0];
			return a[1] - b[1];
		});
		int counter = 0;
		int index = 0;
		int endTime = 0;
		while(index < numTime){
			
			if(data[index][0]>=endTime){
				endTime = data[index][1];
				counter++;
			}
			index++;
		}
		System.out.println(counter);

		// for(int i = 0; i < data.length; i++){
		// 	System.out.println(data[i][0] + " " + data[i][1]);
		// }

	}
}

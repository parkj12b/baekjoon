import java.io.*;
import java.lang.reflect.Method;
import java.util.*;


public class Main {
    
    static String line1;
    static String line2;
    static int max = 0;
    public static void main(String[] args) throws IOException{
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        StringTokenizer st;
        
        Heap h1 = new Heap();
        int N = Integer.parseInt(reader.readLine());

        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(reader.readLine());
            if(a == 0){
                a = h1.removeMax();    
                writer.write(a+"\n");
                continue;
            }
            h1.add(a);
        }
        writer.flush();

    }
        
    static class Heap{
        ArrayList<Integer> heap = new ArrayList<Integer>();

        void add(int a){
            heap.add(a);
            int position = heap.size()-1;
            while(position > 0){
                if(position % 2 == 0){
                    int parent = position/2-1;
                    int parentNum = heap.get(parent);
                    
                    if(parentNum < a){
                        heap.set(parent,a);
                        heap.set(position,parentNum);
                        position = position/2 -1;
                    } else {
                        return;
                    }
                } else {
                    int parent = position/2;
                    int parentNum = heap.get(parent);
                    
                    if(parentNum < a){
                        heap.set(parent,a);
                        heap.set(position,parentNum);
                        position = position/2;//hereeee
                    } else {
                        return;
                    }
                }
            }
            
            
        }
        int removeMax(){
            if(heap.size() == 0){
                return 0;
            }
            int lastEle = heap.get(heap.size()-1);
            int a = heap.get(0);
            heap.set(0,lastEle);             
            heap.remove(heap.size()-1);
            int heapSize = heap.size();
            int position = 0;
            int nextPosition = 1;
            while(nextPosition < heapSize){
                if(nextPosition+1 < heapSize){
                    int numLeft = heap.get(nextPosition);
                    int numRight = heap.get(nextPosition+1);
                    if(numLeft > numRight){
                        if(numLeft > lastEle){
                            heap.set(position,numLeft);
                            heap.set(nextPosition, lastEle);
                            position = nextPosition;
                            nextPosition = nextPosition*2+1;
                        } else {
                            break;
                        }
                    }else {
                        if(numRight > lastEle){
                            heap.set(position,numRight);
                            heap.set(nextPosition+1, lastEle);
                            position = nextPosition+1;
                            nextPosition = (nextPosition+1)*2+1;
                        } else {
                            break;
                        }
                    }
                    
                } else {
                    if(heap.get(nextPosition) > lastEle){
                        heap.set(position,heap.get(nextPosition));
                        heap.set(nextPosition,lastEle);
                        position = nextPosition;
                        nextPosition = nextPosition*2+1;
                    } else {
                        break;
                    }
                }
                
            }
            return a;
        }
    }
}
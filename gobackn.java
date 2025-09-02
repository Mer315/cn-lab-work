import java.util.*;
public class gobackn {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int win =s.nextInt();
        int n=win;
        int i=0;
        while(i<n){
            for(int j=i;j<i+win && j<n;j++){
                System.out.println("Frame"+j+"transmitted");
            }
            System.out.println("print last got ack");
            int ack=s.nextInt();
            if(ack<i-1|| ack>=i+win){
                System.out.println("invalid ack. enter valid one");
                continue;
            }
            i=ack+1;
        }
    }
}

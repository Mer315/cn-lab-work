import java.util.*;

class bitstuffing {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String data = s.nextLine();
        StringBuilder sb = new StringBuilder();
        int cnt=0;
        for(int i=0;i<data.length();i++){
            char b=data.charAt(i);
            sb.append(b);
            if(b=='1'){
                cnt++;
                if(cnt==5){
                    sb.append('0');
                    cnt=0;
                }
            }
            else{
                cnt=0;
            }
        }
        System.out.println(sb.toString());
        
    }
}
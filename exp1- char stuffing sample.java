import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st=s.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append("DLE STX");
        for(int i=0;i<st.length();i++){
            if(i+2<st.length()&& st.charAt(i)=='D' && st.charAt(i+1)=='L'&& st.charAt(i+2)=='E'){
                sb.append("DLE DLE");
                i+=2;
            }
            else{
                sb.append(st.charAt(i));
            }
        }
        sb.append("DLE ETX");
        System.out.println(sb.toString());
    }
}

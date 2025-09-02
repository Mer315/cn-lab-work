import java.util.*;

public class crc {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        String msg = s.next();
        String gen =s.next();
        int ml=msg.length();
        int gl = gen.length();
        int[] data = new int[ml+gl-1];
        int[] generator = new int[gl];
        //msg and gen converted to int arrays
        for(int i=0;i<ml;i++){
            data[i]=msg.charAt(i)-'0';
        }
        for(int i=0;i<gl;i++){
            generator[i]=gen.charAt(i)-'0';
        }
        for(int i=ml;i<ml+gl-1;i++){
            data[i]=0;
        }
        //now we do XOR(division)
        int[] temp = data.clone();
        for(int i=0;i<ml;i++){
            if(temp[i]==1){
                for(int j=0;j<gl;j++){
                    temp[i+j]^=generator[j];
                }
            }
        }
        //now we extract the remainder 
        int[] crc = new int[gl-1];
        for(int i=0;i<gl-1;i++){
            crc[i]=temp[ml+i];
        }
        //build the transmitted msg
        System.out.print(msg);
        for(int c:crc){
            System.out.print(c);
        }
        System.out.println();

        //now we coming to receiver side to detect if error there or not
        String recv=s.next();
        int rl = recv.length();
        int[] rdata = new int[rl];
        for(int i=0;i<rl;i++){
            rdata[i]=recv.charAt(i)-'0';
        }
        //now same division again but we doin it for receiver
        for(int i=0;i<=rl-gl;i++){
            if(rdata[i]==1){
                for(int j=0;j<gl;j++){
                    rdata[i+j]^=generator[j];
                }
            }
        }
        //check if all bits of rem are zero; if not then error there
        boolean error =false;
        for(int i=rl-gl+1;i<rl;i++){
            if(rdata[i]==1){
                error=true;
                break;
            }
        }
        System.out.println(error?"Yes":"No");
    }
}

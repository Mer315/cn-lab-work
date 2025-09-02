
import java.util.Scanner;

public class decryp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String text = s.nextLine();
        int shift = s.nextInt();
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append((char) ((c - 'A' - shift + 26) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                sb.append((char) ((c - 'a' - shift + 26) % 26 + 'a'));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}

package stitis.m2liuwei;
import java.util.Scanner;

public class InputNumber {
    @SuppressWarnings("resource")
	public static int SimpleInteger(int low, int high) {
        Scanner in = new Scanner(System.in);
        int result = -1;
        String input = null;
        
        System.out.print("Entrez un chiffre entre 0 et 7:");
        
        while (true) {
            input = in.next();
            if (input.length() == 1 && Character.isDigit(input.charAt(0))){
                result = Integer.parseInt(input);
                if (result <= high && result >= low) break;
            }
            System.out.print("Entree faute, entrer un chiffre encore une fois :");
        }
        return result;
    }
}

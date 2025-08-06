import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        boolean tryagain = true;
        while (tryagain) {
            int num = r.nextInt(100) + 1;
            int score = 0;
            int count = 0;
            while(count<5){
                System.out.println("Your Answer");
                int ans = sc.nextInt();
            if (ans == num) {
                System.out.println("Correct!!");
                score = score + 5;
                System.out.println("Your Score:" + score);
                System.out.println("Total Retries:" + count);
                count++;
                break;
            }
                if (ans > num) {
                    System.out.println("Too Far!");
                } else {
                    System.out.println("So Close!!");
                }
                count++;
            }
            System.out.println("Do you wish to continue,Yes/No");
            sc.nextLine();
            String choice = sc.nextLine();
            if(!choice.equalsIgnoreCase("yes")){
                tryagain = false;
                System.out.println("Thank you for playing");
            }
        }
    }
}
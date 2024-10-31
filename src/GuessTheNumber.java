import java.util.Scanner;
import java.util.Random;
public class GuessTheNumber {
    GuessTheNumber(){
        System.out.println("Welcome to Guess The Number!");
        System.out.println("Guess the number between 0 and 100");
        this.play();
    }

    private boolean checkWin(int user, int randnum){
        if(user > randnum){
            System.out.println("guess lower");
            return false;
        }
        else if(user == randnum){
            System.out.println("You have guessed the number correctly");
            return true;
        }
        else{
            System.out.println("guess higher");
            return false;
        }
    }

    public void play(){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int rand_num = random.nextInt(0, 100);
        int user = -1;
        int n_guesses = 0;
        
        while(true){
            n_guesses += 1;
            System.out.print("Guess the number: ");
            try {
                user = sc.nextInt();
                boolean win = this.checkWin(user, rand_num);
                if(win){
                    System.out.println("You guessed the number in " + n_guesses + " guesses");
                    break;
                }
            }
            catch(Exception e){
                System.out.println(e);
            }

        }
    }
}

import java.util.Scanner;
import java.util.Random;
public class RockPaperScissor {

    RockPaperScissor(){
        System.out.println("Welcome to Rock Paper Scissor");
        this.play();
    }

    private int checkWin(String user, String comp){
        if((user.equals("rock") && comp.equals("scissor")) || (user.equals("paper") && comp.equals("rock")) || (user.equals("scissor") && comp.equals("paper"))){
            System.out.println("Computer chose: " + comp);
            System.out.println("You score");
            return 0;
        }
        else if((user.equals("rock") && comp.equals("paper")) || (user.equals("paper") && comp.equals("scissor")) || (user.equals("scissor") && comp.equals("rock"))){
            System.out.println("Computer chose: " + comp);
            System.out.println("Computer score!");
            return 1;

        }
        else if(user.equals(comp)){
            System.out.println("It's a tie!");
            System.out.println("Computer chose: " + comp);
        }
        return 2;
    }
    public void play(){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String [] choices = {"rock", "paper", "scissor"};
        String user;
        String comp;
        int u_score = 0;
        int c_score = 0;

        while(true){
            comp = choices[rand.nextInt(0, choices.length)];
            System.out.println("\nYour score: " + u_score + " Computer score: " + c_score);
            System.out.print("rock, paper or scissor?: ");
            user = sc.next();
            int scorer = this.checkWin(user, comp);
            if(scorer == 0){
                u_score += 1;
            }
            else if(scorer == 1){
                c_score += 1;
            }

            if(u_score == 10){
                System.out.println("You have won!");
                break;
            }
            else if(c_score == 10){
                System.out.println("Computer won the game!");
                break;
            }


        }

    }
}

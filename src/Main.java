//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to my Java Game module!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of player1: ");
        String player1 = sc.next();
        System.out.print("Enter the name of player2: ");
        String player2 = sc.next();
        System.out.println("enter exit to exit the module");
        while(true){
            System.out.println("\nWe have games like Tic Tac Toe, Memory cards, Rock Paper Scissor, Guess The Number and Hangman");
            System.out.print("which game you want to play now? : ");
            String user = sc.nextLine().toLowerCase().replace(" ", "");

            if(user.contains("tictac")){
                TicTacToe ticTacToe = new TicTacToe(player1, player2);
            }
            else if(user.contains("hangman")){
                Hangman hangman = new Hangman();
            }
            else if(user.contains("rockpaperscissor")){
                RockPaperScissor rockPaperScissor = new RockPaperScissor();
            }
            else if(user.contains("guessthenumber")){
                GuessTheNumber guessTheNumber = new GuessTheNumber();
            }
            else if(user.contains("memorycard")){
                MemoryCards memoryCards = new MemoryCards(player1, player2);
            }
            else if(user.equals("exit")){
//                System.exit(0);
                break;
            }
        }
        sc.close();
        }
    }

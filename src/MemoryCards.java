import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class MemoryCards {
    String player1;
    String player2;
    String[] array_cards = {"blue", "yellow", "orange", "violet", "red", "purple", "blue", "yellow", "orange", "violet", "red", "purple"};
    ArrayList<String> flipped_cards;
    ArrayList<String> cards = new ArrayList<>(Arrays.stream(array_cards).toList());

    MemoryCards(String player1, String player2){
        this.player1 = player1;
        this.player2 = player2;
        System.out.println("Welcome to Memory Cards game!");
        System.out.println("Each player gets to flip two cards and if they match he/she scores and the cards are taken. If they done match then the cards are put down");
        System.out.println("The game continues till all the cards are taken away and the most scorer wins the game!");
        System.out.println("Tip: remember the cards which you flip, they will be helpful in future if you find its pair!");
        this.play();

    }

    private void showCards(ArrayList<String> cards) throws Exception{
        int width = 4;
        Thread.sleep(700);
        System.out.println("\n");
        for(int i = 0; i < cards.size(); i += width){
            for(int j = i; j < i+4; j++){
                System.out.print(cards.get(j) + "    ");
            }
            System.out.println();
            System.out.println("_____________________");
        }
        System.out.println("\n");
    }
    private boolean isGameOver(){
        for (String flippedCard : this.flipped_cards) {
            if (flippedCard.contains("*")) {
                return false;
            }
        }
        return true;
    }
    private void flipCard(int[] choices) throws Exception{
        ArrayList<String> temp_cards = new ArrayList<>(this.flipped_cards);
        for(int choice: choices){
            temp_cards.set(choice, this.cards.get(choice));
        }
        this.showCards(temp_cards);
        Thread.sleep(900);


    }
    private boolean matchPair(int choice1, int choice2){
        if(this.cards.get(choice1).equals(this.cards.get(choice2)) && ! this.flipped_cards.get(choice1).equals(" ")){
            this.flipped_cards.set(choice1, " ");
            this.flipped_cards.set(choice2, " ");
            return true;
        }
        return false;
    }
    public void play(){
        Scanner sc = new Scanner(System.in);
        Collections.shuffle(this.cards);
        this.flipped_cards = new ArrayList<>();
        for(int i = 0; i < this.cards.size(); i++){
            this.flipped_cards.add("*" + i);
        }
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put(this.player1, 0);
        scores.put(this.player2, 0);
        String curr_turn = this.player1;

        while(!this.isGameOver()){

            try {
                this.showCards(this.flipped_cards);
                System.out.println("Current Turn: " + curr_turn);
                System.out.println(this.player1 + "'s score: " + scores.get(this.player1) + " " + this.player2 + "'s score: " + scores.get(this.player2));
                System.out.print("Your first flip: ");
                int choice1 = sc.nextInt();
                this.flipCard(new int[]{choice1});
                System.out.print("Your second flip: ");
                int choice2 = sc.nextInt();
                this.flipCard(new int[]{choice1, choice2});
                boolean scorer = this.matchPair(choice1, choice2);
                if(scorer){
                    scores.put(curr_turn, scores.get(curr_turn)+1);
                }
                else{
                    curr_turn = curr_turn.equals(this.player1)? this.player2: this.player1;
                }

            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        System.out.println(this.player1 + "'s score: " + scores.get(this.player1) + " " + this.player2 + "'s score: " + scores.get(this.player2));
        if(scores.get(this.player1) > scores.get(this.player2)){
            System.out.println(this.player1 + " Wins!");
        }
        else if(scores.get(this.player1) < scores.get(this.player2)){
            System.out.println(this.player2 + " Wins");
        }
        else{
            System.out.println("It was a tie!");
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Hangman {
    String[] old_words = {
            "elephant", "giraffe", "kangaroo", "alligator", "crocodile",
            "dolphin", "chimpanzee", "penguin", "porcupine", "rhinoceros",
            "hippopotamus", "ostrich", "panda", "koala", "flamingo",
            "meerkat", "lemur", "gorilla", "platypus", "armadillo",
            "octopus", "peacock", "toucan", "jellyfish", "scorpion"};
    ArrayList<String> words;

    ArrayList<String> progress;

    Hangman(){
        this.words = new ArrayList<>(Arrays.stream(this.old_words).toList());
        System.out.println("Welcome to Hangman!");
        System.out.println("guess the animal by guesssing all of its letters.");
        this.play();


    }

    private void showProgress(){
        System.out.println("\n");
        for(String letter: this.progress){
            System.out.print(letter + " ");
        }
        System.out.println();
    }
    private void checkWin(String user, String word){
        for (int i = 0; i < word.length(); i++){
            if((user.equals(String.valueOf(word.charAt(i)))) && (progress.get(i)).equals("_")){
                this.progress.set(i, String.valueOf(word.charAt(i)));

            }
        }
    }
    private boolean isGameOver(){
        for(String letter: this.progress){
            if(letter.equals("_")){
                return false;
            }
        }
        return true;
    }
    public void play(){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String word = this.words.get(random.nextInt(0, this.words.size()));
        this.progress = new ArrayList<>();
        String user;
        for(int i = 0; i < word.length(); i++){
            progress.add("_");
        }
        int hint = random.nextInt(0, word.length());
        this.progress.set(hint, String.valueOf(word.charAt(hint)));
        int chances_left = 2 * word.length();

        while(chances_left != 0){
            this.showProgress();
            System.out.println("Chances left: " + chances_left);
            System.out.print("guess the word: ");
            try{
                user = sc.next().toLowerCase();
                if(word.contains(user)){
                    this.checkWin(user, word);
                }
                else{
                    System.out.println("wrong guess!");
                    chances_left -= 1;
                }
                if(this.isGameOver()){
                    System.out.println("You have correctly guessed the word!");
                    System.out.println(word);
                    break;
                }
                else if(chances_left == 0){
                    System.out.println("You have now chances left now! You lose!");
                    System.out.println(word);
                    break;
                }
            }
            catch(Exception e){
                System.out.println(e);
            }



        }

    }
}

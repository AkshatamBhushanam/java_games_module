import java.util.Scanner;
import java.util.ArrayList;

public class TicTacToe {
    ArrayList<String> board;
    String player1;
    String player2;
    int [] win_cords;

    TicTacToe(String player1, String player2){
        this.player1 = player1;
        this.player2 = player2;
        System.out.println("Welcome to Tic Tac Toe 2 player!");
        System.out.println("To play just enter the position index of the box");
        this.play();

    }
    private void createBoard(){
        this.board = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            this.board.add(String.valueOf(i));
        }
    }
    private void showBoard(){
        System.out.println("\n__________");
        for(int i = 0; i < 9; i+=3){
            System.out.println(board.get(i) + " | " + board.get(i+1) + " | " + board.get(i+2));
            System.out.println("__________");
        }
        System.out.println();
    }
    private void updateBoard(int user, String curr_turn){
        if(board.get(user).equals(String.valueOf(user))){
            this.board.set(user, curr_turn.equals(this.player1)? "X": "O");
        }
    }
    private boolean checkHorizontal(){
        for(int i = 0; i < 9; i += 3){
            if(this.board.get(i).equals(this.board.get(i+1)) && this.board.get(i).equals(this.board.get(i+2))){
                win_cords = new int[]{i, i + 1, i + 2};
                return true;
            }
        }
        return false;
    }
    private boolean checkDiagonal(){
        if(board.get(0).equals(board.get(4)) && board.get(0).equals(board.get(8)) && ! board.get(0).equals("0")){
            win_cords = new int[]{0, 4, 8};
            return true;
        }
        else if(board.get(2).equals(board.get(4)) && board.get(2).equals(board.get(6)) && ! board.get(2).equals("2")){
            win_cords = new int[]{2, 4, 8};
            return true;
        }
        return false;
    }
    private boolean checkVertical(){
        for(int i = 0; i < 3; i++){
            if(board.get(i).equals(board.get(i + 3)) && board.get(i).equals(board.get(i + 6))){
                win_cords = new int[]{i, i+3, i+6};
                return true;
            }
        }
        return false;
    }
    private boolean isTied(){
        for(int i = 0; i < 9; i++){
            if(this.board.get(i).equals(String.valueOf(i))){
                return false;
            }
        }
        return true;
    }
    private int checkWin(){
        if(this.checkDiagonal() || this.checkVertical() || this.checkHorizontal()){
            return 0;
        }
        else if(this.isTied()){
            return 1;
        }
        return 2;

    }
    public void play(){
        Scanner sc = new Scanner(System.in);
        int user;
        this.createBoard();
        String curr_player = this.player1;

        while(true){
            this.showBoard();
            System.out.println("Current Turn: " + curr_player);
            System.out.print("Enter your move: ");
            try{
                user = sc.nextInt();
                if(board.get(user).equals(String.valueOf(user))){
                this.updateBoard(user, curr_player);
                int winner = this.checkWin();
                if(winner == 0){
                    System.out.println(curr_player + " has won the game!");
                    break;
                }
                else if(winner == 1){
                    System.out.println("The game is tied!");
                    break;
                }
                curr_player = curr_player.equals(this.player1)? this.player2: this.player1;
                }
            }
            catch(Exception e){
                System.out.println("Some error occurred");
            }

        }

    }
}

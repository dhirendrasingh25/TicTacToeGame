package TicTacToe;
import java.util.Scanner;

public class TicTacToe {
    private player player1, player2;
    private Board board;
    static Scanner sc= new Scanner(System.in);

    public static void main(String[] args) {
        TicTacToe t= new TicTacToe();
        t.startGame();
    }
    
    public void startGame(){
      player1=takePlayerInput(1);
      player2=takePlayerInput(2);

      while(player1.getSymbol()==player2.getSymbol()){
        System.out.println("Symbol already Taken !! Pick another symbol !!");
        char symbol=sc.next().charAt(0);
        player2.setSymbol(symbol);
      }

      board = new Board(player1.getSymbol(),player2.getSymbol());

      boolean player1Turn = true;

      int status=Board.INCOMPLETE;
      while(status==Board.INCOMPLETE || status == Board.INVALID){
        if(player1Turn){
            System.out.println("Player 1 - "+player1.getName()+"'s turn");
            System.out.println("Enter x: ");
            int x=sc.nextInt();
            System.out.println("Enter y: ");
            int y=sc.nextInt();
            status = board.move(player1.getSymbol(),x,y);
            if(status != Board.INVALID){
                player1Turn=false;
                board.print();
            }else{
                System.out.println("Invalid Move !! Try Again !! ");
            }
        }else{
            System.out.println("Player 2 - "+player2.getName()+"'s turn");
            System.out.println("Enter x: ");
            int x=sc.nextInt();
            System.out.println("Enter y: ");
            int y=sc.nextInt();
            status = board.move(player2.getSymbol(),x,y);
            if(status != Board.INVALID){
                player1Turn=true;
                board.print();
            }else{
                System.out.println("Invalid Move !! Try Again !! ");
            }
        }
      }
      if(status== Board.PLAYER1_WINS){
        System.out.println("Player 1 - "+player1.getName()+" wins !!");
      }else if(status== Board.PLAYER2_WINS){
        System.out.println("Player 2 - "+player2.getName()+" wins !!");
      }else{
        System.out.println(" !! DRAW !!");
      }

    }
    private player takePlayerInput(int num){
        
        System.out.println("Enter Player "+num+" name: ");
        String name =sc.next();
        System.out.println("Enter Player "+num+" symbol: ");
        char symbol=sc.next().charAt(0);
        player p= new player(name,symbol);
        return p;
    }
}

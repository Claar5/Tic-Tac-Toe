import java.util.*;

public class TicTacToe{
	
	public static void printGameBoard(char[][] gameBoard){
		for(char[] row: gameBoard){
			for(char c:row){
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void placePiece(char[][] gameBoard, int pos, String user){
		char symbol = 'X';
		
		if(user.equals ("cpu")){
			symbol = 'O';
			playerPositions.add(pos);				
		}
		
		if(user.equals ("player")){
			symbol = 'X';
			playerPositions.add(pos);
		}
		
		switch(pos){
			case 1:
				gameBoard[0][0] = symbol;
			break;
			case 2:
				gameBoard[0][2] = symbol;
			break;
			case 3:
				gameBoard[0][4] = symbol;
			break;
			case 4:
				gameBoard[2][0] = symbol;
			break;
			case 5:
				gameBoard[2][2] = symbol;
			break;
			case 6:
				gameBoard[2][4] = symbol;
			break;
			case 7:
				gameBoard[4][0] = symbol;
			break;
			case 8:
				gameBoard[4][2] = symbol;
			break;
			case 9:
				gameBoard[4][4] = symbol;
			break;
			default: break;
			
		}
		
	}
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	public static String checkWinner(){
		//all the win conditions
		List topRow = Arrays.asList(1,2,3);
		List middleRow = Arrays.asList(4,5,6);
		List bottomRow = Arrays.asList(7,8,9);
		
		List leftCol = Arrays.asList(1,4,7);
		List middleCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		
		List diag2 = Arrays.asList(1,5,9);
		List diag1 = Arrays.asList(3,5,7);
		
		List<List> winnings = new ArrayList<List>();
		winnings.add(topRow);// winning condition lists to a list
		winnings.add(middleRow);
		winnings.add(bottomRow);
		winnings.add(leftCol);
		winnings.add(middleCol);
		winnings.add(rightCol);
		winnings.add(diag1);
		winnings.add(diag2);
		
		for(List i : winnings){
			if(playerPositions.containsAll(i)){
				return "Congratulations player won";
			}
			else if (cpuPositions.containsAll(i)){
				return "Congratulations plcpuayer won";
			}
			else if( playerPositions.size() + cpuPositions.size() == 9){
				return "CAT";
			}				
		}
		return "";
	}
	
	
	public static void main(String args[]){
		
		char[] [] gameBoard = 
		{{' ','|',' ','|',' ' },
		{'-','+','-','+','-' },
		{' ','|',' ','|',' ' },
		{'-','+','-','+','-' },
		{' ','|',' ','|',' ' }};//creating the board
		
		printGameBoard(gameBoard);//displaying the board
		
		boolean flag = true;
		while(true){
			Scanner input = new Scanner(System.in); //getting input from the user
			System.out.println("Enter your placement 1-9:");
			
			int player = input.nextInt();//storing input in n
			
			
			while(playerPositions.contains(player) || cpuPositions.contains(playerPositions)){
				System.out.println("Position taken");
				player = input.nextInt();
			}
			placePiece(gameBoard, player, "player");
			String result = checkWinner();
			
			Random rand = new Random();
			int cpu = rand.nextInt(9)+1; //generate random number from 1 to 9
			
			while(playerPositions.contains(cpu) || cpuPositions.contains(cpuPositions)){
				System.out.println("Position taken");
				cpu = rand.nextInt();
			}
						
			placePiece(gameBoard, cpu, "cpu");

			printGameBoard(gameBoard);
			result = checkWinner();
			
			if(result.length() > 0){
				System.out.println(result);
				break;
			}

		}
	}
}
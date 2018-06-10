package programmers;

public class level2_0610 {
	//다른 사람 풀이
	class Hopscotch {
	    int hopscotch(int[][] board, int size) {
	        return hopscotch(board, size, 0, -1);
	    }

	    private int hopscotch(int[][] board, int size, int y, int idx) {
	      if (y >= size) return 0;
	      int answer = Integer.MIN_VALUE;
	      for (int i = 0; i < 4; i++) {
	        if (i != idx) {
	          answer = Math.max(hopscotch(board, size, y + 1, i) + board[y][i], answer);
	        }
	      }
	      return answer;
	    }

	    public static void main(String[] args) {
	        Hopscotch c = new Hopscotch();
	        int[][] test = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
	        System.out.println(c.hopscotch(test, 3));
	    }
	}

//----------------------------------------------------
	
class Hopscotch {
    int hopscotch(int[][] board, int size) {
        for(int i=1; i<size; i++) {
            board[i][0] += Math.max(board[i-1][1], Math.max(board[i-1][2], board[i-1][3]));
            board[i][1] += Math.max(board[i-1][0], Math.max(board[i-1][2], board[i-1][3]));
            board[i][2] += Math.max(board[i-1][0], Math.max(board[i-1][1], board[i-1][3]));
            board[i][3] += Math.max(board[i-1][0], Math.max(board[i-1][1], board[i-1][2]));
        }
        return Math.max(board[size-1][0], Math.max(board[size-1][1], Math.max(board[size-1][2], board[size-1][3])));
    }

    public static void main(String[] args) {
        Hopscotch c = new Hopscotch();
        int[][] test = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        System.out.println(c.hopscotch(test, 3));
    }

}

	
}

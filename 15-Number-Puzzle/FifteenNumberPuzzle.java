import java.util.Scanner;

public class FifteenNumberPuzzle {
    public static String check(String puzzle[][], String answer[][], int row, int col) {
        int flag = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (puzzle[i][j] != answer[i][j]) {
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            return "You Win";
        }

        return move(puzzle, answer, row, col);
    }

    public static String move(String puzzle[][], String answer[][], int row, int col) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("['l' for left move, ");
        System.out.print("'r' for right move, ");
        System.out.print("'t' for top move, ");
        System.out.print("'b' for bottom move: ]");
        Scanner input = new Scanner(System.in);
        char dir = input.next().charAt(0);
        int i = 0;
        int j = 0;
        if (dir == 'l') {
            j = -1;
        } else if (dir == 'r') {
            j = 1;
        } else if (dir == 't') {
            i = -1;
        } else if (dir == 'b') {
            i = 1;
        } else {
            System.out.println("Invalid Input");
            return move(puzzle, answer, row, col);
        }

        if ((row + i == -1) || (row + i == 4) || (col + j == -1) || (col + j == 4)) {
            System.out.println("Invalid Input");
            return move(puzzle, answer, row, col);
        } else {
            puzzle[row][col] = puzzle[row + i][col + j];
            puzzle[row + i][col + j] = "  ";
            row += i;
            col += j;
        }
        for (int m = 0; m < 4; m++) {
            for (int n = 0; n < 4; n++) {
                System.out.print(puzzle[m][n]);
                System.out.print(' ');
            }
            System.out.println("");
        }
        if (row == 3 && col == 3) {
            return check(puzzle, answer, row, col);
        }
        return move(puzzle, answer, row, col);
    }

    public static void main(String[] args) {
        String answer[][] = {{" 1", " 2", " 3", " 4"},
                {" 5", " 6", " 7", " 8"},
                {" 9", "10", "11", "12"},
                {"13", "14", "15", "  "}};

        String puzzle[][] = {{" 7", " 8", " 2", " 4"},
                {" 1", " 6", " 3", " 5"},
                {"10", " 9", "12", "  "},
                {"13", "15", "14", "11"}};
        int row = 0;
        int col = 0;
        int flag_1 = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (puzzle[i][j].equals("  ")) {
                    flag_1 = 1;
                    row = i;
                    col = j;
                    break;
                }
                if (flag_1 == 1) {
                    break;
                }
            }
        }
        for (int m = 0; m < 4; m++) {
            for (int n = 0; n < 4; n++) {
                System.out.print(puzzle[m][n]);
                System.out.print(' ');
            }
            System.out.println("");
        }
        System.out.println(check(puzzle, answer, row, col));
    }
}

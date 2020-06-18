package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character[][] arr = new Character[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = ' ';
            }
        }
        print(arr, true);
        boolean t = true;
        int counter = 0;
        char xo;
        do {
            if (counter % 2 == 0) {
                xo = 'X';
            } else {
                xo = 'O';
            }
            System.out.print("Enter the coordinates:");
            String cordinates = scanner.nextLine();
            String cord = cordinates.replaceAll(" ", "");
            if (cord.matches("\\d.")) {
                int i = Integer.parseInt(String.valueOf(cord.charAt(0)));
                int i1 = Integer.parseInt(String.valueOf(cord.charAt(1)));
                do {
                    if (i > 3 || i < 1 || i1 > 3 || i1 < 1) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (cord.charAt(0) == '1' && cord.charAt(1) == '1' && arr[2][0] == ' ') {
                        arr[2][0] = xo;
                        print(arr, true);
                        counter++;
                    } else if (cord.charAt(0) == '1' && cord.charAt(1) == '2' && arr[1][0] == ' ') {
                        arr[1][0] = xo;
                        print(arr, true);
                        counter++;
                    } else if (cord.charAt(0) == '1' && cord.charAt(1) == '3' && arr[0][0] == ' ') {
                        arr[0][0] = xo;
                        print(arr, true);
                        counter++;
                    } else if (cord.charAt(0) == '2' && cord.charAt(1) == '1' && arr[2][1] == ' ') {
                        arr[2][1] = xo;
                        print(arr, true);
                        counter++;
                    } else if (cord.charAt(0) == '2' && cord.charAt(1) == '2' && arr[1][1] == ' ') {
                        arr[1][1] = xo;
                        print(arr, true);
                        counter++;
                    } else if (cord.charAt(0) == '2' && cord.charAt(1) == '3' && arr[0][1] == ' ') {
                        arr[0][1] = xo;
                        print(arr, true);
                        counter++;
                    } else if (cord.charAt(0) == '3' && cord.charAt(1) == '1' && arr[2][2] == ' ') {
                        arr[2][2] = xo;
                        print(arr, true);
                        counter++;
                    } else if (cord.charAt(0) == '3' && cord.charAt(1) == '2' && arr[1][2] == ' ') {
                        arr[1][2] = xo;
                        print(arr, true);
                        counter++;
                    } else if (cord.charAt(0) == '3' && cord.charAt(1) == '3' && arr[0][2] == ' ') {
                        arr[0][2] = xo;
                        print(arr, t);
                        counter++;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                    if ((checkColumn(arr, 'X')) ||
                            (checkRow(arr, 'X')) ||
                            (checkDiagonal1(arr, 'X')) ||
                            (checkDiagonal2(arr, 'X'))) {
                        System.out.println("X wins");
                        return;
                    } else if ((checkColumn(arr, 'O')) ||
                            (checkRow(arr, 'O')) ||
                            (checkDiagonal1(arr, 'O')) ||
                            (checkDiagonal2(arr, 'O'))) {
                        System.out.println("O wins");
                        return;
                    }else if(counter == 9){
                        System.out.println("Draw");
                        return;
                    }
                }
                while (anyEmptyField(arr));
            } else {
                System.out.println("You should enter numbers!");
            }
        } while (t);
    }
    private static void print(Character[][] arr, boolean t) {
        System.out.println("---------");
        System.out.println("| " + arr[0][0] + " " + arr[0][1] + " " + arr[0][2] + " |");
        System.out.println("| " + arr[1][0] + " " + arr[1][1] + " " + arr[1][2] + " |");
        System.out.println("| " + arr[2][0] + " " + arr[2][1] + " " + arr[2][2] + " |");
        System.out.println("---------");
        t = false;
    }
    private static boolean checkRow(Character[][] arr, char symbol) {
        for (int row = 0; row < 3; row++) {
            boolean win = true;
            for (int column = 0; column < 3; column++) {
                if (arr[row][column] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }
    private static boolean checkColumn(Character[][] arr, char symbol) {
        for (int column = 0; column < 3; column++) {
            boolean win = true;
            for (int row = 0; row < 3; row++) {
                if (arr[row][column] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }
    private static boolean checkDiagonal1(Character[][] arr, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (arr[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }
    private static boolean checkDiagonal2(Character[][] arr, char symbol) {
        for (int i = 0; i < 3; i++)
            if (arr[i][(3 - 1) - i] != symbol) {
                return false;
            }
        return true;
    }
    private static boolean anyEmptyField(Character[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkRow(arr, 'X') || !checkRow(arr, 'O') ||
                        !checkColumn(arr, 'X') || !checkColumn(arr, 'O') ||
                        !checkDiagonal1(arr, 'X') || !checkDiagonal2(arr, 'X') ||
                        !checkDiagonal1(arr, 'O') || !checkDiagonal2(arr, 'O') &&
                        arr[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
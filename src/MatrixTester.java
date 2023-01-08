import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class MatrixTester {
    public static void main(String[] args) throws Exception {

        String fileName = "src//example-matrix.txt";

        File file = new File(fileName);

        matrixToSpiralForm(fileToMatrix(file));
    }

    static void matrixToSpiralForm(int[][] matrix) {
//--------------------------------------------------------
// Summary: In this method, we printed the matrix 2D array in spiral form.
// Precondition: matrix is a 2D array.
// Postcondition: the matrix is printed as a spiral.
//--------------------------------------------------------
        LinkedList<Integer> list = new LinkedList<Integer>();

        int i;//iterator
        int minRow = 0;
        int minColumn = 0;
        int maxRow = matrix.length;
        int maxColumn = matrix[0].length;
        int count = 0;
        int total = maxRow * maxColumn;

        while (minRow < maxRow && minColumn < maxColumn) {
            if (count == total)
                break;

            for (i = minRow; i < maxRow; ++i) {
                list.add(matrix[i][minColumn]);

                count++;
            }
            minColumn++;
            if (count == total)
                break;

            for (i = minColumn; i < maxColumn; ++i) {
                list.add(matrix[maxRow - 1][i]);

                count++;
            }
            maxRow--;
            if (count == total)
                break;

            if (minRow < maxRow) {
                for (i = maxRow - 1; i >= minRow; --i) {
                    list.add(matrix[i][maxColumn - 1]);

                    count++;
                }
                maxColumn--;
            }
            if (count == total)
                break;

            if (minColumn < maxColumn) {
                for (i = maxColumn - 1; i >= minColumn; --i) {
                    list.add(matrix[minRow][i]);

                    count++;
                }
                minRow++;
            }
        }
        //checks the list and prints the result.
        list.forEach(element -> {
            if (element.equals(-1)) {
                System.exit(0);
            } else {
                System.out.print(element + " ");
            }
        });
    }

    static int[][] fileToMatrix(File file) throws Exception {
//--------------------------------------------------------
// Summary: In this method, the file is read and converted into a 2D array.
// Precondition: File is for txt file to access.
// Postcondition: Matrix in txt file transferred to 2D array and returned 2D array.
//--------------------------------------------------------
        //To find the value of row.
        Scanner scan = new Scanner(file);
        int row = 0;
        int col = 0;
        while (scan.hasNextLine()) {
            String rowLine = scan.nextLine();
            row++;
        }
        //To find the value of column.
        scan = new Scanner(file);
        String scanNext = scan.nextLine();
        String[] colLine = scanNext.split(" ");
        for (int i = 0; i < colLine.length; i++) {
            col++;
        }

        int arr[][] = new int[row][col];
        //To create and fill a 2D array.
        Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
        while (sc.hasNextLine()) {
            for (int i = 0; i < arr.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        return arr;
    }
}

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Board {
    private final int dimension;
    private final int [][] tiles;
    private final int [][] goal;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles)
    {
        this.tiles = tiles;
        dimension = tiles.length;
        goal = new int[dimension][dimension];

        int count = 1;
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                goal[i][j] = count;
                count++;
            }
        }
        goal[dimension - 1][dimension - 1] = 0;
    }

    // string representation of this board
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append(dimension);
        result.append("\n");
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                result.append(tiles[i][j]);
                result.append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    // board dimension n
    public int dimension()
    {
        return dimension;
    }

    // number of tiles out of place
    public int hamming()
    {
        int count = 0;
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                if (tiles[i][j] != goal[i][j])
                {
                    count++;
                }
            }
        }
        return count - 1;
    }

    private Index goalTotalIndex(int number)
    {
        Index index = new Index();
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                if (number != 0 && goal[i][j] == number)
                {
                    index.row = i;
                    index.col = j;
                    return index;
                }
            }
        }
        return null;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan()
    {
        int manhattan = 0;
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                if (goalTotalIndex(tiles[i][j]) != null)
                {
                    int difference = Math.abs(Objects.requireNonNull(goalTotalIndex(tiles[i][j])).row - i) +
                            Math.abs(Objects.requireNonNull(goalTotalIndex(tiles[i][j])).col - j);
                    manhattan += difference;
                }
            }
        }
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal()
    {
        return manhattan() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y)
    {
        if (y == this) return true;

        if (y == null) return false;

        if (y.getClass() != this.getClass()){
            return false;
        }

        Board thatBoard = (Board)y;
        if (this.dimension != thatBoard.dimension){
            return false;
        }

        int[][] arr_thatBoard = thatBoard.tiles;
        for (int i=0; i<dimension; i++){
            for (int j=0; j<dimension; j++){
                if (tiles[i][j] != arr_thatBoard[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private class Index
    {
        int row;
        int col;
    }

    private Index findBlank()
    {
        Index index = new Index();

        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                if (tiles[i][j] == 0)
                {
                    index.row = i;
                    index.col = j;
                    return index;
                }
            }
        }
        return index;
    }

    private int[][] createNeighbor(int i1, int j1, int i2, int j2)
    {
        int [][] a = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++)
        {
            a[i] = Arrays.copyOf(tiles[i], tiles[i].length);
        }
        int [][] neighborBoard = null;
        if (i2 >= 0 && i2 < dimension && j2 >= 0 && j2 < dimension)
        {
            // 1 -> 0; 2 -> other value
            neighborBoard = Arrays.copyOf(a, dimension);
            int value1 = a[i2][j2];
            int value2 = a[i1][j1];
            neighborBoard[i1][j1] = value1;
            neighborBoard[i2][j2] = value2;
        }
        return neighborBoard;
    }

    // all neighboring boards
    public Iterable<Board> neighbors()
    {
        ArrayList<Board> boardArrayList = new ArrayList<>();
        Index index = findBlank();
        int blankRow = index.row;
        int blankCol = index.col;
        int [][] neighborBoard;

        neighborBoard = createNeighbor(blankRow, blankCol, blankRow, blankCol - 1);
        if (neighborBoard != null)
        {
            boardArrayList.add(new Board(neighborBoard));
        }

        neighborBoard = createNeighbor(blankRow, blankCol, blankRow, blankCol + 1);
        if (neighborBoard != null)
        {
            boardArrayList.add(new Board(neighborBoard));
        }

        neighborBoard = createNeighbor(blankRow, blankCol, blankRow - 1, blankCol);
        if (neighborBoard != null)
        {
            boardArrayList.add(new Board(neighborBoard));
        }

        neighborBoard = createNeighbor(blankRow, blankCol, blankRow + 1, blankCol);
        if (neighborBoard != null)
        {
            boardArrayList.add(new Board(neighborBoard));
        }

        return boardArrayList;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin()
    {
        int [][] a = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++)
        {
            a[i] = Arrays.copyOf(tiles[i], tiles[i].length);
        }

        int i = 0;
        int j = 0;

        // tim vi tri 2 vien gach dung canh nhau dau tien va doi cho
        while (a[i][j] == 0 || a[i][j + 1] == 0)
        {
            j++;
            if (j >= dimension - 1)
            {
                i++;
                j = 0;
            }
        }

        return new Board(createNeighbor(i, j, i, j + 1));
    }

    // unit testing (not graded)
    public static void main(String[] args)
    {
        In in = new In("D:\\Nam_hai\\Semester_1\\DSA\\DSA_BTVN\\Coursera\\src\\board.txt");
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board board = new Board(tiles);
        System.out.println(board.dimension());
        System.out.println(board);
        System.out.println(board.isGoal());
        System.out.println(board.hamming());
        System.out.println(board.manhattan());
        for (Board i : board.neighbors())
        {
            System.out.println(i);
        }
        System.out.println(board.twin());

        int [][]goal = new int[3][3];

        int count = 1;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                goal[i][j] = count;
                count++;
            }
        }
        goal[3 - 1][3 - 1] = 0;
        Board boardGoal = new Board(goal);
        System.out.println(boardGoal);
        System.out.println(boardGoal.manhattan());
    }

}
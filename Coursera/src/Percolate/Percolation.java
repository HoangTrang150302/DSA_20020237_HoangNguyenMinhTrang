package Percolate;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean [][]a;
    private final int size;
    private int openSites;
    private final WeightedQuickUnionUF wqfGrid; //check percolate
    private final WeightedQuickUnionUF wqfFull; //check full
    private final int top;
    private final int bottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n)
    {
        size = n;
        int totalSquare = n * n;
        openSites = 0;
        a = new boolean[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a[i][j] = false;
            }
        }
        wqfGrid = new WeightedQuickUnionUF(totalSquare + 2); // + top and bottom
        wqfFull = new WeightedQuickUnionUF(totalSquare + 1); // + top
        top = totalSquare;
        bottom = totalSquare + 1;
    }

    //turn the grid coordinate into number
    private int flattenGrid(int row, int col)
    {
        return size * (row - 1) + (col - 1);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col)
    {
        validate(row, col);
        if (isOpen(row, col))
        {
            return;
        }

        a[row - 1][col - 1] = true;
        openSites++;
        int flatIndex = flattenGrid(row, col);

        //connect to top and bottom
        if (row == 1) //top row
        {
            wqfFull.union(top, flatIndex);
            wqfGrid.union(top, flatIndex);
        }

        if (row == size) //bottom row
        {
            wqfGrid.union(bottom, flatIndex);
        }

        //connect to up, down, left, right
        //left
        if (inRange(row, col - 1) && isOpen(row, col - 1))
        {
            wqfFull.union(flattenGrid(row, col - 1), flatIndex);
            wqfGrid.union(flattenGrid(row, col - 1), flatIndex);
        }

        //right
        if (inRange(row, col + 1) && isOpen(row, col + 1))
        {
            wqfFull.union(flattenGrid(row, col + 1), flatIndex);
            wqfGrid.union(flattenGrid(row, col + 1), flatIndex);
        }

        //up
        if (inRange(row - 1, col) && isOpen(row - 1, col))
        {
            wqfFull.union(flattenGrid(row - 1, col), flatIndex);
            wqfGrid.union(flattenGrid(row - 1, col), flatIndex);
        }

        //down
        if (inRange(row + 1, col) && isOpen(row + 1, col))
        {
            wqfFull.union(flattenGrid(row + 1, col), flatIndex);
            wqfGrid.union(flattenGrid(row + 1, col), flatIndex);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)
    {
        validate(row, col);
        return a[row - 1][col - 1];
    }

    private boolean inRange(int row, int col)
    {
        return row > 0 && row <= size && col > 0 && col <= size;
    }

    private void validate(int row, int col)
    {
        if (!inRange(row, col))
        {
            throw new IllegalArgumentException();
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)
    {
        validate(row, col);
        return wqfFull.find(top) == wqfFull.find(flattenGrid(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites()
    {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates()
    {
        return wqfGrid.find(top) == wqfGrid.find(bottom);
    }

    // test client (optional)
    public static void main(String[] args)
    {
        int size = 3;
        Percolation percolation = new Percolation(size);
        do
        {
            StdOut.println("Enter the coordinate of the site you want to open");
            int x = StdIn.readInt();
            int y = StdIn.readInt();
            percolation.open(x, y);
            StdOut.println("Check if the site is open: ");
            StdOut.println(percolation.isOpen(x, y));
        }
        while (!StdIn.isEmpty());

        StdOut.println("Check if the gird is percolate: ");
        StdOut.println(percolation.percolates());
    }
}

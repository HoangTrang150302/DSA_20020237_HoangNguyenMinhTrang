package Percolate;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final int numberOfTrials;
    private final double[] trialResults;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials)
    {
        if (n <= 0 && trials <= 0)
        {
            throw new IllegalArgumentException();
        }

        numberOfTrials = trials;
        trialResults = new double[numberOfTrials];

        for (int i = 0; i < numberOfTrials; i++)
        {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates())
            {
                int x = StdRandom.uniform(1, n + 1);
                int y = StdRandom.uniform(1, n + 1);
                percolation.open(x, y);
            }
            int openSties = percolation.numberOfOpenSites();
            double result = openSties / (n * n * 1.0);
            trialResults[i] = result;
        }
    }

    // sample mean of percolation threshold
    public double mean()
    {
        return StdStats.mean(trialResults);
    }

    // sample standard deviation of percolation threshold
    //Do lech chuan
    public double stddev()
    {
        return StdStats.stddev(trialResults);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo()
    {
        return mean() - ((1.96 * stddev()) / Math.sqrt(numberOfTrials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi()
    {
        return mean() + ((1.96 * stddev()) / Math.sqrt(numberOfTrials));
    }

    // test client (see below)
    public static void main(String[] args)
    {
        StdOut.println("Input the size of the grid: ");
        int size = StdIn.readInt();
        StdOut.println("Input the number of trial: ");
        int numberOfTrials = StdIn.readInt();

        PercolationStats percolationStats = new PercolationStats(size, numberOfTrials);
        StdOut.println("Mean = " + percolationStats.mean());
        StdOut.println("Standard deviation = " + percolationStats.stddev());
        StdOut.println("Confident high = " + percolationStats.confidenceLo());
        StdOut.println("Confident low = " + percolationStats.confidenceHi());
    }

}
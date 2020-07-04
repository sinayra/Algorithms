/* *****************************************************************************
 *  Name:              Sinayra Pascoal Cotts Moreira
 *  Coursera User ID:  9743e5f26c97c13124131a7a0c02a87b
 *  Coursera course:   Algorithms Part 1
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double INTERVAL = 1.96;

    // perform independent trials on an n-by-n grid
    private final double[] fractionOpenSites;
    private final int times;

    /**
     * perform T independent computational experiments on an N-by-N grid
     *
     * @param n - size
     * @param trials - how much times
     */
    public PercolationStats(int n, int trials)
    {
        if (n <= 0 || trials <= 0)
        {
            throw new IllegalArgumentException();
        }
        times = trials;
        fractionOpenSites = new double[times];

        for (int i = 0; i < times; i++) {
            Percolation p = new Percolation(n);
            do {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if (!p.isOpen(row, col))
                {
                    p.open(row, col);
                }
            } while (!p.percolates());

            // number of open sites by total of sites
            fractionOpenSites[i] = (double) p.numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean()
    {
        return StdStats.mean(fractionOpenSites);
    }

    // sample standard deviation of percolation threshold
    public double stddev()
    {
        return StdStats.stddev(fractionOpenSites);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo()
    {
        double meanValue = mean();
        double stddevValue = stddev();

        return meanValue - ((INTERVAL * stddevValue)/Math.sqrt(times));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi()
    {
        double meanValue = mean();
        double stddevValue = stddev();

        return meanValue + ((INTERVAL * stddevValue)/Math.sqrt(times));
    }


    // test client (see below)
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(n, t);

        System.out.println("mean = " + stats.mean());
        System.out.println("stddev = " + stats.stddev());
        System.out.println("95% confidence interval = [" + stats.confidenceLo()
                                   + ", " + stats.confidenceHi() + "]");
    }
}

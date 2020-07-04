/* *****************************************************************************
 *  Name:              Sinayra Pascoal Cotts Moreira
 *  Coursera User ID:  9743e5f26c97c13124131a7a0c02a87b
 *  Coursera course:   Algorithms Part 1
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {


    private final boolean [][] grid;
    private final WeightedQuickUnionUF ufTopDown;
    private final WeightedQuickUnionUF ufTop;
    private final int size, virtualTop, virtualBottom;
    private int numOpen;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n)
    {
        if (n <= 0)
        {
            throw new IllegalArgumentException();
        }
        grid = new boolean[n][n];
        ufTopDown = new WeightedQuickUnionUF(n * n + 2);
        ufTop = new WeightedQuickUnionUF(n * n + 1);
        size = n;
        numOpen = 0;
        virtualTop = size * size;
        virtualBottom = size * size + 1;

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                grid[i][j] = false;
            }
        }

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col)
    {
        if (!isValidRowCol(row, col))
        {
            throw new IllegalArgumentException();
        }

        if (!isOpen(row, col))
        {
            final int i = row - 1;
            final int j = col - 1;

            grid[i][j] = true;

            if (i == 0)
            {
                int p = size * i + j;
                ufTopDown.union(p, virtualTop);
                ufTop.union(p, virtualTop);
            }
            if (i == size - 1)
            {
                int p = size * i + j;
                ufTopDown.union(p, virtualBottom);
            }

            connectNeighbors(i, j);
            numOpen++;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)
    {
        if (!isValidRowCol(row, col))
        {
            throw new IllegalArgumentException();
        }

        final int i = row - 1;
        final int j = col - 1;

        return grid[i][j];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)
    {
        if (!isValidRowCol(row, col))
        {
            throw new IllegalArgumentException();
        }

        if (isOpen(row, col))
        {
            final int i = row - 1;
            final int j = col - 1;

            int p = ufTop.find(size * i + j);
            int top = ufTop.find(virtualTop);

            if (p == top) {
                return true;
            }
        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites()
    {
        return numOpen;
    }

    // does the system percolate?
    public boolean percolates()
    {
        return (ufTopDown.find(virtualTop) == ufTopDown.find(virtualBottom));
    }

    private void displayGrid()
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    // test client (optional)
    public static void main(String[] args)
    {
        Percolation percolation = new Percolation(6);

        percolation.displayGrid();

        percolation.open(1, 6);
        percolation.open(2, 6);
        percolation.open(3, 6);
        percolation.open(4, 6);
        percolation.open(5, 6);
        percolation.open(5, 5);
        percolation.open(4, 4);
        percolation.open(3, 4);
        percolation.open(2, 4);
        percolation.open(2, 3);
        percolation.open(2, 2);
        percolation.open(2, 1);
        percolation.open(3, 1);
        percolation.open(4, 1);
        percolation.open(5, 1);
        percolation.open(5, 2);
        percolation.open(6, 2);
        percolation.open(5, 4);

        percolation.displayGrid();

        System.out.println(percolation.percolates());
    }

    private void connect(int i1, int j1, int i2, int j2)
    {
        int p, q;
        int pValue = size * i1 + j1;
        int qValue = size * i2 + j2;

        p = ufTop.find(pValue);
        q = ufTop.find(qValue);

        ufTopDown.union(p, q);
        ufTop.union(p, q);
    }

    private void connectNeighbors(int i, int j)
    {
        int neighborI, neighborJ;

        neighborI = i - 1;
        neighborJ = j;
        if (isValidRowCol(neighborI + 1, neighborJ + 1) && isOpen(neighborI + 1, neighborJ + 1)) {
            connect(i, j, neighborI, neighborJ);
        }

        neighborI = i;
        neighborJ = j - 1;
        if (isValidRowCol(neighborI + 1, neighborJ + 1) && isOpen(neighborI + 1, neighborJ + 1)) {
            connect(i, j, neighborI, neighborJ);
        }

        neighborI = i;
        neighborJ = j + 1;
        if (isValidRowCol(neighborI + 1, neighborJ + 1) && isOpen(neighborI + 1, neighborJ + 1)) {
            connect(i, j, neighborI, neighborJ);
        }

        neighborI = i + 1;
        neighborJ = j;
        if (isValidRowCol(neighborI + 1, neighborJ + 1) && isOpen(neighborI + 1, neighborJ + 1)) {
            connect(i, j, neighborI, neighborJ);
        }
    }

    private boolean isValidRowCol(int row, int col)
    {
        return (row <= size && col <= size && row > 0 && col > 0);
    }
}
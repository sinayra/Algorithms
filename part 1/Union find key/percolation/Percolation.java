/* *****************************************************************************
 *  Name:              Sinayra Pascoal Cotts Moreira
 *  Coursera User ID:  9743e5f26c97c13124131a7a0c02a87b
 *  Coursera course:   Algorithms Part 1
 **************************************************************************** */

public class Percolation {

    private enum SITE {
        OPEN,
        BLOCKED
    }

    private class Data {
        private int value;
        private SITE info;

        Data(int value, SITE info)
        {
            this.setValue(value);
            this.setInfo(info);
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public SITE getInfo() {
            return info;
        }

        public void setInfo(SITE info) {
            this.info = info;
        }
    }

    private final Data [][] grid;
    private final int size;
    private int numOpen;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n)
    {
        if (n <= 0)
        {
            throw new IllegalArgumentException();
        }
        grid = new Data[n][n];
        size = n;
        numOpen = 0;

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                grid[i][j] = new Data(i * size + j, SITE.BLOCKED);
            }
        }
    }


    private int connect(int row, int col, int neighborRow, int neighborCol)
    {
        if (neighborRow >= 0 && neighborRow < size && neighborCol >= 0 && neighborCol < size)
        {
            if (isOpen(neighborRow + 1, neighborCol + 1))
            {
                int lowestValue = Math.min(grid[row][col].getValue(),
                                           grid[neighborRow][neighborCol].getValue());

                grid[row][col].setValue(lowestValue);
                grid[neighborRow][neighborCol].setValue(lowestValue);

                return lowestValue;
            }

        }

        return Integer.MAX_VALUE;
    }

    private void connectNeighbors(int row, int col)
    {
        int[] values = new int[5];
        int lowest;

        values[0] = connect(row, col, row - 1, col);
        lowest = values[0];

        values[1] = connect(row, col, row, col - 1);
        if (values[1] < lowest)
            lowest = values[1];

        values[2] = connect(row, col, row, col + 1);
        if (values[2] < lowest)
            lowest = values[2];

        values[3] = connect(row, col, row + 1, col);
        if (values[3] < lowest)
            lowest = values[3];

        values[4] = grid[row][col].getValue();
        if (values[4] < lowest)
            lowest = values[4];

        grid[row][col].setValue(lowest);
        if (row - 1 >= 0 && isOpen(row, col + 1))
        {
            grid[row - 1][col].setValue(lowest);
        }

        if (row + 1 < size && isOpen(row + 2, col + 1))
        {
            grid[row + 1][col].setValue(lowest);
        }

        if (col - 1 >= 0 && isOpen(row + 1, col))
        {
            grid[row][col - 1].setValue(lowest);
        }

        if (col + 1 < size && isOpen(row + 1, col + 2))
        {
            grid[row][col + 1].setValue(lowest);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col)
    {
        if (row > size || col > size || row <= 0 || col <= 0)
        {
            throw new IllegalArgumentException();
        }

        final int i = row - 1;
        final int j = col - 1;

        if (grid[i][j].getInfo() == SITE.BLOCKED)
        {
            grid[i][j].setInfo(SITE.OPEN);

            connectNeighbors(i, j);
            numOpen++;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)
    {
        if (row > size || col > size || row <= 0 || col <= 0)
        {
            throw new IllegalArgumentException();
        }

        final int i = row - 1;
        final int j = col - 1;

        return (grid[i][j].getInfo() != SITE.BLOCKED);
    }

    private int getRoot(int row, int col)
    {
        int value = grid[row][col].getValue();

        int i = value / size;
        int j = value % size;

        while (value != grid[i][j].getValue())
        {
            // update the root of i,j to the root of its root
            grid[row][col].setValue(value);
            row = i;
            col = j;

            value = grid[row][col].getValue();
            i = value / size;
            j = value % size;
        }

        return value;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)
    {
        if (row > size || col > size || row <= 0 || col <= 0)
        {
            throw new IllegalArgumentException();
        }

        final int i = row - 1;
        final int j = col - 1;

        int value = getRoot(i, j);

        if (value < size && grid[i][j].getInfo() == SITE.OPEN)
        {
            return true;
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
        for (int i = 0; i < size; i++)
        {
            if (isFull(size, i + 1))
            {
                return true;
            }
        }

        return false;
    }

    private void displayGrid()
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                System.out.print(grid[i][j].getInfo() + ": " + grid[i][j].getValue() + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    // test client (optional)
    public static void main(String[] args)
    {
        Percolation percolation = new Percolation(5);

        percolation.displayGrid();

        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(1, 4);
        percolation.open(2, 4);
        percolation.open(3, 2);
        percolation.open(3, 4);
        percolation.open(3, 5);
        percolation.open(4, 1);
        percolation.open(4, 3);
        percolation.open(5, 1);
        percolation.open(5, 2);
        percolation.open(5, 4);
        percolation.open(5, 5);

        percolation.open(3, 3);
        percolation.open(3, 1);

        percolation.displayGrid();

        System.out.println(percolation.percolates());
    }
}

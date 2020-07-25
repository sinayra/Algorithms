/* *****************************************************************************
 *  Name:              Sinayra Pascoal Cotts Moreira
 *  Coursera User ID:  9743e5f26c97c13124131a7a0c02a87b
 *  Coursera course:   Algorithms Part 1
 **************************************************************************** */

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;

public class Board {
    private final int [][]board;
    private final int n;
    private int randomX1, randomY1, randomX2, randomY2;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles)
    {
        n = tiles.length;
        board = new int[n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                board[i][j] = tiles[i][j];
            }
        }

        do {
            randomX1 = StdRandom.uniform(n);
            randomX2 = StdRandom.uniform(n);
            randomY1 = StdRandom.uniform(n);
            randomY2 = StdRandom.uniform(n);
        } while (board[randomX1][randomY1] == board[randomX2][randomY2]
                || 0 == board[randomX1][randomY1]
                || 0 == board[randomX2][randomY2]);
    }

    // string representation of this board
    public String toString()
    {
        StringBuilder buf = new StringBuilder();
        buf.append(n);
        buf.append('\n');

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                buf.append(' ');
                buf.append(board[i][j]);
            }
            buf.append('\n');
        }

        return buf.toString();
    }

    // board dimension n
    public int dimension()
    {
        return n;
    }

    // number of tiles out of place
    public int hamming()
    {
        int wrongPositionTiles = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int expectedTile = (n * i + j) + 1;
                if (i == n - 1 && j == n - 1)
                {
                    expectedTile = 0;
                }
                if (expectedTile > 0 && board[i][j] != expectedTile)
                {
                    wrongPositionTiles++;
                }
            }
        }

        return wrongPositionTiles;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan()
    {
        int distance = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int tile = board[i][j] - 1;
                if (tile > -1)
                {
                    int row = tile / n;
                    int column = tile % n;
                    if (row != i || column != j) {
                        int x = Math.abs(row - i);
                        int y = Math.abs(column - j);

                        distance += x + y;
                    }
                }
            }
        }

        return distance;
    }

    // is this board the goal board?
    public boolean isGoal()
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int expectedTile = (n * i + j) + 1;
                if (i == n - 1 && j == n - 1)
                {
                    expectedTile = 0;
                }
                if (board[i][j] != expectedTile)
                {
                    return false;
                }
            }
        }

        return true;
    }

    // does this board equal y?
    public boolean equals(Object y)
    {
        if (y == null)
        {
            return false;
        }

        if (y == this)
        {
            return true;
        }

        if (y.getClass() != this.getClass())
        {
            return false;
        }

        Board that = (Board) y;

        if (this.dimension() != that.dimension())
        {
            return false;
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (this.board[i][j] != that.board[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors()
    {
        Stack<Board> possibleMoves = new Stack<>();
        int blankTile = findBlankTile();
        int row = blankTile / n;
        int column = blankTile % n;

        if (row > 0)
        {
            Board b = new Board(board);
            b.swap(row - 1, column, row, column);
            possibleMoves.push(b);
        }
        if (row < n - 1)
        {
            Board b = new Board(board);
            b.swap(row + 1, column, row, column);
            possibleMoves.push(b);
        }
        if (column > 0)
        {
            Board b = new Board(board);
            b.swap(row, column - 1, row, column);
            possibleMoves.push(b);
        }
        if (column < n - 1)
        {
            Board b = new Board(board);
            b.swap(row, column + 1, row, column);
            possibleMoves.push(b);
        }
        return possibleMoves;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin()
    {
        Board b = new Board(board);
        b.swap(randomX1, randomY1, randomX2, randomY2);

        return b;
    }

    // unit testing (not graded)
    // public static void main(String[] args)
    // {
    //
    // }

    private int findBlankTile()
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 0)
                {
                    return i * n + j;
                }
            }
        }

        return -1;
    }

    private void swap(int row1, int column1, int row2, int column2)
    {
        int aux = board[row1][column1];

        board[row1][column1] = board[row2][column2];
        board[row2][column2] = aux;
    }

}

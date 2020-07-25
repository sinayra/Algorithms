/* *****************************************************************************
 *  Name:              Sinayra Pascoal Cotts Moreira
 *  Coursera User ID:  9743e5f26c97c13124131a7a0c02a87b
 *  Coursera course:   Algorithms Part 1
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {

    private class SearchNode implements Comparable<SearchNode> {
        private Board initial;
        private int moves;
        private SearchNode previous;
        private int priority;

        SearchNode(Board initial, int moves, SearchNode previous)
        {
            this.initial = initial;
            this.moves = moves;
            this.previous = previous;
            this.priority = moves + initial.manhattan();
        }

        SearchNode(Board initial)
        {
            this.initial = initial;
            this.moves = 0;
            this.previous = null;
            this.priority = 0;
        }

        public int compareTo(SearchNode that) {
            if (that == null)
            {
                throw new NullPointerException();
            }

            if (that.equals(this))
            {
                return 0;
            }

            return this.priority - that.priority;
        }
    }

    private final MinPQ<SearchNode> search;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial)
    {
        if (initial == null)
        {
            throw new IllegalArgumentException();
        }
        MinPQ<SearchNode> searchTwin = new MinPQ<>();
        SearchNode mainNode = new SearchNode(initial);
        SearchNode twinNode = new SearchNode(initial.twin());

        search = new MinPQ<>();

        search.insert(mainNode);
        searchTwin.insert(twinNode);

        while (!search.min().initial.isGoal() && !searchTwin.min().initial.isGoal()) {
            mainNode = search.delMin();
            twinNode = searchTwin.delMin();

            // find for solvable puzzle
            Iterable<Board> neighbors = mainNode.initial.neighbors();
            for (Board neighbor : neighbors)
            {
                if (mainNode.previous == null || !neighbor.equals(mainNode.previous.initial))
                {
                    SearchNode searchNeighbor = new SearchNode(neighbor, mainNode.moves + 1,
                                                               mainNode);
                    search.insert(searchNeighbor);
                }
            }

            // find for solvable puzzle in twin puzzle (main puzzle would be unsolvable)
            neighbors = twinNode.initial.neighbors();
            for (Board neighbor : neighbors)
            {
                if (twinNode.previous == null || !neighbor.equals(twinNode.previous.initial))
                {
                    SearchNode searchNeighbor = new SearchNode(neighbor, twinNode.moves + 1,
                                                               twinNode);
                    searchTwin.insert(searchNeighbor);
                }
            }
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable()
    {
        return search.min().initial.isGoal();
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves()
    {
        return (isSolvable() ?  search.min().moves : -1);
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution()
    {
        if (isSolvable())
        {
            Stack<Board> possibleMoves = new Stack<>();

            SearchNode mainNode = search.min();
            do {
                possibleMoves.push(mainNode.initial);
                mainNode = mainNode.previous;
            } while (mainNode != null);


            return possibleMoves;
        }
        return null;
    }

    // test client (see below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

}

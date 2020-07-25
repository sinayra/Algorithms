import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/* *****************************************************************************
 *  Name:              Sinayra Pascoal Cotts Moreira
 *  Coursera User ID:  9743e5f26c97c13124131a7a0c02a87b
 *  Coursera course:   Algorithms Part 1
 **************************************************************************** */
class BoardTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        int tiles[][] ={
                {1, 0, 3},
                {4, 2, 5},
                {7, 8, 6}
        };
        Board board = new Board(tiles);
        String s = "3\n 1 0 3\n 4 2 5\n 7 8 6\n";

        assertEquals(s, board.toString());
    }

    @org.junit.jupiter.api.Test
    void dimension() {
        int tiles[][] ={
                {1, 0, 3},
                {4, 2, 5},
                {7, 8, 6}
        };
        Board board = new Board(tiles);

        assertEquals(3, board.dimension());
    }

    @org.junit.jupiter.api.Test
    void hamming() {
        int tiles[][] ={
                {8, 1, 3},
                {4, 0, 2},
                {7, 6, 5}
        };
        Board board = new Board(tiles);

        assertEquals(5, board.hamming());
    }

    @org.junit.jupiter.api.Test
    void manhattan() {
        int tiles[][] ={
                {8, 1, 3},
                {4, 0, 2},
                {7, 6, 5}
        };
        Board board = new Board(tiles);

        assertEquals(10, board.manhattan());
    }

    @org.junit.jupiter.api.Test
    void isGoal() {
        int tiles1[][] ={
                {8, 1, 3},
                {4, 0, 2},
                {7, 6, 5}
        };
        int tiles2[][] ={
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        Board board1 = new Board(tiles1);
        Board board2 = new Board(tiles2);

        assertFalse(board1.isGoal());
        assertTrue(board2.isGoal());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        int tiles1[][] ={
                {8, 1, 3},
                {4, 0, 2},
                {7, 6, 5}
        };
        int tiles2[][] ={
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        int tiles3[][] ={
                {8, 1, 3},
                {4, 0, 2},
                {7, 6, 5}
        };
        Board board1 = new Board(tiles1);
        Board board2 = new Board(tiles2);
        Board board3 = new Board(tiles3);

        assertTrue(board1.equals(board3));
        assertFalse(board1.equals(board2));
        assertFalse(board1.equals(tiles1));
    }

    @org.junit.jupiter.api.Test
    void neighbors() {
        int tiles[][] ={
                {1, 0, 3},
                {4, 2, 5},
                {7, 8, 6}
        };
        int tiles1[][] ={
                {1, 2, 3},
                {4, 0, 5},
                {7, 8, 6}
        };
        int tiles2[][] ={
                {0, 1, 3},
                {4, 2, 5},
                {7, 8, 6}
        };
        int tiles3[][] ={
                {1, 3, 0},
                {4, 2, 5},
                {7, 8, 6}
        };
        Board board1 = new Board(tiles1);
        Board board2 = new Board(tiles2);
        Board board3 = new Board(tiles3);

        Board board = new Board(tiles);
        Iterable<Board> boards = board.neighbors();
        ArrayList<Board> arr = new ArrayList<>();

        for (Board b : boards)
        {
            arr.add(b);
        }

        assertEquals(3, arr.size());
        assertTrue(arr.contains(board1));
        assertTrue(arr.contains(board2));
        assertTrue(arr.contains(board3));
        assertFalse(arr.contains(board));
    }

    @org.junit.jupiter.api.Test
    void twin() {
        int tiles[][] ={
                {1, 0, 3},
                {4, 2, 5},
                {7, 8, 6}
        };

        Board board = new Board(tiles);
        Board board1 = board.twin();
        Board board2 = board.twin();

        assertTrue(board1.equals(board2));
    }
}
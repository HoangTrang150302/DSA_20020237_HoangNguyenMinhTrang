import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Solver {
    private Node startNode;
    private final Node nodeTwin;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial)
    {
        int move = 0;
        MinPQ<Node> boardMinPQ = new MinPQ<>();
        startNode = new Node(initial, move);
        nodeTwin = new Node(initial.twin(), move);
        boardMinPQ.insert(startNode);
        boardMinPQ.insert(nodeTwin);
        startNode = boardMinPQ.delMin();

        while (!startNode.isGoal())
        {
            // list cac neighbors cua startNode
            ArrayList<Board> boards = new ArrayList<>();
            for (Board b : startNode.neighbors())
            {
                boards.add(b);
            }

            // tang move len tuong duong voi bac tiep theo cua cay
            move = startNode.move + 1;

            // duyet list cac hang xom cua startNode
            for (Board b : boards)
            {
                Board previousBoard = null;

                // lay ra bang dung truoc bang hien tai
                if (startNode.getPrevious() != null)
                {
                    previousBoard = startNode.previous.getBoard();
                }

                if (!b.equals(previousBoard))
                {
                    Node newNode = new Node(b, move); // tao ra node moi
                    newNode.setPrevious(startNode); // noi node do den node truoc
                    boardMinPQ.insert(newNode); // dua node do vao trong minPQ
                }
            }
            startNode = boardMinPQ.delMin();
        }
    }

    private class Node implements Comparable<Node>
    {
        private Node previous;
        private final Board board;
        private final int move;

        public Node(Board board, int move)
        {
            this.board = board;
            this.move = move;
            previous = null;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Board getBoard() {
            return board;
        }

        public int getMove() {
            return move;
        }

        public boolean isGoal()
        {
            return board.isGoal();
        }

        public int priority()
        {
            return board.manhattan() + move;
        }

        public Iterable<Board> neighbors()
        {
            return board.neighbors();
        }

        public int compareTo(Node other)
        {
            return this.priority() - other.priority();
        }

        public String toString()
        {
            return board.toString();
        }

    }

    // is the initial board solvable? (see below)
    public boolean isSolvable()
    {
        // startNode la node cuoi cung tuc la goal
        Node node = startNode;

        while (node.getPrevious() != null)
        {
            node = node.getPrevious();
        }

        return !node.getBoard().equals(nodeTwin.getBoard());
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves()
    {
        if (!isSolvable())
        {
            return -1;
        }
        return startNode.getMove();
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution()
    {
        if (!isSolvable())
        {
            return null;
        }

        Stack<Board> nodeStack = new Stack<>();
        Node node = startNode;
        nodeStack.push(node.getBoard());
        while (node.previous != null)
        {
            node = node.previous;
            nodeStack.push(node.getBoard());
        }
        return nodeStack;
    }

    // test client (see below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        // In in = new In("D:\\Nam_hai\\Semester_1\\DSA\\DSA_BTVN\\Coursera\\src\\board.txt");
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

import java.util.Scanner;

public class Task2 {
    private static int[][] matrix;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();// read number of test cases

        while (s-- > 0) {
            int n = scanner.nextInt(); // read number of cities
            matrix = new int[n][n];

            String[] names = new String[n];

            for (int i = 0; i < n; i++) {
                names[i] = scanner.next(); // remember city name

                int neigbors = scanner.nextInt();
                for (int j = 0; j < neigbors; j++) { //remember distances to all neigbors
                    int destination = scanner.nextInt() - 1;

                    matrix[i][destination] = scanner.nextInt();
                }
            }

            int m = scanner.nextInt();

            for (int i = 0; i < m; i++) {
                String from = scanner.next();
                String to = scanner.next();

                int fromIndex = 0;
                int toIndex = 0;

                // find indexes of cities in matrix

                for (int j = 0; j < n; j++) {
                    if (names[j].equals(from)) {
                        fromIndex = j;
                    }
                    if (names[j].equals(to)) {
                        toIndex = j;
                    }
                }

                System.out.println(FindShortestPath(fromIndex, toIndex));// output distance
            }
        }

    }

    // implementation of dijkstra algorithm
    private static int FindShortestPath(int fromIndex, int toIndex) {
        // initialize all variables
        int n = matrix.length;

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[fromIndex] = 0; // set distance from starting point to itself

        for (int i = 0; i < n; i++) {
            int u = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) { // choose
                    u = j;
                }
            }

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (matrix[u][v] > 0 && !visited[v]) {
                    if (dist[u] + matrix[u][v] < dist[v]) {
                        dist[v] = dist[u] + matrix[u][v];
                    }
                }
            }
        }

        return dist[toIndex];
    }
}

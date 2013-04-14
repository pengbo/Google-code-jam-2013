import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Lawnmower {
	private static boolean check(int[][] match, int line, int column) {
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < column; j++) {
				if (match[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(
				"A-large.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"A-large.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int tests = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= tests; t++) {
			out.printf("Case #%d: ", t);
			st = new StringTokenizer(f.readLine());
			int line = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());
			int[][] data = new int[line][column];
			int[][] match = new int[line][column];
			for (int i = 0; i < line; i++) {
				st = new StringTokenizer(f.readLine());
				for (int j = 0; j < column; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (line == 1 || column == 1) {
				out.println("YES");
			} else {
				for (int i = 0; i < line; i++) {
					int j = 0, target = 0;
					for (j = 0; j < column; j++) {
						if (data[i][j] > target) {
							target = data[i][j];
						}
					}
					for (j = 0; j < column; j++) {
						if (data[i][j] == target) {
							match[i][j] = 1;
						}
					}
				}
				for (int j = 0; j < column; j++) {
					int i = 0, target = 0;
					for (i = 0; i < line; i++) {
						if (data[i][j] > target) {
							target = data[i][j];
						}
					}
					for (i = 0; i < line; i++) {
						if (data[i][j] == target) {
							match[i][j] = 1;
						}
					}
				}

				if (check(match, line, column)) {
					out.println("YES");
				} else {
					out.println("NO");
				}
			}

		}
		out.close();
	}
}

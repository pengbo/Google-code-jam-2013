import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Tic_Tac_Toe_Tome {
	static BufferedReader f;
	static PrintWriter out;
	public static final String[] oWinString = { "OOOO", "TOOO", "OTOO", "OOTO",
			"OOOT" };
	public static final String[] xWinString = { "XXXX", "TXXX", "XTXX", "XXTX",
			"XXXT" };

	private static boolean someoneWon(char a, char b, char c, char d) {
		char[] ch = new char[] { a, b, c, d };
		String line = String.valueOf(ch);
		for (int i = 0; i < 5; i++) {
			if (oWinString[i].equals(line)) {
				out.println("O won");
				return true;
			}
			if (xWinString[i].equals(line)) {
				out.println("X won");
				return true;
			}
		}
		return false;
	}

	private static void solve() throws IOException {
		int dotCount = 0;
		char[][] data = new char[4][4];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			String line = st.nextToken();
			for (int j = 0; j < 4; j++) {
				data[i][j] = line.charAt(j);
				if (data[i][j] == '.') {
					dotCount++;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			if (someoneWon(data[i][0], data[i][1], data[i][2], data[i][3]))
				return;
			if (someoneWon(data[0][i], data[1][i], data[2][i], data[3][i]))
				return;
		}
		if (someoneWon(data[0][0], data[1][1], data[2][2], data[3][3]))
			return;
		if (someoneWon(data[0][3], data[1][2], data[2][1], data[3][0]))
			return;
		if (dotCount > 0) {
			out.println("Game has not completed");
		} else {
			out.println("Draw");
		}
	}

	public static void main(String[] args) throws IOException {
		f = new BufferedReader(new FileReader("A-large.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("A-large.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int tests = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= tests; t++) {
			out.printf("Case #%d: ", t);
			solve();
			f.readLine();
		}
		out.close();
	}
}

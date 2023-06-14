package Lec_05;

public class decodeString {

	public static void main(String[] args) {
		decode("1125", "");
	}

	private static void decode(String table, String bag) {
		if (table.isEmpty()) {
			System.out.println(bag);
			return;
		}
		for (int chakku = 1; chakku <= table.length(); chakku++) {
			String piece = table.substring(0, chakku);
			if (isTasty(piece)) {
				char ch = (char) (Integer.parseInt(piece) - 1 + 'a');
				String remain = table.substring(chakku);
				decode(remain, bag + "-" + piece);
			}
		}
	}
	
	public static boolean isTasty(String piece) {
		if (piece.length() > 2 || piece.length() == 0) {
			return false;
		} else if (Integer.parseInt(piece) > 26) {
			return false;
		} else {
			return true;
		}
	}
}

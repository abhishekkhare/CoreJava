import java.util.Arrays;

public class TestPOC {

	public static void main(String[] args) {
		//filePath();
		String [] a1 = new String[]{"A","B","C"};
		String [] b1 = new String[]{"A","B"};
		String [] c1 = new String[]{"B","A"};
		Arrays.sort(a1);
		Arrays.sort(b1);
		Arrays.sort(c1);
		System.out.println("A and B:" + Arrays.equals(a1, b1));
		System.out.println("A and C:" + Arrays.equals(a1, c1));
		System.out.println("B and C:" + Arrays.equals(b1, c1));
		System.out.println("C and A:" + Arrays.equals(c1, b1));
		System.out.println("deepEquals A and B:" + Arrays.deepEquals(a1, b1));
		System.out.println("deepEquals A and C:" + Arrays.deepEquals(a1, c1));
		System.out.println("deepEquals B and C:" + Arrays.deepEquals(b1, c1));
		System.out.println("deepEquals C and A:" + Arrays.deepEquals(c1, b1));
	}

	private static void filePath() {
		String tempFilePath = "/ngs/app/wswhited/m1/wsshare/ais/work/AppleCare/Projects/255850_AppleCare CC-Training/Source-English (US)/TEST_WF_RF copy 10.xml";
		tempFilePath = tempFilePath.replaceFirst("upload_\\d+", "");
		System.out.println(tempFilePath);
		
	}

}

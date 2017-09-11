package cuair;
import java.util.Scanner;

public class Solution {

	private static final String keyboard = "qwertyuiopasdfghjkl;zxcvbnm,./";

    static String findSimilarity(String inc, String[] corrections) {
        int correctIndex = 0;
        double correctStrength = Integer.MAX_VALUE;
        for (int s = 0; s < corrections.length; s ++)
        {
        	String str = corrections[s];
            double[][] matrix = new double[inc.length() + 1][str.length() + 1];
            for (int r = 0; r < matrix.length; r ++)
            	matrix[r][0] = r;
            for (int c = 0; c < matrix[0].length; c ++)
            	matrix[0][c] = c;
            for (int r = 1; r < matrix.length; r ++)
            {
            	for (int c = 1; c < matrix[r].length; c++)
            	{
            		double cost = cost(str.substring(c - 1, c), inc.substring(r - 1, r));
            		double min = Math.min(matrix[r][c-1] + 1,matrix[r-1][c] + 1);
            		matrix[r][c] = Math.min(min, matrix[r-1][c-1] + cost);
            	}
            }
            double licVal = matrix[matrix.length-1][matrix[0].length - 1];
            if (correctStrength > licVal)
            {
            	correctStrength = licVal;
            	correctIndex = s;
            }
        }
        return corrections[correctIndex];
    }
    
    public static double cost(String a, String b) {
    	if (a.equals(b))
    		return 0;
    	if ((a.equals("c") && b.equals("k")) || (a.equals("k") && b.equals("c")))
    		return 0.4;
    	if ((a.equals("s") && b.equals("c")) || (a.equals("c") && b.equals("s")))
    		return 0.4;
    	int XofA = keyboard.indexOf(a) % 10;
    	int YofA = keyboard.indexOf(a) / 10;
    	int XofB = keyboard.indexOf(b) % 10;
    	int YofB = keyboard.indexOf(b) / 10;
    	if (Math.abs(XofA - XofB) <= 1 && Math.abs(YofA - YofB) <= 1)
    		return 0.7;
    	return 1;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String incorrect_word = in.next();
        int m = in.nextInt();
        String[] correct_words = new String[m];
        for(int correct_words_i = 0; correct_words_i < m; correct_words_i++){
            correct_words[correct_words_i] = in.next();
        }
        String result = findSimilarity(incorrect_word.toLowerCase(), correct_words);
        System.out.println(result);
        in.close();
    }
}

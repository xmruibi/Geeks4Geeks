package test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {
	 private static final String right = "It's a pi song."; 
	    private static final String wrong = "It's not a pi song.";
	    private static final String PI = "31415926535897932384626433833";
	    
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        int[] pi = new int[PI.length()];
	        for(int i=0;i<PI.length();i++){
	            pi[i] = PI.charAt(i)-'0';
	        }
	        Scanner in = new Scanner(System.in);
	        int cases = in.nextInt();
	        
	        while(cases>0){
	            String line = in.next();
	            String[] words = line.trim().split(" ");
	            for(int i=0;i<words.length;i++){
	                if(words[i].length()!=pi[i]){
	                    System.out.println(wrong);
	                    break;
	                }else if(i==words.length-1&&words[i].length()==pi[i]){
	                    System.out.println(right);
	                }
	            }
	            cases--;
	        }
	    }
}

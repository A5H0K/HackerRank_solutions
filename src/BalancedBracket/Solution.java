package BalancedBracket;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        String result = "YES";
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c : ch){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return "NO";
                }
                char top = stack.pop();
                if(!((c == '}' && top == '{' ) || ( c == ')' && top == '(') || ( c == ']' && top == '[')) ){
                    return "NO";
                }
            }
        }
        if(stack.isEmpty()){
            result = "YES";
        }else{
            result = "NO";
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
package com.leetcodeproj.leetcode;

/*
*
* "Codility We test coders"
*
* With K=14 the algorithm should output:

"Codility We"
*
*Note that:

	the output "Codility We te" would be incorrect, because the original message is cropped through middle of the word
	The output "Codility We " would be incorrect, because it ends with a space.
	The output "Codility We test coders" would be incorrect, because it exceeds the K character limit
	The output "Codility" would be incorrect, because it is shorter than the correct output.
*
* */
public class Zalando2 {
        public String solution(String message,int K){
            StringBuilder builder=new StringBuilder();
            int beginI=0;
            message=message+" ";
            for(int i=0;i<message.length() && i<K;i++){
                if((i+1 != message.length()))
                    if(message.charAt(i+1)==' '){
                    builder.append(message.substring(beginI,i+1));
                    beginI=i+2;
                    builder.append(" ");
                }
            }
            System.out.println(builder.toString().trim());

            return null;
        }

    public static void main(String[] args) {
        Zalando2 zalando2=new Zalando2();
        zalando2.solution("The quick brown fox jumps over the lazy dog",39);
    }
}

package com.companies.questions.sainsbury;

public class Chess {

    public static void main(String[] args) {
        System.out.println(run("2b",3,2));
        System.out.println(run("5h",11,25));

    }
    public static String run(String startPosition, int rows, int columns) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */
        String endPosition = "";
        int boardSize=8;
        int x=Character.getNumericValue(startPosition.charAt(0));
        int y=Character.getNumericValue(startPosition.charAt(1)-'0');
        if(rows>8)
            rows=rows%boardSize;
        if (columns>8)
            columns=columns%boardSize;
        int newX=x+rows;
        int newY=y+columns;
        if(newX>8)
            newX=newX%boardSize;
        if (newY>8)
            newY=newY%boardSize;
        String X=String.valueOf(newX);
        char Y=(char)(newY + '0'+'0');
        endPosition = new StringBuilder().append(X).append(Y).toString();
        return endPosition;
    }
}

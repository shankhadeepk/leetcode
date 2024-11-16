package com.hackerrankproj.hackerrank.optiver;

import java.util.*;
import java.util.stream.Collectors;

class Node{
    String name;
    String roman;
    int val;

    Node(String name,String roman,int val){
        this.name=name;
        this.roman=roman;
        this.val=val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val && Objects.equals(name, node.name) && Objects.equals(roman, node.roman);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, roman, val);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", roman='" + roman + '\'' +
                ", val=" + val +
                '}';
    }
}
public class RoyalNames {
    private static int getRomanToInt(String s){
        Map<Character,Integer> romanMap=new HashMap<>();
        int val=-1;
        int sumNum=0;
        int pos=-1;
        romanMap.put('I', 1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        for(int i=0;i<s.length();i++){
            val=romanMap.get(s.charAt(i));
            pos=i+1;
            if(pos < s.length() && val < romanMap.get(s.charAt(pos))){
                sumNum+= (romanMap.get(s.charAt(pos))-val);
                i++;
            }else {
                sumNum+=val;
            }
        }
        return sumNum;
    }

    public static List<String> getSortedList(List<String> names){
        List<Node> nodes=new ArrayList<>();
        List<String> result=new ArrayList<>();
        if(names==null || names.isEmpty()) return result;

        for (String name:names){
            String[] spName=name.split("\\s");
            Node n=new Node(spName[0],spName[1],getRomanToInt(spName[1]));
            nodes.add(n);
        }

        // Sorting the list with name and if similar, then sorting with value
        nodes.sort((a,b)-> {return a.name.equals(b.name)?a.val-b.val:a.name.compareTo(b.name);});

        for (Node n:nodes){
            result.add(n.name+" "+n.roman);
        }
        return result;

    }
    public static void main(String[] args) {
        RoyalNames royalNames=new RoyalNames();
        List<String> names=new ArrayList<>();
        names.add("Louis IX");
        names.add("Louis VIII");
        //System.out.println(royalNames.getRomanToInt("IV"));
        royalNames.getSortedList(names).stream().forEach(System.out::println);
    }
}

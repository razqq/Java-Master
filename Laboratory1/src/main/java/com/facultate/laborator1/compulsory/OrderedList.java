package com.facultate.laborator1.compulsory;

public class OrderedList {
    public static String wordToOrderedList(String word){
        StringBuilder list = new StringBuilder("<ol>");
        for (char c: word.toCharArray()){
            list.append("<li>").append(c).append("</li>");
        }
        list.append("</ol>");
        return list.toString();
    }
}

package com.java;

import java.util.*;

public class PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex==0) return null;
        return helper(Arrays.asList(1), rowIndex);
    }

    private List<Integer> helper(List<Integer> prevRow, int rowIndex){
        if(rowIndex == prevRow.size()) return prevRow;
        List<Integer> list = new ArrayList<>();
        // add 1 in first of the list since each row will have that
        list.add(1);
        for(int i=1; i<prevRow.size(); i++) {
            list.add(prevRow.get(i-1) + prevRow.get(i));
        }
        // add 1 in last of the list since each row will have that
        list.add(1);
        // recurse with the current row as prevRow
        return helper(list, rowIndex);
    }
}

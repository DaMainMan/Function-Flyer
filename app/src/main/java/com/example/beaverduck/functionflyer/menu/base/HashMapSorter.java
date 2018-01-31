package com.example.beaverduck.functionflyer.menu.base;

import java.util.*;

public class HashMapSorter {
    /*
    This class is used to sort the label positions, on a subclass specified axis, from least to
    greatest using Collections.sort
     */
    public static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) ((Map.Entry)o1).getValue()) - ((Integer)((Map.Entry)o2).getValue());
            }//end compare
        }//end class
        );
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }//end for
        return sortedHashMap;
    }//end sortByValues
}//end class
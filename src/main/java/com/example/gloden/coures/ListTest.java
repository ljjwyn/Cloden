package com.example.gloden.coures;

import java.lang.reflect.Array;
import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        String[] record = {"a","b","c","d","e","f"};
        String[] recordLinked = {"g","h","i","j","k","l"};
        List<String> stringList = new ArrayList<>();
        List<String> stringListLinked = new LinkedList<>();
        for (int i=0;i<record.length;i++){
            stringList.add(record[i]);
            stringListLinked.add(recordLinked[i]);
        }
        ListIterator<String> stringListIterator = stringList.listIterator();
        ListIterator<String> stringListIteratorLinked = stringListLinked.listIterator();
        while (stringListIteratorLinked.hasNext()){
            stringListIterator.next();
            stringListIterator.add(stringListIteratorLinked.next());
        }
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}

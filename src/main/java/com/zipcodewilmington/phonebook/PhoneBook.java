package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    SortedMap<String, ArrayList> sm = new TreeMap();

    Set set = sm.entrySet();


    public void add(String name, String number) {


        ArrayList<String> numbers = sm.get(name);
    //    System.out.println(numbers);

        if(numbers == null) {
            numbers = new ArrayList<String>();
            numbers.add(number);

            sm.put(name,numbers);
    //        System.out.println(sm);
        }
        else {
            numbers.add(number);
        }

 //       System.out.println(numbers);

    }

    public String lookUp(String name) {
        ArrayList<String> numbers ; //= new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

        if(sm.containsKey(name)) {

            numbers = sm.get(name);
            for (String ele : numbers) {
                sb.append(ele);
            }
        }
        else {
            sb.append("Not Found");
        }

        return sb.toString();
    }


    public String reverseLookUp(String number) {
        Iterator k = set.iterator();
        String retVal = "";
        ArrayList<String> numbers ; //= new ArrayList<String>();
        String temp = "";

        while(k.hasNext()){
            Map.Entry me = (Map.Entry)k.next();
            numbers = (ArrayList)me.getValue();
    //        System.out.println(numbers);

            for(String ele: numbers) {
                if(ele.equals(number))
                {
                    retVal = me.getKey().toString();
                }
            }
        }


        return retVal;




        // ** good for key/value string - changing for key value where value is ArrayList
/*
        Iterator k = set.iterator();
        String retVal = "";

       while(k.hasNext()){
            Map.Entry me = (Map.Entry)k.next();
            if(number.equals( me.getValue())) {
               retVal = me.getKey().toString();
           }
        }


    return retVal;
    ********/
    }

    public void remove(String name) {
        sm.remove(name);

    }

    public void display() {

        Iterator i = set.iterator();

        while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            System.out.println(me.getKey()+ " " + me.getValue());
        }

    }

    public void removeNum(String number) {


        ArrayList<String> numbers ; //
        String removedFromKey= "";
        boolean fullRemoval = false;




        Iterator remove = set.iterator();

        while(remove.hasNext()){
            Map.Entry me = (Map.Entry)remove.next();

            numbers = (ArrayList)me.getValue();
            for(String ele: numbers) {
                if(ele.equals(number))
                {
                    if(numbers.size() == 1) {
                        //System.out.println(numbers.size());
                       //sm.remove(me.getKey().toString());
                        removedFromKey = me.getKey().toString();
                        fullRemoval = true;
                    }
                    else {
                        numbers.remove(ele);
                    }

                    break;

                }
            }
        }

    if(fullRemoval) {
        remove(removedFromKey);
    }

    }
}

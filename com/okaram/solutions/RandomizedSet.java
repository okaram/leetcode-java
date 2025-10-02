package com.okaram.solutions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

// Leetcode 380
public class RandomizedSet {
    
    public HashMap<Integer,Integer> places=new HashMap<Integer,Integer>();
    public ArrayList<Integer> elements=new ArrayList<Integer>();
    public Random r=new Random();

    public RandomizedSet() {
        
    }
    
    void checkInvariants(String operation, int v){
        System.out.println(String.format("Checking %s %d",operation,v));
        System.out.println(elements);
        System.out.println(places);
        for(int i=0;i<elements.size();++i){
            int val=elements.get(i);
            int idx=places.get(val);
            if(idx!=i)
                System.out.println(String.format("%d!=%d, v=%d",i,idx,val));
        }
    }
    public boolean insert(int val) {
        // checkInvariants("insert", val);
        if (places.containsKey(val))
            return true;
        int index=elements.size();
        elements.add(val);
        places.put(val, index);                
        // checkInvariants("insert", val);
        return false;
    }
    
    public boolean remove(int val) {
        // checkInvariants("remove", val);
        if(!places.containsKey(val))
            return false;
        int index=places.get(val);
        int other=elements.get(elements.size()-1);
        // this is a hack, instead of checking if the element is at the end :)
        places.put(other,index);
        elements.set(index,other);
        places.remove(val);
        elements.removeLast();
        // checkInvariants("remove", val);

        return true;
    }
    
    public int getRandom() {
        int idx=elements.size()==1? 0: r.nextInt(elements.size());
        return elements.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */    


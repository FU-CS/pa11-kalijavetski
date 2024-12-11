package pa11;
import java.util.LinkedList;


public class HashSet {
    private LinkedList<String>[] data;
    private int capacity = 101;
    /**
     * Constructor for the set
     */

    public HashSet() {
        this.data = new LinkedList[capacity];
        for (int i=0; i<capacity; i++){
            this.data[i] = new LinkedList<String>();
        }
    }

    /**
     * Size of the set
     * @return the number of elements in the set
     */
    public int size() {
        int count = 0;
        for (LinkedList<String> list:data){
            if (!list.isEmpty()){
                count += list.size();
            }
        }
        return count;
    }

    /** 
     * Check if the set is empty
     * @return a boolean indicating whether the set is empty
     */
    public boolean isEmpty() {
        for (LinkedList<String> list:data){
            if (!list.isEmpty()){
                return false;
            }
        }
        return true;
    }

    /**
     * Add an element to the set
     * @param s the element to add
     * @return the old value associated with the key, or null if no such entry exists
     */
    public void add(String s) {
        int sum = 0;
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int ascii = (int) ch;
            sum = sum + ascii;
        }
        int loc = sum % capacity;
        data[loc].add(s);
    }

    /** 
     * Remove an element from the set
     * @param s the element to remove
     * @return the value associated with the key, or null if no such entry exists
     */
    public void remove(String s) {
        if (contains(s)){
            int sum = 0;
            for (int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                int ascii = (int) ch;
                sum = sum + ascii;
            }
            int loc = sum % capacity;
            data[loc].remove(s);
        }
    }

    /** 
     * Check if the set contains an element
     * @param s the element to check for
     * @return a boolean indicating whether the set contains the element
     */
    public boolean contains(String s) {
        for (LinkedList<String> list:data){
                if (list.contains(s)){
                    return true;
                }
        }
        return false;
    }

    /** 
     * Clears the set
     */
    public void clear() {
        for (LinkedList<String> list:data){
            if (!list.isEmpty()){
                list.clear();
            }
        }
    }

    /** 
     * Convert the set to an array
     * @return an array containing all the elements in the set
     */
    public String[] toArray() {
        int i = 0;
        String[] array = new String[size()];
        for (LinkedList<String> list:data){
            if (!list.isEmpty()){
                for (String s:list){
                    array[i] = s;
                    i += 1;
                }
            }
        }
        return array;
    }

    /** 
     * Takes the intersection of the current set and the `other` set
     * @param other the set to intersect with
     * @return a new `HashSet` containing the intersection of the current set and the `other` set
     */
    public HashSet intersection(HashSet other) {
        String[] set1 = toArray();
        HashSet intersect = new HashSet();
        for (String s:set1){
            if (other.contains(s)){
                intersect.add(s);
            }
        }
        return intersect;
    }

    /** 
     * Convert the set to a string
     * @param other the set to union with
     * @return a new `HashSet` containing the union of the current set and the `other` set
     */
    public HashSet union(HashSet other) {
        String[] set1 = toArray();
        String[] set2 = other.toArray();
        HashSet union = new HashSet();
        for (String s:set1){
            union.add(s);
        }
        for (String t:set2){
            if (!union.contains(t)){
                union.add(t);
            }
        }
        return union;
    }

    /** 
     * Takes the difference of the current set and the `other` set 
     * @param other the set to take the difference with
     * @return a new `HashSet` containing the difference of the current set and the `other` set
     */
    public HashSet difference(HashSet other) {
        String[] set1 = toArray();
        HashSet difference = new HashSet();
        for (String s:set1){
            if (!other.contains(s)){
                difference.add(s);
            }
        }
        return difference;
    }

    /** 
     * Check if the current set is a subset of the `other` set
     * @param other the set to check for a subset
     * @return a boolean indicating whether the current set is a subset of the `other` set
     */
    public boolean subset(HashSet other) {
        String[] subset = other.toArray();
        if (size() < other.size())
            return false;
        for (String s:subset){
            if (!contains(s)){
                return false;
            }
        }
        return true;
    }
        
}

package pa11;

import java.util.LinkedList;


public class HashMap {
    private LinkedList<Pair<String, String>>[] data;
    private int capacity = 101;

    /**
     *  Constructor for the map
     */
    public HashMap() {
        this.data = new LinkedList[capacity];
        for (int i=0; i<capacity; i++){
            this.data[i] = new LinkedList<Pair<String,String>>();
    }
    }
    
    /** 
     *  Size of the map
     *  @return the number of elements in the map
     */
    public int size() {
        int count = 0;
        for (LinkedList<Pair<String,String>> list:data){
            if (!list.isEmpty()){
                count += list.size();
            }
        }
        return count;
    }

    /**
     *  Check if the map is empty
     *  @return a boolean indicating whether the map is empty
     */
    public boolean isEmpty() {
        for (LinkedList<Pair<String,String>> list:data){
            if (!list.isEmpty()){
                return false;
            }
        }
        return true;
    }

    /**
     *  Get the value associated with the key
     *  @param key the key to get the value for
     *  @return the value associated with the key, or null if no such entry exists
     */
    public String get(String key) {
        for (LinkedList<Pair<String,String>> list:data){
            for (Pair<String,String> pair:list){
                if (pair.key == key){
                    return pair.value;
                }
            }
        }
        return null;
    }

    /**
     *  Add an entry to the map
     *  @param key the key to add
     *  @param value the value to add
     *  @return the old value associated with the key, or null if no such entry exists
     */
    public String put(String key, String value) {
        int sum = 0;
        for (int i=0; i<key.length(); i++){
            char ch = key.charAt(i);
            int ascii = (int) ch;
            sum = sum + ascii;
        }
        int loc = sum % capacity;
        for (Pair<String,String> pair:data[loc]){
            if (pair.key == key){
                String currval = pair.value;
                pair.value = value;
                return currval;
            }
        }
        data[loc].add(new Pair<>(key,value));
        return null;
    }
    

    /**
     *  Remove an entry from the map
     *  @param key the key to remove
     *  @return the value associated with the key, or null if no such entry exists
     */
    public String remove(String key) {
        int sum = 0;
        for (int i=0; i<key.length(); i++){
            char ch = key.charAt(i);
            int ascii = (int) ch;
            sum = sum + ascii;
        }
        int loc = sum % capacity;
        for (Pair<String,String> pair:data[loc]){
            if (pair.key == key){
                String currval = pair.value;
                data[loc].remove(pair);
                return currval;
            }
        }
        return null;
    }

    /**
     *  Get all the keys in the map
     *  @return all the keys stored in the map
     */
    public String[] keySet() {
        int i = 0;
        String[] array = new String[size()];
        for (LinkedList<Pair<String,String>> list:data){
            if (!list.isEmpty()){
                for (Pair<String,String> pair:list){
                    array[i] = pair.key;
                    i += 1;
                }
            }
        }
        return array;
    }

    /**
     *  Get all the values in the map
     *  @return all the values stored in the map
     */
    public String[] values() {
        int i = 0;
        String[] array = new String[size()];
        for (LinkedList<Pair<String,String>> list:data){
            if (!list.isEmpty()){
                for (Pair<String,String> pair:list){
                    array[i] = pair.value;
                    i += 1;
                }
            }
        }
        return array;
    }

}

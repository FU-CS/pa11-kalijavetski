package pa11;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    @Test 
    void EmptyMap() {
        HashMap Map = new HashMap();
        assertEquals(Map.size(), 0);
        assertEquals(Map.isEmpty(), true);
    }

    @Test 
    void Map() {
        HashMap Map = new HashMap();
        Map.put("abc","abc");
        Map.put("ac","ac");
        Map.put("ab","ab");
        Map.put("a","a");
        assertEquals(Map.size(), 4);
        assertEquals(Map.isEmpty(), false);
    }
    @Test 
    void Map_putRepeatKey() {
        HashMap Map = new HashMap();
        Map.put("abc","abc");
        Map.put("ac","ac");
        Map.put("ab","ab");
        Map.put("a","a");
        Map.put("a","b");
        assertEquals(Map.size(), 4);
        assertEquals(Map.isEmpty(), false);
        assertEquals(Map.get("a"), "b");
    }

    @Test 
    void Map_remove() {
        HashMap Map = new HashMap();
        Map.put("abc","abc");
        Map.put("ac","ac");
        Map.put("ab","ab");
        Map.put("a","a");
        assertEquals(Map.size(), 4);
        assertEquals(Map.remove("a"), "a");
        assertEquals(Map.size(), 3);
    }

    @Test 
    void Map_remove_notfound() {
        HashMap Map = new HashMap();
        Map.put("abc","abc");
        Map.put("ac","ac");
        Map.put("ab","ab");
        Map.put("a","a");
        assertEquals(Map.size(), 4);
        assertEquals(Map.remove("b"), null);
        assertEquals(Map.size(), 4);
    }
    @Test 
    void Map_keySet() {
        HashMap Map = new HashMap();
        Map.put("abc","ab");
        Map.put("ac","c");
        Map.put("ab","b");
        Map.put("a","a");
        String[] str_map = {"abc","ab","ac","a"};
        assertArrayEquals(str_map, Map.keySet());
    }
    @Test 
    void Map_keySet_empty() {
        HashMap Map = new HashMap();
        String[] str_map = {};
        assertArrayEquals(str_map, Map.keySet());
    }
    @Test 
    void Map_valueSet() {
        HashMap Map = new HashMap();
        Map.put("abc","ab");
        Map.put("ac","c");
        Map.put("ab","b");
        Map.put("a","a");
        String[] str_map = {"ab","b","c","a"};
        assertArrayEquals(str_map, Map.values());
    }
    @Test 
    void Map_valueSet_empty() {
        HashMap Map = new HashMap();
        String[] str_map = {};
        assertArrayEquals(str_map, Map.values());
    }

}

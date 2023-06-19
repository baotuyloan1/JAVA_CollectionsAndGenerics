package com.baonguyen.collection.mapexample;

import java.util.*;

public class NavigableMapAndTreeMap {
  public static void main(String[] args) {
    /**
     * Navigable map is sub interface of SortedMap, so it inherits all behaviors of a sorted map
     * like range view endpoints and comparator access operations. In addition, the NavigableMap
     * interface provides navigation methods and descending view similar to NavigableSet. And due to
     * the nature of a map which stores key-value mappings, the additional APIS are designed for
     * both keys and key-value entries in the map.
     *
     * <p>*****Operations on key-value mappings (entries)*********:
     *
     * <p>lowerEntry(K key): returns a key-value mapping associated with the greatest key strictly
     * less than the given key.
     *
     * <p>floorEntry(K key): returns a key-value mapping entry which is associated with the greatest
     * key less than or equal to the given key.
     *
     * <p>ceilingEntry(K key): returns an entry associated with the lest key greater than or equal
     * to the given key.
     *
     * <p>higherEntry(K key): returns an entry associated with the least key strictly greater than
     *
     * <p>Note that all these methods return null if there is no such key.
     *
     * <p>firstEntry(): returns a key-value mapping associated with the least key in the map, or
     * null if the map is empty.
     *
     * <p>lastEntry(): returns a key-value mapping associated with the greatest key in the map, or
     * null if the map is empty. descendingMap(): returns a reverse order view of the mappings
     * contained in the map.
     *
     * <p>pollFirstEntry(): removes and returns a key-value mapping associated with the least key in
     * the map, or null if the map is empty.
     *
     * <p>pollLastEntry(): removes and returns a key-value mapping associated with the greatest key
     * in the map, or null if the map is empty.
     *
     * <p>********Operations on keys only:*****
     *
     * <p>lowerKey(K key): returns the greatest key strictly less than the given key
     *
     * <p>floorKey(K key): returns the greatest key less than or equal to the given key
     *
     * <p>(K key): returns the least key greater than or equal to the given key
     *
     * <p>(K key): returns the least key strictly greater than the given key
     *
     * <p>descendingKeySet(): returns a NavigableSet containing the keys in reverse order.
     *
     * <p>Note that all these methods return null if there is no such key.
     *
     * <p>Furthermore, the NavigableMap interface overloads the headMap(), subMap() and tailMap()
     * methods of the SortedMap interface, which accept additional arguments describing whether
     * lower or upper bounds are inclusive versus exclusive:
     *
     * <p>headMap(K toKey, boolean inclusive)
     *
     * <p>subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
     *
     * <p>tailMap(K fromKey, boolean inclusive)
     */
    NavigableMap<Integer, String> mapHttpStatus = new TreeMap<>();
    mapHttpStatus.put(100, "Continute");
    mapHttpStatus.put(200, "OK");
    mapHttpStatus.put(400, "Bad Request");
    mapHttpStatus.put(401, "Unauthorized");
    mapHttpStatus.put(500, "Internal Server Error");
    mapHttpStatus.put(501, "Not Implemented");

    Set<Integer> ascendingKeys = mapHttpStatus.keySet();
    System.out.println("Ascending keys: " + ascendingKeys);

    Set<Integer> descendingKeys = mapHttpStatus.descendingKeySet();
    System.out.println("Descending keys: " + descendingKeys);

    NavigableMap<Integer, String> descendingMap = mapHttpStatus.descendingMap();

    for (Integer key : descendingMap.keySet()) {
      System.out.println(key + " => " + descendingMap.get(key));
    }

    Integer lowerKey = mapHttpStatus.lowerKey(401);
    System.out.println("Lower key: " + lowerKey);

    Integer floorKey = mapHttpStatus.floorKey(401);
    System.out.println("Floor key: " + floorKey);

    Integer higherKey = mapHttpStatus.higherKey(401);
    System.out.println("Higher key: " + higherKey);

    Integer ceilingKey = mapHttpStatus.ceilingKey(401);
    System.out.println("Ceiling key: " + ceilingKey);

    Map.Entry<Integer, String> firstEntry = mapHttpStatus.firstEntry();
    System.out.println("First entry: " + firstEntry.getKey() + " => " + firstEntry.getValue());

    Map.Entry<Integer, String> lastEntry = mapHttpStatus.lastEntry();
    System.out.println("Last entry: " + lastEntry.getKey() + " => " + lastEntry.getValue());

    Map.Entry<Integer, String> lowerEntry = mapHttpStatus.lowerEntry(401);
    System.out.println("Lower entry: " + lowerEntry.getKey() + " => " + lowerEntry.getValue());

    Map.Entry<Integer, String> floorEntry = mapHttpStatus.floorEntry(401);
    System.out.println("Floor entry: " + floorEntry.getKey() + " => " + floorEntry.getValue());

    Map.Entry<Integer, String> higherEntry = mapHttpStatus.higherEntry(401);
    System.out.println("Higher entry: " + higherEntry.getKey() + " => " + higherEntry.getValue());

    Map.Entry<Integer, String> ceilingEntry = mapHttpStatus.ceilingEntry(401);
    System.out.println(
        "Ceiling entry: " + ceilingEntry.getKey() + " => " + ceilingEntry.getValue());

    Map.Entry firstRemoved = mapHttpStatus.pollFirstEntry();
    System.out.println(
        "Removed first entry: " + firstRemoved.getKey() + " - " + firstRemoved.getValue());

    Map.Entry lastRemoved = mapHttpStatus.pollLastEntry();
    System.out.println(
        "Removed last entry: " + lastRemoved.getKey() + " - " + lastRemoved.getValue());

    System.out.println(mapHttpStatus);
  }
}

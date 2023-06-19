package com.baonguyen.collection.mapexample;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapAndTreeMap {
  public static void main(String[] args) {
    /**
     * The main characteristic of a SortedMap is that, it orders the keys by their natural ordering,
     * or by a specified comparator. So consider using a TreeMap when you want a map that satisfies
     * the following criteria: null key or null value are not permitted. The keys are sorted either
     * by natural ordering or by a specified comparator.
     *
     * <p>Range view: returns a sub sorted map whose keys fall within a range of keys in the
     * original map.
     *
     * <p>Endpoints: returns the first or last key in the sorted map.
     *
     * <p>Comparator access: returns the comparator (implements the Comparator interface), if any,
     * used to sort the map.
     */
    SortedMap<String, String> mapDomains = new TreeMap<>();
    mapDomains.put(".com", "International");
    mapDomains.put(".us", "United States");
    mapDomains.put(".jp", "Japan");
    mapDomains.put(".au", "Australia");
    System.out.println(mapDomains);

    /**
     * Range View Operations:
     *
     * <p>+ subMap(K fromKey, K toKey): returns a sorted map whose keys range from fromKey,
     * inclusive, to toKey, exclusive.
     *
     * <p>+ headMap(K toKey): returns a sorted map whose keys are strictly less than toKey.
     *
     * <p>+ tailMap(K fromKey): returns a sorted map whose keys are greater than or equal to
     * fromKey.
     *
     * <p>* Endpoint operations:
     *
     * <p>+ firstKey(): returns the first (lowest) key currently in the map.
     *
     * <p>+ lastKey(): returns the last (highest) key currently in the map.
     *
     * <p>* Comparator access:
     *
     * <p>+ comparator(): returns the comparator used to order the keys in the map, or returns null
     * if this map uses the natural ordering of its keys.
     */
    SortedMap<Integer, String> mapHttpStatus = new TreeMap<>();
    mapHttpStatus.put(100, "Continue");
    mapHttpStatus.put(200, "OK");
    mapHttpStatus.put(300, "Multiple Choices");

    mapHttpStatus.put(400, "Bad Request");
    mapHttpStatus.put(401, "Unauthorized");
    mapHttpStatus.put(402, "Payment Required");
    mapHttpStatus.put(403, "Forbidden");
    mapHttpStatus.put(404, "Not Found");

    mapHttpStatus.put(500, "Internal Server Error");
    mapHttpStatus.put(501, "Not Implemented");
    mapHttpStatus.put(502, "Bad Gateway");

    System.out.println("All key-value pairs: ");
    for (Integer code : mapHttpStatus.keySet()) {
      System.out.println(code + " => " + mapHttpStatus.get(code));
    }

    Integer firstKey = mapHttpStatus.firstKey();
    String firstValue = mapHttpStatus.get(firstKey);
    System.out.println("First key: " + firstKey + " => " + firstValue);

    Integer lastKey = mapHttpStatus.lastKey();
    String lastValue = mapHttpStatus.get(lastKey);
    System.out.println("Last key: " + lastKey + " => " + lastValue);

    SortedMap<Integer, String> map4xxStatus = mapHttpStatus.subMap(400, 500);
    System.out.println("4xx Statuses: ");
    for (Integer code : map4xxStatus.keySet()) {
      System.out.println(code + " => " + map4xxStatus.get(code));
    }
    SortedMap<Integer, String> mapUnder300Status = mapHttpStatus.headMap(300);
    System.out.println("Statuses < 300: ");
    for (Integer code : mapUnder300Status.keySet()) {
      System.out.println(code + " => " + mapUnder300Status.get(code));
    }

    SortedMap<Integer, String> mapAbove500Status = mapHttpStatus.tailMap(500);

    System.out.println("Statuses >= 500");

    for (Integer code : mapAbove500Status.keySet()) {
      System.out.println(code + " => " + mapAbove500Status.get(code));
    }

    Comparator comparator = mapHttpStatus.comparator();
    System.out.println("Sorted by natural ordering? " + (comparator == null));

    SortedMap<Integer, String> mapHttpStatusReserve = new TreeMap<>(new ReverseComparator());
    mapHttpStatusReserve.put(100, "Continue");
    mapHttpStatusReserve.put(200, "OK");
    mapHttpStatusReserve.put(300, "Multiple Choices");

    mapHttpStatusReserve.put(400, "Bad Request");
    mapHttpStatusReserve.put(401, "Unauthorized");
    mapHttpStatusReserve.put(402, "Payment Required");
    mapHttpStatusReserve.put(403, "Forbidden");
    mapHttpStatusReserve.put(404, "Not Found");

    mapHttpStatusReserve.put(500, "Internal Server Error");
    mapHttpStatusReserve.put(501, "Not Implemented");
    mapHttpStatusReserve.put(502, "Bad Gateway");

    System.out.println(mapHttpStatusReserve);

    //    Java 8
    SortedMap<Integer, String> mapHttpStatusReserve1 = new TreeMap<>((i1, i2) -> i2 - i1);
    mapHttpStatusReserve1.put(100, "Continue");
    mapHttpStatusReserve1.put(200, "OK");
    mapHttpStatusReserve1.put(300, "Multiple Choices");

    mapHttpStatusReserve1.put(400, "Bad Request");
    mapHttpStatusReserve1.put(401, "Unauthorized");
    mapHttpStatusReserve1.put(402, "Payment Required");
    mapHttpStatusReserve1.put(403, "Forbidden");
    mapHttpStatusReserve1.put(404, "Not Found");

    mapHttpStatusReserve1.put(500, "Internal Server Eror");
    mapHttpStatusReserve1.put(501, "Not Implemented");
    mapHttpStatusReserve1.put(502, "Bad Gateway");
    System.out.println(mapHttpStatusReserve1);
  }
}

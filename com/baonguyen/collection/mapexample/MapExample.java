package com.baonguyen.collection.mapexample;

import java.util.*;

public class MapExample {
  public static void main(String[] args) {
    //        Map không đưuọc xem là 1 true collection, map interface không extend Collection
    // interface
    //        Map là 1 nhánh độc lập trong Java Collections Framework

    //        map is not a true collection, so its characteristics and behavior are different than
    // the other collections like List or Set
    //        A map cannot contain duplicate keys and each key can map to at most one value. Some
    // implementations allow null key and null value (HashMap and LinkedHashMap) but some does not
    // (TreeMap).
    //        The order of a map depends on specific implementations, eg TreeMap and LinkedHashMap
    // có thứ tự có thể dự đoán được, while HashMap dose not

    //        Why and When Use Maps:
    /**
     * when want to retrieve and update elements by keys, or perform lookups by keys A map of error
     * codes and their description. A map of zip codes and cities. A map of managers and employee.
     * Each manager (key) is associated with a list of employees (value) he manages. A map of
     * classes and students. Each class (key) is associated with a list of students(value) HashMap,
     * LinkedHashMap, TreeMap HashMap: this implementation uses a hash table as the underlying(cơ
     * bản) data structure. It implements all of the Map operations and allows null values and one
     * null key. This class is roughly equivalent to (gần tương đương với) Hashtable HashMap does
     * not guarantee( đảm bảo) the order of its key-value elements. Therefore consider to use a
     * HashMap when order does not matter and nulls are acceptable.
     *
     * <p>LinkedHashMap: this implementation uses a hash table and a linked list as underlying(cơ
     * bản) data structures, thus the order of a LinkedHashMap is predictable, with insertion-order
     * as the default order. This implementation also allows nulls like HashMap. So consider using a
     * LinkedHashMap when you want a Map with its key-value pairs and sorted by their insertion
     * order
     *
     * <p>TreeMap: this implementation uses a red-black tree as the underlying(cơ bản) data
     * structures. A tree map is sorted by according to the natural ordering of its keys, or by
     * Comparator provided at creation time. This implementation does not allow nulls. SO consider
     * using a TreeMap when you want a Map sorts its key - values pairs by natural order of the keys
     * (e.g alphabetic order or numeric order, or by a customer oder you specify.
     */

    /** Creating a new Map */
    Map<Integer, String> mapHttpErrors = new HashMap<>();
    mapHttpErrors.put(400, "Bad Request");
    mapHttpErrors.put(304, "Not Modified");
    mapHttpErrors.put(200, "OK");
    mapHttpErrors.put(301, "Moved Permanently");
    mapHttpErrors.put(500, "Internal Server Error");
    System.out.println(mapHttpErrors);

    String status301 = mapHttpErrors.get(301);
    System.out.println("301: " + status301);

    if (mapHttpErrors.containsKey(200)) {
      System.out.println("Found: " + mapHttpErrors.get(200));
    }

    if (mapHttpErrors.containsValue("OK")) {
      System.out.println("Found status OK ");
    }

    /**
     * return null iff the map doesn't contain mapping for a key return value which the map
     * previously associated the key
     */
    String removedValue = mapHttpErrors.remove(500);
    if (removedValue != null) {
      System.out.println("Removed value: " + removedValue);
    }

    /**
     * the remove(Object key, Object value) method removes the mapping of a specified key and
     * specified value, and returns true if the value was removed. This method is useful in case we
     * really care about the key and value to be removed.
     */
    boolean isRemovedValued2Param = mapHttpErrors.remove(200, "OK");
    if (isRemovedValued2Param) {
      System.out.println("Remove successful. The rest map: " + mapHttpErrors);
    }

    /** Replacing a value associated with a specified key */
    System.out.println("====");
    System.out.println("Map before: " + mapHttpErrors);
    System.out.println("Old valued: " + mapHttpErrors.replace(400, "Change status"));
    System.out.println("Map after:" + mapHttpErrors);

    boolean isReplace = mapHttpErrors.replace(400, "Change status", "New Change status");
    if (isReplace) {
      System.out.println("was replaced value: " + mapHttpErrors);
    }
    System.out.println("====");

    System.out.println("Number of HTTP status code: " + mapHttpErrors.size());
    if (mapHttpErrors.isEmpty()) {
      System.out.println("No Error");
    } else {
      System.out.println("Have HTTP Errors");
    }

    /**
     * Iterating Over a Map (using Collection views)
     *
     * <p>As a Map is not a true collection, there is no direct method for iterating over map.
     * Instead, we can iterate over a map using its collection views. Any map's implementation has
     * to privide the following three Collection view methods:
     *
     * <p>keySet(): return a set view of the keys contained in the map. Hence we can iterate over
     * the keys of the map
     *
     * <p>values(): returns a collection of values contained in the map. Thus we can iterate over
     * values of the map
     *
     * <p>entrySet():returns a Set view of the mappings contained in this map.
     *
     * <p>Unlike the legacy(cổ điển) Hashtable which is synchronized, the HashMap, TreeMap and
     * LinkedHashMap are not synchronized. If thread-safe is priority, consider using
     * ConcurrentHashMap in place of HashMap. Or we can use Collections.synchronizedMap() utility
     * method that returns a synchronized (thread-safe) map backed by the specified map.
     */
    Map<String, String> mapCountryCodes = new TreeMap<>();

    mapCountryCodes.put("1", "USA");
    mapCountryCodes.put("44", "United Kingdom");
    mapCountryCodes.put("33", "France");
    mapCountryCodes.put("81", "Japan");
    Set<String> setCodes = mapCountryCodes.keySet();
    Iterator<String> iterator = setCodes.iterator();

    System.out.println("=========");
    while (iterator.hasNext()) {
      String code = iterator.next();
      String value = mapCountryCodes.get(code);
      System.out.println(code + " => " + value);
    }
    System.out.println("=========");

    System.out.println("=========");
    Collection<String> countries = mapCountryCodes.values();
    for (String country : countries) {
      System.out.println(country);
    }
    System.out.println("=========");

    /**
     * Performing Bulk(hàng loạt) Operations with Maps There are two bulk operations with maps:
     * clear() and putAll();
     */
    mapHttpErrors.clear();
    System.out.println("Is map empty? " + mapHttpErrors.isEmpty());
    System.out.println("=========");

    Map<Integer, String> countryCodesEU = new HashMap<>();
    countryCodesEU.put(44, "United Kingdom");
    countryCodesEU.put(33, "France");
    countryCodesEU.put(49, "Germany");

    Map<Integer, String> countryCodesWorld = new TreeMap<>();

    countryCodesWorld.put(1, "United States");
    countryCodesWorld.put(86, "China");
    countryCodesWorld.put(82, "South Korea");
    System.out.println("Before: " + countryCodesWorld);
    countryCodesWorld.putAll(countryCodesEU);
    System.out.println("After: " + countryCodesWorld);
    System.out.println("=========");
    Set<Map.Entry<String, String>> entries = mapCountryCodes.entrySet();
    for (Map.Entry<String, String> entry : entries) {
      String code = entry.getKey();
      String country = entry.getValue();

      System.out.println(code + " => " + country);
    }
    System.out.println("=========");

    /** Since Java 8 */
    System.out.println("Java 8");
    mapCountryCodes.forEach((code, country) -> System.out.println(code + " => " + country));
    System.out.println("=========");
    /** The map mapErrors is created with initial elements copied from the map mapHttpErrors. */
    Map<Integer, String> mapErrors = new HashMap<>(mapHttpErrors);

    /**
     * Creating a LinkedHashMap: the LinkedHashMap maintains its elements by their insertion order.
     */
    Map<String, String> mapContacts = new LinkedHashMap<>();
    mapContacts.put("0169238175", "Tom");
    mapContacts.put("0904891321", "Peter");
    mapContacts.put("0945678912", "Mary");
    mapContacts.put("0981127421", "John");

    System.out.println(mapContacts);

    /**
     * Creating a TreeMap: The TreeMap sorts its keys by their natural ordering, which is the
     * alphabetical order in this case.
     */
    Map<String, String> mapLang = new TreeMap<>();
    mapLang.put(".xml", "XML");
    mapLang.put(".c", "C");
    mapLang.put(".java", "Java");
    mapLang.put(".pl", "Perl");
    mapLang.put(".cs", "C#");
    mapLang.put(".php", "PHP");
    mapLang.put(".cpp", "C++");

    System.out.println(mapLang);

    /**
     * Concurrent(đồng bộ, đồng thời) Maps remember we have to manually synchronize the map when
     * iterating over any of its collection views If you use a kind of SortedMap, e.g. TreeMap,
     * consider using the more specific method Collections.synchronizedSortedMap().
     */
    Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());
    Set<Integer> keySet = map.keySet();

    synchronized (map) {
      Iterator<Integer> iterator1 = keySet.iterator();

      while (iterator1.hasNext()) {
        Integer key = iterator1.next();
        String value = map.get(key);
      }
    }

    /**
     * NOTE: If you use your ơn type for the key and value (e.g Student or Employee), the key class and value class must implement the euqals() and hashCode() method properly(đúng) so that the map can look up them correctly.
     */
  }
}

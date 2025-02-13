import java.util.*;

class MyHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private List<Entry<K, V>>[] buckets;
    private int size;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        // Suppress warnings related to creating a generic array
        @SuppressWarnings("unchecked")
        List<Entry<K, V>>[] tempBuckets = new List[capacity];
        buckets = tempBuckets;
        size = 0;
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            buckets[index].removeIf(entry -> entry.key.equals(key));
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("candy", 1);
        map.put("chocolate", 2);
        map.put("lollipop", 3);

        System.out.println("Value of candy: " + map.get("candy"));
        System.out.println("Value of chocolate: " + map.get("chocolate"));
        System.out.println("Value of lollipop: " + map.get("lollipop"));

        map.remove("chocolate");

        System.out.println("Value of chocolate after removal: " + map.get("chocolate"));
    }
}

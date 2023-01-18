package com.project.site.base.util;

import java.io.Serializable;
import java.util.*;

public class ListOrderedMap<K, V> extends HashMap<K, V> implements Serializable {
    private List<K> allOrderedKeys;

    public ListOrderedMap() {
        this.allOrderedKeys = new ArrayList();
    }

    public ListOrderedMap(int initialCapacity) {
        super(initialCapacity);
        this.allOrderedKeys = new ArrayList(initialCapacity);
    }

    public ListOrderedMap(ListOrderedMap<? extends K, ? extends V> listOrderedMap) {
        this.allOrderedKeys = new ArrayList();
        this.putAll(listOrderedMap);
    }

    public ListOrderedMap(List<? extends K> keys, List<? extends V> values) {
        this();
        if (keys != null && values != null) {
            if (keys.size() != values.size()) {
                throw new IllegalArgumentException("'keys' size and 'values' size should not be equal.");
            } else {
                for(int i = 0; i < keys.size(); ++i) {
                    this.put(keys.get(i), values.get(i));
                }

            }
        } else {
            throw new IllegalArgumentException("'keys' and 'values' should not be null.");
        }
    }

    public ListOrderedMap(K key, V value) {
        this();
        this.put(key, value);
    }

    public void clear() {
        super.clear();
        this.allOrderedKeys.clear();
    }

    public K getKey(int index) {
        return this.allOrderedKeys.get(index);
    }

    public V getValue(int index) {
        return this.get(this.getKey(index));
    }

    public V put(int index, K key, V value) {
        if (this.allOrderedKeys.contains(key)) {
            this.allOrderedKeys.remove(key);
        }

        this.allOrderedKeys.add(index, key);
        return super.put(key, value);
    }

    public V put(K key, V value) {
        if (!this.allOrderedKeys.contains(key)) {
            this.allOrderedKeys.add(key);
        }

        return super.put(key, value);
    }

    public V putIfAbsent(K key, V value) {
        return !this.containsKey(key) ? this.put(key, value) : this.get(key);
    }

    public List<K> getAllOrderedKeys() {
        return this.allOrderedKeys;
    }

    public boolean putAll(ListOrderedMap<K, V> anotherMap) {
        if (anotherMap == null) {
            return false;
        } else {
            List<K> allKeys = anotherMap.getAllOrderedKeys();
            Iterator var3 = allKeys.iterator();

            while(var3.hasNext()) {
                K key = (K) var3.next();
                this.put(key, anotherMap.get(key));
            }

            return true;
        }
    }

    public int indexOf(K key) {
        return this.allOrderedKeys.indexOf(key);
    }

    public V remove(Object key) {
        this.allOrderedKeys.remove(key);
        return super.remove(key);
    }

    public V removeByIndex(int index) {
        K key = this.getKey(index);
        return this.remove(key);
    }

    public Collection<V> values() {
        List<V> allValues = new ArrayList();
        Iterator var2 = this.allOrderedKeys.iterator();

        while(var2.hasNext()) {
            K k = (K) var2.next();
            allValues.add(this.get(k));
        }

        return allValues;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        if (this.size() > 0) {
            for(int i = 0; i < this.allOrderedKeys.size(); ++i) {
                K key = this.getKey(i);
                V value = this.get(key);
                stringBuilder.append(key != null ? key.toString() : "null").append("=").append(value != null ? value.toString() : "null");
                if (i < this.allOrderedKeys.size() - 1) {
                    stringBuilder.append(", ");
                }
            }
        }

        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public K getKeyByValue(V value) {
        if (value == null) {
            return null;
        } else {
            Iterator var2 = this.allOrderedKeys.iterator();

            Object key;
            do {
                if (!var2.hasNext()) {
                    return null;
                }

                key = var2.next();
            } while(!value.equals(this.get(key)));

            return (K) key;
        }
    }

    public List<K> getKeysByValue(V value) {
        List<K> keys = new ArrayList();
        if (value != null) {
            Iterator var3 = this.allOrderedKeys.iterator();

            while(var3.hasNext()) {
                K key = (K) var3.next();
                if (value.equals(this.get(key))) {
                    keys.add(key);
                }
            }
        }

        return keys;
    }
}
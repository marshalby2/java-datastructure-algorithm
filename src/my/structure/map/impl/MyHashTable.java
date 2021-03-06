package my.structure.map.impl;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author marshal
 * @Date 18/10/20 9:28 PM
 * <p>
 * 参考HashMap代码实现的
 * 关于HashMap原理，可以参考<a>https://zhuanlan.zhihu.com/p/21673805</a>
 */
public class MyHashTable<K, V> {

    /**
     * 默认初始化容量，必须是2的倍数
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    /**
     * 最大容量
     */
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    /**
     * 默认装载因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /* ---------------- Fields -------------- */

    /**
     * 实际数据量
     */
    private int size;

    /**
     * 装载因子
     */
    final float loadFactor;

    /**
     * 阀值
     */
    private int threshold;

    private Node<K, V>[] table;

    static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /* ---------------- Constructor -------------- */


    public MyHashTable(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    public MyHashTable(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashTable() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    /* ---------------- Static utilities -------------- */

    /**
     * 哈希函数
     * 技巧：当length总是2的n次方时，h & (length-1)运算结果等价于对length取模（h % length），但是&比%具有更高的效率。
     *
     * @param key
     * @return
     */
    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16));
    }

    /**
     * 返回2的倍数
     *
     * @param cap
     * @return
     */
    static final int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    public int size() {
        return size;
    }

    /**
     * 新增一个key-value键值对，如果key已存在，key对应的 old value 将会被替new value替换
     *
     * @param key
     * @param value
     * @return 返回old value 或者  null
     */
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    /**
     * put key-value
     *
     * @param hash         hash for key
     * @param key          the key
     * @param value        the value to put
     * @param onlyIfAbsent if true, don't change exiting value
     * @param evict        if false, the table is in creation mode
     * @return previous value, or null if none
     */
    private V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i;

        if ((tab = table) == null || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }

        if ((p = tab[i = (n - 1) & hash]) == null) {
            // 当(n -1) & hash(key)位置为空时，新建一个Node
            tab[i] = new Node<>(hash, key, value, null);
        } else {
            Node<K, V> e;
            K k;
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
                e = p;
            } else {
                while (true) {
                    if ((e = p.next) == null) {
                        p.next = new Node<>(hash, key, value, null);
                        break;
                    }
                    // key-value重复，退出循环
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        break;
                    }
                    // 移动节点
                    p = e;
                }
            }

            // 如果key存在
            if (e != null) {
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null) {
                    // 替换原来的value
                    e.value = value;
                }
                return oldValue;
            }
        }
        // 扩容
        if (++size > threshold) {
            resize();
        }
        return null;
    }


    /**
     * 初始化 & 扩容
     *
     * @return
     */
    private Node<K, V>[] resize() {

        Node<K, V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                    oldCap >= DEFAULT_INITIAL_CAPACITY) { // 扩容为两倍
                newThr = oldThr << 1; // 阀值也增加为原来的两倍
            }
        } else if (oldThr > 0) {
            newCap = oldThr;  // 当调用MyHashTable(int initialCapacity, float loadFactor)方法时
        } else {
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        }

        if (newThr == 0) {
            float ft = (float) newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ?
                    (int) ft : Integer.MAX_VALUE);
        }
        // 给阀值赋值
        threshold = newThr;
        // 初始化数组
        @SuppressWarnings({"unchecked"})
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
        table = newTab;

        // 将原来数组中的数据迁移到新数组中
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K, V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null; // 释放oldTab的对象引用
                    if (e.next == null) { // 说明该链表只有一个节点
                        newTab[e.hash & (newCap - 1)] = e;
                    } else {
                        // 这段代码看的不是很懂
                        Node<K, V> loHead = null, loTail = null;
                        Node<K, V> hiHead = null, hiTail = null;
                        Node<K, V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null) {
                                    loHead = e;
                                } else {
                                    loTail.next = e;
                                }
                                loTail = e;
                            } else {
                                if (hiTail == null) {
                                    hiHead = e;
                                } else {
                                    hiTail.next = e;
                                }
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }


    public V get(Object key) {
        Node<K, V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    final Node<K, V> getNode(int hash, Object key) {
        Node<K, V>[] tab;
        Node<K, V> first, e;
        int n;
        K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
                ((first = tab[(n - 1) & hash]) != null)) {
            if (first.hash == hash &&
                    ((k = first.key) == key || (key != null && key.equals(k)))) {
                return first;
            }
            if ((e = first.next) != null) {
                do {
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k)))) {
                        return e;
                    }
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

}

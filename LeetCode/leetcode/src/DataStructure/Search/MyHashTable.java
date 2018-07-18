package DataStructure.Search;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/7/12.
 */
public class MyHashTable {
    int[] nums;
    int size;

    public MyHashTable(int size) {
        this.size = size;
        nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.MIN_VALUE;
        }
    }

    private int hash(int key){
        return key % size;
    }

    private void insertHash (int key){
        int addr = hash(key);
        while (nums[addr] != Integer.MIN_VALUE){
            addr = (addr + 1) % size;
        }
        nums[addr] = key;
    }

    private boolean searchHash(int key) {
        int addr = hash(key);
        while (nums[addr] != key) {
            addr = (addr + 1) % size;
            //找到空位置还没找到 或者 循环回原点还没找到，就说明关键字不存在
            if (addr == hash(key) || addr == Integer.MIN_VALUE){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyHashTable hash = new MyHashTable(12);
        int[] a = new int[]{12,67,56,16,25,37,22,29,15,47,48};
        for (int i = 0; i < a.length; i++) System.out.printf("%d ",a[i] % 12);
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            hash.insertHash(a[i]);
        }
        System.out.println(Arrays.toString(hash.nums));
        System.out.println(hash.searchHash(48));
        System.out.println(hash.searchHash(66));

    }
}

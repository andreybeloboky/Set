package com.company;

import java.util.Arrays;

public class Set1 implements Set2 {

    private String[] array;
    private int setSize = 0;

    public Set1() {
        this.array = new String[10];
    }

    /**
     * @param size - the size is entered by the user
     */
    public Set1(int size) {
        this.array = new String[size];
    }

    /**
     * @param data - the data is entered by the user;
     */
    @Override
    public void add(String data) {
        if (setSize == array.length) {
            createNewArray();
        }
        array[setSize] = data;
        int equal = 0;
        for (int i = 0; i < setSize; i++) {
            if (contains(array[i])) {
                equal++;
                break;
            }
        }
        if (equal == 1) {
            array[setSize] = null;
            setSize--;
        }
        setSize++;
    }

    /**
     * @param index - who needs remove;
     */
    @Override
    public void remove(int index) {
        for (int i = index; i < setSize; i++) {
            array[index] = array[index + 1];
            index++;
        }
        if (setSize * 2 < array.length) {
            decreaseArray();
        }
        setSize--;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean contains(Object o) {
        return array[setSize].equals(o) && o.hashCode() == array[setSize].hashCode();
    }

    /**
     * @return - number of filled elements;
     */
    @Override
    public int size() {
        return setSize;
    }

    /**
     * @param index - the index to be changed
     * @param data  - the element to be replaced;
     */
    @Override
    public void set(int index, String data) {
        array[index] = data;
    }

    private void createNewArray() {
        String[] temp = array;
        this.array = new String[temp.length * 2];
        System.arraycopy(temp, 0, array, 0, temp.length);
    }

    public void decreaseArray() {
        String[] temp = array;
        this.array = new String[array.length - 10];
        System.arraycopy(temp, 0, array, 0, array.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set1 set1 = (Set1) o;
        return Arrays.equals(array, set1.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    public void print() {
        for (int i = 0; i < setSize; i++) {
            System.out.println(array[i]);
        }
    }
}

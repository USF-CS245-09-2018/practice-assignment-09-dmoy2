import java.util.*;

public class BinaryHeap {
    private int[] array;
    private int size;
    private int max;

    public BinaryHeap() {
        this.size = 0;
        this.max = 10000;
        this.array = new int[max];
    }

    void add(int addingItem){
        array[++size] = addingItem;
        int item = size;

        while(array[item] < array[parent(item)]){
            swap(array, item, parent(item));
            item = parent(item);
        }
    }

    private int parent(int item) {
        return item/2;
    }

    int remove(){
        swap(array, 1, size);
        size--;
        if(size != 0) {
            shiftDown(0);
        }
        return array[size+1];
    }

    void shiftDown(int index){
        int min; 
        if(index == size-1){
            return;
        }
        int child = (index *2) +1;
        if(array[child+1] < array[child]){
            child = child + 1;
        }
        if(array[index] > array[child]){
            swap(array, index, child);
            shiftDown(child);
        }
    }

    void swap(int[] arr, int val1, int val2){
        int temp = arr[val1];
        arr[val1] = arr[val2];
        arr[val2] = temp;
    }
}



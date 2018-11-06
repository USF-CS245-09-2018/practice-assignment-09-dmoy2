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
        size++;
        array[size] = addingItem;
        int item = size;

        while(array[item] < array[parent(item)]){
            swap(item, parent(item));
            item = parent(item);
        }
    }

    int remove(){
        swap(1, size);
        size--;
        if(size != 0) {
            shiftDown(1);
        }
        return array[size+1];
    }

    void shiftDown(int index){
        while(!isLeaf(index)){
            int child = 2 * index;

            if((child < size) && (array[child] > array[child+1])){
                child = child + 1;
            }

            if(array[index] <= array[child]){
                return;
            }
            swap(index, child);
            index = child;
        }
    }

    boolean isLeaf(int index){
        return ((index > size/2) && (index <= size));
    }

    private int parent(int item) {
        return (item/2);
    }

    void swap(int val1, int val2){
        int temp = array[val1];
        array[val1] = array[val2];
        array[val2] = temp;
    }
}



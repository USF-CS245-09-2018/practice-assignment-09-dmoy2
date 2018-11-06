public class BinaryHeap {
    private int[] array;
    private int current;
    private int size;

    public BinaryHeap() {
        this.current = 0;
        this.size = 10;
        this.array = new int[size];
    }

    void add(int element){
        current++;
        if(current >= size){
            int[] temp = new int[size*2];
            for(int i = 0; i < current; i++){
                temp[i] = array[i];
            }
            array = temp;
            size *= 2;
        }
        else {
            array[current] = element;
            int item = current;
            while (array[item] < array[item / 2]) {
                swap(item, item / 2);
                item = item / 2;
            }
        }
    }

    int remove(){
        swap(1, current);
        current--;
        if(current != 0) {
            shiftDown(1);
        }
        return array[current +1];
    }

    void shiftDown(int index){

        if((index > current /2) && (index <= current)){
            return;
        }

        int child = 2 * index;

        if((child < current) && (array[child] > array[child+1])){
            child = child + 1;
        }

        if(array[index] <= array[child]){
            return;
        }
        swap(index, child);
        shiftDown(child);
    }

    void swap(int val1, int val2){
        int temp = array[val1];
        array[val1] = array[val2];
        array[val2] = temp;
    }
}



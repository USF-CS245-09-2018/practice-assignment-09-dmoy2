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
        // increase current counter
        current++;

        // if current is equal to size or greater, then double the size of array
        if(current >= size){
            int[] temp = new int[size*2];
            for(int i = 0; i < current; i++){
                temp[i] = array[i];
            }
            array = temp;
            size *= 2;
        }

        // else, add element to the end of the array
        else {
            array[current] = element;
            int item = current;

            // sort it O(logn) time by changing item to parents each time
            while (array[item] < array[item / 2]) {
                swap(item, item / 2);
                item = item / 2;
            }
        }
    }

    int remove(){
        // remove the first element of array by swapping with the last element to keep tree balanced
        swap(1, current);
        current--;
        if(current != 0) {
            // shift everything down one
            shiftDown(1);
        }
        // return element we removed
        return array[current + 1];
    }

    void shiftDown(int index){

        // if the index element is a leaf exit out of loop
        if((index > current /2) && (index <= current)){
            return;
        }

        // else keep track of child
        int child = 2 * index;

        // sort child to where it needs to be by comparing children and swapping with lesser of children 
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



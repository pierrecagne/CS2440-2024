package collections;

public class Bag { 

    /**
     * data and occs have always the same size
     *
     * data[i] represents an element of the bag with occs[i]
     * occurrences
     *
     * there is no repetition of values among the elements data[i]
     * such that occs[i]>0
     */
    private int[] data;
    private int[] occs;

    /**
     * Creates an empty bag with initial capacity 10
     */
    public Bag () {
        data = new int[10];
        occs = new int[10];
        for (int i = 0 ; i < occs.length ; i++) {
            data[i] = i;
            occs[i] = 0;
        }
    }

    /**
     * Give the size of the bag
     * @return the sum of the cells of occs
     */
    public int size () {
        int size = 0;
        for (int i = 0 ; i < occs.length ; i++) {
            size += occs[i];
        }
        return size;
    }

    /**
     * Add an element to the bag.
     * If the current capacity is not enough, expand the capacity first.
     * @param element element to be added
     */
    public void add (int element) {
        for (int i = 0 ; i < data.length ; i++) {
            if((data[i] == element) && (occs[i] > 0)) {
                occs[i]++;
                return;
            }
        }

        int i = freeSpot();
        if (i < 0) {
            i = data.length;
            ensureCapacity(2*data.length + 1);
        }
        data[i] = element;
        occs[i] = 1;
    }

    /**
     * Set the new capacity of the bag.
     * @param cap the new capacity
     */
    private void ensureCapacity (int cap) {
        int[] newData = new int[cap];
        int[] newOccs = new int[cap];
        for(int i = 0 ; i < data.length ; i++) {
            newData[i] = data[i];
            newOccs[i] = occs[i];
        }
        for(int i = data.length ; i < newData.length ; i++) {
            newData[i] = 0; //not even necessary
            newOccs[i] = 0;
        }
        data = newData;
        occs = newOccs;
    }

    /**
     * Give a free spot in data that is occupied with junk
     * @return the first index i such that occs[i] = 0, or -1 if such an index doesn't exist
     */
    private int freeSpot () {
        for (int i = 0 ; i < occs.length ; i++) {
            if (occs[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove an element from the bag
     * @param target the element to be removed
     * @return false if the lement wasn't found, true otherwise
     */
    public boolean remove (int target) {
        for (int i = 0 ; i < data.length ; i++) {
            if((occs[i] > 0) && (data[i] == target)) {
                occs[i]--;
                return true;
            }
        }
        return false;
    }

    /**
     * Count the number of occurrences oif an element in the bag
     * @param target the element whose number of occurrences is wanted
     * @return the number of occurrences of target in the bag
     */
    public int countOccurrences (int target) {
        for (int i = 0 ; i < data.length ; i++) {
            if ((occs[i] > 0) && (data[i] == target)) {
                return occs[i];
            }
        }
        return 0;
    }

    /**
     * Print the content of the bag
     */
    public void printBag() {
        for (int i = 0 ; i < data.length ; i++) {
            if (occs[i] > 0) {
                for(int j = 0 ; j < occs[i] ; j++) {
                    System.out.print(data[i] + " ");
                }
            }
        }
        System.out.println();
    }

}
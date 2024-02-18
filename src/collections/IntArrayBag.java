package collections;

public class IntArrayBag { 

    //fields
    private int[] data;
    private int manyItems;

    /**
     * Construct an empty bag
     */
    public IntArrayBag () {
        manyItems = 0;
        data = new int[10];
    }

    /**
     * Give the size of the bag
     * @return the value of manyItems
     */
    public int size () {
        return manyItems;
    }

    /**
     * Count the number of occurences of an element in the bag
     * @param target the integer whose number of occurrences is asked
     * @return the number of occurences of target in data[0..manyItems]
     */
    public int countOccurrences (int target) {
        int nbOcc = 0;

        for (int i = 0 ; i < manyItems ; i++) {
            if (data[i] == target) {
                nbOcc++;
            }
        }

        return nbOcc;
    }

    /**
     * Remove one occurence of an element from the bag
     * @param target the element to be removed
     * @return false if target doesn't appear in data[0..manyItems], true otherwise
     */
    public boolean remove (int target) {
        int i = 0;
        while ((data[i] != target) && i < manyItems){
            i++;
        }
        
        if (i == manyItems) { return false; }

        data[i] = data[manyItems - 1];
        manyItems--; 
        return true;
   }

    /**
     * Add an element to the bag
     * @param element the element to be added
     */
    public void add (int element) {
        if (manyItems == data.length) {
            ensureCapacity(2*manyItems+1);
        }
        data[manyItems] = element;
        manyItems++;
    }

    /**
     * Add (!?) an element to the bag
     * @param element the element to be added
     */
    public void wrongadd (int element) {
        data[manyItems] = element;
        manyItems++;
    }

    /**
     * Ensure that the bag is big enough
     * @param newCapacity the new length for data
     */
    private void ensureCapacity (int newCapacity) {
        if(data.length >= newCapacity) return;

        int[] biggerArray = new int[newCapacity];
        for(int i = 0 ; i < manyItems ; i++) {
            biggerArray[i] = data[i];
        }
        data = biggerArray;
    }

    /**
     * Print the content of the bag on the output
     */
    public void printBag() {
        for (int i = 0 ; i < manyItems ; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

}

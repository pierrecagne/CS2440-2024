import collections.Bag;
import collections.IntArrayBag;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bags of integers -- testing");

        Bag poppins = new Bag();
        //IntArrayBag poppins = new IntArrayBag();

        poppins.add(8);
        poppins.add(4);
        poppins.add(8);
        poppins.add(5);
        poppins.add(2440);
        
        poppins.remove(4);
        
        poppins.add(42);

        for (int i = 0 ; i < 10 ; i++) {
            poppins.add(2*i);
        }

        System.out.println(poppins.size());
        System.out.println(poppins.countOccurrences(8));

        poppins.printBag();

    }

}
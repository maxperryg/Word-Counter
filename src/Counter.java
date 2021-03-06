import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

interface Counter<X extends Comparable<X>, Y> {
   int getCount(X word);
   Set<X> keySet();
   void put(X keyWord, Y word);
   String get(X word);
}

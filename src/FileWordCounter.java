import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class FileWordCounter <X extends Comparable<X>, Y> implements Counter<X, Y> {
      
      public String get(X word) {
          ArrayList<String> variations = (ArrayList<String>) map.get(word);
          ArrayList<String> holder = new ArrayList<String>();
          for (String variation : variations){
              if(!holder.contains(variation)){
                  holder.add(variation);
              }
          }
          return "total count " + this.getCount(word) +", " +holder.toString().substring(1, holder.toString().length()-1);
      }

      public int getCount(X word) {
          ArrayList<String> current = (ArrayList<String>) map.get(word);
          return current.size();
      }

      public Set<X> keySet() {
          return map.keySet();
      }

      public void put(X keyWord, Y word) {
          if(!map.containsKey(keyWord)){
              ArrayList<String> wordsHolder = new ArrayList<String>();
              wordsHolder.add(word.toString());
              map.put(keyWord, wordsHolder);
          }
          else{
              ArrayList<String> current = (ArrayList<String>) map.get(keyWord);
              current.add((String) word);
              map.put(keyWord, current);
          }   
      }
      
      HashMap map = new HashMap<X,ArrayList<String>>();
      

      // declare any required instance variables or helpful auxiliary types and methods here
}

// -------  cut here.  Place your new code above this line and submit only the ------
// -------  code above this line as your homework.  Do not make any code changes ----
// -------  below this line.                                                ---------


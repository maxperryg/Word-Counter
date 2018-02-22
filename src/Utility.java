import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

class Utility {
    
    public static void main(String args[]) throws FileNotFoundException {
       Counter<String, String> x = new FileWordCounter <String, String>();
       Utility.run(x);
    }
    
   public static void run(Counter<String, String> words) throws FileNotFoundException{
      //Scanner terminal = new Scanner(System.in);
      //System.out.println("Give the name of a file for analysis:");
      //String fileName = terminal.next();
       int status;
       JFileChooser chooser = new JFileChooser( );
       status = chooser.showOpenDialog(null);
       String chosenFileName = chooser.getSelectedFile().getAbsolutePath();
       Scanner input = new Scanner(new File(chosenFileName));
       input.useDelimiter("\\W+");

      while (input.hasNext()) {
         String word = input.next();
         String keyWord = Utility.dropS(word);
         words.put(keyWord, word);
      }

      for (String word : words.keySet())
          System.out.println(word +":\t" + words.get(word));

      input.close();
   }
   
   static String dropS(String word) {
      String ans = word.toLowerCase();
      if (ans.endsWith("s"))
         return ans.substring(0, ans.length() - 1);
      return ans;
   }
}
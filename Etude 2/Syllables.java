/**
 * @Author James Walmsley 8358979, Kyle Goucher 8080806
 * @Author Tommy Chen 5277929
 */

import java.util.*;
import java.io.*;

public class Syllables{
  
  private static Scanner scan;
  private static String input;
  private static ArrayList<String> output;
  private static ArrayList<String> lines;
  /**
   * Recursively finds amount of vowels in param
   * @param String word 
   */
  public int findVowel(String word){
    if(word.equals(null)){
      return 0;
    }
    int wLen = word.length();
    char wChar;
    for(int i =0; i<wLen; i++){
      wChar = word.charAt(i);
      wChar =Character.toLowerCase(wChar);
      switch(wChar){
        case 'a': case 'e': case 'u': case 'i': case 'o': case 'y': 
          return 1+findNVowel(word.substring(i+1));
      }
    }
    return 0;
  }
  /**checks for double vowels
    * @param String word
    */
  public int findNVowel(String word){
    if(word.equals(null)){
      return 0;
    }
    int wLen = word.length();
    char wChar;
    for(int i =0; i<wLen; i++){
      wChar = word.charAt(i);
      wChar =Character.toLowerCase(wChar);
      switch(wChar){
        case 'a': case 'e': case 'u': case 'i': case 'o': case 'y': 
          break;
        default:
          return findVowel(word.substring(i+1));
      }
    }
    return 0;
  }
  /**
   * checks our added rules then counts vowels recursively
   * @param String word
   */
  public int sCount(String word){
    if(word.equals(null)){
      return 0;
    }
    int wLen = word.length(); 
    if(wLen>2){
      if((word.substring(wLen-1)).equals("e")){
        if((word.substring(wLen-2)).equals("le")){
          char wChar;
          wChar = word.charAt(wLen-3);
          switch(wChar){
            case 'a': case 'e': case 'u': case 'i': case 'o': case 'y':
              return findVowel(word)-1;
            default:
              break;
          }
        }else{
          return findVowel(word)-1;
        }
      }
    }
    return findVowel(word);
  }
  /* main method which gets the input and then displays output
   * @param unused
   */
  public static void main(String args[]) throws IOException{
    Syllables s = new Syllables();
    scan = new Scanner(System.in);
    output = new ArrayList<String>();
    lines = new ArrayList<String>();
    int count = 0;
    int vcount = 0;
    try{
      while ((input = scan.nextLine()) != null) {
        lines.add(count, input);
        vcount = s.sCount(input);
        if(vcount ==0){
          vcount ++;
        }
        output.add(count, Integer.toString(vcount));
        
        count++;
      }
    }catch(NoSuchElementException e){
      for (int i = 0; i < lines.size(); i++){
        System.out.println(output.get  (i));
      }
    }
    return;
  }
}

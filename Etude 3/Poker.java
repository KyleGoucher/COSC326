/**
 *@Author Kyle Goucher 8080806
 * Poker hand sorter which checks to make sure invalid hand
 * then prints out sorted hand in order
 */
import java.util.*;
import java.lang.*;
public class Poker {
  /**
   * main application class for program
   *@param args unused
   */
  private static final List<String> valid = Arrays.asList("13","12","11","10","9","8","7",
                                                        "6","5","4","3","2","1","C","D", "H","S","A","K","Q","J","T");  
  public static void main(String[] args){ 
    final  String SUIT ="CDHS";
    String[] splitter = new String[5];
    String[] checker = new String[] {" ", "-", "/"};
    Scanner scan = new Scanner(System.in);
    String input;
    int count;
    boolean invalid;
    //takes in line and splits into array
    try{
      while ((input = scan.nextLine()) != null) {
        count = 0;
        invalid = false;
        int pos1=0;
        int low = input.length()-1; 
        for(int i = 0; i < checker.length; i++){
          pos1 = input.indexOf(checker[i]);
          
          if(pos1 < low  && pos1 > 0){
            low = pos1;
          }
        }
        for( String spl: input.split(Character.toString(input.charAt(low)))){
          if(count <= 4){
            splitter[count] = spl.toUpperCase();
            count++;
          }
          else{
            invalid = true;
          }
        }
        for(int i = 0; i <count ;i++){
          splitter[i] = splitter[i].replaceAll("13", "K");
          splitter[i] = splitter[i].replaceAll("12","Q");
          splitter[i] = splitter[i].replaceAll("11","J");
          splitter[i] = splitter[i].replaceAll("T", "10");
          if(splitter[i].length() ==2){
            splitter[i] = splitter[i].replaceAll("1","A");
          }
        }
        if(count ==5){
          int i = 0;
          for(i = 0; i < 5; i++){
            if(invalid == true){
              
            }
            else{  
              int wlen =splitter[i].length();
              if(wlen ==2){
                if((valid.indexOf(splitter[i].substring(0,1)) == -1) ||
                   (valid.indexOf(splitter[i].substring(1,2)) == -1)){  
                  
                  invalid = true;
                }
              }
              else if(wlen == 3){
                if((valid.indexOf(splitter[i].substring(0,2)) == -1) ||
                   (valid.indexOf(splitter[i].substring(2,3)) == -1)){
                  
                  invalid = true;  
                }
              }
            }      
          }
        }      
        else if(count != 5){
          invalid = true;
        }
        if(invalid ==true){
          System.out.println("Invalid: " + input); 
        }
        else{
          Arrays.sort(splitter, new Comparator<String>(){   
            @Override
            public int compare(String s1, String s2){ 
              StringBuilder add1 = new StringBuilder();
              StringBuilder add2 = new StringBuilder();
              int c1 = (int) s1.charAt(0);
              int c2 = (int) s2.charAt(0);
              if(Character.isDigit(s1.charAt(1))){   
                add1.append(s1.charAt(0));
                add1.append(s1.charAt(1));
                c1 = Integer.parseInt(add1.toString());
              } 
              if(Character.isDigit(s2.charAt(1))){   
                add2.append(s2.charAt(0));
                add2.append(s2.charAt(1));
                c2 = Integer.parseInt(add2.toString()); 
              }     
              char c3 = s1.charAt(s1.length()-1);
              char c4 = s2.charAt(s2.length()-1);  
              if (c1 == 49) c1 = 65; //changes the value of 1
              if (c2 == 49) c2 = 65;
              if (c1 == 75) c1 = 61; //changes the value of K
              if (c2 == 75) c2 = 61;
              if (c1 == 81) c1 = 60; //changes the value of Q
              if (c2 == 81) c2 = 60; 
              if (c1 == 74) c1 = 59; //changes the value of J
              if (c2 == 74) c2 = 59;
              if (c1 == 84) c1 = 58; //changes the value of T
              if (c2 == 84) c2 = 58;
              if (c1 == 10) c1 = 58; //changes the value of 10
              if (c2 == 10) c2 = 58;   
              //if values are equal it then decides off suit.
              if(c1-c2 == 0){
                return SUIT.indexOf(c3)- SUIT.indexOf(c4);
              }
              else{
                return c1 - c2;       
              }
            }  
          });
          StringBuilder print = new StringBuilder();
          for(String card :splitter){
            print.append(card + " ");
            
          }
          System.out.println(print.toString().substring(0,print.length()-1));  
        }
      }
    }
    catch(NoSuchElementException e){     
    }
  }
}

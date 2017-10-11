/**
 * RedGreen based on near factors of the current number.
 * A positive integer n > 1, n is red if more of its near factors are green than are red.
 * Otherwise, it is green.
 * @Author  Kyle Goucher 8080806
 */

import java.util.*;
import java.io.*;
import java.lang.*;

public class RedGreen{
  private  static HashMap<Integer,String> hm = new HashMap<Integer,String>();
  
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    Scanner sc;

        

        try{
            while(scan.hasNextLine()){
                String inputs = scan.nextLine();
                sc = new Scanner(inputs);
                if(!inputs.isEmpty() &&  inputs.charAt(0) != '#'){
                    int input[] = new int[2];
                    for(int i = 0 ; i < 2; i++){
                        input[i] = sc.nextInt();
                    }
                    printer(input);
                }
            }
        }catch(NoSuchElementException e){
        }
    }

    public static void printer(int input[]){

        List<Integer> nearfactors = new ArrayList<Integer>();
        StringBuilder output = new StringBuilder();
        int green, red;
        hm.put(1, "Green");
        for(int i = 2 ; i <=(input[0] + input[1] -1);  i++){
            output.setLength(0);
            nearfactors.clear();
            green = 0;
            red = 0;
            if(!hm.containsKey(i)){
              for(int j = 2 ; j <= i ; j++){
                int nf = i/j;
                if(!nearfactors.contains(nf)){
                        nearfactors.add(nf);
                    }
                }
            }
                for(int j : nearfactors){
                    if(hm.get(j).equals("Red")){
                        red++;      
                    }else if (hm.get(j).equals("Green")){
                        green++;
                    }
                }
                if(green > red){
                    hm.put(i, "Red");
                }else{
                    hm.put(i, "Green");
                }
            }
        for(int i = input[0] ; i <=(input[0] + input[1] -1); i++){
            if(hm.get(i) .equals("Red")){
                output.append("R");
            } else{
                output.append("G");
            }
        }
        System.out.println( input[0] + " " + input[1]);
        System.out.println("# " +output);

    }
     
}



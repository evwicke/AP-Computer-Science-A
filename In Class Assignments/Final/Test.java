import java.util.*;
public class Test{
    
    public static void main(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("What word do u want");
        String word = scanner.nextLine();
        
        for(int i = 1; i <= word.length(); i++){
            System.out.print(i + " : ");
            System.out.println(wordScrambler(i, word));
        }
    }
    public static String wordScrambler(int steps, String word){
        String[] split = word.split("");
        ArrayList<String> splitList = new ArrayList<String>();
        for(String c : split){splitList.add(c);}

        for(int i = 0; i < steps; i++){
            splitList.add((int)(Math.random()*word.length() -1), splitList.remove(i));
        }
        
        String fin = "";
        for(String c : splitList){fin +=c.toLowerCase();};
        return fin;
    }
}
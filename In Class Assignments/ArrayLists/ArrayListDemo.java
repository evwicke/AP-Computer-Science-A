import java.util.*;
public class ArrayListDemo{
    public static void Main(){
        ArrayList<String> classmates = new ArrayList<String>();
        
        System.out.println(classmates);
        
        classmates.add("Adrian");
        classmates.add("Ryan");
        classmates.add("Sleepy Yash");
        classmates.add("Nikhil");
        classmates.add("Jason");
        
        System.out.println(classmates);
        System.out.println("Size: "+ classmates.size());
        
        classmates.add(2,"Amanda");
        System.out.println(classmates);
        
        int counter = 0;
        for(String x : classmates){
            System.out.println(x + " #" + (counter+1));
            counter++;
        }
    }
}

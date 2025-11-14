package src.Circle;

/*** CircleClient
*      Start here with creating the idea 
*      of multiple circles and the need 
*      to reuse code
* 
* @dlynch1
* @Nov
*/

public class CircleClient
{
    public static void Main(String[] args){
        Circle circle1 = new Circle();
        
        
        
        
        
        
        Circle jason = new Circle();
        Circle yash = new Circle(6);
        Circle amanda = new Circle("tong", 8);
        
        System.out.println(jason);
        jason.setRadius(13);
        System.out.println(jason);
    }
}
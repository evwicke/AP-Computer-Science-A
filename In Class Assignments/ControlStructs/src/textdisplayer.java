package src;


/**
 * Write a description of class textdisplayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class textdisplayer
{
    public static void main(String[] args){
        TextFormatter texty = new TextFormatter("aabaccb");
        System.out.println(texty.findString("a",0));
        System.out.println(texty.findString("b",4));
        System.out.println(texty.findString("c",0));
        
    }
}

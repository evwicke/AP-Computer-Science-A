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
        
        System.out.println("-----");
        TextFormatter texty2 = new TextFormatter("_This_ is _very_ _good_.");
        System.out.println(texty2.countStrings("_"));
        TextFormatter texty3 = new TextFormatter("This is ___ very _good_.");
        System.out.println(texty3.countStrings("_"));
        
        System.out.println("-----");
        System.out.println(texty2.convertItalics());
        System.out.println(texty3.convertItalics());
    }
}

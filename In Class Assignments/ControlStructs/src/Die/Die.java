package src.Die;


/**
 * review classes
 * 
 * @evwicke
 * @11/17/25
 */
public class Die{
    
    private int sideCount;
    private int currentSide;
    
    public Die(){
        sideCount = 6;
    }

    public Die(int sideCount){
        this.sideCount = sideCount;
    }
    
    public int getCurrentSide(){
        return currentSide;
    }
    
    public void roll(){
        currentSide = ((int)(Math.random()*sideCount))+1;
    }
    
    
    //tostring
    public String toString(){
        return "The current side is :  " +currentSide;
    }
    
}

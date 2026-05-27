
public class WordBank{
    private String[] wordListTwo = {"Acknowledge", "Architectural", "Background",
        "Bioinformatics", "Capabilities", "Celebration",
        "Characteristics", "Collaboration", "Cryptocurrency",
        "Cybersecurity", "Development", "Discipline", "Documentation",
        "Environment", "Experimental", "Fluctuation", "Foundations",
        "Generative", "Hierarchical", "Infrastructure", "Intelligence",
        "Maintenance", "Microservices", "Optimization", "Performance",
        "Programming", "Relationships", "Specialized", "Sustainable", "Terminology"};
        
    private String[] wordList = { 
        "Apple", "Chair", "Table", "House", "Mouse", 
        "Water", "Clock", "Light", "Bread", "Train", 
        "Smile", "River", "Stone", "Dream", "Heart", 
        "Space", "Plane", "Plant", "Banana", "Planet", 
        "Garden", "Screen", "Bottle", "Window", "Shadow", 
        "Butter", "Bridge", "Friend", "Forest", "Rocket" };
    
    public WordBank(){}
    public String getWord(String s){
        if(s.equals("easy")){return wordList[(int)(Math.random()*wordList.length)];}
        if(s.equals("hard")){return wordListTwo[(int)(Math.random()*wordListTwo.length)];}
        return "";
    }
}

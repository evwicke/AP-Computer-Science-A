package src;

public class TextFormatter{
    private String line;  // The line to format
    public TextFormatter(String lineToFormat)
    {
        line = lineToFormat;
    }
    
    public int findString(String str, int start){
        char target = str.charAt(0);
        for (int i = start; i < line.length(); i++) {
            if (line.charAt(i) == target) {
                boolean isConsecutiveBefore = (i > 0 && line.charAt(i - 1) == target);
                boolean isConsecutiveAfter = (i < line.length() - 1 && line.charAt(i + 1) == target);
                if (!isConsecutiveBefore && !isConsecutiveAfter) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public int countStrings(String str)
    {
        return -1;
    }

    public String convertItalics()
    {
        return "";
    }
}
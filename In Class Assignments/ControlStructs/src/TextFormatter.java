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

    public int countStrings(String str) {
        int count = 0;
        int recentFindIndex = 0;
        while (recentFindIndex < line.length()) {
            recentFindIndex = findString(str, recentFindIndex);
            if (recentFindIndex == -1) {
                break; // No more matches found, exit the loop
            }
            count++;
            recentFindIndex++;
        }
        return count;
    }

    public String convertItalics() {
        if( countSimple("_") % 2 == 1 ){
            return line;
        }

        String[] letters = line.split("");
        int oscillator = 1;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i].equals("_")) {
                if (oscillator == 1) {
                    letters[i] = "<I>"; 
                    oscillator *= -1;
                } 
                else if (oscillator == -1) {
                    letters[i] = "</I>";
                    oscillator *= -1;
                }
            }
        }

        String returner = "";
        for (String u : letters) {
            returner += u;
        }

        return returner;
    }

    public int countSimple(String str) {
        int count = 0;
        for (int i = 0; i <= line.length() - str.length(); i++) {
            if (line.substring(i, i + str.length()).equals(str)) {
                count++;
            }
        }
        return count;
    }
}
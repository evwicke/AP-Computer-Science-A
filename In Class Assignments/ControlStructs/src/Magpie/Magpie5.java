package src.Magpie;

public class Magpie5
{
    // modify this method to create an array of random responses
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        int whichResponse = (int)(Math.random() * NUMBER_OF_RESPONSES);
        String[] responses = {"Interesting."	,"Okay." 	,"I haven’t heard that before."	,"What else could you tell me about that?"	,"Where did you hear that?"	,"Please, go on."};

        String response = responses[whichResponse];

        return response;
    }

    private String transformIDontLikeStatement(String statement)
    {
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int position = findPhrase (statement, "I dislike", 0);
        String restOfStatement = statement.substring(position + 12);
        return "You said, 'I dislike" + restOfStatement + 
        "'? What don't you like about it?";
    }

    /**
     * Take a statement with "I want ." and transform it 
     * into "I would like , too!"
     * @param statement the user statement, assumed to contain 
     *            "I want"
     * @return the transformed statement
     */
    private String transformIWantStatement(String statement)
    {
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int position = findPhrase (statement, "I want", 0);
        String restOfStatement = statement.substring(position + 6);
        return "I would like" + restOfStatement + ", too!";
    }

    /**
     * Take a statement with "Would you like to  with me?" 
     * and transform it into 
     * "When would you like me to  with you?"
     * @param statement the user statement, assumed to contain "Would 
     *            you like to" and "with me"
     * @return the transformed statement
     */
    private String transformWouldYouLikeStatement(String statement)
    {
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("?"))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int position = findPhrase (statement, "Would you like ", 0);
        String restOfStatement = statement.substring(position + 15);
        position = findPhrase(restOfStatement, "with me", 0);
        restOfStatement = restOfStatement.substring(0, position);
        return "When would you like me" + restOfStatement + " with you?";
    }

    /**
     * Gives a response to a user statement
     * @param statement the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String names = "Abby,Chinma,Jill,Kim,Marcus,Margaret,Rob,Tom,Travis";
        final int NUMBER_OF_RESPONSES = 9;
        String[] namesArr = names.split(",");
        int whichResponse = (int)(Math.random() * NUMBER_OF_RESPONSES);
        String response = "";
        if(findPhrase(statement, "Mrs. Klipp", 0) != -1){
            response = "Oh, you're in Mrs. Klipp's class! Do you know " + namesArr[whichResponse] + "?";
        }
        return response;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the
     *            search at
     * @return the index of the first occurrence of goal in
     *            statement or -1 if it's not found
     */
    private int findPhrase(String statement, String goal, int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        // The only change to incorporate the startPos is in
        // the line below
        int position = phrase.indexOf(goal, startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (position >= 0)
        {
            // Find the string of length 1 before and after
            // the word
            String before = " ", after = " ";
            if (position > 0)
            {
                before = phrase.substring(position - 1, position);
            }
            if (position + goal.length() < phrase.length())
            {
                after = phrase.substring(position + goal.length(), position + goal.length() + 1);
            }

            // If before and after aren't letters, we've
            // found the word
            if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) // before is not a letter
            && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
            {
                return position;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            position = phrase.indexOf(goal, position + 1);
        }
        return -1;
    }

    /**
     * Get a default greeting    
     * @return a greeting
     */  
    public String getGreeting()
    {
        return "Hello, let's talk. Type in \"Bye\" to end our chat";
    }   
}
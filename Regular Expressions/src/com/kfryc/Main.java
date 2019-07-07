package com.kfryc;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	    String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I am", "You are");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".","Y"));    //"." matches any character
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));  //"^" checks the start of the string

        String secondString = "abcDeeeF12GhhabcDeeeiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDeee"));    // the string as a whole has to match, not just part
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiijkl99z"));

        System.out.println(alphanumeric.replaceAll("jkl99z$", "The end")); // "$" checks the end of the string
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));   // [aei] - all a, e and i will be
                                                                                    // effected. every character
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));
        // a,e or i and F or j are replaced

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));
        System.out.println(alphanumeric.replaceAll("[^ej]","X"));
        // [^ej] will match everything apart from e and j

        System.out.println(alphanumeric.replaceAll("[a-fA-F3-8]","X")); //- shows range it is case sensitive
        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]","X")); //(?i) is for case sensitive

        System.out.println(alphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(alphanumeric.replaceAll("\\d", "X")); // \\d will pick digits same as above
        System.out.println(alphanumeric.replaceAll("\\D", "X")); // \\D will pick non-digits

        String hasWhiteSpace = "I have blanks and \ta tab and also a newline\n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s","")); // \\s will pick all spaces, tabs and new lines
        System.out.println(hasWhiteSpace.replaceAll("\t", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\S","")); // \\S picks all non white spaces

        System.out.println(hasWhiteSpace.replaceAll("\\w", "X")); // \\w picks characters A-Z, 0-9 and _
        System.out.println(hasWhiteSpace.replaceAll("\\W", "X")); // \\W picks everything else than \\w

        System.out.println(hasWhiteSpace.replaceAll("\\b", "X"));   // \\b will be at the beginning and end of the sentence

        System.out.println(alphanumeric.replaceAll("^abcDe{3}", "YYY"));   // {3} the number of preceding character that has to match
        System.out.println(alphanumeric.replaceAll("^abcDe+", "YYY"));     // + one or more number of preceding character
        System.out.println(alphanumeric.replaceAll("^abcDe*", "YYY"));     // * any number of preceding character
        System.out.println(alphanumeric.replaceAll("^abcDe{2,5}", "YYY")); // between 2 and 5 characters of e
        System.out.println(alphanumeric.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something</p>");
        htmlText.append("<p>This is another paragraph about something else</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary</p>");

        // For the upper case
        // String h2Pattern = ".*<h2>.*";      // .* - anything
        // For the matcher.find() case
        String h2Pattern = "<h2>";      // .* - anything
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while (matcher.find()){
            count++;
            System.out.println("Occurence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";       //without "?" it will be a greedy quantifier and will find the longest string
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        groupMatcher.reset();
        while (groupMatcher.find()){
            System.out.println("Occurence: " + groupMatcher.group(1));
        }
        System.out.println("---------");

        String h2TextGroups = "(<h2>)(.+?)(</h2)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find()){
            System.out.println("Occurence: " + h2TextMatcher.group(2)); //looking for the text between <h2> </h2> tags
        }

        String tvTest = "tstvtkt";
        // String tNotVRegExp = "t[^v]";       //match everything with t, apart from v (there must be a character after t)
        String tNotVRegExp = "t(?!v)";         //match everyting with t, apart from v (even without character after!)
        // t(?=v) // match everything with t, with v as a next character, but not needed

        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        System.out.println("---------");

        count = 0;
        while (tNotVMatcher.find()){
            count++;
            System.out.println("Occurence: " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        System.out.println("---------");

        // American phone number validation
        // ^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"
        String phone1 = "1234567890";       // Shouldn't match
        String phone2 = "(123) 456-7890";   // Should match
        String phone3 = "123 456-7890";     // Shouldn't match
        String phone4 = "(123)456-7890";     // Shouldn't match (no blank)

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));


        System.out.println("---------");

        // Validating Visa number
        // ^4[0-9]{12}([0-9]{3})?$
        String visa1 = "4444444444444";     //should match
        String visa2 = "5444444444444";     //shouldn't match
        String visa3 = "4444444444444444";  //should match
        String visa4 = "4444";              //shouldn't match


        System.out.println("visa1 = " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 = " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 = " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 = " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));

    }
}

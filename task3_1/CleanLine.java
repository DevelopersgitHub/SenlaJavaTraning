package task3_1;

public class CleanLine {
public static String cleanedLine(String line) {
        
        line = line.replaceAll("\\p{Punct}", "");        
        line = line.replaceAll("[0-9]", "");                    
        return line;
    }

}

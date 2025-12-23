<<<<<<< HEAD:src/main/java/com/example/FrequencyAnalyzer.java
package com.example;

public class FrequencyAnalyzer {
}
=======
package com;
import java.util.Map;
import java.util.HashMap;

public class FrequencyAnalyzer {

    public static Map<Character, Integer> countFrequency(String text){

        Map<Character, Integer> frequencies = new HashMap<>();

        for(char c : text.toCharArray()){
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        return frequencies;
    }
}
>>>>>>> origin/lyrach_branch:src/main/java/com/FrequencyAnalyzer.java

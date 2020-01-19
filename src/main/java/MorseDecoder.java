
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MorseDecoder {
    public static final String WORD_DELIMITER = "   ";
    public static final String CHAR_DELIMITER = " ";
    Map<String, String> MorseCode;

    public MorseDecoder() {
        initMap();
    }

    private void initMap() {
        MorseCode = new HashMap<String, String>();
        MorseCode.put(".-", "a");
        MorseCode.put("-...", "b");
        MorseCode.put("-.-.", "c");
        MorseCode.put("-..", "d");
        MorseCode.put(".", "e");
        MorseCode.put("..-.", "f");
        MorseCode.put("--.-", "g");
        MorseCode.put("....", "h");
        MorseCode.put("..", "i");
        MorseCode.put(".---", "j");
        MorseCode.put("-.-", "k");
        MorseCode.put(".-..", "l");
        MorseCode.put("--", "m");
        MorseCode.put("-.", "n");
        MorseCode.put("---", "o");
        MorseCode.put(".--.", "p");
        MorseCode.put("--.-", "q");
        MorseCode.put(".-.", "r");
        MorseCode.put("...", "s");
        MorseCode.put("-", "t");
        MorseCode.put("..-", "u");
        MorseCode.put("...-", "v");
        MorseCode.put(".--", "w");
        MorseCode.put("-..-", "x");
        MorseCode.put("-.--", "y");
        MorseCode.put("--..", "z");
    }

    public String decode(String morseCode) {
        if (morseCode.length() == 0)
            return "";
        return Arrays.stream(splitStringBy(morseCode.trim(), WORD_DELIMITER))
                .map(this::decodeMorseWord)
                .collect(Collectors.joining(" "));
    }

    private String decodeMorseWord(String phrase) {
        return Arrays.stream(splitStringBy(phrase, CHAR_DELIMITER))
                .map(this::getLetterFromMorse)
                .collect(Collectors.joining());
    }

    private String[] splitStringBy(String string, String delimiter) {
        return string.split(delimiter);
    }

    private String getLetterFromMorse(String character) {
        try {
            return MorseCode.get(character).toUpperCase();
        } catch (Exception e) {
            return "";
        }

    }
}
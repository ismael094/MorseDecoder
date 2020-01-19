
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
        MorseCode.put(".-", "A");
        MorseCode.put("-...", "B");
        MorseCode.put("-.-.", "C");
        MorseCode.put("-..", "D");
        MorseCode.put(".", "E");
        MorseCode.put("..-.", "F");
        MorseCode.put("--.-", "G");
        MorseCode.put("....", "H");
        MorseCode.put("..", "I");
        MorseCode.put(".---", "J");
        MorseCode.put("-.-", "K");
        MorseCode.put(".-..", "L");
        MorseCode.put("--", "M");
        MorseCode.put("-.", "N");
        MorseCode.put("---", "O");
        MorseCode.put(".--.", "P");
        MorseCode.put("--.-", "Q");
        MorseCode.put(".-.", "R");
        MorseCode.put("...", "S");
        MorseCode.put("-", "T");
        MorseCode.put("..-", "U");
        MorseCode.put("...-", "V");
        MorseCode.put(".--", "W");
        MorseCode.put("-..-", "X");
        MorseCode.put("-.--", "Y");
        MorseCode.put("--..", "Z");
    }

    public String decode(String morseCode) {
        if (morseCode.length() == 0)
            return "";
        return Arrays.stream(splitStringBy(morseCode.trim(), WORD_DELIMITER))
                .map(this::decodeMorseWord)
                .collect(Collectors.joining(" "));
    }

    private String decodeMorseWord(String word) {
        return Arrays.stream(splitStringBy(word, CHAR_DELIMITER))
                .map(MorseCode::get)
                .collect(Collectors.joining());
    }

    private String[] splitStringBy(String string, String delimiter) {
        return string.split(delimiter);
    }

}
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MorseDecoder {
    private Map<String,String> MorseCode;

    @Before
    public void initMap() {
        MorseCode = new HashMap<>();
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

    @Test
    public void decode_an_empty_string_should_return_empty() {
        assertThat(decode("")).isEqualTo("");
    }

    @Test
    public void decode_an_point_string_should_return_letter_E() {
        assertThat(decode(".")).isEqualTo("E");
    }

    @Test
    public void decode_four_point_string_should_return_letter_H() {
        assertThat(decode("....")).isEqualTo("H");
    }

    private String decode(String phrase) {
        if (phrase.length() == 0)
            return "";
        return "E";
    }
}

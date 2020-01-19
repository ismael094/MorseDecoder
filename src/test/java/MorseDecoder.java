import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
    public void decode_a_point_string_should_return_letter_E() {
        assertThat(decode(".")).isEqualTo("E");
    }

    @Test
    public void decode_four_point_string_should_return_letter_H() {
        assertThat(decode("....")).isEqualTo("H");
    }

    @Test
    public void decode_four_point_and_a_point_string_should_return_HE() {
        assertThat(decode(".... .")).isEqualTo("HE");
    }

    @Test
    public void decode_four_point_and_space_and_a_point_string_should_return_H_space_E() {
        assertThat(decode("....   .")).isEqualTo("H E");
    }

    private String decode(String phrase) {
        if (phrase.length() == 0)
            return "";
        return Arrays.stream(stringSplitBy(phrase,"   "))
                .map(this::decodeWord)
                .collect(Collectors.joining(" "));
    }

    private String decodeWord(String phrase) {
        return Arrays.stream(stringSplitBy(phrase," "))
                .map(this::getLetterFromMorse)
                .collect(Collectors.joining(""));
    }

    private String[] stringSplitBy(String phrase, String delimiter) {
        return phrase.split(delimiter);
    }

    private String getLetterFromMorse(String character) {
        return MorseCode.get(character).toUpperCase();
    }
}

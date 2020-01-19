import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MorseDecoder_ {
    private final MorseDecoder morseDecoder = new MorseDecoder();

    @Test
    public void decode_an_empty_string_should_return_empty() {
        assertThat(morseDecoder.decode("")).isEqualTo("");
    }

    @Test
    public void decode_a_point_string_should_return_letter_E() {
        assertThat(morseDecoder.decode(".")).isEqualTo("E");
    }

    @Test
    public void decode_four_point_string_should_return_letter_H() {
        assertThat(morseDecoder.decode("....")).isEqualTo("H");
    }

    @Test
    public void decode_four_point_and_a_point_string_should_return_HE() {
        assertThat(morseDecoder.decode(".... .")).isEqualTo("HE");
    }

    @Test
    public void decode_four_point_and_space_and_a_point_string_should_return_H_space_E() {
        assertThat(morseDecoder.decode(".... . -.--   .--- ..- -.. .")).isEqualTo("HEY JUDE");
    }
}

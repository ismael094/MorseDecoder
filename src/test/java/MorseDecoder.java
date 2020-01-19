import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MorseDecoder {
    @Test
    public void decode_an_empty_string_should_return_empty() {
        assertThat(decode("")).isEqualTo("");
    }

    @Test
    public void decode_an_point_string_should_return_letter_E() {
        assertThat(decode(".")).isEqualTo("E");
    }

    private String decode(String phrase) {
        return "";
    }
}

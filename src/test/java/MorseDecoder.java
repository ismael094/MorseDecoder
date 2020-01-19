import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MorseDecoder {
    @Test
    public void order_an_empty_string_should_return_empty() {
        assertThat(decode("")).isEqualTo("");
    }

    private String decode(String phrase) {
        return null;
    }
}

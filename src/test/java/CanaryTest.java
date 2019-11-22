import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static java.lang.String.join;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CanaryTest {
    @Test
    public void should_be_able_to_run_a_trivial_test_case() {
        assertThat(1 + 2, is(3));
    }

    @Test
    public void should_be_able_to_use_guava_capabilities() throws IOException {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        List<Integer> doubled = numbers.stream().map(x -> x * 2).collect(toList());
        assertThat(doubled, is(asList(2, 4, 6, 8, 10)));

        String license = join("\n", readAllLines(get("LICENSE")));
        assertThat(license.length(), is(11356));
    }
}

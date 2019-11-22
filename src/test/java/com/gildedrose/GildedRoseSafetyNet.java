package com.gildedrose;

import org.junit.Test;

import java.io.IOException;

import static com.gildedrose.TextTestFixture.generateBaselineOutput;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GildedRoseSafetyNet {
    @Test
    public void should_always_generate_output_identical_to_baseline() throws IOException {
        String baseline = new String(readAllBytes(get("src/test/baseline.txt")));
        assertThat(generateBaselineOutput(), is(baseline));
    }
}

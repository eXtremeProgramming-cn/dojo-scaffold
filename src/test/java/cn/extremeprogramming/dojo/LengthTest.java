package cn.extremeprogramming.dojo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LengthTest {
    @Test
    public void should_1_inch_equal_to_1_inch() {
        Length inch = new Length(1, "Inch");
        assertThat(inch, is(new Length(1, "Inch")));
    }

    @Test
    public void should_print_itself_in_a_readable_way() {
        Length inch = new Length(1, "Inch");
        assertThat(inch.toString(), is("1 [Inch]"));

        Length foot = new Length(1, "Foot");
        assertThat(foot.toString(), is("1 [Foot]"));
    }

    @Test
    public void should_1_foot_equal_to_12_inches() {
        assertThat(new Length(1, "Foot"), is(new Length(12, "Inch")));
    }

    @Test
    public void should_1_yard_equal_to_3_feet() {
        assertThat(new Length(1, "Yard"), is(new Length(3, "Foot")));
    }
}

package org.codingdojo.kata.args;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArgsTest {
    @Test
    public void should_create_args_out_of_text() {
        Schema schema = new Schema("l:boolean p:integer d:string");
        Args args = new Args(schema, "-l true", "-p 8080", "-d /usr/log");
        assertThat(args.size(), is(3));
        assertThat(args.valueOf("l"), is(true));
        assertThat(args.valueOf("p"), is(8080));
    }

    @Test(expected = LabelNotFound.class)
    public void should_reject_undefined_args() {
        Schema schema = new Schema("l:boolean p:integer d:string");
        new Args(schema, "-l true", "-w invalid_arg");
    }

    @Test(expected = LabelNotFound.class)
    public void should_throw_exception_when_try_to_extract_value_of_non_exist_label() {
        Schema schema = new Schema("l:boolean p:integer d:string");
        Args args = new Args(schema, "-l true", "-p 8080", "-d /usr/log");
        args.valueOf("w");
    }

}

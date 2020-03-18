package org.codingdojo.kata.args;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Args {
    private final List<Arg> args;

    public Args(Schema schema, String... texts) {
        this.args = stream(texts).map(text -> new Arg(schema, text)).collect(toList());
    }

    public int size() {
        return args.size();
    }

    public Object valueOf(String label) {
        Optional<Arg> matchingArg = args.stream().filter(arg -> arg.withLabel(label)).findFirst();
        if(!matchingArg.isPresent()) {
            throw new LabelNotFound(label);
        }
        return matchingArg.get().value();
    }
}

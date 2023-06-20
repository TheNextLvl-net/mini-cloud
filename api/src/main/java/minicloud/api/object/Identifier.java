package minicloud.api.object;

import java.util.Objects;
import java.util.regex.Pattern;

public class Identifier implements CharSequence {
    /**
     * The allowed pattern for names
     */
    public static final Pattern NAMING_PATTERN = Pattern.compile("^[a-zA-Z0-9-_]+$");

    private final String name;

    public Identifier(String name) {
        if (!NAMING_PATTERN.matcher(name).matches())
            throw new IllegalArgumentException(name
                    + " does not match the pattern: "
                    + NAMING_PATTERN.pattern());
        this.name = name;
    }

    @Override
    public int length() {
        return name.length();
    }

    @Override
    public char charAt(int index) {
        return name.charAt(index);
    }

    @Override
    public Identifier subSequence(int start, int end) {
        return new Identifier(name.substring(start, end));
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return name.equals(other);
        Identifier that = (Identifier) other;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

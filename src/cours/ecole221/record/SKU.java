package cours.ecole221.record;

import java.util.Objects;
import java.util.regex.Pattern;

public record SKU(String value) {
    private static final Pattern PATTERN =
            Pattern.compile("^[A-Z]{3}-\\d{4,6}$");

    public SKU {
        Objects.requireNonNull(value, "SKU cannot be null");

        if (!PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(
                    "Invalid SKU format. Expected: AAA-1234 to AAA-123456"
            );
        }
    }
}

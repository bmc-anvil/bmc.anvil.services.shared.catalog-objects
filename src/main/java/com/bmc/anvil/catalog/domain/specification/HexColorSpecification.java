package com.bmc.anvil.catalog.domain.specification;

import java.util.function.Predicate;

import com.bmc.anvil.catalog.domain.specification.base.SpecificationBase;

import static java.util.regex.Pattern.compile;

/**
 * Implementation of {@link SpecificationBase} to validate if a given string represents a valid
 * hexadecimal color code.
 * <p>
 * This specification checks if the input string matches the pattern for hexadecimal
 * color codes, which can either be 6-character (#RRGGBB) or 8-character (#RRGGBBAA)
 * formats, where R, G, B, and A are hexadecimal digits.
 * <p>
 * The validation is case-insensitive and supports both upper and lower case
 * hexadecimal letters.
 */
public class HexColorSpecification extends SpecificationBase<String> {

    /**
     * Regex pattern for validating hexadecimal color code formats.
     * <p>
     * This constant defines the regular expression used to match valid hexadecimal color codes.
     * <p>
     * It supports two formats:<br>
     * - 6-character format: #RRGGBB<br>
     * - 8-character format: #RRGGBBAA
     * <p>
     * Both formats start with a literal `#` followed by hexadecimal digits.
     * The validation is case-insensitive, allowing uppercase or lowercase hexadecimal letters.
     * <p>
     * Valid examples:
     * <ul>
     *   <li>#FFFFFF (white)</li>
     *   <li>#000000 (black)</li>
     *   <li>#FF5733 (orange)</li>
     *   <li>#12345678 (8-character format with alpha component)</li>
     *   <li>#ABCDEF12 (8-character format with alpha component)</li>
     * </ul>
     * Invalid examples:
     * <ul>
     *   <li>#FFF (too short)</li>
     *   <li>#ZZZZZZ (contains invalid characters)</li>
     *   <li>#12345 (incomplete length)</li>
     *   <li>123456 (missing # character)</li>
     * </ul>
     */
    private static final String            HEX_COLOR_FORMAT_REGEX = "^#([A-Fa-f\\d]{8}|[A-Fa-f\\d]{6})$";
    /**
     * A {@link Predicate} that validates whether a given string matches the format of a valid
     * hexadecimal color code based on the {@link HexColorSpecification#HEX_COLOR_FORMAT_REGEX}
     * <p>
     * Making this pattern {@code static final} and precompiled provides several benefits:
     * <p>
     * - Efficiency: Precompiling the pattern avoids repeating the compilation process every time it's used,
     * resulting in better runtime performance.<br>
     * - Thread Safety: The pattern is immutable and inherently thread-safe when declared static final
     */
    private static final Predicate<String> HEX_COLOR_VALIDATOR    = compile(HEX_COLOR_FORMAT_REGEX).asMatchPredicate();

    @Override
    protected Predicate<String> getValidationRule() {

        return HEX_COLOR_VALIDATOR;
    }

    @Override
    protected String getExceptionMessage(final String input) {

        return "Color with hex value: [%s] does not match the expected format: [ %s ]".formatted(input, HEX_COLOR_FORMAT_REGEX);
    }

}

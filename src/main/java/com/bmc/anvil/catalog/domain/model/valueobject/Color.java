package com.bmc.anvil.catalog.domain.model.valueobject;

import lombok.ToString;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@ToString
public class Color {

    private static final String DEFAULT_HEX_VALUE = "#FFFFFF";

    private String hexValue;
    private String rgbValue;

    public Color(final String hexValue, final String rgbValue) {

        if (hexValue != null) {
            this.hexValue = hexValue;
        } else if (rgbValue != null) {
            this.rgbValue = rgbValue;
        } else {
            this.hexValue = DEFAULT_HEX_VALUE;
        }
    }

    public Color() {

        this.hexValue = DEFAULT_HEX_VALUE;
    }

    public String getHexValue() {

        return hexValue != null ? hexValue : convertRgbToHex();
    }

    public String getRgbValue() {

        return rgbValue != null ? hexValue : convertHexToRbg();
    }

    private String convertHexToRbg() {

        return null;
    }

    private String convertRgbToHex() {

        return null;
    }

}

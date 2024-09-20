package org.education.core.strbuilder;

public class Save {

    private final String version;

    private final char[] value;

    public Save (String version, char[] value) {
        this.version = version;
        this.value = value;
    }

    public String getVersion() {
        return version;
    }

    public char[] getValue() {
        return value;
    }
}


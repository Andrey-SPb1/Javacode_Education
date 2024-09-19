package org.education.strbuilder;

import java.util.Arrays;

public class CustomStringBuilder {

    Save lastSave;

    char[] value;

    String version;


    public CustomStringBuilder(String version) {
        this.version = version;
        this.value = new char[10];
    }

    public CustomStringBuilder(String version, String str) {
        this.version = version;
        this.value = str.toCharArray();
    }

    public CustomStringBuilder(String version, int capacity) {
        this.version = version;
        this.value = new char[capacity];
    }

    public CustomStringBuilder append(String str) {
        if (str == null) {
            return this;
        }
        int len = value.length;
        setNewSize(str.length() + len);
        putStringAt(len, str);
        return this;
    }

    public void save() {
        this.lastSave = new Save(this.version, this.value);
    }

    public void undo() {
        this.version = lastSave.getVersion();
        this.value = lastSave.getValue();
    }

    public int length() {
        return value.length;
    }

    private void setNewSize(int newSize) {
        if (newSize - value.length > 0) {
            value = Arrays.copyOf(value, newSize + 1);
        }
    }

    private void putStringAt(int len, String str) {
        for (char c : str.toCharArray()) {
            value[len++] = c;
        }
    }

    @Override
    public String toString() {
        return new String(value);
    }
}

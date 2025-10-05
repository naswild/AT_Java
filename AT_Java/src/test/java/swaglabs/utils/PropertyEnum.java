package swaglabs.utils;

public enum PropertyEnum {

    STANDARD_USER("AT_Java.standard_user"),
    PASSWORD("AT_Java.password"),
    LOCKED_OUT_USER("AT_Java.locked_out"),
    BASE_URL("AT_Java.url");

    private final String value;

    PropertyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

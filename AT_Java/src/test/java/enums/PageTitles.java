package enums;

public enum PageTitles {

    PRODUCTS("Products"),
    CARTS("Your Cart");

    private final String displayName;

    PageTitles(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

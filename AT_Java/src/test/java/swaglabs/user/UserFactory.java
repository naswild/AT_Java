package swaglabs.user;

import swaglabs.utils.PropertyEnum;
import swaglabs.utils.PropertyReader;

public class UserFactory {

    public static User withClientPermission() {
        return new User(PropertyReader.getProperty(PropertyEnum.STANDARD_USER.getValue()),
                PropertyReader.getProperty(PropertyEnum.PASSWORD.getValue()));
    }

    public static User withLockedOutUserPermission() {
        return new User(PropertyReader.getProperty(PropertyEnum.LOCKED_OUT_USER.getValue()),
                PropertyReader.getProperty(PropertyEnum.PASSWORD.getValue()));
    }
}

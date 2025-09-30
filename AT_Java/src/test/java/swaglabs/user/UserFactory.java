package swaglabs.user;

import swaglabs.utils.PropertyConstants;
import swaglabs.utils.PropertyReader;

public class UserFactory {

    public static User withClientPermission() {
        return new User(PropertyReader.getProperty(PropertyConstants.STANDARD_USER),
                PropertyReader.getProperty(PropertyConstants.PASSWORD));
    }

    public static User withLockedOutUserPermission() {
        return new User(PropertyReader.getProperty(PropertyConstants.LOCKED_OUT_USER),
                PropertyReader.getProperty(PropertyConstants.PASSWORD));
    }
}

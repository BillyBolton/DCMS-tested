package ca.me.proj.api.controller.profile;

import ca.me.proj.api.constants.ApiUri;

public final class ProfileUri {


    private ProfileUri() {}

    public static final String DOMAIN = "/profile";
    public static final String AUTHENTICATE = "/authenticate";
    public static final String BY_USERNAME = "/byUsername";

    public static final String FIND_BY_USERNAME = ApiUri.FIND + BY_USERNAME;
    public static final String EXISTS_BY_USERNAME = ApiUri.EXISTS + BY_USERNAME;
    public static final String DELETE_BY_USERNAME = ApiUri.DELETE + BY_USERNAME;

}

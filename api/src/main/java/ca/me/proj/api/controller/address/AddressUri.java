package ca.me.proj.api.controller.address;

import ca.me.proj.api.constants.ApiUri;

public class AddressUri {

    private AddressUri() {}

    public static final String DOMAIN = "/address";
    public static final String FIND_BY_ADDRESS = ApiUri.FIND + "/by" + DOMAIN;

}

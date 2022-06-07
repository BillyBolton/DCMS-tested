package ca.me.proj.api.constants;

public final class ApiUri {

    private ApiUri() {}


    public static final String FIND = "/find";
    public static final String BY_ID = "/byId";
    public static final String EXISTS = "/exists";
    public static final String ALL = "/all";
    public static final String DELETE = "/delete";

    public static final String EXISTS_BY_ID = EXISTS + BY_ID;
    public static final String FIND_BY_ID = FIND + BY_ID;
    public static final String FIND_ALL = FIND + ALL;
    public static final String SAVE = "/save";
    public static final String DELETE_BY_ID = DELETE + BY_ID;

}

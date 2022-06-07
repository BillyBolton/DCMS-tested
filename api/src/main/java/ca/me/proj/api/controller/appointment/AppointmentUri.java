package ca.me.proj.api.controller.appointment;

import ca.me.proj.api.constants.ApiUri;

public class AppointmentUri {

    private AppointmentUri() {}

    public static final String DOMAIN = "/appointment";

    public static final String FIND_BY_PATIENT_ID = ApiUri.FIND + "/byPatientId";
    public static final String FIND_BY_EMPLOYEE_ID = ApiUri.FIND + "/byEmployeeId";


}

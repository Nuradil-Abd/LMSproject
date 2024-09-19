package lms.models;

import lms.enums.UserType;
import lms.utils.IdGenerator;

public class Admin extends User {
    private final UserType positions;

    public Admin( String name, String email, String password, String phoneNumber) {
        super(IdGenerator.genAdminId(), name, email, password, phoneNumber);
        this.positions = UserType.ADMIN;
    }

    public UserType getPositions() {
        return positions;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "} " + super.toString();
    }
}

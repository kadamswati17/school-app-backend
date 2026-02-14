package com.schoolapp.enums;

//package com.Crmemp.enums;

//import com.Crmemp.enums.Role;

public enum Role {

    ADMIN(0),
    L1(1),
    L2(2),
    L3(3),
    L4(4),
    L5(5),
    L6(6),
    L7(7),
    USER(99);

    private final int level;

    Role(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public static Role fromSpringRole(String role) {
        return Role.valueOf(role.replace("ROLE_", ""));
    }
}


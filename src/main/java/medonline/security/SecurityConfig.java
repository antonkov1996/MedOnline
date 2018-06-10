package medonline.security;

import java.util.*;

public class SecurityConfig {
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    // String: Role
    // List<String>: urlPatterns.
    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {

        // Конфигурация для роли "USER".
        List<String> urlPatterns1 = new ArrayList<String>();

        urlPatterns1.add("/customerInfo");
        urlPatterns1.add("/medicine/add");
        urlPatterns1.add("/order/add");
        urlPatterns1.add("/yourorders");

        mapConfig.put(ROLE_USER, urlPatterns1);

        // Конфигурация для роли "ADMIN".
        List<String> urlPatterns2 = new ArrayList<String>();
        urlPatterns2.add("/order/all");
        urlPatterns2.add("/order/add");
        urlPatterns2.add("/yourorders");
        urlPatterns2.add("/customerInfo");
        urlPatterns2.add("/medicine/all");
        urlPatterns2.add("/medicine/add");
        urlPatterns2.add("/customer/admin");
        urlPatterns2.add("/class/add");
        urlPatterns2.add("/medicine/create");
        urlPatterns2.add("/provider/add");
        urlPatterns2.add("/customer/info");
        urlPatterns2.add("/customer/all");
        urlPatterns2.add("/customer/del");
        urlPatterns2.add("/medicine/delete");
        urlPatterns2.add("/order/del");
        urlPatterns2.add("/provider/del");
        urlPatterns2.add("/medicine/edit");
        urlPatterns2.add("/provider/edit");


        mapConfig.put(ROLE_ADMIN, urlPatterns2);
    }

    //выдать только то что нужно
    public static List<String> getNeedRole(String role) {
        return mapConfig.get(role);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }

}

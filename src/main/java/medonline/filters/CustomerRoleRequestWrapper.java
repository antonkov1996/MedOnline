package medonline.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;

public class CustomerRoleRequestWrapper extends HttpServletRequestWrapper {
    private String email;
    private String role;
    private HttpServletRequest realRequest;

    public CustomerRoleRequestWrapper(String email, String role, HttpServletRequest request) {
        super(request);
        this.email = email;
        this.role = role;
        this.realRequest = request;
    }

    @Override
    public boolean isUserInRole(String role) {
        if (this.role == null) {
            return this.realRequest.isUserInRole(role);
        }
        return this.role.contains(role);
    }

    @Override
    public Principal getUserPrincipal() {
        if (this.email == null) {
            return realRequest.getUserPrincipal();
        }
        return new Principal() {
            @Override
            public String getName() {
                return email;
            }
        };
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

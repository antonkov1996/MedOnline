package medonline.filters;

import medonline.entities.Customer;
import medonline.security.SecurityUtils;
import medonline.utils.MyUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter")
public class SecurityFilter implements Filter {
    public SecurityFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String servletPath = request.getServletPath();
        System.out.println("SecurityFilter works "+servletPath);

        Customer loginedCustomer = MyUtils.getLoginedCustomer(request.getSession());
        request.getSession().setAttribute("customer",loginedCustomer);
        if (servletPath.equals("/login")){
            chain.doFilter(request,response);
            return;
        }
        HttpServletRequest wrapRequest = request;
        if (loginedCustomer!=null){
            String customerEmail = loginedCustomer.getEmail();
            String role = loginedCustomer.getRole();
            wrapRequest = new CustomerRoleRequestWrapper(customerEmail,role,request);
        }

        if (SecurityUtils.isSecurityPage(request)){
            if (loginedCustomer==null){
                String requestURI = request.getRequestURI();
                int redirectId = MyUtils.storeRedirectAfterLoginUrl(request.getSession(),requestURI);
                response.sendRedirect(wrapRequest.getContextPath()+"/login?redirectId="+redirectId);
                return;
            }

            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission){
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/accessDeniedView.jsp");
                dispatcher.forward(request,response);
                return;
            }
        }

        chain.doFilter(wrapRequest,response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

package org.springframework.samples.parchis_oca.admin;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    private static final String VIEWS_ADMINS_CREATE_OR_UPDATE_FORM = "admins/createOrUpdateAdminForm";
    private static final String ADMIN_NOT_FOUND = "admin not found";
    private static final String ADMIN = "admin";
    private static final String MESSAGE = "message";
    private static final String ERROR = "/error";


    
    @GetMapping(path="/profile/{adminId}")
    public String profile(@PathVariable("adminId") int adminId, ModelMap modelMap, HttpServletRequest request) {
        // if the user is not an admin, it will return an error page (only admins can access this page)

        Optional<Admin> admin = adminService.findAdminById(adminId);
        
        if(admin.isPresent()){
            modelMap.addAttribute(ADMIN, admin.get());
        
        } else{
            modelMap.addAttribute(MESSAGE, ADMIN_NOT_FOUND);
            return ERROR;
        }
        return "admins/profile";
    }


    @GetMapping(path="/rooms")
    public String rooms(ModelMap modelMap, HttpServletRequest request) {

        modelMap.addAttribute(MESSAGE, request.getSession().getAttribute(MESSAGE));
        request.getSession().removeAttribute(MESSAGE);
        return "admins/rooms";
    }


    @GetMapping(value = "/profile/edit/{adminId}")
    public String updateAdmin(@PathVariable("adminId") int adminId, ModelMap modelMap) {
        Optional<Admin> admin = adminService.findAdminById(adminId);
        if(admin.isPresent()){
            modelMap.addAttribute(ADMIN, admin.get());
        }else{
            modelMap.addAttribute(MESSAGE, ADMIN_NOT_FOUND);
            return ERROR;
        }
        return VIEWS_ADMINS_CREATE_OR_UPDATE_FORM;
    }
    

}

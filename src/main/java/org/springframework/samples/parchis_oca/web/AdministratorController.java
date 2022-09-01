package org.springframework.samples.parchis_oca.web;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.parchis_oca.model.Administrator;
import org.springframework.samples.parchis_oca.service.AdministratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins")
public class AdministratorController {

    @Autowired
    private AdministratorService adminService;

    private static final String VIEWS_ADMINS_CREATE_OR_UPDATE_FORM = "admins/createOrUpdateAdminForm";
    private static final String ADMIN_NOT_FOUND = "admin not found";
    private static final String ADMIN = "admin";
    private static final String MESSAGE = "message";
    private static final String ERROR = "/error";

   
    @GetMapping(path="/profile/{adminId}")
    public String profile(@PathVariable("adminId") int adminId, ModelMap modelMap, HttpServletRequest request) {
        Optional<Administrator> admin = adminService.findAdminById(adminId);
        
        if(admin.isPresent()){
            modelMap.addAttribute(ADMIN, admin.get());
        
        } else{
            modelMap.addAttribute(MESSAGE, ADMIN_NOT_FOUND);
            return ERROR;
        }
        return "admins/profile";
    }


    @GetMapping(value = "/profile/edit/{adminId}")
    public String updateAdmin(@PathVariable("adminId") int adminId, ModelMap modelMap) {
        Optional<Administrator> admin = adminService.findAdminById(adminId);
        if(admin.isPresent()){
            modelMap.addAttribute(ADMIN, admin.get());
        }else{
            modelMap.addAttribute(MESSAGE, ADMIN_NOT_FOUND);
            return ERROR;
        }
        return VIEWS_ADMINS_CREATE_OR_UPDATE_FORM;
    }
    

}

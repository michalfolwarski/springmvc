package com.mfolwarski.springmvc.profile;

import com.mfolwarski.springmvc.date.LocalDateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Controller
public class ProfileController {

    @ModelAttribute("dateFormat")
    public String localeFormat(Locale locale){
        return LocalDateFormatter.getPattern(locale).toLowerCase();
    }

    @RequestMapping("/profile")
    public String displayProfile(@ModelAttribute("profileForm") ProfileForm profileForm){
        if (profileForm.getTastes().size() == 0)
            profileForm.getTastes().add(null);
        return "profile/profilePage";
    }

    @RequestMapping(value = "/profile", params = {"save"}, method = RequestMethod.POST)
    public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "profile/profilePage";
        }
        System.out.println("save ok: " + profileForm);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/profile", params = {"addField"})
    public String addField(ProfileForm profileForm){
        profileForm.getTastes().add(null);
        return "profile/profilePage";
    }

    @RequestMapping(value = "/profile", params = {"removeTaste"})
    public String removeTaste(ProfileForm profileForm, HttpServletRequest request){
        int rowId = Integer.valueOf(request.getParameter("removeTaste"));
        profileForm.getTastes().remove(rowId);
        return "profile/profilePage";
    }
}

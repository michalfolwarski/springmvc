package com.mfolwarski.springmvc.profile;

import com.mfolwarski.springmvc.date.LocalDateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class ProfileController {

    @ModelAttribute("dateFormat")
    public String localeFormat(Locale locale){
        return LocalDateFormatter.getPattern(locale).toUpperCase();
    }

    @RequestMapping("/profile")
    public String displayProfile(@ModelAttribute("profileForm") ProfileForm profileForm){
        return "profile/profilePage";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String saveProfile(ProfileForm profileForm){
        System.out.println("save ok: " + profileForm);
        return "redirect:/profile";
    }
}

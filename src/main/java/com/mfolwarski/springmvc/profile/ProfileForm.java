package com.mfolwarski.springmvc.profile;

import com.mfolwarski.springmvc.date.PastLocalDate;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProfileForm {
    @Size(min = 3)
    private String twitterHandle;

    @Email
    @NotEmpty
    private String email;

    @NotNull
    @PastLocalDate
    private LocalDate birthDate;

    @NotEmpty
    private List<String> tastes = new ArrayList<>();
}

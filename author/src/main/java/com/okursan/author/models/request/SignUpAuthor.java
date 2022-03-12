package com.okursan.author.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpAuthor {

    private String username;

    private String password;

    private String name;

    private String lastname;

    private String email;

}

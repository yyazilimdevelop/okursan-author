package com.okursan.author.services;

import java.util.Optional;

import com.okursan.author.entities.Author;
import com.okursan.author.models.enums.AuthorStatus;
import com.okursan.author.models.response.ApiResponse;
import com.okursan.author.models.response.EmptyData;
import com.okursan.author.repositories.AuthorRepository;
import com.okursan.author.value.StringValues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public ApiResponse<EmptyData> addAuthor(String name, String lastname, String username, String password,
            String email) {
        if (authorRepository.existsByUsername(username)) {
            return new ApiResponse<EmptyData>().error(StringValues.existUsername);
        }

        save(name, lastname, username, password, email);

        return new ApiResponse<EmptyData>().success(StringValues.successSignUp);
    }

    public Author save(String name, String lastname, String username, String password, String email) {
        Author author = new Author();
        author.setName(name);
        author.setLastname(lastname);
        author.setEmail(email);
        author.setUsername(username);
        author.setPassword(encryptPassword(password));
        author.setStatus(AuthorStatus.waitingActivation.ordinal());

        return authorRepository.save(author);
    }

    private String encryptPassword(String password) {
        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
        String pwd = pwdEncoder.encode(password);

        return pwd;
    }

    public ApiResponse<EmptyData> signIn(String username, String password) {
        Optional<Author> author = authorRepository.findByUsername(username);

        if (author.isEmpty()) {
            return new ApiResponse<EmptyData>().error(StringValues.userNotFound);
        }
        if (!checkPassword(password, author.get().getPassword())) {
            return new ApiResponse<EmptyData>().error(StringValues.userNotFound);
        }

        return new ApiResponse<EmptyData>().success();
    }

    public boolean checkPassword(String inputPassword, String password) {
        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
        return pwdEncoder.matches(inputPassword, password);
    }
}

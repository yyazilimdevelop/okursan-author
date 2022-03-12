package com.okursan.author.services;

import com.okursan.author.entities.Author;
import com.okursan.author.models.enums.AuthorStatus;
import com.okursan.author.models.response.ApiResponse;
import com.okursan.author.models.response.EmptyData;
import com.okursan.author.repositories.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public ApiResponse<EmptyData> addAuthor(String name, String lastname, String username, String password,
            String email) {
        return new ApiResponse<EmptyData>().error();
    }

    public Author save(String name, String lastname, String username, String password, String email) {
        Author author = new Author();
        author.setName(name);
        author.setLastname(lastname);
        author.setEmail(email);
        author.setUsername(username);
        author.setPassword(getEncryptedPassword(password));
        author.setStatus(AuthorStatus.waitingActivation.ordinal());

        return authorRepository.save(author);
    }

    private String getEncryptedPassword(String password) {
        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
        String pwd = pwdEncoder.encode(password);

        return pwd;
    }
}

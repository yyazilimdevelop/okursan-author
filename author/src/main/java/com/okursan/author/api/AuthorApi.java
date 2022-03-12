package com.okursan.author.api;

import com.okursan.author.entities.Author;
import com.okursan.author.models.request.SignUpAuthor;
import com.okursan.author.models.response.ApiResponse;
import com.okursan.author.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorApi {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public ApiResponse<Author> addAuthor(@RequestBody SignUpAuthor author) {
        var auth = authorService.save(author.getName(), author.getLastname(), author.getUsername(),
                author.getPassword(), author.getEmail());

        return new ApiResponse<Author>().success(auth, "mesaj");
    }

}

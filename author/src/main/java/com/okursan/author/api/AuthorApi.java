package com.okursan.author.api;

import com.okursan.author.models.request.SignUpAuthor;
import com.okursan.author.models.response.ApiResponse;
import com.okursan.author.models.response.EmptyData;
import com.okursan.author.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ApiResponse<EmptyData> addAuthor(@RequestBody SignUpAuthor author) {
        return authorService.addAuthor(author.getName(), author.getLastname(), author.getUsername(),
                author.getPassword(), author.getEmail());
    }

    @GetMapping("/get")
    public ApiResponse<EmptyData> signIn() {
        return authorService.signIn("aliyetking", "12345678");
    }

}

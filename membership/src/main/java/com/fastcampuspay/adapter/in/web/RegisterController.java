package com.fastcampuspay.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterController {
    @GetMapping(path = "/test")
    void test() {
        System.out.println("Hello World!");
    }
}

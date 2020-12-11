package com.mobitbrasil.apirecaptcha.recaptcha.api;

import com.mobitbrasil.apirecaptcha.recaptcha.model.Account;
import com.mobitbrasil.apirecaptcha.recaptcha.repository.RecaptchaRepository;
import com.mobitbrasil.apirecaptcha.recaptcha.service.RecaptchaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "/api")
public class RecaptchaResource {

    @Autowired
    private RecaptchaService recaptchaService;
    @Autowired
    private RecaptchaRepository recaptchaRepository;

    @PostMapping("/verify")
    public ResponseEntity<?> signup(
                                    @RequestBody Account account,
                                        HttpServletRequest request){


        String ip = request.getRemoteAddr();
        recaptchaService.verifyRecaptcha(ip, account.getRecaptcha());

        recaptchaRepository.save(account);
        return ResponseEntity.ok().build();
    }
}
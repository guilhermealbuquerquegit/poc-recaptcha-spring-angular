package com.mobitbrasil.apirecaptcha.recaptcha.repository;

import com.mobitbrasil.apirecaptcha.recaptcha.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecaptchaRepository extends JpaRepository <Account, Long> {
}

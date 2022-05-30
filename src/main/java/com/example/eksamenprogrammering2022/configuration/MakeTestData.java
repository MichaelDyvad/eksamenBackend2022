package com.example.eksamenprogrammering2022.configuration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class MakeTestData implements ApplicationRunner {

    //Import repos

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}

package com.example.restapi_lesson_42;

public interface Constant {
    String REGEX_PASSWORD ="(?=.*[0-9])(?=\\S+$).{5,20}";
    String REGEX_USERNAME = "(?=\\S+$).{5,20}";
    String REGEX_FIRSTNAME = "(?=\\S+$).{1,20}";
    String REGEX_LASTNAME = "(?=\\S+$).{1,20}";
    String REGEX_EMAIL = "^(.+)@(.+)$";
}

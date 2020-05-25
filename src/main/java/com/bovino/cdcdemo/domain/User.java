package com.bovino.cdcdemo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private String login;
}

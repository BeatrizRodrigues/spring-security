package com.dev.authserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String MenuName;
}

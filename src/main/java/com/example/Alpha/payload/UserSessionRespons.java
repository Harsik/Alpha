package com.example.Alpha.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserSessionRespons {
    private Long id;
    private String sessionID;
    private String userID;
}

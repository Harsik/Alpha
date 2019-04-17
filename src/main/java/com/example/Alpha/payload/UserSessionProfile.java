package com.example.Alpha.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSessionProfile {
    private String sessionID;
    private String userID;

    @Builder
    public UserSessionProfile(String sessionID, String userID) {
        this.sessionID = sessionID;
        this.userID = userID;
    }
}

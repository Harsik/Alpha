package com.example.Alpha.payload;

import javax.validation.constraints.NotBlank;

// import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
// import lombok.Builder;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSessionRequest {
    
    @NotBlank
    private String sessionID;

    @NotBlank
    private String userID;
    
    // @Builder
    // public UserSessionRequest(String sessionID, String userID) {
    //     this.sessionID = sessionID;
    //     this.userID = userID;
    // }
}
package com.example.Alpha.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse {
    private Boolean success;
    private String message;

    @Builder
    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
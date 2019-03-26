package com.example.Alpha.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserIdentityAvailability {
    private Boolean available;

    @Builder
    public UserIdentityAvailability(Boolean available) {
        this.available = available;
    }
}

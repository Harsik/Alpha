package com.example.Alpha.payload;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

// import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PollLength {
    @NotNull
    @Max(7)
    private Integer days;

    @NotNull
    @Max(23)
    private Integer hours;

    // @Builder
    // public PollLength(int days, int hours){
    //     this.days = days;
    //     this.hours = hours;
    // }
}
package com.example.Alpha.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChoiceRequest {
    @NotBlank
    @Size(max = 40)
    private String text;

    // @Builder
    // public ChoiceRequest(String text){
    //     this.text = text;
    // }
}
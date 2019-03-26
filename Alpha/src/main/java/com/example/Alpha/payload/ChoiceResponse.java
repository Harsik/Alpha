package com.example.Alpha.payload;

// import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ChoiceResponse {
    private long id;
    private String text;
    private long voteCount;
}

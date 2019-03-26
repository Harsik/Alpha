package com.example.Alpha.payload;

import javax.validation.constraints.NotNull;

// import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VoteRequest {
    @NotNull
    private Long choiceId;

    // @Builder
    // public VoteRequest(Long choiceId){
    //     this.choiceId = choiceId;
    // }
}
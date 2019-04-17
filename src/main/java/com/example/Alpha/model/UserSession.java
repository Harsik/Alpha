// package com.example.Alpha.model;

// import java.io.Serializable;

// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

// import org.springframework.data.redis.core.RedisHash;

// import lombok.Builder;
// import lombok.Getter;
// import lombok.Setter;

// @Setter
// @Getter
// @RedisHash("userSession")
// public class UserSession implements Serializable {

//     private static final long serialVersionUID = 1L;
    
//     // @Id
//     // @GeneratedValue(strategy = GenerationType.IDENTITY)
//     // private long id;
    
//     @Id
//     private String sessionID;    
//     private String userID;

//     @Builder
//     public UserSession(String sessionID, String userID) {
//         this.sessionID = sessionID;
//         this.userID = userID;
//     }
// }
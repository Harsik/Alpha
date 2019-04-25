// package com.example.Alpha.controller;

// import javax.validation.Valid;

// import com.example.Alpha.model.UserSession;
// import com.example.Alpha.payload.ApiResponse;
// import com.example.Alpha.payload.UserSessionProfile;
// import com.example.Alpha.payload.UserSessionRequest;
// import com.example.Alpha.repository.UserSessionRepository;

// import java.net.URI;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// @RestController("/api/redis")
// class RedisController {

//     @Autowired
//     UserSessionRepository userSessionRepository;

//     @PostMapping
//     //@PostMapping("/addUserSession")
//     public ResponseEntity<?> registerUser(@Valid @RequestBody UserSessionRequest userSessionRequest) {
//         // Creating user's account
//         UserSession userSession = new UserSession(userSessionRequest.getSessionID(), userSessionRequest.getUserID());

//         UserSession result = userSessionRepository.save(userSession);

//         URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sessionID}")
//                 .buildAndExpand(result.getSessionID()).toUri();

//         return ResponseEntity.created(location).body(new ApiResponse(true, "UserSession Created Successfully"));
//     }
    
//     @GetMapping("/{sessionID}")
//     public UserSessionProfile getUserProfile(@PathVariable(value = "sessionID") String sessionId) {
//         UserSession userSession = userSessionRepository.findBySessionID(sessionId);

//         UserSessionProfile userSessionProfile = new UserSessionProfile(userSession.getSessionID(), userSession.getUserID());

//         return userSessionProfile;
//     }
// }
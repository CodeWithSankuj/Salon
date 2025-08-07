package com.salon.user.service.payload.response;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private String message;
    private String Error;
    private LocalDateTime timestamp;
}

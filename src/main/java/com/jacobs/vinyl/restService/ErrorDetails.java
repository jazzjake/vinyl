package com.jacobs.vinyl.restService;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timeStamp,
                           String message,
                           String details) {
}

package com.enigma.onlineShop.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FileStorage {
    private String filename;
    private LocalDateTime dateTime;
}

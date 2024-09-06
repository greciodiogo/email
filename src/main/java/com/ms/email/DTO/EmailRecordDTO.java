package com.ms.email.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmailRecordDTO(
    UUID userId,
    String emailTo,
    String subject,
   @JsonProperty("text") // Mapeia o campo "text" do JSON para o campo "Text" no Java
    String Text
) {
    
}

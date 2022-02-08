package org.cigma.gestionusers.presentation.openapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@ConfigurationProperties(prefix = "swagger.ui")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class OpenAPIProperties {
    String title = "Spring Boot Exam: Users Management";
    String description = "Gestion des utilisateurs";
    String version = "1.0.0";
    String contactName = "Aimad KADIRI";
    String contactUrl = "http://test123.com";
    String contactEmail = "aimad.kadiri.pro@gmail.com";
}

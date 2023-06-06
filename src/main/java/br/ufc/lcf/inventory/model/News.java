package br.ufc.lcf.inventory.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Document(collection = "noticias")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class News {
    @MongoId
    private String id;
    private String image;
    private String title;
    private String description;
    @DateTimeFormat(pattern = "dd-MM-YYYY")
    private LocalDateTime date;
}

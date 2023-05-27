package br.ufc.lcf.inventory.Postal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "caixa_postal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Postal {
    @MongoId
    private String id;
    private String name;
    private String phone;
    private String email;
    private String message;
    private LocalDateTime date;
}

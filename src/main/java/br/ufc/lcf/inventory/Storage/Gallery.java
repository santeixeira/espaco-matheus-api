package br.ufc.lcf.inventory.Storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "galeria")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Gallery {
    @MongoId
    private String id;
    private String name;
    private String description;
    private String type;
    private byte[] imagePath;
}

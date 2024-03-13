package by.kladvirov.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Authority entity")
public class AuthorityDto {

    @Schema(description = "Identifier")
    private Long id;

    @NotEmpty(message = "Name can't be null")
    @Schema(description = "Authority name", example = "DELETE_ROLES")
    private String name;

}

package AlpacaAPI.PlayneeTesting.dtos;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

public record PostRecordDTO(@NotNull BigDecimal id, @NotBlank String post_id) {
}

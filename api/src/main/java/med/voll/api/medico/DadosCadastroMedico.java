package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(


        @NotBlank// verifica se nao é nulo e nem vazio ... notblanck é so para campos Strings
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") // estou dizendo aqui \\d sera um digito de 4 a 6 digitos
        String crm,
        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid // to dizendo que é para validar tambem os DadosEndereco
        DadosEndereco endereco) {
}

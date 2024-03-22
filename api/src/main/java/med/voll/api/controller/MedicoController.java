package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        // recebi um DTO e agora eu tenho que converter para um tipo Medico

        medicoRepository.save(new Medico(dados));

    }


    // não posso devolver a entidade medico
    @GetMapping
    public List<DadosListagemMedico> listar() {
    return medicoRepository.findAll().stream().map(DadosListagemMedico::new).toList();

    }

}

package com.github.stefanyomori.registro_stefany_558792_m1.service;

import com.github.stefanyomori.registro_stefany_558792_m1.dto.RegistroInput;
import com.github.stefanyomori.registro_stefany_558792_m1.dto.RegistroOutput;
import com.github.stefanyomori.registro_stefany_558792_m1.entities.Registro;
import com.github.stefanyomori.registro_stefany_558792_m1.repository.RegistroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository repository;

    @Transactional
    public RegistroOutput create(RegistroInput input) {
        Registro registro = new Registro();

        registro.setEstacaoNome(input.getEstacaoNome());
        registro.setDataRegistro(input.getDataRegistro());
        registro.setTemperatura(input.getTemperatura());
        registro.setPercentualUmidade(input.getPercentualUmidade());
        registro.setPrecipitacao(input.getPrecipitacao());
        registro.setCondicaoClimatica(input.getCondicaoClimatica());

        Registro salvo = repository.save(registro);

        return toResponse(salvo);
    }

    @Transactional
    public List<RegistroOutput> listAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional
    public RegistroOutput findById(Long id) {
        Registro registro = findEntity(id);
        return toResponse(registro);
    }

    @Transactional
    public RegistroOutput update(Long id, RegistroInput input) {
        Registro registro = findEntity(id);

        registro.setEstacaoNome(input.getEstacaoNome());
        registro.setDataRegistro(input.getDataRegistro());
        registro.setTemperatura(input.getTemperatura());
        registro.setPercentualUmidade(input.getPercentualUmidade());
        registro.setPrecipitacao(input.getPrecipitacao());
        registro.setCondicaoClimatica(input.getCondicaoClimatica());

        Registro atualizado = repository.save(registro);

        return toResponse(atualizado);
    }

    @Transactional
    public void delete(Long id) {
        Registro registro = findEntity(id);
        repository.delete(registro);
    }

    @Transactional
    private Registro findEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Registro meteorológico não encontrado"
                ));
    }

    private RegistroOutput toResponse(
            Registro registro) {
        return new RegistroOutput(
                registro.getId(),
                registro.getEstacaoNome(),
                registro.getDataRegistro(),
                registro.getTemperatura(),
                registro.getPercentualUmidade(),
                registro.getPrecipitacao(),
                registro.getCondicaoClimatica()
        );
    }
}

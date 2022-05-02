package br.com.firstproject.forum.controller;

import br.com.firstproject.forum.controller.dto.TopicoDTO;
import br.com.firstproject.forum.controller.form.TopicoForm;
import br.com.firstproject.forum.modelo.Curso;
import br.com.firstproject.forum.modelo.Topico;
import br.com.firstproject.forum.repository.CursoRepository;
import br.com.firstproject.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDTO> lista(String nomeCurso) {
        if (nomeCurso == null) {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDTO.converter(topicos);
        } else {
            List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
            return TopicoDTO.converter(topicos);
        }
    }

    @PostMapping
    public void cadastrar(@RequestBody TopicoForm topicoForm) {
        topicoRepository.save(topicoForm.converter(cursoRepository));
    }
}

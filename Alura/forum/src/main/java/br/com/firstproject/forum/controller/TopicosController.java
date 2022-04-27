package br.com.firstproject.forum.controller;

import br.com.firstproject.forum.controller.dto.TopicoDTO;
import br.com.firstproject.forum.modelo.Curso;
import br.com.firstproject.forum.modelo.Topico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDTO> lista(){
        Topico topico = new Topico("Duvida", "Duvida com ", new Curso("Spring", "Programação"));

        return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
    }
}

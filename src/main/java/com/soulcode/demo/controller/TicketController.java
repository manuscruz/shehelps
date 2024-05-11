package com.soulcode.demo.controller;

import com.soulcode.demo.dto.TicketDTO;
import com.soulcode.demo.models.Persona;
import com.soulcode.demo.models.Sector;
import com.soulcode.demo.repositories.TypeRepository;
import com.soulcode.demo.service.TicketService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;


@Controller
@RequestMapping
public class TicketController {


    private final TicketService ticketService;
    private TypeRepository typeRepository;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
        this.typeRepository = typeRepository;
    }

    @GetMapping("/chamado")
    public String mostrarFormularioChamado(Model model, Principal principal) {

        return "ticket";
    }

    @PostMapping("/criar-chamado")
    public String criarChamado(
            @RequestParam String descricao,
            @RequestParam String prioridade,
            @RequestParam Sector setorDeDirecionamento,
            RedirectAttributes redirectAttributes,
            Principal principal,
            HttpSession session) {

        String nomeUsuario = (String) session.getAttribute("nomeUsuario");
        String setor = (String) session.getAttribute("setor");

        ticketService.createTicket(descricao, prioridade, setorDeDirecionamento, nomeUsuario, setor);



        redirectAttributes.addAttribute("mensagem", "Chamado criado com sucesso!");

        return "redirect:/chamado";
    }
}

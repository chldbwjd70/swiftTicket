package com.example.swiftTicket.controller.ticket;

import com.example.application.service.ticket.TicketService;
import com.example.domain.ticket.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {


    private final TicketService ticketService;

    @GetMapping("/save")
    public void save() {
        Ticket ticket = new Ticket("ticket2");
        ticketService.save(ticket);
    }


    @GetMapping("/name")
    public void findByName() {
        ticketService.findByName("ticket2");
    }


}

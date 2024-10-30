package com.example.application.service.ticket;

import com.example.domain.ticket.Ticket;
import com.example.domain.ticket.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;


    public void save(Ticket ticket){
        ticketRepository.save(ticket);
    }


    public Ticket findByName(String name){
        List<Ticket> tickets = ticketRepository.findByName(name);
        tickets.forEach( t -> System.out.println(t.getName()));
        return tickets.get(0);
    }


}

package br.fatec.easycoast.mappers;

import br.fatec.easycoast.dtos.TicketItemRequest;
import br.fatec.easycoast.dtos.TicketItemResponse;
import br.fatec.easycoast.entities.TicketItem;

public class TicketItemMapper {

    public static TicketItemResponse toResponse(TicketItem ticketItem) {
        return new TicketItemResponse(
                ticketItem.getId(),
                ticketItem.getDescription(),
                ticketItem.getPrice(),
                ticketItem.getQuantity()
        );
    }

    public static TicketItem toEntity(TicketItemRequest request) {
        TicketItem ticketItem = new TicketItem();
        ticketItem.setDescription(request.description());
        ticketItem.setPrice(request.price());
        ticketItem.setQuantity(request.quantity());
        return ticketItem;
    }
}

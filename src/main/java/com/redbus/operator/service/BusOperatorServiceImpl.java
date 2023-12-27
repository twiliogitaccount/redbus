package com.redbus.operator.service;

import com.redbus.operator.entity.BusOperator;
import com.redbus.operator.entity.TicketCost;
import com.redbus.operator.payload.BusOperatorDto;
import com.redbus.operator.repository.BusOperatorRepository;
import com.redbus.operator.repository.TicketCostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BusOperatorServiceImpl implements BusOperatorService{

    private BusOperatorRepository busOperatorRepository;
    private TicketCostRepository ticketCostRepository;
    private ModelMapper mapper;

    public BusOperatorServiceImpl(BusOperatorRepository busOperatorRepository,
                                  TicketCostRepository ticketCostRepository,
                                  ModelMapper mapper) {
        this.busOperatorRepository = busOperatorRepository;
        this.ticketCostRepository = ticketCostRepository;
        this.mapper = mapper;
    }

    @Override
    public BusOperatorDto scheduleBus(BusOperatorDto busOperatorDto) {
        BusOperator busOperator = mapToEntity(busOperatorDto);

        // Create a new TicketCost entity and set its properties
        TicketCost ticketCost = new TicketCost();
        ticketCost.setTicketId(busOperatorDto.getTicketCost().getTicketId());
        ticketCost.setCost(busOperatorDto.getTicketCost().getCost());
        ticketCost.setCode(busOperatorDto.getTicketCost().getCode());
        ticketCost.setDiscountAmount(busOperatorDto.getTicketCost().getDiscountAmount());

        // Set the TicketCost entity in the BusOperator entity
        busOperator.setTicketCost(ticketCost);

        // Generate a unique busId
        String busId = UUID.randomUUID().toString();
        busOperator.setBusId(busId);

        // Save both entities
        BusOperator savedBusSchedule = busOperatorRepository.save(busOperator);

        return mapToDto(savedBusSchedule);
    }

    BusOperator mapToEntity(BusOperatorDto busOperatorDto) {
        return mapper.map(busOperatorDto, BusOperator.class);
    }

    BusOperatorDto mapToDto(BusOperator busOperator) {
        return mapper.map(busOperator, BusOperatorDto.class);
    }
}


package com.cenfotec.coffeeshop.service;

import com.cenfotec.coffeeshop.domain.Reserva;
import com.cenfotec.coffeeshop.repository.ReservaRepository;
import com.cenfotec.coffeeshop.service.dto.ReservaDTO;
import com.cenfotec.coffeeshop.service.mapper.ReservaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Reserva.
 */
@Service
@Transactional
public class ReservaService {

    private final Logger log = LoggerFactory.getLogger(ReservaService.class);
    
    @Inject
    private ReservaRepository reservaRepository;

    @Inject
    private ReservaMapper reservaMapper;

    /**
     * Save a reserva.
     *
     * @param reservaDTO the entity to save
     * @return the persisted entity
     */
    public ReservaDTO save(ReservaDTO reservaDTO) {
        log.debug("Request to save Reserva : {}", reservaDTO);
        Reserva reserva = reservaMapper.reservaDTOToReserva(reservaDTO);
        reserva = reservaRepository.save(reserva);
        ReservaDTO result = reservaMapper.reservaToReservaDTO(reserva);
        return result;
    }

    /**
     *  Get all the reservas.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<ReservaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Reservas");
        Page<Reserva> result = reservaRepository.findAll(pageable);
        return result.map(reserva -> reservaMapper.reservaToReservaDTO(reserva));
    }

    /**
     *  Get one reserva by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public ReservaDTO findOne(Long id) {
        log.debug("Request to get Reserva : {}", id);
        Reserva reserva = reservaRepository.findOne(id);
        ReservaDTO reservaDTO = reservaMapper.reservaToReservaDTO(reserva);
        return reservaDTO;
    }

    /**
     *  Delete the  reserva by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Reserva : {}", id);
        reservaRepository.delete(id);
    }
}

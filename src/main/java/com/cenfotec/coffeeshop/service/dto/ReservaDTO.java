package com.cenfotec.coffeeshop.service.dto;

import com.cenfotec.coffeeshop.domain.Reserva;
import com.cenfotec.coffeeshop.domain.ReservaTipo;

import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A DTO for the Reserva entity.
 */
public class ReservaDTO implements Serializable {

    private Long id;

    @NotNull
    private ZonedDateTime fechaEntrega;

    @NotNull
    private Boolean recursivo;

    @NotNull
    private Boolean procesado;

    private Long usuarioId;

    public Set<ReservaTipoDTO> reservasTipos;

    private String usuarioLogin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public ZonedDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(ZonedDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Boolean getRecursivo() {
        return recursivo;
    }

    public void setRecursivo(Boolean recursivo) {
        this.recursivo = recursivo;
    }

    public  Set<ReservaTipoDTO> getReservasTipos() {
        return reservasTipos;
    }

    public void setReservasTipos( Set<ReservaTipoDTO>  reservasTipos) {
        this.reservasTipos = reservasTipos;
    }

    public Boolean getProcesado() {
        return recursivo;
    }

    public void setProcesado(Boolean procesado) {
        this.procesado = procesado;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long userId) {
        this.usuarioId = userId;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String userLogin) {
        this.usuarioLogin = userLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReservaDTO reservaDTO = (ReservaDTO) o;

        if ( ! Objects.equals(id, reservaDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ReservaDTO{" +
            "id=" + id +
            ", fechaEntrega='" + fechaEntrega + "'" +
            ", recursivo='" + recursivo + "'" +
            '}';
    }
}

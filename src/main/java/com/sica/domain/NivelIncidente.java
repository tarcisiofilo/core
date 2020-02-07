package com.sica.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A NivelIncidente.
 */
@Entity
@Table(name = "nivel_incidente")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class NivelIncidente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "notifica_dnpm", nullable = false)
    private Boolean notificaDNPM;

    @NotNull
    @Column(name = "notifica_email", nullable = false)
    private Boolean notificaEmail;

    @NotNull
    @Column(name = "notificacao_sms", nullable = false)
    private Boolean notificacaoSms;

    @NotNull
    @Column(name = "notificacao_whatsapp", nullable = false)
    private Boolean notificacaoWhatsapp;

    @NotNull
    @Column(name = "notificacao_dispositivo_seguranca", nullable = false)
    private Boolean notificacaoDispositivoSeguranca;

    @NotNull
    @Column(name = "notifica_sirene", nullable = false)
    private Boolean notificaSirene;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public NivelIncidente nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean isNotificaDNPM() {
        return notificaDNPM;
    }

    public NivelIncidente notificaDNPM(Boolean notificaDNPM) {
        this.notificaDNPM = notificaDNPM;
        return this;
    }

    public void setNotificaDNPM(Boolean notificaDNPM) {
        this.notificaDNPM = notificaDNPM;
    }

    public Boolean isNotificaEmail() {
        return notificaEmail;
    }

    public NivelIncidente notificaEmail(Boolean notificaEmail) {
        this.notificaEmail = notificaEmail;
        return this;
    }

    public void setNotificaEmail(Boolean notificaEmail) {
        this.notificaEmail = notificaEmail;
    }

    public Boolean isNotificacaoSms() {
        return notificacaoSms;
    }

    public NivelIncidente notificacaoSms(Boolean notificacaoSms) {
        this.notificacaoSms = notificacaoSms;
        return this;
    }

    public void setNotificacaoSms(Boolean notificacaoSms) {
        this.notificacaoSms = notificacaoSms;
    }

    public Boolean isNotificacaoWhatsapp() {
        return notificacaoWhatsapp;
    }

    public NivelIncidente notificacaoWhatsapp(Boolean notificacaoWhatsapp) {
        this.notificacaoWhatsapp = notificacaoWhatsapp;
        return this;
    }

    public void setNotificacaoWhatsapp(Boolean notificacaoWhatsapp) {
        this.notificacaoWhatsapp = notificacaoWhatsapp;
    }

    public Boolean isNotificacaoDispositivoSeguranca() {
        return notificacaoDispositivoSeguranca;
    }

    public NivelIncidente notificacaoDispositivoSeguranca(Boolean notificacaoDispositivoSeguranca) {
        this.notificacaoDispositivoSeguranca = notificacaoDispositivoSeguranca;
        return this;
    }

    public void setNotificacaoDispositivoSeguranca(Boolean notificacaoDispositivoSeguranca) {
        this.notificacaoDispositivoSeguranca = notificacaoDispositivoSeguranca;
    }

    public Boolean isNotificaSirene() {
        return notificaSirene;
    }

    public NivelIncidente notificaSirene(Boolean notificaSirene) {
        this.notificaSirene = notificaSirene;
        return this;
    }

    public void setNotificaSirene(Boolean notificaSirene) {
        this.notificaSirene = notificaSirene;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NivelIncidente)) {
            return false;
        }
        return id != null && id.equals(((NivelIncidente) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "NivelIncidente{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", notificaDNPM='" + isNotificaDNPM() + "'" +
            ", notificaEmail='" + isNotificaEmail() + "'" +
            ", notificacaoSms='" + isNotificacaoSms() + "'" +
            ", notificacaoWhatsapp='" + isNotificacaoWhatsapp() + "'" +
            ", notificacaoDispositivoSeguranca='" + isNotificacaoDispositivoSeguranca() + "'" +
            ", notificaSirene='" + isNotificaSirene() + "'" +
            "}";
    }
}

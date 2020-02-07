package com.sica.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Ativo.
 */
@Entity
@Table(name = "ativo")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Ativo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToOne
    @JoinColumn(unique = true)
    private SetorMineracao setorMineracao;

    @OneToMany(mappedBy = "ativo")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<AreaSusceptivel> areaSusceptivels = new HashSet<>();

    @ManyToMany(mappedBy = "ativos")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Incidente> incidentes = new HashSet<>();

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

    public Ativo nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SetorMineracao getSetorMineracao() {
        return setorMineracao;
    }

    public Ativo setorMineracao(SetorMineracao setorMineracao) {
        this.setorMineracao = setorMineracao;
        return this;
    }

    public void setSetorMineracao(SetorMineracao setorMineracao) {
        this.setorMineracao = setorMineracao;
    }

    public Set<AreaSusceptivel> getAreaSusceptivels() {
        return areaSusceptivels;
    }

    public Ativo areaSusceptivels(Set<AreaSusceptivel> areaSusceptivels) {
        this.areaSusceptivels = areaSusceptivels;
        return this;
    }

    public Ativo addAreaSusceptivel(AreaSusceptivel areaSusceptivel) {
        this.areaSusceptivels.add(areaSusceptivel);
        areaSusceptivel.setAtivo(this);
        return this;
    }

    public Ativo removeAreaSusceptivel(AreaSusceptivel areaSusceptivel) {
        this.areaSusceptivels.remove(areaSusceptivel);
        areaSusceptivel.setAtivo(null);
        return this;
    }

    public void setAreaSusceptivels(Set<AreaSusceptivel> areaSusceptivels) {
        this.areaSusceptivels = areaSusceptivels;
    }

    public Set<Incidente> getIncidentes() {
        return incidentes;
    }

    public Ativo incidentes(Set<Incidente> incidentes) {
        this.incidentes = incidentes;
        return this;
    }

    public Ativo addIncidente(Incidente incidente) {
        this.incidentes.add(incidente);
        incidente.getAtivos().add(this);
        return this;
    }

    public Ativo removeIncidente(Incidente incidente) {
        this.incidentes.remove(incidente);
        incidente.getAtivos().remove(this);
        return this;
    }

    public void setIncidentes(Set<Incidente> incidentes) {
        this.incidentes = incidentes;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ativo)) {
            return false;
        }
        return id != null && id.equals(((Ativo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Ativo{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            "}";
    }
}

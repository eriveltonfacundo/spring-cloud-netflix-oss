package com.cloud.fiscalservice.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SITUACAO_FISCAL")
@Getter @Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor @AllArgsConstructor
public class SituacaoFiscal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SITUACAO_FISCAL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "SITUACAO_FISCAL_DESCRICAO", nullable = false)
    private String descricao;

    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    private Date createdDate;

    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @PrePersist
    public void onPrePersist() {
        id = null;
        createdDate = new Date();
    }

    @PreUpdate
    public void onPreUpdate() {
        updatedDate = new Date();
    }
}
package com.cloud.productservice.entities;

import com.cloud.productservice.validators.VerifyExistenceSituacaoFiscal;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PRODUTO")
@Getter @Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor @AllArgsConstructor
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PRODUTO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "PRODUTO_DESCRICAO", nullable = false)
    private String descricao;

    @JoinColumn(columnDefinition = "SECAO_ID", referencedColumnName = "SECAO_ID", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Secao secao;

    @VerifyExistenceSituacaoFiscal
    @Column(name = "SITUACAO_FISCAL_ID", nullable = false)
    private Long situacaoFiscalId;

    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    private Date createdDate;

    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DELETED_DATE")
    private Date deletedDate;

    @PrePersist
    public void onPrePersist() {
        setId(null);
        createdDate = new Date();
    }

    @PreUpdate
    public void onPreUpdate() {
        updatedDate = new Date();
    }

    @PreRemove
    public void onPreRemove() {
        deletedDate = new Date();
    }
}

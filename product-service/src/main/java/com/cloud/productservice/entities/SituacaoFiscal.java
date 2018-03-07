package com.cloud.productservice.entities;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor @AllArgsConstructor
public class SituacaoFiscal implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String descricao;

    private Date createdDate;

    private Date updatedDate;

    private Date deletedDate;

}
package com.fst.sir.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fst.sir.enums.TypePaiment;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Paiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String reference;

    private double prix;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date payedAt;

    @OneToOne
    private Panier panier;

    @Enumerated(EnumType.STRING)
    private TypePaiment typePaiment;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Paiment paiment = (Paiment) o;
        return id != null && Objects.equals(id, paiment.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

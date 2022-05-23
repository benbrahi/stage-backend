package com.fst.sir.service.client.facade;

import com.fst.sir.bean.Paiment;
import com.fst.sir.enums.TypePaiment;

import java.util.List;

public interface PaimentClientService {
    List<Paiment> findAll();


    List<Paiment> findByTypePaiment(TypePaiment typePaiment);

    List<Paiment> findByPanierUserUsername(String username);

    Paiment findByReference(String reference);

    int deleteByReference(String reference);

    Paiment save(Paiment paiment);

    Paiment update(Paiment paiment);


}

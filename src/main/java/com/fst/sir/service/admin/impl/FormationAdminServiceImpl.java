package com.fst.sir.service.admin.impl;

import com.fst.sir.bean.Formation;
import com.fst.sir.dao.FormationDao;
import com.fst.sir.service.admin.facade.FormationAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FormationAdminServiceImpl implements FormationAdminService {

    @Autowired
    private FormationDao formationDao;

    @Override
    public Formation save(Formation formation) {
        Formation entity = findByNom(formation.getNom());
        if (entity != null) {
            return null;
        } else {
            formation.setAddedAt(new Date());
            return formationDao.save(formation);
        }
    }


    @Override
    public List<Formation> findAll() {
        return formationDao.findAll();
    }

    @Override
    public Formation update(Formation formation) {
        Formation formation1 = findByNom(formation.getNom());
        if (formation1 != null) {
            formation.setUpdatedAt(new Date());
            formation.setAddedAt(formation1.getAddedAt());
            formation.setId(formation1.getId());
            return formationDao.save(formation);
        } else return null;
    }

    @Override
    public Formation findByNom(String nom) {
        return formationDao.findByNom(nom);
    }

    @Override
    public int deleteByNom(String nom) {
        return formationDao.deleteByNom(nom);
    }

    @Override
    public List<Formation> findByEncadrantProf(String encadrant) {
        return formationDao.findByEncadrantProf(encadrant);
    }


}

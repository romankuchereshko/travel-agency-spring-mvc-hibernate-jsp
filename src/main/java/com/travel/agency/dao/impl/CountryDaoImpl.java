package com.travel.agency.dao.impl;

import com.travel.agency.dao.CountryDao;
import com.travel.agency.model.Country;
import com.travel.agency.model.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {
    private final SessionFactory sessionFactory;

    public CountryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Country findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Country.class, id);
    }

    @Override
    public Country findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Country country WHERE name =: name", Country.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<Country> getAllCountries() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Country", Country.class)
                .getResultList();
    }

    @Override
    public List<Hotel> getAllHotelsInCountry(String country) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Hotel h WHERE country =: country", Hotel.class)
                .setParameter("country", country)
                .getResultList();
    }
}

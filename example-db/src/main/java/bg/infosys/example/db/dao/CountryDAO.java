package bg.infosys.example.db.dao;

import org.springframework.stereotype.Repository;

import bg.infosys.common.db.dao.GenericDAOImpl;
import bg.infosys.example.db.entity.Country;

@Repository
public class CountryDAO extends GenericDAOImpl<Country, String> {

}

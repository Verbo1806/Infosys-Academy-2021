package bg.infosys.example.db.dao;

import org.springframework.stereotype.Repository;

import bg.infosys.common.db.dao.GenericDAOImpl;
import bg.infosys.example.db.entity.League;

@Repository
public class LeagueDAO extends GenericDAOImpl<League, Long> {

}

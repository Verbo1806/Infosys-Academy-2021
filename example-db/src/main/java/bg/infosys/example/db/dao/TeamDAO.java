package bg.infosys.example.db.dao;

import org.springframework.stereotype.Repository;

import bg.infosys.common.db.dao.GenericDAOImpl;
import bg.infosys.example.db.entity.Team;

@Repository
public class TeamDAO extends GenericDAOImpl<Team, Long> {

}

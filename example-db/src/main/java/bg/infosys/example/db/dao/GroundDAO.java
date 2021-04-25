package bg.infosys.example.db.dao;

import org.springframework.stereotype.Repository;

import bg.infosys.common.db.dao.GenericDAOImpl;
import bg.infosys.example.db.entity.Ground;

@Repository
public class GroundDAO extends GenericDAOImpl<Ground, Long> {

}

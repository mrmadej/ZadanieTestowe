package EpolIt.ZadanieTestowe.dao;

import EpolIt.ZadanieTestowe.entity.SvConf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SvConfRepository extends JpaRepository<SvConf, Integer> {
    SvConf findByAttrName(String attrName);
}

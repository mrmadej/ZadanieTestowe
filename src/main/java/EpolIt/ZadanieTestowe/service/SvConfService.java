package EpolIt.ZadanieTestowe.service;

import EpolIt.ZadanieTestowe.dao.SvConfRepository;
import EpolIt.ZadanieTestowe.entity.SvConf;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SvConfService {
    private SvConfRepository svConfRepository;

    @Autowired
    public SvConfService(SvConfRepository svConfRepository) {
        this.svConfRepository = svConfRepository;
    }

    private boolean svConfIsNotEmpty(SvConf svConf) {
        return !svConf.getAttrName().isEmpty() && !svConf.getAttrValue().isEmpty() && !svConf.getAttrDesc().isEmpty();
    }
    private boolean svConfProperLength(SvConf svConf) {
        return svConf.getAttrName().length() <= 25 && svConf.getAttrValue().length() <= 25 && svConf.getAttrDesc().length() <= 50;
    }
    private boolean svConfIsNotInDatabase(SvConf svConf) {
        return findByAttrName(svConf.getAttrName()) == null;
    }
    @Transactional
    public int save(SvConf svConf) {
        if(svConfIsNotEmpty(svConf))
        {
            if(svConfProperLength(svConf)) {
                if(svConfIsNotInDatabase(svConf)) {
                    System.out.println(svConf);
                    svConfRepository.save(svConf);
                    return 0;
                }
                return 400;
            }
            return 400;
        }
        return 400;
    }
    public SvConf findByAttrName(String attrName) {
        return svConfRepository.findByAttrName(attrName);
    }
    @Transactional
    public int delete(String attrName) {
        SvConf toDelete = svConfRepository.findByAttrName(attrName);
        if(toDelete != null) {
            svConfRepository.delete(toDelete);
            return 0;
        }
        return 404;
    }
    @Transactional
    public int update(SvConf svConf) {
        if (svConfIsNotEmpty(svConf)) {
            if (svConfProperLength(svConf)) {
                if (!svConfIsNotInDatabase(svConf)) {
                    svConfRepository.save(svConf);
                    return 0;
                }
                return 404;
            }
            return 400;
        }
        return 400;
    }
}

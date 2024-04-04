package EpolIt.ZadanieTestowe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sv_conf")
public class SvConf {
    @Id
    @Column(name = "attr_name")
    private String attrName;
    @Column(name = "attr_value")
    private String attrValue;
    @Column(name = "attr_desc")
    private String attrDesc;

    public SvConf() {
    }

    public SvConf(String attrName, String attrValue, String attrDesc) {
        this.attrName = attrName;
        this.attrValue = attrValue;
        this.attrDesc = attrDesc;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getAttrDesc() {
        return attrDesc;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc;
    }
}

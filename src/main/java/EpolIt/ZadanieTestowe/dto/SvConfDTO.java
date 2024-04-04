package EpolIt.ZadanieTestowe.dto;

public class SvConfDTO {
    private String attr_name;
    private String attr_value;
    private String attr_desc;

    public SvConfDTO() {
    }

    public SvConfDTO(String attr_name, String attr_value, String attr_desc) {
        this.attr_name = attr_name;
        this.attr_value = attr_value;
        this.attr_desc = attr_desc;
    }

    public String getAttr_name() {
        return attr_name;
    }

    public void setAttr_name(String attr_name) {
        this.attr_name = attr_name;
    }

    public String getAttr_value() {
        return attr_value;
    }

    public void setAttr_value(String attr_value) {
        this.attr_value = attr_value;
    }

    public String getAttr_desc() {
        return attr_desc;
    }

    public void setAttr_desc(String attr_desc) {
        this.attr_desc = attr_desc;
    }
}

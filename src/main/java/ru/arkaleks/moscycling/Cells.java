package ru.arkaleks.moscycling;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cells {


    private int cell_id;
    private String name;
    private String objectOperOrgPhone;

    @JsonProperty("global_id")
    public int getCell_id() {
        return cell_id;
    }

    public void setCell_id(int cell_id) {
        this.cell_id = cell_id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectOperOrgPhone() {
        return objectOperOrgPhone;
    }

    public void setObjectOperOrgPhone(String objectOperOrgPhone) {
        this.objectOperOrgPhone = objectOperOrgPhone;
    }
}

package ru.arkaleks.moscycling;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cells {


    private int cell_id;
    private String name;
    private String objectOperOrgPhone;
    private String[] type;
    private double width;
    private String location;
    private GeoData geoData;
    private String departamentalAffiliation;
    private String operOrgName;
    private String portionName;


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

    @JsonProperty("ObjectOperOrgPhone")
    public String getObjectOperOrgPhone() {
        return objectOperOrgPhone;
    }

    public void setObjectOperOrgPhone(String objectOperOrgPhone) {
        this.objectOperOrgPhone = objectOperOrgPhone;
    }

    @JsonProperty("Type")
    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    @JsonProperty("Width")
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @JsonProperty("Location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("geoData")
    public GeoData getGeoData() {
        return geoData;
    }

    public void setGeoData(GeoData geoData) {
        this.geoData = geoData;
    }

    @JsonProperty("DepartamentalAffiliation")
    public String getDepartamentalAffiliation() {
        return departamentalAffiliation;
    }

    public void setDepartamentalAffiliation(String departamentalAffiliation) {
        this.departamentalAffiliation = departamentalAffiliation;
    }

    @JsonProperty("OperOrgName")
    public String getOperOrgName() {
        return operOrgName;
    }

    public void setOperOrgName(String operOrgName) {
        this.operOrgName = operOrgName;
    }

    @JsonProperty("PortionName")
    public String getPortionName() {
        return portionName;
    }

    public void setPortionName(String portionName) {
        this.portionName = portionName;
    }
}

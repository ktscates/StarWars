
package com.example.starwars;


import java.util.List;

public class Datum {
    private Integer id;
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String wiki;
    private String image;
    private Integer born;
    private String bornLocation;
    private Integer died;
    private String diedLocation;
    private String species;
    private String hairColor;
    private String eyeColor;
    private String skinColor;
    private String cybernetics;
    private List<String> affiliations = null;
    //    private List<String> masters = null;
//    private List<String> apprentices = null;
//    private List<String> formerAffiliations = null;
    private Integer dateCreated;
    private Integer dateDestroyed;
    private String destroyedLocation;
    private String creator;
    private String manufacturer;
    private String model;
    private String _class;
    private String sensorColor;
    private String platingColor;
    //    private List<String> equipment = null;
    private String productLine;
    private String kajidic;
    //    private List<String> era = null;
    private String degree;
    private String armament;

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum() {
    }

    /**
     //     *
     * @param armament
     * @param homeworld
     * @param gender
     * @param cybernetics
     * @param skinColor
     * @param mass
     * @param wiki
    //     * @param affiliations
    //     * @param masters
     * @param died
    //     * @param formerAffiliations
     * @param sensorColor
     * @param kajidic
     * @param manufacturer
     * @param productLine
     * @param dateCreated
     * @param eyeColor
    //     * @param era
     * @param model
     * @param id
     * @param hairColor
     * @param height
     * @param destroyedLocation
     * @param image
     * @param creator
     * @param born
     * @param degree
     * @param diedLocation
    //     * @param equipment
     * @param platingColor
     * @param bornLocation
     * @param species
     * @param name
     * @param _class
    //     * @param apprentices
     * @param dateDestroyed
     */

// List<String> affiliations,
    public Datum(Integer id, String name, Integer height, Integer mass, String gender, String homeworld, String wiki, String image, Integer born, String bornLocation, Integer died, String diedLocation, String species, String hairColor, String eyeColor, String skinColor, String cybernetics, Integer dateCreated, Integer dateDestroyed, String destroyedLocation, String creator, String manufacturer, String model, String _class, String sensorColor, String platingColor, String productLine, String kajidic, String degree, String armament) {
        super();
        this.id = id;
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.wiki = wiki;
        this.image = image;
        this.born = born;
        this.bornLocation = bornLocation;
        this.died = died;
        this.diedLocation = diedLocation;
        this.species = species;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.skinColor = skinColor;
        this.cybernetics = cybernetics;
//        this.affiliations = affiliations;
//        this.masters = masters;
//        this.apprentices = apprentices;
//        this.formerAffiliations = formerAffiliations;
        this.dateCreated = dateCreated;
        this.dateDestroyed = dateDestroyed;
        this.destroyedLocation = destroyedLocation;
        this.creator = creator;
        this.manufacturer = manufacturer;
        this.model = model;
        this._class = _class;
        this.sensorColor = sensorColor;
        this.platingColor = platingColor;
//        this.equipment = equipment;
        this.productLine = productLine;
        this.kajidic = kajidic;
//        this.era = era;
        this.degree = degree;
        this.armament = armament;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getBorn() {
        return born;
    }

    public void setBorn(Integer born) {
        this.born = born;
    }

    public String getBornLocation() {
        return bornLocation;
    }

    public void setBornLocation(String bornLocation) {
        this.bornLocation = bornLocation;
    }

    public Integer getDied() {
        return died;
    }

    public void setDied(Integer died) {
        this.died = died;
    }

    public String getDiedLocation() {
        return diedLocation;
    }

    public void setDiedLocation(String diedLocation) {
        this.diedLocation = diedLocation;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getCybernetics() {
        return cybernetics;
    }

    public void setCybernetics(String cybernetics) {
        this.cybernetics = cybernetics;
    }

//    public List<String> getAffiliations() {
//        return affiliations;
//    }
//
//    public void setAffiliations(List<String> affiliations) {
//        this.affiliations = affiliations;
//    }

//    public List<String> getMasters() {
//        return masters;
//    }
//
//    public void setMasters(List<String> masters) {
//        this.masters = masters;
//    }
//
//    public List<String> getApprentices() {
//        return apprentices;
//    }
//
//    public void setApprentices(List<String> apprentices) {
//        this.apprentices = apprentices;
//    }
//
//    public List<String> getFormerAffiliations() {
//        return formerAffiliations;
//    }
//
//    public void setFormerAffiliations(List<String> formerAffiliations) {
//        this.formerAffiliations = formerAffiliations;
//    }

    public Integer getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Integer dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getDateDestroyed() {
        return dateDestroyed;
    }

    public void setDateDestroyed(Integer dateDestroyed) {
        this.dateDestroyed = dateDestroyed;
    }

    public String getDestroyedLocation() {
        return destroyedLocation;
    }

    public void setDestroyedLocation(String destroyedLocation) {
        this.destroyedLocation = destroyedLocation;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getSensorColor() {
        return sensorColor;
    }

    public void setSensorColor(String sensorColor) {
        this.sensorColor = sensorColor;
    }

    public String getPlatingColor() {
        return platingColor;
    }

    public void setPlatingColor(String platingColor) {
        this.platingColor = platingColor;
    }

//    public List<String> getEquipment() {
//        return equipment;
//    }
//
//    public void setEquipment(List<String> equipment) {
//        this.equipment = equipment;
//    }
//
    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getKajidic() {
        return kajidic;
    }

    public void setKajidic(String kajidic) {
        this.kajidic = kajidic;
    }

//    public List<String> getEra() {
//        return era;
//    }
//
//    public void setEra(List<String> era) {
//        this.era = era;
//    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getArmament() {
        return armament;
    }

    public void setArmament(String armament) {
        this.armament = armament;
    }

}

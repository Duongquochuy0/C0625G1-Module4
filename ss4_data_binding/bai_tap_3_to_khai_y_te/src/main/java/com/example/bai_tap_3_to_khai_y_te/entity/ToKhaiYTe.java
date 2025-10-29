package com.example.bai_tap_3_to_khai_y_te.entity;

public class ToKhaiYTe {
    private String fullName;
    private int yearOfBirth;
    private String gender;
    private String nationality;
    private String idCard;
    private String vehicle;
    private String vehicleNumber;
    private String seatNumber;
    private String departureDay;
    private String endDay;
    private String visitedPlaces;
    private String city;
    private String district;
    private String ward;
    private String address;
    private String phone;
    private String email;
    private boolean fever;
    private boolean cough;
    private boolean soreThroat;
    private boolean shortnessOfBreath;
    private boolean nausea;
    private boolean diarrhea;
    private boolean skinHemorrhage;
    private boolean rash;
    private boolean contactWithPatient;
    private boolean contactWithFeverPerson;
    private boolean contactWithForeign;

    public ToKhaiYTe(String fullName, int yearOfBirth, String gender, String nationality, String idCard, String vehicle, String vehicleNumber, String seatNumber, String departureDay, String endDay, String visitedPlaces, String city, String district, String ward, String address, String phone, String email, boolean fever, boolean cough, boolean soreThroat, boolean shortnessOfBreath, boolean nausea, boolean diarrhea, boolean skinHemorrhage, boolean rash, boolean contactWithPatient, boolean contactWithFeverPerson, boolean contactWithForeign) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.departureDay = departureDay;
        this.endDay = endDay;
        this.visitedPlaces = visitedPlaces;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.fever = fever;
        this.cough = cough;
        this.soreThroat = soreThroat;
        this.shortnessOfBreath = shortnessOfBreath;
        this.nausea = nausea;
        this.diarrhea = diarrhea;
        this.skinHemorrhage = skinHemorrhage;
        this.rash = rash;
        this.contactWithPatient = contactWithPatient;
        this.contactWithFeverPerson = contactWithFeverPerson;
        this.contactWithForeign = contactWithForeign;
    }

    public ToKhaiYTe() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getVisitedPlaces() {
        return visitedPlaces;
    }

    public void setVisitedPlaces(String visitedPlaces) {
        this.visitedPlaces = visitedPlaces;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isShortnessOfBreath() {
        return shortnessOfBreath;
    }

    public void setShortnessOfBreath(boolean shortnessOfBreath) {
        this.shortnessOfBreath = shortnessOfBreath;
    }

    public boolean isNausea() {
        return nausea;
    }

    public void setNausea(boolean nausea) {
        this.nausea = nausea;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isSkinHemorrhage() {
        return skinHemorrhage;
    }

    public void setSkinHemorrhage(boolean skinHemorrhage) {
        this.skinHemorrhage = skinHemorrhage;
    }

    public boolean isRash() {
        return rash;
    }

    public void setRash(boolean rash) {
        this.rash = rash;
    }

    public boolean isContactWithPatient() {
        return contactWithPatient;
    }

    public void setContactWithPatient(boolean contactWithPatient) {
        this.contactWithPatient = contactWithPatient;
    }

    public boolean isContactWithFeverPerson() {
        return contactWithFeverPerson;
    }

    public void setContactWithFeverPerson(boolean contactWithFeverPerson) {
        this.contactWithFeverPerson = contactWithFeverPerson;
    }

    public boolean isContactWithForeign() {
        return contactWithForeign;
    }

    public void setContactWithForeign(boolean contactWithForeign) {
        this.contactWithForeign = contactWithForeign;
    }
}

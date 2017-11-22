package io.mauth.fakefood.dto;

import io.mauth.fakefood.enums.PurchasePlaceEnum;
import io.mauth.fakefood.enums.RequestStatus;
import io.mauth.fakefood.model.Audit;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by rahulb on 4/11/17.
 */
public class AuditDto implements Serializable{


    private Long id; // It will be stored in the local db, just tells the request made by the user
    private Long dbId;  // In the server DB
    private String androidId;
    private RequestStatus status;
    private String name;
    private Long companyId;
    private String size;
    private String flavour;
    private PurchasePlaceEnum purchasePlaceEnum;
    private String placeOfPurchase;
    private String lotNumber;
    private Date expirationDate;
    private String barCode;
    private String  frontCanisterImage;
    private String backCanisterImage;
    private String logoImage;

    public AuditDto() {
    }

    public AuditDto(Long id) {
        this.id = id;
        this.dbId = id+1;
        this.status=RequestStatus.FAKE;
        this.name="Yo";
        this.companyId =23L;
        this.size="fuck YOU";
        this.flavour="ASS HOEL";
        this.purchasePlaceEnum=PurchasePlaceEnum.OFFLINE;
        this.placeOfPurchase="Indiranagar";
        this.lotNumber="skfhkdsa34324";
        this.expirationDate = new Date();
        this.barCode = "FDSAFDSAR#WQ%RWQAEDS";

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public Long getDbId() {
        return dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public PurchasePlaceEnum getPurchasePlaceEnum() {
        return purchasePlaceEnum;
    }

    public void setPurchasePlaceEnum(PurchasePlaceEnum purchasePlaceEnum) {
        this.purchasePlaceEnum = purchasePlaceEnum;
    }

    public String getPlaceOfPurchase() {
        return placeOfPurchase;
    }

    public void setPlaceOfPurchase(String placeOfPurchase) {
        this.placeOfPurchase = placeOfPurchase;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getFrontCanisterImage() {
        return frontCanisterImage;
    }

    public void setFrontCanisterImage(String frontCanisterImage) {
        this.frontCanisterImage = frontCanisterImage;
    }

    public String getBackCanisterImage() {
        return backCanisterImage;
    }

    public void setBackCanisterImage(String backCanisterImage) {
        this.backCanisterImage = backCanisterImage;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }

    public Audit toAudit(){
        return new Audit(this.androidId,
                this.status,
                this.name,
                this.companyId,
                this.size,
                this.flavour,
                this.purchasePlaceEnum,
                this.placeOfPurchase,
                this.lotNumber,
                this.expirationDate,
                this.barCode,
                this.frontCanisterImage,
                this.backCanisterImage,
                this.logoImage);
    }
}

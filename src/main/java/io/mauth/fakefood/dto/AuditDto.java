package io.mauth.fakefood.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.mauth.fakefood.enums.FoodType;
import io.mauth.fakefood.enums.PurchasePlaceEnum;
import io.mauth.fakefood.enums.RequestStatus;
import io.mauth.fakefood.model.Audit;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by rahulb on 4/11/17.
 */
public class AuditDto implements Serializable{


    private Long id; // It will be stored in the local db, just tells the request made by the user
    private Long dbId;  // In the server DB
    @NotNull
    private String androidId;
    @NotNull
    private RequestStatus status;
    @NotNull
    private String name;
    @NotNull
    private Long productId;
    @NotNull
    private Long companyId;
    @NotNull
    private String company;
    @NotNull
    private String size;
    @NotNull
    private String flavour;
    @NotNull
    private PurchasePlaceEnum purchasePlaceEnum;
    @NotNull
    private String placeOfPurchase;
    @NotNull
    private String lotNumber;
    @NotNull
    private FoodType foodType;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date expirationDate;
    @NotNull
    private String barCode;
    @NotNull
    private String frontImageName;
    @NotNull
    private String backImageName;
    @NotNull
    private String logoImageName;

    public AuditDto() {
    }

    public Long getId() {
        return id;
    }

    public AuditDto setId(Long id) {
        this.id = id;
        return this;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public String getAndroidId() {
        return androidId;
    }

    public AuditDto setAndroidId(String androidId) {
        this.androidId = androidId;
        return this;
    }

    public Long getDbId() {
        return dbId;
    }

    public AuditDto setDbId(Long dbId) {
        this.dbId = dbId;
        return this;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public AuditDto setStatus(RequestStatus status) {
        this.status = status;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuditDto setName(String name) {
        this.name = name;
        return this;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public AuditDto setCompanyId(Long companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSize() {
        return size;
    }

    public AuditDto setSize(String size) {
        this.size = size;
        return this;
    }

    public String getFlavour() {
        return flavour;
    }

    public AuditDto setFlavour(String flavour) {
        this.flavour = flavour;
        return this;
    }

    public PurchasePlaceEnum getPurchasePlaceEnum() {
        return purchasePlaceEnum;
    }

    public AuditDto setPurchasePlaceEnum(PurchasePlaceEnum purchasePlaceEnum) {
        this.purchasePlaceEnum = purchasePlaceEnum;
        return this;
    }

    public String getPlaceOfPurchase() {
        return placeOfPurchase;
    }

    public AuditDto setPlaceOfPurchase(String placeOfPurchase) {
        this.placeOfPurchase = placeOfPurchase;
        return this;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public AuditDto setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
        return this;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public AuditDto setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public String getBarCode() {
        return barCode;
    }

    public AuditDto setBarCode(String barCode) {
        this.barCode = barCode;
        return this;
    }

    public String getFrontImageName() {
        return frontImageName;
    }

    public AuditDto setFrontImageName(String frontImageName) {
        this.frontImageName = frontImageName;
        return this;
    }

    public String getBackImageName() {
        return backImageName;
    }

    public AuditDto setBackImageName(String backImageName) {
        this.backImageName = backImageName;
        return this;
    }

    public String getLogoImageName() {
        return logoImageName;
    }

    public AuditDto setLogoImageName(String logoImageName) {
        this.logoImageName = logoImageName;
        return this;
    }

    public Audit toAudit(){
        return new Audit(this.androidId,
                this.status,
                this.name,
                this.companyId,
                this.productId,
                this.size,
                this.flavour,
                this.purchasePlaceEnum,
                this.placeOfPurchase,
                this.lotNumber,
                this.expirationDate,
                this.barCode,
                this.frontImageName,
                this.backImageName,
                this.logoImageName);
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}

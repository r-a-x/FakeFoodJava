package io.mauth.fakefood.model;

import io.mauth.fakefood.dto.AuditDto;
import io.mauth.fakefood.enums.PurchasePlaceEnum;
import io.mauth.fakefood.enums.RequestStatus;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by rahulb on 4/11/17.
 */

@Entity
@DynamicUpdate
@Table(name = "audit_requests")
public class Audit implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id; // It will be stored in the local db, just tells the request made by the user

    @Column(name = "android_id")
    private String androidId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @Column(name = "name")
    private String name;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "size")
    private String size;

    @Column(name = "flavour")
    private String flavour;

    @Column(name = "purchase_place_type")
    @Enumerated(EnumType.STRING)
    private PurchasePlaceEnum purchasePlaceEnum;

    @Column(name = "place_of_purchase")
    private String placeOfPurchase;

    @Column(name = "lot_number")
    private String lotNumber;

// 2017-10-04 12:12:00
    @Column(name = "expiration_date")

    private Date expirationDate;

    @Column(name = "barcode")
    private String barCode;

    @Column(name ="front_canister_image")
    private String frontCanisterImage;

    @Column(name = "back_canister_image")
    private String backCanisterImage;

    @Column(name = "logo_image")
    private String logoImage;

    public Audit() {
    }

    public Audit(String androidId, RequestStatus status, String name, Long companyId, String size, String flavour, PurchasePlaceEnum purchasePlaceEnum, String placeOfPurchase, String lotNumber, Date expirationDate, String barCode, String frontCanisterImage, String backCanisterImage, String logoImage) {
        this.androidId = androidId;
        this.status = status;
        this.name = name;
        this.companyId = companyId;
        this.size = size;
        this.flavour = flavour;
        this.purchasePlaceEnum = purchasePlaceEnum;
        this.placeOfPurchase = placeOfPurchase;
        this.lotNumber = lotNumber;
        this.expirationDate = expirationDate;
        this.barCode = barCode;
        this.frontCanisterImage = frontCanisterImage;
        this.backCanisterImage = backCanisterImage;
        this.logoImage = logoImage;
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

    public AuditDto toAuditDto(){
        return new AuditDto()
                .setStatus(this.getStatus())
                .setAndroidId(this.getAndroidId())
                .setFlavour(this.getFlavour())
                .setBarCode(this.getBarCode())
                .setExpirationDate(this.getExpirationDate())
                .setId(this.getId())
                .setFrontCanisterImage(this.getFrontCanisterImage())
                .setCompanyId(this.getCompanyId())
                .setLotNumber(this.getLotNumber())
                .setName(this.getName())
                .setPlaceOfPurchase(this.getPlaceOfPurchase())
                .setSize(this.getSize());

    }
}

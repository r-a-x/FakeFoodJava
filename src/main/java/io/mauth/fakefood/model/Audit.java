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

    @Column(name = "product_id")
    private Long productId;

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
    private String frontCanisterImageName;

    @Column(name = "back_canister_image")
    private String backCanisterImageName;

    @Column(name = "logo_image")
    private String logoImageName;

    public Audit() {
    }
    public Audit(String androidId, RequestStatus status, String name, Long companyId, Long productId, String size, String flavour, PurchasePlaceEnum purchasePlaceEnum, String placeOfPurchase, String lotNumber, Date expirationDate, String barCode, String frontImageName, String backImageName, String logoImageName) {
        this.androidId = androidId;
        this.status = status;
        this.name = name;
        this.productId = productId;
        this.companyId = companyId;
        this.size = size;
        this.flavour = flavour;
        this.purchasePlaceEnum = purchasePlaceEnum;
        this.placeOfPurchase = placeOfPurchase;
        this.lotNumber = lotNumber;
        this.expirationDate = expirationDate;
        this.barCode = barCode;
        this.frontCanisterImageName = frontImageName;
        this.backCanisterImageName = backImageName;
        this.logoImageName = logoImageName;
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

    public String getFrontCanisterImageName() {
        return frontCanisterImageName;
    }

    public void setFrontCanisterImageName(String frontCanisterImageName) {
        this.frontCanisterImageName = frontCanisterImageName;
    }

    public String getBackCanisterImageName() {
        return backCanisterImageName;
    }

    public void setBackCanisterImageName(String backCanisterImageName) {
        this.backCanisterImageName = backCanisterImageName;
    }

    public String getLogoImageName() {
        return logoImageName;
    }

    public void setLogoImageName(String logoImageName) {
        this.logoImageName = logoImageName;
    }

    public AuditDto toAuditDto(){

        return new AuditDto()
                .setStatus(this.getStatus())
                .setAndroidId(this.getAndroidId())
                .setFlavour(this.getFlavour())
                .setBarCode(this.getBarCode())
                .setExpirationDate(this.getExpirationDate())
                .setId(this.getId())
                .setFrontImageName(this.getFrontCanisterImageName())
                .setBackImageName(this.getBackCanisterImageName())
                .setLogoImageName(this.getLogoImageName())
                .setCompanyId(this.getCompanyId())
                .setLotNumber(this.getLotNumber())
                .setName(this.getName())
                .setPlaceOfPurchase(this.getPlaceOfPurchase())
                .setSize(this.getSize());

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}

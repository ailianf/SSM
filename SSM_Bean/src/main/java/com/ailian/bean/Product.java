package com.ailian.bean;

import com.ailian.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品信息实体类
 */
public class Product implements Serializable {

    private String code; // 无意义，主键UUID
    private String productNum; // 产品编号，唯一，不为空
    private String productName; // 产品名称（路线名称）
    private String cityName;   // 出发城市

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime; // 出发时间
    private String departureTimeStr;
    private double productPrice;   // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus;  // 状态（0 关闭 1开启）
    private String productStatusStr;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        return DateUtils.date2Str(departureTime, "yyyy-MM-dd HH:mm:ss");
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        return productStatus == 0 ? "关闭" : "开启";
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }
}

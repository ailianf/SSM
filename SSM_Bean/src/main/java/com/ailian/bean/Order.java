package com.ailian.bean;

import com.ailian.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单信息实体类
 */
public class Order implements Serializable {

    private String code; // 主键
    private String orderNum; // 订单编号 不为空 唯一
    private Date orderTime; // 下单时间
    private String orderTimeStr;
    private Integer peopleCount; // 出行人数
    private String orderDesc; // 订单描述（其他信息）
    private Integer payType; // 支付方式 0：支付宝，1：微信；2：其他
    private String payTypeStr;
    private Integer orderStatus; // 订单状态 0：未支付；1：已支付 2：已取消
    private String orderStatusStr;

    private Product product;
    private Member member;

    public Order() {
    }

    private List<Traveller> travellers;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        return DateUtils.date2Str(orderTime, "yyyy-MM-dd HH:mm:ss");
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        // 支付方式 0：支付宝，1：微信；2：其他
        if (payType != null) {
            if (payType == 0) {
                payTypeStr = "支付宝";
            }
            if (payType == 1) {
                payTypeStr = "微信";
            }
            if (payType == 2) {
                payTypeStr = "其他";
            }
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        // 订单状态 0：未支付；1：已支付 2：已取消
        if (orderStatus != null) {
            if (orderStatus == 0) {
                orderStatusStr = "未支付";
            } else if (orderStatus == 1) {
                orderStatusStr = "已支付";
            } else if (orderStatus == 2) {
                orderStatusStr = "已取消";
            }
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "code='" + code + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", product=" + product +
                ", member=" + member +
                ", travellers=" + travellers +
                '}';
    }
}

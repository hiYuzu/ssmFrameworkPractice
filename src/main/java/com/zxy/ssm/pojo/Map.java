package com.zxy.ssm.pojo;

import com.zxy.ssm.util.DefaultArgument;

import java.util.Date;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description
 * @date 2019/3/5 9:58
 */
public class Map extends BasePojo {
    private long id;
    private String deviceName;
    private Double lng = DefaultArgument.DOUBLE_DEFAULT;
    private Double lat = DefaultArgument.DOUBLE_DEFAULT;
    private Integer temp;
    private Integer hum;
    private Double acceleX = DefaultArgument.DOUBLE_DEFAULT;
    private Double acceleY = DefaultArgument.DOUBLE_DEFAULT;
    private Double acceleZ = DefaultArgument.DOUBLE_DEFAULT;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getHum() {
        return hum;
    }

    public void setHum(Integer hum) {
        this.hum = hum;
    }

    public Double getAcceleX() {
        return acceleX;
    }

    public void setAcceleX(Double acceleX) {
        this.acceleX = acceleX;
    }

    public Double getAcceleY() {
        return acceleY;
    }

    public void setAcceleY(Double acceleY) {
        this.acceleY = acceleY;
    }

    public Double getAcceleZ() {
        return acceleZ;
    }

    public void setAcceleZ(Double acceleZ) {
        this.acceleZ = acceleZ;
    }

}

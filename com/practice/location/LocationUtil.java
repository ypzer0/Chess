package com.practice.location;

import com.practice.constant.CommonConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨鹏
 * 定义了棋盘落子的位置
 *
 */
public class LocationUtil {

    private  List<Integer> locationXList = new ArrayList<>();

    private  List<Integer> locationYList = new ArrayList<>();

    private static final int Max_X = 9;

    private static final int Max_Y = 10;

    public LocationUtil(){
        Integer x = CommonConstant.originLocationX;
        Integer y = CommonConstant.originLocationY;
        for (int i = 0; i < Max_X; i++) {
            locationXList.add(x);
            x+=CommonConstant.CELL;
        }

        for (int i = 0; i < Max_Y; i++) {
            locationYList.add(y);
            y+=CommonConstant.CELL;
        }
    }

    public Integer turnMouseXLocation(Integer x){
        return turnMouseLocation(x, locationXList);
    }

    public Integer turnMouseYLocation(Integer y){
        return turnMouseLocation(y, locationYList);
    }

    private Integer turnMouseLocation(Integer location,List<Integer> locationList){
        int distance = Math.abs(locationList.get(0) - location);
        if(distance < CommonConstant.CELL){
            return locationList.get(0);
        }
        for (int i = 1; i < locationList.size(); i++) {
            distance = Math.abs(locationList.get(i) - location);
            if(distance < CommonConstant.CELL){
                return locationList.get(i);
            }
        }
        return null;
    }

    public List<Integer> getLocationXList() {
        return locationXList;
    }

    public void setLocationXList(List<Integer> locationXList) {
        this.locationXList = locationXList;
    }

    public List<Integer> getLocationYList() {
        return locationYList;
    }

    public void setLocationYList(List<Integer> locationYList) {
        this.locationYList = locationYList;
    }


}

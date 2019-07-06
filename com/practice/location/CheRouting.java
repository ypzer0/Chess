package com.practice.location;

import java.util.List;

/**
 * 存储车可能的落点
 * @author 杨鹏
 */
public class CheRouting extends PieceRouting{
    private LocationUtil locationUtil;

    public CheRouting(LocationUtil locationUtil) {
        this.locationUtil = locationUtil;
    }

    public List<Integer[]>  calculateRouting(Integer x,Integer y){
        List<Integer> locationYList = locationUtil.getLocationYList();
        List<Integer> locationXList = locationUtil.getLocationXList();
        for (Integer yGuess : locationYList) {
            Integer[] arr = {x,yGuess};
            ruleList.add(arr);
        }
        for (Integer xGuess : locationXList) {
            Integer[] arr = {xGuess,y};
            ruleList.add(arr);
        }
        return ruleList;
    }

}

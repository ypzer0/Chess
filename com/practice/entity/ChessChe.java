package com.practice.entity;

import com.practice.constant.CommonConstant;
import com.practice.location.LocationUtil;
import com.practice.location.PieceRouting;

import javax.swing.ImageIcon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨鹏
 */
public class ChessChe extends CommonEntity {

    public ChessChe(){
        super();
        setIcon(new ImageIcon(CommonConstant.CHESS_IMAGE_PATH+"r_c.png"));
        setLocation(CommonConstant.originLocationX,
                CommonConstant.originLocationY + CommonConstant.CELL*9);
    }

    public ChessChe(String imgName,Integer locationX,Integer locationY){
        super();
        setIcon(new ImageIcon(imgName));
        setLocation(locationX,locationY);
    }

    public Integer[] getInfoArray() {
        return new Integer[]{CommonConstant.COLOR_RED,CommonConstant.CHESS_CHE,getX(),getY()};
    }

    public void calculateRouting(Integer x, Integer y,PieceRouting pieceRouting){
        LocationUtil locationUtil=new LocationUtil();
        List<Integer[]> ruleList=new ArrayList<>();
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
        pieceRouting.setRuleList(ruleList);
    }

}

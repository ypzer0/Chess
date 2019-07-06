package com.practice.entity;

import com.practice.constant.CommonConstant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author 杨鹏
 */
public class CommonEntity {

    protected String chessImgPath;

    protected Integer coordinateX;

    protected Integer coordinateY;

    protected Integer imgWeight = 55;

    protected Integer imgHeight = 55;

    public String getChessImgPath() {
        return chessImgPath;
    }

    public void setChessImgPath(String chessImgPath) {
        this.chessImgPath = chessImgPath;
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Integer coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Integer getImgWeight() {
        return imgWeight;
    }

    public void setImgWeight(Integer imgWeight) {
        this.imgWeight = imgWeight;
    }

    public Integer getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(Integer imgHeight) {
        this.imgHeight = imgHeight;
    }

    public JLabel getLabel(){
        ImageIcon icon=new ImageIcon(this.chessImgPath);
        JLabel label=new JLabel(icon);
        label.setBounds(coordinateX,
                coordinateY,imgWeight,imgHeight);
        return label;
    }

}

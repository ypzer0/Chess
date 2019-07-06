package com.practice.entity;

import com.practice.constant.CommonConstant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author 杨鹏
 */
public class BackgroundEntity extends CommonEntity{
    public BackgroundEntity(){
        this.chessImgPath = CommonConstant.CHESS_IMAGE_PATH+"bg.png";
        this.coordinateX = 50;
        this.coordinateY = 0;
        this.imgWeight = 800;
        this.imgHeight = 600;
    }

    @Override
    public JLabel getLabel() {
        ImageIcon icon=new ImageIcon(this.chessImgPath);
        JLabel label=new JLabel(icon);
        label.setBounds(coordinateX,
                coordinateY,imgWeight,imgHeight);
        return label;
    }
}

package com.practice.entity;

import com.practice.constant.CommonConstant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author 杨鹏
 */
public class BackgroundEntity extends CommonEntity{
    public BackgroundEntity(){
        super();
        setIcon(new ImageIcon(CommonConstant.CHESS_IMAGE_PATH+"bg.png"));
        setBounds(CommonConstant.originLocationX+4,
                CommonConstant.originLocationY - 10,800,600);
    }


}

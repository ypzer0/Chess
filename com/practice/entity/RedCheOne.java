package com.practice.entity;

import com.practice.constant.CommonConstant;
import com.practice.location.PieceRouting;

import javax.swing.ImageIcon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author 杨鹏
 */
public class RedCheOne extends CommonEntity {

    public RedCheOne(){
        super();
        setIcon(new ImageIcon(CommonConstant.CHESS_IMAGE_PATH+"r_c.png"));
        setLocation(CommonConstant.originLocationX,
                CommonConstant.originLocationY + CommonConstant.CELL*9);
    }
}

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_140514b extends PApplet {

int s;
int m;
int h;

public void setup(){
  size(480,480);
  noStroke();
  //smooth();
  s=m=h=0;
}

public void draw(){
  noStroke();
  background(0xffffffff);
  translate(width/2,height/2);
  setTime(0);
  
  setHour();
  setMinute();
  setSecond();
  
}

/*
* \u6642\u9593\u53d6\u5f97
* timeDiff : \u6642\u5dee
*/
public void setTime(int timeDiff) {
  s = second() + timeDiff;
  m = minute() + timeDiff;
  h = hour() + timeDiff;
}

/**
* \u6587\u5b57\u76e4\uff08\u6642\u9593\uff09\u3092\u63cf\u753b\u3059\u308b
*/
public void setHour() {
  fill(0xff7fffd4);
  ellipse(0,0,400,400);
  pushMatrix();
  setText(24,-182,h,1);
  popMatrix();
}

/**
* \u6587\u5b57\u76e4\uff08\u5206\uff09\u3092\u63cf\u753b\u3059\u308b
*/
public void setMinute() {
  fill(0xff87cefa);
  ellipse(0,0,350,350);
  pushMatrix();
  setText(60,-160,m,2);
  popMatrix();
}


/**
* \u6587\u5b57\u76e4\uff08\u79d2\uff09\u3092\u63cf\u753b\u3059\u308b
*/
public void setSecond() {
  fill(0xffffedcc);
  ellipse(0,0,300,300);
  pushMatrix();
  setText(60,-134,s,3);
  popMatrix();
  fill(0xffffffff);
  ellipse(0,0,250,250);
}


/**
* \u6587\u5b57\u76e4\u3092\u63cf\u753b\u3059\u308b
* timeNum : \u8868\u793a\u3059\u308b\u6570\u5b57\u306e\u6700\u5927\u5024
* yNum : \u8868\u793a\u4f4d\u7f6e\u306ey\u8ef8\u5024
* now : \u73fe\u5728\u306e\u6642\u9593\u60c5\u5831
* timeMode : \u73fe\u5728\u306e\u6587\u5b57\u76e4\u306e\u72b6\u614b\u30011...\u6642\u30012...\u5206\u30013...\u79d2
*/
public void setText(int timeNum , int yNum , int now , int timeMode){
  switch(timeMode){
  case 1:
    rotate(-h*PI/12);
    rotate(-m*((PI/12)/60));
    rotate(-s*(((PI/12)/60)/60));
    break;
  case 2:
    rotate(-m*PI/30);
    rotate(-s*((PI/30)/60));
    break;
  case 3:
    rotate(-s*PI/30);
    break;
  }
  fill(0xff333333);
  textAlign(CENTER);
  for(int i = 0 ; i < timeNum ; i++){
    textSize(6);
    if(i == now){
      textSize(12);
    }
    text(i,0,yNum);
    rotate(PI/(timeNum/2));
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_140514b" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

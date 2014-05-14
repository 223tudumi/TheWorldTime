int s;
int m;
int h;

void setup(){
  size(480,480);
  noStroke();
  //smooth();
  s=m=h=0;
}

void draw(){
  noStroke();
  background(#ffffff);
  translate(width/2,height/2);
  setTime(0);
  
  setHour();
  setMinute();
  setSecond();
  
}

/*
* 時間取得
* timeDiff : 時差
*/
void setTime(int timeDiff) {
  s = second() + timeDiff;
  m = minute() + timeDiff;
  h = hour() + timeDiff;
}

/**
* 文字盤（時間）を描画する
*/
void setHour() {
  fill(#7fffd4);
  stroke(#ffffff);
  ellipse(0,0,400,400);
  noStroke();
  pushMatrix();
  setText(24,-182,h,1);
  popMatrix();
}

/**
* 文字盤（分）を描画する
*/
void setMinute() {
  fill(#87cefa);
  stroke(#ffffff);
  ellipse(0,0,350,350);
  noStroke();
  pushMatrix();
  setText(60,-160,m,2);
  popMatrix();
}


/**
* 文字盤（秒）を描画する
*/
void setSecond() {
  fill(#ffedcc);
  stroke(#ffffff);
  ellipse(0,0,300,300);
  noStroke();
  pushMatrix();
  setText(60,-134,s,3);
  popMatrix();
  fill(#ffffff);
  ellipse(0,0,250,250);
}


/**
* 文字盤を描画する
* timeNum : 表示する数字の最大値
* yNum : 表示位置のy軸値
* now : 現在の時間情報
* timeMode : 現在の文字盤の状態、1...時、2...分、3...秒
*/
void setText(int timeNum , int yNum , int now , int timeMode){
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
  fill(#333333);
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

import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  // used to enable typing letters
  String message ="";

  public void settings() {

    size(400, 400);
  }

  public void setup() {

    background(51, 139, 255);
  }

  //setting up the drawHouse function
  void drawHouse(float mouseX, float mouseY, float houseWidth, float houseHeight) {

    //biggest rectangle of the house
    stroke(0);
    fill(240, 235, 182);
    rect(mouseX, mouseY, houseWidth, houseHeight);
    
    //roof positions
    fill(207, 76, 33);
    triangle((float) (mouseX), (float) (mouseY), (float) (mouseX + 100), (float) (mouseY - 100), (float) (mouseX + houseWidth) , (float) (mouseY));
           
    //window positions
    fill(145, 229, 242);
    rect((float) (mouseX + 10), (float) (mouseY + 30), (float) (houseWidth - 130), (float) (houseHeight - 90));
     
    //rectangle door positions
    fill(82, 79, 53);
    rect((float) (mouseX + 90), (float) (mouseY +30), (float) (houseWidth - 120), (float) (houseHeight - 30));
         
    // doorknob positions
    fill(240, 252, 0);
    ellipse((float) (mouseX + 155), (float) (mouseY + 100), (float) (houseWidth -185), (float) (houseHeight - 135));
  }

  public void draw() {

    //draws out grass by pressing the mouse
    if (mousePressed) {
      stroke(0);
      fill (0, 255, 106);
      rect(mouseX, mouseY, 200, 120);
    }
 
    if (keyPressed) {
      if (keyCode == CONTROL){
        //summoning a slime
        PImage imgSlime;
        imgSlime = loadImage("RedSlime.png");
        imgSlime.resize(100, 100);
        image(imgSlime, mouseX, mouseY);
      }
      
      //drawing different colored retangle clouds with different keys
      if (key == 's') {
        fill(255, 255, 255);
        rect(mouseX, mouseY, 100, 20);
      }

      else if (key == 'i') {
        fill(163, 152, 152);
        rect(mouseX, mouseY, 100,20);
      }

      else if (key == 'e') {
        fill(20, 20, 20);
        rect(mouseX, mouseY, 100, 20);
      }

    }

    //types out a message
    fill(244, 250, 62);
    text(message, 20, 150);
  }
  
  public void keyTyped() {

    //displays the letters typed
    message += key;
  }

  public void mouseClicked() {

    //when clicked a house will be drawn
    drawHouse(mouseX, mouseY, 200, 150);
  }
}
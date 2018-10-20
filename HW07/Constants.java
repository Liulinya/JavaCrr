//This file create and use constants in the game

class Constants{
 //screen constants
 static int block_size = 5;
 static int WIDTH = 500;//width
 static int HEIGHT = 500;//height
 static int GAME_HEIGHT = Constants.HEIGHT - Constants.block_size;//playable height
 static int GAME_WIDTH = Constants.WIDTH - Constants.block_size;//playable width
 
 //direction constants
 static int DIR_RIGHT = 0;
 static int DIR_UP = 1;
 static int DIR_LEFT = 2;
 static int DIR_DOWN = 3;
 
 //food constants
 static int MAX_GROWTH_FOOD = 10;
 static int MAX_NUM_FOOD = 1;
}

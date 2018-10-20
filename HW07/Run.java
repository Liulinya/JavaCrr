public class Run{
 public static void main(String[] args){
  GameFrame g_frame = new GameFrame("Snake");
  Game g = new Game();
  g_frame.ctx.game = g;
 }
}

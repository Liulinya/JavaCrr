public class BST {
  int value; 
  BST left, right;
  public BST(int value, BST left, BST right) {
    this.value = value; 
    this.left = left; 
    this.right = right; 
  }
    
  public void insert(int value) {
    if (this.value == value) return;
    else if (this.value > value) // insert value on right side
      if (this.left == null) 
        this.left  = new BST(value, null, null); 
      else this.left.insert(value); 
    else // this.value < value, insert value on left side
      if (this.right == null) 
        this.right  = new BST(value, null, null); 
      else this.right.insert(value); 
  }
  
  public boolean find(int value) {
    if (this.value == value) return true;
    else if (this.value > value) // this was wrong, fixed now
      return (this.left == null) ? false : this.left.find(value); // "?" if left then false, ":" else find next value
    else // this.value < value 
      return (this.right == null) ? false : this.right.find(value); 
  }
  
  public String toString() {
    String left = (this.left  == null) ? "" : this.left.toString(), 
          right = (this.right == null) ? "" : this.right.toString();
    return left + " " + this.value + " " + right;     
  }
}
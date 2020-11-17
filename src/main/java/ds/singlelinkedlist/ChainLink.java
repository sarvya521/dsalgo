package ds.singlelinkedlist;

public class ChainLink {

	enum Side { NONE, LEFT, RIGHT }

    private ChainLink left, right;
    
    public void append(ChainLink rightPart) {
        if (this.right != null)
            throw new IllegalStateException("Link is already connected.");

        this.right = rightPart;
        rightPart.left = this;
    }
    
    public int traverseLeft() {
    	int l = 0;
    	if(this.left != null) {
    		l = 1;
    		l += this.left.traverseLeft();
    	}
    	return l;
    }
    
    public int traverseRight() {
    	int r = 0;
    	if(this.right != null) {
    		r = 1;
    		r += this.right.traverseRight();
    	}
    	return r;
    }
    
    public Side longerSide() {
    	int l = this.traverseLeft();
    	int r = this.traverseRight();
    	if(l > r) {
    		return Side.LEFT;
    	} else if(r > l) {
    		return Side.RIGHT;
    	}
    	return Side.NONE;
    }
	    
    public static void main(String[] args) {
    	ChainLink left = new ChainLink();
    	ChainLink middle = new ChainLink();
    	ChainLink right = new ChainLink();
        left.append(middle);
        middle.append(right);

        System.out.println(left.longerSide());
    }

	@Override
	public String toString() {
		return "ChainLink [left=" + (left != null ? 1 : 0) + ", right=" + (right != null ? 1 : 0) + "]";
	}
    
    
}

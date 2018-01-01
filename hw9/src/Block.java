public class Block {
    private int cost;
    public void init(String file){
        // Read in the file and build an initial map. 
    }
    public boolean isfinished(){
        // Return true if the goal point is reached.
        return true;
    }
    public void addblock(String[] points){
        // In every step, this function will be called to add some new block points in the map.
    }
    public int cost(){ 
        // Return the total cost of the path you build recently.
        return cost;
    }
    
    // This main function is just an template for you to try on. 
    // However, we will not use your main function to run on the judge system.
    public static void main(String argv[]){
        Block block = new Block();
    
        block.init(argv[0]);
        while(block.isfinished()){
            String[] points = null; // We will generate some  new block points here.
            block.addblock(points);
        }
        
        System.out.println(block.cost());
    }
}

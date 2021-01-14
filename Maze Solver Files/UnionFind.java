package HW8;


/**
 * Implementation of the Union-Find ADT. 
 */
public class UnionFind {

   private int up[];
   private int weight[];
   int numSets;


   /**
    * Constructor - initializes up and weight arrays. 
    *
    * @param numElements initial number of singleton sets. 
    */
   public UnionFind (int numElements) {
      this.up = new int[numElements + 1];
      // arrays start with 1
      for (int i = 1; i <= numElements; i++) {
         up[i] = -1;
      }
      this.weight = new int[numElements + 1];
      for (int i = 1; i <= numElements; i++) {
         weight[i] = 1;
      }
      this.numSets = numElements;
   }

   /**
    * Unites two sets using weigthed union. 
    *
    * @param i representative of first set. 
    * @param j representative of second set. 
    */
   public void union (int i, int j) {
      // index are not out of bounds
      if((i > 0) && (i < this.up.length) && (j > 0) && (j < this.up.length)) {
         // make sure i and j are representative
         i = find(i);
         j = find(j);
         if(find(i) != find(j)) {
            int weightSum = weight[i] + weight[j];
            if(weight[i] < weight[j]) {
               up[i] = j;
               // updates the leader for the rest of the smaller sub-tree
               for(int k = 0; k < this.up.length; k++) {
                  if(up[k] == i) {
                     up[k] = j;
                  }
               }
               weight[j] = weightSum;
               weight[i] = 1;
               this.numSets--;
            }
            else {
               up[j] = i;
               // updates the leader for the rest of the smaller sub-tree
               for(int k = 0; k < this.up.length; k++) {
                  if(up[k] == j) {
                     up[k] = i;
                  }
               }
               weight[i] = weightSum;
               weight[j] = 1;
               this.numSets--;
            }
         }
         // else, the two elements are in the same set
      }
      else {
         throw new IndexOutOfBoundsException ("One or two of the elements does not exist in this set.");
      }
   }

   /**
    * Finds the set representative, and applies path compression. 
    *
    * @param i the element to search. 
    * @return the representative of the group that contains i. 
    */
   public int find (int i) {
      if(this.up[i] == -1) {
         return i;
      }
      else {
         up[i] = find(up[i]);
         return up[i];
      }
   }

   /**
    * Find the current number of sets. 
    *
    * @return the number of set. 
    */
   public int getNumSets() {
      return this.numSets;
   }

   /**
    * Prints the contents of the up array. 
    */
   private void debugPrintUp() {

      System.out.print ("up:     ");
      for (int i = 1; i < up.length; i++)
         System.out.print (up[i] + " ");
      System.out.println ("");
   }

   /**
    * Prints the results of running find on all elements. 
    */
   private void debugPrintFind() {

      System.out.print ("find:   ");
      for (int i = 1; i < up.length; i++)
         System.out.print (find (i) + " ");
      System.out.println ("");
   }

   /**
    * Prints the contents of the weight array. 
    */
   private void debugPrintWeight() {

      System.out.print ("weight: ");
      for (int i = 1; i < weight.length; i++)
         System.out.print (weight[i] + " ");
      System.out.println ("");
   }

   /**
    * Various tests for the Union-Find functionality. 
    *
    * @param args command line arguments - not used. 
    */
   public static void main (String[] args) {

      UnionFind uf = new UnionFind (10);

//      uf.debugPrintUp(); 
//      uf.debugPrintFind(); 
//      uf.debugPrintWeight(); 
//      System.out.println ("Number of sets: " + uf.getNumSets()); 
//      System.out.println (""); 
// 
//      uf.union (1, 2); 
//      
//      uf.debugPrintUp(); 
//      uf.debugPrintFind(); 
//      uf.debugPrintWeight(); 
//      System.out.println ("Number of sets: " + uf.getNumSets()); 
//      System.out.println (""); 
//      
//      uf.union (3, 8); 
//      
//      uf.debugPrintUp(); 
//      uf.debugPrintFind(); 
//      uf.debugPrintWeight(); 
//      System.out.println ("Number of sets: " + uf.getNumSets()); 
//      System.out.println (""); 
//      
//      uf.union (8, 2);  
//      
//      uf.debugPrintUp(); 
//      uf.debugPrintFind(); 
//      uf.debugPrintWeight(); 
//      System.out.println ("Number of sets: " + uf.getNumSets()); 
//      System.out.println (""); 
//      
//      uf.union (2, 1);
//      
//      uf.debugPrintUp(); 
//      uf.debugPrintFind(); 
//      uf.debugPrintWeight(); 
//      System.out.println ("Number of sets: " + uf.getNumSets()); 
//      System.out.println (""); 
//      
//      uf.union (4, 5);
//      uf.union (7, 5);
//      uf.union (7, 8);
//      uf.union (8, 6);
//      uf.union (4, 9);
//      uf.union (10, 5);
//      
//      uf.debugPrintUp(); 
//      uf.debugPrintFind(); 
//      uf.debugPrintWeight(); 
//      System.out.println ("Number of sets: " + uf.getNumSets()); 
//      System.out.println (""); 

      uf.debugPrintUp();
      uf.debugPrintFind();
      uf.debugPrintWeight();
      System.out.println ("Number of sets: " + uf.getNumSets());
      System.out.println ("");

      uf.union (2, 1);
      uf.union (3, 2);
      uf.union (4, 2);
      uf.union (5, 2);

      uf.debugPrintUp();
      uf.debugPrintFind();
      uf.debugPrintWeight();
      System.out.println ("Number of sets: " + uf.getNumSets());
      System.out.println();

      uf.union (6, 7);
      uf.union (8, 9);
      uf.union (6, 8);

      uf.debugPrintUp();
      uf.debugPrintFind();
      uf.debugPrintWeight();
      System.out.println ("Number of sets: " + uf.getNumSets());
      System.out.println();

      uf.find (8);

      uf.debugPrintUp();
      uf.debugPrintFind();
      uf.debugPrintWeight();
      System.out.println ("Number of sets: " + uf.getNumSets());
      System.out.println();

   }
} 


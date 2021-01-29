public class MaxHeap{
    private Integer[] heap;
    private int arraySize;
    private int heapSize;
    public MaxHeap(int size){//creates empty heap
        heap= new Integer[size];
        arraySize= size;
        heapSize=0;
    }
    public MaxHeap(Integer[] someArray){//turns array into a heap
        int size= someArray.length;
        arraySize=size;
        heapSize=size;
        heap=bringDown(size/2 -1, someArray, false);//organizes the heap
    }
    public Integer[] getHeap(){
        return heap;
    }
    public int getCapacity(){
        return this.arraySize;
    }
    public int getSize(){
        return this.heapSize;
    }
    public void insert(int n){//inserts a new number
        if(arraySize==heapSize){//checks if array is full
            Integer[] replace= new Integer[arraySize*2];//creates new integer double the size of the previous one
            for(int i=0; i<heapSize; i++){
                replace[i]=heap[i];
            }
            heap=replace;//now the heap array is half full of null values
            arraySize*=2;
        }
        heap[heapSize]=n;//adds the new number in
        heapSize++;
        heap=bringDown(heapSize/2 - 1, heap, false);
    }
    private int deleteMax(){//deletes and return the highest number
        int max=heap[0];//since its a max heap the highest number should be the first one
        heap[0]=heap[heapSize-1];//put the last value in the spot of th efirst one
        heap[heapSize-1]=null;
        heapSize--;
        heap= bringDown(0, heap, false);//reorganize heap
        return max;
    }
    public String toString(){//returns heap as string
        String print="";
        for(int i=0; i<heapSize; i++){
            print+= heap[i] + ",";
        }
        return print;
    }
    public static void heapsort(Integer[] arrayToSort){//sorts the values in decreasing order
        int j=0;
        while(arrayToSort[j]!=null){
            j++;
        }
        Integer[] a= new Integer[j];
        for(int k=0; k<j; k++){
            a[k]=arrayToSort[k];
        }
        MaxHeap hold= new MaxHeap(a);
        Integer[] arraySorted= new Integer[j];
        for(int i=0; i<j; i++){
            arraySorted[i]= hold.deleteMax();
        }
        for(int i=0; i<j; i++){
            arrayToSort[i]= arraySorted[i];
        }
    }
    private Integer[] bringDown(int index, Integer[] someArray, Boolean processing){//sorts the heap by bringing down any lower values
        if(heapSize<2)// checks if the heap has one or no values
            return someArray;
        int child1= index*2 +1; //left child
        int child2= index*2 +2; //right child
        int size= heapSize;
        Integer hold;
        if(child2<size && someArray[child2]>someArray[child1] && someArray[child2]>someArray[index]){
            hold=someArray[child2];
            someArray[child2]=someArray[index];
            someArray[index]=hold;//switches the right child with the parent
            if(child2<(size)/2){//checks if the child has children
                if(someArray[child2]<someArray[child2*2+1])//checks if the child's left child is smaller
                    someArray=bringDown(child2, someArray, true);//goes down the heap
                else if((child2*2+2)<size && someArray[child2]<someArray[child2*2+2])//checks if the child's right child exists and if it is smaller
                    someArray=bringDown(child2, someArray, true);//goes down the heap
            }
        }
        else if(someArray[child1]>someArray[index]){
            hold=someArray[child1];
            someArray[child1]=someArray[index];
            someArray[index]=hold;// switches the left child
            if(child1<(size)/2){//checks if the child has children
                if(someArray[child1]<someArray[child1*2+1])//checks if the child's left child is smaller
                    someArray=bringDown(child1, someArray, true);//goes down the heap
                else if((child1*2+2)<size && someArray[child1]<someArray[child1*2+2])//checks if the child's right child exists and if it is smaller
                    someArray=bringDown(child1, someArray, true);//goes down the heap
            }
        }
        //checks if previous action was going down or up the heap
        //if processing is true then the current index is an index previously visited
        if(processing==false && index>0){
            someArray=bringDown(index-1, someArray, false);//goes up the heap
        }
        return someArray;
    }

}
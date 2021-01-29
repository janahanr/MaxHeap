class Main{
    public static void main(String[] args) {
        MaxHeap empty= new MaxHeap(5);
        int a= empty.getCapacity();
        int b= empty.getSize();
        System.out.println("Empty Heap Capacity: "+ a);
        System.out.println("Empty Heap Size: "+ b);
        Integer[] arr1= {3,2,9,5,18,14,11,7};
        MaxHeap heap1= new MaxHeap(arr1);
        Integer[] arr2= heap1.getHeap();
        int cap= heap1.getCapacity();
        int size= heap1.getSize();
        System.out.println("Capacity: "+ cap);
        System.out.println("Size: "+ size);
        System.out.println("Initial Heap: ");
        String print="";
        for(int i=0; i<size; i++){
            print+= arr2[i] + ", ";
        }
        System.out.println(print);
        heap1.insert(20);
        System.out.println("Insert 20: " + heap1.toString());
        heap1.insert(6);
        System.out.println("Insert 6: " + heap1.toString());
        arr2= heap1.getHeap();
        heap1.heapsort(arr2);
        System.out.println("Heap Sort: ");
        print="";
        for(int i=0; i<heap1.getSize(); i++){
            print+= arr2[i] + ", ";
        }
        System.out.println(print);
        
    }
}
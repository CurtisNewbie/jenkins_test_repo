public class ComplexApplication {

    public static void main(String[] args){
        System.out.println("Started very complex application");
        System.out.printf("Executing $d task\n", i);
        for(int i = 0; i < 3; i++){
            System.out.println("Task " + i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
            }
        }
        System.out.println("Application Exited");
    }
    
}
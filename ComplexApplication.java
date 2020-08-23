public class ComplexApplication {

    public static void main(String[] args){
        System.out.println("Started very complex application");
        int tasks = 3;
        System.out.printf("Executing %d task\n", tasks);
        for(int i = 0; i < tasks; i++){
            System.out.println("Task " + i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
            }
        }
        System.out.println("Application Exited");
    }
    
}
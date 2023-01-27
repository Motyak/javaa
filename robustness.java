
import java.util.Optional;

@FunctionalInterface
interface OptLambda<T> {
    abstract Optional<T> execute();
}

@FunctionalInterface
interface BoolLambda {
    abstract boolean execute();
}

 class fds {
     public static <T> T callWithRetry(OptLambda call, int RETRY_SLEEP, int MAX_TRIES) {
         Optional<T> result;
         int iter = 0;
         do {
             iter++;
             result = call.execute();
             
             if (!result.isPresent()) {
                 if (iter <= MAX_TRIES) {
                     sleep(RETRY_SLEEP * 1000);
                     continue;
                 } else {
                     throw new CustomRuntimeException();
                 }
             }
         } while (!result.isPresent());
         
         return result.get();
     }
     
     public static void callWithRetry(BoolLambda call, int RETRY_SLEEP, int MAX_TRIES) {
         boolean callSucceeded = false;
         int iter = 0;
         do {
             iter++;
             callSucceeded = call.execute();
             
             if (!callSucceeded) {
                 if (iter <= MAX_TRIES) {
                     sleep(RETRY_SLEEP * 1000);
                     continue;
                 } else {
                     throw new CustomRuntimeException();
                 }
             }
         } while (!callSucceeded);
     }

     private static void sleep(long millis) {
         try {
            Thread.sleep(millis);
         } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
         }
     }
 }

class CustomRuntimeException extends RuntimeException {}

public class Main
{
    
    private static Optional<Integer> usingOpt() {
        boolean serverWorking = false;
        
        return serverWorking? Optional.of(91) : Optional.empty();
    }
    
    private static boolean usingBool() {
        boolean serverWorking = true;
        
        return serverWorking;
    }
    
    private static void somethingThatThrows() throws Exception {
        boolean serverWorking = true;
        
        if (!serverWorking) {
            throw new Exception(); 
        }
    }
    
    private static int somethingThatThrowsAndReturn() throws Exception {
        boolean serverWorking = false;
        
        if (!serverWorking) {
            throw new Exception(); 
        }
        
        return 91;
    }
    
	public static void main(String[] args)
	{
	    {
	        BoolLambda fn = () -> {
    	        try {
    	            Main.somethingThatThrows();
    	            return true;
    	        } catch (Exception e) {
    	            return false;
    	        }
    	    };
    	    
    	    fds.callWithRetry(fn, 1, 2);
	    }
	    
	    OptLambda fn = () -> {
	        Optional<Integer> res;
	        try {
	            res = Optional.of(Main.somethingThatThrowsAndReturn());
	        } catch (Exception e) {
	            res = Optional.empty();
	        }
	        return res;
	    };
	    
	    
		fds.callWithRetry(fn, 1, 2);
		
		
	}
}


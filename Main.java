
import java.util.Optional;

class Main {

    public static void main(String[] args) {
        // String str = fds.callWithRetry(Main::e, 1, 3);
        // fds.callWithRetry(Main::d, 1, 3);
        // String str = fds.callWithRetry(Main::c, 1, 3);
        // int i = fds.callWithRetry(Main::b, 1, 3);
        fds.callWithRetry(Main::a, 1, 3);
    }

    private static void a() throws Exception {
        // throw new Exception();
    }

    private static int b() throws Exception {
        throw new Exception();
        // return 91;
    }

    private static String c() throws Exception {
        throw new Exception();
        // return "fds";
    }

    private static boolean d() {
        return false;
        // return true;
    }

    private static Optional<String> e() {
        return Optional.empty();
        // return Optional.of("fds");
    }
}

@FunctionalInterface
interface Lambda_ReturnNothing_MightThrowException {
    abstract void __() throws Exception;
}

@FunctionalInterface
interface Lambda_ReturnSomething_MightThrowException<T> {
    abstract T __() throws Exception;
}

@FunctionalInterface
interface Lambda_ReturnBool {
    abstract boolean __();
}

@FunctionalInterface
interface Lambda_ReturnOptional<T> {
    abstract Optional<T> __();
}

class fds {

    public static void callWithRetry(Lambda_ReturnNothing_MightThrowException call, int RETRY_SLEEP, int MAX_TRIES) {
        Lambda_ReturnBool newCall = () -> {
            try {
                call.__();
                return true;
            } catch (Exception e) {
                return false;
            }
        };
        fds.callWithRetry(newCall, RETRY_SLEEP, MAX_TRIES);
    }

    public static <T> T callWithRetry(Lambda_ReturnSomething_MightThrowException call, int RETRY_SLEEP, int MAX_TRIES) {
        Lambda_ReturnOptional newCall = () -> {
            try {
                return Optional.of(call.__());
            } catch (Exception e) {
                return Optional.empty();
            }
        };
        return fds.callWithRetry(newCall, RETRY_SLEEP, MAX_TRIES);
    }

    public static void callWithRetry(Lambda_ReturnBool call, int RETRY_SLEEP, int MAX_TRIES) {
        boolean callSucceeded = false;
        int iter = 0;
        do {
            iter++;
            callSucceeded = call.__();
            
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

    public static <T> T callWithRetry(Lambda_ReturnOptional call, int RETRY_SLEEP, int MAX_TRIES) {
        Optional<T> result;
        int iter = 0;
        do {
            iter++;
            result = call.__();
            
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

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class CustomRuntimeException extends RuntimeException {}

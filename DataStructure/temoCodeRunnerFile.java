import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class temoCodeRunnerFile {
    public static void main(String[] args) throws Exception {
        Unsafe unsafe = getUnsafe();
        long address = unsafe.allocateMemory(1024); // Allocate 1024 bytes of memory
        System.out.println("Memory address of the allocated memory: " + address);
        unsafe.freeMemory(address); // Free the allocated memory
    }

    private static Unsafe getUnsafe() throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        return (Unsafe) theUnsafe.get(null);
    }
}

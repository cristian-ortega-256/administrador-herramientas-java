package workerTest;

import org.junit.Test;

import Entities.Worker;

import static org.junit.Assert.*;

public class WorkerTest {
    @Test public void testConstructor() {
        Worker worker =  new Worker("Goku");
        assertEquals(worker.getName(), "Goku");
    }
}
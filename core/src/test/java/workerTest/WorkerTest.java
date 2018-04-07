package workerTest;

import org.junit.Test;

import Entities.Worker;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorkerTest {
    @Test public void testConstructor() {
        Worker worker =  new Worker("Goku");
        assertEquals(worker.getName(), "Goku");
    }
}
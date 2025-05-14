package ru.destroy;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Warmup(iterations = 5, time = 2)
@Fork(1)
public class ListOfTest {

    @Benchmark
    public void listOf(Blackhole blackhole){

        blackhole.consume(List.of(100,1000,100,1,1,1,1,1,1,1,1,1,1,11,1,1));

    }

    @Benchmark
    public void arrayAsList(Blackhole blackhole){

        blackhole.consume(Arrays.asList(100, 1000, 100, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 1, 1));

    }

    /**
     * Benchmark                Mode  Cnt         Score         Error  Units
     * ListOfTest.arrayAsList  thrpt    5  32477027.751 ± 1750521.492  ops/s
     * ListOfTest.listOf       thrpt    5  25951967.932 ± 2050858.447  ops/s
     */
    public static void main(String[] args) throws IOException {
        Main.main(args);
    }

}

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@State(Scope.Thread)
public class ListOfTest {

    @Benchmark
    public void listOf(Blackhole blackhole){

        blackhole.consume(List.of(100,1000,100,1,1,1,1,1,1,1,1,1,1,11,1,1));

    }

    @Benchmark
    public void arrayAsList(Blackhole blackhole){

        blackhole.consume(Arrays.asList(100, 1000, 100, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 1, 1));

    }

    public static void main(String[] args) throws IOException {
        Main.main(args);
    }

}

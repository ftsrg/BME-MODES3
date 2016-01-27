package hu.bme.mit.ftsrg.ptregex;

import hu.bme.mit.ftsrg.ptregex.RegexCompiler;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class RegexTest {
  public static void main(final String[] input) {
    LinkedList<Integer> left = new LinkedList<Integer>();
    LinkedList<Integer> right = new LinkedList<Integer>();
    left.add(Integer.valueOf(1));
    left.add(Integer.valueOf(2));
    left.add(Integer.valueOf(3));
    left.add(Integer.valueOf(4));
    right.add(Integer.valueOf(10));
    right.add(Integer.valueOf(11));
    List<List<Integer>> _generatePerm = RegexCompiler.generatePerm(left, right);
    final Consumer<List<Integer>> _function = (List<Integer> it) -> {
      final Consumer<Integer> _function_1 = (Integer it_1) -> {
        InputOutput.<Integer>print(it_1);
        InputOutput.<String>print(", ");
      };
      it.forEach(_function_1);
      InputOutput.println();
    };
    _generatePerm.forEach(_function);
  }
}

//Code Organizing:

import org.model.*;

/**
 *A Javadoc comment
 * @since 2007
 */
public class Engine {
  public void start() {}

  public
  void stop() {
  }
}

class SortExample {
  private String foo;
  private String bar;
  private void foo() {}
  private void bar() {}
}


//Code Style:

if (obj == null) {
    throw new IllegalArgumentException();
}
if (ids.length > 0) {
    System.out.println(ids[0]);
} else {
    return;
}

for (int i = 0; i < ids.length; i++) {
    double value= ids[i] / 2; 
    System.out.println(value);
}

boolean b= (i > 0 && i < 10 || i == 50);

private int i= 0;
public void foo(int j) {
    int k, h;
    h= 0;
}

IntConsumer c = new IntConsumer() {
    @Override public void accept(int value) {
        System.out.println(i);
    }
};
Runnable r = () -> { /* do something */ };


//Member Access:

private int value;
public int get() {
    return value + value;
}

public int getZero() {
    return get() - get();
}

class E {
    public static int NUMBER;
    public static void set(int i) {
        NUMBER= i;
    }

    public void reset() {
        set(0);
    }
}

class ESub extends E {
    public void reset() {
        ESub.NUMBER= 0;
    }
}

public void dec() {
    E.NUMBER--;
}


//Missing Code:

class E {
    /**
     * @deprecated
     */
    @Deprecated
    public void foo() {}
}
class ESub extends E implements Runnable {
    @Override
    public void foo() {}
    @Override
    public void run() {}
}

class E implements java.io.Serializable {
    private static final long serialVersionUID = -391484377137870342L;
}

public class Face implements IFace {
}


//Unnecessary Code:

import pack.Bar;
class Example {
    private class Sub {}
    public Example(boolean b) {}
    private Example() {}
    private int fField;
    private void foo() {}
    public void bar() {
        int i= 10;
    }
}

Boolean b= Boolean.TRUE;

public String s; //$NON-NLS-1$

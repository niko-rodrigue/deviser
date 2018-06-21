// Indentation:

/**
 * Indentation
 */
class Example {

  int[]  myArray    = {1, 2, 3, 4, 5, 6};
  int    theInt     = 1;
  String someString = "Hello";
  double aDouble    = 3.0;


  void foo(int a, int b, int c, int d, int e, int f) {
    switch (a) {
    case 0:
      Other.doFoo();
      break;
    default:
      Other.doBaz();
    }
  }


  void bar(List v) {
    for (int i = 0; i < 10; i++) {
      v.add(new Integer(i));
    }
  }
}


enum MyEnum {
             UNDEFINED(0) {

               void foo() {
               }
             }
}


@interface MyAnnotation {

  int count() default 1;
}


//Braces:

/**
 * Braces
 */
interface Empty {
}


enum MyEnum {
             UNDEFINED(0) {

               void foo() {
               }
             }
}


@interface SomeAnnotationType {
}


class Example {

  SomeClass fField     = new SomeClass() {};
  int[]     myArray    = {1, 2, 3, 4, 5, 6};
  int[]     emptyArray = new int[] {};


  Example() {
    Runnable r = () -> {
      fField.set(20);
    };
  }


  void bar(int p) {
    for (int i = 0; i < 10; i++) {
    }
    switch (p) {
    case 0:
      fField.set(0);
      break;
    case 1:
    {
      break;
    }
    default:
      fField.reset();
    }
  }
}



// Blank Lines:


/**
 * Blank Lines
 */
package foo.bar.baz;

import java.util.List;
import java.util.Vector;

import java.net.Socket;

public class Another {
}


public class Example {

  public static class Pair {

    public String first;
    public String second;
    // Between here...
    // ...and here are 10 blank lines
  };

  private LinkedList fList;
  public int         counter;


  public Example(LinkedList list) {
    fList = list;
    counter = 0;
  }


  public void push(Pair p) {
    fList.add(p);
    ++counter;
  }


  public Object pop() {
    --counter;
    return (Pair) fList.getLast();
  }
}


// New Lines:

/**
 * New Lines
 */
@Deprecated
package com.example; // annotation on package is only allowed in
                     // package-info.java

public class Empty {
}


@Deprecated
class Example {

  @Deprecated
  static int[] fArray    = {1, 2, 3, 4, 5};
  Listener     fListener = new Listener() {};


  @Deprecated
  @Override
  public void bar(@SuppressWarnings("unused") int i) {
    @SuppressWarnings("unused")
    final @Positive int k;
  }


  void foo() {
    ;
    ;
    label: do {
    } while (false);
    for (;;) {
    }
  }
}


enum MyEnum {
             UNDEFINED(0) {
             }
}


enum EmptyEnum {
}


@interface EmptyAnnotation {
}


// Contol statements:



  void bar() {
    do {
    } while (true);
    try {
    } catch (Exception e) {
    }
    finally {
    }
  }


  void foo2() {
    if (true) {
      return;
    }
    if (true) {
      return;
    } else if (false) {
      return;
    } else {
      return;
    }
  }


  void foo(int state) {
    if (true)
      return;
    if (true)
      return;
    else if (false)
      return;
    else
      return;
  }


// Line wrapping:

/**
 * Element-value pairs
 */
@MyAnnotation(value1 = "this is an example", value2 = "of an annotation", value3 = "with several arguments", value4 = "which may need to be wrapped")
class Example {
}


// Comments:

/**
 * An example for comment formatting. This example is meant to illustrate the
 * various possibilities offered by <i>Eclipse</i> in order to format comments.
 */
package mypackage;

/**
 * This is the comment for the example interface.
 */
interface Example {

  // This is a long comment with whitespace that should be split in multiple
  // line comments in case the line comment formatting is enabled
  int foo3();
  // void commented() {
  // System.out.println("indented");
  // }
  // void indentedCommented() {
  // System.out.println("indented");
  // }


  /* block comment on first column */
  int bar();


  /*
   * These possibilities include:
   * <ul><li>Formatting of header comments.</li><li>Formatting of Javadoc
   * tags</li></ul>
   */
  int bar2(); // This is a long comment that should be split in multiple line
              // comments in case the line comment formatting is enabled


  /**
   * The following is some sample code which illustrates source formatting
   * within javadoc comments:
   * 
   * <pre>
   * public class Example {
   * 
   *   final int a = 1;
   *   final boolean b = true;
   * }
   * </pre>
   * 
   * Descriptions of parameters and return values are best appended at end of
   * the javadoc comment.
   * 
   * @param a
   *        The first parameter. For an optimum result, this should be an odd
   *        number
   *        between 0 and 100.
   * @param b
   *        The second parameter.
   * @return The result of the foo operation, usually within 0 and 1000.
   */
  int foo(int a, int b);
}


class Test {

  void trailingCommented() {
    System.out.println("indented"); // comment
    System.out.println("indent"); // comment
  }
}




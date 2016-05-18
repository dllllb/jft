# About

Functional style collections library inspired by Scala collections

# Motivation

JFT leverages functional approach that is also used in such products as Scala containers library or C++ STL.
The main advantage of such approach is that container procession algorithms are decoupled from logic required to process the particular type of container elements
  
Such decoupling has the following advantages:

- Simple reusable building blocks. Containers algorithms and functions to work with elements (functors) can be used in any combination. Algorithms may be applied in any combination.
- Simple unit testing with good coverage. All algorithms and functors can be tested separately.
- Simple parallelization
- Simple code verification. There are a set of distinct simple algorithms and functors to be verified. And if they are correct then any complex combination of them is also correct.

# Examples

## Plain Java

    Map<String, String> test = new HashMap<String, String>();

## JFT

    Map<String, String> test = hashMap();

## Plain Java

    Map<Integer, String> control = new HashMap<Integer, String>();
    control.put(1, "a");
    control.put(2, "b");

## JFT

    Map<Integer, String> map = hashMap(array(1, 2), array("a", "b"));

## Plain Java

    List<String> test = new ArrayList<String>();
    test.add("one");
    test.add("two");
    test.add("three");

## JFT

    List<String> test = arrayList("one", "two", "three");

## Plain Java

    Map<String, List<String>> test = new HashMap<String, List<String>>();
    List<String> val = test.get("a");

    if (val == null) {
      val = new ArrayList<String>();
      val.put("a", val);
    }

    val.add("one");

## JFT

    MapF<String, List<String>> test = Containers.hashMap();
    test.getOrElseUpdate("a", new ArrayList<Integer>()).add("one");

## Plain Java

    Map<String, String> test = new HashMap<String, String>();
    String val = test.get("a");
    if (val == null) throw new RuntimeException("error");

## JFT

    MapF<String, String> test = Containers.hashMap();
    String val = test.getOrThrow("a", new RuntimeException("error"));
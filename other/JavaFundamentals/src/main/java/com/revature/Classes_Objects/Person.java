package com.revature.ClassesObjects;

// The first uncommented line of these java files should be the package name
// Packages provide useful namespaces for us to declare similar classes with the correct name

public class Person {
    /*
    This is a multiline comment

    We talked about classes and objects yesterday and said classes are blueprints for objects, but what does this mean?
    We can create classes as blueprints with all the necessary information we expect EVERY object from that class to get

    First thing I'll create are FIELDS which are similar to properties of the object. We create these just like regular
    variables from yesterday only we don't necessarily have to give them a value.

    Fields we might want for a person class:
    Name --> String
    Height --> Double
    Weight --> Double
    Age --> Integer

    We'll declare these fields or properties at the class level OUTSIDE any method
     */
    String name;

    double height;

    double weight;

    int age;

    /*
    Now everytime I create a person OBJECT they should have all these properties associated with them and depending on how the variable is
    accessible I should be able to call the value by saying something like personObject.field
     */

    // I'm going to create a constructor for this class
    // Constructors are basically special methods with the same name as the class itself and provides a simple way to set the STATE of the object upon creation (instantiation)

    public Person(String name, double height, double weight, int age){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    /*
    Before we go too far I'm going to add onto our constructor notes from before by creating
    additional constructors with varying amounts of arguments. Before we created an all args constructor, but
    what if I just wanted like an average person or only wanted to set some of the values
     */

    // No-args Constructor
    //public Person(){
    //    this.name = "James";
    //}


    /*
    Let's add in some methods.

    If we remember, methods are like reusable chunks of code and they generally represent what an object can DO

    What are some things that people can do?
    Walk
    Talk
     */

    public void walk(int distance){
        System.out.println(this.name + " walked a distance of " + distance + " feet");
    }

    // We'll create a method for talking so someone can introduce themselves

    public String talk(){
        return "Hi, my name is " + this.name;
    }
}

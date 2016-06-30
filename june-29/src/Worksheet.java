public class Worksheet {

}

class Person implements Comparable<Person> {
    private String first, last;
    public Person (String f, String l){

    }

    // default first is Michael, last is Jackson
    public Person(){

    }

    //format: Last, First
    @Override
    public String toString() {

    }

    @Override
    public boolean equals(Object other){

    }

    @Override
    public int compareTo(Person p){

    }
}

class Box implements Comparable<Box> {
    private int length, area, perimeter;

    // use the area() method to assign the area instance variable
    // use the perimeter() method to assign the perimeter instance variable
    public Box (int length) {

    }

    // default length is 0
    public Box() {

    }

    public static int area() {

    }

    public static int perimeter() {

    }

    // format: length: 10, area: 100, parameter: 40
    @Override
    public String toString() {

    }

    @Override
    public boolean equals(Object other){

    }

    @Override
    public int compareTo(Box b){

    }
}

class Music implements Comparable<Music> {
    private String title, artist, album;
    private int year;
    public Music(String title, String artist, String album, int year){

    }
    // by default assign the title to "Barbie Girl", artist to "Aqua", album to Aquarium, year to 1997
    public Music() {

    }

    // format: Title: Oops! I did it again, Artist: Britney Spears, Album: Oops! I did it again, Year: 2000
    @Override
    public String toString() {

    }

    @Override
    public boolean equals(Object other){

    }

    @Override
    public int compareTo(Music m){

    }
}

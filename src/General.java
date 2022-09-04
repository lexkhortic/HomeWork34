public class General {

    public static void main(String[] args) throws InterruptedException {

        Library library = new Library();

        Reader r1 = new Reader("Лёха", library);
        Reader r2 = new Reader("Настя", library);
        Reader r3 = new Reader("Натали", library);
        Reader r4 = new Reader("Серега", library);
        Reader r5 = new Reader("Егор", library);

        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();

//        library.forEach((k, v) -> {
//            System.out.println(k.getNameBook() + " - " + v);
//        });

    }
}

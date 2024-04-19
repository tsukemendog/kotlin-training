package training.chapter1;

public class PersonJava {
    private final String name;

    public PersonJava(String name) {
        this.name = name;
    }

    public String getName() {

        return this.name;
    }

    public void test() {
        Person person = new Person("Hello", true);
        person.getName();
        person.isMarried(); //getter 일 때 이름이 is로 시작하는 프로퍼티는 이름을 그대로 사용함
        person.setMarried(true); //setter 일 때 is로 시작하는 프로퍼티는 is를 set으로 변경
    }
}

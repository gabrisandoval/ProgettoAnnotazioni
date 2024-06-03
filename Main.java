import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        
        Person person=new Person("Mario",28);

        //System.out.println(person.getInfo());

        System.out.println(person.getAge());

        try{
            Method method = Person.class.getMethod("getAge");
            if(method.isAnnotationPresent(DeprecatedCustom.class)){
                DeprecatedCustom annotation = method.getAnnotation(DeprecatedCustom.class);
                System.out.println(annotation.doNotUse());
            }
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }
        try{
        Class<?> personClass = person.getClass();
        if (personClass.isAnnotationPresent(Info.class)) {
            Info info = personClass.getAnnotation(Info.class);
            System.out.println("Autore: " + info.author());
            System.out.println("Versione: " + info.version());
        }}catch(NoClassDefFoundError e2){
            e2.printStackTrace();
        }

        person.serializeXML();

    }
}

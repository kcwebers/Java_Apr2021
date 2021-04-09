public class WeberskiFamilyMember {
    private int age;
    private String name;
    
    // let's count family members as they are generated!
    private static int familyMemberCount = 0;
    // new family members share the same surname, therefore we can make this static
    private static String surname = "Weberski";
    
    public WeberskiFamilyMember(int ageParam, String nameParam) {
        this.age = ageParam;
        this.name = nameParam;
        familyMemberCount++;
    }
    
    public String getMemberInfo() {
        return "Hello! My name is " + this.name + " and I am " + this.age + " years old!";
    }
    
    // static methods to refer to static variables
    public static int getFamilyMemberCount() {
        return familyMemberCount;
    }
    
    public static String getSurname() {
        return surname;
    }
}

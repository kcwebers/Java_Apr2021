public class WeberskiFamilyTree {

	public static void main(String[] args) {
		
        WeberskiFamilyMember spence = new WeberskiFamilyMember(27, "Spencer");
        WeberskiFamilyMember kayce = new WeberskiFamilyMember(27, "Kaysee");
        WeberskiFamilyMember mally = new WeberskiFamilyMember(26, "Mallory");
        WeberskiFamilyMember manda = new WeberskiFamilyMember(29, "Amanda");

        System.out.println(mally.getMemberInfo());
        System.out.println(WeberskiFamilyMember.getSurname());
        
        System.out.println(WeberskiFamilyMember.getFamilyMemberCount());
        System.out.println(WeberskiFamilyMember.getSurname());
	}

}

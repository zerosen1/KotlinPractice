//public class Example {
//
//    public static void main(String[] args) throws Exception {
//
//        BufferedReader br = new BufferedReader(new FileReader("testdbcsv/ACL.csv"));
//        while((var line=br.readLine())!=null){
//            String pattern = "^(\\d+),(\\w+),((\\w+)=(\\w+)),((\\w+)=(\\w+)+?";
//            if(line.matches(pattern)){
//                System.out.println("pattern matched");
//            }
////Code
//        }

//data class Member(var firstName: String? = null, var lastName: String? = null)
//
//fun readCsvFileKotlin2(csvFile:String) {
//    var memberList = mutableListOf<Member>()
//    var reader = File(csvFile).readLines()
//
//    val fprop = Member::firstName
//    val lprop = Member::lastName
//
//    for (line in reader) {
//        val mbrProperties = line.split(",")
//        val member = Member()
//        fprop.set(member, mbrProperties[0])
//        lprop.set(member, mbrProperties[1])
//        memberList.add(member)
//    }
//}
